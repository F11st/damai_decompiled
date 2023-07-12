package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AbsHttpResponse extends HttpResponse {
    protected String retCode;
    protected String retMsg;

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetMsg(String str) {
        this.retMsg = str;
    }
}
