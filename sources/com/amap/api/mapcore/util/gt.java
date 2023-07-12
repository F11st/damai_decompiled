package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.gg;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gt {
    private static final String a = gn.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final String b = gn.c("FbGJzX3Nkaw");
    private static final String c = gn.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String d = gn.c("FQU5EU0RLMTA");
    private static final String e = gn.c("FMTAw");
    private static boolean f = false;
    private String g = "";

    public static gg.a a() {
        return new gg.a() { // from class: com.amap.api.mapcore.util.gt.1
            private gt a = new gt();

            @Override // com.amap.api.mapcore.util.gg.a
            public String a() {
                return this.a.c();
            }

            @Override // com.amap.api.mapcore.util.gg.a
            public Map<String, String> b() {
                return this.a.b();
            }

            @Override // com.amap.api.mapcore.util.gg.a
            public String a(Context context, String str) {
                return this.a.a(context, str);
            }

            @Override // com.amap.api.mapcore.util.gg.a
            public String a(String str, String str2, String str3, String str4) {
                return this.a.a(str, str2, str3, str4);
            }
        };
    }

    private String d() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String a2 = gh.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a2.length(); i++) {
            stringBuffer.append((char) (a2.charAt(i) - (i % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer2.length() / 2; i2++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i2) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i2)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.g = stringBuffer4;
        return stringBuffer4;
    }

    public synchronized Map<String, String> b() {
        if (f) {
            return null;
        }
        f = true;
        HashMap hashMap = new HashMap();
        hashMap.put(gn.c("FZW50"), gn.c("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(gn.c("SY2hhbm5lbD0"));
        String str = b;
        sb.append(str);
        sb.append(gn.c("SJmRpdj0"));
        String str2 = d;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(gn.c("FQA"));
        stringBuffer.append(c);
        String a2 = gw.a(stringBuffer.toString());
        sb.append(gn.c("FJnNpZ249"));
        sb.append(a2.toUpperCase(Locale.US));
        sb.append(gn.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(gn.c("FaW4"), gr.a(gx.a(sb.toString().getBytes(), a.getBytes())));
        hashMap.put(gn.c("Sa2V5dA"), e);
        return hashMap;
    }

    public String c() {
        return gu.a();
    }

    public String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(gn.c("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(gn.c("FZGF0YQ"))).optString(gn.c("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                gu.a(optString);
                gp.a(context).a(optString);
                return optString;
            }
            return "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(gn.c("LdGlk"), str);
            jSONObject.put(gn.c("FZGl1"), str2);
            jSONObject.put(gn.c("AZGl1Mg"), str3);
            jSONObject.put(gn.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String a2 = gw.a();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = gr.a(gx.a((jSONObject2 + "\u0000").getBytes(), a2.getBytes()));
            if (!TextUtils.isEmpty(a3)) {
                try {
                    String a4 = gr.a(gv.a(a2.getBytes("utf-8"), gv.a(d())));
                    return gn.c("Fa2V5PQ") + URLEncoder.encode(a4) + gn.c("SJmRhdGE9") + URLEncoder.encode(a3);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }
}
