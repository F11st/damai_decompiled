package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableFromObservable<T> extends a {
    final ObservableSource<T> observable;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver co;

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.co = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.co.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.co.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.co.onSubscribe(disposable);
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    @Override // io.reactivex.a
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }
}
