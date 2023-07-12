package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.d */
/* loaded from: classes11.dex */
final class C7273d implements ValueCallback<AbstractC7282l> {
    final ValueCallback a;
    final /* synthetic */ C7268b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7273d(C7268b c7268b) {
        this.b = c7268b;
        this.a = c7268b.getCallback("switch");
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        Log.d("DecompressSetupTask", "switch callback.");
        ValueCallback valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(abstractC7282l2);
        }
    }
}
