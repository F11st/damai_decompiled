package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.business.setup.a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class l implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.a = aVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        a.C0349a c0349a;
        a.C0349a c0349a2;
        a.C0349a c0349a3;
        a.C0349a c0349a4;
        com.uc.webview.export.business.a aVar;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = a.a;
        Log.d(str, "mNewCoreDecompressAndODex " + baseSetupTask2.toString());
        a.a(this.a, UCCore.LEGACY_EVENT_SETUP, baseSetupTask2);
        c0349a = this.a.h;
        c0349a2 = this.a.h;
        c0349a.d = String.valueOf(c0349a2.a.getMilis());
        c0349a3 = this.a.h;
        c0349a4 = this.a.h;
        c0349a3.e = String.valueOf(c0349a4.a.getMilisCpu());
        aVar = this.a.d;
        aVar.a(a.d.e);
    }
}
