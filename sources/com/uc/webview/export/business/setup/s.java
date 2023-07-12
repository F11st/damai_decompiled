package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class s implements ValueCallback<com.uc.webview.export.internal.setup.l> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.a = pVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(com.uc.webview.export.internal.setup.l lVar) {
        String str;
        com.uc.webview.export.business.a aVar;
        com.uc.webview.export.internal.setup.l lVar2 = lVar;
        str = p.a;
        Log.d(str, "die " + lVar2);
        aVar = this.a.c;
        IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(aVar.a), 1);
        if (com.uc.webview.export.internal.utility.p.h()) {
            IWaStat.WaStat.saveData();
            IWaStat.WaStat.upload();
        }
        p.a(this.a, lVar2);
    }
}
