package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.n */
/* loaded from: classes10.dex */
public final class C4440n extends AbstractC4379b<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public C4440n(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 c(String str) throws AMapException {
        return C4443q.c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((AbstractC4370a) this).e));
        if (((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C4435i.a(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getFrom()));
            if (!C4443q.g(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C4435i.a(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getTo()));
            if (!C4443q.g(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!C4443q.g(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType());
            }
            if (!C4443q.g(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getMode());
        stringBuffer.append(sb.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getShowFields();
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
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(AbstractC4379b.b(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((AbstractC4370a) this).b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.c() + "/direction/driving?";
    }
}
