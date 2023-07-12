package io.reactivex.internal.operators.maybe;

import io.reactivex.AbstractC8148c;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
abstract class AbstractMaybeWithUpstream<T, R> extends AbstractC8148c<R> implements HasUpstreamMaybeSource<T> {
    protected final MaybeSource<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public final MaybeSource<T> source() {
        return this.source;
    }
}
