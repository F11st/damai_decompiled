package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.ii;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.i */
/* loaded from: classes11.dex */
public class C7756i {
    private static InterfaceC7757a a;

    /* renamed from: a  reason: collision with other field name */
    private static InterfaceC7758b f972a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.i$a */
    /* loaded from: classes11.dex */
    public interface InterfaceC7757a {
        boolean a(ii iiVar);
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.i$b */
    /* loaded from: classes11.dex */
    public interface InterfaceC7758b {
    }

    public static void a(InterfaceC7758b interfaceC7758b) {
        f972a = interfaceC7758b;
    }

    public static boolean a(ii iiVar) {
        String str;
        if (a == null || iiVar == null) {
            str = "rc params is null, not cpra";
        } else if (C7688m.m1119a(C7786v.m1245a())) {
            return a.a(iiVar);
        } else {
            str = "rc app not permission to cpra";
        }
        AbstractC7535b.m586a(str);
        return false;
    }
}
