package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC8152e;
import io.reactivex.ObservableSource;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;
import tb.dg0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ObservableReduceWithSingle<T, R> extends AbstractC8152e<R> {
    final BiFunction<R, ? super T, R> reducer;
    final Callable<R> seedSupplier;
    final ObservableSource<T> source;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = observableSource;
        this.seedSupplier = callable;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.AbstractC8152e
    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.reducer, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            dg0.b(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}