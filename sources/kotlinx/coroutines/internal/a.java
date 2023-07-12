package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aa0;
import tb.dm;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a<T> extends kotlinx.coroutines.a<T> implements CoroutineStackFrame {
    @JvmField
    @NotNull
    public final Continuation<T> uCont;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, true);
        this.uCont = continuation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        Continuation c;
        c = IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont);
        aa0.c(c, dm.a(obj, this.uCont), null, 2, null);
    }

    @Override // kotlinx.coroutines.a
    protected void afterResume(@Nullable Object obj) {
        Continuation<T> continuation = this.uCont;
        continuation.resumeWith(dm.a(obj, continuation));
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public final CoroutineStackFrame getCallerFrame() {
        return (CoroutineStackFrame) this.uCont;
    }

    @Nullable
    public final Job getParent$kotlinx_coroutines_core() {
        return (Job) this.parentContext.get(Job.Key);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final boolean isScopedCoroutine() {
        return true;
    }
}
