package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class a implements Executor {
    final /* synthetic */ PreStartup.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PreStartup.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.c.post(runnable);
    }
}
