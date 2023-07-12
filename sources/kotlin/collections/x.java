package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class x extends w {
    @NotNull
    public static <K, V> Map<K, V> i() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        b41.g(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @SinceKotlin(version = "1.1")
    public static <K, V> V j(@NotNull Map<K, ? extends V> map, K k) {
        b41.i(map, "<this>");
        return (V) v.a(map, k);
    }

    @NotNull
    public static <K, V> HashMap<K, V> k(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        b41.i(pairArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(u.e(pairArr.length));
        q(hashMap, pairArr);
        return hashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> l(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        b41.i(pairArr, "pairs");
        return pairArr.length > 0 ? u(pairArr, new LinkedHashMap(u.e(pairArr.length))) : u.i();
    }

    @NotNull
    public static <K, V> Map<K, V> m(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        b41.i(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.e(pairArr.length));
        q(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> n(@NotNull Map<K, ? extends V> map) {
        b41.i(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : w.g(map);
        }
        return u.i();
    }

    @NotNull
    public static <K, V> Map<K, V> o(@NotNull Map<? extends K, ? extends V> map, @NotNull Map<? extends K, ? extends V> map2) {
        b41.i(map, "<this>");
        b41.i(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void p(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        b41.i(map, "<this>");
        b41.i(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static final <K, V> void q(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        b41.i(map, "<this>");
        b41.i(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> r(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        b41.i(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return s(iterable, new LinkedHashMap(u.e(collection.size())));
                }
                return u.f(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            return u.i();
        }
        return n(s(iterable, new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M s(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M m) {
        b41.i(iterable, "<this>");
        b41.i(m, "destination");
        p(m, iterable);
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> t(@NotNull Map<? extends K, ? extends V> map) {
        b41.i(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                return u.v(map);
            }
            return w.g(map);
        }
        return u.i();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M u(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M m) {
        b41.i(pairArr, "<this>");
        b41.i(m, "destination");
        q(m, pairArr);
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <K, V> Map<K, V> v(@NotNull Map<? extends K, ? extends V> map) {
        b41.i(map, "<this>");
        return new LinkedHashMap(map);
    }
}
