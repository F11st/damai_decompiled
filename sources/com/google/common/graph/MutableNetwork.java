package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import tb.re0;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(N n, N n2, E e);

    @CanIgnoreReturnValue
    boolean addEdge(re0<N> re0Var, E e);

    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    boolean removeEdge(E e);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
