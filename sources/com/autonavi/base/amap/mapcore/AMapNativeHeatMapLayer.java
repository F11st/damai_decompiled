package com.autonavi.base.amap.mapcore;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapNativeHeatMapLayer {
    public static native long nativeCreate();

    public static native long nativeDestroy(long j);

    public static native Object nativeGetHeatMapItem(long j, double d, double d2);

    public static native void nativeRender(long j, float[] fArr, float[] fArr2, int i, int i2, float f);

    public static native void nativeSetGLShaderManager(long j, long j2);

    public static native void nativeSetOptions(long j, double[] dArr, int i, float f, int[] iArr, float[] fArr, float f2, float f3, float f4, float f5, int i2, double d);
}
