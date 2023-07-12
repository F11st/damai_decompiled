package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ap extends b<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
    private final String k;
    private final String l;
    private final String m;

    public ap(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.k = "/direction/truck?";
        this.l = "|";
        this.m = ",";
    }

    private static TruckRouteRestult c(String str) throws AMapException {
        return q.j(str);
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
        if (((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(i.a(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getFrom()));
            if (!q.g(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(i.a(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getTo()));
            if (!q.g(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!q.g(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getOriginType());
            }
            if (!q.g(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getDestinationType());
            }
            if (!q.g(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getPlateProvince());
            }
            if (!q.g(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getMode());
        if (((RouteSearch.TruckRouteQuery) ((a) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getTruckAxis());
        if (!TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) ((a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.b() + "/direction/truck?";
    }
}
