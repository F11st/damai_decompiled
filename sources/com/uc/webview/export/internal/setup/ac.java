package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ac implements ValueCallback<l> {
    final ValueCallback a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(o oVar) {
        this.b = oVar;
        this.a = oVar.getCallback(UCCore.EVENT_DOWNLOAD_EXCEPTION);
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        if (this.a != null) {
            if (lVar2.getExtraException() != null) {
                this.b.setExtraException(lVar2.getExtraException());
            }
            this.a.onReceiveValue(this.b);
        }
    }
}
