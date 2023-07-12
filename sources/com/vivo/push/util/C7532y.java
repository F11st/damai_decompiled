package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.y */
/* loaded from: classes11.dex */
public final class C7532y implements InterfaceC7511d {
    private static final HashMap<String, Integer> a = new HashMap<>();
    private static final HashMap<String, Long> b = new HashMap<>();
    private static final HashMap<String, String> c = new HashMap<>();
    private static C7532y d;
    private Context e;
    private InterfaceC7511d f;
    private boolean g;

    private C7532y(Context context) {
        this.g = false;
        this.e = context;
        this.g = a(context);
        C7523p.d("SystemCache", "init status is " + this.g + ";  curCache is " + this.f);
    }

    public static synchronized C7532y b(Context context) {
        C7532y c7532y;
        synchronized (C7532y.class) {
            if (d == null) {
                d = new C7532y(context.getApplicationContext());
            }
            c7532y = d;
        }
        return c7532y;
    }

    public final void a() {
        C7531x c7531x = new C7531x();
        if (c7531x.a(this.e)) {
            c7531x.a();
            C7523p.d("SystemCache", "sp cache is cleared");
        }
    }

    @Override // com.vivo.push.util.InterfaceC7511d
    public final void b(String str, String str2) {
        InterfaceC7511d interfaceC7511d;
        c.put(str, str2);
        if (!this.g || (interfaceC7511d = this.f) == null) {
            return;
        }
        interfaceC7511d.b(str, str2);
    }

    @Override // com.vivo.push.util.InterfaceC7511d
    public final boolean a(Context context) {
        C7529v c7529v = new C7529v();
        this.f = c7529v;
        boolean a2 = c7529v.a(context);
        if (!a2) {
            C7531x c7531x = new C7531x();
            this.f = c7531x;
            a2 = c7531x.a(context);
        }
        if (!a2) {
            this.f = null;
        }
        return a2;
    }

    @Override // com.vivo.push.util.InterfaceC7511d
    public final String a(String str, String str2) {
        InterfaceC7511d interfaceC7511d;
        String str3 = c.get(str);
        return (str3 != null || (interfaceC7511d = this.f) == null) ? str3 : interfaceC7511d.a(str, str2);
    }
}
