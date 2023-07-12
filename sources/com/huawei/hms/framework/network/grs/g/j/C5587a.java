package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.k.C5591d;
import com.huawei.hms.framework.network.grs.h.C5594c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.framework.network.grs.g.j.a */
/* loaded from: classes10.dex */
public class C5587a {
    private static final String a = "a";
    private static C5591d b;

    public static synchronized C5591d a(Context context) {
        synchronized (C5587a.class) {
            C5591d c5591d = b;
            if (c5591d != null) {
                return c5591d;
            }
            String a2 = C5594c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(a2).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.get(i).toString());
                    }
                }
                C5591d c5591d2 = new C5591d();
                b = c5591d2;
                c5591d2.a(arrayList);
                b.b(jSONObject.getString("grs_query_endpoint_1.0"));
                b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e) {
                Logger.w(a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
            return b;
        }
    }
}
