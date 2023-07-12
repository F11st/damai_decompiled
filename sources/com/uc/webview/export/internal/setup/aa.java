package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class aa implements ValueCallback<AbstractC7282l> {
    final ValueCallback a;
    final /* synthetic */ C7285o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(C7285o c7285o) {
        this.b = c7285o;
        this.a = c7285o.getCallback(UCCore.EVENT_UPDATE_PROGRESS);
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        this.b.mPercent = abstractC7282l.getPercent();
        ValueCallback valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(this.b);
        }
    }
}
