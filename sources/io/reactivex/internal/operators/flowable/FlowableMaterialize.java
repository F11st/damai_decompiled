package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;
import tb.i42;
import tb.ul1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, ul1<T>> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, ul1<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        MaterializeSubscriber(Subscriber<? super ul1<T>> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            complete(ul1.a());
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        protected /* bridge */ /* synthetic */ void onDrop(Object obj) {
            onDrop((ul1) ((ul1) obj));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            complete(ul1.b(th));
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(ul1.c(t));
        }

        protected void onDrop(ul1<T> ul1Var) {
            if (ul1Var.g()) {
                i42.u(ul1Var.d());
            }
        }
    }

    public FlowableMaterialize(b<T> bVar) {
        super(bVar);
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super ul1<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new MaterializeSubscriber(subscriber));
    }
}
