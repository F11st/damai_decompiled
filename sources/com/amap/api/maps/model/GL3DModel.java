package com.amap.api.maps.model;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IglModel;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GL3DModel extends BasePointOverlay {
    private final IglModel mModel;

    public GL3DModel(IglModel iglModel) {
        this.mModel = iglModel;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        IglModel iglModel = this.mModel;
        if (iglModel != null) {
            iglModel.destroy();
        }
    }

    public float getAngle() {
        try {
            return this.mModel.getRotateAngle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.mModel.getId();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        IglModel iglModel = this.mModel;
        if (iglModel != null) {
            return iglModel.getObject();
        }
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        try {
            return this.mModel.getPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        try {
            return this.mModel.getRotateAngle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            return this.mModel.getSnippet();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            return this.mModel.getTitle();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            return this.mModel.isVisible();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
        try {
            this.mModel.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAngle(float f) {
        try {
            this.mModel.setRotateAngle(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation animation) {
        try {
            this.mModel.setAnimation(animation);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint iPoint) {
        IglModel iglModel = this.mModel;
        if (iglModel != null) {
            iglModel.setGeoPoint(iPoint);
        }
    }

    public void setModelFixedLength(int i) {
        try {
            this.mModel.setModelFixedLength(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        try {
            this.mModel.setObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            this.mModel.setPosition(latLng);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f) {
        try {
            this.mModel.setRotateAngle(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        IglModel iglModel = this.mModel;
        if (iglModel != null) {
            iglModel.setSnippet(str);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        IglModel iglModel = this.mModel;
        if (iglModel != null) {
            iglModel.setTitle(str);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z) {
        try {
            this.mModel.setVisible(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setZoomLimit(float f) {
        IglModel iglModel = this.mModel;
        if (iglModel != null) {
            iglModel.setZoomLimit(f);
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            this.mModel.showInfoWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        try {
            return this.mModel.startAnimation();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
