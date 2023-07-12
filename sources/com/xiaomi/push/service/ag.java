package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.Cif;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ag {
    private static InterfaceC7722a a;

    /* renamed from: a  reason: collision with other field name */
    private static InterfaceC7723b f878a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.ag$a */
    /* loaded from: classes11.dex */
    public interface InterfaceC7722a {
        Map<String, String> a(Context context, Cif cif);

        /* renamed from: a  reason: collision with other method in class */
        void m1160a(Context context, Cif cif);

        boolean a(Context context, Cif cif, boolean z);
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.ag$b */
    /* loaded from: classes11.dex */
    public interface InterfaceC7723b {
        void a(Cif cif);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m1161a(Cif cif);
    }

    public static Map<String, String> a(Context context, Cif cif) {
        InterfaceC7722a interfaceC7722a = a;
        if (interfaceC7722a == null || cif == null) {
            AbstractC7535b.m586a("pepa listener or container is null");
            return null;
        }
        return interfaceC7722a.a(context, cif);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m1158a(Context context, Cif cif) {
        InterfaceC7722a interfaceC7722a = a;
        if (interfaceC7722a == null || cif == null) {
            AbstractC7535b.m586a("handle msg wrong");
        } else {
            interfaceC7722a.m1160a(context, cif);
        }
    }

    public static void a(Cif cif) {
        InterfaceC7723b interfaceC7723b = f878a;
        if (interfaceC7723b == null || cif == null) {
            AbstractC7535b.m586a("pepa clearMessage is null");
        } else {
            interfaceC7723b.a(cif);
        }
    }

    public static void a(String str) {
        InterfaceC7723b interfaceC7723b = f878a;
        if (interfaceC7723b == null || str == null) {
            AbstractC7535b.m586a("pepa clearMessage is null");
        } else {
            interfaceC7723b.a(str);
        }
    }

    public static boolean a(Context context, Cif cif, boolean z) {
        InterfaceC7722a interfaceC7722a = a;
        if (interfaceC7722a == null || cif == null) {
            AbstractC7535b.m586a("pepa judement listener or container is null");
            return false;
        }
        return interfaceC7722a.a(context, cif, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m1159a(Cif cif) {
        InterfaceC7723b interfaceC7723b = f878a;
        if (interfaceC7723b == null || cif == null) {
            AbstractC7535b.m586a("pepa handleReceiveMessage is null");
            return false;
        }
        return interfaceC7723b.m1161a(cif);
    }
}
