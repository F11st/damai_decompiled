package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.t */
/* loaded from: classes11.dex */
public final class C7290t implements ValueCallback<C7275f> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7290t(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(C7275f c7275f) {
        ValueCallback<CALLBACK_TYPE> callback = this.a.getCallback(UCCore.EVENT_DELETE_FILE_FINISH);
        if (callback != 0) {
            callback.onReceiveValue(this.a);
        }
    }
}
