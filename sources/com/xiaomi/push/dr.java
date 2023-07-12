package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.al;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dr {
    private static volatile dr a;

    /* renamed from: a  reason: collision with other field name */
    private Context f222a;

    /* renamed from: a  reason: collision with other field name */
    private a f223a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        void a();
    }

    private dr(Context context) {
        this.f222a = context;
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    public static dr a(Context context) {
        if (a == null) {
            synchronized (dr.class) {
                if (a == null) {
                    a = new dr(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.push.service.ba baVar, al alVar, boolean z) {
        if (baVar.a(ho.UploadSwitch.a(), true)) {
            dv dvVar = new dv(this.f222a);
            if (z) {
                alVar.a((al.a) dvVar, a(baVar.a(ho.UploadFrequency.a(), 86400)));
            } else {
                alVar.m664a((al.a) dvVar);
            }
        }
    }

    private boolean a() {
        try {
            Context context = this.f222a;
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            ((Application) context).registerActivityLifecycleCallbacks(new dl(this.f222a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        al a2 = al.a(this.f222a);
        com.xiaomi.push.service.ba a3 = com.xiaomi.push.service.ba.a(this.f222a);
        SharedPreferences sharedPreferences = this.f222a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < 172800000) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(ho.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(ho.StorageCollectionFrequency.a(), 86400));
            a2.a(new du(this.f222a, a4), a4, 0);
        }
        if (m.m1119a(this.f222a) && (aVar = this.f223a) != null) {
            aVar.a();
        }
        if (a3.a(ho.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m770a() {
        al.a(this.f222a).a(new ds(this));
    }
}
