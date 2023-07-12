package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableFromIterable<T> extends b<T> {
    final Iterable<? extends T> source;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.it = it;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.it = null;
        }

        abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.it;
            return it == null || !it.hasNext();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            Iterator<? extends T> it = this.it;
            if (it == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == AbsPerformance.LONG_NIL) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 1;
        }

        abstract void slowPath(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final ConditionalSubscriber<? super T> actual;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.actual = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            while (!this.cancelled) {
                try {
                    Object obj = (T) it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (obj == null) {
                        conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    conditionalSubscriber.tryOnNext(obj);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        dg0.b(th);
                        conditionalSubscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    dg0.b(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void slowPath(long j) {
            Iterator<? extends T> it = this.it;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.cancelled) {
                                return;
                            }
                            if (obj == null) {
                                conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean tryOnNext = conditionalSubscriber.tryOnNext(obj);
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.cancelled) {
                                        return;
                                    }
                                    conditionalSubscriber.onComplete();
                                    return;
                                } else if (tryOnNext) {
                                    j2++;
                                }
                            } catch (Throwable th) {
                                dg0.b(th);
                                conditionalSubscriber.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            dg0.b(th2);
                            conditionalSubscriber.onError(th2);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = addAndGet(-j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final Subscriber<? super T> actual;

        IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.actual = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void fastPath() {
            Iterator<? extends T> it = this.it;
            Subscriber<? super T> subscriber = this.actual;
            while (!this.cancelled) {
                try {
                    Object obj = (T) it.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (obj == null) {
                        subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    subscriber.onNext(obj);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        dg0.b(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    dg0.b(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void slowPath(long j) {
            Iterator<? extends T> it = this.it;
            Subscriber<? super T> subscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.cancelled) {
                                return;
                            }
                            if (obj == null) {
                                subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            subscriber.onNext(obj);
                            if (this.cancelled) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.cancelled) {
                                        return;
                                    }
                                    subscriber.onComplete();
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                dg0.b(th);
                                subscriber.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            dg0.b(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            j = addAndGet(-j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.source = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.onSubscribe(new IteratorSubscription(subscriber, it));
            }
        } catch (Throwable th) {
            dg0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.source.iterator());
        } catch (Throwable th) {
            dg0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
