package org.android.spdy;

import com.youku.live.livesdk.wkit.component.Constants;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import tb.jg1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SpdyRequest {
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    private int connectionTimeoutMs;
    private String domain;
    private Map<String, String> extHead;
    private String host;
    private String method;
    private int port;
    private RequestPriority priority;
    private String proxyIp;
    private int proxyPort;
    private int requestRdTimeoutMs;
    private int requestTimeoutMs;
    private int retryTimes;
    private URL url;

    public SpdyRequest(URL url, String str, int i, String str2, int i2, String str3, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = "";
        this.host = str;
        this.port = i;
        if (str2 != null && i2 != 0) {
            this.proxyIp = str2;
            this.proxyPort = i2;
        }
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    private String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.url.getPath());
        if (this.url.getQuery() != null) {
            sb.append("?");
            sb.append(this.url.getQuery());
        }
        if (this.url.getRef() != null) {
            sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            sb.append(this.url.getRef());
        }
        if (sb.length() == 0) {
            sb.append(r10.DIR);
        }
        return sb.toString();
    }

    public void addHeader(String str, String str2) {
        this.extHead.put(str, str2);
    }

    public void addHeaders(Map<String, String> map) {
        this.extHead.putAll(map);
    }

    public String getAuthority() {
        return this.host + ":" + Integer.toString(this.port) + "/" + this.proxyIp + ":" + this.proxyPort;
    }

    public int getConnectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDomain() {
        return this.domain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap(5);
        hashMap.put(okhttp3.internal.http2.a.TARGET_PATH_UTF8, getPath());
        hashMap.put(okhttp3.internal.http2.a.TARGET_METHOD_UTF8, this.method);
        hashMap.put(":version", "HTTP/1.1");
        hashMap.put(":host", this.url.getAuthority());
        hashMap.put(okhttp3.internal.http2.a.TARGET_SCHEME_UTF8, this.url.getProtocol());
        Map<String, String> map = this.extHead;
        if (map != null && map.size() > 0) {
            hashMap.putAll(this.extHead);
        }
        return hashMap;
    }

    String getHost() {
        return this.host;
    }

    String getMethod() {
        return this.method;
    }

    int getPort() {
        int i = this.port;
        if (i < 0) {
            return 80;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPriority() {
        return this.priority.getPriorityInt();
    }

    String getProxyIp() {
        return this.proxyIp;
    }

    int getProxyPort() {
        return this.proxyPort;
    }

    public int getRequestRdTimeoutMs() {
        return this.requestRdTimeoutMs;
    }

    public int getRequestTimeoutMs() {
        return this.requestTimeoutMs;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    URL getUrl() {
        return this.url;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUrlPath() {
        return this.url.getProtocol() + jg1.SCHEME_SLASH + this.url.getAuthority() + getPath();
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setRequestRdTimeoutMs(int i) {
        if (i >= 0) {
            this.requestRdTimeoutMs = i;
        }
    }

    public SpdyRequest(URL url, String str, int i, String str2, RequestPriority requestPriority) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = "";
        this.host = str;
        this.port = i;
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, RequestPriority requestPriority) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = "";
        this.host = url.getHost();
        int port = url.getPort();
        this.port = port;
        if (port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, RequestPriority requestPriority, int i, int i2) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = "";
        this.host = url.getHost();
        int port = url.getPort();
        this.port = port;
        if (port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url, String str) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = "";
        this.host = url.getHost();
        int port = url.getPort();
        this.port = port;
        if (port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }

    public SpdyRequest(URL url, String str, String str2, int i, String str3, int i2, String str4, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = str;
        this.host = str2;
        this.port = i;
        if (str3 != null && i2 != 0) {
            this.proxyIp = str3;
            this.proxyPort = i2;
        }
        this.method = str4;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    public SpdyRequest(URL url, String str, String str2, int i, String str3, RequestPriority requestPriority) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = str;
        this.host = str2;
        this.port = i;
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, String str2, RequestPriority requestPriority) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = str;
        this.host = url.getHost();
        int port = url.getPort();
        this.port = port;
        if (port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, String str2, RequestPriority requestPriority, int i, int i2) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = str;
        this.host = url.getHost();
        int port = url.getPort();
        this.port = port;
        if (port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url, String str, String str2) {
        this.proxyIp = "0.0.0.0";
        this.proxyPort = 0;
        this.requestTimeoutMs = 0;
        this.requestRdTimeoutMs = 0;
        this.connectionTimeoutMs = 0;
        this.retryTimes = 0;
        this.url = url;
        this.domain = str;
        this.host = url.getHost();
        int port = url.getPort();
        this.port = port;
        if (port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }
}
