package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import tb.i42;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableDematerialize<T> extends AbstractObservableWithUpstream<ul1<T>, T> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class DematerializeObserver<T> implements Observer<ul1<T>>, Disposable {
        final Observer<? super T> actual;
        boolean done;
        Disposable s;

        DematerializeObserver(Observer<? super T> observer) {
            this.actual = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                i42.u(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((ul1) ((ul1) obj));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(ul1<T> ul1Var) {
            if (this.done) {
                if (ul1Var.g()) {
                    i42.u(ul1Var.d());
                }
            } else if (ul1Var.g()) {
                this.s.dispose();
                onError(ul1Var.d());
            } else if (ul1Var.f()) {
                this.s.dispose();
                onComplete();
            } else {
                this.actual.onNext(ul1Var.e());
            }
        }
    }

    public ObservableDematerialize(ObservableSource<ul1<T>> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DematerializeObserver(observer));
    }
}
