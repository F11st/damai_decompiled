package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.b */
/* loaded from: classes11.dex */
public final class RunnableC7159b implements Runnable {
    final /* synthetic */ PreStartup.ServiceConnectionC7154a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7159b(PreStartup.ServiceConnectionC7154a serviceConnectionC7154a) {
        this.a = serviceConnectionC7154a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.ServiceConnectionC7154a.a(this.a);
    }
}
