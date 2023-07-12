package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import com.uc.webview.export.internal.utility.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class bi implements ValueCallback<Object> {
    final /* synthetic */ bh.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh.a aVar) {
        this.a = aVar;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        Log.d("ThinSetupTask", "task observer : " + obj);
        if (obj instanceof UCSetupException) {
            if (bu.d() != ae.d.b) {
                this.a.f.setException((UCSetupException) obj);
                return;
            }
            throw ((UCSetupException) obj);
        } else if (obj instanceof ae.c) {
            ae.c cVar = (ae.c) obj;
            if (cVar.c == ae.f.c) {
                if (ae.b.LOAD_SDK_SHELL.equals(cVar.a)) {
                    bh.a.a(this.a);
                    bh.a.b(this.a);
                    bh.a.c(this.a);
                } else if (ae.b.VERIFY_CORE_JAR.equals(cVar.a)) {
                    this.a.b();
                }
            }
        }
    }
}
