package mtopsdk.network.impl;

import android.taobao.windvane.connect.HttpConnector;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.network.AbstractCallImpl;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.cookie.CookieManager;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.RequestBody;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;
import mtopsdk.network.util.Constants;
import mtopsdk.network.util.NetworkUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultCallImpl extends AbstractCallImpl {
    private static final String TAG = "mtopsdk.DefaultCallImpl";
    ExecutorService executorService;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class AsyncCallTask implements Runnable {
        NetworkCallback callback;
        Request request;

        public AsyncCallTask(Request request, NetworkCallback networkCallback) {
            this.request = request;
            this.callback = networkCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (((AbstractCallImpl) DefaultCallImpl.this).canceled) {
                    TBSdkLog.d(DefaultCallImpl.TAG, ((AbstractCallImpl) DefaultCallImpl.this).seqNo, "call task is canceled.");
                    this.callback.onCancel(DefaultCallImpl.this);
                    return;
                }
                Response execute = DefaultCallImpl.this.execute();
                if (execute == null) {
                    this.callback.onFailure(DefaultCallImpl.this, new Exception("response is null"));
                } else {
                    this.callback.onResponse(DefaultCallImpl.this, execute);
                }
            } catch (InterruptedException unused) {
                this.callback.onCancel(DefaultCallImpl.this);
            } catch (CancellationException unused2) {
                this.callback.onCancel(DefaultCallImpl.this);
            } catch (Exception e) {
                this.callback.onFailure(DefaultCallImpl.this, e);
                TBSdkLog.e(DefaultCallImpl.TAG, ((AbstractCallImpl) DefaultCallImpl.this).seqNo, "do call.execute failed.", e);
            }
        }
    }

    public DefaultCallImpl(Request request, ExecutorService executorService) {
        super(request, null);
        this.executorService = executorService;
    }

    @Override // mtopsdk.network.Call
    public void enqueue(NetworkCallback networkCallback) {
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            try {
                this.future = executorService.submit(new AsyncCallTask(request(), networkCallback));
                return;
            } catch (Exception e) {
                networkCallback.onFailure(this, e);
                return;
            }
        }
        networkCallback.onFailure(this, new Exception("miss executorService in CallImpl "));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0 A[LOOP:0: B:37:0x0044->B:36:0x00a0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // mtopsdk.network.Call
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public mtopsdk.network.domain.Response execute() throws java.lang.InterruptedException {
        /*
            r9 = this;
            mtopsdk.network.domain.Request r1 = r9.request()
            boolean r0 = mtopsdk.network.AbstractCallImpl.isDebugApk
            r3 = 0
            if (r0 == 0) goto L42
            boolean r0 = mtopsdk.network.AbstractCallImpl.isOpenMock
            if (r0 == 0) goto L42
            java.lang.String r0 = r1.api
            mtopsdk.mtop.domain.MockResponse r0 = r9.getMockResponse(r0)
            if (r0 == 0) goto L42
            int r2 = r0.statusCode
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r0.headers
            byte[] r5 = r0.byteData
            mtopsdk.common.util.TBSdkLog$LogEnable r6 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
            boolean r6 = mtopsdk.common.util.TBSdkLog.isLogEnable(r6)
            if (r6 == 0) goto L3b
            java.lang.String r6 = r9.seqNo
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "[execute]get MockResponse succeed.mockResponse="
            r7.append(r8)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            java.lang.String r7 = "mtopsdk.DefaultCallImpl"
            mtopsdk.common.util.TBSdkLog.i(r7, r6, r0)
        L3b:
            r6 = 0
            r0 = r9
            mtopsdk.network.domain.Response r0 = r0.buildResponse(r1, r2, r3, r4, r5, r6)
            return r0
        L42:
            r0 = 0
            r2 = 0
        L44:
            java.net.HttpURLConnection r4 = r9.openConnection(r1)     // Catch: java.lang.Exception -> L50 java.net.ConnectException -> L59 javax.net.ssl.SSLException -> L62 javax.net.ssl.SSLHandshakeException -> L6b org.apache.http.conn.ConnectTimeoutException -> L74 java.net.SocketTimeoutException -> L7d java.net.UnknownHostException -> L86
            r9.prepareRequest(r4, r1)     // Catch: java.lang.Exception -> L50 java.net.ConnectException -> L59 javax.net.ssl.SSLException -> L62 javax.net.ssl.SSLHandshakeException -> L6b org.apache.http.conn.ConnectTimeoutException -> L74 java.net.SocketTimeoutException -> L7d java.net.UnknownHostException -> L86
            mtopsdk.network.domain.Response r0 = r9.readResponse(r4, r1)     // Catch: java.lang.Exception -> L50 java.net.ConnectException -> L59 javax.net.ssl.SSLException -> L62 javax.net.ssl.SSLHandshakeException -> L6b org.apache.http.conn.ConnectTimeoutException -> L74 java.net.SocketTimeoutException -> L7d java.net.UnknownHostException -> L86
            goto L95
        L50:
            r2 = move-exception
            r3 = -7
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -7
            goto L8e
        L59:
            r2 = move-exception
            r3 = -6
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -6
            goto L8e
        L62:
            r2 = move-exception
            r3 = -5
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -5
            goto L8e
        L6b:
            r2 = move-exception
            r3 = -4
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -4
            goto L8e
        L74:
            r2 = move-exception
            r3 = -3
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -3
            goto L8e
        L7d:
            r2 = move-exception
            r3 = -2
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -2
            goto L8e
        L86:
            r2 = move-exception
            r3 = -1
            java.lang.String r2 = r2.getMessage()
            r3 = r2
            r2 = -1
        L8e:
            int r4 = r0 + 1
            int r5 = r1.retryTimes
            if (r0 < r5) goto La0
            r0 = 0
        L95:
            if (r0 != 0) goto L9f
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r9
            mtopsdk.network.domain.Response r0 = r0.buildResponse(r1, r2, r3, r4, r5, r6)
        L9f:
            return r0
        La0:
            r0 = r4
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.network.impl.DefaultCallImpl.execute():mtopsdk.network.domain.Response");
    }

    @Override // mtopsdk.network.Ext
    public boolean isNoNetworkError(int i) {
        return i == -1 || i == -2 || i == -3;
    }

    HttpURLConnection openConnection(Request request) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.url).openConnection();
        httpURLConnection.setConnectTimeout(request.connectTimeoutMills);
        httpURLConnection.setReadTimeout(request.readTimeoutMills);
        return httpURLConnection;
    }

    void prepareRequest(HttpURLConnection httpURLConnection, Request request) throws IOException {
        httpURLConnection.setRequestMethod(request.method);
        for (Map.Entry<String, String> entry : request.headers.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase(IRequestConst.COOKIE)) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!StringUtils.isBlank(CookieManager.getCookie(request.url))) {
            httpURLConnection.addRequestProperty(IRequestConst.COOKIE, CookieManager.getCookie(request.url));
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            String str = request.seqNo;
            TBSdkLog.i(TAG, str, "request url =" + request.url);
            String str2 = request.seqNo;
            TBSdkLog.i(TAG, str2, "request headers =" + httpURLConnection.getRequestProperties());
        }
        if ("POST".equalsIgnoreCase(request.method)) {
            httpURLConnection.setDoOutput(true);
        }
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", requestBody.contentType());
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                httpURLConnection.addRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(contentLength));
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                try {
                    requestBody.writeTo(outputStream);
                } catch (Exception e) {
                    TBSdkLog.e(TAG, "write outputstream error.", e);
                }
            } finally {
                NetworkUtils.closeQuietly(outputStream);
            }
        }
    }

    Response readResponse(HttpURLConnection httpURLConnection, Request request) throws IOException {
        final InputStream inputStream;
        if (!Thread.currentThread().isInterrupted()) {
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            if (responseMessage == null) {
                responseMessage = "";
            }
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            storeCookies(request.url, headerFields);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                String str = request.seqNo;
                TBSdkLog.i(TAG, str, "response headers:" + headerFields);
            }
            final String contentType = httpURLConnection.getContentType();
            final int contentLength = httpURLConnection.getContentLength();
            boolean checkContentEncodingGZip = NetworkUtils.checkContentEncodingGZip(headerFields);
            if (responseCode >= 400) {
                inputStream = httpURLConnection.getErrorStream();
            } else if (checkContentEncodingGZip) {
                inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            ResponseBody responseBody = new ResponseBody() { // from class: mtopsdk.network.impl.DefaultCallImpl.1
                @Override // mtopsdk.network.domain.ResponseBody
                public InputStream byteStream() {
                    return inputStream;
                }

                @Override // mtopsdk.network.domain.ResponseBody
                public long contentLength() throws IOException {
                    return contentLength;
                }

                @Override // mtopsdk.network.domain.ResponseBody
                public String contentType() {
                    return contentType;
                }
            };
            if (!Thread.currentThread().isInterrupted()) {
                responseBody.getBytes();
                return new Response.Builder().request(request).code(responseCode).message(responseMessage).headers(HeaderHandlerUtil.cloneHeaderMap(headerFields)).body(responseBody).build();
            }
            TBSdkLog.d(TAG, this.seqNo, "[readResponse]call task is canceled.");
            throw new CancellationException("call canceled");
        }
        TBSdkLog.d(TAG, this.seqNo, "[readResponse]call task is canceled.");
        throw new CancellationException("call canceled");
    }

    public void storeCookies(String str, Map<String, List<String>> map) {
        if (str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && (key.equalsIgnoreCase(HttpConnector.SET_COOKIE) || key.equalsIgnoreCase("Set-Cookie2"))) {
                    for (String str2 : entry.getValue()) {
                        CookieManager.setCookie(str, str2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
