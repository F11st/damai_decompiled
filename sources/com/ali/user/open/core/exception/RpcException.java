package com.ali.user.open.core.exception;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RpcException extends RuntimeException {
    private static final long serialVersionUID = -2875437994101380406L;
    private int mCode;
    private String mMsg;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public interface ErrorCode {
        public static final int ANTI_REFRESH = 401;
        public static final int API_UNAUTHORIZED = 408;
        public static final int CLIENT_DESERIALIZER_ERROR = 10;
        public static final int CLIENT_NETWORK_ERROR = 7;
        public static final int EXPIRED_REQUEST = 402;
        public static final int ILLEGEL_SIGN = 403;
        public static final int LIMIT_ERROR = 400;
        public static final int SESSION_INVALID = 407;
        public static final int SYSTEM_ERROR = 406;
    }

    public RpcException(Integer num, String str) {
        super(format(num, str));
        this.mCode = num.intValue();
        this.mMsg = str;
    }

    protected static String format(Integer num, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("RPCException: ");
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

    public static boolean isNetworkError(int i) {
        return i == 7;
    }

    public static boolean isSystemError(int i) {
        if (i != 7) {
            return i >= 400 && i <= 408;
        }
        return true;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public RpcException(Integer num, Throwable th) {
        super(th);
        this.mCode = num.intValue();
    }

    public RpcException(String str) {
        super(str);
        this.mCode = 0;
        this.mMsg = str;
    }
}
