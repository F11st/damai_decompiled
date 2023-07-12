package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HeatMapLayer {
    private IHeatMapLayer mHeatMapLayer;

    public HeatMapLayer(IHeatMapLayer iHeatMapLayer) {
        this.mHeatMapLayer = iHeatMapLayer;
    }

    public void destroy() {
        try {
            this.mHeatMapLayer.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof HeatMapLayer)) {
            try {
                return this.mHeatMapLayer.equalsRemote(((HeatMapLayer) obj).mHeatMapLayer);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public HeatMapItem getHeatMapItem(LatLng latLng) {
        try {
            return this.mHeatMapLayer.getHeatMapItem(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getId() {
        try {
            return this.mHeatMapLayer.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public HeatMapLayerOptions getOptions() {
        try {
            return this.mHeatMapLayer.getOptions();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        try {
            return this.mHeatMapLayer.getZIndex();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return this.mHeatMapLayer.hashCodeRemote();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            return this.mHeatMapLayer.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void setOptions(HeatMapLayerOptions heatMapLayerOptions) {
        try {
            this.mHeatMapLayer.setOptions(heatMapLayerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            this.mHeatMapLayer.setVisible(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            this.mHeatMapLayer.setZIndex(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
