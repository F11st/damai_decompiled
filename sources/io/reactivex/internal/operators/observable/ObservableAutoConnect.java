package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import tb.bn;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableAutoConnect<T> extends d<T> {
    final AtomicInteger clients = new AtomicInteger();
    final Consumer<? super Disposable> connection;
    final int numberOfObservers;
    final bn<? extends T> source;

    public ObservableAutoConnect(bn<? extends T> bnVar, int i, Consumer<? super Disposable> consumer) {
        this.source = bnVar;
        this.numberOfObservers = i;
        this.connection = consumer;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer<? super Object>) observer);
        if (this.clients.incrementAndGet() == this.numberOfObservers) {
            this.source.connect(this.connection);
        }
    }
}
