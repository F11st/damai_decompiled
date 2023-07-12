package com.youku.opengl.a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class c {
    public static final float[] a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] b = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    public static final float[] c = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    private static float a(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    public static float[] a(int i, boolean z, boolean z2) {
        if (a.b) {
            a.a("TexRotationUtil", "getRotation() - renderType:" + i + " flipHorizontal:" + z + " flipVertical:" + z2);
        }
        int a2 = b.a(i);
        float[] fArr = a2 != 90 ? a2 != 180 ? a2 != 270 ? a : d : c : b;
        if (z) {
            fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
        }
        return z2 ? new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])} : fArr;
    }
}
