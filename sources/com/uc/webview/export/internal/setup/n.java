package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class n extends UCSubSetupTask<n, n> implements ValueCallback<Pair<String, HashMap<String, String>>> {
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Pair<String, HashMap<String, String>> pair) {
        callbackStat(pair);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public final void run() {
        SDKFactory.b = this;
    }
}
