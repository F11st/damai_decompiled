package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ScaleModifier implements ParticleModifier {
    private static transient /* synthetic */ IpChange $ipChange;
    private long mDuration;
    private long mEndTime;
    private float mFinalValue;
    private float mInitialValue;
    private Interpolator mInterpolator;
    private long mStartTime;
    private float mValueIncrement;

    public ScaleModifier(float f, float f2, long j, long j2, Interpolator interpolator) {
        this.mInitialValue = f;
        this.mFinalValue = f2;
        this.mStartTime = j;
        this.mEndTime = j2;
        this.mDuration = j2 - j;
        this.mValueIncrement = f2 - f;
        this.mInterpolator = interpolator;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers.ParticleModifier
    public void apply(Particle particle, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829296754")) {
            ipChange.ipc$dispatch("829296754", new Object[]{this, particle, Long.valueOf(j)});
            return;
        }
        long j2 = this.mStartTime;
        if (j < j2) {
            particle.mScale = this.mInitialValue;
        } else if (j > this.mEndTime) {
            particle.mScale = this.mFinalValue;
        } else {
            particle.mScale = this.mInitialValue + (this.mValueIncrement * this.mInterpolator.getInterpolation((((float) (j - j2)) * 1.0f) / ((float) this.mDuration)));
        }
    }

    public ScaleModifier(float f, float f2, long j, long j2) {
        this(f, f2, j, j2, new LinearInterpolator());
    }
}
