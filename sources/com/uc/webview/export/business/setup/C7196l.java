package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.business.setup.C7184a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.l */
/* loaded from: classes11.dex */
public final class C7196l implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7196l(C7184a c7184a) {
        this.a = c7184a;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        C7184a.C7185a c7185a;
        C7184a.C7185a c7185a2;
        C7184a.C7185a c7185a3;
        C7184a.C7185a c7185a4;
        C7179a c7179a;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = C7184a.a;
        Log.d(str, "mNewCoreDecompressAndODex " + baseSetupTask2.toString());
        C7184a.a(this.a, UCCore.LEGACY_EVENT_SETUP, baseSetupTask2);
        c7185a = this.a.h;
        c7185a2 = this.a.h;
        c7185a.d = String.valueOf(c7185a2.a.getMilis());
        c7185a3 = this.a.h;
        c7185a4 = this.a.h;
        c7185a3.e = String.valueOf(c7185a4.a.getMilisCpu());
        c7179a = this.a.d;
        c7179a.a(C7179a.C7183d.e);
    }
}
