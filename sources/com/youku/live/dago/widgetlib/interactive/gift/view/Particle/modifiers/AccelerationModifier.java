package com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.Particle.Particle;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AccelerationModifier implements ParticleModifier {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mVelocityX;
    private float mVelocityY;

    public AccelerationModifier(float f, float f2) {
        double d = f;
        double d2 = (float) ((f2 * 3.141592653589793d) / 180.0d);
        this.mVelocityX = (float) (Math.cos(d2) * d);
        this.mVelocityY = (float) (d * Math.sin(d2));
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.Particle.modifiers.ParticleModifier
    public void apply(Particle particle, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749207998")) {
            ipChange.ipc$dispatch("1749207998", new Object[]{this, particle, Long.valueOf(j)});
            return;
        }
        float f = (float) j;
        particle.mCurrentX += this.mVelocityX * f * f;
        particle.mCurrentY += this.mVelocityY * f * f;
    }
}
