package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class cb {
    private static final String a = bw.c("SRFZHZUVZT3BOa0ZiemZRQQ");
    private static final String b = bw.c("FbGJzX3Nkaw");
    private static final String c = bw.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    private static final String d = bw.c("FQU5EU0RLMTA");
    private static final String e = bw.c("FMTAw");
    private static boolean f = false;
    private String g = "";

    public static bo.InterfaceC4391a a() {
        return new bo.InterfaceC4391a() { // from class: com.amap.api.col.s.cb.1
            private cb a = new cb();

            @Override // com.amap.api.col.s.bo.InterfaceC4391a
            public final df a(byte[] bArr, Map<String, String> map) {
                return new cy(bArr, map);
            }

            @Override // com.amap.api.col.s.bo.InterfaceC4391a
            public final Map<String, String> b() {
                return this.a.b();
            }

            @Override // com.amap.api.col.s.bo.InterfaceC4391a
            public final String a() {
                return cb.c();
            }

            @Override // com.amap.api.col.s.bo.InterfaceC4391a
            public final String a(Context context, String str) {
                return cb.a(context, str);
            }

            @Override // com.amap.api.col.s.bo.InterfaceC4391a
            public final String a(String str, String str2, String str3, String str4) {
                return this.a.a(str, str2, str3, str4);
            }
        };
    }

    public static String c() {
        return cc.a();
    }

    private String d() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        String a2 = bp.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
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

    public final synchronized Map<String, String> b() {
        if (f) {
            return null;
        }
        f = true;
        HashMap hashMap = new HashMap();
        hashMap.put(bw.c("FZW50"), bw.c("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(bw.c("SY2hhbm5lbD0"));
        String str = b;
        sb.append(str);
        sb.append(bw.c("SJmRpdj0"));
        String str2 = d;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(bw.c("FQA"));
        stringBuffer.append(c);
        String a2 = ce.a(stringBuffer.toString());
        sb.append(bw.c("FJnNpZ249"));
        sb.append(a2.toUpperCase(Locale.US));
        sb.append(bw.c("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(bw.c("FaW4"), bz.a(cv.a(sb.toString().getBytes(), a.getBytes())));
        hashMap.put(bw.c("Sa2V5dA"), e);
        return hashMap;
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(bw.c("UY29kZQ")) == 1) {
                String optString = new JSONObject(jSONObject.optString(bw.c("FZGF0YQ"))).optString(bw.c("FYWRpdQ"));
                if (TextUtils.isEmpty(optString)) {
                    return "";
                }
                cc.a(optString);
                bx.a(context).a(optString);
                return optString;
            }
            return "";
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final String a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bw.c("LdGlk"), str);
            jSONObject.put(bw.c("FZGl1"), str2);
            jSONObject.put(bw.c("AZGl1Mg"), str3);
            jSONObject.put(bw.c("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String a2 = ce.a();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = bz.a(cv.a((jSONObject2 + "\u0000").getBytes(), a2.getBytes()));
            if (!TextUtils.isEmpty(a3)) {
                try {
                    String a4 = bz.a(C4403cd.a(a2.getBytes("utf-8"), C4403cd.a(d())));
                    return bw.c("Fa2V5PQ") + URLEncoder.encode(a4) + bw.c("SJmRhdGE9") + URLEncoder.encode(a3);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }
}
