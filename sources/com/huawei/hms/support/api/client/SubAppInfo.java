package com.huawei.hms.support.api.client;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SubAppInfo {
    private String a;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.a = subAppInfo.getSubAppID();
        }
    }

    public String getSubAppID() {
        return this.a;
    }

    public void setSubAppInfoID(String str) {
        this.a = str;
    }

    public SubAppInfo(String str) {
        this.a = str;
    }
}
