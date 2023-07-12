package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class bz implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ by a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar) {
        this.a = byVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        String str;
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        str = by.a;
        Log.d(str, "setup callback.");
        if (C7349p.a(UCSetupTask.getTotalLoadedUCM())) {
            return;
        }
        abstractC7282l2.stop();
    }
}
