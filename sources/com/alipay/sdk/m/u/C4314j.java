package com.alipay.sdk.m.u;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.n.C4254e;
import com.alipay.sdk.m.s.C4293a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.j */
/* loaded from: classes10.dex */
public class C4314j {
    public static String a;

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        synchronized (C4314j.class) {
            try {
                z = PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (Throwable th) {
                C4302e.a(th);
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b(Context context, String str) {
        synchronized (C4314j.class) {
            try {
                PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
            } catch (Throwable th) {
                C4302e.a(th);
            }
        }
    }

    public static synchronized String a(C4293a c4293a, Context context, String str, String str2) {
        String str3;
        synchronized (C4314j.class) {
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                str3 = TextUtils.isEmpty(string) ? null : C4254e.a(a(context), string, str);
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                    C4218a.b(c4293a, "cp", C4226b.F, String.format("%s,%s", str, string));
                }
            } catch (Exception e) {
                C4302e.a(e);
            }
        }
        return str3;
    }

    public static synchronized void b(C4293a c4293a, Context context, String str, String str2) {
        synchronized (C4314j.class) {
            try {
                String b = C4254e.b(a(context), str2, str);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(b)) {
                    C4218a.b(c4293a, "cp", C4226b.G, String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, b).apply();
            } catch (Throwable th) {
                C4302e.a(th);
            }
        }
    }

    public static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                C4302e.a(th);
                str = "";
            }
            a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return a;
    }
}
