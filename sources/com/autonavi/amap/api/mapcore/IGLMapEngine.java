package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i);
}
