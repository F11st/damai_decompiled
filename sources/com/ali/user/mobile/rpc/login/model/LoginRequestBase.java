package com.ali.user.mobile.rpc.login.model;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class LoginRequestBase extends MemberRequestBase {
    public String biometricId;
    public String biometricState;
    public String deviceTokenKey;
    public String deviceTokenSign;
    public String hid;
    public String sid;
    public String snsToken;
    public String supportBiometricType;
    public long t;
    public boolean useDeviceToken = true;
    public String deviceName = Build.getBRAND() + jn1.BRACKET_START_STR + Build.getMODEL() + jn1.BRACKET_END_STR;
    public boolean useAcitonType = true;
}
