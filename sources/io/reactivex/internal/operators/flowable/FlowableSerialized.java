package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import org.reactivestreams.Subscriber;
import tb.ua2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableSerialized(b<T> bVar) {
        super(bVar);
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ua2(subscriber));
    }
}
