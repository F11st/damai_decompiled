package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.b0.C4149e;
import com.alipay.sdk.m.y.C4367c;
import com.alipay.sdk.m.z.C4368a;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.e.g */
/* loaded from: classes12.dex */
public final class C4111g {
    public static synchronized String a(Context context, String str) {
        synchronized (C4111g.class) {
            String a = C4149e.a(context, "openapi_file_pri", "openApi" + str, "");
            if (C4368a.a(a)) {
                return "";
            }
            String b = C4367c.b(C4367c.a(), a);
            return C4368a.a(b) ? "" : b;
        }
    }

    public static synchronized void a() {
        synchronized (C4111g.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (C4111g.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        synchronized (C4111g.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.putString("openApi" + str, C4367c.a(C4367c.a(), str2));
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
