package com.amap.api.mapcore.util;

import android.graphics.PointF;
import android.os.RemoteException;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.z */
/* loaded from: classes10.dex */
class C4648z implements IProjectionDelegate {
    private IAMapDelegate a;

    public C4648z(IAMapDelegate iAMapDelegate) {
        this.a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) throws RemoteException {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.a;
        LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IAMapDelegate iAMapDelegate2 = this.a;
        LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        int xVar = Point.getx(obtain);
        int i3 = 20 - i;
        int i4 = (xVar >> i3) / i2;
        int yVar = (Point.gety(obtain) >> i3) / i2;
        int xVar2 = (Point.getx(obtain2) >> i3) / i2;
        int yVar2 = Point.gety(obtain2);
        int i5 = (yVar2 >> i3) / i2;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection((xVar - ((i4 << i3) * i2)) >> i3, (yVar2 - ((i5 << i3) * i2)) >> i3, i4, xVar2, i5, yVar);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public LatLng fromScreenLocation(android.graphics.Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.a.getPixel2LatLng(Point.getx(point), Point.gety(point), obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public AMapCameraInfo getCameraInfo() {
        return this.a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public LatLngBounds getMapBounds(LatLng latLng, float f) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.a.getMapWidth();
        int mapHeight = this.a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new android.graphics.Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new android.graphics.Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new android.graphics.Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new android.graphics.Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public float toMapLenWithWin(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.a.toMapLenWithWin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(((PointF) obtain).x, ((PointF) obtain).y);
        obtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public android.graphics.Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        android.graphics.Point point = new android.graphics.Point(Point.getx(obtain), Point.gety(obtain));
        obtain.recycle();
        return point;
    }
}
