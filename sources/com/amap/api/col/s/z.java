package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.ag;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z extends x<ac, PoiResult> {
    private int k;
    private boolean l;
    private List<String> m;
    private List<SuggestionCity> n;

    public z(Context context, ac acVar) {
        super(context, acVar);
        this.k = 0;
        this.l = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
    }

    private static String b(boolean z) {
        return z ? "distance" : "weight";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: e */
    public PoiResult a(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            T t = ((a) this).b;
            return PoiResult.createPagedResult(((ac) t).a, ((ac) t).b, this.m, this.n, ((ac) t).a.getPageSize(), this.k, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.k = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
            arrayList = q.c(jSONObject);
        } catch (JSONException e) {
            i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            i.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            T t2 = ((a) this).b;
            return PoiResult.createPagedResult(((ac) t2).a, ((ac) t2).b, this.m, this.n, ((ac) t2).a.getPageSize(), this.k, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t3 = ((a) this).b;
            return PoiResult.createPagedResult(((ac) t3).a, ((ac) t3).b, this.m, this.n, ((ac) t3).a.getPageSize(), this.k, arrayList);
        }
        this.n = q.a(optJSONObject);
        this.m = q.b(optJSONObject);
        T t4 = ((a) this).b;
        return PoiResult.createPagedResult(((ac) t4).a, ((ac) t4).b, this.m, this.n, ((ac) t4).a.getPageSize(), this.k, arrayList);
    }

    private static ag j() {
        af a = ae.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (ag) a;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        return a(true);
    }

    @Override // com.amap.api.col.s.a
    protected final ae.b d() {
        ae.b bVar = new ae.b();
        if (this.l) {
            ag j = j();
            double a = j != null ? j.a() : 0.0d;
            bVar.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((ac) ((a) this).b).b.getShape().equals("Bound")) {
                bVar.b = new ag.a(i.a(((ac) ((a) this).b).b.getCenter().getLatitude()), i.a(((ac) ((a) this).b).b.getCenter().getLongitude()), a);
            }
        } else {
            bVar.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str = h.a() + "/place";
        T t = ((a) this).b;
        if (((ac) t).b == null) {
            return str + "/text?";
        } else if (((ac) t).b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.l = true;
            return str2;
        } else if (((ac) ((a) this).b).b.getShape().equals("Rectangle") || ((ac) ((a) this).b).b.getShape().equals("Polygon")) {
            return str + "/polygon?";
        } else {
            return str;
        }
    }

    private String a(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((a) this).b;
        if (((ac) t).b != null) {
            if (((ac) t).b.getShape().equals("Bound")) {
                if (z) {
                    double a = i.a(((ac) ((a) this).b).b.getCenter().getLongitude());
                    double a2 = i.a(((ac) ((a) this).b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a + "," + a2);
                }
                sb.append("&radius=");
                sb.append(((ac) ((a) this).b).b.getRange());
                sb.append("&sortrule=");
                sb.append(b(((ac) ((a) this).b).b.isDistanceSort()));
            } else if (((ac) ((a) this).b).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((ac) ((a) this).b).b.getLowerLeft();
                LatLonPoint upperRight = ((ac) ((a) this).b).b.getUpperRight();
                double a3 = i.a(lowerLeft.getLatitude());
                double a4 = i.a(lowerLeft.getLongitude());
                double a5 = i.a(upperRight.getLatitude());
                double a6 = i.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((ac) ((a) this).b).b.getShape().equals("Polygon") && (polyGonList = ((ac) ((a) this).b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + i.a(polyGonList));
            }
        }
        String city = ((ac) ((a) this).b).a.getCity();
        if (!x.c(city)) {
            String b = b.b(city);
            sb.append("&city=");
            sb.append(b);
        }
        String b2 = b.b(((ac) ((a) this).b).a.getQueryString());
        if (!x.c(b2)) {
            sb.append("&keywords=");
            sb.append(b2);
        }
        sb.append("&offset=");
        sb.append(((ac) ((a) this).b).a.getPageSize());
        sb.append("&page=");
        sb.append(((ac) ((a) this).b).a.getPageNum());
        String building = ((ac) ((a) this).b).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((ac) ((a) this).b).a.getBuilding());
        }
        String b3 = b.b(((ac) ((a) this).b).a.getCategory());
        if (!x.c(b3)) {
            sb.append("&types=");
            sb.append(b3);
        }
        if (!x.c(((ac) ((a) this).b).a.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((ac) ((a) this).b).a.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&key=");
        sb.append(bk.f(((a) this).e));
        if (((ac) ((a) this).b).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((ac) ((a) this).b).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.l) {
            if (((ac) ((a) this).b).a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t2 = ((a) this).b;
        if (((ac) t2).b == null && ((ac) t2).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(b(((ac) ((a) this).b).a.isDistanceSort()));
            double a7 = i.a(((ac) ((a) this).b).a.getLocation().getLongitude());
            double a8 = i.a(((ac) ((a) this).b).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        return sb.toString();
    }
}
