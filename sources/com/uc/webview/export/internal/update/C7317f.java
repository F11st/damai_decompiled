package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.update.f */
/* loaded from: classes11.dex */
public final class C7317f implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7317f(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        Log.d("UpdateUtils", "doUpdateUCCore setuptask exception url:" + this.a, abstractC7282l2.getException());
        C7312b.a(this.b, "failed", abstractC7282l2.getException());
    }
}
