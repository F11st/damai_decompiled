package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IGLMapState {
    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i, int i2, Point point);

    void setCameraDegree(float f);

    void setMapAngle(float f);

    void setMapGeoCenter(double d, double d2);

    void setMapZoomer(float f);
}
