package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import tb.i42;
import tb.pi2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class AsyncSubject<T> extends pi2<T> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose()) {
                throw null;
            }
        }

        void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                i42.u(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
