package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fg implements fz {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    fw f351a;

    /* renamed from: a  reason: collision with other field name */
    XMPushService f352a;

    /* renamed from: a  reason: collision with other field name */
    private Exception f353a;
    private long e;
    private long f;

    /* renamed from: a  reason: collision with other field name */
    private long f350a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a  reason: collision with other field name */
    private String f354a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(XMPushService xMPushService) {
        this.e = 0L;
        this.f = 0L;
        this.f352a = xMPushService;
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f350a = 0L;
        this.c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (bj.b(this.f352a)) {
            this.f350a = elapsedRealtime;
        }
        if (this.f352a.m1155c()) {
            this.c = elapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f354a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        fa faVar = new fa();
        faVar.f329a = (byte) 0;
        faVar.a(ez.CHANNEL_ONLINE_RATE.a());
        faVar.a(this.f354a);
        faVar.d((int) (System.currentTimeMillis() / 1000));
        faVar.b((int) (this.b / 1000));
        faVar.c((int) (this.d / 1000));
        fh.m881a().a(faVar);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f353a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m880a() {
        XMPushService xMPushService = this.f352a;
        if (xMPushService == null) {
            return;
        }
        String m693a = bj.m693a((Context) xMPushService);
        boolean c = bj.c(this.f352a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f350a;
        if (j > 0) {
            this.b += elapsedRealtime - j;
            this.f350a = 0L;
        }
        long j2 = this.c;
        if (j2 != 0) {
            this.d += elapsedRealtime - j2;
            this.c = 0L;
        }
        if (c) {
            if ((!TextUtils.equals(this.f354a, m693a) && this.b > 30000) || this.b > 5400000) {
                c();
            }
            this.f354a = m693a;
            if (this.f350a == 0) {
                this.f350a = elapsedRealtime;
            }
            if (this.f352a.m1155c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        this.a = 0;
        this.f353a = null;
        this.f351a = fwVar;
        this.f354a = bj.m693a((Context) this.f352a);
        fj.a(0, ez.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        long j;
        if (this.a == 0 && this.f353a == null) {
            this.a = i;
            this.f353a = exc;
            fj.b(fwVar.mo910a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long m908a = fwVar.m908a() - this.c;
            if (m908a < 0) {
                m908a = 0;
            }
            this.d += m908a + (gc.b() / 2);
            this.c = 0L;
        }
        m880a();
        int myUid = Process.myUid();
        long j2 = -1;
        try {
            j2 = TrafficStats.getUidRxBytes(myUid);
            j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("Failed to obtain traffic data: " + e);
            j = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
        this.f = j2;
        this.e = j;
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        fj.a(0, ez.CHANNEL_CON_FAIL.a(), 1, fwVar.mo910a(), bj.c(this.f352a) ? 1 : 0);
        m880a();
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        m880a();
        this.c = SystemClock.elapsedRealtime();
        fj.a(0, ez.CONN_SUCCESS.a(), fwVar.mo910a(), fwVar.a());
    }
}
