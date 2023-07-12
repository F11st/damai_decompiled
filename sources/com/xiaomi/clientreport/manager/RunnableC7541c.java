package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.manager.c */
/* loaded from: classes11.dex */
public class RunnableC7541c implements Runnable {
    final /* synthetic */ PerfClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ C7539a f18a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7541c(C7539a c7539a, PerfClientReport perfClientReport) {
        this.f18a = c7539a;
        this.a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18a.b(this.a);
    }
}
