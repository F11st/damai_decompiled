package tb;

import java.net.Proxy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class d22 {
    public static String a(okhttp3.o oVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(oVar.g());
        sb.append(' ');
        if (b(oVar, type)) {
            sb.append(oVar.i());
        } else {
            sb.append(c(oVar.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(okhttp3.o oVar, Proxy.Type type) {
        return !oVar.f() && type == Proxy.Type.HTTP;
    }

    public static String c(okhttp3.m mVar) {
        String h = mVar.h();
        String j = mVar.j();
        if (j != null) {
            return h + jn1.CONDITION_IF + j;
        }
        return h;
    }
}
