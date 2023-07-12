package kotlin.collections;

import java.util.Map;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class u extends z {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> b(@NotNull Map<K, V> map) {
        return w.b(map);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> c() {
        return w.c();
    }

    @PublishedApi
    public static /* bridge */ /* synthetic */ int e(int i) {
        return w.e(i);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> f(@NotNull Pair<? extends K, ? extends V> pair) {
        return w.f(pair);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> i() {
        return x.i();
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ <K, V> V j(@NotNull Map<K, ? extends V> map, K k) {
        return (V) x.j(map, k);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> v(@NotNull Map<? extends K, ? extends V> map) {
        return x.v(map);
    }
}
