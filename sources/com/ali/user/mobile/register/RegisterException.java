package com.ali.user.mobile.register;

import com.ali.user.mobile.rpc.RpcResponse;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RegisterException<T> {
    private Throwable cause;
    private int code;
    private String message;
    private RpcResponse<T> orinResponse;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface ErrorCode {
        public static final int ACTION_TYPE_ALERT = 700;
        public static final int ACTION_TYPE_ALERT_WITH_H5 = 1000;
        public static final int ACTION_TYPE_NOTIFY = 900;
        public static final int ACTION_TYPE_REGISTER = 1300;
        public static final int ACTION_TYPE_REGISTER_FAIL = 1301;
        public static final int ACTION_TYPE_REGISTER_PARAM_ERROR = 1302;
        public static final int ACTION_TYPE_TOAST = 800;
        public static final int ACTION_TYPE_UCC_H5 = 1200;
        public static final int ACTION_TYPE_UNKNOW = 1100;
        public static final int ANTI_REFRESH = 401;
        public static final int CLIENT_NETWORK_CONNECTION_ERROR = 4;
        public static final int CLIENT_NETWORK_ERROR = 7;
        public static final int CLIENT_NETWORK_SERVER_ERROR = 6;
        public static final int CLIENT_NETWORK_SOCKET_ERROR = 5;
        public static final int ERROR_UNKNOWN = 405;
        public static final int EXPIRED_REQUEST = 402;
        public static final int FACE_LOGIN = 1400;
        public static final int FACE_LOGIN_SCAN_FALI = 1402;
        public static final int FACE_LOGIN_SCAN_FALI_CHOOSE_OTHER = 1401;
        public static final int H5_DATA_ERROR = 601;
        public static final int H5_ERROR_MACHINE = 603;
        public static final int H5_NO_URL = 602;
        public static final int H5_RESULT_FAIL = 604;
        public static final int H5_RESULT_PARAM_ERROR = 605;
        public static final int ILLEGEL_SIGN = 403;
        public static final int LIMIT_ERROR = 400;
        public static final int MOBILE_VERIFY_LOGIN = 1600;
        public static final int MOBILE_VERIFY_LOGIN_GET_TOKEEN_FAIL = 1601;
        public static final int SESSION_INVALID = 407;
        public static final int SIM_LOGIN = 1500;
        public static final int SIM_LOGIN_GET_TOKEEN_FAIL = 1501;
        public static final int SYSTEM_ERROR = 406;
        public static final int UCC_H5_FAIL = 1202;
        public static final int UCC_H5_NO_LOGIN_DATA = 1201;
    }

    public RegisterException(int i, String str, RpcResponse<T> rpcResponse) {
        this.code = i;
        this.message = str;
        this.orinResponse = rpcResponse;
    }

    protected static String format(Integer num, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginException: ");
        if (num != null) {
            sb.append(jn1.ARRAY_START_STR);
            sb.append(num);
            sb.append(jn1.ARRAY_END_STR);
        }
        sb.append(" : ");
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean isSystemError(int i) {
        return i == 7;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.message;
    }

    public RpcResponse<T> getOrinResponse() {
        return this.orinResponse;
    }

    public RegisterException(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public RegisterException(int i, Throwable th) {
        this.code = i;
        this.cause = th;
    }
}
