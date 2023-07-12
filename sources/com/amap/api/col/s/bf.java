package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bf implements IRouteSearch {
    private RouteSearch.OnRouteSearchListener a;
    private RouteSearch.OnTruckRouteSearchListener b;
    private RouteSearch.OnRoutePlanSearchListener c;
    private Context d;
    private Handler e;

    public bf(Context context) throws AMapException {
        bu a = bt.a(context, C4434h.a(false));
        if (a.a == bt.EnumC4398c.SuccessCode) {
            this.d = context.getApplicationContext();
            this.e = HandlerC4447t.a();
            return;
        }
        String str = a.b;
        throw new AMapException(str, 1, str, a.a.a());
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            C4444r.a(this.d);
            if (busRouteQuery != null) {
                if (a(busRouteQuery.getFromAndTo())) {
                    RouteSearch.BusRouteQuery m229clone = busRouteQuery.m229clone();
                    BusRouteResult b = new C4402c(this.d, m229clone).b();
                    if (b != null) {
                        b.setBusQuery(m229clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    try {
                        try {
                            busRouteResult = bf.this.calculateBusRoute(busRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bf.this.a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        bf.this.e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            C4444r.a(this.d);
            if (drivePlanQuery != null) {
                if (a(drivePlanQuery.getFromAndTo())) {
                    DriveRoutePlanResult b = new C4438l(this.d, drivePlanQuery.m230clone()).b();
                    if (b != null) {
                        b.setDrivePlanQuery(drivePlanQuery);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "RouteSearch", "calculateDrivePlan");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(final RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.6
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.what = 105;
                    obtainMessage.arg1 = 18;
                    Bundle bundle = new Bundle();
                    DriveRoutePlanResult driveRoutePlanResult = null;
                    try {
                        try {
                            driveRoutePlanResult = bf.this.calculateDrivePlan(drivePlanQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bf.this.c;
                        bundle.putParcelable("result", driveRoutePlanResult);
                        obtainMessage.setData(bundle);
                        bf.this.e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            C4444r.a(this.d);
            if (driveRouteQuery != null) {
                if (a(driveRouteQuery.getFromAndTo())) {
                    ah.a().a(driveRouteQuery.getPassedByPoints());
                    ah.a().b(driveRouteQuery.getAvoidpolygons());
                    RouteSearch.DriveRouteQuery m231clone = driveRouteQuery.m231clone();
                    DriveRouteResult b = new C4439m(this.d, m231clone).b();
                    if (b != null) {
                        b.setDriveQuery(m231clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    try {
                        try {
                            driveRouteResult = bf.this.calculateDriveRoute(driveRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bf.this.a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        bf.this.e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            C4444r.a(this.d);
            if (rideRouteQuery != null) {
                if (a(rideRouteQuery.getFromAndTo())) {
                    ah.a().a(rideRouteQuery.getFromAndTo());
                    RouteSearch.RideRouteQuery m233clone = rideRouteQuery.m233clone();
                    RideRouteResult b = new aj(this.d, m233clone).b();
                    if (b != null) {
                        b.setRideQuery(m233clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.4
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    try {
                        try {
                            rideRouteResult = bf.this.calculateRideRoute(rideRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bf.this.a;
                        bundle.putParcelable("result", rideRouteResult);
                        obtainMessage.setData(bundle);
                        bf.this.e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            C4444r.a(this.d);
            if (truckRouteQuery != null) {
                if (a(truckRouteQuery.getFromAndTo())) {
                    ah.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
                    ah.a().a(truckRouteQuery.getPassedByPoints());
                    RouteSearch.TruckRouteQuery m234clone = truckRouteQuery.m234clone();
                    TruckRouteRestult b = new ap(this.d, m234clone).b();
                    if (b != null) {
                        b.setTruckQuery(m234clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.5
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.what = 104;
                    obtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestult = null;
                    try {
                        try {
                            truckRouteRestult = bf.this.calculateTruckRoute(truckRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bf.this.b;
                        bundle.putParcelable("result", truckRouteRestult);
                        obtainMessage.setData(bundle);
                        bf.this.e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            C4444r.a(this.d);
            if (walkRouteQuery != null) {
                if (a(walkRouteQuery.getFromAndTo())) {
                    ah.a().b(walkRouteQuery.getFromAndTo());
                    RouteSearch.WalkRouteQuery m235clone = walkRouteQuery.m235clone();
                    WalkRouteResult b = new aq(this.d, m235clone).b();
                    if (b != null) {
                        b.setWalkQuery(m235clone);
                    }
                    return b;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C4435i.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            ao.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = HandlerC4447t.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    try {
                        try {
                            walkRouteResult = bf.this.calculateWalkRoute(walkRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bf.this.a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        bf.this.e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            C4435i.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }

    private static boolean a(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
