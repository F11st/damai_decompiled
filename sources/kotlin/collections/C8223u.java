package kotlin.collections;

import java.util.Map;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: kotlin.collections.u */
/* loaded from: classes3.dex */
public final class C8223u extends C8228z {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> b(@NotNull Map<K, V> map) {
        return C8225w.b(map);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> c() {
        return C8225w.c();
    }

    @PublishedApi
    public static /* bridge */ /* synthetic */ int e(int i) {
        return C8225w.e(i);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> f(@NotNull Pair<? extends K, ? extends V> pair) {
        return C8225w.f(pair);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> i() {
        return C8226x.i();
    }

    @SinceKotlin(version = "1.1")
    public static /* bridge */ /* synthetic */ <K, V> V j(@NotNull Map<K, ? extends V> map, K k) {
        return (V) C8226x.j(map, k);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static /* bridge */ /* synthetic */ <K, V> Map<K, V> v(@NotNull Map<? extends K, ? extends V> map) {
        return C8226x.v(map);
    }
}
