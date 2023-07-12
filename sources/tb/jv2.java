package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.ut.mini.UTAnalytics;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class jv2 extends ib {
    @Override // tb.ib
    protected void h(np2 np2Var) {
        int i;
        JSONObject fields = e().getFields();
        if (fields == null) {
            return;
        }
        try {
            i = fields.getInteger("eventId").intValue();
        } catch (Exception unused) {
            i = -1;
        }
        if (i < 0) {
            return;
        }
        String string = fields.getString("page");
        String string2 = fields.getString("arg1");
        String string3 = fields.getString("arg2");
        String string4 = fields.getString(UTDataCollectorNodeColumn.ARG3);
        String str = TextUtils.isEmpty(string3) ? "" : string3;
        String str2 = TextUtils.isEmpty(string4) ? "" : string4;
        JSONObject jSONObject = fields.getJSONObject("args");
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!TextUtils.isEmpty(key) && (value instanceof String)) {
                    hashMap.put(key, String.valueOf(yg0.a(this.e.getData(), value)));
                }
            }
        }
        UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(string, i, string2, str, str2, hashMap).build());
    }
}
