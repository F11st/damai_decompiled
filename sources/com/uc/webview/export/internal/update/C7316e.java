package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.e */
/* loaded from: classes11.dex */
public final class C7316e implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ Map a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7316e(Map map) {
        this.a = map;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        C7312b.a(this.a, "switch", null);
    }
}
