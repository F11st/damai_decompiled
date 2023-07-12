package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import java.util.concurrent.Callable;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableToSingle<T> extends e<T> {
    final T completionValue;
    final Callable<? extends T> completionValueSupplier;
    final CompletableSource source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> observer;

        ToSingle(SingleObserver<? super T> singleObserver) {
            this.observer = singleObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            T call;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Callable<? extends T> callable = completableToSingle.completionValueSupplier;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (Throwable th) {
                    dg0.b(th);
                    this.observer.onError(th);
                    return;
                }
            } else {
                call = completableToSingle.completionValue;
            }
            if (call == null) {
                this.observer.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.observer.onSuccess(call);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.observer.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.source = completableSource;
        this.completionValue = t;
        this.completionValueSupplier = callable;
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ToSingle(singleObserver));
    }
}
