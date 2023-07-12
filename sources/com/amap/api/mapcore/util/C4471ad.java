package com.amap.api.mapcore.util;

import android.util.Pair;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.ad */
/* loaded from: classes10.dex */
public class C4471ad extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> a = eq.a(this, iGLMapState, this.mapConfig);
        if (a == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) a.first).floatValue());
        Object obj = a.second;
        iGLMapState.setMapGeoCenter(Point.getx((IPoint) obj), Point.gety((IPoint) obj));
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
