package com.uc.webview.export.internal.setup;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class q implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ UCMRunningInfo b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, l lVar, UCMRunningInfo uCMRunningInfo) {
        this.c = pVar;
        this.a = lVar;
        this.b = uCMRunningInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o.b(this.c.a, this.b);
    }
}
