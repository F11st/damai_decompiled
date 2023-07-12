package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IOverlayDelegate extends IOverlay {
    boolean calMapFPoint() throws RemoteException;

    boolean checkInBounds();

    void draw(MapConfig mapConfig) throws RemoteException;

    boolean isDrawFinish();
}
