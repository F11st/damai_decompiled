package com.uc.webview.export.internal.setup;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.q */
/* loaded from: classes11.dex */
final class RunnableC7287q implements Runnable {
    final /* synthetic */ AbstractC7282l a;
    final /* synthetic */ UCMRunningInfo b;
    final /* synthetic */ C7286p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7287q(C7286p c7286p, AbstractC7282l abstractC7282l, UCMRunningInfo uCMRunningInfo) {
        this.c = c7286p;
        this.a = abstractC7282l;
        this.b = uCMRunningInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C7285o.b(this.c.a, this.b);
    }
}
