package com.uc.webview.export.internal.android;

import com.uc.webview.export.extension.RenderProcessGoneDetail;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.u */
/* loaded from: classes11.dex */
final class C7242u extends RenderProcessGoneDetail {
    final /* synthetic */ android.webkit.RenderProcessGoneDetail a;
    final /* synthetic */ C7240t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7242u(C7240t c7240t, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
        this.b = c7240t;
        this.a = renderProcessGoneDetail;
    }

    @Override // com.uc.webview.export.extension.RenderProcessGoneDetail
    public final boolean didCrash() {
        return this.a.didCrash();
    }

    @Override // com.uc.webview.export.extension.RenderProcessGoneDetail
    public final int rendererPriorityAtExit() {
        return this.a.rendererPriorityAtExit();
    }
}
