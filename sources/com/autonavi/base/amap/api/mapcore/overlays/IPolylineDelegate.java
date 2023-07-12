package com.autonavi.base.amap.api.mapcore.overlays;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.interfaces.IPolyline;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IPolylineDelegate extends IPolyline, IOverlayDelegate {
    boolean contains(LatLng latLng);

    void reLoadTexture();

    void setColorValues(List<Integer> list);

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    void setCustomTextureList(List<BitmapDescriptor> list);

    void useGradient(boolean z);
}
