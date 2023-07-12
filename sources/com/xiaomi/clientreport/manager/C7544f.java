package com.xiaomi.clientreport.manager;

import com.xiaomi.push.al;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.manager.f */
/* loaded from: classes11.dex */
public class C7544f extends al.AbstractRunnableC7597a {
    final /* synthetic */ C7539a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7544f(C7539a c7539a) {
        this.a = c7539a;
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public void run() {
        int b;
        ExecutorService executorService;
        b = this.a.b();
        if (b > 0) {
            executorService = this.a.f16a;
            executorService.execute(new RunnableC7545g(this));
        }
    }
}
