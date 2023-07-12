package com.autonavi.base.amap.mapcore;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapNativeRenderer {
    public static native void nativeDrawGradientColorLine(float[] fArr, int i, float f, int[] iArr, int i2, int[] iArr2, int i3, int i4, float[] fArr2, int i5, int i6);

    public static native void nativeDrawLineByMultiColor(float[] fArr, int i, float f, int i2, int[] iArr, int i3, int[] iArr2, int i4, float[] fArr2, int i5, int i6);

    public static native void nativeDrawLineByMultiTextureID(float[] fArr, int i, float f, int[] iArr, float f2, int i2, int[] iArr2, int i3, float f3, float[] fArr2, int i4, int i5);

    public static void nativeDrawLineByTextureID(float[] fArr, int i, float f, int i2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2, boolean z3, float[] fArr2, int i3, int i4) {
        nativeDrawLineByTextureID(fArr, i, f, i2, f2, f3, f4, f5, f6, f7, z, z2, z3, fArr2, i3, i4, false);
    }

    public static native void nativeDrawLineByTextureID(float[] fArr, int i, float f, int i2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2, boolean z3, float[] fArr2, int i3, int i4, boolean z4);

    public static native void nativeDrawLineInit();
}
