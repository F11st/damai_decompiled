package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super d<T>, ? extends ObservableSource<R>> selector;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class SourceObserver<T, R> implements Observer<T> {
        final PublishSubject<T> subject;
        final AtomicReference<Disposable> target;

        SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.subject = publishSubject;
            this.target = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.subject.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.subject.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.subject.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.target, disposable);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;
        final Observer<? super R> actual;
        Disposable d;

        TargetObserver(Observer<? super R> observer) {
            this.actual = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super d<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.selector = function;
    }

    @Override // io.reactivex.d
    protected void subscribeActual(Observer<? super R> observer) {
        PublishSubject c = PublishSubject.c();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(c), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.source.subscribe(new SourceObserver(c, targetObserver));
        } catch (Throwable th) {
            dg0.b(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
