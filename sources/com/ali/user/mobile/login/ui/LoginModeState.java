package com.ali.user.mobile.login.ui;

import com.ali.user.mobile.ui.R;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum SCAN_FACE uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public final class LoginModeState {
    private static final /* synthetic */ LoginModeState[] $VALUES;
    public static final LoginModeState BIOMETRIC;
    public static final LoginModeState LOCATION;
    public static final LoginModeState PASSWORD;
    public static final LoginModeState SCAN_FACE;
    public static final LoginModeState SIM_LOGIN;
    public static final LoginModeState SMS_LOGIN;
    public final int loginBtnText;
    public final int loginModeName;
    public final int passwordVisibility;
    public final int protocolVisibility;
    public final int regionTVVisibility;
    public final int rightFuncTVVisibility;

    static {
        LoginModeState loginModeState = new LoginModeState("LOCATION", 0, 8, 0, 8, 8, R.string.aliuser_common_ok, 8);
        LOCATION = loginModeState;
        LoginModeState loginModeState2 = new LoginModeState("SMS_LOGIN", 1, 0, R.string.aliuser_login_sms_login, 8, 8, R.string.aliuser_signup_verification_getCode, 8);
        SMS_LOGIN = loginModeState2;
        LoginModeState loginModeState3 = new LoginModeState("PASSWORD", 2, 8, R.string.aliuser_login_pwd_login, 0, 0, R.string.aliuser_sign_in_title, 8);
        PASSWORD = loginModeState3;
        int i = R.string.aliuser_scan_login_text;
        LoginModeState loginModeState4 = new LoginModeState("SCAN_FACE", 3, 8, i, 8, 8, i, 8);
        SCAN_FACE = loginModeState4;
        LoginModeState loginModeState5 = new LoginModeState("SIM_LOGIN", 4, 0, 0, 8, 8, R.string.aliuser_agree_and_onekey_login, 0);
        SIM_LOGIN = loginModeState5;
        int i2 = R.string.aliuser_finger_button_text;
        LoginModeState loginModeState6 = new LoginModeState("BIOMETRIC", 5, 8, i2, 8, 8, i2, 8);
        BIOMETRIC = loginModeState6;
        $VALUES = new LoginModeState[]{loginModeState, loginModeState2, loginModeState3, loginModeState4, loginModeState5, loginModeState6};
    }

    private LoginModeState(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.regionTVVisibility = i2;
        this.loginModeName = i3;
        this.rightFuncTVVisibility = i4;
        this.passwordVisibility = i5;
        this.loginBtnText = i6;
        this.protocolVisibility = i7;
    }

    public static LoginModeState valueOf(String str) {
        return (LoginModeState) Enum.valueOf(LoginModeState.class, str);
    }

    public static LoginModeState[] values() {
        return (LoginModeState[]) $VALUES.clone();
    }
}
