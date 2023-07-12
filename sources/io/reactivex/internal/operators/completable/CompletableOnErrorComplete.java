package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableOnErrorComplete extends a {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class OnError implements CompletableObserver {
        private final CompletableObserver s;

        OnError(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.s.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th)) {
                    this.s.onComplete();
                } else {
                    this.s.onError(th);
                }
            } catch (Throwable th2) {
                dg0.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.s.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.source = completableSource;
        this.predicate = predicate;
    }

    @Override // io.reactivex.a
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }
}
