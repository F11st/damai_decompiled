package com.uc.sandboxExport;

import com.uc.sandboxExport.PreStartup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ PreStartup.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PreStartup.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.a.a(this.a);
    }
}
