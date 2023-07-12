package com.alibaba.security.realidentity.http.model;

import anet.channel.request.a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum HttpMethod {
    GET("GET", 1),
    POST("POST", 2),
    PUT(a.c.PUT, 3),
    DELETE(a.c.DELETE, 4),
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
