package com.ut.mini.core.sign;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTSecurityThridRequestAuthentication implements IUTRequestAuthentication {
    private static final String TAG = "UTSecurityThridRequestAuthentication";
    private String mAppkey;
    private String mAuthcode;
    private SecuritySDK mSecuritySDK;

    public UTSecurityThridRequestAuthentication(String str, String str2) {
        this.mAppkey = null;
        this.mAuthcode = "";
        this.mSecuritySDK = null;
        this.mAppkey = str;
        this.mAuthcode = str2;
        this.mSecuritySDK = new SecuritySDK(str, str2);
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.mAppkey;
    }

    public String getAuthcode() {
        return this.mAuthcode;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        return this.mSecuritySDK.getSign(str);
    }
}
