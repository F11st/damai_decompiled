package com.alibaba.security.realidentity.business.dynamic.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BcConfig implements Serializable {
    private String authCode;
    private String bcContent;
    private String bcDesc;

    public String getAuthCode() {
        return this.authCode;
    }

    public String getBcContent() {
        return this.bcContent;
    }

    public String getBcDesc() {
        return this.bcDesc;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setBcContent(String str) {
        this.bcContent = str;
    }

    public void setBcDesc(String str) {
        this.bcDesc = str;
    }
}
