package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface FlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull b<T> bVar);
}
