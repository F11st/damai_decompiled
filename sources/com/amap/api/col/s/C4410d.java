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
/* renamed from: com.amap.api.col.s.d */
/* loaded from: classes10.dex */
public final class C4410d<T> extends AbstractC4379b<T, Object> {
    private int k;
    private List<String> l;
    private List<SuggestionCity> m;

    public C4410d(Context context, T t) {
        super(context, t);
        this.k = 0;
        this.l = new ArrayList();
        this.m = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.m = C4443q.a(optJSONObject);
                this.l = C4443q.b(optJSONObject);
            }
            this.k = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
            if (((AbstractC4370a) this).b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) ((AbstractC4370a) this).b, this.k, this.m, this.l, C4443q.f(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) ((AbstractC4370a) this).b, this.k, this.m, this.l, C4443q.e(jSONObject));
        } catch (Exception e) {
            C4435i.a(e, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((AbstractC4370a) this).b;
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
                sb.append(AbstractC4379b.b(((BusLineQuery) ((AbstractC4370a) this).b).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!C4443q.g(city)) {
                    String b = AbstractC4379b.b(city);
                    sb.append("&city=");
                    sb.append(b);
                }
                sb.append("&keywords=" + AbstractC4379b.b(busLineQuery.getQueryString()));
                sb.append("&offset=" + busLineQuery.getPageSize());
                sb.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t;
            String city2 = busStationQuery.getCity();
            if (!C4443q.g(city2)) {
                String b2 = AbstractC4379b.b(city2);
                sb.append("&city=");
                sb.append(b2);
            }
            sb.append("&keywords=" + AbstractC4379b.b(busStationQuery.getQueryString()));
            sb.append("&offset=" + busStationQuery.getPageSize());
            sb.append("&page=" + busStationQuery.getPageNumber());
        }
        sb.append("&key=" + bk.f(((AbstractC4370a) this).e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str;
        T t = ((AbstractC4370a) this).b;
        if (!(t instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) t).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else {
            str = ((BusLineQuery) ((AbstractC4370a) this).b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        }
        return C4434h.a() + "/bus/" + str + "?";
    }
}
