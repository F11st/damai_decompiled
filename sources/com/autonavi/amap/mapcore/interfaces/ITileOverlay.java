package com.autonavi.amap.mapcore.interfaces;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ITileOverlay {
    void clearTileCache();

    void destroy(boolean z);

    boolean equalsRemote(ITileOverlay iTileOverlay);

    String getId();

    float getZIndex();

    int hashCodeRemote();

    boolean isVisible();

    void remove();

    void setVisible(boolean z);

    void setZIndex(float f);
}
