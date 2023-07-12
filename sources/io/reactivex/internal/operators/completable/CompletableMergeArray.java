package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.i42;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableMergeArray extends a {
    final CompletableSource[] sources;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;
        final CompletableObserver actual;
        final AtomicBoolean once;
        final jm set;

        InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, jm jmVar, int i) {
            this.actual = completableObserver;
            this.once = atomicBoolean;
            this.set = jmVar;
            lazySet(i);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                i42.u(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.sources = completableSourceArr;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableSource[] completableSourceArr;
        jm jmVar = new jm();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), jmVar, this.sources.length + 1);
        completableObserver.onSubscribe(jmVar);
        for (CompletableSource completableSource : this.sources) {
            if (jmVar.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                jmVar.dispose();
                innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                return;
            }
            completableSource.subscribe(innerCompletableObserver);
        }
        innerCompletableObserver.onComplete();
    }
}
