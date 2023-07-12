package com.alibaba.security.realidentity.http.model;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ContentType {
    JSON("application/json"),
    FORM("multipart/form-data");
    
    public String name;

    ContentType(String str) {
        this.name = str;
    }
}
