package com.uc.sandboxExport;

import android.os.HandlerThread;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.g */
/* loaded from: classes11.dex */
final class HandlerThreadC7164g extends HandlerThread {
    final /* synthetic */ PreStartup.C7155b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerThreadC7164g(PreStartup.C7155b c7155b, String str) {
        super(str, 0);
        this.a = c7155b;
    }

    @Override // android.os.HandlerThread
    protected final void onLooperPrepared() {
        synchronized (this.a.a) {
            this.a.a.notify();
        }
    }
}
