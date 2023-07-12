package com.tencent.open.b;

import com.tencent.open.utils.C7126m;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.b.e */
/* loaded from: classes11.dex */
public class C7084e {
    protected static C7084e a;

    protected C7084e() {
    }

    public static synchronized C7084e a() {
        C7084e c7084e;
        synchronized (C7084e.class) {
            if (a == null) {
                a = new C7084e();
            }
            c7084e = a;
        }
        return c7084e;
    }

    public void a(int i, String str, String str2, String str3, String str4, Long l, int i2, int i3, String str5) {
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        C7087h.a().a(C7126m.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        C7087h.a().a(C7126m.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        C7087h.a().a(C7126m.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }
}
