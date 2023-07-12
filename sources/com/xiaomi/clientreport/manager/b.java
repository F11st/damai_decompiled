package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b implements Runnable {
    final /* synthetic */ EventClientReport a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ a f17a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, EventClientReport eventClientReport) {
        this.f17a = aVar;
        this.a = eventClientReport;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17a.b(this.a);
    }
}
