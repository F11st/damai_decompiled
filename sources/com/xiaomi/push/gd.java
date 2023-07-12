package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.C7764o;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class gd extends fw {
    protected Exception a;

    /* renamed from: a  reason: collision with other field name */
    protected Socket f415a;
    protected XMPushService b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    String f416c;
    private String d;
    protected volatile long e;
    protected volatile long f;
    protected volatile long g;
    private long h;

    public gd(XMPushService xMPushService, fx fxVar) {
        super(xMPushService, fxVar);
        this.a = null;
        this.f416c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    private void a(fx fxVar) {
        a(fxVar.c(), fxVar.m916a());
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r32, int r33) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.gd.a(java.lang.String, int):void");
    }

    cr a(String str) {
        cr a = cv.a().a(str, false);
        if (!a.b()) {
            gz.a(new gg(this, str));
        }
        return a;
    }

    @Override // com.xiaomi.push.fw
    /* renamed from: a */
    public String mo910a() {
        return this.d;
    }

    public Socket a() {
        return new Socket();
    }

    /* renamed from: a  reason: collision with other method in class */
    protected synchronized void mo921a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(int i, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i, exc);
        ((fw) this).f401a = "";
        try {
            this.f415a.close();
        } catch (Throwable unused) {
        }
        this.e = 0L;
        this.f = 0L;
    }

    protected void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < 300000) {
            if (!bj.b(this.b)) {
                return;
            }
            int i = this.c + 1;
            this.c = i;
            if (i < 2) {
                return;
            }
            String mo910a = mo910a();
            AbstractC7535b.m586a("max short conn time reached, sink down current host:" + mo910a);
            a(mo910a, 0L, exc);
        }
        this.c = 0;
    }

    protected void a(String str, long j, Exception exc) {
        cr a = cv.a().a(fx.a(), false);
        if (a != null) {
            a.b(str, j, 0L, exc);
            cv.a().m758c();
        }
    }

    /* renamed from: a */
    protected abstract void mo901a(boolean z);

    @Override // com.xiaomi.push.fw
    public void a(fl[] flVarArr) {
        throw new gh("Don't support send Blob");
    }

    @Override // com.xiaomi.push.fw
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fw
    public void b(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        mo901a(z);
        C7764o.a(this.b).m1225c();
        if (z) {
            return;
        }
        this.b.a(new ge(this, 13, elapsedRealtime, currentTimeMillis), 10000L);
    }

    public String c() {
        return ((fw) this).f401a;
    }

    public void c(int i, Exception exc) {
        this.b.a(new gf(this, 2, i, exc));
    }

    public synchronized void e() {
        try {
            if (!m915c() && !m914b()) {
                a(0, 0, (Exception) null);
                a(((fw) this).f398a);
                return;
            }
            AbstractC7535b.m586a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new gh(e);
        }
    }

    public void f() {
        this.e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }
}
