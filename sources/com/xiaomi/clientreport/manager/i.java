package com.xiaomi.clientreport.manager;

import com.xiaomi.push.br;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ br f20a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, br brVar) {
        this.a = aVar;
        this.f20a = brVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20a.run();
    }
}
