package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface SingleConverter<T, R> {
    @NonNull
    R apply(@NonNull e<T> eVar);
}
