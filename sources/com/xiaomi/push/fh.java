package com.xiaomi.push;

import android.content.Context;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.bl;
import com.xiaomi.push.jl;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fh {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f355a;

    /* renamed from: a  reason: collision with other field name */
    private fg f357a;

    /* renamed from: a  reason: collision with other field name */
    private String f358a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f359a = false;

    /* renamed from: a  reason: collision with other field name */
    private bl f356a = bl.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.fh$a */
    /* loaded from: classes11.dex */
    public static class C7653a {
        static final fh a = new fh();
    }

    private fa a(bl.C7612a c7612a) {
        if (c7612a.f134a == 0) {
            Object obj = c7612a.f135a;
            if (obj instanceof fa) {
                return (fa) obj;
            }
            return null;
        }
        fa m883a = m883a();
        m883a.a(ez.CHANNEL_STATS_COUNTER.a());
        m883a.c(c7612a.f134a);
        m883a.c(c7612a.f136a);
        return m883a;
    }

    private fb a(int i) {
        ArrayList arrayList = new ArrayList();
        fb fbVar = new fb(this.f358a, arrayList);
        if (!bj.e(this.f357a.f352a)) {
            fbVar.a(C7680j.k(this.f357a.f352a));
        }
        jn jnVar = new jn(i);
        jf a = new jl.C7682a().a(jnVar);
        try {
            fbVar.b(a);
        } catch (iz unused) {
        }
        LinkedList<bl.C7612a> m700a = this.f356a.m700a();
        while (m700a.size() > 0) {
            try {
                fa a2 = a(m700a.getLast());
                if (a2 != null) {
                    a2.b(a);
                }
                if (jnVar.a_() > i) {
                    break;
                }
                if (a2 != null) {
                    arrayList.add(a2);
                }
                m700a.removeLast();
            } catch (iz | NoSuchElementException unused2) {
            }
        }
        return fbVar;
    }

    public static fg a() {
        fg fgVar;
        fh fhVar = C7653a.a;
        synchronized (fhVar) {
            fgVar = fhVar.f357a;
        }
        return fgVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static fh m881a() {
        return C7653a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m882a() {
        if (!this.f359a || System.currentTimeMillis() - this.f355a <= this.a) {
            return;
        }
        this.f359a = false;
        this.f355a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fa m883a() {
        fa faVar;
        faVar = new fa();
        faVar.a(bj.m693a((Context) this.f357a.f352a));
        faVar.f329a = (byte) 0;
        faVar.f333b = 1;
        faVar.d((int) (System.currentTimeMillis() / 1000));
        return faVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public synchronized fb m884a() {
        fb fbVar;
        fbVar = null;
        if (b()) {
            int i = FeatureFactory.PRIORITY_ABOVE_NORMAL;
            if (!bj.e(this.f357a.f352a)) {
                i = 375;
            }
            fbVar = a(i);
        }
        return fbVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m885a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.a == i2 && this.f359a) {
                return;
            }
            this.f359a = true;
            this.f355a = System.currentTimeMillis();
            this.a = i2;
            AbstractC7535b.c("enable dot duration = " + i2 + " start = " + this.f355a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(fa faVar) {
        this.f356a.a(faVar);
    }

    public synchronized void a(XMPushService xMPushService) {
        this.f357a = new fg(xMPushService);
        this.f358a = "";
        com.xiaomi.push.service.bv.a().a(new fi(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m886a() {
        return this.f359a;
    }

    boolean b() {
        m882a();
        return this.f359a && this.f356a.m699a() > 0;
    }
}
