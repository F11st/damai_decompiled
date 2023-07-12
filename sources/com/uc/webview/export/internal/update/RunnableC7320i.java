package com.uc.webview.export.internal.update;

import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.internal.update.C7312b;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.i */
/* loaded from: classes11.dex */
final class RunnableC7320i implements Runnable {
    final /* synthetic */ UpdateService a;
    final /* synthetic */ C7312b.C7313a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7320i(C7312b.C7313a c7313a, UpdateService updateService) {
        this.b = c7313a;
        this.a = updateService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            File extractDir = this.a.getExtractDir();
            if (extractDir != null) {
                UCCyclone.recursiveDelete(extractDir, true, null);
            }
        } catch (Throwable unused) {
        }
    }
}
