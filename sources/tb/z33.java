package tb;

import android.content.Context;
import com.alimm.xadsdk.request.builder.IRequestConst;
import io.flutter.stat.StatServices;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z33 extends o83 {
    public JSONObject l = null;
    public Context m = null;

    @Override // com.loc.bl
    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(IRequestConst.USER_AGENT, "AMAP SDK Android core 4.2.9");
        hashMap.put("X-INFO", com.loc.o1.b(this.m));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.2.9", StatServices.CATEGORY));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.loc.bl
    public final String j() {
        return com.loc.q1.a().h() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }

    @Override // com.loc.bl
    public final Map<String, String> q() {
        return null;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.l;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = this.l.get(next).toString();
                    stringBuffer.append(next + "=" + URLEncoder.encode(obj, "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String j = com.loc.l.j(this.m);
            stringBuffer.append("&key=".concat(String.valueOf(j)));
            String a = com.loc.o1.a();
            stringBuffer.append("&ts=".concat(String.valueOf(a)));
            stringBuffer.append("&scode=" + com.loc.o1.c(this.m, a, "key=".concat(String.valueOf(j))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.loc.bl
    public final String t() {
        return StatServices.CATEGORY;
    }
}
