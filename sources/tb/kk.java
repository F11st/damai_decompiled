package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.C8212k;
import kotlin.collections.C8213l;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class kk {
    public static final <T> void a(@NotNull Collection<T> collection, @Nullable T t) {
        b41.i(collection, "<this>");
        if (t != null) {
            collection.add(t);
        }
    }

    private static final int b(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    @NotNull
    public static final <T> List<T> c(@NotNull ArrayList<T> arrayList) {
        List<T> g;
        List<T> e;
        b41.i(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            g = C8214m.g();
            return g;
        } else if (size != 1) {
            arrayList.trimToSize();
            return arrayList;
        } else {
            e = C8213l.e(C8212k.P(arrayList));
            return e;
        }
    }

    @NotNull
    public static final <K> Map<K, Integer> d(@NotNull Iterable<? extends K> iterable) {
        b41.i(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (K k : iterable) {
            linkedHashMap.put(k, Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> HashMap<K, V> e(int i) {
        return new HashMap<>(b(i));
    }

    @NotNull
    public static final <E> HashSet<E> f(int i) {
        return new HashSet<>(b(i));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> g(int i) {
        return new LinkedHashSet<>(b(i));
    }
}
