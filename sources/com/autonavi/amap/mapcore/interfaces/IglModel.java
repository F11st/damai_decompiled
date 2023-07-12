package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IglModel {
    void destroy();

    String getId();

    Object getObject();

    LatLng getPosition();

    float getRotateAngle();

    String getSnippet();

    String getTitle();

    boolean isVisible();

    boolean remove();

    void setAnimation(Animation animation);

    void setGeoPoint(IPoint iPoint);

    void setModelFixedLength(int i);

    void setObject(Object obj);

    void setPosition(LatLng latLng);

    void setRotateAngle(float f);

    void setSnippet(String str);

    void setTitle(String str);

    void setVisible(boolean z);

    void setZoomLimit(float f);

    void showInfoWindow();

    boolean startAnimation();
}
