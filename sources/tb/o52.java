package tb;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.3")
@PublishedApi
/* loaded from: classes3.dex */
public final class o52<T> implements Continuation<T>, CoroutineStackFrame {
    @Deprecated
    private static final AtomicReferenceFieldUpdater<o52<?>, Object> b;
    @NotNull
    private final Continuation<T> a;
    @Nullable
    private volatile Object result;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        new a(null);
        b = AtomicReferenceFieldUpdater.newUpdater(o52.class, Object.class, "result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o52(@NotNull Continuation<? super T> continuation, @Nullable Object obj) {
        b41.i(continuation, "delegate");
        this.a = continuation;
        this.result = obj;
    }

    @PublishedApi
    @Nullable
    public final Object a() {
        Object d;
        Object d2;
        Object d3;
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            AtomicReferenceFieldUpdater<o52<?>, Object> atomicReferenceFieldUpdater = b;
            d2 = kotlin.coroutines.intrinsics.b.d();
            if (atomicReferenceFieldUpdater.compareAndSet(this, coroutineSingletons, d2)) {
                d3 = kotlin.coroutines.intrinsics.b.d();
                return d3;
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            d = kotlin.coroutines.intrinsics.b.d();
            return d;
        } else if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        } else {
            return obj;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.a.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        Object d;
        Object d2;
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 != coroutineSingletons) {
                d = kotlin.coroutines.intrinsics.b.d();
                if (obj2 != d) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater<o52<?>, Object> atomicReferenceFieldUpdater = b;
                d2 = kotlin.coroutines.intrinsics.b.d();
                if (atomicReferenceFieldUpdater.compareAndSet(this, d2, CoroutineSingletons.RESUMED)) {
                    this.a.resumeWith(obj);
                    return;
                }
            } else if (b.compareAndSet(this, coroutineSingletons, obj)) {
                return;
            }
        }
    }

    @NotNull
    public String toString() {
        return "SafeContinuation for " + this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public o52(@NotNull Continuation<? super T> continuation) {
        this(continuation, CoroutineSingletons.UNDECIDED);
        b41.i(continuation, "delegate");
    }
}
