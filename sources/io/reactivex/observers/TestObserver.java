package io.reactivex.observers;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T> {
    private final Observer<? super T> h;
    private final AtomicReference<Disposable> i;
    private QueueDisposable<T> j;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.i);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.i.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.e) {
            this.e = true;
            if (this.i.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.d++;
            this.h.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!this.e) {
            this.e = true;
            if (this.i.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th == null) {
                this.c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.c.add(th);
            }
            this.h.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (!this.e) {
            this.e = true;
            if (this.i.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.g != 2) {
            this.b.add(t);
            if (t == null) {
                this.c.add(new NullPointerException("onNext received a null value"));
            }
            this.h.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.j.poll();
                if (poll == null) {
                    return;
                }
                this.b.add(poll);
            } catch (Throwable th) {
                this.c.add(th);
                this.j.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Thread.currentThread();
        if (disposable == null) {
            this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.i.compareAndSet(null, disposable)) {
            disposable.dispose();
            if (this.i.get() != DisposableHelper.DISPOSED) {
                this.c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
            }
        } else {
            int i = this.f;
            if (i != 0 && (disposable instanceof QueueDisposable)) {
                QueueDisposable<T> queueDisposable = (QueueDisposable) disposable;
                this.j = queueDisposable;
                int requestFusion = queueDisposable.requestFusion(i);
                this.g = requestFusion;
                if (requestFusion == 1) {
                    this.e = true;
                    Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.j.poll();
                            if (poll != null) {
                                this.b.add(poll);
                            } else {
                                this.d++;
                                this.i.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.c.add(th);
                            return;
                        }
                    }
                }
            }
            this.h.onSubscribe(disposable);
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    public TestObserver(Observer<? super T> observer) {
        this.i = new AtomicReference<>();
        this.h = observer;
    }
}
