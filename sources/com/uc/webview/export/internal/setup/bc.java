package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bb;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bc implements ValueCallback<Object> {
    final /* synthetic */ bb.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb.a aVar) {
        this.a = aVar;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        Log.d("ThickSetupTask", "task observer : " + obj);
        if (obj instanceof UCSetupException) {
            if (bu.d() != ae.d.b) {
                this.a.f.setException((UCSetupException) obj);
                return;
            }
            throw ((UCSetupException) obj);
        } else if (obj instanceof ae.c) {
            ae.c cVar = (ae.c) obj;
            if (cVar.c == ae.f.c && ae.b.CHECK_OLD_KERNEL.equals(cVar.a)) {
                this.a.b();
            }
        }
    }
}
