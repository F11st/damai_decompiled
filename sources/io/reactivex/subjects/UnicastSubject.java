package io.reactivex.subjects;

import io.reactivex.AbstractC8149d;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import tb.i42;
import tb.pi2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class UnicastSubject<T> extends pi2<T> {
    final SpscLinkedArrayQueue<T> a;
    final AtomicReference<Observer<? super T>> b;
    final AtomicReference<Runnable> c;
    final boolean d;
    volatile boolean e;
    volatile boolean f;
    Throwable g;
    final AtomicBoolean h;
    final BasicIntQueueDisposable<T> i;
    boolean j;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.a.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (UnicastSubject.this.e) {
                return;
            }
            UnicastSubject.this.e = true;
            UnicastSubject.this.e();
            UnicastSubject.this.b.lazySet(null);
            if (UnicastSubject.this.i.getAndIncrement() == 0) {
                UnicastSubject.this.b.lazySet(null);
                UnicastSubject.this.a.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.e;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.a.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Exception {
            return UnicastSubject.this.a.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastSubject.this.j = true;
                return 2;
            }
            return 0;
        }
    }

    UnicastSubject(int i, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.c = new AtomicReference<>();
        this.d = z;
        this.b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> b() {
        return new UnicastSubject<>(AbstractC8149d.bufferSize(), true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> c(int i) {
        return new UnicastSubject<>(i, true);
    }

    @CheckReturnValue
    public static <T> UnicastSubject<T> d(int i, Runnable runnable) {
        return new UnicastSubject<>(i, runnable, true);
    }

    void e() {
        Runnable runnable = this.c.get();
        if (runnable == null || !this.c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void f() {
        if (this.i.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.b.get();
        int i = 1;
        while (observer == null) {
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            }
            observer = this.b.get();
        }
        if (this.j) {
            g(observer);
        } else {
            h(observer);
        }
    }

    void g(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        int i = 1;
        boolean z = !this.d;
        while (!this.e) {
            boolean z2 = this.f;
            if (z && z2 && j(spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.onNext(null);
            if (z2) {
                i(observer);
                return;
            }
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        this.b.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void h(Observer<? super T> observer) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        boolean z = !this.d;
        boolean z2 = true;
        int i = 1;
        while (!this.e) {
            boolean z3 = this.f;
            Object obj = (T) this.a.poll();
            boolean z4 = obj == null;
            if (z3) {
                if (z && z2) {
                    if (j(spscLinkedArrayQueue, observer)) {
                        return;
                    }
                    z2 = false;
                }
                if (z4) {
                    i(observer);
                    return;
                }
            }
            if (z4) {
                i = this.i.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                observer.onNext(obj);
            }
        }
        this.b.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void i(Observer<? super T> observer) {
        this.b.lazySet(null);
        Throwable th = this.g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    boolean j(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.g;
        if (th != null) {
            this.b.lazySet(null);
            simpleQueue.clear();
            observer.onError(th);
            return true;
        }
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f || this.e) {
            return;
        }
        this.f = true;
        e();
        f();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f && !this.e) {
            this.g = th;
            this.f = true;
            e();
            f();
            return;
        }
        i42.u(th);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f || this.e) {
            return;
        }
        this.a.offer(t);
        f();
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f || this.e) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.AbstractC8149d
    protected void subscribeActual(Observer<? super T> observer) {
        if (!this.h.get() && this.h.compareAndSet(false, true)) {
            observer.onSubscribe(this.i);
            this.b.lazySet(observer);
            if (this.e) {
                this.b.lazySet(null);
                return;
            } else {
                f();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }

    UnicastSubject(int i, Runnable runnable, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.c = new AtomicReference<>(ObjectHelper.requireNonNull(runnable, "onTerminate"));
        this.d = z;
        this.b = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueDisposable();
    }
}
