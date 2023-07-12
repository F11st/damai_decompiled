package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.e */
/* loaded from: classes11.dex */
public final class C7189e extends HashMap<String, Object> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7189e(C7184a c7184a) {
        ConcurrentHashMap concurrentHashMap;
        this.a = c7184a;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR);
        put(UCCore.OPTION_UCM_ZIP_FILE, null);
        put(UCCore.OPTION_NOT_USE_7Z_CORE, Boolean.TRUE);
        concurrentHashMap = c7184a.mOptions;
        put(UCCore.OPTION_DEX_FILE_PATH, concurrentHashMap.get(UCCore.OPTION_OLD_DEX_DIR_PATH));
    }
}
