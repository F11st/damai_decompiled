package mtopsdk.mtop.domain;

import anet.channel.request.C0193a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum MethodEnum {
    GET("GET"),
    POST("POST"),
    HEAD(C0193a.C0196c.HEAD),
    PATCH("PATCH");
    
    private String method;

    MethodEnum(String str) {
        this.method = str;
    }

    public String getMethod() {
        return this.method;
    }
}
