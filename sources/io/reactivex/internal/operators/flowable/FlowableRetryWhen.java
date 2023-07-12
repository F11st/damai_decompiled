package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.dg0;
import tb.mn0;
import tb.ua2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super b<Throwable>, ? extends Publisher<?>> handler;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(Subscriber<? super T> subscriber, mn0<Throwable> mn0Var, Subscription subscription) {
            super(subscriber, mn0Var, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.receiver.cancel();
            ((FlowableRepeatWhen.WhenSourceSubscriber) this).actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            again(th);
        }
    }

    public FlowableRetryWhen(b<T> bVar, Function<? super b<Throwable>, ? extends Publisher<?>> function) {
        super(bVar);
        this.handler = function;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ua2 ua2Var = new ua2(subscriber);
        mn0<T> a = UnicastProcessor.d(8).a();
        try {
            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.handler.apply(a), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.source);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(ua2Var, a, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            subscriber.onSubscribe(retryWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            dg0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
