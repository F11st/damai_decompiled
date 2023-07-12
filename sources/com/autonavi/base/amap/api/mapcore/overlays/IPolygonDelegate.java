package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.interfaces.IPolygon;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IPolygonDelegate extends IPolygon, IOverlayDelegate {
    List<LatLng> getHoles();

    boolean isGeodesic();

    void setGeodesic(boolean z);

    void setHoles(List<LatLng> list) throws RemoteException;
}
