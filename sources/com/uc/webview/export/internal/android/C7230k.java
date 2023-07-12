package com.uc.webview.export.internal.android;

import android.net.Uri;
import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.k */
/* loaded from: classes11.dex */
public final class C7230k implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ C7225i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7230k(C7225i c7225i, ValueCallback valueCallback) {
        this.b = c7225i;
        this.a = valueCallback;
    }

    @Override // android.webkit.ValueCallback
    public final /* bridge */ /* synthetic */ void onReceiveValue(Uri[] uriArr) {
        Uri[] uriArr2 = uriArr;
        this.a.onReceiveValue(uriArr2 == null ? null : uriArr2[0]);
    }
}
