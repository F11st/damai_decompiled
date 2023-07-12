package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.ListBuilder;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.l */
/* loaded from: classes3.dex */
public class C8213l {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> a(@NotNull List<E> list) {
        b41.i(list, "builder");
        return ((ListBuilder) list).build();
    }

    @NotNull
    public static final <T> Object[] b(@NotNull T[] tArr, boolean z) {
        b41.i(tArr, "<this>");
        if (z && b41.d(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        b41.h(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> c() {
        return new ListBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> d(int i) {
        return new ListBuilder(i);
    }

    @NotNull
    public static <T> List<T> e(T t) {
        List<T> singletonList = Collections.singletonList(t);
        b41.h(singletonList, "singletonList(element)");
        return singletonList;
    }
}
