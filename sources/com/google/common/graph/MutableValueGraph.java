package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import tb.re0;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    V putEdgeValue(N n, N n2, V v);

    @CanIgnoreReturnValue
    V putEdgeValue(re0<N> re0Var, V v);

    @CanIgnoreReturnValue
    V removeEdge(N n, N n2);

    @CanIgnoreReturnValue
    V removeEdge(re0<N> re0Var);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
