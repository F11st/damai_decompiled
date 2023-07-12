package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class v implements ValueCallback<l> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.a = oVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        String str;
        l lVar2 = lVar;
        if (com.uc.webview.export.internal.utility.p.f()) {
            str = "ThickSetupTask_" + ((String) lVar2.getOption(UCCore.OPTION_SO_FILE_PATH));
        } else {
            str = "";
        }
        if (str == null) {
            str = (String) lVar2.getOption(UCCore.OPTION_DEX_FILE_PATH);
        }
        if (str == null) {
            str = (String) lVar2.getOption(UCCore.OPTION_UCM_ZIP_FILE);
        }
        if (str == null) {
            str = (String) lVar2.getOption(UCCore.OPTION_UCM_LIB_DIR);
        }
        if (str == null) {
            str = (String) lVar2.getOption(UCCore.OPTION_UCM_KRL_DIR);
        }
        if (str == null) {
            str = (String) lVar2.getOption(UCCore.OPTION_UCM_CFG_FILE);
        }
        lVar2.setException(new UCSetupException((int) GlobalErrorCode.ERROR_CTID_NO_CERT, String.format("Multi crash detected in [%s].", str)));
        lVar2.onEvent(UCCore.EVENT_DIE, (ValueCallback) null);
        af.a(af.a.INIT_MULTI_CRASHED, lVar2.getException());
    }
}
