package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class r implements ValueCallback<com.uc.webview.export.internal.setup.l> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str, String str2) {
        this.c = pVar;
        this.a = str;
        this.b = str2;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(com.uc.webview.export.internal.setup.l lVar) {
        String str;
        com.uc.webview.export.business.a aVar;
        Object option;
        com.uc.webview.export.internal.setup.l lVar2 = lVar;
        str = p.a;
        Log.d(str, "setup callback.");
        lVar2.stop();
        aVar = this.c.c;
        aVar.a(a.c.g);
        option = this.c.getOption("o_flag_odex_done");
        if (com.uc.webview.export.internal.utility.p.a((Boolean) option)) {
            p.a(this.a, this.b);
        }
        p.a(this.c, lVar2);
    }
}
