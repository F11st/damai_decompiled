package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bh;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bi implements ValueCallback<Object> {
    final /* synthetic */ bh.C7270a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh.C7270a c7270a) {
        this.a = c7270a;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        Log.d("ThinSetupTask", "task observer : " + obj);
        if (obj instanceof UCSetupException) {
            if (bu.d() != C7257ae.C7261d.b) {
                this.a.f.setException((UCSetupException) obj);
                return;
            }
            throw ((UCSetupException) obj);
        } else if (obj instanceof C7257ae.C7260c) {
            C7257ae.C7260c c7260c = (C7257ae.C7260c) obj;
            if (c7260c.c == C7257ae.C7263f.c) {
                if (C7257ae.EnumC7259b.LOAD_SDK_SHELL.equals(c7260c.a)) {
                    bh.C7270a.a(this.a);
                    bh.C7270a.b(this.a);
                    bh.C7270a.c(this.a);
                } else if (C7257ae.EnumC7259b.VERIFY_CORE_JAR.equals(c7260c.a)) {
                    this.a.b();
                }
            }
        }
    }
}
