package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
abstract class k<V> implements ListenableFuture<V> {
    private static final Logger a = Logger.getLogger(k.class.getName());

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class a<V> extends AbstractFuture.g<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Throwable th) {
            setException(th);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b<V> extends k<V> {
        static final b<Object> c = new b<>(null);
        @NullableDecl
        private final V b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(@NullableDecl V v) {
            this.b = v;
        }

        @Override // com.google.common.util.concurrent.k, java.util.concurrent.Future
        public V get() {
            return this.b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.b + "]]";
        }
    }

    k() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        du1.q(runnable, "Runnable was null.");
        du1.q(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = a;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        du1.p(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
