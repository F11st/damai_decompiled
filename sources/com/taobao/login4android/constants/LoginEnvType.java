package com.taobao.login4android.constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum LoginEnvType {
    ONLINE(3),
    PRE(2),
    DEV(1);
    
    private int aliuserSdkEvnType;

    LoginEnvType(int i) {
        this.aliuserSdkEvnType = 3;
        this.aliuserSdkEvnType = i;
    }

    public static LoginEnvType getType(int i) {
        LoginEnvType[] values;
        for (LoginEnvType loginEnvType : values()) {
            if (loginEnvType.aliuserSdkEvnType == i) {
                return loginEnvType;
            }
        }
        return ONLINE;
    }

    public int getSdkEnvType() {
        return this.aliuserSdkEvnType;
    }
}
