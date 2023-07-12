package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ba extends l {
    public ba() {
        Log.i("SystemSetupTask", "<init>", new Throwable());
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public final void run() {
        Log.i("SystemSetupTask", "run");
        try {
            CookieSyncManager.createInstance((Context) getOption("CONTEXT"));
        } catch (RuntimeException unused) {
        }
        callback(UCCore.LEGACY_EVENT_SETUP);
        callback("load");
        SDKFactory.f(2);
        setLoadedUCM(new UCMRunningInfo(getContext(), null, null, null, false, false, null, 2, false, 0));
        callback(UCCore.LEGACY_EVENT_INIT);
        callback("switch");
        IWaStat.WaStat.stat(IWaStat.KEY_SYSTEM_SETUP_PV);
    }
}
