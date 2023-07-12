package tb;

import java.util.Iterator;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@RestrictsSuspension
/* loaded from: classes3.dex */
public abstract class pa2<T> {
    @Nullable
    public abstract Object a(T t, @NotNull Continuation<? super wt2> continuation);

    @Nullable
    public abstract Object b(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super wt2> continuation);

    @Nullable
    public final Object c(@NotNull Sequence<? extends T> sequence, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object b = b(sequence.iterator(), continuation);
        d = C8234b.d();
        return b == d ? b : wt2.INSTANCE;
    }
}
