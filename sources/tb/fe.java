package tb;

import com.taobao.aranger.constant.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class fe {
    @NotNull
    public static final fe INSTANCE = new fe();
    @NotNull
    private static final Map<hp0, ni1> a;
    @NotNull
    private static final Map<ni1, List<ni1>> b;
    @NotNull
    private static final Set<hp0> c;
    @NotNull
    private static final Set<ni1> d;

    static {
        hp0 d2;
        hp0 d3;
        hp0 c2;
        hp0 c3;
        hp0 d4;
        hp0 c4;
        hp0 c5;
        hp0 c6;
        Map<hp0, ni1> l;
        int q;
        int e;
        int q2;
        Set<ni1> E0;
        List K;
        ip0 ip0Var = c.a._enum;
        d2 = ge.d(ip0Var, "name");
        d3 = ge.d(ip0Var, "ordinal");
        c2 = ge.c(c.a.collection, "size");
        hp0 hp0Var = c.a.map;
        c3 = ge.c(hp0Var, "size");
        d4 = ge.d(c.a.charSequence, "length");
        c4 = ge.c(hp0Var, Constants.PARAM_KEYS);
        c5 = ge.c(hp0Var, "values");
        c6 = ge.c(hp0Var, "entries");
        l = kotlin.collections.x.l(hq2.a(d2, ni1.f("name")), hq2.a(d3, ni1.f("ordinal")), hq2.a(c2, ni1.f("size")), hq2.a(c3, ni1.f("size")), hq2.a(d4, ni1.f("length")), hq2.a(c4, ni1.f("keySet")), hq2.a(c5, ni1.f("values")), hq2.a(c6, ni1.f("entrySet")));
        a = l;
        Set<Map.Entry<hp0, ni1>> entrySet = l.entrySet();
        q = kotlin.collections.n.q(entrySet, 10);
        ArrayList<Pair> arrayList = new ArrayList(q);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((hp0) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            ni1 ni1Var = (ni1) pair.getSecond();
            Object obj = linkedHashMap.get(ni1Var);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(ni1Var, obj);
            }
            ((List) obj).add((ni1) pair.getFirst());
        }
        e = kotlin.collections.w.e(linkedHashMap.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(e);
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            K = CollectionsKt___CollectionsKt.K((Iterable) entry2.getValue());
            linkedHashMap2.put(key, K);
        }
        b = linkedHashMap2;
        Set<hp0> keySet = a.keySet();
        c = keySet;
        q2 = kotlin.collections.n.q(keySet, 10);
        ArrayList arrayList2 = new ArrayList(q2);
        for (hp0 hp0Var2 : keySet) {
            arrayList2.add(hp0Var2.g());
        }
        E0 = CollectionsKt___CollectionsKt.E0(arrayList2);
        d = E0;
    }

    private fe() {
    }

    @NotNull
    public final Map<hp0, ni1> a() {
        return a;
    }

    @NotNull
    public final List<ni1> b(@NotNull ni1 ni1Var) {
        List<ni1> g;
        b41.i(ni1Var, "name1");
        List<ni1> list = b.get(ni1Var);
        if (list == null) {
            g = kotlin.collections.m.g();
            return g;
        }
        return list;
    }

    @NotNull
    public final Set<hp0> c() {
        return c;
    }

    @NotNull
    public final Set<ni1> d() {
        return d;
    }
}
