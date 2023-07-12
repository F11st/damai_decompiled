package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.io2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, io2<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super io2<T>> actual;
        long lastTime;
        Subscription s;
        final Scheduler scheduler;
        final TimeUnit unit;

        TimeIntervalSubscriber(Subscriber<? super io2<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.actual = subscriber;
            this.scheduler = scheduler;
            this.unit = timeUnit;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long now = this.scheduler.now(this.unit);
            long j = this.lastTime;
            this.lastTime = now;
            this.actual.onNext(new io2(t, now - j, this.unit));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.lastTime = this.scheduler.now(this.unit);
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }
    }

    public FlowableTimeInterval(b<T> bVar, TimeUnit timeUnit, Scheduler scheduler) {
        super(bVar);
        this.scheduler = scheduler;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super io2<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new TimeIntervalSubscriber(subscriber, this.unit, this.scheduler));
    }
}
