package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.AbstractC8161a;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ParallelFromArray<T> extends AbstractC8161a<T> {
    final Publisher<T>[] sources;

    public ParallelFromArray(Publisher<T>[] publisherArr) {
        this.sources = publisherArr;
    }

    @Override // io.reactivex.parallel.AbstractC8161a
    public int parallelism() {
        return this.sources.length;
    }

    @Override // io.reactivex.parallel.AbstractC8161a
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            for (int i = 0; i < length; i++) {
                this.sources[i].subscribe(subscriberArr[i]);
            }
        }
    }
}
