package com.squareup.okhttp.internal.http;

import anet.channel.request.C0193a;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(C0193a.C0196c.PUT) || str.equals(C0193a.C0196c.DELETE);
    }

    public static boolean permitsRequestBody(String str) {
        return requiresRequestBody(str) || str.equals(C0193a.C0196c.DELETE);
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals(C0193a.C0196c.PUT) || str.equals("PATCH");
    }
}
