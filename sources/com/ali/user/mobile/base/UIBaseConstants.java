package com.ali.user.mobile.base;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UIBaseConstants {
    public static final String UT_FROM_REGIST_KEY = "ut_from_register";

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface IntentExtrasNamesConstants {
        public static final String NUM_PROTOCOL_NAME = "protocolName";
        public static final String NUM_PROTOCOL_URL = "protocolURL";
        public static final String NUM_SCENE = "scene";
        public static final String PARAM_LOGIN_PARAM = "PARAM_LOGIN_PARAM";
        public static final String PARAM_LOGIN_PARAM_IS_BIND_PHONE = "isBindPhone";
        public static final String PARAM_METHODS = "loginMethods";
        public static final String PARAM_MOBILE_NUMBER = "number";
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface LoginPage {
        public static final String HALF_PAGE_GUIDE_LOGIN = "halfPageGuideLogin";
        public static final String HALF_PAGE_ONEKEY_LOGIN = "halfPageOnekeyLogin";
        public static final String PAGE_GUIDE_LOGIN = "pageGuideLogin";
        public static final String PAGE_LOGIN_TYPE = "pageLoginType";
        public static final String PAGE_ONEKEY_LOGIN = "pageOnekeyLogin";
        public static final String PAGE_PWD_LOGIN = "pagePwdLogin";
        public static final String PAGE_RECOMMEND_LOGIN = "pageRecommendLogin";
        public static final String PAGE_SCAN_FACE_LOGIN = "pageScanFaceLogin";
        public static final String PAGE_SMS_LOGIN = "pageSmsLogin";
    }

    public static boolean isHalfPage(String str) {
        return TextUtils.equals(LoginPage.HALF_PAGE_GUIDE_LOGIN, str) || TextUtils.equals(LoginPage.HALF_PAGE_ONEKEY_LOGIN, str);
    }
}
