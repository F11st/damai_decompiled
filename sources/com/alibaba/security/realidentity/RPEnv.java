package com.alibaba.security.realidentity;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum RPEnv {
    ONLINE(0, "线上"),
    PRE(1, "预发"),
    DAILY(2, "日常");
    
    public int code;
    public String label;

    RPEnv(int i, String str) {
        this.code = i;
        this.label = str;
    }
}
