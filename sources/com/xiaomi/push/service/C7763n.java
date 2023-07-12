package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7613bm;
import com.xiaomi.push.C7674i;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ik;
import com.xiaomi.push.it;
import com.xiaomi.push.iz;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.n */
/* loaded from: classes11.dex */
public class C7763n {
    public static ik a(Cif cif) {
        byte[] m1028a = cif.m1028a();
        ik ikVar = new ik();
        try {
            it.a(ikVar, m1028a);
            return ikVar;
        } catch (iz unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] b = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (b != null) {
                al.m1163a(context, C7782y.a(b), b);
            } else {
                AbstractC7535b.m586a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            AbstractC7535b.a("notify fcm notification error ", th);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7535b.m586a("secret is empty, return null");
            return null;
        }
        try {
            return C7674i.b(C7613bm.m701a(str), bArr);
        } catch (Exception e) {
            AbstractC7535b.a("encryption error. ", e);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7535b.m586a("secret is empty, return null");
            return null;
        }
        try {
            return C7674i.a(C7613bm.m701a(str), bArr);
        } catch (Exception e) {
            AbstractC7535b.a("dencryption error. ", e);
            return null;
        }
    }
}
