package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class k implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.a = aVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        String str2;
        ConcurrentHashMap concurrentHashMap;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = a.a;
        Log.d(str, "mDieDelegateCallback " + baseSetupTask2.toString() + " init type: " + baseSetupTask2.getInitType());
        a.g(this.a);
        a.a(this.a, baseSetupTask2.getInitType());
        if (com.uc.webview.export.internal.utility.p.h()) {
            IWaStat.WaStat.saveData(true);
            IWaStat.WaStat.upload();
        }
        str2 = a.a;
        StringBuilder sb = new StringBuilder("options: ");
        concurrentHashMap = this.a.mOptions;
        sb.append(concurrentHashMap);
        Log.d(str2, sb.toString());
    }
}
