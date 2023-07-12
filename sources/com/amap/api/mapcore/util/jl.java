package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.gm;
import com.huawei.hms.opendevice.AbstractC5658c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jl {
    private gm a;

    public jl(String str) {
        this.a = null;
        try {
            this.a = new gm.C4569a(str, "1.0", "1.0.0").a(new String[]{"info"}).a();
        } catch (gb unused) {
        }
    }

    public final void a(Context context, gm gmVar) {
        if (gmVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(gmVar);
        String jSONArray = a(arrayList).toString();
        if (TextUtils.isEmpty(jSONArray)) {
            return;
        }
        hq.a(context, this.a, "rbck", jSONArray);
    }

    public final List<gm> a(Context context) {
        try {
            return a(new JSONArray(hq.a(context, this.a, "rbck")));
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    private JSONArray a(List<gm> list) {
        if (list.size() == 0) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (gm gmVar : list) {
            jSONArray.put(a(gmVar));
        }
        return jSONArray;
    }

    private static JSONObject a(gm gmVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", gmVar.a());
            jSONObject.put("b", gmVar.b());
            jSONObject.put(AbstractC5658c.a, gmVar.c());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; gmVar.g() != null && i < gmVar.g().length; i++) {
                jSONArray.put(gmVar.g()[i]);
            }
            jSONObject.put("d", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static gm a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString(AbstractC5658c.a);
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            return new gm.C4569a(optString, optString2, optString).a(optString3).a((String[]) arrayList.toArray(new String[0])).a();
        } catch (Throwable unused) {
            return null;
        }
    }

    private List<gm> a(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            gm gmVar = null;
            try {
                gmVar = a(jSONArray.getJSONObject(i));
            } catch (JSONException unused) {
            }
            if (gmVar != null) {
                arrayList.add(gmVar);
            }
        }
        return arrayList;
    }
}
