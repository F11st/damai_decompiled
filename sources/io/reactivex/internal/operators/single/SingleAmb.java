package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.dg0;
import tb.i42;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleAmb<T> extends e<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class AmbSingleObserver<T> extends AtomicBoolean implements SingleObserver<T> {
        private static final long serialVersionUID = -1944085461036028108L;
        final SingleObserver<? super T> s;
        final jm set;

        AmbSingleObserver(SingleObserver<? super T> singleObserver, jm jmVar) {
            this.s = singleObserver;
            this.set = jmVar;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onError(th);
                return;
            }
            i42.u(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onSuccess(t);
            }
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.sources = singleSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        int length;
        SingleSource<? extends T>[] singleSourceArr = this.sources;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                length = 0;
                for (SingleSource<? extends T> singleSource : this.sourcesIterable) {
                    if (singleSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (length == singleSourceArr.length) {
                        SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[(length >> 2) + length];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i = length + 1;
                    singleSourceArr[length] = singleSource;
                    length = i;
                }
            } catch (Throwable th) {
                dg0.b(th);
                EmptyDisposable.error(th, singleObserver);
                return;
            }
        } else {
            length = singleSourceArr.length;
        }
        jm jmVar = new jm();
        AmbSingleObserver ambSingleObserver = new AmbSingleObserver(singleObserver, jmVar);
        singleObserver.onSubscribe(jmVar);
        for (int i2 = 0; i2 < length; i2++) {
            SingleSource<? extends T> singleSource2 = singleSourceArr[i2];
            if (ambSingleObserver.get()) {
                return;
            }
            if (singleSource2 == null) {
                jmVar.dispose();
                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                if (ambSingleObserver.compareAndSet(false, true)) {
                    singleObserver.onError(nullPointerException);
                    return;
                } else {
                    i42.u(nullPointerException);
                    return;
                }
            }
            singleSource2.subscribe(ambSingleObserver);
        }
    }
}
