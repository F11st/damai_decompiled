package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Hashtable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fj {
    private static final int a = ez.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    private static long f360a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a() {
        if (f360a == 0 || SystemClock.elapsedRealtime() - f360a > 7200000) {
            f360a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i) {
        fa m883a = fh.m881a().m883a();
        m883a.a(ez.CHANNEL_STATS_COUNTER.a());
        m883a.c(i);
        fh.m881a().a(m883a);
    }

    public static synchronized void a(int i, int i2) {
        synchronized (fj.class) {
            if (i2 < 16777215) {
                a.a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
            }
        }
    }

    public static void a(int i, int i2, int i3, String str, int i4) {
        fa m883a = fh.m881a().m883a();
        m883a.a((byte) i);
        m883a.a(i2);
        m883a.b(i3);
        m883a.b(str);
        m883a.c(i4);
        fh.m881a().a(m883a);
    }

    public static synchronized void a(int i, int i2, String str, int i3) {
        synchronized (fj.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.a.containsKey(Integer.valueOf(i4))) {
                fa m883a = fh.m881a().m883a();
                m883a.a(i2);
                m883a.b((int) (currentTimeMillis - a.a.get(Integer.valueOf(i4)).longValue()));
                m883a.b(str);
                if (i3 > -1) {
                    m883a.c(i3);
                }
                fh.m881a().a(m883a);
                a.a.remove(Integer.valueOf(i2));
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
            }
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        new fc(xMPushService, bVar).a();
    }

    public static void a(String str, int i, Exception exc) {
        fa m883a = fh.m881a().m883a();
        if (fh.a() != null && fh.a().f352a != null) {
            m883a.c(bj.c(fh.a().f352a) ? 1 : 0);
        }
        if (i > 0) {
            m883a.a(ez.GSLB_REQUEST_SUCCESS.a());
            m883a.b(str);
            m883a.b(i);
            fh.m881a().a(m883a);
            return;
        }
        try {
            ff.a a2 = ff.a(exc);
            m883a.a(a2.a.a());
            m883a.c(a2.f349a);
            m883a.b(str);
            fh.m881a().a(m883a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, Exception exc) {
        try {
            ff.a b = ff.b(exc);
            fa m883a = fh.m881a().m883a();
            m883a.a(b.a.a());
            m883a.c(b.f349a);
            m883a.b(str);
            if (fh.a() != null && fh.a().f352a != null) {
                m883a.c(bj.c(fh.a().f352a) ? 1 : 0);
            }
            fh.m881a().a(m883a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m887a() {
        fb m884a = fh.m881a().m884a();
        if (m884a != null) {
            return it.a(m884a);
        }
        return null;
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void b(String str, Exception exc) {
        try {
            ff.a d = ff.d(exc);
            fa m883a = fh.m881a().m883a();
            m883a.a(d.a.a());
            m883a.c(d.f349a);
            m883a.b(str);
            if (fh.a() != null && fh.a().f352a != null) {
                m883a.c(bj.c(fh.a().f352a) ? 1 : 0);
            }
            fh.m881a().a(m883a);
        } catch (NullPointerException unused) {
        }
    }
}
