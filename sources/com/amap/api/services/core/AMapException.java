package com.amap.api.services.core;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapException extends Exception {
    public static final String AMAP_ACCESS_TOO_FREQUENT = "用户访问过于频繁";
    public static final String AMAP_CLIENT_ERRORCODE_MISSSING = "没有对应的错误";
    public static final String AMAP_CLIENT_ERRORCODE_MISSSING_TPPE = "AMAP_CLIENT_ERRORCODE_MISSSING";
    public static final String AMAP_CLIENT_ERROR_PROTOCOL = "协议解析错误 - ProtocolException";
    public static final String AMAP_CLIENT_INVALID_PARAMETER = "无效的参数 - IllegalArgumentException";
    public static final String AMAP_CLIENT_IO_EXCEPTION = "IO 操作异常 - IOException";
    public static final String AMAP_CLIENT_NEARBY_NULL_RESULT = "NearbyInfo对象为空";
    public static final String AMAP_CLIENT_NETWORK_EXCEPTION = "http或socket连接失败 - ConnectionException";
    public static final String AMAP_CLIENT_NULLPOINT_EXCEPTION = "空指针异常 - NullPointException";
    public static final String AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION = "关键字过长";
    public static final String AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION = "避让区域点个数超限";
    public static final String AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION = "避让区域大小超限";
    public static final String AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION = "避让区域个数超限";
    public static final String AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION = "途经点个数超限";
    public static final String AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION = "socket 连接超时 - SocketTimeoutException";
    public static final String AMAP_CLIENT_UNKNOWHOST_EXCEPTION = "未知主机 - UnKnowHostException";
    public static final String AMAP_CLIENT_UNKNOWN_ERROR = "未知错误";
    public static final String AMAP_CLIENT_UNKNOWN_ERROR_TYPE = "CLIENT_UNKNOWN_ERROR";
    public static final String AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR = "已开启自动上传";
    public static final String AMAP_CLIENT_UPLOAD_LOCATION_ERROR = "Point为空，或与前次上传的相同";
    public static final String AMAP_CLIENT_UPLOAD_TOO_FREQUENT = "两次单次上传的间隔低于7秒";
    public static final String AMAP_CLIENT_URL_EXCEPTION = "url异常 - MalformedURLException";
    public static final String AMAP_CLIENT_USERID_ILLEGAL = "USERID非法";
    public static final String AMAP_DAILY_QUERY_OVER_LIMIT = "访问已超出日访问量";
    public static final String AMAP_ENGINE_CONNECT_TIMEOUT = "服务端请求链接超时";
    public static final String AMAP_ENGINE_RESPONSE_DATA_ERROR = "引擎返回数据异常";
    public static final String AMAP_ENGINE_RESPONSE_ERROR = "请求服务响应错误";
    public static final String AMAP_ENGINE_RETURN_TIMEOUT = "读取服务结果超时";
    public static final String AMAP_ENGINE_TABLEID_NOT_EXIST = "key对应的tableID不存在";
    public static final int AMAP_ERROR_CORE = 1;
    public static final int AMAP_ERROR_LOCAL = 0;
    public static final int AMAP_ERROR_LOCAL_STANDARDIZED = 4;
    public static final int AMAP_ERROR_REST = 2;
    public static final String AMAP_ID_NOT_EXIST = "ID不存在";
    public static final String AMAP_INSUFFICIENT_PRIVILEGES = "权限不足，服务请求被拒绝";
    public static final String AMAP_INVALID_USER_DOMAIN = "用户域名无效";
    public static final String AMAP_INVALID_USER_IP = "用户IP无效";
    public static final String AMAP_INVALID_USER_KEY = "用户key不正确或过期";
    public static final String AMAP_INVALID_USER_SCODE = "用户MD5安全码未通过";
    public static final String AMAP_IP_QUERY_OVER_LIMIT = "IP访问超限";
    public static final String AMAP_NEARBY_INVALID_USERID = "找不到对应的userid信息,请检查您提供的userid是否存在";
    public static final String AMAP_NEARBY_KEY_NOT_BIND = "App key未开通“附近”功能,请注册附近KEY";
    public static final String AMAP_NOT_SUPPORT_HTTPS = "服务不支持https请求";
    public static final String AMAP_OVER_DIRECTION_RANGE = "起点终点距离过长";
    public static final String AMAP_ROUTE_FAIL = "路线计算失败，通常是由于道路连通关系导致";
    public static final String AMAP_ROUTE_NO_ROADS_NEARBY = "规划点（起点、终点、途经点）附近搜不到路";
    public static final String AMAP_ROUTE_OUT_OF_SERVICE = "规划点（包括起点、终点、途经点）不在中国陆地范围内";
    public static final String AMAP_SERVICE_ILLEGAL_REQUEST = "请求协议非法";
    public static final String AMAP_SERVICE_INVALID_PARAMS = "请求参数非法";
    public static final String AMAP_SERVICE_MAINTENANCE = "服务器维护中";
    public static final String AMAP_SERVICE_MISSING_REQUIRED_PARAMS = "缺少必填参数";
    public static final String AMAP_SERVICE_NOT_AVAILBALE = "请求服务不存在";
    public static final String AMAP_SERVICE_TABLEID_NOT_EXIST = "tableID格式不正确不存在";
    public static final String AMAP_SERVICE_UNKNOWN_ERROR = "其他未知错误";
    public static final String AMAP_SHARE_FAILURE = "短串请求失败";
    public static final String AMAP_SHARE_LICENSE_IS_EXPIRED = "短串分享认证失败";
    public static final String AMAP_SHARE_SIGNATURE_FAILURE = "用户签名未通过";
    public static final String AMAP_SIGNATURE_ERROR = "用户签名未通过";
    public static final String AMAP_USERKEY_PLAT_NOMATCH = "请求key与绑定平台不符";
    public static final String AMAP_USER_KEY_RECYCLED = "开发者删除了key，key被删除后无法正常使用";
    public static final int CODE_AMAP_ACCESS_TOO_FREQUENT = 1005;
    public static final int CODE_AMAP_CLIENT_ERRORCODE_MISSSING = 1800;
    public static final int CODE_AMAP_CLIENT_ERROR_PROTOCOL = 1801;
    public static final int CODE_AMAP_CLIENT_INVALID_PARAMETER = 1901;
    public static final int CODE_AMAP_CLIENT_IO_EXCEPTION = 1902;
    public static final int CODE_AMAP_CLIENT_NEARBY_NULL_RESULT = 2202;
    public static final int CODE_AMAP_CLIENT_NETWORK_EXCEPTION = 1806;
    public static final int CODE_AMAP_CLIENT_NULLPOINT_EXCEPTION = 1903;
    public static final int CODE_AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION = 1813;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION = 1812;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION = 1811;
    public static final int CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION = 1810;
    public static final int CODE_AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION = 1809;
    public static final int CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION = 1802;
    public static final int CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION = 1804;
    public static final int CODE_AMAP_CLIENT_UNKNOWN_ERROR = 1900;
    public static final int CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR = 2200;
    public static final int CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR = 2204;
    public static final int CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT = 2203;
    public static final int CODE_AMAP_CLIENT_URL_EXCEPTION = 1803;
    public static final int CODE_AMAP_CLIENT_USERID_ILLEGAL = 2201;
    public static final int CODE_AMAP_DAILY_QUERY_OVER_LIMIT = 1004;
    public static final int CODE_AMAP_ENGINE_CONNECT_TIMEOUT = 1102;
    public static final int CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR = 1101;
    public static final int CODE_AMAP_ENGINE_RESPONSE_ERROR = 1100;
    public static final int CODE_AMAP_ENGINE_RETURN_TIMEOUT = 1103;
    public static final int CODE_AMAP_ENGINE_TABLEID_NOT_EXIST = 2003;
    public static final int CODE_AMAP_ID_NOT_EXIST = 2001;
    public static final int CODE_AMAP_INSUFFICIENT_PRIVILEGES = 1012;
    public static final int CODE_AMAP_INVALID_USER_DOMAIN = 1007;
    public static final int CODE_AMAP_INVALID_USER_IP = 1006;
    public static final int CODE_AMAP_INVALID_USER_KEY = 1002;
    public static final int CODE_AMAP_INVALID_USER_SCODE = 1008;
    public static final int CODE_AMAP_IP_QUERY_OVER_LIMIT = 1010;
    public static final int CODE_AMAP_NEARBY_INVALID_USERID = 2100;
    public static final int CODE_AMAP_NEARBY_KEY_NOT_BIND = 2101;
    public static final int CODE_AMAP_NOT_SUPPORT_HTTPS = 1011;
    public static final int CODE_AMAP_OVER_DIRECTION_RANGE = 3003;
    public static final int CODE_AMAP_ROUTE_FAIL = 3002;
    public static final int CODE_AMAP_ROUTE_NO_ROADS_NEARBY = 3001;
    public static final int CODE_AMAP_ROUTE_OUT_OF_SERVICE = 3000;
    public static final int CODE_AMAP_SERVICE_ILLEGAL_REQUEST = 1202;
    public static final int CODE_AMAP_SERVICE_INVALID_PARAMS = 1200;
    public static final int CODE_AMAP_SERVICE_MAINTENANCE = 2002;
    public static final int CODE_AMAP_SERVICE_MISSING_REQUIRED_PARAMS = 1201;
    public static final int CODE_AMAP_SERVICE_NOT_AVAILBALE = 1003;
    public static final int CODE_AMAP_SERVICE_TABLEID_NOT_EXIST = 2000;
    public static final int CODE_AMAP_SERVICE_UNKNOWN_ERROR = 1203;
    public static final int CODE_AMAP_SHARE_FAILURE = 4001;
    public static final int CODE_AMAP_SHARE_LICENSE_IS_EXPIRED = 4000;
    public static final int CODE_AMAP_SHARE_SIGNATURE_FAILURE = 4002;
    public static final int CODE_AMAP_SIGNATURE_ERROR = 1001;
    public static final int CODE_AMAP_SUCCESS = 1000;
    public static final int CODE_AMAP_USERKEY_PLAT_NOMATCH = 1009;
    public static final int CODE_AMAP_USER_KEY_RECYCLED = 1013;
    private int a;
    private String b;
    private String c;
    private int d;

    public AMapException(String str) {
        super(str);
        this.a = 0;
        this.b = null;
        this.c = "";
        this.d = 1000;
        this.c = str;
        this.a = 0;
        a(str);
    }

    private void a(String str) {
        if ("用户签名未通过".equals(str)) {
            this.d = 1001;
        } else if (AMAP_INVALID_USER_KEY.equals(str)) {
            this.d = 1002;
        } else if (AMAP_SERVICE_NOT_AVAILBALE.equals(str)) {
            this.d = 1003;
        } else if (AMAP_DAILY_QUERY_OVER_LIMIT.equals(str)) {
            this.d = 1004;
        } else if (AMAP_ACCESS_TOO_FREQUENT.equals(str)) {
            this.d = 1005;
        } else if (AMAP_INVALID_USER_IP.equals(str)) {
            this.d = 1006;
        } else if (AMAP_INVALID_USER_DOMAIN.equals(str)) {
            this.d = 1007;
        } else if (AMAP_INVALID_USER_SCODE.equals(str)) {
            this.d = 1008;
        } else if (AMAP_USERKEY_PLAT_NOMATCH.equals(str)) {
            this.d = 1009;
        } else if (AMAP_IP_QUERY_OVER_LIMIT.equals(str)) {
            this.d = 1010;
        } else if (AMAP_NOT_SUPPORT_HTTPS.equals(str)) {
            this.d = 1011;
        } else if (AMAP_INSUFFICIENT_PRIVILEGES.equals(str)) {
            this.d = 1012;
        } else if (AMAP_USER_KEY_RECYCLED.equals(str)) {
            this.d = 1013;
        } else if (AMAP_ENGINE_RESPONSE_ERROR.equals(str)) {
            this.d = 1100;
        } else if (AMAP_ENGINE_RESPONSE_DATA_ERROR.equals(str)) {
            this.d = 1101;
        } else if (AMAP_ENGINE_CONNECT_TIMEOUT.equals(str)) {
            this.d = 1102;
        } else if (AMAP_ENGINE_RETURN_TIMEOUT.equals(str)) {
            this.d = 1103;
        } else if (AMAP_SERVICE_INVALID_PARAMS.equals(str)) {
            this.d = 1200;
        } else if (AMAP_SERVICE_MISSING_REQUIRED_PARAMS.equals(str)) {
            this.d = 1201;
        } else if (AMAP_SERVICE_ILLEGAL_REQUEST.equals(str)) {
            this.d = 1202;
        } else if (AMAP_SERVICE_UNKNOWN_ERROR.equals(str)) {
            this.d = 1203;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.d = 1801;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.d = CODE_AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.d = CODE_AMAP_CLIENT_URL_EXCEPTION;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.d = CODE_AMAP_CLIENT_UNKNOWHOST_EXCEPTION;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.d = 1901;
        } else if (AMAP_CLIENT_NETWORK_EXCEPTION.equals(str)) {
            this.d = CODE_AMAP_CLIENT_NETWORK_EXCEPTION;
        } else if ("IO 操作异常 - IOException".equals(str)) {
            this.d = 1902;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.d = 1903;
        } else if (AMAP_SERVICE_TABLEID_NOT_EXIST.equals(str)) {
            this.d = 2000;
        } else if (AMAP_ID_NOT_EXIST.equals(str)) {
            this.d = 2001;
        } else if (AMAP_SERVICE_MAINTENANCE.equals(str)) {
            this.d = 2002;
        } else if (AMAP_ENGINE_TABLEID_NOT_EXIST.equals(str)) {
            this.d = 2003;
        } else if (AMAP_NEARBY_INVALID_USERID.equals(str)) {
            this.d = 2100;
        } else if (AMAP_NEARBY_KEY_NOT_BIND.equals(str)) {
            this.d = 2101;
        } else if (AMAP_ROUTE_OUT_OF_SERVICE.equals(str)) {
            this.d = 3000;
        } else if (AMAP_ROUTE_NO_ROADS_NEARBY.equals(str)) {
            this.d = 3001;
        } else if (AMAP_ROUTE_FAIL.equals(str)) {
            this.d = 3002;
        } else if (AMAP_OVER_DIRECTION_RANGE.equals(str)) {
            this.d = 3003;
        } else if (AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR.equals(str)) {
            this.d = 2200;
        } else if (AMAP_CLIENT_USERID_ILLEGAL.equals(str)) {
            this.d = 2201;
        } else if (AMAP_CLIENT_NEARBY_NULL_RESULT.equals(str)) {
            this.d = 2202;
        } else if (AMAP_CLIENT_UPLOAD_TOO_FREQUENT.equals(str)) {
            this.d = 2203;
        } else if (AMAP_CLIENT_UPLOAD_LOCATION_ERROR.equals(str)) {
            this.d = 2204;
        } else if (AMAP_SHARE_LICENSE_IS_EXPIRED.equals(str)) {
            this.d = 4000;
        } else if (AMAP_SHARE_FAILURE.equals(str)) {
            this.d = 4001;
        } else if ("用户签名未通过".equals(str)) {
            this.d = 4002;
        } else if (AMAP_CLIENT_UNKNOWN_ERROR.equals(str)) {
            this.d = 1900;
            this.b = AMAP_CLIENT_UNKNOWN_ERROR_TYPE;
        } else if (AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION.equals(str)) {
            this.d = CODE_AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION;
        } else if (AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION.equals(str)) {
            this.d = CODE_AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION;
        } else if (AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION.equals(str)) {
            this.d = CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION;
        } else if (AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION.equals(str)) {
            this.d = CODE_AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION;
        } else if (AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION.equals(str)) {
            this.d = CODE_AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION;
        } else {
            this.d = 1800;
            this.b = AMAP_CLIENT_ERRORCODE_MISSSING_TPPE;
        }
    }

    public int getErrorCode() {
        return this.d;
    }

    public int getErrorLevel() {
        return this.a;
    }

    public String getErrorMessage() {
        return this.c;
    }

    public String getErrorType() {
        return this.b;
    }

    public AMapException(String str, int i, String str2) {
        super(str);
        this.a = 0;
        this.b = null;
        this.c = "";
        this.d = 1000;
        this.c = str;
        this.a = i;
        this.b = str2;
        a(str);
    }

    public AMapException(String str, int i, String str2, int i2) {
        this(str);
        this.c = str;
        this.a = i;
        this.b = str2;
        this.d = i2;
    }

    public AMapException() {
        this.a = 0;
        this.b = null;
        this.c = "";
        this.d = 1000;
    }
}
