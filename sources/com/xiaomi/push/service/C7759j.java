package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7688m;
import com.xiaomi.push.fl;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.bg;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.j */
/* loaded from: classes11.dex */
public class C7759j {
    private C7782y a = new C7782y();

    public static String a(bg.C7737b c7737b) {
        StringBuilder sb;
        String str;
        if ("9".equals(c7737b.g)) {
            sb = new StringBuilder();
            sb.append(c7737b.f925a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(c7737b.f925a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, bg.C7737b c7737b) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(c7737b));
        }
    }

    bg.C7737b a(fl flVar) {
        Collection<bg.C7737b> m1195a = bg.a().m1195a(Integer.toString(flVar.a()));
        if (m1195a.isEmpty()) {
            return null;
        }
        Iterator<bg.C7737b> it = m1195a.iterator();
        if (m1195a.size() == 1) {
            return it.next();
        }
        String g = flVar.g();
        while (it.hasNext()) {
            bg.C7737b next = it.next();
            if (TextUtils.equals(g, next.f928b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.xiaomi.push.service.bg.C7737b a(com.xiaomi.push.gn r6) {
        /*
            r5 = this;
            com.xiaomi.push.service.bg r0 = com.xiaomi.push.service.bg.a()
            java.lang.String r1 = r6.k()
            java.util.Collection r0 = r0.m1195a(r1)
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L14
            return r2
        L14:
            java.util.Iterator r1 = r0.iterator()
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L26
            java.lang.Object r6 = r1.next()
            com.xiaomi.push.service.bg$b r6 = (com.xiaomi.push.service.bg.C7737b) r6
            return r6
        L26:
            java.lang.String r0 = r6.m()
            java.lang.String r6 = r6.l()
        L2e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L4b
            java.lang.Object r3 = r1.next()
            com.xiaomi.push.service.bg$b r3 = (com.xiaomi.push.service.bg.C7737b) r3
            java.lang.String r4 = r3.f928b
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 != 0) goto L4a
            java.lang.String r4 = r3.f928b
            boolean r4 = android.text.TextUtils.equals(r6, r4)
            if (r4 == 0) goto L2e
        L4a:
            return r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C7759j.a(com.xiaomi.push.gn):com.xiaomi.push.service.bg$b");
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (C7688m.m1123c()) {
            intent.addFlags(16777216);
        }
        AbstractC7535b.m586a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.C7737b c7737b, int i) {
        if ("5".equalsIgnoreCase(c7737b.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(c7737b.f925a);
        intent.putExtra(bk.t, c7737b.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(bk.q, c7737b.f928b);
        intent.putExtra(bk.F, c7737b.i);
        if (c7737b.f919a == null || !"9".equals(c7737b.g)) {
            AbstractC7535b.m586a(String.format("[Bcst] notify channel closed. %s,%s,%d", c7737b.g, c7737b.f925a, Integer.valueOf(i)));
            a(context, intent, c7737b);
            return;
        }
        try {
            c7737b.f919a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            c7737b.f919a = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = c7737b.f928b;
            sb.append(str.substring(str.lastIndexOf(64)));
            AbstractC7535b.m586a(sb.toString());
        }
    }

    public void a(Context context, bg.C7737b c7737b, String str, String str2) {
        if (c7737b == null) {
            AbstractC7535b.d("error while notify kick by server!");
        } else if ("5".equalsIgnoreCase(c7737b.g)) {
            AbstractC7535b.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(c7737b.f925a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", c7737b.g);
            intent.putExtra(bk.q, c7737b.f928b);
            intent.putExtra(bk.F, c7737b.i);
            AbstractC7535b.m586a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", c7737b.g, c7737b.f925a, str2));
            a(context, intent, c7737b);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.C7737b c7737b, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(c7737b.g)) {
            this.a.a(context, c7737b, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(c7737b.f925a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", c7737b.g);
        intent.putExtra(bk.q, c7737b.f928b);
        intent.putExtra(bk.F, c7737b.i);
        AbstractC7535b.m586a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", c7737b.g, c7737b.f925a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, c7737b);
    }

    public void a(XMPushService xMPushService, String str, fl flVar) {
        ao aoVar;
        bg.C7737b a = a(flVar);
        if (a == null) {
            AbstractC7535b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, flVar, a);
        } else {
            String str2 = a.f925a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", flVar.m893a(a.h));
            intent.putExtra(bk.F, a.i);
            intent.putExtra(bk.x, a.h);
            if (a.f919a != null) {
                try {
                    a.f919a.send(Message.obtain(null, 17, intent));
                    AbstractC7535b.m586a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a.f919a = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("peer may died: ");
                    String str3 = a.f928b;
                    sb.append(str3.substring(str3.lastIndexOf(64)));
                    AbstractC7535b.m586a(sb.toString());
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            AbstractC7535b.m586a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a.g, a.f925a, flVar.e()));
            a(xMPushService, intent, a);
            if (!"10".equals(str) || (aoVar = flVar.f364a) == null) {
                return;
            }
            aoVar.d = System.currentTimeMillis();
            if (hi.a(xMPushService, 1)) {
                bz.a("category_coord_down", "coord_down", "com.xiaomi.xmsf", flVar.f364a);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, gn gnVar) {
        String str2;
        String str3;
        bg.C7737b a = a(gnVar);
        if (a != null) {
            if ("5".equalsIgnoreCase(str)) {
                this.a.a(xMPushService, gnVar, a);
                return;
            }
            String str4 = a.f925a;
            if (gnVar instanceof gm) {
                str3 = "com.xiaomi.push.new_msg";
            } else if (gnVar instanceof gl) {
                str3 = "com.xiaomi.push.new_iq";
            } else if (gnVar instanceof gp) {
                str3 = "com.xiaomi.push.new_pres";
            } else {
                str2 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str3);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", gnVar.a());
            intent.putExtra(bk.F, a.i);
            intent.putExtra(bk.x, a.h);
            AbstractC7535b.m586a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a.g, a.f925a, gnVar.j()));
            a(xMPushService, intent, a);
            return;
        }
        str2 = "error while notify channel closed! channel " + str + " not registered";
        AbstractC7535b.d(str2);
    }
}
