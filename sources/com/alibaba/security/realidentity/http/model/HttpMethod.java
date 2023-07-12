package com.alibaba.security.realidentity.http.model;

import anet.channel.request.C0193a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum HttpMethod {
    GET("GET", 1),
    POST("POST", 2),
    PUT(C0193a.C0196c.PUT, 3),
    DELETE(C0193a.C0196c.DELETE, 4),
    PATCH("PATCH", 5);
    
    private int index;
    private String name;

    HttpMethod(String str, int i) {
        this.name = str;
        this.index = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.name;
    }
}
