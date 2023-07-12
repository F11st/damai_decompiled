package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tb.du1;

/* compiled from: Taobao */
@Beta
@GwtCompatible(emulated = true)
/* renamed from: com.google.common.util.concurrent.e */
/* loaded from: classes10.dex */
public abstract class AbstractC5344e<V> extends AbstractC5350i<V> {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.e$a */
    /* loaded from: classes10.dex */
    static abstract class AbstractC5345a<V> extends AbstractC5344e<V> implements AbstractFuture.Trusted<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    public static <V> AbstractC5344e<V> from(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof AbstractC5344e ? (AbstractC5344e) listenableFuture : new C5346f(listenableFuture);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.a(this, futureCallback, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> AbstractC5344e<V> catching(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (AbstractC5344e) Futures.b(this, cls, function, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> AbstractC5344e<V> catchingAsync(Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return (AbstractC5344e) Futures.c(this, cls, asyncFunction, executor);
    }

    public final <T> AbstractC5344e<T> transform(Function<? super V, T> function, Executor executor) {
        return (AbstractC5344e) Futures.g(this, function, executor);
    }

    public final <T> AbstractC5344e<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (AbstractC5344e) Futures.h(this, asyncFunction, executor);
    }

    @GwtIncompatible
    public final AbstractC5344e<V> withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (AbstractC5344e) Futures.i(this, j, timeUnit, scheduledExecutorService);
    }

    @Deprecated
    public static <V> AbstractC5344e<V> from(AbstractC5344e<V> abstractC5344e) {
        return (AbstractC5344e) du1.p(abstractC5344e);
    }
}
