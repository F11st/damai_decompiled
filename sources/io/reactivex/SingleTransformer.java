package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface SingleTransformer<Upstream, Downstream> {
    @NonNull
    SingleSource<Downstream> apply(@NonNull e<Upstream> eVar);
}
