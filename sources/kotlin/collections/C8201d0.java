package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.SetBuilder;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.collections.d0 */
/* loaded from: classes3.dex */
public class C8201d0 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> a(@NotNull Set<E> set) {
        b41.i(set, "builder");
        return ((SetBuilder) set).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> b(int i) {
        return new SetBuilder(i);
    }

    @NotNull
    public static <T> Set<T> c(T t) {
        Set<T> singleton = Collections.singleton(t);
        b41.h(singleton, "singleton(element)");
        return singleton;
    }
}
