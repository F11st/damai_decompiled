package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.z */
/* loaded from: classes11.dex */
public final class C7296z implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7296z(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        if (abstractC7282l instanceof aq) {
            Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask.EVENT_DELAY_SEARCH_CORE_FILE callback");
            C7285o c7285o = this.a;
            c7285o.f = C7285o.i(c7285o);
        }
    }
}
