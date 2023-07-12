package com.amap.api.maps;

import com.autonavi.amap.mapcore.interfaces.IUiSettings;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class UiSettings {
    private final IUiSettings a;

    public UiSettings(IUiSettings iUiSettings) {
        this.a = iUiSettings;
    }

    public float getLogoMarginRate(int i) {
        try {
            return this.a.getLogoMarginRate(i);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int getLogoPosition() {
        try {
            return this.a.getLogoPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getZoomPosition() {
        try {
            return this.a.getZoomPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 2;
        }
    }

    public boolean isCompassEnabled() {
        try {
            return this.a.isCompassEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isGestureScaleByMapCenter() {
        try {
            return this.a.isGestureScaleByMapCenter();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isIndoorSwitchEnabled() {
        try {
            return this.a.isIndoorSwitchEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.a.isMyLocationButtonEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.a.isRotateGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isScaleControlsEnabled() {
        try {
            return this.a.isScaleControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.a.isScrollGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.a.isTiltGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.a.isZoomControlsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.a.isZoomGesturesEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.a.setAllGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.a.setCompassEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setGestureScaleByMapCenter(boolean z) {
        try {
            this.a.setGestureScaleByMapCenter(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setIndoorSwitchEnabled(boolean z) {
        try {
            this.a.setIndoorSwitchEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoBottomMargin(int i) {
        try {
            this.a.setLogoBottomMargin(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLogoCenter(int i, int i2) {
    }

    protected void setLogoEnable(boolean z) {
        try {
            this.a.setLogoEnable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoLeftMargin(int i) {
        try {
            this.a.setLogoLeftMargin(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoMarginRate(int i, float f) {
        try {
            this.a.setLogoMarginRate(i, f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLogoPosition(int i) {
        try {
            this.a.setLogoPosition(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.a.setMyLocationButtonEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        try {
            this.a.setRotateGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setScaleControlsEnabled(boolean z) {
        try {
            this.a.setScaleControlsEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.a.setScrollGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        try {
            this.a.setTiltGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.a.setZoomControlsEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.a.setZoomGesturesEnabled(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZoomInByScreenCenter(boolean z) {
        try {
            this.a.setZoomInByScreenCenter(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZoomPosition(int i) {
        try {
            this.a.setZoomPosition(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
