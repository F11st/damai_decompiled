package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.c */
/* loaded from: classes11.dex */
final class C7272c implements ValueCallback<AbstractC7282l> {
    final ValueCallback<AbstractC7282l> a;
    final /* synthetic */ C7268b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7272c(C7268b c7268b) {
        this.b = c7268b;
        this.a = c7268b.getCallback(UCCore.LEGACY_EVENT_SETUP);
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        Log.d("DecompressSetupTask", "setup callback.");
        ValueCallback<AbstractC7282l> valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(abstractC7282l2);
        } else if (C7349p.a(UCSetupTask.getTotalLoadedUCM())) {
        } else {
            abstractC7282l2.stop();
        }
    }
}
