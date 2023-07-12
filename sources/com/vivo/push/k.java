package com.vivo.push;

import com.vivo.push.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a d;
        d = this.b.d(this.a);
        if (d != null) {
            d.a(1003, new Object[0]);
        }
    }
}
