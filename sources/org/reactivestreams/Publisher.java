package org.reactivestreams;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
