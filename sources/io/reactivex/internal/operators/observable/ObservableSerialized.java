package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8149d;
import io.reactivex.Observer;
import tb.ra2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(AbstractC8149d<T> abstractC8149d) {
        super(abstractC8149d);
    }

    @Override // io.reactivex.AbstractC8149d
    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ra2(observer));
    }
}
