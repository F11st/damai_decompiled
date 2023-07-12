package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.manager.b */
/* loaded from: classes11.dex */
public class RunnableC7540b implements Runnable {
    final /* synthetic */ EventClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ C7539a f17a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7540b(C7539a c7539a, EventClientReport eventClientReport) {
        this.f17a = c7539a;
        this.a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17a.b(this.a);
    }
}
