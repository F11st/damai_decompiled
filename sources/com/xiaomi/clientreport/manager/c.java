package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c implements Runnable {
    final /* synthetic */ PerfClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f18a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, PerfClientReport perfClientReport) {
        this.f18a = aVar;
        this.a = perfClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f18a.b(this.a);
    }
}
