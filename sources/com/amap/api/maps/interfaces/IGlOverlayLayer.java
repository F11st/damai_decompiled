package com.amap.api.maps.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IGlOverlayLayer {
    boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng);

    boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng);

    int getCurrentParticleNum(String str);

    LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng);

    void prepareIcon(Object obj);

    void processCircleHoleOption(CircleOptions circleOptions);

    void processPolygonHoleOption(PolygonOptions polygonOptions);

    boolean removeOverlay(String str) throws RemoteException;

    void updateOption(String str, Object obj);
}
