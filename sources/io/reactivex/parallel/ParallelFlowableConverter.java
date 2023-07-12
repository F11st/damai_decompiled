package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface ParallelFlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull a<T> aVar);
}
