package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.webkit.WebMessage;

/* compiled from: Taobao */
@TargetApi(23)
/* renamed from: com.uc.webview.export.internal.android.m */
/* loaded from: classes11.dex */
public final class C7232m extends WebMessage {
    private com.uc.webview.export.WebMessage a;

    public C7232m(com.uc.webview.export.WebMessage webMessage) {
        super(webMessage.getData());
        this.a = webMessage;
    }

    @Override // android.webkit.WebMessage
    public final String getData() {
        return this.a.getData();
    }
}
