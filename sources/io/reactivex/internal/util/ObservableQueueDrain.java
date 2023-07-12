package io.reactivex.internal.util;

import io.reactivex.Observer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> observer, T t);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i);
}
