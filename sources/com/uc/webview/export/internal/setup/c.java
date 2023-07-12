package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class c implements ValueCallback<l> {
    final ValueCallback<l> a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.b = bVar;
        this.a = bVar.getCallback(UCCore.LEGACY_EVENT_SETUP);
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d("DecompressSetupTask", "setup callback.");
        ValueCallback<l> valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(lVar2);
        } else if (com.uc.webview.export.internal.utility.p.a(UCSetupTask.getTotalLoadedUCM())) {
        } else {
            lVar2.stop();
        }
    }
}
