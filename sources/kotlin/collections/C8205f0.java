package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.f0 */
/* loaded from: classes3.dex */
public class C8205f0 extends C8203e0 {
    @NotNull
    public static <T> Set<T> h(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        b41.i(set, "<this>");
        b41.i(iterable, "elements");
        Collection<?> a = C8211j.a(iterable, set);
        if (a.isEmpty()) {
            return C8212k.E0(set);
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
        Integer r = C8215n.r(iterable);
        if (r != null) {
            size = set.size() + r.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(C8223u.e(size));
        linkedHashSet.addAll(set);
        C8212k.v(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> j(@NotNull Set<? extends T> set, T t) {
        b41.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(C8223u.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }
}
