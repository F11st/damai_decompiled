package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8149d;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
abstract class AbstractObservableWithUpstream<T, U> extends AbstractC8149d<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public final ObservableSource<T> source() {
        return this.source;
    }
}
