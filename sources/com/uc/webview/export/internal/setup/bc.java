package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.setup.bb;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bc implements ValueCallback<Object> {
    final /* synthetic */ bb.C7269a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb.C7269a c7269a) {
        this.a = c7269a;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        Log.d("ThickSetupTask", "task observer : " + obj);
        if (obj instanceof UCSetupException) {
            if (bu.d() != C7257ae.C7261d.b) {
                this.a.f.setException((UCSetupException) obj);
                return;
            }
            throw ((UCSetupException) obj);
        } else if (obj instanceof C7257ae.C7260c) {
            C7257ae.C7260c c7260c = (C7257ae.C7260c) obj;
            if (c7260c.c == C7257ae.C7263f.c && C7257ae.EnumC7259b.CHECK_OLD_KERNEL.equals(c7260c.a)) {
                this.a.b();
            }
        }
    }
}
