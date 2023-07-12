package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class f implements ValueCallback<l> {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d("UpdateUtils", "doUpdateUCCore setuptask exception url:" + this.a, lVar2.getException());
        b.a(this.b, "failed", lVar2.getException());
    }
}
