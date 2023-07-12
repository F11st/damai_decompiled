package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8146a;
import io.reactivex.AbstractC8149d;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableIgnoreElementsCompletable<T> extends AbstractC8146a implements FuseToObservable<T> {
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final CompletableObserver actual;
        Disposable d;

        IgnoreObservable(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.actual.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public AbstractC8149d<T> fuseToObservable() {
        return i42.n(new ObservableIgnoreElements(this.source));
    }

    @Override // io.reactivex.AbstractC8146a
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreObservable(completableObserver));
    }
}
