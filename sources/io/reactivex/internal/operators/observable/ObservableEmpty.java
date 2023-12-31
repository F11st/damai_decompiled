package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableEmpty extends d<Object> implements ScalarCallable<Object> {
    public static final d<Object> INSTANCE = new ObservableEmpty();

    private ObservableEmpty() {
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.d
    protected void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete(observer);
    }
}
