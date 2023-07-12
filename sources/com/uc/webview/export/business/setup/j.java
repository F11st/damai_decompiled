package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class j implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.a = aVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        com.uc.webview.export.business.a aVar;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = a.a;
        Log.d(str, "mExceptionCallback " + baseSetupTask2.getException().errCode() + ":" + baseSetupTask2.getException().getMessage());
        aVar = this.a.d;
        aVar.a(a.d.g);
        baseSetupTask2.getException().errCode();
        a.b();
        a.a(this.a, "exception", baseSetupTask2);
    }
}
