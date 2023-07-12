package mtopsdk.mtop.domain;

import anet.channel.request.a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum MethodEnum {
    GET("GET"),
    POST("POST"),
    HEAD(a.c.HEAD),
    PATCH("PATCH");
    
    private String method;

    MethodEnum(String str) {
        this.method = str;
    }

    public String getMethod() {
        return this.method;
    }
}
