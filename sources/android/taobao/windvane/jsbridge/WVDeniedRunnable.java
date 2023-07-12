package android.taobao.windvane.jsbridge;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVDeniedRunnable implements Runnable {
    WVCallBackContext callback;
    String errorMsg;
    String state;

    public WVDeniedRunnable(WVCallBackContext wVCallBackContext, String str) {
        this.callback = wVCallBackContext;
        this.errorMsg = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVResult wVResult = new WVResult();
        wVResult.addData("msg", this.errorMsg);
        if (!TextUtils.isEmpty(this.state)) {
            wVResult.addData("state", this.state);
        }
        this.callback.error(wVResult);
    }

    public WVDeniedRunnable(WVCallBackContext wVCallBackContext, String str, String str2) {
        this.callback = wVCallBackContext;
        this.errorMsg = str;
        this.state = str2;
    }
}
