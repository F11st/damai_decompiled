package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.e0 */
/* loaded from: classes3.dex */
public class C8203e0 extends C8201d0 {
    @NotNull
    public static <T> Set<T> d() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public static <T> LinkedHashSet<T> e(@NotNull T... tArr) {
        int e;
        b41.i(tArr, "elements");
        e = C8225w.e(tArr.length);
        return (LinkedHashSet) ArraysKt___ArraysKt.Q(tArr, new LinkedHashSet(e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> f(@NotNull Set<? extends T> set) {
        Set<T> d;
        Set<T> c;
        b41.i(set, "<this>");
        int size = set.size();
        if (size == 0) {
            d = d();
            return d;
        } else if (size != 1) {
            return set;
        } else {
            c = C8201d0.c(set.iterator().next());
            return c;
        }
    }

    @NotNull
    public static <T> Set<T> g(@NotNull T... tArr) {
        Set<T> d;
        Set<T> j0;
        b41.i(tArr, "elements");
        if (tArr.length > 0) {
            j0 = ArraysKt___ArraysKt.j0(tArr);
            return j0;
        }
        d = d();
        return d;
    }
}
