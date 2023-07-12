package com.amap.api.location;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CoordUtil {
    private static boolean a;

    public static native int convertToGcj(double[] dArr, double[] dArr2);

    public static boolean isLoadedSo() {
        return a;
    }

    public static void setLoadedSo(boolean z) {
        a = z;
    }
}
