package kotlin.sequences;

import java.util.List;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pa2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class d extends SequencesKt___SequencesKt {
    @NotNull
    public static /* bridge */ /* synthetic */ <T> List<T> B(@NotNull Sequence<? extends T> sequence) {
        return SequencesKt___SequencesKt.B(sequence);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ <T> Sequence<T> b(@BuilderInference @NotNull Function2<? super pa2<? super T>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        return e.b(function2);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <T> Sequence<T> e() {
        return SequencesKt__SequencesKt.e();
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static /* bridge */ /* synthetic */ <T> Sequence<T> h(@Nullable T t, @NotNull Function1<? super T, ? extends T> function1) {
        return SequencesKt__SequencesKt.h(t, function1);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <T> Sequence<T> j(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        return SequencesKt__SequencesKt.j(function0, function1);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <T> Iterable<T> l(@NotNull Sequence<? extends T> sequence) {
        return SequencesKt___SequencesKt.l(sequence);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <T> Sequence<T> n(@NotNull Sequence<? extends T> sequence, int i) {
        return SequencesKt___SequencesKt.n(sequence, i);
    }

    public static /* bridge */ /* synthetic */ <T> T r(@NotNull Sequence<? extends T> sequence) {
        return (T) SequencesKt___SequencesKt.r(sequence);
    }

    @Nullable
    public static /* bridge */ /* synthetic */ <T> T s(@NotNull Sequence<? extends T> sequence) {
        return (T) SequencesKt___SequencesKt.s(sequence);
    }

    public static /* bridge */ /* synthetic */ <T> T u(@NotNull Sequence<? extends T> sequence) {
        return (T) SequencesKt___SequencesKt.u(sequence);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ <T, R> Sequence<R> v(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends R> function1) {
        return SequencesKt___SequencesKt.v(sequence, function1);
    }
}
