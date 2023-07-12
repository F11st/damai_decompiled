package com.meizu.cloud.pushsdk.c.c;

import anet.channel.request.C0193a;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.c.d */
/* loaded from: classes10.dex */
public class C5959d {
    public static boolean a(String str) {
        return "POST".equals(str) || C0193a.C0196c.PUT.equals(str) || "PATCH".equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean b(String str) {
        return a(str) || C0193a.C0196c.OPTION.equals(str) || C0193a.C0196c.DELETE.equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }
}
