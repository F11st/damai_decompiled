package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    @NonNull
    a<Downstream> apply(@NonNull a<Upstream> aVar);
}
