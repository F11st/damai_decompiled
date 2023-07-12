package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.b0.C4145a;
import com.alipay.sdk.m.b0.C4149e;
import com.alipay.sdk.m.y.C4366b;
import com.alipay.sdk.m.z.C4368a;
import java.util.UUID;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.e.h */
/* loaded from: classes12.dex */
public class C4112h {
    public static String a = "";

    public static long a(Context context) {
        String a2 = C4145a.a(context, "vkeyid_settings", "update_time_interval");
        if (C4368a.b(a2)) {
            try {
                return Long.parseLong(a2);
            } catch (Exception unused) {
                return 86400000L;
            }
        }
        return 86400000L;
    }

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static void a(Context context, String str, long j) {
        C4145a.a(context, "vkeyid_settings", "vkey_valid" + str, String.valueOf(j));
    }

    public static void a(Context context, String str, String str2) {
        C4145a.a(context, "vkeyid_settings", str, str2);
    }

    public static void a(Context context, boolean z) {
        a(context, "log_switch", z ? "1" : "0");
    }

    public static String b(Context context) {
        return C4145a.a(context, "vkeyid_settings", "last_apdid_env");
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static boolean c(Context context) {
        String a2 = C4145a.a(context, "vkeyid_settings", "log_switch");
        return a2 != null && "1".equals(a2);
    }

    public static String d(Context context) {
        return C4145a.a(context, "vkeyid_settings", "dynamic_key");
    }

    public static void d(Context context, String str) {
        a(context, "agent_switch", str);
    }

    public static String e(Context context) {
        return C4145a.a(context, "vkeyid_settings", "apse_degrade");
    }

    public static void e(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static String f(Context context) {
        String str;
        SharedPreferences.Editor edit;
        synchronized (C4112h.class) {
            if (C4368a.a(a)) {
                String a2 = C4149e.a(context, "alipay_vkey_random", "random", "");
                a = a2;
                if (C4368a.a(a2)) {
                    String a3 = C4366b.a(UUID.randomUUID().toString());
                    a = a3;
                    if (a3 != null && (edit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                        edit.putString("random", a3);
                        edit.commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    public static void f(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static void g(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    public static long h(Context context, String str) {
        try {
            String a2 = C4145a.a(context, "vkeyid_settings", "vkey_valid" + str);
            if (C4368a.a(a2)) {
                return 0L;
            }
            return Long.parseLong(a2);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
