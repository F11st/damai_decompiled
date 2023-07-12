package mtopsdk.mtop.util;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import mtopsdk.common.util.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ErrorConstant {
    public static final String ERRCODE_ANDROID_SYS_LOGIN_CANCEL = "ANDROID_SYS_LOGIN_CANCEL";
    public static final String ERRCODE_ANDROID_SYS_LOGIN_FAIL = "ANDROID_SYS_LOGIN_FAIL";
    public static final String ERRCODE_API_41X_ANTI_ATTACK = "ANDROID_SYS_API_41X_ANTI_ATTACK";
    public static final String ERRCODE_API_FLOW_LIMIT_LOCKED = "ANDROID_SYS_API_FLOW_LIMIT_LOCKED";
    public static final String ERRCODE_BUILD_PROTOCOL_PARAMS_ERROR = "ANDROID_SYS_BUILD_PROTOCOL_PARAMS_ERROR";
    public static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED = "FAIL_SYS_ACCESS_TOKEN_EXPIRED";
    private static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT = "FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT";
    private static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID = "FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID";
    private static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE = "FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE";
    private static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT = "FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT";
    private static final String ERRCODE_FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR = "FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR";
    private static final String ERRCODE_FAIL_SYS_API_NOT_FOUNDED = "FAIL_SYS_API_NOT_FOUNDED";
    private static final String ERRCODE_FAIL_SYS_API_STOP_SERVICE = "FAIL_SYS_API_STOP_SERVICE";
    private static final String ERRCODE_FAIL_SYS_API_UNAUTHORIZED = "FAIL_SYS_API_UNAUTHORIZED";
    private static final String ERRCODE_FAIL_SYS_BADARGUMENT_T = "FAIL_SYS_BADARGUMENT_T";
    private static final String ERRCODE_FAIL_SYS_BIZPARAM_MISSED = "FAIL_SYS_BIZPARAM_MISSED";
    private static final String ERRCODE_FAIL_SYS_BIZPARAM_TYPE_ERROR = "FAIL_SYS_BIZPARAM_TYPE_ERROR";
    private static final String ERRCODE_FAIL_SYS_EXPIRED_REQUEST = "FAIL_SYS_EXPIRED_REQUEST";
    private static final String ERRCODE_FAIL_SYS_FLOWLIMIT = "FAIL_SYS_FLOWLIMIT";
    private static final String ERRCODE_FAIL_SYS_HSF_THROWN_EXCEPTION = "FAIL_SYS_HSF_THROWN_EXCEPTION";
    private static final String ERRCODE_FAIL_SYS_HTTP_CONNECT_TIMEOUT = "FAIL_SYS_HTTP_CONNECT_TIMEOUT";
    private static final String ERRCODE_FAIL_SYS_HTTP_INVOKE_ERROR = "FAIL_SYS_HTTP_INVOKE_ERROR";
    private static final String ERRCODE_FAIL_SYS_HTTP_QUERYIP_ERROR = "FAIL_SYS_HTTP_QUERYIP_ERROR";
    private static final String ERRCODE_FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED = "FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED";
    private static final String ERRCODE_FAIL_SYS_HTTP_RESPONSE_TIMEOUT = "FAIL_SYS_HTTP_RESPONSE_TIMEOUT";
    private static final String ERRCODE_FAIL_SYS_HTTP_RESULT_FIELDMISSED = "FAIL_SYS_HTTP_RESULT_FIELDMISSED";
    private static final String ERRCODE_FAIL_SYS_ILEGEL_SIGN = "FAIL_SYS_ILEGEL_SIGN";
    public static final String ERRCODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN = "FAIL_SYS_ILLEGAL_ACCESS_TOKEN";
    private static final String ERRCODE_FAIL_SYS_ILLEGAL_ARGUMENT_TTID = "FAIL_SYS_ILLEGAL_ARGUMENT_TTID";
    private static final String ERRCODE_FAIL_SYS_INTERNAL_FAULT = "FAIL_SYS_INTERNAL_FAULT";
    private static final String ERRCODE_FAIL_SYS_INVALID_HTTP_METHOD = "FAIL_SYS_INVALID_HTTP_METHOD";
    private static final String ERRCODE_FAIL_SYS_INVALID_PROTOCOLVERSION = "FAIL_SYS_INVALID_PROTOCOLVERSION";
    private static final String ERRCODE_FAIL_SYS_MT_ODD_REQUEST = "FAIL_SYS_MT_ODD_REQUEST";
    private static final String ERRCODE_FAIL_SYS_PARAMINVALID_ERROR = "FAIL_SYS_PARAMINVALID_ERROR";
    private static final String ERRCODE_FAIL_SYS_PARAM_FORMAT_ERROR = "FAIL_SYS_PARAM_FORMAT_ERROR";
    private static final String ERRCODE_FAIL_SYS_PARAM_MISSING = "FAIL_SYS_PARAM_MISSING";
    private static final String ERRCODE_FAIL_SYS_PORTOCOLPARAM_INVALID = "FAIL_SYS_PORTOCOLPARAM_INVALID";
    private static final String ERRCODE_FAIL_SYS_PROTOPARAM_MISSED = "FAIL_SYS_PROTOPARAM_MISSED";
    private static final String ERRCODE_FAIL_SYS_PROTOVER_MISSED = "FAIL_SYS_PROTOVER_MISSED";
    private static final String ERRCODE_FAIL_SYS_REQUEST_EXPIRED = "FAIL_SYS_REQUEST_EXPIRED";
    public static final String ERRCODE_FAIL_SYS_REQUEST_QUEUED = "FAIL_SYS_REQUEST_QUEUED";
    private static final String ERRCODE_FAIL_SYS_RETMISSED_ERROR = "FAIL_SYS_RETMISSED_ERROR";
    private static final String ERRCODE_FAIL_SYS_SERVICE_FAULT = "FAIL_SYS_SERVICE_FAULT";
    private static final String ERRCODE_FAIL_SYS_SERVICE_INNER_FAULT = "FAIL_SYS_SERVICE_INNER_FAULT";
    private static final String ERRCODE_FAIL_SYS_SERVICE_NOT_EXIST = "FAIL_SYS_SERVICE_NOT_EXIST";
    private static final String ERRCODE_FAIL_SYS_SERVICE_TIMEOUT = "FAIL_SYS_SERVICE_TIMEOUT";
    private static final String ERRCODE_FAIL_SYS_SERVLET_ASYNC_START_FAIL = "FAIL_SYS_SERVLET_ASYNC_START_FAIL";
    private static final String ERRCODE_FAIL_SYS_SESSION_ERROR = "FAIL_SYS_SESSION_ERROR";
    public static final String ERRCODE_FAIL_SYS_SESSION_EXPIRED = "FAIL_SYS_SESSION_EXPIRED";
    private static final String ERRCODE_FAIL_SYS_SM_ODD_REQUEST = "FAIL_SYS_SM_ODD_REQUEST";
    private static final String ERRCODE_FAIL_SYS_SYSTEM_BUSY_ERROR = "FAIL_SYS_SYSTEM_BUSY_ERROR";
    private static final String ERRCODE_FAIL_SYS_TOPAUTHPARAM_MISSED = "FAIL_SYS_TOPAUTHPARAM_MISSED";
    private static final String ERRCODE_FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR = "FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR";
    private static final String ERRCODE_FAIL_SYS_TOPAUTH_FAILED = "FAIL_SYS_TOPAUTH_FAILED";
    private static final String ERRCODE_FAIL_SYS_TOPAUTH_FAULT = "FAIL_SYS_TOPAUTH_FAULT";
    private static final String ERRCODE_FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR = "FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR";
    private static final String ERRCODE_FAIL_SYS_TOPUNAUTHAPI_ERROR = "FAIL_SYS_TOPUNAUTHAPI_ERROR";
    private static final String ERRCODE_FAIL_SYS_TRAFFIC_LIMIT = "FAIL_SYS_TRAFFIC_LIMIT";
    private static final String ERRCODE_FAIL_SYS_UNAUTHORIZED_ENTRANCE = "FAIL_SYS_UNAUTHORIZED_ENTRANCE";
    private static final String ERRCODE_FAIL_SYS_UNKNOWN_APP = "FAIL_SYS_UNKNOWN_APP";
    public static final String ERRCODE_GENERATE_MTOP_SIGN_ERROR = "ANDROID_SYS_GENERATE_MTOP_SIGN_ERROR";
    public static final String ERRCODE_ILLEGAL_JSPARAM_ERROR = "ANDROID_SYS_ILLEGAL_JSPARAM_ERROR";
    public static final String ERRCODE_INIT_MTOP_ISIGN_ERROR = "ANDROID_SYS_INIT_MTOP_ISIGN_ERROR";
    public static final String ERRCODE_JSONDATA_BLANK = "ANDROID_SYS_JSONDATA_BLANK";
    public static final String ERRCODE_JSONDATA_PARSE_ERROR = "ANDROID_SYS_JSONDATA_PARSE_ERROR";
    public static final String ERRCODE_MTOPCONTEXT_INIT_ERROR = "ANDROID_SYS_MTOPCONTEXT_INIT_ERROR";
    public static final String ERRCODE_MTOPSDK_INIT_ERROR = "ANDROID_SYS_MTOPSDK_INIT_ERROR";
    public static final String ERRCODE_MTOP_APICALL_ASYNC_TIMEOUT = "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT";
    public static final String ERRCODE_MTOP_MISS_CALL_FACTORY = "ANDROID_SYS_MTOP_MISS_CALL_FACTORY";
    public static final String ERRCODE_NETWORK_ERROR = "ANDROID_SYS_NETWORK_ERROR";
    public static final String ERRCODE_NETWORK_REQUEST_CONVERT_ERROR = "ANDROID_SYS_NETWORK_REQUEST_CONVERT_ERROR";
    public static final String ERRCODE_NO_NETWORK = "ANDROID_SYS_NO_NETWORK";
    public static final String ERRCODE_PARSE_JSPARAM_ERROR = "ANDROID_SYS_PARSE_JSPARAM_ERROR";
    public static final String ERRCODE_SUCCESS = "SUCCESS";
    @Deprecated
    public static final String ERRCODE_SYSTEM_ERROR = "SYSTEM_ERROR";
    private static final String ERRCODE_UNKNOWN_FAIL_CODE = "UNKNOWN_FAIL_CODE";
    public static final String ERRMSG_ANDROID_SYS_LOGIN_CANCEL = "登录被取消";
    public static final String ERRMSG_ANDROID_SYS_LOGIN_FAIL = "登录失败";
    public static final String ERRMSG_API_41X_ANTI_ATTACK = "哎哟喂,被挤爆啦,请稍后重试(419)!";
    public static final String ERRMSG_API_FLOW_LIMIT_LOCKED = "哎哟喂,被挤爆啦,请稍后重试(420)";
    public static final String ERRMSG_BUILD_PROTOCOL_PARAMS_ERROR = "组装MTOP协议参数错误";
    public static final String ERRMSG_FAIL_SYS_SESSION_EXPIRED = "Session过期";
    public static final String ERRMSG_GENERATE_MTOP_SIGN_ERROR = "生成Mtop签名sign失败";
    public static final String ERRMSG_ILLEGAL_JSPARAM_ERROR = "MTOP JSBridge 参数错误";
    public static final String ERRMSG_INIT_MTOP_ISIGN_ERROR = "初始化Mtop签名类ISign失败";
    public static final String ERRMSG_JSONDATA_BLANK = "返回JSONDATA为空";
    public static final String ERRMSG_JSONDATA_PARSE_ERROR = "解析JSONDATA错误";
    public static final String ERRMSG_MTOPCONTEXT_INIT_ERROR = "MTOPCONTEXT初始化错误";
    public static final String ERRMSG_MTOPSDK_INIT_ERROR = "MTOPSDK初始化失败";
    public static final String ERRMSG_MTOP_APICALL_ASYNC_TIMEOUT = "MTOP异步调用超时";
    public static final String ERRMSG_MTOP_MISS_CALL_FACTORY = "Mtop实例没有设置Call Factory";
    public static final String ERRMSG_NETWORK_ERROR = "网络错误";
    public static final String ERRMSG_NETWORK_REQUEST_CONVERT_ERROR = "网络Request转换失败";
    public static final String ERRMSG_NO_NETWORK = "无网络";
    public static final String ERRMSG_PARSE_JSPARAM_ERROR = "MTOP JSBridge 参数解析错误";
    private static final String FAIL_SYS_PREFIX = "FAIL_SYS_";
    @Deprecated
    public static final int INT_ANDROID_SYS_ERROR = -2500;
    @Deprecated
    public static final int INT_ERRCODE_SUCCESS = -1001;
    public static final int INT_ERR_SID_INVALID = -2005;
    @Deprecated
    public static final int INT_UNKNOWN_ERROR = -1000;
    private static final String MAPPING_CODE_ANDROID_SYS_LOGIN_CANCEL = "EC40008";
    private static final String MAPPING_CODE_ANDROID_SYS_LOGIN_FAIL = "EC40007";
    private static final String MAPPING_CODE_API_41X_ANTI_ATTACK = "EC20001";
    private static final String MAPPING_CODE_API_FLOW_LIMIT_LOCKED = "EC20000";
    private static final String MAPPING_CODE_BUILD_PROTOCOL_PARAMS_ERROR = "EC40011";
    private static final String MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED = "ES10041";
    private static final String MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT = "ES10039";
    private static final String MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID = "ES10042";
    private static final String MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE = "ES10038";
    private static final String MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT = "ES10040";
    private static final String MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR = "ES10043";
    private static final String MAPPING_CODE_FAIL_SYS_API_NOT_FOUNDED = "ES10002";
    private static final String MAPPING_CODE_FAIL_SYS_API_STOP_SERVICE = "ES10000";
    private static final String MAPPING_CODE_FAIL_SYS_API_UNAUTHORIZED = "ES10007";
    private static final String MAPPING_CODE_FAIL_SYS_BADARGUMENT_T = "ES10013";
    private static final String MAPPING_CODE_FAIL_SYS_BIZPARAM_MISSED = "ES10018";
    private static final String MAPPING_CODE_FAIL_SYS_BIZPARAM_TYPE_ERROR = "ES10017";
    private static final String MAPPING_CODE_FAIL_SYS_EXPIRED_REQUEST = "ES10031";
    private static final String MAPPING_CODE_FAIL_SYS_FLOWLIMIT = "ES10006";
    private static final String MAPPING_CODE_FAIL_SYS_HSF_THROWN_EXCEPTION = "ES40001";
    private static final String MAPPING_CODE_FAIL_SYS_HTTP_CONNECT_TIMEOUT = "ES30004";
    private static final String MAPPING_CODE_FAIL_SYS_HTTP_INVOKE_ERROR = "ES30002";
    private static final String MAPPING_CODE_FAIL_SYS_HTTP_QUERYIP_ERROR = "ES30000";
    private static final String MAPPING_CODE_FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED = "ES30001";
    private static final String MAPPING_CODE_FAIL_SYS_HTTP_RESPONSE_TIMEOUT = "ES30003";
    private static final String MAPPING_CODE_FAIL_SYS_HTTP_RESULT_FIELDMISSED = "ES40003";
    private static final String MAPPING_CODE_FAIL_SYS_ILEGEL_SIGN = "ES10011";
    private static final String MAPPING_CODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN = "ES10037";
    private static final String MAPPING_CODE_FAIL_SYS_ILLEGAL_ARGUMENT_TTID = "ES10034";
    private static final String MAPPING_CODE_FAIL_SYS_INTERNAL_FAULT = "ES10015";
    private static final String MAPPING_CODE_FAIL_SYS_INVALID_HTTP_METHOD = "ES10012";
    private static final String MAPPING_CODE_FAIL_SYS_INVALID_PROTOCOLVERSION = "ES10033";
    private static final String MAPPING_CODE_FAIL_SYS_MT_ODD_REQUEST = "ES10030";
    private static final String MAPPING_CODE_FAIL_SYS_PARAMINVALID_ERROR = "ES10026";
    private static final String MAPPING_CODE_FAIL_SYS_PARAM_FORMAT_ERROR = "ES10036";
    private static final String MAPPING_CODE_FAIL_SYS_PARAM_MISSING = "ES10035";
    private static final String MAPPING_CODE_FAIL_SYS_PORTOCOLPARAM_INVALID = "ES10032";
    private static final String MAPPING_CODE_FAIL_SYS_PROTOPARAM_MISSED = "ES10008";
    private static final String MAPPING_CODE_FAIL_SYS_PROTOVER_MISSED = "ES10009";
    private static final String MAPPING_CODE_FAIL_SYS_REQUEST_EXPIRED = "ES10010";
    private static final String MAPPING_CODE_FAIL_SYS_REQUEST_QUEUED = "ES10044";
    private static final String MAPPING_CODE_FAIL_SYS_RETMISSED_ERROR = "ES10025";
    private static final String MAPPING_CODE_FAIL_SYS_SERVICE_FAULT = "ES20002";
    private static final String MAPPING_CODE_FAIL_SYS_SERVICE_INNER_FAULT = "ES40002";
    private static final String MAPPING_CODE_FAIL_SYS_SERVICE_NOT_EXIST = "ES20000";
    private static final String MAPPING_CODE_FAIL_SYS_SERVICE_TIMEOUT = "ES20001";
    private static final String MAPPING_CODE_FAIL_SYS_SERVLET_ASYNC_START_FAIL = "ES10005";
    private static final String MAPPING_CODE_FAIL_SYS_SESSION_ERROR = "ES10029";
    private static final String MAPPING_CODE_FAIL_SYS_SESSION_EXPIRED = "ES10003";
    private static final String MAPPING_CODE_FAIL_SYS_SM_ODD_REQUEST = "ES10001";
    private static final String MAPPING_CODE_FAIL_SYS_SYSTEM_BUSY_ERROR = "ES10004";
    private static final String MAPPING_CODE_FAIL_SYS_TOPAUTHPARAM_MISSED = "ES10019";
    private static final String MAPPING_CODE_FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR = "ES10021";
    private static final String MAPPING_CODE_FAIL_SYS_TOPAUTH_FAILED = "ES10020";
    private static final String MAPPING_CODE_FAIL_SYS_TOPAUTH_FAULT = "ES10024";
    private static final String MAPPING_CODE_FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR = "ES10022";
    private static final String MAPPING_CODE_FAIL_SYS_TOPUNAUTHAPI_ERROR = "ES10023";
    private static final String MAPPING_CODE_FAIL_SYS_TRAFFIC_LIMIT = "ES10016";
    private static final String MAPPING_CODE_FAIL_SYS_UNAUTHORIZED_ENTRANCE = "ES10028";
    private static final String MAPPING_CODE_FAIL_SYS_UNKNOWN_APP = "ES10014";
    public static final String MAPPING_CODE_GENERATE_MTOP_SIGN_ERROR = "EC40002";
    private static final String MAPPING_CODE_ILLEGAL_JSPARAM_ERROR = "EC40009";
    private static final String MAPPING_CODE_INIT_MTOP_ISIGN_ERROR = "EC40005";
    private static final String MAPPING_CODE_JSONDATA_BLANK = "EC30000";
    private static final String MAPPING_CODE_JSONDATA_PARSE_ERROR = "EC30001";
    private static final String MAPPING_CODE_MTOPCONTEXT_INIT_ERROR = "EC40001";
    private static final String MAPPING_CODE_MTOPSDK_INIT_ERROR = "EC40000";
    private static final String MAPPING_CODE_MTOP_APICALL_ASYNC_TIMEOUT = "EC40004";
    private static final String MAPPING_CODE_MTOP_MISS_CALL_FACTORY = "EC40006";
    private static final String MAPPING_CODE_NETWORK_ERROR = "EC10001";
    private static final String MAPPING_CODE_NETWORK_REQUEST_CONVERT_ERROR = "EC40003";
    private static final String MAPPING_CODE_NO_NETWORK = "EC10000";
    private static final String MAPPING_CODE_PARSE_JSPARAM_ERROR = "EC40010";
    private static final String MAPPING_CODE_SYSTEM_ERROR = "ES10027";
    private static final String MAPPING_CODE_UNKNOWN_FAIL_CODE = "ES40000";
    @Deprecated
    public static final String RET_MSG_OFFLINE_SUCCESS = "离线调用成功";
    public static final String UNKNOWN_CLIENT_MAPPING_CODE_SUFFIX = "EC00000";
    public static final String UNKNOWN_SERVER_MAPPING_CODE_SUFFIX = "ES00000";
    public static final String UNKNOWN_SERVICE_PROVIDER_MAPPING_CODE_SUFFIX = "TERR00000";
    static HashMap<String, String> errCodeMappingMap = new HashMap<>(128);
    static HashMap<String, String> mtopSdkErrCodeMappingMap = new HashMap<>(24);
    static HashMap<String, String> mtopServerErrCodeMappingMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ErrorMappingType {
        public static final String FLOW_LIMIT_ERROR_MAPPING = "FLOW_LIMIT_ERROR_MAPPING";
        public static final String NETWORK_ERROR_MAPPING = "NETWORK_ERROR_MAPPING";
        public static final String SERVICE_ERROR_MAPPING = "SERVICE_ERROR_MAPPING";

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MappingMsg {
        public static final String FLOW_LIMIT_MAPPING_MSG = "前方拥挤，亲稍等再试试";
        public static final String NETWORK_MAPPING_MSG = "网络竟然崩溃了";
        public static final String SERVICE_MAPPING_MSG = "服务竟然出错了";

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>(64);
        mtopServerErrCodeMappingMap = hashMap;
        hashMap.put(ERRCODE_FAIL_SYS_API_STOP_SERVICE, MAPPING_CODE_FAIL_SYS_API_STOP_SERVICE);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_SM_ODD_REQUEST, MAPPING_CODE_FAIL_SYS_SM_ODD_REQUEST);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_API_NOT_FOUNDED, MAPPING_CODE_FAIL_SYS_API_NOT_FOUNDED);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_SESSION_EXPIRED", MAPPING_CODE_FAIL_SYS_SESSION_EXPIRED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_SYSTEM_BUSY_ERROR, MAPPING_CODE_FAIL_SYS_SYSTEM_BUSY_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_SERVLET_ASYNC_START_FAIL, MAPPING_CODE_FAIL_SYS_SERVLET_ASYNC_START_FAIL);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_FLOWLIMIT", MAPPING_CODE_FAIL_SYS_FLOWLIMIT);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_API_UNAUTHORIZED, MAPPING_CODE_FAIL_SYS_API_UNAUTHORIZED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_PROTOPARAM_MISSED, MAPPING_CODE_FAIL_SYS_PROTOPARAM_MISSED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_PROTOVER_MISSED, MAPPING_CODE_FAIL_SYS_PROTOVER_MISSED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_REQUEST_EXPIRED, MAPPING_CODE_FAIL_SYS_REQUEST_EXPIRED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ILEGEL_SIGN, MAPPING_CODE_FAIL_SYS_ILEGEL_SIGN);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_INVALID_HTTP_METHOD, MAPPING_CODE_FAIL_SYS_INVALID_HTTP_METHOD);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_BADARGUMENT_T, MAPPING_CODE_FAIL_SYS_BADARGUMENT_T);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_UNKNOWN_APP, MAPPING_CODE_FAIL_SYS_UNKNOWN_APP);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_INTERNAL_FAULT, MAPPING_CODE_FAIL_SYS_INTERNAL_FAULT);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_TRAFFIC_LIMIT", MAPPING_CODE_FAIL_SYS_TRAFFIC_LIMIT);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_BIZPARAM_TYPE_ERROR, MAPPING_CODE_FAIL_SYS_BIZPARAM_TYPE_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_BIZPARAM_MISSED, MAPPING_CODE_FAIL_SYS_BIZPARAM_MISSED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_TOPAUTHPARAM_MISSED, MAPPING_CODE_FAIL_SYS_TOPAUTHPARAM_MISSED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_TOPAUTH_FAILED, MAPPING_CODE_FAIL_SYS_TOPAUTH_FAILED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR, MAPPING_CODE_FAIL_SYS_TOPAUTH_ACCESSTOKENEXPIRED_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR, MAPPING_CODE_FAIL_SYS_TOPAUTH_TRAFFICLIMIT_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_TOPUNAUTHAPI_ERROR, MAPPING_CODE_FAIL_SYS_TOPUNAUTHAPI_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_TOPAUTH_FAULT, MAPPING_CODE_FAIL_SYS_TOPAUTH_FAULT);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_RETMISSED_ERROR, MAPPING_CODE_FAIL_SYS_RETMISSED_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_PARAMINVALID_ERROR, MAPPING_CODE_FAIL_SYS_PARAMINVALID_ERROR);
        mtopServerErrCodeMappingMap.put("SYSTEM_ERROR", MAPPING_CODE_SYSTEM_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_UNAUTHORIZED_ENTRANCE, MAPPING_CODE_FAIL_SYS_UNAUTHORIZED_ENTRANCE);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_SESSION_ERROR, MAPPING_CODE_FAIL_SYS_SESSION_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_MT_ODD_REQUEST, MAPPING_CODE_FAIL_SYS_MT_ODD_REQUEST);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_EXPIRED_REQUEST, MAPPING_CODE_FAIL_SYS_EXPIRED_REQUEST);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_PORTOCOLPARAM_INVALID, MAPPING_CODE_FAIL_SYS_PORTOCOLPARAM_INVALID);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_INVALID_PROTOCOLVERSION, MAPPING_CODE_FAIL_SYS_INVALID_PROTOCOLVERSION);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_PARAM_MISSING, MAPPING_CODE_FAIL_SYS_PARAM_MISSING);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_PARAM_FORMAT_ERROR, MAPPING_CODE_FAIL_SYS_PARAM_FORMAT_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ILLEGAL_ARGUMENT_TTID, MAPPING_CODE_FAIL_SYS_ILLEGAL_ARGUMENT_TTID);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN, MAPPING_CODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE, MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT, MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_INTERNAL_FAULT);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT, MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_TRAFFIC_LIMIT);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED, MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID, MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_PARAM_INVALID);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR, MAPPING_CODE_FAIL_SYS_ACCESS_TOKEN_UNKNOWN_ERROR);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_REQUEST_QUEUED", MAPPING_CODE_FAIL_SYS_REQUEST_QUEUED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_SERVICE_NOT_EXIST, MAPPING_CODE_FAIL_SYS_SERVICE_NOT_EXIST);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_SERVICE_TIMEOUT", MAPPING_CODE_FAIL_SYS_SERVICE_TIMEOUT);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_SERVICE_FAULT", MAPPING_CODE_FAIL_SYS_SERVICE_FAULT);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_HTTP_QUERYIP_ERROR, MAPPING_CODE_FAIL_SYS_HTTP_QUERYIP_ERROR);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED, MAPPING_CODE_FAIL_SYS_HTTP_REQUESTSUBMIT_FAILED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_HTTP_INVOKE_ERROR, MAPPING_CODE_FAIL_SYS_HTTP_INVOKE_ERROR);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_HTTP_RESPONSE_TIMEOUT", MAPPING_CODE_FAIL_SYS_HTTP_RESPONSE_TIMEOUT);
        mtopServerErrCodeMappingMap.put("FAIL_SYS_HTTP_CONNECT_TIMEOUT", MAPPING_CODE_FAIL_SYS_HTTP_CONNECT_TIMEOUT);
        mtopServerErrCodeMappingMap.put(ERRCODE_UNKNOWN_FAIL_CODE, MAPPING_CODE_UNKNOWN_FAIL_CODE);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_HSF_THROWN_EXCEPTION, MAPPING_CODE_FAIL_SYS_HSF_THROWN_EXCEPTION);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_HTTP_RESULT_FIELDMISSED, MAPPING_CODE_FAIL_SYS_HTTP_RESULT_FIELDMISSED);
        mtopServerErrCodeMappingMap.put(ERRCODE_FAIL_SYS_SERVICE_INNER_FAULT, MAPPING_CODE_FAIL_SYS_SERVICE_INNER_FAULT);
        mtopSdkErrCodeMappingMap.put("ANDROID_SYS_NO_NETWORK", MAPPING_CODE_NO_NETWORK);
        mtopSdkErrCodeMappingMap.put("ANDROID_SYS_NETWORK_ERROR", MAPPING_CODE_NETWORK_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_JSONDATA_BLANK, MAPPING_CODE_JSONDATA_BLANK);
        mtopSdkErrCodeMappingMap.put(ERRCODE_JSONDATA_PARSE_ERROR, MAPPING_CODE_JSONDATA_PARSE_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_MTOPSDK_INIT_ERROR, MAPPING_CODE_MTOPSDK_INIT_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_MTOPCONTEXT_INIT_ERROR, MAPPING_CODE_MTOPCONTEXT_INIT_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_GENERATE_MTOP_SIGN_ERROR, MAPPING_CODE_GENERATE_MTOP_SIGN_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_NETWORK_REQUEST_CONVERT_ERROR, MAPPING_CODE_NETWORK_REQUEST_CONVERT_ERROR);
        mtopSdkErrCodeMappingMap.put("ANDROID_SYS_API_FLOW_LIMIT_LOCKED", MAPPING_CODE_API_FLOW_LIMIT_LOCKED);
        mtopSdkErrCodeMappingMap.put(ERRCODE_API_41X_ANTI_ATTACK, MAPPING_CODE_API_41X_ANTI_ATTACK);
        mtopSdkErrCodeMappingMap.put(ERRCODE_MTOP_APICALL_ASYNC_TIMEOUT, MAPPING_CODE_MTOP_APICALL_ASYNC_TIMEOUT);
        mtopSdkErrCodeMappingMap.put(ERRCODE_INIT_MTOP_ISIGN_ERROR, MAPPING_CODE_INIT_MTOP_ISIGN_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_MTOP_MISS_CALL_FACTORY, MAPPING_CODE_MTOP_MISS_CALL_FACTORY);
        mtopSdkErrCodeMappingMap.put(ERRCODE_ANDROID_SYS_LOGIN_FAIL, MAPPING_CODE_ANDROID_SYS_LOGIN_FAIL);
        mtopSdkErrCodeMappingMap.put(ERRCODE_ANDROID_SYS_LOGIN_CANCEL, MAPPING_CODE_ANDROID_SYS_LOGIN_CANCEL);
        mtopSdkErrCodeMappingMap.put(ERRCODE_ILLEGAL_JSPARAM_ERROR, MAPPING_CODE_ILLEGAL_JSPARAM_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_PARSE_JSPARAM_ERROR, MAPPING_CODE_PARSE_JSPARAM_ERROR);
        mtopSdkErrCodeMappingMap.put(ERRCODE_BUILD_PROTOCOL_PARAMS_ERROR, MAPPING_CODE_BUILD_PROTOCOL_PARAMS_ERROR);
        errCodeMappingMap.putAll(mtopServerErrCodeMappingMap);
        errCodeMappingMap.putAll(mtopSdkErrCodeMappingMap);
        errCodeMappingMap.put("SUCCESS", "SUCCESS");
    }

    public static String appendMappingCode(int i, String str) {
        return i + ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + str;
    }

    @Deprecated
    public static Integer getIntErrCodeByStrErrorCode(String str) {
        return -1000;
    }

    public static String getMappingCodeByErrorCode(String str) {
        return errCodeMappingMap.get(str);
    }

    @Deprecated
    public static Integer getMtopSdkIntErrCode(String str) {
        return -1000;
    }

    public static boolean is41XResult(String str) {
        return ERRCODE_API_41X_ANTI_ATTACK.equals(str);
    }

    public static boolean isApiLockedResult(String str) {
        return "ANDROID_SYS_API_FLOW_LIMIT_LOCKED".equals(str);
    }

    public static boolean isExpiredRequest(String str) {
        return ERRCODE_FAIL_SYS_EXPIRED_REQUEST.equals(str) || ERRCODE_FAIL_SYS_REQUEST_EXPIRED.equals(str);
    }

    public static boolean isIllegelSign(String str) {
        return ERRCODE_FAIL_SYS_ILEGEL_SIGN.equals(str);
    }

    public static boolean isMtopSdkError(String str) {
        return StringUtils.isBlank(str) || mtopSdkErrCodeMappingMap.containsKey(str);
    }

    public static boolean isMtopServerError(String str) {
        return str != null && (mtopServerErrCodeMappingMap.containsKey(str) || str.startsWith(FAIL_SYS_PREFIX));
    }

    public static boolean isNetworkError(String str) {
        return "ANDROID_SYS_NETWORK_ERROR".equals(str) || "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    public static boolean isNoNetwork(String str) {
        return "ANDROID_SYS_NO_NETWORK".equals(str);
    }

    public static boolean isSessionInvalid(String str) {
        return "FAIL_SYS_SESSION_EXPIRED".equals(str) || ERRCODE_ANDROID_SYS_LOGIN_FAIL.equals(str);
    }

    public static boolean isSuccess(String str) {
        return "SUCCESS".equals(str);
    }

    public static boolean isSystemError(String str) {
        return mtopServerErrCodeMappingMap.containsKey(str);
    }
}
