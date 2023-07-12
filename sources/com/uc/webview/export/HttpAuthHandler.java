package com.uc.webview.export;

import android.os.Handler;
import com.uc.webview.export.annotations.Api;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class HttpAuthHandler extends Handler {
    public android.webkit.HttpAuthHandler mHandler = null;

    public void cancel() {
        this.mHandler.cancel();
    }

    public void proceed(String str, String str2) {
        this.mHandler.proceed(str, str2);
    }

    public boolean suppressDialog() {
        return false;
    }

    public boolean useHttpAuthUsernamePassword() {
        return this.mHandler.useHttpAuthUsernamePassword();
    }
}
