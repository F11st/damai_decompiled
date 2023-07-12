package com.huawei.hms.push;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class SendException extends BaseException {
    public static final int ERROR_INVALID_PARAMETERS = 907122042;
    public static final int ERROR_NO_NETWORK = 907122031;
    public static final int ERROR_NO_TOKEN = 907122030;
    public static final int ERROR_PUSH_SERVER = 907122047;
    public static final int ERROR_SERVICE_NOT_AVAILABLE = 907122046;
    public static final int ERROR_SIZE = 907122041;
    public static final int ERROR_TOKEN_INVALID = 907122032;
    public static final int ERROR_TOO_MANY_MESSAGES = 907122043;
    public static final int ERROR_TTL_EXCEEDED = 907122044;
    public static final int ERROR_UNKNOWN = 907122045;

    public SendException(int i) {
        super(i);
    }
}
