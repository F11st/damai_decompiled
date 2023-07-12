package com.uc.sandboxExport;

import android.os.HandlerThread;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class g extends HandlerThread {
    final /* synthetic */ PreStartup.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PreStartup.b bVar, String str) {
        super(str, 0);
        this.a = bVar;
    }

    @Override // android.os.HandlerThread
    protected final void onLooperPrepared() {
        synchronized (this.a.a) {
            this.a.a.notify();
        }
    }
}
