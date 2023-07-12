package com.alibaba.security.realidentity;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum RPResult {
    AUDIT_EXCEPTION(-2, "客户端异常"),
    AUDIT_NOT(-1, "未完成认证"),
    AUDIT_IN_AUDIT(0, "认证审核中"),
    AUDIT_PASS(1, "认证通过"),
    AUDIT_FAIL(2, "认证不通过");
    
    public int code;
    public String message;

    RPResult(int i, String str) {
        this.code = i;
        this.message = str;
    }
}
