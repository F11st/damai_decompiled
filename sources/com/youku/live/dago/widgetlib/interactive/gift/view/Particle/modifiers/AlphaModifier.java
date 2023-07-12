package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.C7945Particle;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AlphaModifier implements ParticleModifier {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mDuration;
    private long mEndTime;
    private int mFinalValue;
    private int mInitialValue;
    private Interpolator mInterpolator;
    private long mStartTime;
    private float mValueIncrement;

    public AlphaModifier(int i, int i2, long j, long j2, Interpolator interpolator) {
        this.mInitialValue = i;
        this.mFinalValue = i2;
        this.mStartTime = j;
        this.mEndTime = j2;
        this.mDuration = (float) (j2 - j);
        this.mValueIncrement = i2 - i;
        this.mInterpolator = interpolator;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers.ParticleModifier
    public void apply(C7945Particle c7945Particle, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807850462")) {
            ipChange.ipc$dispatch("1807850462", new Object[]{this, c7945Particle, Long.valueOf(j)});
            return;
        }
        long j2 = this.mStartTime;
        if (j < j2) {
            c7945Particle.mAlpha = this.mInitialValue;
        } else if (j > this.mEndTime) {
            c7945Particle.mAlpha = this.mFinalValue;
        } else {
            c7945Particle.mAlpha = (int) (this.mInitialValue + (this.mValueIncrement * this.mInterpolator.getInterpolation((((float) (j - j2)) * 1.0f) / this.mDuration)));
        }
    }

    public AlphaModifier(int i, int i2, long j, long j2) {
        this(i, i2, j, j2, new LinearInterpolator());
    }
}
