package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean tryOnNext(T t);
}
