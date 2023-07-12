package com.amap.api.mapcore.util;

import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.HeatMapItem;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeHeatMapLayer;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.Collection;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ct implements IHeatMapLayer, IOverlayDelegate {
    private C4637r b;
    private String d;
    private boolean f;
    private C4505de g;
    private HeatMapLayerOptions h;
    private boolean i;
    long a = -1;
    private boolean c = true;
    private float e = 0.0f;

    public ct(C4637r c4637r) {
        this.i = false;
        try {
            this.i = false;
            this.b = c4637r;
            this.d = getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a() {
        HeatMapLayerOptions heatMapLayerOptions = this.h;
        return (heatMapLayerOptions == null || heatMapLayerOptions.getData() == null || this.h.getData().size() <= 0 || this.h.getGradient() == null || this.h.getGradient().getColors() == null || this.h.getGradient().getColors().length <= 0 || this.h.getGradient().getStartPoints() == null || this.h.getGradient().getStartPoints().length <= 0) ? false : true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        synchronized (this) {
            this.i = true;
            long j = this.a;
            if (j != -1) {
                AMapNativeHeatMapLayer.nativeDestroy(j);
                this.a = -1L;
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        C4505de c4505de;
        LatLng latLng;
        try {
            if (this.i) {
                return;
            }
            C4637r c4637r = this.b;
            if (c4637r != null && this.g == null) {
                this.g = c4637r.b();
            }
            if (this.g == null || mapConfig == null || !this.c) {
                return;
            }
            if (this.a != -1) {
                synchronized (this) {
                    if (this.a != -1) {
                        if (this.f && a()) {
                            double[] dArr = new double[this.h.getData().size() * 3];
                            Collection<WeightedLatLng> data = this.h.getData();
                            int size = data.size();
                            double d = 0.0d;
                            int i = 0;
                            for (WeightedLatLng weightedLatLng : data) {
                                if (weightedLatLng != null && (latLng = weightedLatLng.latLng) != null) {
                                    int i2 = i * 3;
                                    double d2 = latLng.latitude;
                                    dArr[i2 + 0] = d2;
                                    dArr[i2 + 1] = latLng.longitude;
                                    dArr[i2 + 2] = weightedLatLng.intensity;
                                    d += d2 / size;
                                } else {
                                    Log.e("mapcore", "read file failed");
                                }
                                i++;
                            }
                            AMapNativeHeatMapLayer.nativeSetOptions(this.a, dArr, (int) this.h.getMaxIntensity(), this.h.getSize(), this.h.getGradient().getColors(), this.h.getGradient().getStartPoints(), this.h.getMaxZoom(), this.h.getMinZoom(), this.h.getOpacity(), this.h.getGap(), this.h.getType(), d);
                            this.f = false;
                        }
                        AMapNativeHeatMapLayer.nativeRender(this.a, mapConfig.getViewMatrix(), mapConfig.getProjectionMatrix(), (int) mapConfig.getSX(), (int) mapConfig.getSY(), mapConfig.getSZ());
                    }
                }
                return;
            }
            long nativeCreate = AMapNativeHeatMapLayer.nativeCreate();
            this.a = nativeCreate;
            if (nativeCreate == -1 || (c4505de = this.g) == null) {
                return;
            }
            AMapNativeHeatMapLayer.nativeSetGLShaderManager(nativeCreate, c4505de.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IHeatMapLayer
    public HeatMapItem getHeatMapItem(LatLng latLng) {
        Object nativeGetHeatMapItem;
        if (latLng == null) {
            return null;
        }
        long j = this.a;
        if (j == -1 || (nativeGetHeatMapItem = AMapNativeHeatMapLayer.nativeGetHeatMapItem(j, latLng.latitude, latLng.longitude)) == null || !(nativeGetHeatMapItem instanceof HeatMapItem)) {
            return null;
        }
        return (HeatMapItem) nativeGetHeatMapItem;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.d == null) {
            this.d = this.b.a("HeatMapLayer");
        }
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IHeatMapLayer
    public HeatMapLayerOptions getOptions() {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        C4637r c4637r = this.b;
        if (c4637r == null || c4637r.a(this.d, true)) {
            return;
        }
        destroy();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IHeatMapLayer
    public void setOptions(HeatMapLayerOptions heatMapLayerOptions) {
        this.h = heatMapLayerOptions;
        if (heatMapLayerOptions != null) {
            this.e = heatMapLayerOptions.getZIndex();
            this.c = this.h.isVisible();
        }
        this.f = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        this.c = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
        try {
            this.e = f;
            this.b.e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(C4505de c4505de) {
        this.g = c4505de;
    }
}
