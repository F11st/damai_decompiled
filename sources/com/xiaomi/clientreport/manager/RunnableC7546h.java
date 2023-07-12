package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bq;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.manager.h */
/* loaded from: classes11.dex */
public class RunnableC7546h implements Runnable {
    final /* synthetic */ C7539a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bq f19a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7546h(C7539a c7539a, bq bqVar) {
        this.a = c7539a;
        this.f19a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19a.run();
    }
}
