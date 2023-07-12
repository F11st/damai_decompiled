package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i21;
import tb.wt2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.channels.b */
/* loaded from: classes9.dex */
public final class C8648b {
    @NotNull
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object A(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.A(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object B(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.B(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object C(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.C(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object D(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.D(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object E(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.E(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object F(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.F(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R> Object G(@NotNull ReceiveChannel<? extends E> receiveChannel, R r, @NotNull Function2<? super R, ? super E, ? extends R> function2, @NotNull Continuation<? super R> continuation) {
        return ChannelsKt__Channels_commonKt.G(receiveChannel, r, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R> Object H(@NotNull ReceiveChannel<? extends E> receiveChannel, R r, @NotNull Function3<? super Integer, ? super R, ? super E, ? extends R> function3, @NotNull Continuation<? super R> continuation) {
        return ChannelsKt__Channels_commonKt.H(receiveChannel, r, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K> Object I(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends K> function1, @NotNull Continuation<? super Map<K, ? extends List<? extends E>>> continuation) {
        return ChannelsKt__Channels_commonKt.I(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, V> Object J(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends K> function1, @NotNull Function1<? super E, ? extends V> function12, @NotNull Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        return ChannelsKt__Channels_commonKt.J(receiveChannel, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, M extends Map<? super K, List<E>>> Object K(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull M m, @NotNull Function1<? super E, ? extends K> function1, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.K(receiveChannel, m, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, V, M extends Map<? super K, List<V>>> Object L(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull M m, @NotNull Function1<? super E, ? extends K> function1, @NotNull Function1<? super E, ? extends V> function12, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.L(receiveChannel, m, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object M(@NotNull ReceiveChannel<? extends E> receiveChannel, E e, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.M(receiveChannel, e, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object N(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.N(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object O(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.O(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object P(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.P(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object Q(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.Q(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object R(@NotNull ReceiveChannel<? extends E> receiveChannel, E e, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.R(receiveChannel, e, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object S(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.S(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object T(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.T(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends Collection<? super R>> Object U(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function2<? super Integer, ? super E, ? extends R> function2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.U(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends SendChannel<? super R>> Object V(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function2<? super Integer, ? super E, ? extends R> function2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.V(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends Collection<? super R>> Object W(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function2<? super Integer, ? super E, ? extends R> function2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.W(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends SendChannel<? super R>> Object X(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function2<? super Integer, ? super E, ? extends R> function2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.X(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends Collection<? super R>> Object Y(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, ? extends R> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.Y(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends SendChannel<? super R>> Object Z(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, ? extends R> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.Z(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object a(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.a(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends Collection<? super R>> Object a0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, ? extends R> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.a0(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object b(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.b(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R, C extends SendChannel<? super R>> Object b0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, ? extends R> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.b0(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object c(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.c(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R extends Comparable<? super R>> Object c0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends R> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.c0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, V> Object d(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, @NotNull Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object d0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Comparator<? super E> comparator, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.d0(receiveChannel, comparator, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K> Object e(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends K> function1, @NotNull Continuation<? super Map<K, ? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.e(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, R extends Comparable<? super R>> Object e0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends R> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.e0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, V> Object f(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, ? extends K> function1, @NotNull Function1<? super E, ? extends V> function12, @NotNull Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.f(receiveChannel, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object f0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Comparator<? super E> comparator, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.f0(receiveChannel, comparator, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, M extends Map<? super K, ? super E>> Object g(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull M m, @NotNull Function1<? super E, ? extends K> function1, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.g(receiveChannel, m, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object g0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.g0(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object h(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull M m, @NotNull Function1<? super E, ? extends K> function1, @NotNull Function1<? super E, ? extends V> function12, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.h(receiveChannel, m, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object h0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.h0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object i(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull M m, @NotNull Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.i(receiveChannel, m, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object i0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> continuation) {
        return ChannelsKt__Channels_commonKt.i0(receiveChannel, function1, continuation);
    }

    @PublishedApi
    public static final void j(@NotNull ReceiveChannel<?> receiveChannel, @Nullable Throwable th) {
        ChannelsKt__Channels_commonKt.j(receiveChannel, th);
    }

    @ExperimentalCoroutinesApi
    @Nullable
    public static final <E> Object j0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.j0(receiveChannel, continuation);
    }

    @ObsoleteCoroutinesApi
    @Nullable
    public static final <E> Object k(@NotNull BroadcastChannel<E> broadcastChannel, @NotNull Function1<? super E, wt2> function1, @NotNull Continuation<? super wt2> continuation) {
        return ChannelsKt__Channels_commonKt.k(broadcastChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <S, E extends S> Object k0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function2<? super S, ? super E, ? extends S> function2, @NotNull Continuation<? super S> continuation) {
        return ChannelsKt__Channels_commonKt.k0(receiveChannel, function2, continuation);
    }

    @Nullable
    public static final <E> Object l(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, wt2> function1, @NotNull Continuation<? super wt2> continuation) {
        return ChannelsKt__Channels_commonKt.l(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <S, E extends S> Object l0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function3<? super Integer, ? super S, ? super E, ? extends S> function3, @NotNull Continuation<? super S> continuation) {
        return ChannelsKt__Channels_commonKt.l0(receiveChannel, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object m(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super i21<? extends E>, wt2> function1, @NotNull Continuation<? super wt2> continuation) {
        return ChannelsKt__Channels_commonKt.m(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object m0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.m0(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object n(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.n(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object n0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.n0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object o(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.o(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object o0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.o0(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object p(@NotNull ReceiveChannel<? extends E> receiveChannel, int i, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.p(receiveChannel, i, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object p0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.p0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object q(@NotNull ReceiveChannel<? extends E> receiveChannel, int i, @NotNull Function1<? super Integer, ? extends E> function1, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.q(receiveChannel, i, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object q0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Integer> function1, @NotNull Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.q0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object r(@NotNull ReceiveChannel<? extends E> receiveChannel, int i, @NotNull Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.r(receiveChannel, i, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E> Object r0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull Function1<? super E, Double> function1, @NotNull Continuation<? super Double> continuation) {
        return ChannelsKt__Channels_commonKt.r0(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends Collection<? super E>> Object s(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function2<? super Integer, ? super E, Boolean> function2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.s(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object s0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.s0(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object t(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function2<? super Integer, ? super E, Boolean> function2, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.t(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends Collection<? super E>> Object t0(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.t0(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends Collection<? super E>> Object u(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.u(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <K, V, M extends Map<? super K, ? super V>> Object u0(@NotNull ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @NotNull M m, @NotNull Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.u0(receiveChannel, m, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object v(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.v(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends Collection<? super E>> Object w(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.w(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object x(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.x(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends Collection<? super E>> Object y(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.y(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4.x")
    @Nullable
    public static final <E, C extends SendChannel<? super E>> Object z(@NotNull ReceiveChannel<? extends E> receiveChannel, @NotNull C c, @NotNull Function1<? super E, Boolean> function1, @NotNull Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.z(receiveChannel, c, function1, continuation);
    }
}
