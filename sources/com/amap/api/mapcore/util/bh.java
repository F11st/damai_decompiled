package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.gd;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bh extends by<String, List<OfflineMapProvince>> {
    private Context d;

    public bh(Context context, String str) {
        super(context, str);
    }

    public void a(Context context) {
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.by
    /* renamed from: a */
    public List<OfflineMapProvince> b(JSONObject jSONObject) throws AMapException {
        try {
            if (this.d != null) {
                bx.c(jSONObject.toString(), this.d);
            }
        } catch (Throwable th) {
            hd.c(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.d;
            if (context != null) {
                return bx.a(jSONObject, context);
            }
            return null;
        } catch (JSONException e) {
            hd.c(e, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.mapcore.util.by
    protected Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.by
    protected JSONObject a(gd.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.w) == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return optJSONObject;
    }

    @Override // com.amap.api.mapcore.util.by
    protected String a() {
        return "015";
    }
}
