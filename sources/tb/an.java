package tb;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class an<T> extends io.reactivex.b<T> {
    @NonNull
    public io.reactivex.b<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @NonNull
    public io.reactivex.b<T> refCount() {
        return i42.l(new FlowableRefCount(this));
    }

    @NonNull
    public io.reactivex.b<T> autoConnect(int i) {
        return autoConnect(i, Functions.emptyConsumer());
    }

    @NonNull
    public io.reactivex.b<T> autoConnect(int i, @NonNull Consumer<? super Disposable> consumer) {
        if (i <= 0) {
            connect(consumer);
            return i42.q(this);
        }
        return i42.l(new FlowableAutoConnect(this, i, consumer));
    }
}
