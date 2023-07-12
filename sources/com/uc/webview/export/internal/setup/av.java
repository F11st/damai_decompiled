package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class av implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7266ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(C7266ar c7266ar) {
        this.a = c7266ar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        String str;
        str = C7266ar.c;
        Log.d(str, "success " + abstractC7282l);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_SEARE_CORE_FILE_SUCCESS_PV);
    }
}
