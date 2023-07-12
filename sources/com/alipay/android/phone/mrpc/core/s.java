package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class s {
    public static Boolean a;

    public static final boolean a(Context context) {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
