package com.meizu.cloud.pushsdk.c.c;

import anet.channel.request.a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d {
    public static boolean a(String str) {
        return "POST".equals(str) || a.c.PUT.equals(str) || "PATCH".equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean b(String str) {
        return a(str) || a.c.OPTION.equals(str) || a.c.DELETE.equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }
}
