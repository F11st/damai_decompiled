package com.uc.webview.export.internal.setup;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.ad */
/* loaded from: classes11.dex */
public final class C7256ad implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7256ad(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        Log.d("SdkSetupTask", "mSwitchCB " + abstractC7282l2);
        if (abstractC7282l2.getLoadedUCM() != null) {
            C7285o.a(this.a, abstractC7282l2.getLoadedUCM());
            this.a.f();
            if (!TextUtils.isEmpty((String) this.a.getOption(UCCore.OPTION_UCM_UPD_URL))) {
                this.a.g();
            }
            ValueCallback<CALLBACK_TYPE> callback = this.a.getCallback("switch");
            if (callback != 0) {
                callback.onReceiveValue(this.a);
            }
        }
    }
}
