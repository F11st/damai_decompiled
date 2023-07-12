package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class aj extends AbstractC4379b<RouteSearch.RideRouteQuery, RideRouteResult> {
    public aj(Context context, RouteSearch.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResult c(String str) throws AMapException {
        return C4443q.h(str);
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
        stringBuffer.append("&origin=");
        stringBuffer.append(C4435i.a(((RouteSearch.RideRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C4435i.a(((RouteSearch.RideRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (!TextUtils.isEmpty(((RouteSearch.RideRouteQuery) ((AbstractC4370a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.RideRouteQuery) ((AbstractC4370a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.b() + "/direction/bicycling?";
    }
}
