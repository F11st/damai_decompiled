package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.g */
/* loaded from: classes10.dex */
public abstract class AbstractC5620g {
    public static String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(AbstractC5604a.a(str, str2))) {
            C5653y.c("hmsSdk", "getAndroidId(): to getConfigByType()");
            return c(context, str, str2);
        }
        return AbstractC5604a.a(str, str2);
    }

    public static String b(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            C5653y.f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return d(context, str, str2);
    }

    public static String c(Context context, String str, String str2) {
        if (AbstractC5604a.b(str, str2)) {
            if (TextUtils.isEmpty(AbstractC5607b.d())) {
                C5624i.c().b().b(AbstractC5616f.a(context));
            }
            return AbstractC5607b.d();
        }
        return "";
    }

    public static String d(Context context, String str, String str2) {
        if (TextUtils.isEmpty(AbstractC5609c.d(str, str2))) {
            C5630l b = C5624i.c().b();
            if (TextUtils.isEmpty(b.h())) {
                String b2 = AbstractC5616f.b(context);
                if (!s0.a("channel", b2, 256)) {
                    b2 = "";
                }
                b.f(b2);
            }
            return b.h();
        }
        return AbstractC5609c.d(str, str2);
    }
}
