package com.vivo.push;

import com.vivo.push.C7481e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.k */
/* loaded from: classes11.dex */
public final class RunnableC7490k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ C7481e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7490k(C7481e c7481e, String str) {
        this.b = c7481e;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C7481e.C7482a d;
        d = this.b.d(this.a);
        if (d != null) {
            d.a(1003, new Object[0]);
        }
    }
}
