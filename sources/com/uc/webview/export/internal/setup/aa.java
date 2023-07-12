package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class aa implements ValueCallback<l> {
    final ValueCallback a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(o oVar) {
        this.b = oVar;
        this.a = oVar.getCallback(UCCore.EVENT_UPDATE_PROGRESS);
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        this.b.mPercent = lVar.getPercent();
        ValueCallback valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(this.b);
        }
    }
}
