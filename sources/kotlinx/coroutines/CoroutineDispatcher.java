package kotlinx.coroutines;

import java.util.Objects;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;
import tb.n1;
import tb.o1;
import tb.o40;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class CoroutineDispatcher extends n1 implements ContinuationInterceptor {
    public static final Key Key = new Key(null);

    /* compiled from: Taobao */
    @ExperimentalStdlibApi
    /* loaded from: classes8.dex */
    public static final class Key extends o1<ContinuationInterceptor, CoroutineDispatcher> {
        public /* synthetic */ Key(k50 k50Var) {
            this();
        }

        private Key() {
            super(ContinuationInterceptor.Key, new Function1<CoroutineContext.Element, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final CoroutineDispatcher invoke(@NotNull CoroutineContext.Element element) {
                    if (!(element instanceof CoroutineDispatcher)) {
                        element = null;
                    }
                    return (CoroutineDispatcher) element;
                }
            });
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable);

    @InternalCoroutinesApi
    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // tb.n1, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) ContinuationInterceptor.a.a(this, key);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @NotNull
    public final <T> Continuation<T> interceptContinuation(@NotNull Continuation<? super T> continuation) {
        return new DispatchedContinuation(this, continuation);
    }

    public boolean isDispatchNeeded(@NotNull CoroutineContext coroutineContext) {
        return true;
    }

    @Override // tb.n1, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return ContinuationInterceptor.a.b(this, key);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @NotNull
    public final CoroutineDispatcher plus(@NotNull CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    @InternalCoroutinesApi
    public void releaseInterceptedContinuation(@NotNull Continuation<?> continuation) {
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        CancellableContinuationImpl<?> reusableCancellableContinuation = ((DispatchedContinuation) continuation).getReusableCancellableContinuation();
        if (reusableCancellableContinuation != null) {
            reusableCancellableContinuation.detachChild$kotlinx_coroutines_core();
        }
    }

    @NotNull
    public String toString() {
        return o40.a(this) + '@' + o40.b(this);
    }
}
