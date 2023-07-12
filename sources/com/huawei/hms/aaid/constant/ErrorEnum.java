package com.huawei.hms.aaid.constant;

import android.util.SparseArray;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.SendException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.huawei.hms.support.api.entity.core.CommonCode;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public enum ErrorEnum {
    SUCCESS(0, 0, "success"),
    ERROR_NO_TOKEN(800000000, SendException.ERROR_NO_TOKEN, "token missing"),
    ERROR_NO_TOKENSIGN(800000001, SendException.ERROR_TOKEN_INVALID, "token invalid"),
    ERROR_NO_NETWORK(800000002, SendException.ERROR_NO_NETWORK, "no network"),
    ERROR_SERVICE_NOT_AVAILABLE(800000003, SendException.ERROR_SERVICE_NOT_AVAILABLE, "service not available"),
    ERROR_PUSH_SERVER(800000004, SendException.ERROR_PUSH_SERVER, "push server error"),
    ERROR_UNKNOWN(800000005, SendException.ERROR_UNKNOWN, "unknown error"),
    ERROR_NO_RIGHT(800100000, 907122036, "no right"),
    ERROR_NO_CONNECTION_ID(800100001, 907122037, "get token error"),
    ERROR_LENGTH(800100002, 907122037, "get token error"),
    ERROR_NO_DEVICE_ID_TYPE(800100003, 907122037, "get token error"),
    ERROR_PARAM_INVALID(800100004, 907122037, "get token error"),
    ERROR_TOKEN_URL_EMPTY(800100005, 907122037, "get token error"),
    ERROR_NOT_ALLOW_CROSS_APPLY(800100006, 907122053, "Failed to apply for the token. Cross-region application is not allowed."),
    ERROR_MULTISENDER_NO_RIGHT(800100007, 907122039, "Failed to apply for the token. No multisender right."),
    ERROR_TOKEN_DECRYPT(800200001, SendException.ERROR_TOKEN_INVALID, "token invalid"),
    ERROR_TOKENSIGN_VALID(800200002, SendException.ERROR_TOKEN_INVALID, "token invalid"),
    ERROR_TOPIC_EXCEED(800200003, 907122034, "topic exceed"),
    ERROR_TOPIC_SEND(800200004, 907122035, "topic send error"),
    ERROR_STORAGE_LOCATION_EMPTY(800200005, 907122038, "storage location is empty or invalid"),
    ERROR_SIZE(800300000, SendException.ERROR_SIZE, "message size error"),
    ERROR_INVALID_PARAMETERS(800300001, SendException.ERROR_INVALID_PARAMETERS, "parameter invalid"),
    ERROR_TOO_MANY_MESSAGES(800300002, SendException.ERROR_TOO_MANY_MESSAGES, "too many messages"),
    ERROR_TTL_EXCEEDED(800300003, SendException.ERROR_TTL_EXCEEDED, "ttl exceed"),
    ERROR_UPSTREAM_TOKEN_DECRYPT(800300004, SendException.ERROR_TOKEN_INVALID, "token invalid"),
    ERROR_UPSTREAM_TOKENSIGN_VALID(800300005, SendException.ERROR_TOKEN_INVALID, "token invalid"),
    ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP(800300006, 907122057, "device not in device group"),
    ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY(800300007, 907122038, "storage location is empty or invalid"),
    ERROR_CACHE_SIZE_EXCEED(800300008, 907122058, "cache size exceeds threshold"),
    ERROR_MSG_CACHE(800300009, 907122059, "message is cached"),
    ERROR_APP_SERVER_NOT_ONLINE(800300010, 907122060, "app server is not online."),
    ERROR_OVER_FLOW_CONTROL_SIZE(800300011, 907122061, "frequency of message is over flow control size."),
    ERROR_PUSH_ARGUMENTS_INVALID(807135000, CommonCode.ErrorCode.ARGUMENTS_INVALID, "arguments invalid"),
    ERROR_PUSH_INTERNAL_ERROR(807135001, CommonCode.ErrorCode.INTERNAL_ERROR, "internal error"),
    ERROR_PUSH_NAMING_INVALID(807135002, CommonCode.ErrorCode.NAMING_INVALID, "naming invalid"),
    ERROR_PUSH_CLIENT_API_INVALID(807135003, CommonCode.ErrorCode.CLIENT_API_INVALID, "client api invalid"),
    ERROR_PUSH_EXECUTE_TIMEOUT(807135004, CommonCode.ErrorCode.EXECUTE_TIMEOUT, "execute timeout"),
    ERROR_PUSH_NOT_IN_SERVICE(807135005, CommonCode.ErrorCode.NOT_IN_SERVICE, "not int service"),
    ERROR_SPUSH_ESSION_INVALID(807135006, CommonCode.ErrorCode.SESSION_INVALID, "session invalid"),
    ERROR_ARGUMENTS_INVALID(CommonCode.ErrorCode.ARGUMENTS_INVALID, CommonCode.ErrorCode.ARGUMENTS_INVALID, "arguments invalid"),
    ERROR_INTERNAL_ERROR(CommonCode.ErrorCode.INTERNAL_ERROR, CommonCode.ErrorCode.INTERNAL_ERROR, "internal error"),
    ERROR_NAMING_INVALID(CommonCode.ErrorCode.NAMING_INVALID, CommonCode.ErrorCode.NAMING_INVALID, "naming invalid"),
    ERROR_CLIENT_API_INVALID(CommonCode.ErrorCode.CLIENT_API_INVALID, CommonCode.ErrorCode.CLIENT_API_INVALID, "client api invalid"),
    ERROR_EXECUTE_TIMEOUT(CommonCode.ErrorCode.EXECUTE_TIMEOUT, CommonCode.ErrorCode.EXECUTE_TIMEOUT, "execute timeout"),
    ERROR_NOT_IN_SERVICE(CommonCode.ErrorCode.NOT_IN_SERVICE, CommonCode.ErrorCode.NOT_IN_SERVICE, "not int service"),
    ERROR_SESSION_INVALID(CommonCode.ErrorCode.SESSION_INVALID, CommonCode.ErrorCode.SESSION_INVALID, "session invalid"),
    ERROR_API_NOT_SPECIFIED(1002, 1002, "API not specified"),
    ERROR_GET_SCOPE_ERROR(AuthCode.ErrorCode.GET_SCOPE_ERROR, AuthCode.ErrorCode.GET_SCOPE_ERROR, "get scope error"),
    ERROR_SCOPE_LIST_EMPTY(AuthCode.ErrorCode.SCOPE_LIST_EMPTY, AuthCode.ErrorCode.SCOPE_LIST_EMPTY, "scope list empty"),
    ERROR_CERT_FINGERPRINT_EMPTY(AuthCode.ErrorCode.CERT_FINGERPRINT_EMPTY, AuthCode.ErrorCode.CERT_FINGERPRINT_EMPTY, "certificate fingerprint empty"),
    ERROR_PERMISSION_LIST_EMPTY(AuthCode.ErrorCode.PERMISSION_LIST_EMPTY, AuthCode.ErrorCode.PERMISSION_LIST_EMPTY, "permission list empty"),
    ERROR_AUTH_INFO_NOT_EXIST(6002, 6002, "auth info not exist"),
    ERROR_CERT_FINGERPRINT_ERROR(6003, 6003, "certificate fingerprint error"),
    ERROR_PERMISSION_NOT_EXIST(6004, 6004, "permission not exist"),
    ERROR_PERMISSION_NOT_AUTHORIZED(6005, 6005, "permission not authorized"),
    ERROR_PERMISSION_EXPIRED(6006, 6006, "permission expired"),
    ERROR_NO_NETWORK_OLD(907122005, SendException.ERROR_NO_NETWORK, "no network"),
    ERROR_NO_RIGHT_SELF_MAPPING(907122011, 907122036, "no right"),
    ERROR_NO_CONNECTION_ID_OLD(907122012, 907122037, "get token error"),
    ERROR_LENGTH_OLD(907122013, 907122037, "get token error"),
    ERROR_NO_DEVICE_ID_TYPE_OLD(907122014, 907122037, "get token error"),
    ERROR_PUSH_SERVER_OLD(907122017, SendException.ERROR_PUSH_SERVER, "push server error"),
    ERROR_NO_TOKEN_OLD(907122019, SendException.ERROR_NO_TOKEN, "token missing"),
    ERROR_HMS_CLIENT_API(907122048, 907122048, "HMS client api invalid"),
    ERROR_OPERATION_NOT_SUPPORTED(907122049, 907122049, "operation not supported"),
    ERROR_MAIN_THREAD(907122050, 907122050, "operation in MAIN thread prohibited"),
    ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING(907122051, 907122051, "device certificate auth fail"),
    ERROR_BIND_SERVICE_SELF_MAPPING(907122052, 907122052, "bind service failed."),
    ERROR_AUTO_INITIALIZING(907122054, 907122054, "push kit initializing, try again later"),
    ERROR_RETRY_LATER_SELF_MAPPING(907122055, 907122055, "System busy, please retry later."),
    ERROR_SEND_SELF_MAPPING(907122056, 907122056, "send error."),
    ERROR_MISSING_PROJECT_ID(907122064, 907122064, "agc connect services config missing project id"),
    ERROR_RESTRICT_GET_TOKEN(800100014, 907122065, "restrict get token"),
    ERROR_GET_3RD_PARTY_TOKEN_FAILED(907122101, 907122101, "get 3rd-party token failed."),
    ERROR_DELETE_3RD_PARTY_TOKEN_FAILED(907122102, 907122102, "delete 3rd-party token failed."),
    ERROR_3RD_PARTY_INTERNAL_ERROR(907122103, 907122103, "3rd-party internal error."),
    ERROR_FETCH_DOMAIN_FAILED(907135104, 907135104, "fetch domain failed."),
    ERROR_BUILD_CONTENT_ERROR(907122105, 907122105, "build content error."),
    ERROR_HWID_NOT_LOGIN(907122066, 907122066, "account logout"),
    ERROR_PROFILE_EXCEED(800400000, 907122067, "profile num over limit"),
    ERROR_OPER_IN_CHILD_PROCESS(907122068, 907122068, "Operations in child processes are not supported.");
    
    public static final SparseArray<ErrorEnum> ENUM_MAPPER = new SparseArray<>();
    public int externalCode;
    public int internalCode;
    public String message;

    static {
        ErrorEnum[] values;
        for (ErrorEnum errorEnum : values()) {
            SparseArray<ErrorEnum> sparseArray = ENUM_MAPPER;
            sparseArray.put(errorEnum.internalCode, errorEnum);
            sparseArray.put(errorEnum.externalCode, errorEnum);
        }
    }

    ErrorEnum(int i, int i2, String str) {
        this.internalCode = i;
        this.externalCode = i2;
        this.message = str;
    }

    public static ErrorEnum fromCode(int i) {
        return ENUM_MAPPER.get(i, ERROR_UNKNOWN);
    }

    public int getExternalCode() {
        return this.externalCode;
    }

    public int getInternalCode() {
        return this.internalCode;
    }

    public String getMessage() {
        return this.message;
    }

    public ApiException toApiException() {
        return new ApiException(new Status(getExternalCode(), getMessage()));
    }
}
