package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static b a;
    private ScheduledExecutorService b;
    private final Context c;
    private final a d;
    private final com.meizu.cloud.pushsdk.platform.b.b e;
    private final g f;
    private final f g;
    private final e h;
    private final d i;
    private final boolean j;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        a aVar = new a(applicationContext);
        this.d = aVar;
        if (z) {
            this.b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        }
        this.j = z2;
        this.e = new com.meizu.cloud.pushsdk.platform.b.b(applicationContext, aVar, this.b, z2);
        this.f = new g(applicationContext, aVar, this.b, z2);
        this.g = new f(applicationContext, aVar, this.b, z2);
        this.h = new e(applicationContext, aVar, this.b, z2);
        this.i = new d(applicationContext, aVar, this.b, z2);
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context, true);
                }
            }
        }
        return a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
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
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.c, this.b, this.j);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.c, this.b, this.j);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
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
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.c, this.b, this.j);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
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
