package com.xiaomi.clientreport.manager;

import com.xiaomi.push.al;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f extends al.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.al.a
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
            executorService.execute(new g(this));
        }
    }
}
