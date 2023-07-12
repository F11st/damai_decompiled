package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e extends HashMap<String, Object> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        ConcurrentHashMap concurrentHashMap;
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_OLD_CORE_DEX_DIR);
        put(UCCore.OPTION_UCM_ZIP_FILE, null);
        put(UCCore.OPTION_NOT_USE_7Z_CORE, Boolean.TRUE);
        concurrentHashMap = aVar.mOptions;
        put(UCCore.OPTION_DEX_FILE_PATH, concurrentHashMap.get(UCCore.OPTION_OLD_DEX_DIR_PATH));
    }
}
