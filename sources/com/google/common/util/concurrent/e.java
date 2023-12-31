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
/* loaded from: classes10.dex */
public abstract class e<V> extends i<V> {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class a<V> extends e<V> implements AbstractFuture.Trusted<V> {
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

    public static <V> e<V> from(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof e ? (e) listenableFuture : new f(listenableFuture);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.a(this, futureCallback, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> e<V> catching(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (e) Futures.b(this, cls, function, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> e<V> catchingAsync(Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return (e) Futures.c(this, cls, asyncFunction, executor);
    }

    public final <T> e<T> transform(Function<? super V, T> function, Executor executor) {
        return (e) Futures.g(this, function, executor);
    }

    public final <T> e<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (e) Futures.h(this, asyncFunction, executor);
    }

    @GwtIncompatible
    public final e<V> withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (e) Futures.i(this, j, timeUnit, scheduledExecutorService);
    }

    @Deprecated
    public static <V> e<V> from(e<V> eVar) {
        return (e) du1.p(eVar);
    }
}
