package com.squareup.okhttp.internal.http;

import anet.channel.request.a;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(a.c.PUT) || str.equals(a.c.DELETE);
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equals(a.c.DELETE);
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals(a.c.PUT) || str.equals("PATCH");
    }
}
