package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.s */
/* loaded from: classes11.dex */
public class C7583s {
    private static volatile C7583s a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f77a;

    private C7583s(Context context) {
        this.f77a = context.getApplicationContext();
    }

    private static C7583s a(Context context) {
        if (a == null) {
            synchronized (C7583s.class) {
                if (a == null) {
                    a = new C7583s(context);
                }
            }
        }
        return a;
    }

    public static void a(Context context, Cif cif) {
        a(context).a(cif, 0, true);
    }

    public static void a(Context context, Cif cif, boolean z) {
        a(context).a(cif, 1, z);
    }

    private void a(Cif cif, int i, boolean z) {
        if (C7688m.m1119a(this.f77a) || !C7688m.m1118a() || cif == null || cif.f617a != hj.SendMessage || cif.m1022a() == null || !z) {
            return;
        }
        AbstractC7535b.m586a("click to start activity result:" + String.valueOf(i));
        ii iiVar = new ii(cif.m1022a().m988a(), false);
        iiVar.c(ht.SDK_START_ACTIVITY.f497a);
        iiVar.b(cif.m1023a());
        iiVar.d(cif.f624b);
        HashMap hashMap = new HashMap();
        iiVar.f636a = hashMap;
        hashMap.put("result", String.valueOf(i));
        ao.a(this.f77a).a(iiVar, hj.Notification, false, false, null, true, cif.f624b, cif.f620a, true, false);
    }

    public static void b(Context context, Cif cif, boolean z) {
        a(context).a(cif, 2, z);
    }

    public static void c(Context context, Cif cif, boolean z) {
        a(context).a(cif, 3, z);
    }

    public static void d(Context context, Cif cif, boolean z) {
        a(context).a(cif, 4, z);
    }

    public static void e(Context context, Cif cif, boolean z) {
        C7583s a2;
        int i;
        C7564b m629a = C7564b.m629a(context);
        if (TextUtils.isEmpty(m629a.m637c()) || TextUtils.isEmpty(m629a.d())) {
            a2 = a(context);
            i = 6;
        } else {
            boolean m641f = m629a.m641f();
            a2 = a(context);
            i = m641f ? 7 : 5;
        }
        a2.a(cif, i, z);
    }
}
