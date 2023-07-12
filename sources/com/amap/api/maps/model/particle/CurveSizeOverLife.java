package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.AMapNativeParticleSystem;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CurveSizeOverLife extends SizeOverLife {
    private float x;
    private float y;
    private float z;

    public CurveSizeOverLife(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.type = 0;
        createNativeInstace();
    }

    @Override // com.autonavi.amap.mapcore.AbstractNativeInstance
    public void createNativeInstace() {
        try {
            this.nativeInstance = AMapNativeParticleSystem.nativeCreateCurveSizeOverLife(this.x, this.y, this.z);
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f) {
        return 0.0f;
    }
}
