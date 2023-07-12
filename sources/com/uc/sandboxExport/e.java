package com.uc.sandboxExport;

import android.os.IBinder;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class e implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ PreStartup.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PreStartup.a aVar, IBinder iBinder) {
        this.b = aVar;
        this.a = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PreStartup.a.a(this.b, this.a);
    }
}
