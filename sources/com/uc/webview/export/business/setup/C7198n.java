package com.uc.webview.export.business.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.n */
/* loaded from: classes11.dex */
public final class C7198n extends HashMap<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> {
    final /* synthetic */ C7184a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7198n(C7184a c7184a) {
        ValueCallback valueCallback;
        ValueCallback valueCallback2;
        ValueCallback valueCallback3;
        ValueCallback valueCallback4;
        ValueCallback valueCallback5;
        this.a = c7184a;
        valueCallback = c7184a.j;
        put("exception", new Pair(null, valueCallback));
        valueCallback2 = c7184a.k;
        put("die_delegate", new Pair(null, valueCallback2));
        valueCallback3 = c7184a.i;
        put(UCCore.EVENT_INIT_CORE_SUCCESS, new Pair(null, valueCallback3));
        valueCallback4 = c7184a.l;
        put(UCCore.LEGACY_EVENT_SETUP, new Pair(null, valueCallback4));
        valueCallback5 = c7184a.m;
        put(UCCore.EVENT_DELETE_FILE_FINISH, new Pair(null, valueCallback5));
    }
}
