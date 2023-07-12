package com.uc.webview.export.business.setup;

import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class o extends HashMap<String, String> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.a = aVar;
        put(UCCore.EVENT_INIT_CORE_SUCCESS, "success");
        put("die_delegate", UCCore.EVENT_DIE);
    }
}
