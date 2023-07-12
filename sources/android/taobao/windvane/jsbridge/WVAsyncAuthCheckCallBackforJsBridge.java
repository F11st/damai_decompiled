package android.taobao.windvane.jsbridge;

import android.taobao.windvane.jsbridge.WVAsyncAuthCheck;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVAsyncAuthCheckCallBackforJsBridge implements WVAsyncAuthCheck.AsyncAuthCheckCallBack {
    String TAG = "WVAsyncAuthCheckCallBackforJsBridge";

    @Override // android.taobao.windvane.jsbridge.WVAsyncAuthCheck.AsyncAuthCheckCallBack
    public void callBackFail(String str, WVCallMethodContext wVCallMethodContext) {
        WVJsBridge.startCall(3, wVCallMethodContext);
        TaoLog.w(this.TAG, "Async preprocessor callBackSuccess ,");
    }

    @Override // android.taobao.windvane.jsbridge.WVAsyncAuthCheck.AsyncAuthCheckCallBack
    public void callBackSuccess(String str, WVCallMethodContext wVCallMethodContext) {
        WVJsBridge.aftercallMethod(wVCallMethodContext, str);
        TaoLog.w(this.TAG, "Async preprocessor callBackSuccess ");
    }
}
