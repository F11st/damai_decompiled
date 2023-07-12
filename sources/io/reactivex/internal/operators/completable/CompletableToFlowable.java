package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.b;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompletableToFlowable<T> extends b<T> {
    final CompletableSource source;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    @Override // io.reactivex.b
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SubscriberCompletableObserver(subscriber));
    }
}
