package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f extends e<ab, CloudItemDetail> {
    public f(Context context, ab abVar) {
        super(context, abVar);
    }

    private static CloudItemDetail c(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return d(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static CloudItemDetail d(JSONObject jSONObject) throws JSONException {
        JSONArray a = e.a(jSONObject);
        if (a == null || a.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = a.getJSONObject(0);
        CloudItemDetail c = e.c(jSONObject2);
        e.a(c, jSONObject2);
        return c;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.df
    public final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bk.f(((a) this).e));
        hashtable.put("layerId", ((ab) ((a) this).b).a);
        hashtable.put("output", Preloader.KEY_JSON);
        hashtable.put("id", ((ab) ((a) this).b).b);
        String a = bn.a();
        String a2 = bn.a(((a) this).e, a, bw.b(hashtable));
        hashtable.put("ts", a);
        hashtable.put("scode", a2);
        return hashtable;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.e() + "/datasearch/id";
    }
}
