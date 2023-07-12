package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.webkit.WebMessage;

/* compiled from: Taobao */
@TargetApi(23)
/* loaded from: classes11.dex */
public final class m extends WebMessage {
    private com.uc.webview.export.WebMessage a;

    public m(com.uc.webview.export.WebMessage webMessage) {
        super(webMessage.getData());
        this.a = webMessage;
    }

    @Override // android.webkit.WebMessage
    public final String getData() {
        return this.a.getData();
    }
}
