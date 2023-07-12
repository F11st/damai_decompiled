package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpeedModuleAndRangeInitializer implements ParticleInitializer {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mMaxAngle;
    private int mMinAngle;
    private float mSpeedMax;
    private float mSpeedMin;

    public SpeedModuleAndRangeInitializer(float f, float f2, int i, int i2) {
        int i3;
        this.mSpeedMin = f;
        this.mSpeedMax = f2;
        this.mMinAngle = i;
        this.mMaxAngle = i2;
        while (true) {
            int i4 = this.mMinAngle;
            if (i4 >= 0) {
                break;
            }
            this.mMinAngle = i4 + 360;
        }
        while (true) {
            i3 = this.mMaxAngle;
            if (i3 >= 0) {
                break;
            }
            this.mMaxAngle = i3 + 360;
        }
        int i5 = this.mMinAngle;
        if (i5 > i3) {
            this.mMinAngle = i3;
            this.mMaxAngle = i5;
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer
    public void initParticle(Particle particle, Random random) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-599344959")) {
            ipChange.ipc$dispatch("-599344959", new Object[]{this, particle, random});
            return;
        }
        float nextFloat = random.nextFloat();
        float f = this.mSpeedMax;
        float f2 = this.mSpeedMin;
        float f3 = (nextFloat * (f - f2)) + f2;
        int i = this.mMaxAngle;
        int i2 = this.mMinAngle;
        if (i != i2) {
            i2 = random.nextInt(i - i2) + this.mMinAngle;
        }
        double radians = Math.toRadians(i2);
        double d = f3;
        particle.mSpeedX = (float) (Math.cos(radians) * d);
        particle.mSpeedY = (float) (d * Math.sin(radians));
        particle.mInitialRotation = i2 + 90;
    }
}
