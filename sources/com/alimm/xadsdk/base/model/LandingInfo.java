package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class LandingInfo implements BaseInfo {
    @JSONField(name = "open_type")
    private int mType;
    @JSONField(name = "url")
    private String mUrl;

    public LandingInfo() {
    }

    public LandingInfo(int i, String str) {
        this.mType = i;
        this.mUrl = str;
    }

    public int getType() {
        return this.mType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public LandingInfo setType(int i) {
        this.mType = i;
        return this;
    }

    public LandingInfo setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public String toString() {
        return "LandingInfo{type=" + this.mType + ", url=" + this.mUrl + "}";
    }
}
