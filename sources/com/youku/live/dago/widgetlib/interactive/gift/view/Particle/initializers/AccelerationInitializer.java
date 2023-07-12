package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AccelerationInitializer implements ParticleInitializer {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mMaxAngle;
    private float mMaxValue;
    private int mMinAngle;
    private float mMinValue;

    public AccelerationInitializer(float f, float f2, int i, int i2) {
        this.mMinValue = f;
        this.mMaxValue = f2;
        this.mMinAngle = i;
        this.mMaxAngle = i2;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer
    public void initParticle(Particle particle, Random random) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214270228")) {
            ipChange.ipc$dispatch("-214270228", new Object[]{this, particle, random});
            return;
        }
        int i = this.mMinAngle;
        float f = i;
        int i2 = this.mMaxAngle;
        if (i2 != i) {
            f = random.nextInt(i2 - i) + this.mMinAngle;
        }
        float nextFloat = random.nextFloat();
        float f2 = this.mMaxValue;
        float f3 = this.mMinValue;
        double d = (nextFloat * (f2 - f3)) + f3;
        double d2 = (float) ((f * 3.141592653589793d) / 180.0d);
        particle.mAccelerationX = (float) (Math.cos(d2) * d);
        particle.mAccelerationY = (float) (d * Math.sin(d2));
    }
}
