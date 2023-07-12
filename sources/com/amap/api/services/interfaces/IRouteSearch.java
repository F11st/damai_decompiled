package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IRouteSearch {
    BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException;

    void calculateBusRouteAsyn(RouteSearch.BusRouteQuery busRouteQuery);

    DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException;

    void calculateDrivePlanAsyn(RouteSearch.DrivePlanQuery drivePlanQuery);

    DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException;

    void calculateDriveRouteAsyn(RouteSearch.DriveRouteQuery driveRouteQuery);

    RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException;

    void calculateRideRouteAsyn(RouteSearch.RideRouteQuery rideRouteQuery);

    TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException;

    void calculateTruckRouteAsyn(RouteSearch.TruckRouteQuery truckRouteQuery);

    WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException;

    void calculateWalkRouteAsyn(RouteSearch.WalkRouteQuery walkRouteQuery);

    void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener);

    void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener);

    void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener);
}
