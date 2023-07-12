package com.alibaba.wireless.security.open.litevm;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LiteVMInstance {
    private Object a;
    private String b;
    private String c;

    public LiteVMInstance(Object obj, String str, String str2) {
        this.b = "";
        this.c = "";
        this.b = str;
        this.c = str2;
        this.a = obj;
    }

    public String getAuthCode() {
        return this.b;
    }

    public String getBizId() {
        return this.c;
    }

    public Object getImpl() {
        return this.a;
    }
}
