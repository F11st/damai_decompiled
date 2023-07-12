package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.util.ConnectConsumer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class bn<T> extends io.reactivex.d<T> {
    @NonNull
    public io.reactivex.d<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @NonNull
    public io.reactivex.d<T> refCount() {
        return i42.n(new ObservableRefCount(this));
    }

    @NonNull
    public io.reactivex.d<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    @NonNull
    public io.reactivex.d<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        if (i <= 0) {
            connect(consumer);
            return i42.r(this);
        }
        return i42.n(new ObservableAutoConnect(this, i, consumer));
    }
}
