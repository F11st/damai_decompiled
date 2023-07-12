package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8149d;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableNever extends AbstractC8149d<Object> {
    public static final AbstractC8149d<Object> INSTANCE = new ObservableNever();

    private ObservableNever() {
    }

    @Override // io.reactivex.AbstractC8149d
    protected void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
