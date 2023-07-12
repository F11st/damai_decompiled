package com.uc.sandboxExport;

import android.content.ServiceConnection;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class d implements Runnable {
    final /* synthetic */ PreStartup.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PreStartup.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.a aVar = this.a;
        ServiceConnection serviceConnection = aVar.h;
        if (serviceConnection != null) {
            serviceConnection.onServiceConnected(aVar.f, aVar.g);
        }
    }
}
