package com.autonavi.base.amap.api.mapcore.overlays;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.base.amap.mapcore.FPoint;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IMarkerDelegate extends IMarker, IOverlayImageDelegate {
    FPoint anchorUVoff();

    IPoint getAnchor();

    BitmapDescriptor getBitmapDescriptor();

    int getHeight();

    int getInfoWindowOffsetX();

    int getInfoWindowOffsetY();

    int getRealInfoWindowOffsetX();

    int getRealInfoWindowOffsetY();

    int getWidth();

    boolean isContains();

    boolean isDestory();

    boolean isInfoWindowEnable();

    boolean isViewMode();

    void setInfoWindowOffset(int i, int i2) throws RemoteException;

    void setInfoWindowShown(boolean z);
}
