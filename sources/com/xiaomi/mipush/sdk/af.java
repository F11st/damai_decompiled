package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class af {
    private static volatile af a;

    /* renamed from: a  reason: collision with other field name */
    private Context f39a;

    /* renamed from: a  reason: collision with other field name */
    private List<C7590x> f40a = new ArrayList();

    private af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f39a = applicationContext;
        if (applicationContext == null) {
            this.f39a = context;
        }
    }

    public static af a(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        synchronized (this.f40a) {
            C7590x c7590x = new C7590x();
            c7590x.f80a = str;
            if (this.f40a.contains(c7590x)) {
                for (C7590x c7590x2 : this.f40a) {
                    if (c7590x2.equals(c7590x)) {
                        return c7590x2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(au auVar) {
        return this.f39a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public synchronized void a(au auVar, String str) {
        SharedPreferences sharedPreferences = this.f39a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m607a(String str) {
        synchronized (this.f40a) {
            C7590x c7590x = new C7590x();
            c7590x.a = 0;
            c7590x.f80a = str;
            if (this.f40a.contains(c7590x)) {
                this.f40a.remove(c7590x);
            }
            this.f40a.add(c7590x);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m608a(String str) {
        synchronized (this.f40a) {
            C7590x c7590x = new C7590x();
            c7590x.f80a = str;
            return this.f40a.contains(c7590x);
        }
    }

    public void b(String str) {
        synchronized (this.f40a) {
            C7590x c7590x = new C7590x();
            c7590x.f80a = str;
            if (this.f40a.contains(c7590x)) {
                Iterator<C7590x> it = this.f40a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C7590x next = it.next();
                    if (c7590x.equals(next)) {
                        c7590x = next;
                        break;
                    }
                }
            }
            c7590x.a++;
            this.f40a.remove(c7590x);
            this.f40a.add(c7590x);
        }
    }

    public void c(String str) {
        synchronized (this.f40a) {
            C7590x c7590x = new C7590x();
            c7590x.f80a = str;
            if (this.f40a.contains(c7590x)) {
                this.f40a.remove(c7590x);
            }
        }
    }
}
