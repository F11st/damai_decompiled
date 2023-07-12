package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import tb.ra2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(d<T> dVar) {
        super(dVar);
    }

    @Override // io.reactivex.d
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ra2(observer));
    }
}
