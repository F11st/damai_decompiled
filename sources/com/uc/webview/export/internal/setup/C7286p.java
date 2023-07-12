package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.p */
/* loaded from: classes11.dex */
public final class C7286p implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7286p(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        if (abstractC7282l2.getLoadedUCM() == null) {
            this.a.setException(new UCSetupException(4001, String.format("Task [%s] report success but no loaded UCM.", abstractC7282l2.getClass().getName())));
            return;
        }
        UCMRunningInfo loadedUCM = abstractC7282l2.getLoadedUCM();
        C7285o.a(this.a, loadedUCM);
        try {
            new UCAsyncTask(new RunnableC7287q(this, abstractC7282l2, loadedUCM)).setParent(UCSetupTask.getRoot()).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        af.a(af.EnumC7264a.INIT_FINISHED, new Object[0]);
    }
}
