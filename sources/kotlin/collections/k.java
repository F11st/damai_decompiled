package kotlin.collections;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class k extends CollectionsKt___CollectionsKt {
    @NotNull
    public static /* bridge */ /* synthetic */ <T> Set<T> E0(@NotNull Iterable<? extends T> iterable) {
        return CollectionsKt___CollectionsKt.E0(iterable);
    }

    public static /* bridge */ /* synthetic */ <T> T O(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.O(iterable);
    }

    public static /* bridge */ /* synthetic */ <T> T P(@NotNull List<? extends T> list) {
        return (T) CollectionsKt___CollectionsKt.P(list);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T Q(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.Q(iterable);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T R(@NotNull List<? extends T> list) {
        return (T) CollectionsKt___CollectionsKt.R(list);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T S(@NotNull List<? extends T> list, int i) {
        return (T) CollectionsKt___CollectionsKt.S(list, i);
    }

    public static /* bridge */ /* synthetic */ Appendable X(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        Appendable W;
        W = CollectionsKt___CollectionsKt.W(iterable, appendable, (r14 & 2) != 0 ? AVFSCacheConstants.COMMA_SEP : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : function1);
        return W;
    }

    public static /* bridge */ /* synthetic */ String Z(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        return CollectionsKt___CollectionsKt.Z(iterable, charSequence, charSequence2, charSequence3, i, charSequence4, function1, i2, obj);
    }

    public static /* bridge */ /* synthetic */ <T> T a0(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.a0(iterable);
    }

    public static /* bridge */ /* synthetic */ <T> T b0(@NotNull List<? extends T> list) {
        return (T) CollectionsKt___CollectionsKt.b0(list);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T c0(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.c0(iterable);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T d0(@NotNull List<? extends T> list) {
        return (T) CollectionsKt___CollectionsKt.d0(list);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T f0(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.f0(iterable);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static /* bridge */ /* synthetic */ <T> T g0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        return (T) CollectionsKt___CollectionsKt.g0(iterable, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T h0(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.h0(iterable);
    }

    public static /* bridge */ /* synthetic */ <T> int i(@NotNull List<? extends T> list) {
        return m.i(list);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static /* bridge */ /* synthetic */ <T> T i0(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        return (T) CollectionsKt___CollectionsKt.i0(iterable, comparator);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ void p() {
        m.p();
    }

    public static /* bridge */ /* synthetic */ <T> T p0(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.p0(iterable);
    }

    @PublishedApi
    public static /* bridge */ /* synthetic */ <T> int q(@NotNull Iterable<? extends T> iterable, int i) {
        return n.q(iterable, i);
    }

    public static /* bridge */ /* synthetic */ <T> T q0(@NotNull List<? extends T> list) {
        return (T) CollectionsKt___CollectionsKt.q0(list);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T r0(@NotNull Iterable<? extends T> iterable) {
        return (T) CollectionsKt___CollectionsKt.r0(iterable);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T s0(@NotNull List<? extends T> list) {
        return (T) CollectionsKt___CollectionsKt.s0(list);
    }

    public static /* bridge */ /* synthetic */ <T> boolean v(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        return r.v(collection, iterable);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* bridge */ /* synthetic */ <T> T y(@NotNull List<T> list) {
        return (T) r.y(list);
    }
}
