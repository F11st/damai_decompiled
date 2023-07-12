package com.uc.webview.export.business.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class n extends HashMap<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        ValueCallback valueCallback;
        ValueCallback valueCallback2;
        ValueCallback valueCallback3;
        ValueCallback valueCallback4;
        ValueCallback valueCallback5;
        this.a = aVar;
        valueCallback = aVar.j;
        put("exception", new Pair(null, valueCallback));
        valueCallback2 = aVar.k;
        put("die_delegate", new Pair(null, valueCallback2));
        valueCallback3 = aVar.i;
        put(UCCore.EVENT_INIT_CORE_SUCCESS, new Pair(null, valueCallback3));
        valueCallback4 = aVar.l;
        put(UCCore.LEGACY_EVENT_SETUP, new Pair(null, valueCallback4));
        valueCallback5 = aVar.m;
        put(UCCore.EVENT_DELETE_FILE_FINISH, new Pair(null, valueCallback5));
    }
}
