package com.google.common.cache;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import tb.cf;

/* compiled from: Taobao */
/* renamed from: com.google.common.cache.a */
/* loaded from: classes10.dex */
public final class C4891a implements AbstractCache$StatsCounter {
    private final LongAddable a = LongAddables.a();
    private final LongAddable b = LongAddables.a();
    private final LongAddable c = LongAddables.a();
    private final LongAddable d = LongAddables.a();
    private final LongAddable e = LongAddables.a();
    private final LongAddable f = LongAddables.a();

    private static long b(long j) {
        return j >= 0 ? j : AbsPerformance.LONG_NIL;
    }

    public void a(AbstractCache$StatsCounter abstractCache$StatsCounter) {
        cf snapshot = abstractCache$StatsCounter.snapshot();
        this.a.add(snapshot.b());
        this.b.add(snapshot.e());
        this.c.add(snapshot.d());
        this.d.add(snapshot.c());
        this.e.add(snapshot.f());
        this.f.add(snapshot.a());
    }

    @Override // com.google.common.cache.AbstractCache$StatsCounter
    public void recordEviction() {
        this.f.increment();
    }

    @Override // com.google.common.cache.AbstractCache$StatsCounter
    public void recordHits(int i) {
        this.a.add(i);
    }

    @Override // com.google.common.cache.AbstractCache$StatsCounter
    public void recordLoadException(long j) {
        this.d.increment();
        this.e.add(j);
    }

    @Override // com.google.common.cache.AbstractCache$StatsCounter
    public void recordLoadSuccess(long j) {
        this.c.increment();
        this.e.add(j);
    }

    @Override // com.google.common.cache.AbstractCache$StatsCounter
    public void recordMisses(int i) {
        this.b.add(i);
    }

    @Override // com.google.common.cache.AbstractCache$StatsCounter
    public cf snapshot() {
        return new cf(b(this.a.sum()), b(this.b.sum()), b(this.c.sum()), b(this.d.sum()), b(this.e.sum()), b(this.f.sum()));
    }
}
