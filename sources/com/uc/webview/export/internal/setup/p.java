package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class p implements ValueCallback<l> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        if (lVar2.getLoadedUCM() == null) {
            this.a.setException(new UCSetupException(4001, String.format("Task [%s] report success but no loaded UCM.", lVar2.getClass().getName())));
            return;
        }
        UCMRunningInfo loadedUCM = lVar2.getLoadedUCM();
        o.a(this.a, loadedUCM);
        try {
            new UCAsyncTask(new q(this, lVar2, loadedUCM)).setParent(UCSetupTask.getRoot()).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        af.a(af.a.INIT_FINISHED, new Object[0]);
    }
}
