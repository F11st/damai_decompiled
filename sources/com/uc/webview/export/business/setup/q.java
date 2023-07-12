package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.utility.SetupTask;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class q implements ValueCallback<com.uc.webview.export.internal.setup.l> {
    final ValueCallback<SetupTask> a;
    final /* synthetic */ Map.Entry b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Map.Entry entry) {
        this.c = pVar;
        this.b = entry;
        this.a = (ValueCallback) entry.getValue();
    }

    @Override // android.webkit.ValueCallback
    public final /* bridge */ /* synthetic */ void onReceiveValue(com.uc.webview.export.internal.setup.l lVar) {
        this.a.onReceiveValue(this.c);
    }
}
