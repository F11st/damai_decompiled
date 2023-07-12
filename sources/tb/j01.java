package tb;

import anet.channel.request.a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class j01 {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(a.c.PUT) || str.equals(a.c.DELETE) || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return (str.equals("GET") || str.equals(a.c.HEAD)) ? false : true;
    }

    public static boolean c(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return str.equals("POST") || str.equals(a.c.PUT) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
