package com.amap.api.mapcore.util;

import com.amap.api.services.core.AMapException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ft extends Exception {
    private String a;
    private int b;

    public ft(String str) {
        super(str);
        this.a = "";
        this.b = 1000;
        this.a = str;
        a(str);
    }

    public String a() {
        return this.a;
    }

    private void a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.b = 1001;
        } else if (AMapException.AMAP_INVALID_USER_KEY.equals(str)) {
            this.b = 1002;
        } else if (AMapException.AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            this.b = 1003;
        } else if (AMapException.AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            this.b = 1004;
        } else if (AMapException.AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            this.b = 1005;
        } else if (AMapException.AMAP_INVALID_USER_IP.equals(str)) {
            this.b = 1006;
        } else if (AMapException.AMAP_INVALID_USER_DOMAIN.equals(str)) {
            this.b = 1007;
        } else if (AMapException.AMAP_INVALID_USER_SCODE.equals(str)) {
            this.b = 1008;
        } else if (AMapException.AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            this.b = 1009;
        } else if (AMapException.AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            this.b = 1010;
        } else if (AMapException.AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            this.b = 1011;
        } else if (AMapException.AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            this.b = 1012;
        } else if (AMapException.AMAP_USER_KEY_RECYCLED.equals(str)) {
            this.b = 1013;
        } else if (AMapException.AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            this.b = 1100;
        } else if (AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            this.b = 1101;
        } else if (AMapException.AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            this.b = 1102;
        } else if (AMapException.AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            this.b = 1103;
        } else if (AMapException.AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            this.b = 1200;
        } else if (AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            this.b = 1201;
        } else if (AMapException.AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            this.b = 1202;
        } else if (AMapException.AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            this.b = 1203;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.b = 1801;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.b = AMapException.CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.b = AMapException.CODE_AMAP_CLIENT_URL_EXCEPTION;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.b = AMapException.CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
        } else if (AMapException.AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            this.b = 1900;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.b = 1901;
        } else if (AMapException.AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            this.b = AMapException.CODE_AMAP_CLIENT_NETWORK_EXCEPTION;
        } else if ("IO 操作异常 - IOException".equals(str)) {
            this.b = 1902;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.b = 1903;
        } else {
            this.b = 1800;
        }
    }

    public ft() {
        this.a = "";
        this.b = 1000;
    }
}
