package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.m */
/* loaded from: classes10.dex */
public final class C4439m extends AbstractC4379b<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public C4439m(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResult c(String str) throws AMapException {
        return C4443q.b(str);
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
        if (((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C4435i.a(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getFrom()));
            if (!C4443q.g(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C4435i.a(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getTo()));
            if (!C4443q.g(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!C4443q.g(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType());
            }
            if (!C4443q.g(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationType());
            }
            if (!C4443q.g(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateProvince());
            }
            if (!C4443q.g(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getMode());
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).isUseFerry());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getCarType());
        stringBuffer.append(sb2.toString());
        if (((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(AbstractC4379b.b(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((AbstractC4370a) this).b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/direction/driving?";
    }
}
