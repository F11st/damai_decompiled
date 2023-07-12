package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class e {
    @NotNull
    public static final Job a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super wt2>, ? extends Object> function2) {
        return g.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T c(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) f.a(coroutineContext, function2);
    }

    @Nullable
    public static final <T> Object e(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return g.c(coroutineContext, function2, continuation);
    }
}
