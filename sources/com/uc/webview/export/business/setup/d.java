package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class d extends HashMap<String, Object> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        String f;
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_NEW_CORE_DEX_DIR);
        put(UCCore.OPTION_UCM_ZIP_FILE, null);
        put(UCCore.OPTION_NOT_USE_7Z_CORE, Boolean.TRUE);
        f = aVar.f();
        put(UCCore.OPTION_DEX_FILE_PATH, f);
    }
}
