package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.i42;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableDematerialize<T> extends AbstractFlowableWithUpstream<ul1<T>, T> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class DematerializeSubscriber<T> implements FlowableSubscriber<ul1<T>>, Subscription {
        final Subscriber<? super T> actual;
        boolean done;
        Subscription s;

        DematerializeSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                i42.u(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((ul1) ((ul1) obj));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }

        public void onNext(ul1<T> ul1Var) {
            if (this.done) {
                if (ul1Var.g()) {
                    i42.u(ul1Var.d());
                }
            } else if (ul1Var.g()) {
                this.s.cancel();
                onError(ul1Var.d());
            } else if (ul1Var.f()) {
                this.s.cancel();
                onComplete();
            } else {
                this.actual.onNext(ul1Var.e());
            }
        }
    }

    public FlowableDematerialize(b<ul1<T>> bVar) {
        super(bVar);
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DematerializeSubscriber(subscriber));
    }
}
