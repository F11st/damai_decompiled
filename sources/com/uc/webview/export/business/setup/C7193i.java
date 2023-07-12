package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.business.setup.C7184a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.i */
/* loaded from: classes11.dex */
public final class C7193i implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7193i(C7184a c7184a) {
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
        C7179a c7179a2;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = C7184a.a;
        Log.d(str, "mSuccessCallback " + baseSetupTask2.toString() + " init type: " + baseSetupTask2.getInitType());
        c7185a = this.a.h;
        c7185a2 = this.a.h;
        c7185a.f = String.valueOf(c7185a2.a.getMilis());
        c7185a3 = this.a.h;
        c7185a4 = this.a.h;
        c7185a3.g = String.valueOf(c7185a4.a.getMilisCpu());
        if (SDKFactory.e() != 2) {
            c7179a2 = this.a.d;
            c7179a2.a(C7179a.C7183d.h);
            C7184a.a(this.a, UCCore.EVENT_INIT_CORE_SUCCESS, baseSetupTask2);
            return;
        }
        c7179a = this.a.d;
        c7179a.a(C7179a.C7183d.i);
    }
}
