package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.INavigateArrow;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class NavigateArrow extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private INavigateArrow navigateArrowDelegate;
    private NavigateArrowOptions options;

    public NavigateArrow(INavigateArrow iNavigateArrow) {
        this.navigateArrowDelegate = iNavigateArrow;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavigateArrow)) {
            try {
                INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
                if (iNavigateArrow != null) {
                    return iNavigateArrow.equalsRemote(((NavigateArrow) obj).navigateArrowDelegate);
                }
                return super.equals(obj) || ((NavigateArrow) obj).getId() == getId();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.getId();
            }
            return this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.getPoints();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getPoints();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public int getSideColor() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.getSideColor();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getSideColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getTopColor() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.getTopColor();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getTopColor();
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getWidth() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.getWidth();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.getZIndex();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.hashCodeRemote();
            }
            return super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean is3DModel() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.is3DModel();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.is3DModel();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                return iNavigateArrow.isVisible();
            }
            NavigateArrowOptions navigateArrowOptions = this.options;
            if (navigateArrowOptions != null) {
                return navigateArrowOptions.isVisible();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.remove();
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

    public void set3DModel(boolean z) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.set3DModel(z);
            } else {
                NavigateArrowOptions navigateArrowOptions = this.options;
                if (navigateArrowOptions != null) {
                    navigateArrowOptions.set3DModel(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.setPoints(list);
            } else if (this.options != null) {
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSideColor(int i) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.setSideColor(i);
            } else {
                NavigateArrowOptions navigateArrowOptions = this.options;
                if (navigateArrowOptions != null) {
                    navigateArrowOptions.sideColor(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTopColor(int i) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.setTopColor(i);
            } else {
                NavigateArrowOptions navigateArrowOptions = this.options;
                if (navigateArrowOptions != null) {
                    navigateArrowOptions.topColor(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.setVisible(z);
            } else {
                NavigateArrowOptions navigateArrowOptions = this.options;
                if (navigateArrowOptions != null) {
                    navigateArrowOptions.visible(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.setWidth(f);
            } else {
                NavigateArrowOptions navigateArrowOptions = this.options;
                if (navigateArrowOptions != null) {
                    navigateArrowOptions.width(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            INavigateArrow iNavigateArrow = this.navigateArrowDelegate;
            if (iNavigateArrow != null) {
                iNavigateArrow.setZIndex(f);
            } else {
                NavigateArrowOptions navigateArrowOptions = this.options;
                if (navigateArrowOptions != null) {
                    navigateArrowOptions.zIndex(f);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public NavigateArrow(IGlOverlayLayer iGlOverlayLayer, NavigateArrowOptions navigateArrowOptions) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = navigateArrowOptions;
    }
}
