package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.a */
/* loaded from: classes11.dex */
final class ExecutorC7158a implements Executor {
    final /* synthetic */ PreStartup.ServiceConnectionC7154a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorC7158a(PreStartup.ServiceConnectionC7154a serviceConnectionC7154a) {
        this.a = serviceConnectionC7154a;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.c.post(runnable);
    }
}
