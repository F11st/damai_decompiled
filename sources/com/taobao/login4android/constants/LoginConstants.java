package com.taobao.login4android.constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginConstants {
    public static final String BROWSER_REF_URL = "browserRefUrl";
    public static final String EVENT_SESSION_INVALID = "SESSION_INVALID";
    public static final String H5_SEND_CANCEL_BROADCAST = "sendCancelBroadcast";
    public static final String LOGIN_ACCOUNT = "login_account";
    public static final String LOGIN_EXT_DATA = "loginExtData";
    public static final String LOGIN_FAIL_BY_APPKEY = "loginFailNullAppkey";
    public static final String LOGIN_FAIL_REASON = "loginFailReason";
    public static final String LOGIN_FROM = "loginFrom";
    public static final String LOGIN_FROM_MULTI_ACCOUNT = "multiAccount";
    public static final String LOGIN_SOURCE = "source";
    public static final String LOGIN_TYPE = "loginType";
    public static final String LOGIN_UPGRADE = "upgrade";
    public static final String LOGOUT_TYPE = "logoutType";
    public static final String MTOP_API_REFERENCE = "apiReferer";
    public static final String SHOW_TOAST = "showToast";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum LogoutType {
        NORMAL_LOGOUT("logout"),
        CHANGE_ACCOUNT("changeAccount");
        
        private String type;

        LogoutType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }
}
