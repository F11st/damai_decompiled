package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IGroundOverlay;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class GroundOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private float high;
    private IGroundOverlay iGroundOverlayDelegate;
    private GroundOverlayOptions options;
    private LatLng point;
    private float width;

    public GroundOverlay(IGroundOverlay iGroundOverlay) {
        this.iGroundOverlayDelegate = iGroundOverlay;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.destroy();
            } else {
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.removeOverlay(this.overlayName);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof GroundOverlay)) {
            try {
                IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
                if (iGroundOverlay != null) {
                    return iGroundOverlay.equalsRemote(((GroundOverlay) obj).iGroundOverlayDelegate);
                }
                return super.equals(obj) || ((GroundOverlay) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public float getBearing() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getBearing();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getBearing();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public LatLngBounds getBounds() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getBounds();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getBounds();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getHeight() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getHeight();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getHeight();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public String getId() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getId();
            }
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng getPosition() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getPosition();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getLocation();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getTransparency() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getTransparency();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getTransparency();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getWidth() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getWidth();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.getZIndex();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
        if (iGroundOverlay != null) {
            return iGroundOverlay.hashCode();
        }
        return super.hashCode();
    }

    public boolean isVisible() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                return iGroundOverlay.isVisible();
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.remove();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || groundOverlayOptions.getImage() == null) {
                return;
            }
            this.options.getImage().recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setBearing(float f) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setBearing(f);
            } else {
                GroundOverlayOptions groundOverlayOptions = this.options;
                if (groundOverlayOptions != null) {
                    groundOverlayOptions.bearing(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDimensions(float f) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setDimensions(f);
                return;
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                LatLng latLng = this.point;
                if (latLng == null) {
                    latLng = groundOverlayOptions.getLocation();
                }
                if (latLng == null) {
                    this.width = f;
                    return;
                }
                this.options.position(latLng, f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setImage(bitmapDescriptor);
            } else {
                GroundOverlayOptions groundOverlayOptions = this.options;
                if (groundOverlayOptions != null) {
                    groundOverlayOptions.image(bitmapDescriptor);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setPosition(latLng);
                return;
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || latLng == null) {
                return;
            }
            float f = this.width;
            if (f <= 0.0f) {
                f = groundOverlayOptions.getWidth();
            }
            float f2 = this.high;
            if (f2 <= 0.0f) {
                f2 = this.options.getHeight();
            }
            if (f == 0.0f) {
                this.point = latLng;
                return;
            }
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i == 0) {
                this.options.position(latLng, f);
                a();
            } else if (i > 0) {
                this.options.position(latLng, f, f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setPositionFromBounds(latLngBounds);
            } else {
                GroundOverlayOptions groundOverlayOptions = this.options;
                if (groundOverlayOptions != null && latLngBounds != null) {
                    groundOverlayOptions.positionFromBounds(latLngBounds);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTransparency(float f) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setTransparency(f);
            } else {
                GroundOverlayOptions groundOverlayOptions = this.options;
                if (groundOverlayOptions != null) {
                    groundOverlayOptions.transparency(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setVisible(z);
            } else {
                GroundOverlayOptions groundOverlayOptions = this.options;
                if (groundOverlayOptions != null) {
                    groundOverlayOptions.visible(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setZIndex(f);
            } else {
                GroundOverlayOptions groundOverlayOptions = this.options;
                if (groundOverlayOptions != null) {
                    groundOverlayOptions.zIndex(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public GroundOverlay(IGlOverlayLayer iGlOverlayLayer, GroundOverlayOptions groundOverlayOptions) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = groundOverlayOptions;
        this.overlayName = "";
    }

    public void setDimensions(float f, float f2) {
        try {
            IGroundOverlay iGroundOverlay = this.iGroundOverlayDelegate;
            if (iGroundOverlay != null) {
                iGroundOverlay.setDimensions(f, f2);
                return;
            }
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                LatLng latLng = this.point;
                if (latLng == null) {
                    latLng = groundOverlayOptions.getLocation();
                }
                if (latLng == null) {
                    this.width = f;
                    this.high = f2;
                    return;
                }
                GroundOverlayOptions groundOverlayOptions2 = this.options;
                groundOverlayOptions2.position(groundOverlayOptions2.getLocation(), f, f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
