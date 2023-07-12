package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.dx;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fs extends gd {
    private fn a;

    /* renamed from: a  reason: collision with other field name */
    private fo f385a;

    /* renamed from: a  reason: collision with other field name */
    private Thread f386a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f387a;

    public fs(XMPushService xMPushService, fx fxVar) {
        super(xMPushService, fxVar);
    }

    private fl a(boolean z) {
        fr frVar = new fr();
        if (z) {
            frVar.a("1");
        }
        byte[] m887a = fj.m887a();
        if (m887a != null) {
            dx.C7644j c7644j = new dx.C7644j();
            c7644j.a(C7593a.a(m887a));
            frVar.a(c7644j.m852a(), (String) null);
        }
        return frVar;
    }

    private void h() {
        try {
            this.a = new fn(((gd) this).f415a.getInputStream(), this, ((fw) this).f400a);
            this.f385a = new fo(((gd) this).f415a.getOutputStream(), this);
            ft ftVar = new ft(this, "Blob Reader (" + ((fw) this).b + jn1.BRACKET_END_STR);
            this.f386a = ftVar;
            ftVar.start();
        } catch (Exception e) {
            throw new gh("Error to init reader and writer", e);
        }
    }

    @Override // com.xiaomi.push.gd
    /* renamed from: a */
    protected synchronized void mo921a() {
        h();
        this.f385a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.gd
    public synchronized void a(int i, Exception exc) {
        fn fnVar = this.a;
        if (fnVar != null) {
            fnVar.b();
            this.a = null;
        }
        fo foVar = this.f385a;
        if (foVar != null) {
            try {
                foVar.b();
            } catch (Exception e) {
                AbstractC7535b.a(e);
            }
            this.f385a = null;
        }
        this.f387a = null;
        super.a(i, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        if (flVar.m891a()) {
            AbstractC7535b.m586a("[Slim] RCV blob chid=" + flVar.a() + "; id=" + flVar.e() + "; errCode=" + flVar.b() + "; err=" + flVar.m895c());
        }
        if (flVar.a() == 0) {
            if ("PING".equals(flVar.m888a())) {
                AbstractC7535b.m586a("[Slim] RCV ping id=" + flVar.e());
                g();
            } else if (StandOutWindow.ACTION_CLOSE.equals(flVar.m888a())) {
                c(13, null);
            }
        }
        for (fw.C7660a c7660a : ((fw) this).f404a.values()) {
            c7660a.a(flVar);
        }
    }

    @Override // com.xiaomi.push.fw
    @Deprecated
    public void a(gn gnVar) {
        b(fl.a(gnVar, (String) null));
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a(bg.C7737b c7737b) {
        fk.a(c7737b, c(), this);
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a(String str, String str2) {
        fk.a(str, str2, this);
    }

    @Override // com.xiaomi.push.gd
    /* renamed from: a  reason: collision with other method in class */
    protected void mo901a(boolean z) {
        if (this.f385a == null) {
            throw new gh("The BlobWriter is null.");
        }
        fl a = a(z);
        AbstractC7535b.m586a("[Slim] SND ping id=" + a.e());
        b(a);
        f();
    }

    @Override // com.xiaomi.push.gd, com.xiaomi.push.fw
    public void a(fl[] flVarArr) {
        for (fl flVar : flVarArr) {
            b(flVar);
        }
    }

    @Override // com.xiaomi.push.fw
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo902a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized byte[] m903a() {
        if (this.f387a == null && !TextUtils.isEmpty(((fw) this).f401a)) {
            String m1206a = com.xiaomi.push.service.bv.m1206a();
            StringBuilder sb = new StringBuilder();
            String str = ((fw) this).f401a;
            sb.append(str.substring(str.length() / 2));
            sb.append(m1206a.substring(m1206a.length() / 2));
            this.f387a = com.xiaomi.push.service.bp.a(((fw) this).f401a.getBytes(), sb.toString().getBytes());
        }
        return this.f387a;
    }

    @Override // com.xiaomi.push.fw
    public void b(fl flVar) {
        fo foVar = this.f385a;
        if (foVar == null) {
            throw new gh("the writer is null.");
        }
        try {
            int a = foVar.a(flVar);
            ((fw) this).d = SystemClock.elapsedRealtime();
            String f = flVar.f();
            if (!TextUtils.isEmpty(f)) {
                hb.a(((fw) this).f400a, f, a, false, true, System.currentTimeMillis());
            }
            for (fw.C7660a c7660a : ((fw) this).f407b.values()) {
                c7660a.a(flVar);
            }
        } catch (Exception e) {
            throw new gh(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(gn gnVar) {
        if (gnVar == null) {
            return;
        }
        for (fw.C7660a c7660a : ((fw) this).f404a.values()) {
            c7660a.a(gnVar);
        }
    }
}
