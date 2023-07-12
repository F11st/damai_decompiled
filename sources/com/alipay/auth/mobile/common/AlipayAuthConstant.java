package com.alipay.auth.mobile.common;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface AlipayAuthConstant {
    public static final String ALIPAY_PACKAGE_NAME = "com.eg.android.AlipayGphone";
    public static final String ALIPAY_URI = "alipays://platformapi/startApp?appId=20000267";
    public static final String APP_KEY = "appKey";
    public static final String FULL_CLASS_NAME = "fullClassName";
    public static final boolean IS_DEBUG = false;
    public static final String PACKAGE_NAME = "packageName";
    public static final String SIGN_DATA = "signData";
    public static final String TIME_STAMP = "timestamp";
    public static final String UUID = "uuid";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface AuthResultKey {
        public static final String AUTH_CODE = "code";
        public static final String AUTH_MSG = "msg";
        public static final String AUTH_SUCCESS = "success";
        public static final String AUTH_TOEKN = "token";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface AuthState {
        public static final String AUTH_STATE_KEY = "authStateKey";
        public static final int STATE_NORMAL_CALLBACK = 3000;
        public static final int STATE_USER_CANCEL = 3001;
        public static final int STATE_USER_CHANGE = 3002;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface AuthTokenResult {
        public static final String AUTH_TOKEN_RESULT_SUCCESS = "1000";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface LoginResult {
        public static final String ALIPAY_LOGIN_SUCCESS = "1000";
        public static final String SUCCESS = "200";
    }
}
