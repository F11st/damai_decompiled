package com.xiaomi.clientreport.manager;

import com.xiaomi.push.al;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d extends al.a {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public void run() {
        int a;
        ExecutorService executorService;
        a = this.a.a();
        if (a > 0) {
            executorService = this.a.f16a;
            executorService.execute(new e(this));
        }
    }
}
