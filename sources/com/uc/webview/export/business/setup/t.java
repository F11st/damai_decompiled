package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class t implements ValueCallback<com.uc.webview.export.internal.setup.l> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.a = pVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(com.uc.webview.export.internal.setup.l lVar) {
        String str;
        com.uc.webview.export.business.a aVar;
        com.uc.webview.export.internal.setup.l lVar2 = lVar;
        str = p.a;
        Log.d(str, "exception " + lVar2);
        aVar = this.a.c;
        aVar.a(a.c.h);
        p.a(this.a, lVar2);
    }
}
