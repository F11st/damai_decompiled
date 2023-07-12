package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.s */
/* loaded from: classes11.dex */
final class C7203s implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7200p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7203s(C7200p c7200p) {
        this.a = c7200p;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        String str;
        C7179a c7179a;
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        str = C7200p.a;
        Log.d(str, "die " + abstractC7282l2);
        c7179a = this.a.c;
        IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(c7179a.a), 1);
        if (C7349p.h()) {
            IWaStat.WaStat.saveData();
            IWaStat.WaStat.upload();
        }
        C7200p.a(this.a, abstractC7282l2);
    }
}
