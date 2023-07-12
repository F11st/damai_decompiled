package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.w */
/* loaded from: classes11.dex */
public final class C7293w implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7293w(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l e;
        ValueCallback valueCallback;
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        Log.d("SdkSetupTask", "mShareCoreCB " + abstractC7282l2);
        try {
            by byVar = (by) abstractC7282l2;
            if (CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY))) {
                e = this.a.e();
                valueCallback = this.a.t;
                ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) e.setParent(UCSetupTask.getRoot())).setup(UCCore.OPTION_LOCAL_DIR, (Object) byVar.d)).setup(UCCore.OPTION_DEC_FILE, (Object) byVar.e)).onEvent("switch", valueCallback)).onEvent("success", (ValueCallback) new C7295y(this))).onEvent("exception", (ValueCallback) new C7294x(this))).onEvent(UCCore.EVENT_DELAY_SEARCH_CORE_FILE, (ValueCallback) null)).start();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
