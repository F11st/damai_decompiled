package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class c extends b<RouteSearch.BusRouteQuery, BusRouteResult> {
    public c(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult c(String str) throws AMapException {
        return q.a(str);
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
        stringBuffer.append("&origin=");
        stringBuffer.append(i.a(((RouteSearch.BusRouteQuery) ((a) this).b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(i.a(((RouteSearch.BusRouteQuery) ((a) this).b).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) ((a) this).b).getCity();
        if (!q.g(city)) {
            city = b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!q.g(((RouteSearch.BusRouteQuery) ((a) this).b).getCity())) {
            String b = b.b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RouteSearch.BusRouteQuery) ((a) this).b).getMode());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) ((a) this).b).getNightFlag());
        if (!TextUtils.isEmpty(((RouteSearch.BusRouteQuery) ((a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) ((a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/direction/transit/integrated?";
    }
}
