package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8149d;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableFromUnsafeSource<T> extends AbstractC8149d<T> {
    final ObservableSource<T> source;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.AbstractC8149d
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(observer);
    }
}
