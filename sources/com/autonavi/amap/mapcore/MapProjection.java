package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MapProjection {
    public static void geo2LonLat(int i, int i2, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d, double d2, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d, 20);
        ((Point) iPoint).x = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels);
        ((Point) iPoint).y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels);
    }
}
