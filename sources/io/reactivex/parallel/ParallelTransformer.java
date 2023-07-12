package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

/* compiled from: Taobao */
@Experimental
/* loaded from: classes3.dex */
public interface ParallelTransformer<Upstream, Downstream> {
    @NonNull
    AbstractC8161a<Downstream> apply(@NonNull AbstractC8161a<Upstream> abstractC8161a);
}
