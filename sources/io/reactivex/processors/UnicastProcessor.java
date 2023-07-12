package io.reactivex.processors;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.AbstractC8147b;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.i42;
import tb.mn0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class UnicastProcessor<T> extends mn0<T> {
    final SpscLinkedArrayQueue<T> a;
    final AtomicReference<Runnable> b;
    final boolean c;
    volatile boolean d;
    Throwable e;
    final AtomicReference<Subscriber<? super T>> f;
    volatile boolean g;
    final AtomicBoolean h;
    final BasicIntQueueSubscription<T> i;
    final AtomicLong j;
    boolean k;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.g) {
                return;
            }
            UnicastProcessor.this.g = true;
            UnicastProcessor.this.f();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.k || unicastProcessor.i.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.a.clear();
            UnicastProcessor.this.f.lazySet(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.a.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.a.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return UnicastProcessor.this.a.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(UnicastProcessor.this.j, j);
                UnicastProcessor.this.drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.k = true;
                return 2;
            }
            return 0;
        }
    }

    UnicastProcessor(int i) {
        this(i, null, true);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> c() {
        return new UnicastProcessor<>(AbstractC8147b.bufferSize());
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> d(int i) {
        return new UnicastProcessor<>(i);
    }

    @CheckReturnValue
    public static <T> UnicastProcessor<T> e(int i, Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    boolean b(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.g) {
            spscLinkedArrayQueue.clear();
            this.f.lazySet(null);
            return true;
        } else if (z2) {
            if (z && this.e != null) {
                spscLinkedArrayQueue.clear();
                this.f.lazySet(null);
                subscriber.onError(this.e);
                return true;
            } else if (z3) {
                Throwable th = this.e;
                this.f.lazySet(null);
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void drain() {
        if (this.i.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        Subscriber<? super T> subscriber = this.f.get();
        while (subscriber == null) {
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            }
            subscriber = this.f.get();
        }
        if (this.k) {
            g(subscriber);
        } else {
            h(subscriber);
        }
    }

    void f() {
        Runnable runnable = this.b.get();
        if (runnable == null || !this.b.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void g(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        int i = 1;
        boolean z = !this.c;
        while (!this.g) {
            boolean z2 = this.d;
            if (z && z2 && this.e != null) {
                spscLinkedArrayQueue.clear();
                this.f.lazySet(null);
                subscriber.onError(this.e);
                return;
            }
            subscriber.onNext(null);
            if (z2) {
                this.f.lazySet(null);
                Throwable th = this.e;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            i = this.i.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.f.lazySet(null);
    }

    void h(Subscriber<? super T> subscriber) {
        int i;
        long j;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
        boolean z = !this.c;
        int i2 = 1;
        while (true) {
            long j2 = this.j.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.d;
                T poll = spscLinkedArrayQueue.poll();
                boolean z3 = poll == null;
                j = j3;
                if (b(z, z2, z3, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z3) {
                    break;
                }
                subscriber.onNext(poll);
                j3 = 1 + j;
            }
            if (i == 0 && b(z, this.d, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j != 0 && j2 != AbsPerformance.LONG_NIL) {
                this.j.addAndGet(-j);
            }
            i2 = this.i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.d || this.g) {
            return;
        }
        this.d = true;
        f();
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.d && !this.g) {
            this.e = th;
            this.d = true;
            f();
            drain();
            return;
        }
        i42.u(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.d || this.g) {
            return;
        }
        this.a.offer(t);
        drain();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (!this.d && !this.g) {
            subscription.request(AbsPerformance.LONG_NIL);
        } else {
            subscription.cancel();
        }
    }

    @Override // io.reactivex.AbstractC8147b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (!this.h.get() && this.h.compareAndSet(false, true)) {
            subscriber.onSubscribe(this.i);
            this.f.set(subscriber);
            if (this.g) {
                this.f.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(ObjectHelper.verifyPositive(i, "capacityHint"));
        this.b = new AtomicReference<>(runnable);
        this.c = z;
        this.f = new AtomicReference<>();
        this.h = new AtomicBoolean();
        this.i = new UnicastQueueSubscription();
        this.j = new AtomicLong();
    }
}
