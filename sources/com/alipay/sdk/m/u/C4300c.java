package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;
import com.alipay.sdk.m.w.C4325b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.c */
/* loaded from: classes10.dex */
public class C4300c {
    public static final String b = "00:00:00:00:00:00";
    public static C4300c c;
    public String a;

    public C4300c(Context context) {
        try {
            try {
                String macAddress = WifiInfo.getMacAddress(C4325b.d(null, context));
                this.a = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e) {
                C4302e.a(e);
                if (!TextUtils.isEmpty(this.a)) {
                    return;
                }
            }
            this.a = b;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.a)) {
                this.a = b;
            }
            throw th;
        }
    }

    public static C4300c b(Context context) {
        if (c == null) {
            c = new C4300c(context);
        }
        return c;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String a() {
        String str = b() + "|";
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return str + "000000000000000";
        }
        return str + c2;
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String d() {
        return this.a;
    }

    public static EnumC4304g d(Context context) {
        try {
            NetworkInfo a = C4325b.a(null, context);
            if (a != null && a.getType() == 0) {
                return EnumC4304g.a(a.getSubtype());
            }
            if (a != null && a.getType() == 1) {
                return EnumC4304g.WIFI;
            }
            return EnumC4304g.NONE;
        } catch (Exception unused) {
            return EnumC4304g.NONE;
        }
    }

    public static String a(Context context) {
        return b(context).a().substring(0, 8);
    }
}
