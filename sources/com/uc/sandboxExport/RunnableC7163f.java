package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.f */
/* loaded from: classes11.dex */
final class RunnableC7163f implements Runnable {
    final /* synthetic */ PreStartup.ServiceConnectionC7154a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7163f(PreStartup.ServiceConnectionC7154a serviceConnectionC7154a) {
        this.a = serviceConnectionC7154a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.ServiceConnectionC7154a.c(this.a);
    }
}
