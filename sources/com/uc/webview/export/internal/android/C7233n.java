package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.os.Handler;
import com.uc.webview.export.WebMessage;
import com.uc.webview.export.WebMessagePort;

/* compiled from: Taobao */
@TargetApi(23)
/* renamed from: com.uc.webview.export.internal.android.n */
/* loaded from: classes11.dex */
public final class C7233n extends WebMessagePort {
    android.webkit.WebMessagePort a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7233n(android.webkit.WebMessagePort webMessagePort) {
        this.a = webMessagePort;
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void close() {
        this.a.close();
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void postMessage(WebMessage webMessage) {
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback) {
        setWebMessageCallback(webMessageCallback, null);
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback, Handler handler) {
        this.a.setWebMessageCallback(new C7234o(this));
    }
}
