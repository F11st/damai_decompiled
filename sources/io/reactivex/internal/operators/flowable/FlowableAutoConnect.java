package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import tb.an;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class FlowableAutoConnect<T> extends b<T> {
    final AtomicInteger clients = new AtomicInteger();
    final Consumer<? super Disposable> connection;
    final int numberOfSubscribers;
    final an<? extends T> source;

    public FlowableAutoConnect(an<? extends T> anVar, int i, Consumer<? super Disposable> consumer) {
        this.source = anVar;
        this.numberOfSubscribers = i;
        this.connection = consumer;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((Subscriber<? super Object>) subscriber);
        if (this.clients.incrementAndGet() == this.numberOfSubscribers) {
            this.source.connect(this.connection);
        }
    }
}
