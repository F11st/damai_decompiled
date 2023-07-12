package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class at implements ValueCallback<l> {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar) {
        this.a = arVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        String str;
        str = ar.c;
        Log.d(str, "setup callback.");
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_SEARE_CORE_FILE_SETUP_PV);
        lVar.stop();
    }
}
