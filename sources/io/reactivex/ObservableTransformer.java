package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull d<Upstream> dVar);
}
