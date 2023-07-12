package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.k */
/* loaded from: classes11.dex */
public final class C7195k implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7195k(C7184a c7184a) {
        this.a = c7184a;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        String str2;
        ConcurrentHashMap concurrentHashMap;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = C7184a.a;
        Log.d(str, "mDieDelegateCallback " + baseSetupTask2.toString() + " init type: " + baseSetupTask2.getInitType());
        C7184a.g(this.a);
        C7184a.a(this.a, baseSetupTask2.getInitType());
        if (C7349p.h()) {
            IWaStat.WaStat.saveData(true);
            IWaStat.WaStat.upload();
        }
        str2 = C7184a.a;
        StringBuilder sb = new StringBuilder("options: ");
        concurrentHashMap = this.a.mOptions;
        sb.append(concurrentHashMap);
        Log.d(str2, sb.toString());
    }
}
