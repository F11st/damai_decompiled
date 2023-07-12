package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.request.builder.IRequestConst;
import io.flutter.stat.StatServices;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.cn */
/* loaded from: classes10.dex */
public final class C4404cn extends br {
    public JSONObject a = null;
    public Context b = null;

    @Override // com.amap.api.col.s.df
    public final String c() {
        return StatServices.CATEGORY;
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.df
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(IRequestConst.USER_AGENT, "AMAP SDK Android core 4.2.9");
        hashMap.put("X-INFO", bn.a(this.b));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.2.9", StatServices.CATEGORY));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public final byte[] g() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.a.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String f = bk.f(this.b);
            stringBuffer.append("&key=".concat(String.valueOf(f)));
            String a = bn.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a)));
            stringBuffer.append("&scode=" + bn.a(this.b, a, "key=".concat(String.valueOf(f))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return bq.a().b() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}
