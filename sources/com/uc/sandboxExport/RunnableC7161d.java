package com.uc.sandboxExport;

import android.content.ServiceConnection;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* renamed from: com.uc.sandboxExport.d */
/* loaded from: classes11.dex */
final class RunnableC7161d implements Runnable {
    final /* synthetic */ PreStartup.ServiceConnectionC7154a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7161d(PreStartup.ServiceConnectionC7154a serviceConnectionC7154a) {
        this.a = serviceConnectionC7154a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.ServiceConnectionC7154a serviceConnectionC7154a = this.a;
        ServiceConnection serviceConnection = serviceConnectionC7154a.h;
        if (serviceConnection != null) {
            serviceConnection.onServiceConnected(serviceConnectionC7154a.f, serviceConnectionC7154a.g);
        }
    }
}
