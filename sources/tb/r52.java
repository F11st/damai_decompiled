package tb;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r52<T> implements Observer<T>, Disposable {
    final Observer<? super T> a;
    Disposable b;
    boolean c;

    public r52(@NonNull Observer<? super T> observer) {
        this.a = observer;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                dg0.b(th);
                i42.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            dg0.b(th2);
            i42.u(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.a.onError(nullPointerException);
            } catch (Throwable th) {
                dg0.b(th);
                i42.u(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            dg0.b(th2);
            i42.u(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.b == null) {
            a();
            return;
        }
        try {
            this.a.onComplete();
        } catch (Throwable th) {
            dg0.b(th);
            i42.u(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(@NonNull Throwable th) {
        if (this.c) {
            i42.u(th);
            return;
        }
        this.c = true;
        if (this.b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.a.onError(new CompositeException(th, nullPointerException));
                    return;
                } catch (Throwable th2) {
                    dg0.b(th2);
                    i42.u(new CompositeException(th, nullPointerException, th2));
                    return;
                }
            } catch (Throwable th3) {
                dg0.b(th3);
                i42.u(new CompositeException(th, nullPointerException, th3));
                return;
            }
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.a.onError(th);
        } catch (Throwable th4) {
            dg0.b(th4);
            i42.u(new CompositeException(th, th4));
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(@NonNull T t) {
        if (this.c) {
            return;
        }
        if (this.b == null) {
            b();
        } else if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.b.dispose();
                onError(nullPointerException);
            } catch (Throwable th) {
                dg0.b(th);
                onError(new CompositeException(nullPointerException, th));
            }
        } else {
            try {
                this.a.onNext(t);
            } catch (Throwable th2) {
                dg0.b(th2);
                try {
                    this.b.dispose();
                    onError(th2);
                } catch (Throwable th3) {
                    dg0.b(th3);
                    onError(new CompositeException(th2, th3));
                }
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.b, disposable)) {
            this.b = disposable;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                dg0.b(th);
                this.c = true;
                try {
                    disposable.dispose();
                    i42.u(th);
                } catch (Throwable th2) {
                    dg0.b(th2);
                    i42.u(new CompositeException(th, th2));
                }
            }
        }
    }
}
