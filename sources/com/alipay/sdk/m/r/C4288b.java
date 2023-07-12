package com.alipay.sdk.m.r;

import android.text.TextUtils;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.t.C4296a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.r.b */
/* loaded from: classes12.dex */
public class C4288b {
    public EnumC4287a a;
    public String b;
    public String[] c;

    public C4288b(String str) {
        this.b = str;
    }

    public static void a(C4288b c4288b) {
        String[] c = c4288b.c();
        if (c.length == 3 && TextUtils.equals("tid", c[0])) {
            C4296a a = C4296a.a(C4295b.d().b());
            if (TextUtils.isEmpty(c[1]) || TextUtils.isEmpty(c[2])) {
                return;
            }
            a.a(c[1], c[2]);
        }
    }

    public static String[] b(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String[] c() {
        return this.c;
    }

    public C4288b(String str, EnumC4287a enumC4287a) {
        this.b = str;
        this.a = enumC4287a;
    }

    public static List<C4288b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] a = a(jSONObject.optString("name", ""));
        for (int i = 0; i < a.length; i++) {
            EnumC4287a a2 = EnumC4287a.a(a[i]);
            if (a2 != EnumC4287a.None) {
                C4288b c4288b = new C4288b(a[i], a2);
                c4288b.c = b(a[i]);
                arrayList.add(c4288b);
            }
        }
        return arrayList;
    }

    public String b() {
        return this.b;
    }

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public EnumC4287a a() {
        return this.a;
    }
}
