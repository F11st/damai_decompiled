package com.alibaba.security.realidentity.business.dynamic.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CtidConfig implements Serializable {
    private String androidAppId;
    private String iosAppId;
    private String orgId;
    private int type;

    public String getAndroidAppId() {
        return this.androidAppId;
    }

    public String getIosAppId() {
        return this.iosAppId;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public int getType() {
        return this.type;
    }

    public void setAndroidAppId(String str) {
        this.androidAppId = str;
    }

    public void setIosAppId(String str) {
        this.iosAppId = str;
    }

    public void setOrgId(String str) {
        this.orgId = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
