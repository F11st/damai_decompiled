package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.d */
/* loaded from: classes11.dex */
final class C7188d extends HashMap<String, Object> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7188d(C7184a c7184a) {
        String f;
        this.a = c7184a;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_NEW_CORE_DEX_DIR);
        put(UCCore.OPTION_UCM_ZIP_FILE, null);
        put(UCCore.OPTION_NOT_USE_7Z_CORE, Boolean.TRUE);
        f = c7184a.f();
        put(UCCore.OPTION_DEX_FILE_PATH, f);
    }
}
