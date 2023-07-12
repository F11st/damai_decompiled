package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ScaleInitializer implements ParticleInitializer {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mMaxScale;
    private float mMinScale;

    public ScaleInitializer(float f, float f2) {
        this.mMinScale = f;
        this.mMaxScale = f2;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.initializers.ParticleInitializer
    public void initParticle(Particle particle, Random random) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711073650")) {
            ipChange.ipc$dispatch("711073650", new Object[]{this, particle, random});
            return;
        }
        float nextFloat = random.nextFloat();
        float f = this.mMaxScale;
        float f2 = this.mMinScale;
        particle.mScale = (nextFloat * (f - f2)) + f2;
    }
}
