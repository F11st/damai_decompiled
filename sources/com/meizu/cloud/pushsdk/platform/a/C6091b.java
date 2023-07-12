package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.d.b.a.C6005b;
import com.meizu.cloud.pushsdk.platform.b.C6093a;
import com.meizu.cloud.pushsdk.platform.b.C6094b;
import com.meizu.cloud.pushsdk.platform.b.C6096d;
import com.meizu.cloud.pushsdk.platform.b.C6097e;
import com.meizu.cloud.pushsdk.platform.b.C6098f;
import com.meizu.cloud.pushsdk.platform.b.C6099g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.a.b */
/* loaded from: classes10.dex */
public class C6091b {
    private static C6091b a;
    private ScheduledExecutorService b;
    private final Context c;
    private final C6090a d;
    private final C6094b e;
    private final C6099g f;
    private final C6098f g;
    private final C6097e h;
    private final C6096d i;
    private final boolean j;

    public C6091b(Context context, boolean z) {
        this(context, z, true);
    }

    public C6091b(Context context, boolean z, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        C6090a c6090a = new C6090a(applicationContext);
        this.d = c6090a;
        if (z) {
            this.b = (ScheduledExecutorService) C6005b.a();
        }
        this.j = z2;
        this.e = new C6094b(applicationContext, c6090a, this.b, z2);
        this.f = new C6099g(applicationContext, c6090a, this.b, z2);
        this.g = new C6098f(applicationContext, c6090a, this.b, z2);
        this.h = new C6097e(applicationContext, c6090a, this.b, z2);
        this.i = new C6096d(applicationContext, c6090a, this.b, z2);
    }

    public static C6091b a(Context context) {
        if (a == null) {
            synchronized (C6091b.class) {
                if (a == null) {
                    a = new C6091b(context, true);
                }
            }
        }
        return a;
    }

    public C5950c<String> a(String str, String str2, String str3, File file) {
        return this.d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.e.a(z);
        this.f.a(z);
        this.g.a(z);
        this.i.a(z);
        this.h.a(z);
    }

    public boolean a(String str) {
        C6093a c6093a = new C6093a(this.c, this.b, this.j);
        c6093a.a(0);
        c6093a.d(str);
        return c6093a.m();
    }

    public boolean a(String str, String str2) {
        C6093a c6093a = new C6093a(this.c, this.b, this.j);
        c6093a.a(2);
        c6093a.a(str2);
        c6093a.d(str);
        return c6093a.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.e.b(str);
        this.e.c(str2);
        this.e.d(str3);
        return this.e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.g.b(str);
        this.g.c(str2);
        this.g.d(str3);
        this.g.a(str4);
        this.g.a(2);
        return this.g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i, boolean z) {
        this.g.b(str);
        this.g.c(str2);
        this.g.d(str3);
        this.g.a(str4);
        this.g.a(i);
        this.g.b(z);
        return this.g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(0);
        this.h.a(str5);
        return this.h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.g.b(str);
        this.g.c(str2);
        this.g.d(str3);
        this.g.a(str4);
        this.g.a(3);
        this.g.b(z);
        return this.g.m();
    }

    public boolean a(String str, int... iArr) {
        C6093a c6093a = new C6093a(this.c, this.b, this.j);
        c6093a.a(iArr);
        c6093a.d(str);
        c6093a.a(1);
        return c6093a.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f.b(str);
        this.f.c(str2);
        this.f.d(str3);
        return this.f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(2);
        return this.h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(1);
        this.h.a(str5);
        return this.h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.h.b(str);
        this.h.c(str2);
        this.h.d(str3);
        this.h.e(str4);
        this.h.a(3);
        return this.h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(0);
        this.i.a(str5);
        return this.i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(2);
        return this.i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(1);
        this.i.a(str5);
        return this.i.m();
    }
}
