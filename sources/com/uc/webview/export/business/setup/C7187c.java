package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.c */
/* loaded from: classes11.dex */
public final class C7187c extends HashMap<String, Object> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7187c(C7184a c7184a) {
        Object option;
        ConcurrentHashMap concurrentHashMap;
        this.a = c7184a;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, UCCore.BUSINESS_INIT_BY_NEW_CORE_ZIP_FILE);
        option = c7184a.getOption(UCCore.OPTION_NEW_UCM_ZIP_TYPE);
        put(UCCore.OPTION_ZIP_FILE_TYPE, option);
        put(UCCore.OPTION_DEX_FILE_PATH, null);
        concurrentHashMap = c7184a.mOptions;
        put(UCCore.OPTION_UCM_ZIP_FILE, concurrentHashMap.get(UCCore.OPTION_NEW_UCM_ZIP_FILE));
    }
}
