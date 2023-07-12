package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "rpTraceLink")
/* loaded from: classes8.dex */
public class n extends a {
    private static final String as = "TraceLinkApi";

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return "rpTraceLink";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final boolean a(String str, h hVar) {
        try {
            com.alibaba.security.common.c.a.a(as, str);
            TrackLog trackLog = new TrackLog();
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("token");
            String optString2 = jSONObject.optString("service");
            String optString3 = jSONObject.optString("method");
            int optInt = jSONObject.optInt("code");
            String optString4 = jSONObject.optString("msg");
            String optString5 = jSONObject.optString("params");
            String optString6 = jSONObject.optString("result");
            JSONArray optJSONArray = jSONObject.optJSONArray(IRequestConst.TAGS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList(10);
                for (int i = 0; i < 10; i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                trackLog.setTags(arrayList);
            }
            trackLog.setLayer("h5");
            trackLog.setService(optString2);
            trackLog.setMethod(optString3);
            trackLog.setCode(optInt);
            trackLog.setMsg(optString4);
            trackLog.setParams(optString5);
            trackLog.setResult(optString6);
            g.a.a.d = optString;
            g.a.a.a(trackLog);
            WVResult wVResult = new WVResult();
            wVResult.setSuccess();
            hVar.b(wVResult);
            return true;
        } catch (Exception unused) {
            com.alibaba.security.common.c.a.b();
            return true;
        }
    }
}
