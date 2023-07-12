package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.tq2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.r */
/* loaded from: classes3.dex */
public class C8220r extends C8219q {
    public static final <T> boolean A(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        b41.i(collection, "<this>");
        b41.i(iterable, "elements");
        return tq2.a(collection).retainAll(C8211j.a(iterable, collection));
    }

    public static <T> boolean v(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        b41.i(collection, "<this>");
        b41.i(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean w(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        List d;
        b41.i(collection, "<this>");
        b41.i(tArr, "elements");
        d = C8207h.d(tArr);
        return collection.addAll(d);
    }

    private static final <T> boolean x(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T y(@NotNull List<T> list) {
        int i;
        b41.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        i = C8214m.i(list);
        return list.remove(i);
    }

    public static <T> boolean z(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        b41.i(iterable, "<this>");
        b41.i(function1, "predicate");
        return x(iterable, function1, false);
    }
}
