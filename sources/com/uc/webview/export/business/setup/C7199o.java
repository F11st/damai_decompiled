package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.o */
/* loaded from: classes11.dex */
final class C7199o extends HashMap<String, String> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7199o(C7184a c7184a) {
        this.a = c7184a;
        put(UCCore.EVENT_INIT_CORE_SUCCESS, "success");
        put("die_delegate", UCCore.EVENT_DIE);
    }
}
