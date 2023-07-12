package com.xiaomi.clientreport.manager;

import com.xiaomi.push.br;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.manager.i */
/* loaded from: classes11.dex */
public class RunnableC7547i implements Runnable {
    final /* synthetic */ C7539a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ br f20a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7547i(C7539a c7539a, br brVar) {
        this.a = c7539a;
        this.f20a = brVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20a.run();
    }
}
