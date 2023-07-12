package com.uc.webview.export.internal.android;

import com.uc.webview.export.JsPromptResult;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.d */
/* loaded from: classes11.dex */
final class C7219d implements JsPromptResult {
    private android.webkit.JsPromptResult a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7219d(android.webkit.JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    @Override // com.uc.webview.export.JsPromptResult, com.uc.webview.export.JsResult
    public final void cancel() {
        this.a.cancel();
    }

    @Override // com.uc.webview.export.JsPromptResult, com.uc.webview.export.JsResult
    public final void confirm() {
        this.a.confirm();
    }

    @Override // com.uc.webview.export.JsPromptResult
    public final void confirm(String str) {
        this.a.confirm(str);
    }
}
