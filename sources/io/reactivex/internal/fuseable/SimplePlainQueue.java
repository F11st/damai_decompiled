package io.reactivex.internal.fuseable;

import io.reactivex.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    T poll();
}
