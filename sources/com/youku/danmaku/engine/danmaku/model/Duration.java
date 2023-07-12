package com.youku.danmaku.engine.danmaku.model;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Duration {
    public float factor = 1.0f;
    public long mInitialDuration;
    public long value;

    public Duration(long j) {
        this.mInitialDuration = j;
        this.value = j;
    }

    public void setFactor(float f) {
        if (this.factor != f) {
            this.factor = f;
            this.value = ((float) this.mInitialDuration) * f;
        }
    }

    public void setValue(long j) {
        this.mInitialDuration = j;
        this.value = ((float) j) * this.factor;
    }

    public void setFactor(float f, long j) {
        this.mInitialDuration = j;
        this.factor = f;
        this.value = ((float) j) * f;
    }
}
