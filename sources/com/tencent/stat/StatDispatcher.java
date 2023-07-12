package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.tencent.stat.common.RC4;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.Event;
import com.youku.live.livesdk.preloader.Preloader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import mtopsdk.network.util.Constants;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatDispatcher {
    DefaultHttpClient client;
    Handler handler;
    private static StatLogger logger = StatCommonHelper.getLogger();
    private static long dispatcherThreadId = -1;
    private static StatDispatcher instance = null;
    private static Context applicationContext = null;

    private StatDispatcher() {
        this.client = null;
        this.handler = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            dispatcherThreadId = handlerThread.getId();
            this.handler = new Handler(handlerThread.getLooper());
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            this.client = defaultHttpClient;
            defaultHttpClient.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() { // from class: com.tencent.stat.StatDispatcher.1
                public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                    long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
                    if (keepAliveDuration == -1) {
                        return 20000L;
                    }
                    return keepAliveDuration;
                }
            });
            if (StatConfig.getStatHttpProxy() != null) {
                this.client.getParams().setParameter("http.route.default-proxy", StatConfig.getStatHttpProxy());
            }
        } catch (Throwable th) {
            logger.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getApplicationContext() {
        return applicationContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StatDispatcher getInstance() {
        if (instance == null) {
            instance = new StatDispatcher();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setApplicationContext(Context context) {
        applicationContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void send(Event event, StatDispatchCallback statDispatchCallback) {
        send(Arrays.asList(event.toJsonString()), statDispatchCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void send(final List<String> list, final StatDispatchCallback statDispatchCallback) {
        Handler handler;
        if (list.isEmpty() || (handler = this.handler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.stat.StatDispatcher.2
            @Override // java.lang.Runnable
            public void run() {
                StatDispatcher.this.sendHttpPost(list, statDispatchCallback);
            }
        });
    }

    void sendHttpPost(List<String> list, StatDispatchCallback statDispatchCallback) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        int i = 0;
        while (true) {
            z = true;
            if (i >= list.size()) {
                break;
            }
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append(jn1.ARRAY_END_STR);
        String statReportUrl = StatConfig.getStatReportUrl();
        StatLogger statLogger = logger;
        statLogger.i(jn1.ARRAY_START_STR + statReportUrl + "]Send request(" + sb.toString().length() + "bytes):" + sb.toString());
        HttpPost httpPost = new HttpPost(statReportUrl);
        try {
            httpPost.addHeader("Accept-Encoding", "gzip");
            httpPost.setHeader(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
            httpPost.removeHeaders("Cache-Control");
            HttpHost httpProxy = StatCommonHelper.getHttpProxy(applicationContext);
            if (httpProxy != null) {
                this.client.getParams().setParameter("http.route.default-proxy", StatCommonHelper.getHttpProxy(applicationContext));
                httpPost.addHeader("X-Online-Host", StatConstants.MTA_SERVER);
                httpPost.addHeader("Accept", "*/*");
                httpPost.addHeader("Content-Type", Preloader.KEY_JSON);
            } else {
                z = false;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = sb.toString().getBytes("UTF-8");
            int length = bytes.length;
            if (sb.length() >= 256) {
                if (httpProxy == null) {
                    httpPost.addHeader(Constants.Protocol.CONTENT_ENCODING, "rc4,gzip");
                } else {
                    httpPost.addHeader("X-Content-Encoding", "rc4,gzip");
                }
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                StatLogger statLogger2 = logger;
                statLogger2.d("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
            } else if (httpProxy == null) {
                httpPost.addHeader(Constants.Protocol.CONTENT_ENCODING, "rc4");
            } else {
                httpPost.addHeader("X-Content-Encoding", "rc4");
            }
            httpPost.setEntity(new ByteArrayEntity(RC4.encrypt(bytes)));
            HttpResponse execute = this.client.execute(httpPost);
            if (z) {
                this.client.getParams().removeParameter("http.route.default-proxy");
            }
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            StatLogger statLogger3 = logger;
            statLogger3.i("recv response status code:" + statusCode + ", content length:" + contentLength);
            int i2 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
            if (i2 == 0) {
                EntityUtils.toString(entity);
                if (statusCode == 200) {
                    if (statDispatchCallback != null) {
                        statDispatchCallback.onDispatchSuccess();
                        return;
                    }
                    return;
                }
                StatLogger statLogger4 = logger;
                statLogger4.error("Server response error code:" + statusCode);
            } else if (i2 <= 0) {
                EntityUtils.toString(entity);
            } else {
                InputStream content = entity.getContent();
                DataInputStream dataInputStream = new DataInputStream(content);
                byte[] bArr = new byte[(int) entity.getContentLength()];
                dataInputStream.readFully(bArr);
                Header firstHeader = execute.getFirstHeader(Constants.Protocol.CONTENT_ENCODING);
                if (firstHeader != null) {
                    if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                        bArr = RC4.decrypt(StatCommonHelper.deocdeGZipContent(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                        bArr = StatCommonHelper.deocdeGZipContent(RC4.decrypt(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                        bArr = StatCommonHelper.deocdeGZipContent(bArr);
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                        bArr = RC4.decrypt(bArr);
                    }
                }
                if (statusCode == 200) {
                    try {
                        logger.d(new String(bArr, "UTF-8"));
                        JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8")).getJSONObject("cfg");
                        if (jSONObject != null) {
                            StatConfig.updateOnlineConfig(jSONObject);
                        }
                    } catch (JSONException e) {
                        logger.i(e.toString());
                    }
                    if (statDispatchCallback != null) {
                        statDispatchCallback.onDispatchSuccess();
                    }
                } else {
                    StatLogger statLogger5 = logger;
                    statLogger5.error("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                }
                content.close();
            }
        } finally {
        }
    }
}
