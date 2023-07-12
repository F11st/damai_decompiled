package com.alibaba.security.realidentity.business.start;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ExtrasBean implements Serializable {
    private String name;
    private String sgConfig;
    private String status;

    public String getName() {
        return this.name;
    }

    public String getSgConfig() {
        return this.sgConfig;
    }

    public String getStatus() {
        return this.status;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSgConfig(String str) {
        this.sgConfig = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
