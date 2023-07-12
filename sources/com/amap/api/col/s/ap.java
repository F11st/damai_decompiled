package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ap extends AbstractC4379b<RouteSearch.TruckRouteQuery, TruckRouteRestult> {
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
        return C4443q.j(str);
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
        if (((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C4435i.a(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getFrom()));
            if (!C4443q.g(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C4435i.a(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getTo()));
            if (!C4443q.g(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!C4443q.g(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType());
            }
            if (!C4443q.g(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationType());
            }
            if (!C4443q.g(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateProvince());
            }
            if (!C4443q.g(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getMode());
        if (((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getTruckAxis());
        if (!TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((AbstractC4370a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.b() + "/direction/truck?";
    }
}
