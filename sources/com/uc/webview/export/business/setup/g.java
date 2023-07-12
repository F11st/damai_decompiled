package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class g extends HashMap<String, Object> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
        put(UCCore.OPTION_BUSINESS_INIT_TYPE, "int_android_webview");
        put(UCCore.OPTION_USE_SYSTEM_WEBVIEW, Boolean.TRUE);
    }
}
