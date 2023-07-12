package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class m implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.a = aVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        String str;
        com.uc.webview.export.business.a aVar;
        Object option;
        Object option2;
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        str = a.a;
        Log.d(str, "mDeleteFileFinish " + baseSetupTask2.toString());
        a.a(this.a, UCCore.EVENT_DELETE_FILE_FINISH, baseSetupTask2);
        aVar = this.a.d;
        aVar.a(a.d.k);
        if (UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE.equals(baseSetupTask2.getInitType())) {
            option = this.a.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH);
            option2 = this.a.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE);
            p.a((String) option, (String) option2);
        } else if (UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR.equals(baseSetupTask2.getInitType())) {
            a.i(this.a);
        }
    }
}
