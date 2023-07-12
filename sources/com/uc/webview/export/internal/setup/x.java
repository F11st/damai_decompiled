package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class x implements ValueCallback<l> {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask exception " + lVar);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPD_SC_INIT_EXCEPTION_PV);
        try {
            com.uc.webview.export.internal.utility.j.f(this.a.a.getContext().getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
