package tb;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class q12 {
    @NotNull
    public static final String a(@NotNull ip0 ip0Var) {
        b41.i(ip0Var, "<this>");
        List<ni1> h = ip0Var.h();
        b41.h(h, "pathSegments()");
        return c(h);
    }

    @NotNull
    public static final String b(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "<this>");
        if (!d(ni1Var)) {
            String b = ni1Var.b();
            b41.h(b, "asString()");
            return b;
        }
        String b2 = ni1Var.b();
        b41.h(b2, "asString()");
        return b41.r(String.valueOf('`') + b2, "`");
    }

    @NotNull
    public static final String c(@NotNull List<ni1> list) {
        b41.i(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (ni1 ni1Var : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(ni1Var));
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final boolean d(ni1 ni1Var) {
        boolean z;
        if (ni1Var.g()) {
            return false;
        }
        String b = ni1Var.b();
        b41.h(b, "asString()");
        if (!v71.KEYWORDS.contains(b)) {
            int i = 0;
            while (true) {
                if (i >= b.length()) {
                    z = false;
                    break;
                }
                char charAt = b.charAt(i);
                if ((Character.isLetterOrDigit(charAt) || charAt == '_') ? false : true) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }
}
