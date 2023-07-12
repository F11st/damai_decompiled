package org.reactivestreams;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Subscription subscription);
}
