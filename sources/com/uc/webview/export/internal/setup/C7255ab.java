package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.ab */
/* loaded from: classes11.dex */
public final class C7255ab implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ String a;
    final /* synthetic */ C7285o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7255ab(C7285o c7285o, String str) {
        this.b = c7285o;
        this.a = str;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        try {
            new aw();
            aw.a(this.b.getContext().getApplicationContext(), this.a, ((by) abstractC7282l2).c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
