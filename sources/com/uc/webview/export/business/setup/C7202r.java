package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.r */
/* loaded from: classes11.dex */
final class C7202r implements ValueCallback<AbstractC7282l> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ C7200p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7202r(C7200p c7200p, String str, String str2) {
        this.c = c7200p;
        this.a = str;
        this.b = str2;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(AbstractC7282l abstractC7282l) {
        String str;
        C7179a c7179a;
        Object option;
        AbstractC7282l abstractC7282l2 = abstractC7282l;
        str = C7200p.a;
        Log.d(str, "setup callback.");
        abstractC7282l2.stop();
        c7179a = this.c.c;
        c7179a.a(C7179a.C7182c.g);
        option = this.c.getOption("o_flag_odex_done");
        if (C7349p.a((Boolean) option)) {
            C7200p.a(this.a, this.b);
        }
        C7200p.a(this.c, abstractC7282l2);
    }
}
