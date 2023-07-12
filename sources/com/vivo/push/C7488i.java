package com.vivo.push;

import com.vivo.push.util.C7509b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.i */
/* loaded from: classes11.dex */
public final class C7488i implements IPushActionListener {
    final /* synthetic */ C7481e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7488i(C7481e c7481e) {
        this.a = c7481e;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        C7509b c7509b;
        C7509b c7509b2;
        if (i == 0) {
            this.a.k = "";
            c7509b2 = this.a.j;
            c7509b2.a("APP_TOKEN", "");
            this.a.m();
            this.a.j.b("APP_TAGS");
            return;
        }
        this.a.k = null;
        c7509b = this.a.j;
        c7509b.b("APP_TOKEN");
    }
}
