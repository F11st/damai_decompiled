package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.col.s.C4373ae;
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
/* renamed from: com.amap.api.col.s.z */
/* loaded from: classes10.dex */
public final class C4465z extends AbstractC4463x<ac, PoiResult> {
    private int k;
    private boolean l;
    private List<String> m;
    private List<SuggestionCity> n;

    public C4465z(Context context, ac acVar) {
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
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    /* renamed from: e */
    public PoiResult a(String str) throws AMapException {
        JSONObject jSONObject;
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (str == null) {
            T t = ((AbstractC4370a) this).b;
            return PoiResult.createPagedResult(((ac) t).a, ((ac) t).b, this.m, this.n, ((ac) t).a.getPageSize(), this.k, arrayList);
        }
        try {
            jSONObject = new JSONObject(str);
            this.k = jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
            arrayList = C4443q.c(jSONObject);
        } catch (JSONException e) {
            C4435i.a(e, "PoiSearchKeywordHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            C4435i.a(e2, "PoiSearchKeywordHandler", "paseJSONException");
        }
        if (!jSONObject.has("suggestion")) {
            T t2 = ((AbstractC4370a) this).b;
            return PoiResult.createPagedResult(((ac) t2).a, ((ac) t2).b, this.m, this.n, ((ac) t2).a.getPageSize(), this.k, arrayList);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
        if (optJSONObject == null) {
            T t3 = ((AbstractC4370a) this).b;
            return PoiResult.createPagedResult(((ac) t3).a, ((ac) t3).b, this.m, this.n, ((ac) t3).a.getPageSize(), this.k, arrayList);
        }
        this.n = C4443q.a(optJSONObject);
        this.m = C4443q.b(optJSONObject);
        T t4 = ((AbstractC4370a) this).b;
        return PoiResult.createPagedResult(((ac) t4).a, ((ac) t4).b, this.m, this.n, ((ac) t4).a.getPageSize(), this.k, arrayList);
    }

    private static ag j() {
        af a = C4373ae.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (ag) a;
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        return a(true);
    }

    @Override // com.amap.api.col.s.AbstractC4370a
    protected final C4373ae.C4375b d() {
        C4373ae.C4375b c4375b = new C4373ae.C4375b();
        if (this.l) {
            ag j = j();
            double a = j != null ? j.a() : 0.0d;
            c4375b.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
            if (((ac) ((AbstractC4370a) this).b).b.getShape().equals("Bound")) {
                c4375b.b = new ag.C4377a(C4435i.a(((ac) ((AbstractC4370a) this).b).b.getCenter().getLatitude()), C4435i.a(((ac) ((AbstractC4370a) this).b).b.getCenter().getLongitude()), a);
            }
        } else {
            c4375b.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        }
        return c4375b;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str = C4434h.a() + "/place";
        T t = ((AbstractC4370a) this).b;
        if (((ac) t).b == null) {
            return str + "/text?";
        } else if (((ac) t).b.getShape().equals("Bound")) {
            String str2 = str + "/around?";
            this.l = true;
            return str2;
        } else if (((ac) ((AbstractC4370a) this).b).b.getShape().equals("Rectangle") || ((ac) ((AbstractC4370a) this).b).b.getShape().equals("Polygon")) {
            return str + "/polygon?";
        } else {
            return str;
        }
    }

    private String a(boolean z) {
        List<LatLonPoint> polyGonList;
        StringBuilder sb = new StringBuilder();
        sb.append("output=json");
        T t = ((AbstractC4370a) this).b;
        if (((ac) t).b != null) {
            if (((ac) t).b.getShape().equals("Bound")) {
                if (z) {
                    double a = C4435i.a(((ac) ((AbstractC4370a) this).b).b.getCenter().getLongitude());
                    double a2 = C4435i.a(((ac) ((AbstractC4370a) this).b).b.getCenter().getLatitude());
                    sb.append("&location=");
                    sb.append(a + "," + a2);
                }
                sb.append("&radius=");
                sb.append(((ac) ((AbstractC4370a) this).b).b.getRange());
                sb.append("&sortrule=");
                sb.append(b(((ac) ((AbstractC4370a) this).b).b.isDistanceSort()));
            } else if (((ac) ((AbstractC4370a) this).b).b.getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((ac) ((AbstractC4370a) this).b).b.getLowerLeft();
                LatLonPoint upperRight = ((ac) ((AbstractC4370a) this).b).b.getUpperRight();
                double a3 = C4435i.a(lowerLeft.getLatitude());
                double a4 = C4435i.a(lowerLeft.getLongitude());
                double a5 = C4435i.a(upperRight.getLatitude());
                double a6 = C4435i.a(upperRight.getLongitude());
                sb.append("&polygon=" + a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((ac) ((AbstractC4370a) this).b).b.getShape().equals("Polygon") && (polyGonList = ((ac) ((AbstractC4370a) this).b).b.getPolyGonList()) != null && polyGonList.size() > 0) {
                sb.append("&polygon=" + C4435i.a(polyGonList));
            }
        }
        String city = ((ac) ((AbstractC4370a) this).b).a.getCity();
        if (!AbstractC4463x.c(city)) {
            String b = AbstractC4379b.b(city);
            sb.append("&city=");
            sb.append(b);
        }
        String b2 = AbstractC4379b.b(((ac) ((AbstractC4370a) this).b).a.getQueryString());
        if (!AbstractC4463x.c(b2)) {
            sb.append("&keywords=");
            sb.append(b2);
        }
        sb.append("&offset=");
        sb.append(((ac) ((AbstractC4370a) this).b).a.getPageSize());
        sb.append("&page=");
        sb.append(((ac) ((AbstractC4370a) this).b).a.getPageNum());
        String building = ((ac) ((AbstractC4370a) this).b).a.getBuilding();
        if (building != null && building.trim().length() > 0) {
            sb.append("&building=");
            sb.append(((ac) ((AbstractC4370a) this).b).a.getBuilding());
        }
        String b3 = AbstractC4379b.b(((ac) ((AbstractC4370a) this).b).a.getCategory());
        if (!AbstractC4463x.c(b3)) {
            sb.append("&types=");
            sb.append(b3);
        }
        if (!AbstractC4463x.c(((ac) ((AbstractC4370a) this).b).a.getExtensions())) {
            sb.append("&extensions=");
            sb.append(((ac) ((AbstractC4370a) this).b).a.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&key=");
        sb.append(bk.f(((AbstractC4370a) this).e));
        if (((ac) ((AbstractC4370a) this).b).a.getCityLimit()) {
            sb.append("&citylimit=true");
        } else {
            sb.append("&citylimit=false");
        }
        if (((ac) ((AbstractC4370a) this).b).a.isRequireSubPois()) {
            sb.append("&children=1");
        } else {
            sb.append("&children=0");
        }
        if (this.l) {
            if (((ac) ((AbstractC4370a) this).b).a.isSpecial()) {
                sb.append("&special=1");
            } else {
                sb.append("&special=0");
            }
        }
        T t2 = ((AbstractC4370a) this).b;
        if (((ac) t2).b == null && ((ac) t2).a.getLocation() != null) {
            sb.append("&sortrule=");
            sb.append(b(((ac) ((AbstractC4370a) this).b).a.isDistanceSort()));
            double a7 = C4435i.a(((ac) ((AbstractC4370a) this).b).a.getLocation().getLongitude());
            double a8 = C4435i.a(((ac) ((AbstractC4370a) this).b).a.getLocation().getLatitude());
            sb.append("&location=");
            sb.append(a7 + "," + a8);
        }
        return sb.toString();
    }
}
