package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.j */
/* loaded from: classes11.dex */
public final class C7194j implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7194j(C7184a c7184a) {
        this.a = c7184a;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        C7179a c7179a;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = C7184a.a;
        Log.d(str, "mExceptionCallback " + baseSetupTask2.getException().errCode() + ":" + baseSetupTask2.getException().getMessage());
        c7179a = this.a.d;
        c7179a.a(C7179a.C7183d.g);
        baseSetupTask2.getException().errCode();
        C7184a.b();
        C7184a.a(this.a, "exception", baseSetupTask2);
    }
}
