package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.l;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e implements ValueCallback<l> {
    final /* synthetic */ Map a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Map map) {
        this.a = map;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        b.a(this.a, "switch", null);
    }
}
