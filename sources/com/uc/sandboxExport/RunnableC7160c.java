package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.c */
/* loaded from: classes11.dex */
public final class RunnableC7160c implements Runnable {
    final /* synthetic */ PreStartup.ServiceConnectionC7154a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7160c(PreStartup.ServiceConnectionC7154a serviceConnectionC7154a) {
        this.a = serviceConnectionC7154a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
