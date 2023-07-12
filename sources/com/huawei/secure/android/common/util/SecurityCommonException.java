package com.huawei.secure.android.common.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SecurityCommonException extends Exception {
    private static final long c = 1;
    private String a;
    private String b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.b;
    }

    public String getRetCd() {
        return this.a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
