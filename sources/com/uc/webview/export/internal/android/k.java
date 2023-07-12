package com.uc.webview.export.internal.android;

import android.net.Uri;
import android.webkit.ValueCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class k implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ValueCallback valueCallback) {
        this.b = iVar;
        this.a = valueCallback;
    }

    @Override // android.webkit.ValueCallback
    public final /* bridge */ /* synthetic */ void onReceiveValue(Uri[] uriArr) {
        Uri[] uriArr2 = uriArr;
        this.a.onReceiveValue(uriArr2 == null ? null : uriArr2[0]);
    }
}
