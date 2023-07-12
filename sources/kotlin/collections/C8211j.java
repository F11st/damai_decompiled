package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ik;

/* compiled from: Taobao */
/* renamed from: kotlin.collections.j */
/* loaded from: classes3.dex */
public final class C8211j {
    @NotNull
    public static final <T> Collection<T> a(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        List A0;
        b41.i(iterable, "<this>");
        b41.i(iterable2, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (iterable instanceof Collection) {
            if (!(iterable2 instanceof Collection) || ((Collection) iterable2).size() >= 2) {
                Collection<T> collection = (Collection) iterable;
                return b(collection) ? CollectionsKt___CollectionsKt.y0(iterable) : collection;
            }
            return (Collection) iterable;
        } else if (ik.brittleContainsOptimizationEnabled) {
            return CollectionsKt___CollectionsKt.y0(iterable);
        } else {
            A0 = CollectionsKt___CollectionsKt.A0(iterable);
            return A0;
        }
    }

    private static final <T> boolean b(Collection<? extends T> collection) {
        return ik.brittleContainsOptimizationEnabled && collection.size() > 2 && (collection instanceof ArrayList);
    }
}
