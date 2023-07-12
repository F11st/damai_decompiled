package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.utils.f */
/* loaded from: classes11.dex */
public class C7117f {
    private String a;
    private String b;

    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.utils.f$a */
    /* loaded from: classes11.dex */
    private static class C7118a {
        private static C7117f a = new C7117f();
    }

    public static C7117f a() {
        return C7118a.a;
    }

    public String b(Context context) {
        return this.a;
    }

    public String c(Context context) {
        return this.b;
    }

    private C7117f() {
        this.a = "";
        this.b = "";
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String str = this.b;
        if (str == null || str.trim().isEmpty()) {
            this.b = sharedPreferences.getString("build_model", "");
        }
        String str2 = this.a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.a = sharedPreferences.getString("build_device", "");
        }
    }

    public String b() {
        return this.b;
    }

    public void a(Context context, String str) {
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.b;
            if (str2 == null || !str2.equals(str)) {
                this.b = str;
                if (context != null) {
                    context.getSharedPreferences("device_info_file", 0).edit().putString("build_model", this.b).apply();
                    return;
                }
                return;
            }
            return;
        }
        this.b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 0).edit().remove("build_model").apply();
        }
    }
}
