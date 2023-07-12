package com.google.common.cache;

import tb.cf;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface AbstractCache$StatsCounter {
    void recordEviction();

    void recordHits(int i);

    void recordLoadException(long j);

    void recordLoadSuccess(long j);

    void recordMisses(int i);

    cf snapshot();
}
