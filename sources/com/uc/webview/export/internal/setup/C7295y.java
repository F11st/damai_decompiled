package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.y */
/* loaded from: classes11.dex */
final class C7295y implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7293w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7295y(C7293w c7293w) {
        this.a = c7293w;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask success " + abstractC7282l);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPD_SC_INIT_SUCCESS_PV);
    }
}
