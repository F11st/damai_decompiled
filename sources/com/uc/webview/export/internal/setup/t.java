package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class t implements ValueCallback<f> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.a = oVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(f fVar) {
        ValueCallback<CALLBACK_TYPE> callback = this.a.getCallback(UCCore.EVENT_DELETE_FILE_FINISH);
        if (callback != 0) {
            callback.onReceiveValue(this.a);
        }
    }
}
