package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ag;
import tb.b41;
import tb.f61;
import tb.id;
import tb.jn1;
import tb.n40;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.c */
/* loaded from: classes8.dex */
public final class C8623c<T> {
    static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(C8623c.class, "notCompletedCount");
    private final Deferred<T>[] a;
    volatile int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.c$a */
    /* loaded from: classes8.dex */
    public final class C8624a extends f61<Job> {
        private volatile Object _disposer;
        @NotNull
        public DisposableHandle e;
        private final CancellableContinuation<List<? extends T>> f;

        /* JADX WARN: Multi-variable type inference failed */
        public C8624a(@NotNull CancellableContinuation<? super List<? extends T>> cancellableContinuation, @NotNull Job job) {
            super(job);
            this.f = cancellableContinuation;
            this._disposer = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
            t(th);
            return wt2.INSTANCE;
        }

        @Override // tb.cm
        public void t(@Nullable Throwable th) {
            if (th != null) {
                Object tryResumeWithException = this.f.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    this.f.completeResume(tryResumeWithException);
                    C8623c<T>.C8625b u = u();
                    if (u != null) {
                        u.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (C8623c.b.decrementAndGet(C8623c.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.f;
                Deferred[] deferredArr = C8623c.this.a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                Result.C8174a c8174a = Result.Companion;
                cancellableContinuation.resumeWith(Result.m1271constructorimpl(arrayList));
            }
        }

        @Nullable
        public final C8623c<T>.C8625b u() {
            return (C8625b) this._disposer;
        }

        @NotNull
        public final DisposableHandle v() {
            DisposableHandle disposableHandle = this.e;
            if (disposableHandle == null) {
                b41.A("handle");
            }
            return disposableHandle;
        }

        public final void w(@Nullable C8623c<T>.C8625b c8625b) {
            this._disposer = c8625b;
        }

        public final void x(@NotNull DisposableHandle disposableHandle) {
            this.e = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.c$b */
    /* loaded from: classes8.dex */
    public final class C8625b extends ag {
        private final C8623c<T>.C8624a[] a;

        public C8625b(@NotNull C8623c c8623c, C8623c<T>.C8624a[] c8624aArr) {
            this.a = c8624aArr;
        }

        @Override // tb.bg
        public void a(@Nullable Throwable th) {
            b();
        }

        public final void b() {
            for (C8623c<T>.C8624a c8624a : this.a) {
                c8624a.v().dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
            a(th);
            return wt2.INSTANCE;
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.a + jn1.ARRAY_END;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C8623c(@NotNull Deferred<? extends T>[] deferredArr) {
        this.a = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    @Nullable
    public final Object b(@NotNull Continuation<? super List<? extends T>> continuation) {
        Continuation c;
        Object d;
        c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c, 1);
        cancellableContinuationImpl.initCancellability();
        int length = this.a.length;
        C8624a[] c8624aArr = new C8624a[length];
        for (int i = 0; i < length; i++) {
            Deferred deferred = this.a[id.c(i).intValue()];
            deferred.start();
            C8624a c8624a = new C8624a(cancellableContinuationImpl, deferred);
            c8624a.x(deferred.invokeOnCompletion(c8624a));
            c8624aArr[i] = c8624a;
        }
        C8623c<T>.C8625b c8625b = new C8625b(this, c8624aArr);
        for (int i2 = 0; i2 < length; i2++) {
            c8624aArr[i2].w(c8625b);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            c8625b.b();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(c8625b);
        }
        Object result = cancellableContinuationImpl.getResult();
        d = C8234b.d();
        if (result == d) {
            n40.c(continuation);
        }
        return result;
    }
}
