package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.n31;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.m */
/* loaded from: classes3.dex */
public class C8214m extends C8213l {
    @NotNull
    public static final <T> Collection<T> f(@NotNull T[] tArr) {
        b41.i(tArr, "<this>");
        return new C8200d(tArr, false);
    }

    @NotNull
    public static <T> List<T> g() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static n31 h(@NotNull Collection<?> collection) {
        b41.i(collection, "<this>");
        return new n31(0, collection.size() - 1);
    }

    public static <T> int i(@NotNull List<? extends T> list) {
        b41.i(list, "<this>");
        return list.size() - 1;
    }

    @NotNull
    public static <T> List<T> j(@NotNull T... tArr) {
        List<T> g;
        List<T> d;
        b41.i(tArr, "elements");
        if (tArr.length > 0) {
            d = C8207h.d(tArr);
            return d;
        }
        g = g();
        return g;
    }

    @NotNull
    public static <T> List<T> k(@Nullable T t) {
        List<T> g;
        List<T> e;
        if (t != null) {
            e = C8213l.e(t);
            return e;
        }
        g = g();
        return g;
    }

    @NotNull
    public static <T> List<T> l(@NotNull T... tArr) {
        List<T> s;
        b41.i(tArr, "elements");
        s = ArraysKt___ArraysKt.s(tArr);
        return s;
    }

    @NotNull
    public static <T> List<T> m(@NotNull T... tArr) {
        b41.i(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C8200d(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> n(@NotNull List<? extends T> list) {
        List<T> g;
        List<T> e;
        b41.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            g = g();
            return g;
        } else if (size != 1) {
            return list;
        } else {
            e = C8213l.e(list.get(0));
            return e;
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void o() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void p() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
