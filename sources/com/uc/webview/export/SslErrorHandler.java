package com.uc.webview.export;

import android.os.Handler;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class SslErrorHandler extends Handler {
    public android.webkit.SslErrorHandler mHandler = null;

    public void cancel() {
        this.mHandler.cancel();
    }

    public void proceed() {
        this.mHandler.proceed();
    }
}
