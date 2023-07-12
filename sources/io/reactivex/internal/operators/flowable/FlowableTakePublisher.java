package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableTakePublisher<T> extends b<T> {
    final long limit;
    final Publisher<T> source;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.source = publisher;
        this.limit = j;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.limit));
    }
}
