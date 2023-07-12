package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BuildingOverlayOptions;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapNativeBuildingRenderer {
    public static native void addBuildingOptions(long j, BuildingOverlayOptions buildingOverlayOptions);

    public static native void nativeClearBuildingOptions(long j);

    public static native long nativeCreate();

    public static native void nativeDestory(long j);

    public static native void nativeSetGLShaderManager(long j, long j2);

    public static native void render(long j, float[] fArr, float[] fArr2, int i, int i2, float f, int[] iArr);

    public static native void setCurTileIDs(long j, int[] iArr);
}
