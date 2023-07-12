package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class ca implements ValueCallback<l> {
    final ValueCallback a;
    final /* synthetic */ by b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(by byVar) {
        this.b = byVar;
        this.a = byVar.getCallback("switch");
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        String str;
        l lVar2 = lVar;
        str = by.a;
        Log.d(str, "switch callback.");
        ValueCallback valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(lVar2);
        }
    }
}
