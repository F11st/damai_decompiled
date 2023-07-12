package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class w implements ValueCallback<l> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(o oVar) {
        this.a = oVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l e;
        ValueCallback valueCallback;
        l lVar2 = lVar;
        Log.d("SdkSetupTask", "mShareCoreCB " + lVar2);
        try {
            by byVar = (by) lVar2;
            if (CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY))) {
                e = this.a.e();
                valueCallback = this.a.t;
                ((l) ((l) ((l) ((l) ((l) ((l) ((l) e.setParent(UCSetupTask.getRoot())).setup(UCCore.OPTION_LOCAL_DIR, (Object) byVar.d)).setup(UCCore.OPTION_DEC_FILE, (Object) byVar.e)).onEvent("switch", valueCallback)).onEvent("success", (ValueCallback) new y(this))).onEvent("exception", (ValueCallback) new x(this))).onEvent(UCCore.EVENT_DELAY_SEARCH_CORE_FILE, (ValueCallback) null)).start();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
