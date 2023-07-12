package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.C7945Particle;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RotationSpeedInitializer implements ParticleInitializer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mMaxRotationSpeed;
    private float mMinRotationSpeed;

    public RotationSpeedInitializer(float f, float f2) {
        this.mMinRotationSpeed = f;
        this.mMaxRotationSpeed = f2;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer
    public void initParticle(C7945Particle c7945Particle, Random random) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135015855")) {
            ipChange.ipc$dispatch("-135015855", new Object[]{this, c7945Particle, random});
            return;
        }
        float nextFloat = random.nextFloat();
        float f = this.mMaxRotationSpeed;
        float f2 = this.mMinRotationSpeed;
        c7945Particle.mRotationSpeed = (nextFloat * (f - f2)) + f2;
    }
}
