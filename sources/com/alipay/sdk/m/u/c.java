package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c {
    public static final String b = "00:00:00:00:00:00";
    public static c c;
    public String a;

    public c(Context context) {
        try {
            try {
                String macAddress = WifiInfo.getMacAddress(com.alipay.sdk.m.w.b.d(null, context));
                this.a = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e) {
                e.a(e);
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

    public static c b(Context context) {
        if (c == null) {
            c = new c(context);
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

    public static g d(Context context) {
        try {
            NetworkInfo a = com.alipay.sdk.m.w.b.a(null, context);
            if (a != null && a.getType() == 0) {
                return g.a(a.getSubtype());
            }
            if (a != null && a.getType() == 1) {
                return g.WIFI;
            }
            return g.NONE;
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    public static String a(Context context) {
        return b(context).a().substring(0, 8);
    }
}
