package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IPolyline;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Polyline extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolylineOptions options;
    private IPolyline polylineDelegate;

    public Polyline(IGlOverlayLayer iGlOverlayLayer, PolylineOptions polylineOptions) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polylineOptions;
    }

    private void a() {
        try {
            synchronized (this) {
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                    setOptionPointList(this.options);
                    iGlOverlayLayer.updateOption(this.overlayName, this.options);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Polyline) {
            try {
                IPolyline iPolyline = this.polylineDelegate;
                if (iPolyline != null) {
                    return iPolyline.equalsRemote(((Polyline) obj).polylineDelegate);
                }
                return super.equals(obj) || ((Polyline) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public int getColor() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.getColor();
            }
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public String getId() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.getId();
            }
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng getNearestLatLng(LatLng latLng) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            return iPolyline.getNearestLatLng(latLng);
        }
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.getNearestLatLng(this.options, latLng);
        }
        return null;
    }

    public PolylineOptions getOptions() {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            return iPolyline.getOptions();
        }
        return this.options;
    }

    public List<LatLng> getPoints() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.getPoints();
            }
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getShownRatio() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.getShownRatio();
            }
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getShownRatio();
            }
            return -1.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1.0f;
        }
    }

    public float getWidth() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.getWidth();
            }
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.getZIndex();
            }
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.hashCodeRemote();
            }
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isDottedLine() {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            return iPolyline.isDottedLine();
        }
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            return polylineOptions.isDottedLine();
        }
        return false;
    }

    public boolean isGeodesic() {
        if (this.polylineDelegate.isGeodesic()) {
            return true;
        }
        PolylineOptions polylineOptions = this.options;
        return polylineOptions != null && polylineOptions.isGeodesic();
    }

    public boolean isVisible() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                return iPolyline.isVisible();
            }
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.remove();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            BitmapDescriptor customTexture = this.options.getCustomTexture();
            if (customTexture != null) {
                customTexture.recycle();
            }
            if (this.options.getCustomTextureList() != null) {
                for (BitmapDescriptor bitmapDescriptor : this.options.getCustomTextureList()) {
                    bitmapDescriptor.recycle();
                }
                this.options.getCustomTextureList().clear();
            }
            this.options = null;
            this.overlayName = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAboveMaskLayer(boolean z) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            iPolyline.setAboveMaskLayer(z);
            return;
        }
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.aboveMaskLayer(z);
            a();
        }
    }

    public void setColor(int i) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setColor(i);
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.color(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCustemTextureIndex(List<Integer> list) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            iPolyline.setCustemTextureIndex(list);
            return;
        }
        synchronized (this) {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setCustomTextureIndex(list);
                a();
            }
        }
    }

    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            iPolyline.setCustomTexture(bitmapDescriptor);
            return;
        }
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setCustomTexture(bitmapDescriptor);
            a();
        }
    }

    public void setCustomTextureList(List<BitmapDescriptor> list) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setCustomTextureList(list);
            } else {
                this.options.setCustomTextureList(list);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDottedLine(boolean z) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            iPolyline.setDottedLine(z);
            return;
        }
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setDottedLine(z);
            a();
        }
    }

    public void setGeodesic(boolean z) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                if (iPolyline.isGeodesic() != z) {
                    List<LatLng> points = getPoints();
                    this.polylineDelegate.setGeodesic(z);
                    setPoints(points);
                }
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.geodesic(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void setOptionPointList(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Field declaredField = cls.getDeclaredField("isPointsUpdated");
            if (declaredField == null) {
                return;
            }
            declaredField.setAccessible(true);
            if (declaredField.getBoolean(obj)) {
                List<LatLng> points = ((PolylineOptions) obj).getPoints();
                double[] dArr = new double[points.size() * 2];
                for (int i = 0; i < points.size(); i++) {
                    int i2 = i * 2;
                    dArr[i2] = points.get(i).latitude;
                    dArr[i2 + 1] = points.get(i).longitude;
                }
                Field declaredField2 = cls.getDeclaredField("pointList");
                if (declaredField2 == null) {
                    return;
                }
                declaredField2.setAccessible(true);
                declaredField2.set(obj, dArr);
            }
        } catch (Throwable th) {
            hd.c(th, "Polyline", "setOptionPointList");
        }
    }

    public void setOptions(PolylineOptions polylineOptions) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            iPolyline.setOptions(polylineOptions);
            return;
        }
        this.options = polylineOptions;
        a();
    }

    public void setPoints(List<LatLng> list) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setPoints(list);
                return;
            }
            synchronized (this) {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.setPoints(list);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setShownRange(float f, float f2) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setShowRange(f, f2);
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.setShownRange(f, f2);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setShownRatio(float f) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setShownRatio(f);
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.setShownRatio(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTransparency(float f) {
        IPolyline iPolyline = this.polylineDelegate;
        if (iPolyline != null) {
            iPolyline.setTransparency(f);
            return;
        }
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.transparency(f);
            a();
        }
    }

    public void setVisible(boolean z) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setVisible(z);
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.visible(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setWidth(f);
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.width(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            IPolyline iPolyline = this.polylineDelegate;
            if (iPolyline != null) {
                iPolyline.setZIndex(f);
            } else {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.zIndex(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Polyline(IGlOverlayLayer iGlOverlayLayer, PolylineOptions polylineOptions, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polylineOptions;
        this.overlayName = str;
    }

    public Polyline(IPolyline iPolyline) {
        this.polylineDelegate = iPolyline;
    }
}
