package com.alipay.sdk.m.h0;

import android.content.Context;
import com.alipay.sdk.m.a.InterfaceC4131a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.h0.a */
/* loaded from: classes12.dex */
public class C4203a {
    public static String a(Context context) {
        if (InterfaceC4131a.C4134b.a) {
            return InterfaceC4131a.C4135c.C4137b.a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (InterfaceC4131a.C4134b.a) {
            return InterfaceC4131a.C4135c.C4137b.a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (InterfaceC4131a.C4134b.a) {
            return InterfaceC4131a.C4135c.C4137b.a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (InterfaceC4131a.C4134b.a) {
            return InterfaceC4131a.C4135c.C4137b.a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void e(Context context) {
        InterfaceC4131a.C4134b.b = InterfaceC4131a.C4135c.C4137b.a.a(context.getApplicationContext());
        InterfaceC4131a.C4134b.a = true;
    }

    public static boolean a() {
        if (InterfaceC4131a.C4134b.a) {
            return InterfaceC4131a.C4134b.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
