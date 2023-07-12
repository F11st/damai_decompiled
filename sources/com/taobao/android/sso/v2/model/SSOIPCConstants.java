package com.taobao.android.sso.v2.model;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SSOIPCConstants {
    public static final String APPLY_SSO_RESULT = "applySSOTokenResult";
    public static final String CURRENT_SSO_MINI_PROGRAM = "quickapp_1";
    public static final String CURRENT_SSO_VERSION = "android:2";
    public static final String IPC_JUMP_URL = "targetPage";
    public static final String IPC_MASTER_APPKEY = "sourceAppKey";
    public static final String IPC_MASTER_KIDS_STATUS = "taoKidsLoginStatus";
    public static final String IPC_MASTER_KIDS_USERID = "taoKidsUserId";
    public static final String IPC_MASTER_SIGN = "sign";
    public static final String IPC_MASTER_SSO_TOKEN = "ssoToken";
    public static final String IPC_MASTER_SSO_VERSION = "ssoVersion";
    public static final String IPC_MASTER_T = "masterT";
    public static final String IPC_MASTER_USER_ID = "userId";
    public static final String IPC_MASTER_UUID_KEY = "uuidKey";
    public static final String IPC_SLAVE_APPKEY = "appKey";
    public static final String IPC_SLAVE_CALLBACK = "callbackClass";
    public static final String IPC_SLAVE_SIGN = "sign";
    public static final String IPC_SLAVE_SSO_VERSION = "ssoVersion";
    public static final String IPC_SLAVE_T = "t";
    public static final String IPC_SLAVE_TARGET_URL = "targetUrl";
    public static final String IPC_SLAVE_UUIDKEY = "uuidKey";
    public static int OPEN_TAOBAO = 10008;
    public static final String SSO_VRRSION = "SSO_V2_VERSION";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface SSOResultCode {
        public static final int SSO_CANCEL = 504;
        public static final int SSO_EXCEPTION = 503;
        public static final int SSO_NETWORK_ERROR = 501;
        public static final int SSO_RESPONSE_NULL_ERROR = 502;
        public static final int SSO_SIGN_EXCEPTION = 505;
        public static final int SUCCESS = 500;
    }
}
