package com.uc.sandboxExport;

import android.os.IBinder;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.e */
/* loaded from: classes11.dex */
final class RunnableC7162e implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ PreStartup.ServiceConnectionC7154a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7162e(PreStartup.ServiceConnectionC7154a serviceConnectionC7154a, IBinder iBinder) {
        this.b = serviceConnectionC7154a;
        this.a = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.ServiceConnectionC7154a.a(this.b, this.a);
    }
}
