package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class bf2 {
    @Nullable
    public static final m0 a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        if (f instanceof m0) {
            return (m0) f;
        }
        return null;
    }

    @Nullable
    public static final fd2 b(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        m0 a = a(z71Var);
        if (a == null) {
            return null;
        }
        return a.o();
    }

    public static final boolean c(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return z71Var.f() instanceof j60;
    }

    private static final IntersectionTypeConstructor d(IntersectionTypeConstructor intersectionTypeConstructor) {
        int q;
        z71 z71Var;
        Collection<z71> supertypes = intersectionTypeConstructor.getSupertypes();
        q = kotlin.collections.n.q(supertypes, 10);
        ArrayList arrayList = new ArrayList(q);
        Iterator<T> it = supertypes.iterator();
        boolean z = false;
        while (true) {
            z71Var = null;
            if (!it.hasNext()) {
                break;
            }
            z71 z71Var2 = (z71) it.next();
            if (fr2.m(z71Var2)) {
                z71Var2 = f(z71Var2.f(), false, 1, null);
                z = true;
            }
            arrayList.add(z71Var2);
        }
        if (z) {
            z71 c = intersectionTypeConstructor.c();
            if (c != null) {
                if (fr2.m(c)) {
                    c = f(c.f(), false, 1, null);
                }
                z71Var = c;
            }
            return new IntersectionTypeConstructor(arrayList).g(z71Var);
        }
        return null;
    }

    @NotNull
    public static final gu2 e(@NotNull gu2 gu2Var, boolean z) {
        b41.i(gu2Var, "<this>");
        j60 b = j60.Companion.b(gu2Var, z);
        if (b == null) {
            fd2 g = g(gu2Var);
            return g == null ? gu2Var.g(false) : g;
        }
        return b;
    }

    public static /* synthetic */ gu2 f(gu2 gu2Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return e(gu2Var, z);
    }

    private static final fd2 g(z71 z71Var) {
        IntersectionTypeConstructor d;
        TypeConstructor c = z71Var.c();
        IntersectionTypeConstructor intersectionTypeConstructor = c instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) c : null;
        if (intersectionTypeConstructor == null || (d = d(intersectionTypeConstructor)) == null) {
            return null;
        }
        return d.b();
    }

    @NotNull
    public static final fd2 h(@NotNull fd2 fd2Var, boolean z) {
        b41.i(fd2Var, "<this>");
        j60 b = j60.Companion.b(fd2Var, z);
        if (b == null) {
            fd2 g = g(fd2Var);
            return g == null ? fd2Var.j(false) : g;
        }
        return b;
    }

    public static /* synthetic */ fd2 i(fd2 fd2Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return h(fd2Var, z);
    }

    @NotNull
    public static final fd2 j(@NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        b41.i(fd2Var, "<this>");
        b41.i(fd2Var2, "abbreviatedType");
        return a81.a(fd2Var) ? fd2Var : new m0(fd2Var, fd2Var2);
    }

    @NotNull
    public static final zj1 k(@NotNull zj1 zj1Var) {
        b41.i(zj1Var, "<this>");
        return new zj1(zj1Var.l(), zj1Var.c(), zj1Var.n(), zj1Var.getAnnotations(), zj1Var.d(), true);
    }
}
