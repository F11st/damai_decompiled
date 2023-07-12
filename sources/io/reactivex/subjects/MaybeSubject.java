package io.reactivex.subjects;

import io.reactivex.AbstractC8148c;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MaybeSubject<T> extends AbstractC8148c<T> implements MaybeObserver<T> {
    static final MaybeDisposable[] e = new MaybeDisposable[0];
    static final MaybeDisposable[] f = new MaybeDisposable[0];
    T c;
    Throwable d;
    final AtomicBoolean b = new AtomicBoolean();
    final AtomicReference<MaybeDisposable<T>[]> a = new AtomicReference<>(e);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final MaybeObserver<? super T> actual;

        MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.actual = maybeObserver;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    MaybeSubject() {
    }

    boolean a(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable<T>[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.a.get();
            if (maybeDisposableArr == f) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[length + 1];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.a.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.a.get();
            int length = maybeDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (maybeDisposableArr[i2] == maybeDisposable) {
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
                maybeDisposableArr2 = e;
            } else {
                MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[length - 1];
                System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i);
                System.arraycopy(maybeDisposableArr, i + 1, maybeDisposableArr3, i, (length - i) - 1);
                maybeDisposableArr2 = maybeDisposableArr3;
            }
        } while (!this.a.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.b.compareAndSet(false, true)) {
            for (MaybeDisposable<T> maybeDisposable : this.a.getAndSet(f)) {
                maybeDisposable.actual.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.d = th;
            for (MaybeDisposable<T> maybeDisposable : this.a.getAndSet(f)) {
                maybeDisposable.actual.onError(th);
            }
            return;
        }
        i42.u(th);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.c = t;
            for (MaybeDisposable<T> maybeDisposable : this.a.getAndSet(f)) {
                maybeDisposable.actual.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.AbstractC8148c
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable<T> maybeDisposable = new MaybeDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (a(maybeDisposable)) {
            if (maybeDisposable.isDisposed()) {
                b(maybeDisposable);
                return;
            }
            return;
        }
        Throwable th = this.d;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        Object obj = (T) this.c;
        if (obj == null) {
            maybeObserver.onComplete();
        } else {
            maybeObserver.onSuccess(obj);
        }
    }
}
