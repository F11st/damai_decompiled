package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    final AtomicBoolean once;
    final CacheState<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
        static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
        final AtomicReference<Subscription> connection;
        volatile boolean isConnected;
        final b<T> source;
        boolean sourceDone;
        final AtomicReference<ReplaySubscription<T>[]> subscribers;

        CacheState(b<T> bVar, int i) {
            super(i);
            this.connection = new AtomicReference<>();
            this.source = bVar;
            this.subscribers = new AtomicReference<>(EMPTY);
        }

        public void addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                if (replaySubscriptionArr == TERMINATED) {
                    return;
                }
                int length = replaySubscriptionArr.length;
                replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                replaySubscriptionArr2[length] = replaySubscription;
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }

        public void connect() {
            this.source.subscribe((FlowableSubscriber) this);
            this.isConnected = true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.sourceDone) {
                return;
            }
            this.sourceDone = true;
            add(NotificationLite.complete());
            SubscriptionHelper.cancel(this.connection);
            for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                SubscriptionHelper.cancel(this.connection);
                for (ReplaySubscription<T> replaySubscription : this.subscribers.getAndSet(TERMINATED)) {
                    replaySubscription.replay();
                }
                return;
            }
            i42.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceDone) {
                return;
            }
            add(NotificationLite.next(t));
            for (ReplaySubscription<T> replaySubscription : this.subscribers.get()) {
                replaySubscription.replay();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.connection, subscription)) {
                subscription.request(AbsPerformance.LONG_NIL);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.subscribers.get();
                int length = replaySubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replaySubscriptionArr[i2].equals(replaySubscription)) {
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
                    replaySubscriptionArr2 = EMPTY;
                } else {
                    ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                    System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                    System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                    replaySubscriptionArr2 = replaySubscriptionArr3;
                }
            } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long CANCELLED = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final CacheState<T> state;

        ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.removeChild(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.child;
            AtomicLong atomicLong = this.requested;
            int i = 1;
            int i2 = 1;
            while (true) {
                long j = atomicLong.get();
                if (j < 0) {
                    return;
                }
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - i;
                    int i3 = this.index;
                    int i4 = this.currentIndexInBuffer;
                    int i5 = 0;
                    while (i3 < size && j > 0) {
                        if (atomicLong.get() == -1) {
                            return;
                        }
                        if (i4 == length) {
                            objArr = (Object[]) objArr[length];
                            i4 = 0;
                        }
                        if (NotificationLite.accept(objArr[i4], subscriber)) {
                            return;
                        }
                        i4++;
                        i3++;
                        j--;
                        i5++;
                    }
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (j == 0) {
                        Object obj = objArr[i4];
                        if (NotificationLite.isComplete(obj)) {
                            subscriber.onComplete();
                            return;
                        } else if (NotificationLite.isError(obj)) {
                            subscriber.onError(NotificationLite.getError(obj));
                            return;
                        }
                    }
                    if (i5 != 0) {
                        BackpressureHelper.producedCancel(atomicLong, i5);
                    }
                    this.index = i3;
                    this.currentIndexInBuffer = i4;
                    this.currentBuffer = objArr;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                i = 1;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long j2;
            if (SubscriptionHelper.validate(j)) {
                do {
                    j2 = this.requested.get();
                    if (j2 == -1) {
                        return;
                    }
                } while (!this.requested.compareAndSet(j2, BackpressureHelper.addCap(j2, j)));
                replay();
            }
        }
    }

    public FlowableCache(b<T> bVar, int i) {
        super(bVar);
        this.state = new CacheState<>(bVar, i);
        this.once = new AtomicBoolean();
    }

    int cachedEventCount() {
        return this.state.size();
    }

    boolean hasSubscribers() {
        return this.state.subscribers.get().length != 0;
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this.state);
        this.state.addChild(replaySubscription);
        subscriber.onSubscribe(replaySubscription);
        if (this.once.get() || !this.once.compareAndSet(false, true)) {
            return;
        }
        this.state.connect();
    }
}
