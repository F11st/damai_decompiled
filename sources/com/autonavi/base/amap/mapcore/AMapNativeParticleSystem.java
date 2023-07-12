package com.autonavi.base.amap.mapcore;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapNativeParticleSystem {
    public static native int getCurrentParticleNum(long j);

    public static native long nativeCreate();

    public static native long nativeCreateConstantRotationOverLife(float f);

    public static native long nativeCreateCurveSizeOverLife(float f, float f2, float f3);

    public static native long nativeCreateParticleEmissionModule(int i, int i2);

    public static native long nativeCreateParticleOverLifeModule();

    public static native long nativeCreateRandomColorBetWeenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    public static native long nativeCreateRandomVelocityBetweenTwoConstants(float f, float f2, float f3, float f4, float f5, float f6);

    public static native long nativeCreateRectParticleShape(float f, float f2, float f3, float f4, boolean z);

    public static native long nativeCreateSinglePointParticleShape(float f, float f2, float f3, boolean z);

    public static native long nativeDestroy(long j);

    public static native void nativeReleaseColorGenerate(long j);

    public static native void nativeReleaseParticleEmissonModule(long j);

    public static native void nativeReleaseParticleOverLifeModule(long j);

    public static native void nativeReleaseParticleShapeModule(long j);

    public static native void nativeReleaseRotationOverLife(long j);

    public static native void nativeReleaseSizeOverLife(long j);

    public static native void nativeReleaseVelocityOverLife(long j);

    public static native void nativeRender(long j, float[] fArr, float[] fArr2, int i, int i2, float f, float f2, float f3);

    public static native void nativeSetGLShaderManager(long j, long j2);

    public static native void nativeSetOverLifeItem(long j, long j2, int i);

    public static native void nativeSetTextureId(long j, int i);

    public static native void setDuration(long j, long j2);

    public static native void setLoop(long j, boolean z);

    public static native void setMaxParticles(long j, int i);

    public static native void setParticleEmission(long j, long j2);

    public static native void setParticleLifeTime(long j, long j2);

    public static native void setParticleOverLifeModule(long j, long j2);

    public static native void setParticleShapeModule(long j, long j2);

    public static native void setParticleStartSpeed(long j, long j2);

    public static native void setPreWram(long j, boolean z);

    public static native void setStartColor(long j, long j2);

    public static native void setStartParticleSize(long j, float f, float f2);
}
