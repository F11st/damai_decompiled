package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Marker extends BasePointOverlay {
    private IMarker markerDelegate;

    public Marker(IMarker iMarker) {
        this.markerDelegate = iMarker;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        try {
            IMarker iMarker = this.markerDelegate;
            if (iMarker != null) {
                iMarker.destroy(true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Marker) {
                    return this.markerDelegate.equalsRemote(((Marker) obj).markerDelegate);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public float getAlpha() {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getAlpha();
        }
        return 1.0f;
    }

    public float getAnchorU() {
        return this.markerDelegate.getAnchorU();
    }

    public float getAnchorV() {
        return this.markerDelegate.getAnchorV();
    }

    public int getDisplayLevel() {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getDisplayLevel();
        }
        return 5;
    }

    public IPoint getGeoPoint() {
        return this.markerDelegate.getGeoPoint();
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.markerDelegate.getIcons();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.markerDelegate.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.markerDelegate.getObject();
    }

    public MarkerOptions getOptions() {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.getOptions();
        }
        return null;
    }

    public int getPeriod() {
        try {
            return this.markerDelegate.getPeriod();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        try {
            return this.markerDelegate.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        return this.markerDelegate.getRotateAngle();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            return this.markerDelegate.getSnippet();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            return this.markerDelegate.getTitle();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        return this.markerDelegate.getZIndex();
    }

    public int hashCode() {
        return this.markerDelegate.hashCodeRemote();
    }

    public void hideInfoWindow() {
        try {
            this.markerDelegate.hideInfoWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isClickable() {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isClickable();
        }
        return false;
    }

    public boolean isDraggable() {
        return this.markerDelegate.isDraggable();
    }

    public boolean isFlat() {
        return this.markerDelegate.isFlat();
    }

    public boolean isInfoWindowAutoOverturn() {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isInfoWindowAutoOverturn();
        }
        return false;
    }

    public boolean isInfoWindowEnable() {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            return iMarkerAction.isInfoWindowEnable();
        }
        return false;
    }

    public boolean isInfoWindowShown() {
        return this.markerDelegate.isInfoWindowShown();
    }

    public boolean isPerspective() {
        try {
            return this.markerDelegate.isPerspective();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isRemoved() {
        IMarker iMarker = this.markerDelegate;
        if (iMarker != null) {
            return iMarker.isRemoved();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            return this.markerDelegate.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
        try {
            this.markerDelegate.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAlpha(float f) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setAlpha(f);
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            this.markerDelegate.setAnchor(f, f2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation animation) {
        try {
            this.markerDelegate.setAnimation(animation);
        } catch (Throwable unused) {
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.markerDelegate.setAnimationListener(animationListener);
    }

    public void setAutoOverturnInfoWindow(boolean z) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setAutoOverturnInfoWindow(z);
        }
    }

    public void setBelowMaskLayer(boolean z) {
        this.markerDelegate.setBelowMaskLayer(z);
    }

    public void setClickable(boolean z) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setClickable(z);
        }
    }

    public void setDisplayLevel(int i) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setDisplayLevel(i);
        }
    }

    public void setDraggable(boolean z) {
        try {
            this.markerDelegate.setDraggable(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFixingPointEnable(boolean z) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setFixingPointEnable(z);
        }
    }

    public void setFlat(boolean z) {
        try {
            this.markerDelegate.setFlat(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint iPoint) {
        this.markerDelegate.setGeoPoint(iPoint);
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                this.markerDelegate.setIcon(bitmapDescriptor);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.markerDelegate.setIcons(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setInfoWindowEnable(boolean z) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setInfoWindowEnable(z);
        }
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setMarkerOptions(markerOptions);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        this.markerDelegate.setObject(obj);
    }

    public void setPeriod(int i) {
        try {
            this.markerDelegate.setPeriod(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPerspective(boolean z) {
        try {
            this.markerDelegate.setPerspective(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            this.markerDelegate.setPosition(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPositionByPixels(int i, int i2) {
        this.markerDelegate.setPositionByPixels(i, i2);
    }

    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f) {
        try {
            this.markerDelegate.setRotateAngle(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRotateAngleNotUpdate(float f) {
        IMarkerAction iMarkerAction = this.markerDelegate.getIMarkerAction();
        if (iMarkerAction != null) {
            iMarkerAction.setRotateAngleNotUpdate(f);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        try {
            this.markerDelegate.setSnippet(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        try {
            this.markerDelegate.setTitle(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setToTop() {
        try {
            this.markerDelegate.set2Top();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z) {
        try {
            this.markerDelegate.setVisible(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        this.markerDelegate.setZIndex(f);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            this.markerDelegate.showInfoWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        return this.markerDelegate.startAnimation();
    }
}
