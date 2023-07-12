package com.autonavi.base.amap.mapcore;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    void onMapRender(int i, int i2);

    void reloadMapResource(int i, String str, int i2);

    byte[] requireCharBitmap(int i, int i2, int i3);

    byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3);

    @Deprecated
    void requireMapData(int i, byte[] bArr);

    int requireMapDataAsyn(int i, byte[] bArr);

    void requireMapRender(int i, int i2, int i3);

    byte[] requireMapResource(int i, String str);
}
