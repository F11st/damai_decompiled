package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gb extends Exception {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;

    public gb(String str) {
        super(str);
        this.a = AMapException.ERROR_UNKNOWN;
        this.b = "";
        this.c = "";
        this.d = "1900";
        this.e = "UnknownError";
        this.f = -1;
        this.a = str;
        a(str);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public void a(int i) {
        this.f = i;
    }

    private void a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f = 21;
            this.d = "1902";
            this.e = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f = 23;
            this.d = "1802";
            this.e = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f = 24;
            this.d = "1901";
            this.e = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f = 25;
            this.d = "1903";
            this.e = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f = 26;
            this.d = "1803";
            this.e = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f = 27;
            this.d = "1804";
            this.e = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f = 28;
            this.d = "1805";
            this.e = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f = 29;
            this.d = "1801";
            this.e = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f = 30;
            this.d = "1806";
            this.e = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f = 32;
        } else if ("requeust is null".equals(str)) {
            this.f = 1;
        } else if ("request url is empty".equals(str)) {
            this.f = 2;
        } else if ("response is null".equals(str)) {
            this.f = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f = 7;
        } else if ("线程池为空".equals(str)) {
            this.f = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f = 101;
        } else {
            this.f = -1;
        }
    }

    public gb(String str, String str2, String str3) {
        this(str);
        this.b = str2;
        this.c = str3;
    }
}
