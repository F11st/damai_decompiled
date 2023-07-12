package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RotationInitializer implements ParticleInitializer {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mMaxAngle;
    private int mMinAngle;

    public RotationInitializer(int i, int i2) {
        this.mMinAngle = i;
        this.mMaxAngle = i2;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer
    public void initParticle(Particle particle, Random random) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "270692458")) {
            ipChange.ipc$dispatch("270692458", new Object[]{this, particle, random});
            return;
        }
        int i = this.mMinAngle;
        int i2 = this.mMaxAngle;
        particle.mInitialRotation = i == i2 ? i : random.nextInt(i2 - i) + this.mMinAngle;
    }
}
