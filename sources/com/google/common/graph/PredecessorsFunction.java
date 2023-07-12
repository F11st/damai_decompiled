package com.google.common.graph;

import com.google.common.annotations.Beta;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public interface PredecessorsFunction<N> {
    Iterable<? extends N> predecessors(N n);
}
