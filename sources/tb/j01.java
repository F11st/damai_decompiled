package tb;

import anet.channel.request.C0193a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class j01 {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(C0193a.C0196c.PUT) || str.equals(C0193a.C0196c.DELETE) || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return (str.equals("GET") || str.equals(C0193a.C0196c.HEAD)) ? false : true;
    }

    public static boolean c(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return str.equals("POST") || str.equals(C0193a.C0196c.PUT) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
