package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakuTimer {
    public long currMillisecond;
    private long lastInterval;

    public long add(long j) {
        return update(this.currMillisecond + j);
    }

    public long lastInterval() {
        return this.lastInterval;
    }

    public long update(long j) {
        long j2 = j - this.currMillisecond;
        this.lastInterval = j2;
        this.currMillisecond = j;
        return j2;
    }

    public long update(Long l, int i) {
        if (i == 0) {
            this.lastInterval = l.longValue() - this.currMillisecond;
            this.currMillisecond = l.longValue();
            return this.lastInterval;
        }
        return this.lastInterval;
    }
}
