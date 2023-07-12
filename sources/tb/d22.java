package tb;

import java.net.Proxy;
import okhttp3.C8818m;
import okhttp3.C8823o;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class d22 {
    public static String a(C8823o c8823o, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(c8823o.g());
        sb.append(' ');
        if (b(c8823o, type)) {
            sb.append(c8823o.i());
        } else {
            sb.append(c(c8823o.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(C8823o c8823o, Proxy.Type type) {
        return !c8823o.f() && type == Proxy.Type.HTTP;
    }

    public static String c(C8818m c8818m) {
        String h = c8818m.h();
        String j = c8818m.j();
        if (j != null) {
            return h + jn1.CONDITION_IF + j;
        }
        return h;
    }
}
