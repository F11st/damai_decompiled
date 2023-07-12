package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class bz implements ValueCallback<l> {
    final /* synthetic */ by a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar) {
        this.a = byVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        String str;
        l lVar2 = lVar;
        str = by.a;
        Log.d(str, "setup callback.");
        if (com.uc.webview.export.internal.utility.p.a(UCSetupTask.getTotalLoadedUCM())) {
            return;
        }
        lVar2.stop();
    }
}
