package com.huawei.hms.push.ups.entity;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TokenResult extends CodeResult {
    public String c;

    public TokenResult() {
    }

    public String getToken() {
        return this.c;
    }

    public void setToken(String str) {
        this.c = str;
    }

    public TokenResult(int i) {
        super(i);
    }

    public TokenResult(int i, String str) {
        super(i, str);
    }

    public TokenResult(String str) {
        this.c = str;
    }
}
