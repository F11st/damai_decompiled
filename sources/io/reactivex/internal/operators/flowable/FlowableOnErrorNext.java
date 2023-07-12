package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.dg0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean allowFatal;
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class OnErrorNextSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> actual;
        final boolean allowFatal;
        final SubscriptionArbiter arbiter = new SubscriptionArbiter();
        boolean done;
        final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
        boolean once;

        OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
            this.actual = subscriber;
            this.nextSupplier = function;
            this.allowFatal = z;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.once = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.once) {
                if (this.done) {
                    i42.u(th);
                    return;
                } else {
                    this.actual.onError(th);
                    return;
                }
            }
            this.once = true;
            if (this.allowFatal && !(th instanceof Exception)) {
                this.actual.onError(th);
                return;
            }
            try {
                Publisher<? extends T> apply = this.nextSupplier.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Publisher is null");
                    nullPointerException.initCause(th);
                    this.actual.onError(nullPointerException);
                    return;
                }
                apply.subscribe(this);
            } catch (Throwable th2) {
                dg0.b(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.actual.onNext(t);
            if (this.once) {
                return;
            }
            this.arbiter.produced(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.arbiter.setSubscription(subscription);
        }
    }

    public FlowableOnErrorNext(b<T> bVar, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
        super(bVar);
        this.nextSupplier = function;
        this.allowFatal = z;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.nextSupplier, this.allowFatal);
        subscriber.onSubscribe(onErrorNextSubscriber.arbiter);
        this.source.subscribe((FlowableSubscriber) onErrorNextSubscriber);
    }
}
