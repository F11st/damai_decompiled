package tb;

import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class zw1 {
    @NotNull
    public static final List<ni1> a(@NotNull ni1 ni1Var) {
        List<ni1> k;
        b41.i(ni1Var, "name");
        String b = ni1Var.b();
        b41.h(b, "name.asString()");
        if (n61.b(b)) {
            k = kotlin.collections.m.k(b(ni1Var));
            return k;
        } else if (n61.c(b)) {
            return f(ni1Var);
        } else {
            return fe.INSTANCE.b(ni1Var);
        }
    }

    @Nullable
    public static final ni1 b(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "methodName");
        ni1 e = e(ni1Var, gn1.TYPE_OPEN_URL_METHOD_GET, false, null, 12, null);
        return e == null ? e(ni1Var, "is", false, null, 8, null) : e;
    }

    @Nullable
    public static final ni1 c(@NotNull ni1 ni1Var, boolean z) {
        b41.i(ni1Var, "methodName");
        return e(ni1Var, "set", false, z ? "is" : null, 4, null);
    }

    private static final ni1 d(ni1 ni1Var, String str, boolean z, String str2) {
        boolean F;
        String o0;
        String o02;
        if (ni1Var.g()) {
            return null;
        }
        String d = ni1Var.d();
        b41.h(d, "methodName.identifier");
        boolean z2 = false;
        F = kotlin.text.o.F(d, str, false, 2, null);
        if (F && d.length() != str.length()) {
            char charAt = d.charAt(str.length());
            if ('a' <= charAt && charAt <= 'z') {
                z2 = true;
            }
            if (z2) {
                return null;
            }
            if (str2 != null) {
                o02 = StringsKt__StringsKt.o0(d, str);
                return ni1.f(b41.r(str2, o02));
            } else if (z) {
                o0 = StringsKt__StringsKt.o0(d, str);
                String c = jg.c(o0, true);
                if (ni1.h(c)) {
                    return ni1.f(c);
                }
                return null;
            } else {
                return ni1Var;
            }
        }
        return null;
    }

    static /* synthetic */ ni1 e(ni1 ni1Var, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return d(ni1Var, str, z, str2);
    }

    @NotNull
    public static final List<ni1> f(@NotNull ni1 ni1Var) {
        List<ni1> l;
        b41.i(ni1Var, "methodName");
        l = kotlin.collections.m.l(c(ni1Var, false), c(ni1Var, true));
        return l;
    }
}
