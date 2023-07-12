package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IArc;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Arc extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private IArc iArcDel;
    private ArcOptions options;

    public Arc(IArc iArc) {
        this.iArcDel = iArc;
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Arc)) {
            try {
                IArc iArc = this.iArcDel;
                if (iArc != null) {
                    return iArc.equalsRemote(((Arc) obj).iArcDel);
                }
                return super.equals(obj) || ((Arc) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                return iArc.getId();
            }
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getStrokeColor() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                return iArc.getStrokeColor();
            }
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getStrokeWidth() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                return iArc.getStrokeWidth();
            }
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                return iArc.getZIndex();
            }
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                return iArc.hashCodeRemote();
            }
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                return iArc.isVisible();
            }
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                iArc.remove();
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

    public void setStrokeColor(int i) {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                iArc.setStrokeColor(i);
            } else {
                ArcOptions arcOptions = this.options;
                if (arcOptions != null) {
                    arcOptions.strokeColor(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeWidth(float f) {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                iArc.setStrokeWidth(f);
            } else {
                ArcOptions arcOptions = this.options;
                if (arcOptions != null) {
                    arcOptions.strokeWidth(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                iArc.setVisible(z);
            } else {
                ArcOptions arcOptions = this.options;
                if (arcOptions != null) {
                    arcOptions.visible(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            IArc iArc = this.iArcDel;
            if (iArc != null) {
                iArc.setZIndex(f);
            } else {
                ArcOptions arcOptions = this.options;
                if (arcOptions != null) {
                    arcOptions.zIndex(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Arc(IGlOverlayLayer iGlOverlayLayer, ArcOptions arcOptions) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = arcOptions;
        this.overlayName = "";
    }
}
