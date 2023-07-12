package com.autonavi.amap.mapcore.interfaces;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface INavigateArrow extends IOverlay {
    List<LatLng> getPoints() throws RemoteException;

    int getSideColor() throws RemoteException;

    int getTopColor() throws RemoteException;

    float getWidth() throws RemoteException;

    boolean is3DModel();

    void set3DModel(boolean z);

    void setPoints(List<LatLng> list) throws RemoteException;

    void setSideColor(int i) throws RemoteException;

    void setTopColor(int i) throws RemoteException;

    void setWidth(float f) throws RemoteException;
}
