package com.youku.usercenter.passport.result;

import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LoginRequestBase extends MemberRequestBase {
    public String deviceTokenKey;
    public String deviceTokenSign;
    public String hid;
    public String sid;
    public String snsToken;
    public long t;
    public boolean useDeviceToken = true;
    public String deviceName = Build.getBRAND() + jn1.BRACKET_START_STR + Build.getMODEL() + jn1.BRACKET_END_STR;
    public boolean useAcitonType = true;
}
