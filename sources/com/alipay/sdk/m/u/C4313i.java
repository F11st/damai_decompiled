package com.alipay.sdk.m.u;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.s.C4293a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.i */
/* loaded from: classes10.dex */
public class C4313i {
    public static final String a = "pref_trade_token";
    public static final String b = ";";
    public static final String c = "result={";
    public static final String d = "}";
    public static final String e = "trade_token=\"";
    public static final String f = "\"";
    public static final String g = "trade_token=";

    public static void a(C4293a c4293a, Context context, String str) {
        try {
            String a2 = a(str);
            C4302e.b(C4230a.z, "trade token: " + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            C4314j.b(c4293a, context, a, a2);
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, C4226b.I, th);
            C4302e.a(th);
        }
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(c) && split[i].endsWith("}")) {
                String[] split2 = split[i].substring(8, split[i].length() - 1).split("&");
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length) {
                        break;
                    } else if (split2[i2].startsWith(e) && split2[i2].endsWith("\"")) {
                        str2 = split2[i2].substring(13, split2[i2].length() - 1);
                        break;
                    } else if (split2[i2].startsWith(g)) {
                        str2 = split2[i2].substring(12);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(C4293a c4293a, Context context) {
        String a2 = C4314j.a(c4293a, context, a, "");
        C4302e.b(C4230a.z, "get trade token: " + a2);
        return a2;
    }
}
