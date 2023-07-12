package com.alipay.sdk.m.u;

import com.alipay.sdk.m.j.EnumC4213c;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.s.C4293a;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.l */
/* loaded from: classes10.dex */
public class C4316l {
    public static final String a = "resultStatus";
    public static final String b = "memo";
    public static final String c = "result";

    public static Map<String, String> a(C4293a c4293a, String str) {
        Map<String, String> a2 = a();
        try {
            return a(str);
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, C4226b.q, th);
            return a2;
        }
    }

    public static String b(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public static Map<String, String> a() {
        EnumC4213c b2 = EnumC4213c.b(EnumC4213c.CANCELED.b());
        HashMap hashMap = new HashMap();
        hashMap.put(a, Integer.toString(b2.b()));
        hashMap.put(b, b2.a());
        hashMap.put("result", "");
        return hashMap;
    }

    public static Map<String, String> a(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, b(str2, substring));
        }
        return hashMap;
    }

    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (Throwable th) {
            C4302e.a(th);
        }
        return "?";
    }
}
