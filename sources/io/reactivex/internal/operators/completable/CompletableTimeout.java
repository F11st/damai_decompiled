package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.i42;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableTimeout extends a {
    final CompletableSource other;
    final Scheduler scheduler;
    final CompletableSource source;
    final long timeout;
    final TimeUnit unit;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class DisposeTask implements Runnable {
        private final AtomicBoolean once;
        final CompletableObserver s;
        final jm set;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        final class DisposeObserver implements CompletableObserver {
            DisposeObserver() {
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                DisposeTask.this.set.dispose();
                DisposeTask.this.s.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                DisposeTask.this.set.dispose();
                DisposeTask.this.s.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposeTask.this.set.add(disposable);
            }
        }

        DisposeTask(AtomicBoolean atomicBoolean, jm jmVar, CompletableObserver completableObserver) {
            this.once = atomicBoolean;
            this.set = jmVar;
            this.s = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.set.a();
                CompletableSource completableSource = CompletableTimeout.this.other;
                if (completableSource == null) {
                    this.s.onError(new TimeoutException());
                } else {
                    completableSource.subscribe(new DisposeObserver());
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class TimeOutObserver implements CompletableObserver {
        private final AtomicBoolean once;
        private final CompletableObserver s;
        private final jm set;

        TimeOutObserver(jm jmVar, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.set = jmVar;
            this.once = atomicBoolean;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onError(th);
                return;
            }
            i42.u(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.source = completableSource;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = completableSource2;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        jm jmVar = new jm();
        completableObserver.onSubscribe(jmVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        jmVar.add(this.scheduler.scheduleDirect(new DisposeTask(atomicBoolean, jmVar, completableObserver), this.timeout, this.unit));
        this.source.subscribe(new TimeOutObserver(jmVar, atomicBoolean, completableObserver));
    }
}
