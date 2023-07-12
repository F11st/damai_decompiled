package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ab implements ValueCallback<l> {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        try {
            new aw();
            aw.a(this.b.getContext().getApplicationContext(), this.a, ((by) lVar2).c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
