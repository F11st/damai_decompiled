package com.uc.webview.export.internal;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCSetupException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class c implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                Runnable runnable = (Runnable) SDKFactory.b.a.poll();
                if (runnable == null) {
                    return;
                }
                runnable.run();
            } catch (Exception e) {
                SDKFactory.b.a.clear();
                UCSetupException unused = SDKFactory.b.b = new UCSetupException((int) GlobalErrorCode.ERROR_CTID_DATA_ERROR, e);
                return;
            }
        }
    }
}
