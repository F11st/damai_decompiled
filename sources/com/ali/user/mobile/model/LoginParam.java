package com.ali.user.mobile.model;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginParam implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public boolean alipayInstalled;
    public String bindProtocolUrl;
    public String biometricId;
    public boolean callRpc;
    public String codeLength;
    public String countryCode;
    public String deviceTokenKey;
    public String errorCode;
    public Map<String, String> externParams;
    public String h5QueryString;
    public long havanaId;
    public String headImg;
    public String helpUrl;
    public boolean isFoundPassword;
    public boolean isFromRegister;
    public String loginAccount;
    public String loginPassword;
    public int loginSite;
    public String loginSourcePage;
    public String loginSourceSpm;
    public String loginSourceType;
    public String loginType;
    public String nativeLoginType;
    public String phoneCode;
    public RegionInfo regionInfo;
    public String scene;
    public boolean sendLoginFailWhenWebviewCancel;
    public String smsCode;
    public String smsSid;
    public String snsToken;
    public String snsType;
    public String source;
    public String spm;
    public String token;
    public String traceId;
    public String tokenType = TokenType.LOGIN;
    public boolean isFromAccount = false;
    public boolean enableVoiceSMS = false;
    public boolean supportOverseaMobile = true;
    public boolean goSMS = true;

    /* renamed from: clone */
    public LoginParam m104clone() {
        try {
            return (LoginParam) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
