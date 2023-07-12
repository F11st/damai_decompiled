package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.d;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableFromUnsafeSource<T> extends d<T> {
    final ObservableSource<T> source;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.d
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(observer);
    }
}
