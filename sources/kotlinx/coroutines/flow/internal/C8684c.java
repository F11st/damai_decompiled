package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.internal.c */
/* loaded from: classes11.dex */
final class C8684c<T> implements Continuation<T>, CoroutineStackFrame {
    private final Continuation<T> a;
    @NotNull
    private final CoroutineContext b;

    /* JADX WARN: Multi-variable type inference failed */
    public C8684c(@NotNull Continuation<? super T> continuation, @NotNull CoroutineContext coroutineContext) {
        this.a = continuation;
        this.b = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.a;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.b;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        this.a.resumeWith(obj);
    }
}
