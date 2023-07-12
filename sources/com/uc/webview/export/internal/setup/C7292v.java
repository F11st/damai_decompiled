package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.utility.C7349p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.v */
/* loaded from: classes11.dex */
public final class C7292v implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ C7285o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7292v(C7285o c7285o) {
        this.a = c7285o;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        String str;
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        if (C7349p.f()) {
            str = "ThickSetupTask_" + ((String) abstractC7282l2.getOption(UCCore.OPTION_SO_FILE_PATH));
        } else {
            str = "";
        }
        if (str == null) {
            str = (String) abstractC7282l2.getOption(UCCore.OPTION_DEX_FILE_PATH);
        }
        if (str == null) {
            str = (String) abstractC7282l2.getOption(UCCore.OPTION_UCM_ZIP_FILE);
        }
        if (str == null) {
            str = (String) abstractC7282l2.getOption(UCCore.OPTION_UCM_LIB_DIR);
        }
        if (str == null) {
            str = (String) abstractC7282l2.getOption(UCCore.OPTION_UCM_KRL_DIR);
        }
        if (str == null) {
            str = (String) abstractC7282l2.getOption(UCCore.OPTION_UCM_CFG_FILE);
        }
        abstractC7282l2.setException(new UCSetupException((int) GlobalErrorCode.ERROR_CTID_NO_CERT, String.format("Multi crash detected in [%s].", str)));
        abstractC7282l2.onEvent(UCCore.EVENT_DIE, (ValueCallback) null);
        af.a(af.EnumC7264a.INIT_MULTI_CRASHED, abstractC7282l2.getException());
    }
}
