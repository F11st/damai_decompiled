package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.gd;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bc extends by<String, bb> {
    public bc(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.mapcore.util.by
    protected JSONObject a(gd.a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.w) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    @Override // com.amap.api.mapcore.util.by
    protected Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.a);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.by
    protected String a() {
        return "016";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.by
    /* renamed from: a */
    public bb b(JSONObject jSONObject) throws AMapException {
        bb bbVar = new bb();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                bbVar.a(false);
            } else if (optString.equals("1")) {
                bbVar.a(true);
            }
            bbVar.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            hd.c(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return bbVar;
    }
}
