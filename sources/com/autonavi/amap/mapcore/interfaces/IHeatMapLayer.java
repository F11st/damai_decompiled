package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.HeatMapItem;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IHeatMapLayer extends IOverlay {
    HeatMapItem getHeatMapItem(LatLng latLng);

    HeatMapLayerOptions getOptions();

    void setOptions(HeatMapLayerOptions heatMapLayerOptions);
}
