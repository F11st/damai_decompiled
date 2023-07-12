package com.uc.webview.export.internal.android;

import com.uc.webview.export.JsResult;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.e */
/* loaded from: classes11.dex */
final class C7220e implements JsResult {
    private android.webkit.JsResult a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7220e(android.webkit.JsResult jsResult) {
        this.a = jsResult;
    }

    @Override // com.uc.webview.export.JsResult
    public final void cancel() {
        this.a.cancel();
    }

    @Override // com.uc.webview.export.JsResult
    public final void confirm() {
        this.a.confirm();
    }
}
