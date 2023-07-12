package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.utility.SetupTask;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.q */
/* loaded from: classes11.dex */
final class C7201q implements ValueCallback<AbstractC7282l> {
    final ValueCallback<SetupTask> a;
    final /* synthetic */ Map.Entry b;
    final /* synthetic */ C7200p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7201q(C7200p c7200p, Map.Entry entry) {
        this.c = c7200p;
        this.b = entry;
        this.a = (ValueCallback) entry.getValue();
    }

    @Override // android.webkit.ValueCallback
    public final /* bridge */ /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        this.a.onReceiveValue(this.c);
    }
}
