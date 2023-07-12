package com.vivo.push;

import com.vivo.push.b.C7414b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.h */
/* loaded from: classes11.dex */
public final class RunnableC7487h implements Runnable {
    final /* synthetic */ C7414b a;
    final /* synthetic */ String b;
    final /* synthetic */ C7481e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7487h(C7481e c7481e, C7414b c7414b, String str) {
        this.c = c7481e;
        this.a = c7414b;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a);
        this.c.e(this.b);
    }
}
