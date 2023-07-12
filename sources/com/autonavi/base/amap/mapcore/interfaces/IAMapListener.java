package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i, GLMapState gLMapState);

    void afterDrawLabel(int i, GLMapState gLMapState);

    void afterRendererOver(int i, GLMapState gLMapState);

    void beforeDrawLabel(int i, GLMapState gLMapState);
}
