package com.uc.webview.export.internal.android;

import com.uc.webview.export.extension.RenderProcessGoneDetail;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class u extends RenderProcessGoneDetail {
    final /* synthetic */ android.webkit.RenderProcessGoneDetail a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
        this.b = tVar;
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
