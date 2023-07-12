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
    private List<x> f40a = new ArrayList();

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
            x xVar = new x();
            xVar.f80a = str;
            if (this.f40a.contains(xVar)) {
                for (x xVar2 : this.f40a) {
                    if (xVar2.equals(xVar)) {
                        return xVar2.a;
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
            x xVar = new x();
            xVar.a = 0;
            xVar.f80a = str;
            if (this.f40a.contains(xVar)) {
                this.f40a.remove(xVar);
            }
            this.f40a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m608a(String str) {
        synchronized (this.f40a) {
            x xVar = new x();
            xVar.f80a = str;
            return this.f40a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f40a) {
            x xVar = new x();
            xVar.f80a = str;
            if (this.f40a.contains(xVar)) {
                Iterator<x> it = this.f40a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    x next = it.next();
                    if (xVar.equals(next)) {
                        xVar = next;
                        break;
                    }
                }
            }
            xVar.a++;
            this.f40a.remove(xVar);
            this.f40a.add(xVar);
        }
    }

    public void c(String str) {
        synchronized (this.f40a) {
            x xVar = new x();
            xVar.f80a = str;
            if (this.f40a.contains(xVar)) {
                this.f40a.remove(xVar);
            }
        }
    }
}
