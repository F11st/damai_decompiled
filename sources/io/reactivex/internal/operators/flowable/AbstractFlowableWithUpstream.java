package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC8147b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
abstract class AbstractFlowableWithUpstream<T, R> extends AbstractC8147b<R> implements HasUpstreamPublisher<T> {
    protected final AbstractC8147b<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractFlowableWithUpstream(AbstractC8147b<T> abstractC8147b) {
        this.source = (AbstractC8147b) ObjectHelper.requireNonNull(abstractC8147b, "source is null");
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public final Publisher<T> source() {
        return this.source;
    }
}
