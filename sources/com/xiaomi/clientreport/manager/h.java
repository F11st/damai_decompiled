package com.xiaomi.clientreport.manager;

import com.xiaomi.push.bq;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h implements Runnable {
    final /* synthetic */ a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bq f19a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, bq bqVar) {
        this.a = aVar;
        this.f19a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19a.run();
    }
}
