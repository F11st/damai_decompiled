package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ag {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static b f878a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        Map<String, String> a(Context context, Cif cif);

        /* renamed from: a  reason: collision with other method in class */
        void m1160a(Context context, Cif cif);

        boolean a(Context context, Cif cif, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface b {
        void a(Cif cif);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m1161a(Cif cif);
    }

    public static Map<String, String> a(Context context, Cif cif) {
        a aVar = a;
        if (aVar == null || cif == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("pepa listener or container is null");
            return null;
        }
        return aVar.a(context, cif);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m1158a(Context context, Cif cif) {
        a aVar = a;
        if (aVar == null || cif == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("handle msg wrong");
        } else {
            aVar.m1160a(context, cif);
        }
    }

    public static void a(Cif cif) {
        b bVar = f878a;
        if (bVar == null || cif == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("pepa clearMessage is null");
        } else {
            bVar.a(cif);
        }
    }

    public static void a(String str) {
        b bVar = f878a;
        if (bVar == null || str == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, Cif cif, boolean z) {
        a aVar = a;
        if (aVar == null || cif == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("pepa judement listener or container is null");
            return false;
        }
        return aVar.a(context, cif, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1159a(Cif cif) {
        b bVar = f878a;
        if (bVar == null || cif == null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("pepa handleReceiveMessage is null");
            return false;
        }
        return bVar.m1161a(cif);
    }
}
