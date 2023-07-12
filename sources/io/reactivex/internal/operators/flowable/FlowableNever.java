package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableNever extends b<Object> {
    public static final b<Object> INSTANCE = new FlowableNever();

    private FlowableNever() {
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super Object> subscriber) {
        subscriber.onSubscribe(EmptySubscription.INSTANCE);
    }
}
