package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bw implements ValueCallback {
    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        SDKFactory.j = true;
        SDKFactory.k = true;
    }
}
