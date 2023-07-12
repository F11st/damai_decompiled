package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ah {
    public static AbstractCameraUpdateMessage a() {
        ag agVar = new ag();
        agVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        agVar.amount = 1.0f;
        return agVar;
    }

    public static AbstractCameraUpdateMessage b() {
        ag agVar = new ag();
        agVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        agVar.amount = -1.0f;
        return agVar;
    }

    public static AbstractCameraUpdateMessage c(float f) {
        C4472ae c4472ae = new C4472ae();
        c4472ae.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        c4472ae.tilt = f;
        return c4472ae;
    }

    public static AbstractCameraUpdateMessage d(float f) {
        C4472ae c4472ae = new C4472ae();
        c4472ae.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        c4472ae.bearing = f;
        return c4472ae;
    }

    public static AbstractCameraUpdateMessage a(float f, float f2) {
        af afVar = new af();
        afVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        afVar.xPixel = f;
        afVar.yPixel = f2;
        return afVar;
    }

    public static AbstractCameraUpdateMessage b(float f) {
        return a(f, (Point) null);
    }

    public static AbstractCameraUpdateMessage c() {
        return new C4472ae();
    }

    public static AbstractCameraUpdateMessage b(float f, Point point) {
        C4472ae c4472ae = new C4472ae();
        c4472ae.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        c4472ae.geoPoint = new DPoint(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        c4472ae.bearing = f;
        return c4472ae;
    }

    public static AbstractCameraUpdateMessage a(float f) {
        C4472ae c4472ae = new C4472ae();
        c4472ae.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        c4472ae.zoom = f;
        return c4472ae;
    }

    public static AbstractCameraUpdateMessage a(float f, Point point) {
        ag agVar = new ag();
        agVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        agVar.amount = f;
        agVar.focus = point;
        return agVar;
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        LatLng latLng;
        C4472ae c4472ae = new C4472ae();
        c4472ae.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            c4472ae.geoPoint = new DPoint(latLongToPixelsDouble.x, latLongToPixelsDouble.y);
            c4472ae.zoom = cameraPosition.zoom;
            c4472ae.bearing = cameraPosition.bearing;
            c4472ae.tilt = cameraPosition.tilt;
            c4472ae.cameraPosition = cameraPosition;
        }
        return c4472ae;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        C4472ae c4472ae = new C4472ae();
        c4472ae.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        c4472ae.geoPoint = new DPoint(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        return c4472ae;
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng) {
        return a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng, float f) {
        return a(CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i) {
        C4471ad c4471ad = new C4471ad();
        c4471ad.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        c4471ad.bounds = latLngBounds;
        c4471ad.paddingLeft = i;
        c4471ad.paddingRight = i;
        c4471ad.paddingTop = i;
        c4471ad.paddingBottom = i;
        return c4471ad;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        C4471ad c4471ad = new C4471ad();
        c4471ad.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        c4471ad.bounds = latLngBounds;
        c4471ad.paddingLeft = i3;
        c4471ad.paddingRight = i3;
        c4471ad.paddingTop = i3;
        c4471ad.paddingBottom = i3;
        c4471ad.width = i;
        c4471ad.height = i2;
        return c4471ad;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        C4471ad c4471ad = new C4471ad();
        c4471ad.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        c4471ad.bounds = latLngBounds;
        c4471ad.paddingLeft = i;
        c4471ad.paddingRight = i2;
        c4471ad.paddingTop = i3;
        c4471ad.paddingBottom = i4;
        return c4471ad;
    }
}
