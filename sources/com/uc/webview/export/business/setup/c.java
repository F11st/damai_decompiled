package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class c extends HashMap<String, Object> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        Object option;
        ConcurrentHashMap concurrentHashMap;
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE);
        option = aVar.getOption(UCCore.OPTION_NEW_UCM_ZIP_TYPE);
        put(UCCore.OPTION_ZIP_FILE_TYPE, option);
        put(UCCore.OPTION_DEX_FILE_PATH, null);
        concurrentHashMap = aVar.mOptions;
        put(UCCore.OPTION_UCM_ZIP_FILE, concurrentHashMap.get(UCCore.OPTION_NEW_UCM_ZIP_FILE));
    }
}
