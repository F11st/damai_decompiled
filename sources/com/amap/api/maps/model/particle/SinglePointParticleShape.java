package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f, float f2, float f3, boolean z) {
        this.point_3 = r0;
        float[] fArr = {f, f2, f3};
        this.isUseRatio = z;
        createNativeInstace();
        this.type = 0;
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            float[] fArr = this.point_3;
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateSinglePointParticleShape(fArr[0], fArr[1], fArr[2], this.isUseRatio);
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }

    public SinglePointParticleShape(float f, float f2, float f3) {
        this(f, f2, f3, false);
    }
}
