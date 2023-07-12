package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.c */
/* loaded from: classes10.dex */
public final class C4402c extends AbstractC4379b<RouteSearch.BusRouteQuery, BusRouteResult> {
    public C4402c(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult c(String str) throws AMapException {
        return C4443q.a(str);
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
        stringBuffer.append(C4435i.a(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(C4435i.a(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getCity();
        if (!C4443q.g(city)) {
            city = AbstractC4379b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!C4443q.g(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getCity())) {
            String b = AbstractC4379b.b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getNightFlag());
        if (!TextUtils.isEmpty(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) ((AbstractC4370a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/direction/transit/integrated?";
    }
}
