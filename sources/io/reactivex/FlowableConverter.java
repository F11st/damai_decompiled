package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface FlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull AbstractC8147b<T> abstractC8147b);
}
