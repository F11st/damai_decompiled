package com.alipay.sdk.m.a0;

import android.content.Context;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.a0.a */
/* loaded from: classes12.dex */
public final class C4138a {
    public static C4138a a = new C4138a();

    public static C4138a a() {
        return a;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }
}
