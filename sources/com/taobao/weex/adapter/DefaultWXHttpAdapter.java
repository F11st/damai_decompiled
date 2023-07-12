package com.taobao.weex.adapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anet.channel.request.C0193a;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultWXHttpAdapter implements IWXHttpAdapter {
    private static final IEventReporterDelegate DEFAULT_DELEGATE = new NOPEventReportDelegate();
    private ExecutorService mExecutorService;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IEventReporterDelegate {
        void httpExchangeFailed(IOException iOException);

        InputStream interpretResponseStream(@Nullable InputStream inputStream);

        void postConnect();

        void preConnect(HttpURLConnection httpURLConnection, @Nullable String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class NOPEventReportDelegate implements IEventReporterDelegate {
        private NOPEventReportDelegate() {
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public void httpExchangeFailed(IOException iOException) {
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public InputStream interpretResponseStream(@Nullable InputStream inputStream) {
            return inputStream;
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public void postConnect() {
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public void preConnect(HttpURLConnection httpURLConnection, @Nullable String str) {
        }
    }

    private void execute(Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newFixedThreadPool(3);
        }
        this.mExecutorService.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection openConnection(WXRequest wXRequest, IWXHttpAdapter.OnHttpListener onHttpListener) throws IOException {
        HttpURLConnection createConnection = createConnection(new URL(wXRequest.url));
        createConnection.setConnectTimeout(wXRequest.timeoutMs);
        createConnection.setReadTimeout(wXRequest.timeoutMs);
        createConnection.setUseCaches(false);
        createConnection.setDoInput(true);
        Map<String, String> map = wXRequest.paramMap;
        if (map != null) {
            for (String str : map.keySet()) {
                createConnection.addRequestProperty(str, wXRequest.paramMap.get(str));
            }
        }
        if (!"POST".equals(wXRequest.method) && !C0193a.C0196c.PUT.equals(wXRequest.method) && !"PATCH".equals(wXRequest.method)) {
            if (!TextUtils.isEmpty(wXRequest.method)) {
                createConnection.setRequestMethod(wXRequest.method);
            } else {
                createConnection.setRequestMethod("GET");
            }
        } else {
            createConnection.setRequestMethod(wXRequest.method);
            if (wXRequest.body != null) {
                if (onHttpListener != null) {
                    onHttpListener.onHttpUploadProgress(0);
                }
                createConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(createConnection.getOutputStream());
                dataOutputStream.write(wXRequest.body.getBytes());
                dataOutputStream.close();
                if (onHttpListener != null) {
                    onHttpListener.onHttpUploadProgress(100);
                }
            }
        }
        return createConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readInputStream(InputStream inputStream, IWXHttpAdapter.OnHttpListener onHttpListener) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        char[] cArr = new char[2048];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
                if (onHttpListener != null) {
                    onHttpListener.onHttpResponseProgress(sb.length());
                }
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] readInputStreamAsBytes(InputStream inputStream, IWXHttpAdapter.OnHttpListener onHttpListener) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                i += read;
                if (onHttpListener != null) {
                    onHttpListener.onHttpResponseProgress(i);
                }
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    protected HttpURLConnection createConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @NonNull
    public IEventReporterDelegate getEventReporterDelegate() {
        return DEFAULT_DELEGATE;
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter
    public void sendRequest(final WXRequest wXRequest, final IWXHttpAdapter.OnHttpListener onHttpListener) {
        if (onHttpListener != null) {
            onHttpListener.onHttpStart();
        }
        execute(new Runnable() { // from class: com.taobao.weex.adapter.DefaultWXHttpAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                WXSDKInstance wXSDKInstance = WXSDKManager.v().i().get(wXRequest.instanceId);
                if (wXSDKInstance != null && !wXSDKInstance.isDestroy()) {
                    wXSDKInstance.getApmForInstance().c();
                }
                boolean z = true;
                WXResponse wXResponse = new WXResponse();
                IEventReporterDelegate eventReporterDelegate = DefaultWXHttpAdapter.this.getEventReporterDelegate();
                boolean z2 = false;
                try {
                    HttpURLConnection openConnection = DefaultWXHttpAdapter.this.openConnection(wXRequest, onHttpListener);
                    eventReporterDelegate.preConnect(openConnection, wXRequest.body);
                    Map<String, List<String>> headerFields = openConnection.getHeaderFields();
                    int responseCode = openConnection.getResponseCode();
                    IWXHttpAdapter.OnHttpListener onHttpListener2 = onHttpListener;
                    if (onHttpListener2 != null) {
                        onHttpListener2.onHeadersReceived(responseCode, headerFields);
                    }
                    eventReporterDelegate.postConnect();
                    wXResponse.statusCode = String.valueOf(responseCode);
                    if (responseCode < 200 || responseCode > 299) {
                        wXResponse.errorMsg = DefaultWXHttpAdapter.this.readInputStream(openConnection.getErrorStream(), onHttpListener);
                        z = false;
                    } else {
                        wXResponse.originalData = DefaultWXHttpAdapter.this.readInputStreamAsBytes(eventReporterDelegate.interpretResponseStream(openConnection.getInputStream()), onHttpListener);
                    }
                    IWXHttpAdapter.OnHttpListener onHttpListener3 = onHttpListener;
                    if (onHttpListener3 != null) {
                        onHttpListener3.onHttpFinish(wXResponse);
                    }
                    z2 = z;
                } catch (IOException | IllegalArgumentException e) {
                    e.printStackTrace();
                    wXResponse.statusCode = "-1";
                    wXResponse.errorCode = "-1";
                    wXResponse.errorMsg = e.getMessage();
                    IWXHttpAdapter.OnHttpListener onHttpListener4 = onHttpListener;
                    if (onHttpListener4 != null) {
                        onHttpListener4.onHttpFinish(wXResponse);
                    }
                    if (e instanceof IOException) {
                        try {
                            eventReporterDelegate.httpExchangeFailed((IOException) e);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (wXSDKInstance == null || wXSDKInstance.isDestroy()) {
                    return;
                }
                wXSDKInstance.getApmForInstance().d(z2, null);
            }
        });
    }
}
