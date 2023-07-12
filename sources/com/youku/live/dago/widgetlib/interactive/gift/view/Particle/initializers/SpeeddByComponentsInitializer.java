package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpeeddByComponentsInitializer implements ParticleInitializer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mMaxSpeedX;
    private float mMaxSpeedY;
    private float mMinSpeedX;
    private float mMinSpeedY;

    public SpeeddByComponentsInitializer(float f, float f2, float f3, float f4) {
        this.mMinSpeedX = f;
        this.mMaxSpeedX = f2;
        this.mMinSpeedY = f3;
        this.mMaxSpeedY = f4;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer
    public void initParticle(Particle particle, Random random) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-706522666")) {
            ipChange.ipc$dispatch("-706522666", new Object[]{this, particle, random});
            return;
        }
        float nextFloat = random.nextFloat();
        float f = this.mMaxSpeedX;
        float f2 = this.mMinSpeedX;
        particle.mSpeedX = (nextFloat * (f - f2)) + f2;
        float nextFloat2 = random.nextFloat();
        float f3 = this.mMaxSpeedY;
        float f4 = this.mMinSpeedY;
        particle.mSpeedY = (nextFloat2 * (f3 - f4)) + f4;
    }
}
