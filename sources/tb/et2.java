package tb;

import android.net.Uri;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class et2 {
    private static et2 d;
    private List<ft2> a = new LinkedList();
    private Map<String, String> b = new HashMap();
    private String c = null;

    private et2() {
    }

    private String a(String str, Uri uri, Map<String, String> map) {
        String str2;
        if (yh2.f(str)) {
            return null;
        }
        if (str.startsWith("${url|") && str.length() > 7) {
            String substring = str.substring(6, str.length() - 1);
            if (!yh2.f(substring) && uri != null) {
                return uri.getQueryParameter(substring);
            }
        } else if (str.startsWith("${ut|") && str.length() > 6) {
            String substring2 = str.substring(5, str.length() - 1);
            if (!yh2.f(substring2) && map != null) {
                return map.get(substring2);
            }
        } else if (!str.startsWith("${") || str.length() <= 3) {
            return str;
        } else {
            String substring3 = str.substring(2, str.length() - 1);
            if (!yh2.f(substring3)) {
                if (map != null && (str2 = map.get(substring3)) != null) {
                    return str2;
                }
                if (uri != null) {
                    return uri.getQueryParameter(substring3);
                }
            }
        }
        return null;
    }

    private void b(String str, String str2) {
        Logger.f("UTMCTPKBiz", "", "pConfName", str, "pConfContent", str2);
        if (yh2.f(str2)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.has("kn") && !optJSONObject.isNull("kn")) {
                    String string = optJSONObject.getString("kn");
                    if (!"a".equals(string)) {
                        ft2 ft2Var = new ft2();
                        String optString = optJSONObject.optString("v");
                        if (yh2.f(optString)) {
                            optString = "${" + string + "}";
                        }
                        String optString2 = optJSONObject.optString(com.alipay.sdk.m.s.a.s, ft2.TYPE_FAR);
                        ft2Var.d(string);
                        ft2Var.e(optString);
                        ft2Var.f(optString2);
                        this.a.add(ft2Var);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized et2 e() {
        et2 et2Var;
        synchronized (et2.class) {
            if (d == null) {
                d = new et2();
            }
            et2Var = d;
        }
        return et2Var;
    }

    public synchronized void c(String str, String str2) {
        if (!yh2.f(str)) {
            if (str2 == null) {
                this.b.remove(str);
            } else {
                this.b.put(str, str2);
            }
        }
    }

    public synchronized void d(ft2 ft2Var) {
        if (ft2Var != null) {
            this.a.add(ft2Var);
        }
    }

    public synchronized String f(Uri uri, Map<String, String> map) {
        String K;
        String c = UTClientConfigMgr.d().c("tpk_md5");
        Logger.f("UTTPKBiz", "tpk_md5", c);
        if (c != null && !c.equals(this.c) && (K = AnalyticsMgr.K("tpk_string")) != null) {
            b(null, K);
            this.c = "" + K.hashCode();
        }
        for (ft2 ft2Var : this.a) {
            String a = ft2Var.a();
            String c2 = ft2Var.c();
            String b = ft2Var.b();
            if (yh2.f(a)) {
                return null;
            }
            if (yh2.f(this.b.get(a))) {
                String a2 = a(b, uri, map);
                if (!yh2.f(a2)) {
                    this.b.put(a, a2);
                }
            } else if (!ft2.TYPE_FAR.equals(c2)) {
                String a3 = a(b, uri, map);
                if (!yh2.f(a3)) {
                    this.b.put(a, a3);
                }
            }
        }
        if (!this.b.containsKey("ttid") && !yh2.f(sj.c().d())) {
            this.b.put("ttid", sj.c().d());
        }
        if (this.b.size() > 0) {
            return jn1.BLOCK_START_STR + yh2.a(this.b) + "}";
        }
        return null;
    }

    public synchronized void g() {
        this.b.clear();
    }
}
