package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.i42;
import tb.pi2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class PublishSubject<T> extends pi2<T> {
    static final PublishDisposable[] c = new PublishDisposable[0];
    static final PublishDisposable[] d = new PublishDisposable[0];
    final AtomicReference<PublishDisposable<T>[]> a = new AtomicReference<>(d);
    Throwable b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final Observer<? super T> actual;
        final PublishSubject<T> parent;

        PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.actual = observer;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.d(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                i42.u(th);
            } else {
                this.actual.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.actual.onNext(t);
        }
    }

    PublishSubject() {
    }

    @CheckReturnValue
    public static <T> PublishSubject<T> c() {
        return new PublishSubject<>();
    }

    boolean b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.a.get();
            if (publishDisposableArr == c) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.a.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void d(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.a.get();
            if (publishDisposableArr == c || publishDisposableArr == d) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (publishDisposableArr[i2] == publishDisposable) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = d;
            } else {
                PublishDisposable[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!this.a.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.a.get();
        PublishDisposable<T>[] publishDisposableArr2 = c;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.a.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.a.get();
        PublishDisposable<T>[] publishDisposableArr2 = c;
        if (publishDisposableArr == publishDisposableArr2) {
            i42.u(th);
            return;
        }
        this.b = th;
        for (PublishDisposable<T> publishDisposable : this.a.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.a.get() == c) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.a.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == c) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.AbstractC8149d
    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        if (b(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                d(publishDisposable);
                return;
            }
            return;
        }
        Throwable th = this.b;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }
}
