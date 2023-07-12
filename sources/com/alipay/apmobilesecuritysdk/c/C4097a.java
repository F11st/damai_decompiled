package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.c0.C4165a;
import com.alipay.sdk.m.c0.C4168d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.c.a */
/* loaded from: classes12.dex */
public final class C4097a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (C4097a.class) {
            C4165a b = b(context, str, str2, str3);
            C4168d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b.toString());
        }
    }

    public static synchronized void a(String str) {
        synchronized (C4097a.class) {
            C4168d.a(str);
        }
    }

    public static synchronized void a(Throwable th) {
        synchronized (C4097a.class) {
            C4168d.a(th);
        }
    }

    public static C4165a b(Context context, String str, String str2, String str3) {
        String str4;
        try {
            str4 = context.getPackageName();
        } catch (Throwable unused) {
            str4 = "";
        }
        return new C4165a(Build.getMODEL(), str4, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202206130311", str, str2, str3);
    }
}
