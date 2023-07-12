package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.m */
/* loaded from: classes11.dex */
public final class C7197m implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7197m(C7184a c7184a) {
        this.a = c7184a;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        C7179a c7179a;
        Object option;
        Object option2;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = C7184a.a;
        Log.d(str, "mDeleteFileFinish " + baseSetupTask2.toString());
        C7184a.a(this.a, UCCore.EVENT_DELETE_FILE_FINISH, baseSetupTask2);
        c7179a = this.a.d;
        c7179a.a(C7179a.C7183d.k);
        if (UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE.equals(baseSetupTask2.getInitType())) {
            option = this.a.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH);
            option2 = this.a.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE);
            C7200p.a((String) option, (String) option2);
        } else if (UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR.equals(baseSetupTask2.getInitType())) {
            C7184a.i(this.a);
        }
    }
}
