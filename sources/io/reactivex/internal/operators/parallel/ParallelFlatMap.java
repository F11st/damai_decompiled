package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.a;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ParallelFlatMap<T, R> extends a<R> {
    final boolean delayError;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final a<T> source;

    public ParallelFlatMap(a<T> aVar, Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        this.source = aVar;
        this.mapper = function;
        this.delayError = z;
        this.maxConcurrency = i;
        this.prefetch = i2;
    }

    @Override // io.reactivex.parallel.a
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.a
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableFlatMap.subscribe(subscriberArr[i], this.mapper, this.delayError, this.maxConcurrency, this.prefetch);
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
