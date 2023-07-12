package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.an;
import tb.jm;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableRefCount<T> extends AbstractFlowableWithUpstream<T, T> {
    volatile jm baseDisposable;
    final ReentrantLock lock;
    final an<T> source;
    final AtomicInteger subscriptionCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class ConnectionSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 152064694420235350L;
        final jm currentBase;
        final AtomicLong requested = new AtomicLong();
        final Disposable resource;
        final Subscriber<? super T> subscriber;

        ConnectionSubscriber(Subscriber<? super T> subscriber, jm jmVar, Disposable disposable) {
            this.subscriber = subscriber;
            this.currentBase = jmVar;
            this.resource = disposable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            this.resource.dispose();
        }

        void cleanup() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.baseDisposable == this.currentBase) {
                    an<T> anVar = FlowableRefCount.this.source;
                    if (anVar instanceof Disposable) {
                        ((Disposable) anVar).dispose();
                    }
                    FlowableRefCount.this.baseDisposable.dispose();
                    FlowableRefCount.this.baseDisposable = new jm();
                    FlowableRefCount.this.subscriptionCount.set(0);
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class DisposeConsumer implements Consumer<Disposable> {
        private final Subscriber<? super T> subscriber;
        private final AtomicBoolean writeLocked;

        DisposeConsumer(Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
            this.subscriber = subscriber;
            this.writeLocked = atomicBoolean;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            try {
                FlowableRefCount.this.baseDisposable.add(disposable);
                FlowableRefCount flowableRefCount = FlowableRefCount.this;
                flowableRefCount.doSubscribe(this.subscriber, flowableRefCount.baseDisposable);
            } finally {
                FlowableRefCount.this.lock.unlock();
                this.writeLocked.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class DisposeTask implements Runnable {
        private final jm current;

        DisposeTask(jm jmVar) {
            this.current = jmVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.baseDisposable == this.current && FlowableRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                    an<T> anVar = FlowableRefCount.this.source;
                    if (anVar instanceof Disposable) {
                        ((Disposable) anVar).dispose();
                    }
                    FlowableRefCount.this.baseDisposable.dispose();
                    FlowableRefCount.this.baseDisposable = new jm();
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }
    }

    public FlowableRefCount(an<T> anVar) {
        super(anVar);
        this.baseDisposable = new jm();
        this.subscriptionCount = new AtomicInteger();
        this.lock = new ReentrantLock();
        this.source = anVar;
    }

    private Disposable disconnect(jm jmVar) {
        return a.c(new DisposeTask(jmVar));
    }

    private Consumer<Disposable> onSubscribe(Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
        return new DisposeConsumer(subscriber, atomicBoolean);
    }

    void doSubscribe(Subscriber<? super T> subscriber, jm jmVar) {
        ConnectionSubscriber connectionSubscriber = new ConnectionSubscriber(subscriber, jmVar, disconnect(jmVar));
        subscriber.onSubscribe(connectionSubscriber);
        this.source.subscribe((FlowableSubscriber) connectionSubscriber);
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(subscriber, atomicBoolean));
                if (z) {
                    return;
                }
                return;
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            doSubscribe(subscriber, this.baseDisposable);
        } finally {
            this.lock.unlock();
        }
    }
}
