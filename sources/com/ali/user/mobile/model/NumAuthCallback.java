package com.ali.user.mobile.model;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface NumAuthCallback {
    public static final int INIT_ERROR = -103;
    public static final String INIT_ERROR_MSG = "auth sdk checkEnvAvailable is false";
    public static final int RPC_PARSE_ERROR = -101;
    public static final String RPC_PARSE_ERROR_MSG = "rpc parse data fail";

    void onInit(boolean z);
}
