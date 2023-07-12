package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bn {
    private static bn a;

    /* renamed from: a  reason: collision with other field name */
    private int f935a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f936a;

    private bn(Context context) {
        this.f936a = context.getApplicationContext();
    }

    public static bn a(Context context) {
        if (a == null) {
            a = new bn(context);
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i = this.f935a;
        if (i != 0) {
            return i;
        }
        try {
            this.f935a = Settings.Global.getInt(this.f936a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f935a;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a  reason: collision with other method in class */
    public Uri m1202a() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1203a() {
        String str = com.xiaomi.push.ae.f84a;
        return str.contains("xmsf") || str.contains("xiaomi") || str.contains("miui");
    }
}
