package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IGroundOverlay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IGroundOverlayDelegate extends IGroundOverlay, IOverlayDelegate {
    void reLoadTexture();

    void setAnchor(float f, float f2) throws RemoteException;
}
