package android.taobao.windvane.connect;

import android.net.Uri;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class HttpRequest {
    public static final String DEFAULT_HTTPS_ERROR_EXPIRED = "EXPIRED";
    public static final String DEFAULT_HTTPS_ERROR_INVALID = "INVALID";
    public static final String DEFAULT_HTTPS_ERROR_NONE = "NONE";
    public static final int DEFAULT_MAX_LENGTH = 5242880;
    public static final int DEFAULT_MAX_REDIRECT_TIMES = 5;
    private byte[] postData;
    private Uri uri;
    private String method = "GET";
    private Map<String, String> headers = null;
    private boolean isRedirect = true;
    private int retryTime = 1;
    private int connectTimeout = 5000;
    private int readTimeout = 5000;
    private String httpsVerifyError = "NONE";

    public HttpRequest(String str) {
        Objects.requireNonNull(str, "HttpRequest init error, url is null.");
        this.uri = Uri.parse(str);
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getHttpsVerifyError() {
        return this.httpsVerifyError;
    }

    public String getMethod() {
        return this.method;
    }

    public byte[] getPostData() {
        return this.postData;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public int getRetryTime() {
        return this.retryTime;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setHttpsVerifyError(String str) {
        this.httpsVerifyError = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setPostData(byte[] bArr) {
        this.postData = bArr;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setRedirect(boolean z) {
        this.isRedirect = z;
    }

    public void setRetryTime(int i) {
        this.retryTime = i;
    }

    public void setUri(Uri uri) {
        if (uri != null) {
            this.uri = uri;
        }
    }
}
