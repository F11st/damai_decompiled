package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SingleLift<T, R> extends e<R> {
    final SingleOperator<? extends R, ? super T> onLift;
    final SingleSource<T> source;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.source = singleSource;
        this.onLift = singleOperator;
    }

    @Override // io.reactivex.e
    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe((SingleObserver) ObjectHelper.requireNonNull(this.onLift.apply(singleObserver), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            dg0.b(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
