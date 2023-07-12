package com.xiaomi.push.service;

import com.xiaomi.push.ii;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i {
    private static a a;

    /* renamed from: a  reason: collision with other field name */
    private static b f972a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface a {
        boolean a(ii iiVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface b {
    }

    public static void a(b bVar) {
        f972a = bVar;
    }

    public static boolean a(ii iiVar) {
        String str;
        if (a == null || iiVar == null) {
            str = "rc params is null, not cpra";
        } else if (com.xiaomi.push.m.m1119a(com.xiaomi.push.v.m1245a())) {
            return a.a(iiVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.m586a(str);
        return false;
    }
}
