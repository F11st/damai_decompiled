package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.C4834e;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractC5354k;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Futures extends AbstractC5353j {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.Futures$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Future val$scheduled;

        AnonymousClass1(Future future) {
            this.val$scheduled = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$scheduled.cancel(false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.Futures$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImmutableList val$delegates;
        final /* synthetic */ int val$localI;
        final /* synthetic */ C5313a val$state;

        AnonymousClass3(C5313a c5313a, ImmutableList immutableList, int i) {
            this.val$delegates = immutableList;
            this.val$localI = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5313a.a(this.val$state, this.val$delegates, this.val$localI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.future = future;
            this.callback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.callback.onSuccess(Futures.d(this.future));
            } catch (Error e) {
                e = e;
                this.callback.onFailure(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.callback.onFailure(e);
            } catch (ExecutionException e3) {
                this.callback.onFailure(e3.getCause());
            }
        }

        public String toString() {
            return C4834e.b(this).h(this.callback).toString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.AbstractC5300g<V> implements Runnable {
        private ListenableFuture<V> delegate;

        NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = listenableFuture;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                return "delegate=[" + listenableFuture + jn1.ARRAY_END_STR;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.Futures$a */
    /* loaded from: classes10.dex */
    private static final class C5313a<T> {
        static /* synthetic */ void a(C5313a c5313a, ImmutableList immutableList, int i) {
            throw null;
        }
    }

    public static <V> void a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        du1.p(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> b(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, function, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> c(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, asyncFunction, executor);
    }

    @CanIgnoreReturnValue
    public static <V> V d(Future<V> future) throws ExecutionException {
        du1.A(future.isDone(), "Future was expected to be done: %s", future);
        return (V) C5363q.a(future);
    }

    public static <V> ListenableFuture<V> e(Throwable th) {
        du1.p(th);
        return new AbstractC5354k.C5355a(th);
    }

    public static <V> ListenableFuture<V> f(@NullableDecl V v) {
        if (v == null) {
            return AbstractC5354k.C5356b.c;
        }
        return new AbstractC5354k.C5356b(v);
    }

    @Beta
    public static <I, O> ListenableFuture<O> g(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    @Beta
    public static <I, O> ListenableFuture<O> h(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, asyncFunction, executor);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> i(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : TimeoutFuture.d(listenableFuture, j, timeUnit, scheduledExecutorService);
    }
}
