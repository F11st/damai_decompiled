package com.ali.user.mobile.app.constant;

import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FragmentConstant {
    public static final String ALIPAY_FRAGMENT_TAG = "aliuser_alipay";
    public static final String ALIPAY_HISTORY_FRAGMENT_TAG = "aliuser_alipay_history";
    public static final String AUTH_FRAGMENT_TAG = "aliuser_auth_fragment";
    public static final String FACE_LOGIN_FRAGMENT_TAG = "aliuser_face_login";
    public static final String FINGER_FRAGMENT = "aliuser_finger";
    public static final String GUIDE_FRAGMENT_TAG = "aliuser_guide_login";
    public static final String LOGIN_SMSCODE_FRAGMENT_TAG = "aliuser_smscode_login";
    public static final String MOBILE_LOGIN_FRAGMENT_TAG = "aliuser_mobile_login";
    public static final String ONE_KEY_LOGIN_FRAGMENT_TAG = "aliuser_onekey_login";
    public static final String ONE_KEY_LOGIN_HISTORY_FRAGMENT_TAG = "aliuser_onekey_login_history";
    public static final String PWD_AUTH_WITH_FIXED_NICK = "aliuser_pwd_auth_fix_nick";
    public static final String PWD_LOGIN_FRAGMENT_TAG = "aliuser_pwd_login";
    public static final String RECOMMEND_LOGIN_FRAGMENT_TAG = "aliuser_recommend_login";
    public static final String REG_FRAGMENT_TAG = "aliuser_reg";
    public static final String REG_SMSCODE_FRAGMENT_TAG = "aliuser_smscode_reg";
    public static final String SNS_FAST_REG_OR_LOGIN_BIND = "aliuser_reg_or_login_bind";
    public static final String SNS_TO_SMS_LOGIN_FRAGMENT_TAG = "aliuser_sns_to_sms";
    public static final String TWO_STEP_MOBILE_LOGIN_FRAGMENT_TAG = "aliuser_two_step_mobile_login";

    public static List<String> getFragmentTagList() {
        return Arrays.asList(GUIDE_FRAGMENT_TAG, AUTH_FRAGMENT_TAG, MOBILE_LOGIN_FRAGMENT_TAG, PWD_LOGIN_FRAGMENT_TAG, FACE_LOGIN_FRAGMENT_TAG, ONE_KEY_LOGIN_FRAGMENT_TAG, LOGIN_SMSCODE_FRAGMENT_TAG, RECOMMEND_LOGIN_FRAGMENT_TAG, ONE_KEY_LOGIN_HISTORY_FRAGMENT_TAG, ALIPAY_HISTORY_FRAGMENT_TAG, ALIPAY_FRAGMENT_TAG, FINGER_FRAGMENT, SNS_TO_SMS_LOGIN_FRAGMENT_TAG);
    }

    public static List<String> getRegFragmentTagList() {
        return Arrays.asList(REG_SMSCODE_FRAGMENT_TAG, REG_FRAGMENT_TAG);
    }
}
