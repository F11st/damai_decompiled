package com.autonavi.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.particle.ColorGenerate;
import com.amap.api.maps.model.particle.ParticleEmissionModule;
import com.amap.api.maps.model.particle.ParticleOverLifeModule;
import com.amap.api.maps.model.particle.ParticleShapeModule;
import com.amap.api.maps.model.particle.VelocityGenerate;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IParticleLatyer {
    void destroy();

    int getCurrentParticleNum();

    void pause();

    void setCustomTexture(BitmapDescriptor bitmapDescriptor);

    void setDuration(long j);

    void setLoop(boolean z);

    void setMaxParticles(int i);

    void setParticleEmission(ParticleEmissionModule particleEmissionModule);

    void setParticleLifeTime(long j);

    void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule);

    void setParticleShapeModule(ParticleShapeModule particleShapeModule);

    void setParticleStartSpeed(VelocityGenerate velocityGenerate);

    void setPreWram(boolean z);

    void setStartColor(ColorGenerate colorGenerate);

    void setStartParticleSize(int i, int i2);

    void setVisible(boolean z) throws RemoteException;

    void start();

    void stop();
}
