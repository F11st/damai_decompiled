package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ac implements ValueCallback<AbstractC7282l> {
    final ValueCallback a;
    final /* synthetic */ C7285o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(C7285o c7285o) {
        this.b = c7285o;
        this.a = c7285o.getCallback(UCCore.EVENT_DOWNLOAD_EXCEPTION);
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        if (this.a != null) {
            if (abstractC7282l2.getExtraException() != null) {
                this.b.setExtraException(abstractC7282l2.getExtraException());
            }
            this.a.onReceiveValue(this.b);
        }
    }
}
