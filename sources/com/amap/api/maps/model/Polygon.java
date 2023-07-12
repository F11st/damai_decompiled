package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.mapcore.util.hd;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IPolygon;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Polygon extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolygonOptions options;
    private IPolygon polygonDelegate;

    public Polygon(IPolygon iPolygon) {
        this.polygonDelegate = iPolygon;
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            setOptionPointList(this.options);
            iGlOverlayLayer.processPolygonHoleOption(this.options);
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.contains(latLng);
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.IsPolygonContainsPoint(this.options, latLng);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Polygon)) {
            try {
                IPolygon iPolygon = this.polygonDelegate;
                if (iPolygon != null) {
                    return iPolygon.equalsRemote(((Polygon) obj).polygonDelegate);
                }
                return super.equals(obj) || ((Polygon) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public int getFillColor() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getFillColor();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getFillColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public List<BaseHoleOptions> getHoleOptions() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getHoleOptions();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getHoleOptions();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getId() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getId();
            }
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getPoints();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getStrokeColor() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getStrokeColor();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getStrokeWidth() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getStrokeWidth();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.getZIndex();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.hashCodeRemote();
            }
            return super.hashCode();
        } catch (Throwable unused) {
            return super.hashCode();
        }
    }

    public boolean isVisible() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                return iPolygon.isVisible();
            }
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.remove();
            } else {
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.removeOverlay(this.overlayName);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFillColor(int i) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setFillColor(i);
            } else {
                PolygonOptions polygonOptions = this.options;
                if (polygonOptions != null) {
                    polygonOptions.fillColor(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setHoleOptions(list);
                return;
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            this.options.setHoleOptions(list);
            a();
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
                List<LatLng> points = ((PolygonOptions) obj).getPoints();
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
            hd.c(th, "Polygon", "setOptionPointList");
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setPoints(list);
            } else {
                this.options.setPoints(list);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeColor(int i) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setStrokeColor(i);
            } else {
                PolygonOptions polygonOptions = this.options;
                if (polygonOptions != null) {
                    polygonOptions.strokeColor(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeWidth(float f) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setStrokeWidth(f);
            } else {
                this.options.strokeWidth(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setVisible(z);
            } else {
                PolygonOptions polygonOptions = this.options;
                if (polygonOptions != null) {
                    polygonOptions.visible(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            IPolygon iPolygon = this.polygonDelegate;
            if (iPolygon != null) {
                iPolygon.setZIndex(f);
            } else {
                PolygonOptions polygonOptions = this.options;
                if (polygonOptions != null) {
                    polygonOptions.zIndex(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Polygon(IGlOverlayLayer iGlOverlayLayer, PolygonOptions polygonOptions) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polygonOptions;
    }
}
