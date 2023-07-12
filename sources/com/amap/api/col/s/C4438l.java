package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.l */
/* loaded from: classes10.dex */
public final class C4438l extends AbstractC4379b<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public C4438l(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    private static DriveRoutePlanResult c(String str) throws AMapException {
        return C4443q.k(str);
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
        if (((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C4435i.a(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getFrom()));
            if (!C4443q.g(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(C4435i.a(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getTo()));
            if (!C4443q.g(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationPoiID());
            }
            if (!C4443q.g(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getOriginType());
            }
            if (!C4443q.g(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getDestinationType());
            }
            if (!C4443q.g(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateProvince());
            }
            if (!C4443q.g(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&cartype=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getCarType());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&firsttime=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getFirstTime());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&interval=");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getInterval());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&count=");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((RouteSearch.DrivePlanQuery) ((AbstractC4370a) this).b).getCount());
        stringBuffer.append(sb5.toString());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.b() + "/etd/driving?";
    }
}
