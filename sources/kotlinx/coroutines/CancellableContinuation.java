package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u0006\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\tH'J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004H'J\b\u0010\u0014\u001a\u00020\rH'J\u0014\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&J1\u0010\u0019\u001a\u00020\r2'\u0010\u0018\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u0017H&J\u001b\u0010\u001b\u001a\u00020\r*\u00020\u001a2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\r*\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\tH'J<\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006$"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "value", "", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Ltb/wt2;", "onCancellation", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "token", "completeResume", "initCancellability", "", "cancel", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "isActive", "()Z", "isCompleted", "isCancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes8.dex */
public interface CancellableContinuation<T> extends Continuation<T> {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Object a(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return cancellableContinuation.tryResume(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    boolean cancel(@Nullable Throwable th);

    @InternalCoroutinesApi
    void completeResume(@NotNull Object obj);

    @InternalCoroutinesApi
    void initCancellability();

    void invokeOnCancellation(@NotNull Function1<? super Throwable, wt2> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @ExperimentalCoroutinesApi
    void resume(T t, @Nullable Function1<? super Throwable, wt2> function1);

    @ExperimentalCoroutinesApi
    void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t);

    @ExperimentalCoroutinesApi
    void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th);

    @InternalCoroutinesApi
    @Nullable
    Object tryResume(T t, @Nullable Object obj);

    @InternalCoroutinesApi
    @Nullable
    Object tryResume(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, wt2> function1);

    @InternalCoroutinesApi
    @Nullable
    Object tryResumeWithException(@NotNull Throwable th);
}
