package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface MaybeTransformer<Upstream, Downstream> {
    @NonNull
    MaybeSource<Downstream> apply(@NonNull c<Upstream> cVar);
}
