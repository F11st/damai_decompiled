package io.reactivex;

import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface MaybeOperator<Downstream, Upstream> {
    @NonNull
    MaybeObserver<? super Upstream> apply(@NonNull MaybeObserver<? super Downstream> maybeObserver) throws Exception;
}
