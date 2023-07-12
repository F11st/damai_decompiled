package com.huawei.hms.push.ups.entity;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CodeResult {
    public int a;
    public String b;

    public CodeResult() {
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.a = i;
    }

    public CodeResult(int i) {
        this.a = i;
    }

    public CodeResult(int i, String str) {
        this.a = i;
        this.b = str;
    }
}
