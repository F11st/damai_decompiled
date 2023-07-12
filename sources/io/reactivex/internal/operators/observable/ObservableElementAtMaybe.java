package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8148c;
import io.reactivex.AbstractC8149d;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableElementAtMaybe<T> extends AbstractC8148c<T> implements FuseToObservable<T> {
    final long index;
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> actual;
        long count;
        boolean done;
        final long index;
        Disposable s;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j) {
            this.actual = maybeObserver;
            this.index = j;
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
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.count;
            if (j == this.index) {
                this.done = true;
                this.s.dispose();
                this.actual.onSuccess(t);
                return;
            }
            this.count = j + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j) {
        this.source = observableSource;
        this.index = j;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public AbstractC8149d<T> fuseToObservable() {
        return i42.n(new ObservableElementAt(this.source, this.index, null, false));
    }

    @Override // io.reactivex.AbstractC8148c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ElementAtObserver(maybeObserver, this.index));
    }
}
