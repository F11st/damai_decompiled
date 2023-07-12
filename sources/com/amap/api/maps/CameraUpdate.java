package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class CameraUpdate {
    AbstractCameraUpdateMessage a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.a = abstractCameraUpdateMessage;
    }

    public AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.a;
    }
}
