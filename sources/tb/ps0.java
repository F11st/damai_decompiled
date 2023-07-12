package tb;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ps0 {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static final class a<T> implements Comparator {
        public static final a<T> INSTANCE = new a<>();

        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<? extends Object, l81> entry, Map.Entry<? extends Object, l81> entry2) {
            return Float.compare(entry.getValue().d(), entry2.getValue().d());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static final class b<T> implements Comparator {
        public static final b<T> INSTANCE = new b<>();

        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Map.Entry<? extends Object, l81> entry, Map.Entry<? extends Object, l81> entry2) {
            return Float.compare(entry.getValue().d(), entry2.getValue().d());
        }
    }

    public static final void a(@NotNull os0 os0Var) {
        b41.i(os0Var, "<this>");
        os0Var.Q(null);
        os0Var.H(null);
        Map<Object, l81> l = os0Var.l();
        if (l == null) {
            return;
        }
        l.clear();
    }

    @Nullable
    public static final l81 b(@NotNull os0 os0Var, @NotNull Object obj) {
        b41.i(os0Var, "<this>");
        b41.i(obj, "key");
        Map<Object, l81> l = os0Var.l();
        if (l == null) {
            return null;
        }
        return l.get(obj);
    }

    @Nullable
    public static final l81 c(@NotNull os0 os0Var) {
        b41.i(os0Var, "<this>");
        Map<Object, l81> l = os0Var.l();
        if (l == null) {
            return null;
        }
        Map.Entry entry = (Map.Entry) kotlin.collections.k.g0(l.entrySet(), a.INSTANCE);
        if (entry == null) {
            return null;
        }
        return (l81) entry.getValue();
    }

    @Nullable
    public static final l81 d(@NotNull os0 os0Var) {
        b41.i(os0Var, "<this>");
        Map<Object, l81> l = os0Var.l();
        if (l == null) {
            return null;
        }
        Map.Entry entry = (Map.Entry) kotlin.collections.k.i0(l.entrySet(), b.INSTANCE);
        if (entry == null) {
            return null;
        }
        return (l81) entry.getValue();
    }

    public static final void e(@NotNull os0 os0Var) {
        b41.i(os0Var, "<this>");
        if (os0Var.l() == null) {
            os0Var.N(new LinkedHashMap());
        }
    }

    public static final void f(@NotNull os0 os0Var) {
        b41.i(os0Var, "<this>");
        if (os0Var.m() == null) {
            os0Var.O(new LinkedHashMap());
        }
    }

    public static final boolean g(@NotNull os0 os0Var, @NotNull Object obj) {
        b41.i(os0Var, "<this>");
        b41.i(obj, "key");
        Map<Object, l81> l = os0Var.l();
        return l != null && l.containsKey(obj);
    }

    public static final boolean h(@NotNull os0 os0Var, @NotNull Object obj) {
        b41.i(os0Var, "<this>");
        b41.i(obj, "key");
        Map<Object, qr0> m = os0Var.m();
        if (m == null) {
            return false;
        }
        return m.containsKey(obj);
    }

    @Nullable
    public static final qr0 i(@NotNull os0 os0Var, @NotNull Object obj) {
        b41.i(os0Var, "<this>");
        b41.i(obj, "key");
        Map<Object, qr0> m = os0Var.m();
        qr0 remove = m == null ? null : m.remove(obj);
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("obtainNodeForScroll key=" + obj + " value=" + remove);
        }
        return remove;
    }

    public static final void j(@NotNull os0 os0Var, @NotNull Object obj, @NotNull l81 l81Var) {
        b41.i(os0Var, "<this>");
        b41.i(obj, "key");
        b41.i(l81Var, "value");
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("putLayoutForScroll key=" + obj + " value=" + l81Var);
        }
        Map<Object, l81> l = os0Var.l();
        if (l == null) {
            return;
        }
        l.put(obj, l81Var);
    }

    public static final void k(@NotNull os0 os0Var, @NotNull Object obj, @NotNull qr0 qr0Var) {
        b41.i(os0Var, "<this>");
        b41.i(obj, "key");
        b41.i(qr0Var, "value");
        Map<Object, qr0> m = os0Var.m();
        if (m != null) {
            m.put(obj, qr0Var);
        }
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a("putNodeForScroll key=" + obj + " value=" + qr0Var);
        }
    }
}
