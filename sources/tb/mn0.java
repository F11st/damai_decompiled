package tb;

import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import org.reactivestreams.Processor;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class mn0<T> extends io.reactivex.b<T> implements Processor<T, T>, FlowableSubscriber<T> {
    @CheckReturnValue
    @NonNull
    public final mn0<T> a() {
        return this instanceof sa2 ? this : new sa2(this);
    }
}
