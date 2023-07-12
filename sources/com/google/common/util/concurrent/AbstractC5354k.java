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
/* renamed from: com.google.common.util.concurrent.k */
/* loaded from: classes10.dex */
abstract class AbstractC5354k<V> implements ListenableFuture<V> {
    private static final Logger a = Logger.getLogger(AbstractC5354k.class.getName());

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.k$a */
    /* loaded from: classes10.dex */
    static final class C5355a<V> extends AbstractFuture.AbstractC5300g<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C5355a(Throwable th) {
            setException(th);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.k$b */
    /* loaded from: classes10.dex */
    static class C5356b<V> extends AbstractC5354k<V> {
        static final C5356b<Object> c = new C5356b<>(null);
        @NullableDecl
        private final V b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5356b(@NullableDecl V v) {
            this.b = v;
        }

        @Override // com.google.common.util.concurrent.AbstractC5354k, java.util.concurrent.Future
        public V get() {
            return this.b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.b + "]]";
        }
    }

    AbstractC5354k() {
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
