package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import tb.re0;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public interface MutableGraph<N> extends Graph<N> {
    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    boolean putEdge(N n, N n2);

    @CanIgnoreReturnValue
    boolean putEdge(re0<N> re0Var);

    @CanIgnoreReturnValue
    boolean removeEdge(N n, N n2);

    @CanIgnoreReturnValue
    boolean removeEdge(re0<N> re0Var);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
