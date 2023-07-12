package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ae;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class y extends x<String, PoiItem> {
    private PoiSearch.Query k;

    public y(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.k = null;
        this.k = query;
    }

    private static PoiItem e(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            i.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            i.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) ((a) this).b);
        sb.append("&output=json");
        PoiSearch.Query query = this.k;
        if (query != null && !x.c(query.getExtensions())) {
            sb.append("&extensions=");
            sb.append(this.k.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&children=1");
        sb.append("&key=" + bk.f(((a) this).e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return e(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        return j();
    }

    @Override // com.amap.api.col.s.a
    protected final ae.b d() {
        ae.b bVar = new ae.b();
        bVar.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/place/detail?";
    }

    private static PoiItem a(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return q.d(optJSONObject);
    }
}
