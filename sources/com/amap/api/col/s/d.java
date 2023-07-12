package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d<T> extends b<T, Object> {
    private int k;
    private List<String> l;
    private List<SuggestionCity> m;

    public d(Context context, T t) {
        super(context, t);
        this.k = 0;
        this.l = new ArrayList();
        this.m = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.m = q.a(optJSONObject);
                this.l = q.b(optJSONObject);
            }
            this.k = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
            if (((a) this).b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) ((a) this).b, this.k, this.m, this.l, q.f(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) ((a) this).b, this.k, this.m, this.l, q.e(jSONObject));
        } catch (Exception e) {
            i.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((a) this).b;
        if (t instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t;
            if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb.append("&extensions=");
                sb.append(busLineQuery.getExtensions());
            } else {
                sb.append("&extensions=base");
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb.append("&id=");
                sb.append(b.b(((BusLineQuery) ((a) this).b).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!q.g(city)) {
                    String b = b.b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + b.b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t;
            String city2 = busStationQuery.getCity();
            if (!q.g(city2)) {
                String b2 = b.b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + b.b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + bk.f(((a) this).e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str;
        T t = ((a) this).b;
        if (!(t instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) t).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else {
            str = ((BusLineQuery) ((a) this).b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        }
        return h.a() + "/bus/" + str + "?";
    }
}
