package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class n extends b<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public n(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 c(String str) throws AMapException {
        return q.c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((a) this).e));
        if (((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getFrom()));
            if (!q.g(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getTo()));
            if (!q.g(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!q.g(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getOriginType());
            }
            if (!q.g(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getMode());
        stringBuffer.append(sb.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) ((a) this).b).getShowFields();
        stringBuffer.append("&show_fields=");
        if ((showFields & 1) != 0) {
            stringBuffer.append("cost,");
        }
        if ((showFields & 2) != 0) {
            stringBuffer.append("tmcs,");
        }
        if ((showFields & 4) != 0) {
            stringBuffer.append("navi,");
        }
        if ((showFields & 8) != 0) {
            stringBuffer.append("cities,");
        }
        if ((showFields & 16) != 0) {
            stringBuffer.append("polyline,");
        }
        if ((showFields & 32) != 0) {
            stringBuffer.append("elec_consume_info,");
        }
        if ((showFields & 64) != 0) {
            stringBuffer.append("charge_station_info,");
        }
        stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), "");
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) ((a) this).b).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) ((a) this).b).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearchV2.DriveRouteQuery) ((a) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((a) this).b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((a) this).b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(b.b(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) ((a) this).b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((a) this).b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.c() + "/direction/driving?";
    }
}
