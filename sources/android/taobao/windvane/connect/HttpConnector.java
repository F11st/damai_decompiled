package android.taobao.windvane.connect;

import android.taobao.windvane.WVCookieManager;
import android.taobao.windvane.util.TaoLog;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Objects;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HttpConnector {
    public static final String CACHE_CONTROL = "cache-control";
    public static final String CONTENT_LENGTH = "content-length";
    public static final String CONTENT_TYPE = "content-type";
    public static final String DATE = "date";
    public static final String ETAG = "etag";
    public static final String EXPIRES = "expires";
    public static final String IF_MODIFY_SINCE = "If-Modified-Since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String REDIRECT_LOCATION = "location";
    public static final String RESPONSE_CODE = "response-code";
    public static final String SET_COOKIE = "Set-Cookie";
    private static String TAG = "HttpConnector";
    public static final String URL = "url";
    private int redirectTime = 0;
    private HttpConnectListener<HttpResponse> mListener = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class HttpOverFlowException extends Exception {
        public HttpOverFlowException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class HttpsErrorException extends Exception {
        public HttpsErrorException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class NetWorkErrorException extends Exception {
        public NetWorkErrorException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class RedirectException extends Exception {
        public RedirectException(String str) {
            super(str);
        }
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    /* JADX WARN: Code restructure failed: missing block: B:237:0x03b2, code lost:
        if (r7 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x03f7, code lost:
        if (r7 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x03f9, code lost:
        r7.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x03fc, code lost:
        r2 = r17.mListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x03fe, code lost:
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0400, code lost:
        r2.onFinish(new android.taobao.windvane.connect.HttpResponse(), 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x040d, code lost:
        return new android.taobao.windvane.connect.HttpResponse();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x041d: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:279:0x041c */
    /* JADX WARN: Removed duplicated region for block: B:208:0x034f A[Catch: all -> 0x0445, TryCatch #17 {all -> 0x0445, blocks: (B:206:0x0347, B:208:0x034f, B:209:0x0364, B:210:0x036f, B:283:0x042a, B:285:0x042e, B:286:0x0434, B:290:0x043c, B:292:0x0440, B:293:0x0444), top: B:328:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x037b A[Catch: all -> 0x041b, TryCatch #60 {all -> 0x041b, blocks: (B:214:0x0377, B:216:0x037b, B:217:0x0382, B:242:0x03bc, B:244:0x03c0, B:245:0x03c7, B:273:0x040e), top: B:355:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03c0 A[Catch: all -> 0x041b, TryCatch #60 {all -> 0x041b, blocks: (B:214:0x0377, B:216:0x037b, B:217:0x0382, B:242:0x03bc, B:244:0x03c0, B:245:0x03c7, B:273:0x040e), top: B:355:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x040e A[Catch: all -> 0x040f, TRY_ENTER, TRY_LEAVE, TryCatch #60 {all -> 0x041b, blocks: (B:214:0x0377, B:216:0x037b, B:217:0x0382, B:242:0x03bc, B:244:0x03c0, B:245:0x03c7, B:273:0x040e), top: B:355:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x042e A[Catch: all -> 0x0445, TryCatch #17 {all -> 0x0445, blocks: (B:206:0x0347, B:208:0x034f, B:209:0x0364, B:210:0x036f, B:283:0x042a, B:285:0x042e, B:286:0x0434, B:290:0x043c, B:292:0x0440, B:293:0x0444), top: B:328:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0440 A[Catch: all -> 0x0445, TryCatch #17 {all -> 0x0445, blocks: (B:206:0x0347, B:208:0x034f, B:209:0x0364, B:210:0x036f, B:283:0x042a, B:285:0x042e, B:286:0x0434, B:290:0x043c, B:292:0x0440, B:293:0x0444), top: B:328:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x03a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.taobao.windvane.connect.HttpConnector] */
    /* JADX WARN: Type inference failed for: r18v0, types: [java.util.zip.GZIPInputStream, android.taobao.windvane.connect.HttpRequest] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v31, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.taobao.windvane.connect.HttpResponse dataConnect(android.taobao.windvane.connect.HttpRequest r18) throws android.taobao.windvane.connect.HttpConnector.NetWorkErrorException, android.taobao.windvane.connect.HttpConnector.HttpOverFlowException, android.taobao.windvane.connect.HttpConnector.RedirectException, android.taobao.windvane.connect.HttpConnector.HttpsErrorException {
        /*
            Method dump skipped, instructions count: 1143
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.connect.HttpConnector.dataConnect(android.taobao.windvane.connect.HttpRequest):android.taobao.windvane.connect.HttpResponse");
    }

    private void setConnectProp(HttpURLConnection httpURLConnection, HttpRequest httpRequest) {
        int retryTime = httpRequest.getRetryTime() + 1;
        httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout() * retryTime);
        httpURLConnection.setReadTimeout(httpRequest.getReadTimeout() * retryTime);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty(BizTime.HOST, httpRequest.getUri().getHost());
        httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String cookie = WVCookieManager.getCookie(httpURLConnection.getURL().toString());
        if (cookie != null) {
            httpURLConnection.setRequestProperty(IRequestConst.COOKIE, cookie);
        }
        Map<String, String> headers = httpRequest.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpURLConnection.setUseCaches(false);
    }

    public HttpResponse syncConnect(String str) {
        return syncConnect(new HttpRequest(str), null);
    }

    public HttpResponse syncConnect(HttpRequest httpRequest) {
        return syncConnect(httpRequest, null);
    }

    public HttpResponse syncConnect(HttpRequest httpRequest, HttpConnectListener<HttpResponse> httpConnectListener) {
        Objects.requireNonNull(httpRequest, "Http connect error, request is null");
        String str = null;
        this.mListener = httpConnectListener;
        int i = 0;
        this.redirectTime = 0;
        int retryTime = httpRequest.getRetryTime();
        while (i < retryTime) {
            try {
                return dataConnect(httpRequest);
            } catch (HttpOverFlowException e) {
                e.printStackTrace();
                str = e.toString();
            } catch (HttpsErrorException e2) {
                e2.printStackTrace();
                str = e2.toString();
            } catch (NetWorkErrorException e3) {
                e3.printStackTrace();
                str = e3.toString();
                i++;
                try {
                    Thread.sleep(i * 2 * 1000);
                } catch (InterruptedException unused) {
                    TaoLog.e(TAG, "HttpConnector retry Sleep has been interrupted, go ahead");
                }
            } catch (RedirectException e4) {
                e4.printStackTrace();
                str = e4.toString();
            }
        }
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setErrorMsg(str);
        return httpResponse;
    }
}
