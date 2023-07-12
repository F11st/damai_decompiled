package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.C4373ae;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.y */
/* loaded from: classes10.dex */
public final class C4464y extends AbstractC4463x<String, PoiItem> {
    private PoiSearch.Query k;

    public C4464y(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.k = null;
        this.k = query;
    }

    private static PoiItem e(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e) {
            C4435i.a(e, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e2) {
            C4435i.a(e2, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append((String) ((AbstractC4370a) this).b);
        sb.append("&output=json");
        PoiSearch.Query query = this.k;
        if (query != null && !AbstractC4463x.c(query.getExtensions())) {
            sb.append("&extensions=");
            sb.append(this.k.getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&children=1");
        sb.append("&key=" + bk.f(((AbstractC4370a) this).e));
        return sb.toString();
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return e(str);
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        return j();
    }

    @Override // com.amap.api.col.s.AbstractC4370a
    protected final C4373ae.C4375b d() {
        C4373ae.C4375b c4375b = new C4373ae.C4375b();
        c4375b.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return c4375b;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/place/detail?";
    }

    private static PoiItem a(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return C4443q.d(optJSONObject);
    }
}
