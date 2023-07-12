package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class f0 extends e0 {
    @NotNull
    public static <T> Set<T> h(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        b41.i(set, "<this>");
        b41.i(iterable, "elements");
        Collection<?> a = j.a(iterable, set);
        if (a.isEmpty()) {
            return k.E0(set);
        }
        if (a instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!a.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(a);
        return linkedHashSet2;
    }

    @NotNull
    public static <T> Set<T> i(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        int size;
        b41.i(set, "<this>");
        b41.i(iterable, "elements");
        Integer r = n.r(iterable);
        if (r != null) {
            size = set.size() + r.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(u.e(size));
        linkedHashSet.addAll(set);
        k.v(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> j(@NotNull Set<? extends T> set, T t) {
        b41.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(u.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }
}
