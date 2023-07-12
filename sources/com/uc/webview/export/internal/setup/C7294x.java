package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.C7337j;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.x */
/* loaded from: classes11.dex */
final class C7294x implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7293w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7294x(C7293w c7293w) {
        this.a = c7293w;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask exception " + abstractC7282l);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPD_SC_INIT_EXCEPTION_PV);
        try {
            C7337j.f(this.a.a.getContext().getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
