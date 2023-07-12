package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class z implements ValueCallback<l> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(o oVar) {
        this.a = oVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        if (lVar instanceof aq) {
            Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask.EVENT_DELAY_SEARCH_CORE_FILE callback");
            o oVar = this.a;
            oVar.f = o.i(oVar);
        }
    }
}
