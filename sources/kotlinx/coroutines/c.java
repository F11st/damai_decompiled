package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
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
/* loaded from: classes8.dex */
public final class c<T> {
    static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    private final Deferred<T>[] a;
    volatile int notCompletedCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public final class a extends f61<Job> {
        private volatile Object _disposer;
        @NotNull
        public DisposableHandle e;
        private final CancellableContinuation<List<? extends T>> f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull CancellableContinuation<? super List<? extends T>> cancellableContinuation, @NotNull Job job) {
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
                    c<T>.b u = u();
                    if (u != null) {
                        u.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (c.b.decrementAndGet(c.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.f;
                Deferred[] deferredArr = c.this.a;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred deferred : deferredArr) {
                    arrayList.add(deferred.getCompleted());
                }
                Result.a aVar = Result.Companion;
                cancellableContinuation.resumeWith(Result.m1271constructorimpl(arrayList));
            }
        }

        @Nullable
        public final c<T>.b u() {
            return (b) this._disposer;
        }

        @NotNull
        public final DisposableHandle v() {
            DisposableHandle disposableHandle = this.e;
            if (disposableHandle == null) {
                b41.A("handle");
            }
            return disposableHandle;
        }

        public final void w(@Nullable c<T>.b bVar) {
            this._disposer = bVar;
        }

        public final void x(@NotNull DisposableHandle disposableHandle) {
            this.e = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public final class b extends ag {
        private final c<T>.a[] a;

        public b(@NotNull c cVar, c<T>.a[] aVarArr) {
            this.a = aVarArr;
        }

        @Override // tb.bg
        public void a(@Nullable Throwable th) {
            b();
        }

        public final void b() {
            for (c<T>.a aVar : this.a) {
                aVar.v().dispose();
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
    public c(@NotNull Deferred<? extends T>[] deferredArr) {
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
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            Deferred deferred = this.a[id.c(i).intValue()];
            deferred.start();
            a aVar = new a(cancellableContinuationImpl, deferred);
            aVar.x(deferred.invokeOnCompletion(aVar));
            aVarArr[i] = aVar;
        }
        c<T>.b bVar = new b(this, aVarArr);
        for (int i2 = 0; i2 < length; i2++) {
            aVarArr[i2].w(bVar);
        }
        if (cancellableContinuationImpl.isCompleted()) {
            bVar.b();
        } else {
            cancellableContinuationImpl.invokeOnCancellation(bVar);
        }
        Object result = cancellableContinuationImpl.getResult();
        d = kotlin.coroutines.intrinsics.b.d();
        if (result == d) {
            n40.c(continuation);
        }
        return result;
    }
}
