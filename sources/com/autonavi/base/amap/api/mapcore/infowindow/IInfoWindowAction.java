package com.autonavi.base.amap.api.mapcore.infowindow;

import android.os.RemoteException;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.C4479ar;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IInfoWindowAction {
    void hideInfoWindow();

    boolean isInfoWindowShown();

    boolean onInfoWindowTap(MotionEvent motionEvent);

    void redrawInfoWindow();

    void setInfoWindowAdapterManager(C4479ar c4479ar);

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;
}
