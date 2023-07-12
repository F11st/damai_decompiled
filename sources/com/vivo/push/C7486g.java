package com.vivo.push;

import com.vivo.push.C7481e;
import com.vivo.push.util.C7509b;
import com.vivo.push.util.C7523p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.g */
/* loaded from: classes11.dex */
public final class C7486g implements IPushActionListener {
    final /* synthetic */ C7481e.C7482a a;
    final /* synthetic */ C7481e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7486g(C7481e c7481e, C7481e.C7482a c7482a) {
        this.b = c7481e;
        this.a = c7482a;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        C7509b c7509b;
        if (i == 0) {
            Object[] b = this.a.b();
            if (b != null && b.length != 0) {
                this.b.a((String) this.a.b()[0]);
                return;
            } else {
                C7523p.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        this.b.k = null;
        c7509b = this.b.j;
        c7509b.b("APP_TOKEN");
    }
}
