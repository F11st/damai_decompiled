package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IRouteSearchV2 {
    DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException;

    void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery);

    void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener);
}
