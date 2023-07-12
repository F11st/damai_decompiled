package android.taobao.windvane.jsbridge;

import android.os.Looper;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVCallBackContext {
    private static final String TAG = "WVCallBackContext";
    private IJsApiFailedCallBack failedCallBack;
    private String instancename;
    private String methodname;
    private String objectname;
    private IJsApiSucceedCallBack succeedCallBack;
    private String token;
    private IWVWebView webview;
    private boolean mNotiNavtive = false;
    private String mAction = null;

    public WVCallBackContext(IWVWebView iWVWebView) {
        this.webview = iWVWebView;
    }

    private static void callback(final IWVWebView iWVWebView, String str, String str2) {
        if (TaoLog.getLogStatus() && EnvUtil.isDebug() && !TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
                TaoLog.e(TAG, "return param is not a valid json!\n" + str + StringUtils.LF + str2);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        try {
            final String format = String.format(str, formatJsonString(str2));
            try {
                runOnUiThread(iWVWebView, new Runnable() { // from class: android.taobao.windvane.jsbridge.WVCallBackContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IWVWebView.this.evaluateJavascript(format);
                    }
                });
            } catch (Exception e) {
                TaoLog.w(TAG, e.getMessage());
            }
        } catch (Exception e2) {
            TaoLog.e(TAG, "callback error. " + e2.getMessage());
        }
    }

    private static String formatJsonString(String str) {
        if (str.contains("\u2028")) {
            try {
                str = str.replace("\u2028", "\\u2028");
            } catch (Exception unused) {
            }
        }
        if (str.contains("\u2029")) {
            try {
                str = str.replace("\u2029", "\\u2029");
            } catch (Exception unused2) {
            }
        }
        return str.replace("\\", "\\\\").replace("'", "\\'");
    }

    private static void runOnUiThread(IWVWebView iWVWebView, Runnable runnable) {
        if (iWVWebView == null || iWVWebView.getView() == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        try {
            iWVWebView._post(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void commitJsBridgeReturn(WVResult wVResult) {
        try {
            String str = "" + this.objectname + "." + this.methodname;
            String str2 = this.instancename;
            String str3 = wVResult.get("ret", "HY_FAILED_EMPTY");
            String str4 = wVResult.get("msg", "");
            IWVWebView iWVWebView = this.webview;
            String url = iWVWebView == null ? "unknown" : iWVWebView.getUrl();
            if (WVMonitorService.getJsBridgeMonitor() != null) {
                WVMonitorService.getJsBridgeMonitor().onJsBridgeReturn(str, str2, str3, str4, url);
            }
        } catch (Throwable unused) {
        }
    }

    public void error() {
        error("{}");
    }

    public void fireEvent(String str, String str2) {
        TaoLog.d(TAG, "call fireEvent ");
        WVEventService.getInstance().onEvent(3013, this.mAction, str, str2);
        callback(this.webview, String.format("window.WindVane && window.WindVane.fireEvent('%s', '%%s', %s);", str, null), str2);
    }

    public String getToken() {
        return this.token;
    }

    public IWVWebView getWebview() {
        return this.webview;
    }

    public void setInstancename(String str) {
        this.instancename = str;
    }

    public void setNeedfireNativeEvent(String str, boolean z) {
        this.mAction = str;
        this.mNotiNavtive = z;
        TaoLog.e(TAG, "setNeedfireNativeEvent : " + str);
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setWebview(IWVWebView iWVWebView) {
        this.webview = iWVWebView;
    }

    public void success() {
        success(WVResult.RET_SUCCESS);
    }

    public void successAndKeepAlive(String str) {
        TaoLog.d(TAG, "call success and keep alive");
        IJsApiSucceedCallBack iJsApiSucceedCallBack = this.succeedCallBack;
        if (iJsApiSucceedCallBack != null && (iJsApiSucceedCallBack instanceof IExtJsApiSuccessCallBack)) {
            ((IExtJsApiSuccessCallBack) iJsApiSucceedCallBack).successAndKeepAlive(str);
        } else {
            callback(this.webview, String.format("javascript:window.WindVane&&window.WindVane.onSuccess('%s','%%s', true);", this.token), str);
        }
    }

    public void error(WVResult wVResult) {
        if (wVResult != null) {
            error(wVResult.toJsonString());
            commitJsBridgeReturn(wVResult);
        }
    }

    public void success(WVResult wVResult) {
        if (wVResult != null) {
            wVResult.setSuccess();
            success(wVResult.toJsonString());
            commitJsBridgeReturn(wVResult);
        }
    }

    public static void fireEvent(IWVWebView iWVWebView, String str, String str2) {
        TaoLog.d(TAG, "call fireEvent ");
        WVEventService.getInstance().onEvent(3013, null, str, str2);
        callback(iWVWebView, String.format("window.WindVane && window.WindVane.fireEvent('%s', '%%s', %s);", str, null), str2);
    }

    public WVCallBackContext(IWVWebView iWVWebView, String str, String str2, String str3) {
        this.webview = iWVWebView;
        this.token = str;
        this.objectname = str2;
        this.methodname = str3;
    }

    public void error(String str, String str2) {
        WVResult wVResult = new WVResult("HY_FAILED");
        wVResult.addData(str, str2);
        error(wVResult);
    }

    public void success(String str) {
        TaoLog.d(TAG, "call success ");
        IJsApiSucceedCallBack iJsApiSucceedCallBack = this.succeedCallBack;
        if (iJsApiSucceedCallBack != null) {
            iJsApiSucceedCallBack.succeed(str);
            return;
        }
        if (this.mNotiNavtive) {
            WVEventService.getInstance().onEvent(3011, null, this.webview.getUrl(), this.mAction, str);
            this.mNotiNavtive = false;
            this.mAction = null;
        }
        callback(this.webview, String.format("javascript:window.WindVane&&window.WindVane.onSuccess(%s,'%%s');", this.token), str);
    }

    public void fireEvent(String str) {
        fireEvent(str, "{}");
    }

    public void error(String str) {
        TaoLog.d(TAG, "call error ");
        IJsApiFailedCallBack iJsApiFailedCallBack = this.failedCallBack;
        if (iJsApiFailedCallBack != null) {
            iJsApiFailedCallBack.fail(str);
            return;
        }
        if (this.mNotiNavtive) {
            WVEventService.getInstance().onEvent(3012, null, this.webview.getUrl(), this.mAction, str);
            this.mNotiNavtive = false;
            this.mAction = null;
        }
        callback(this.webview, String.format("javascript:window.WindVane&&window.WindVane.onFailure(%s,'%%s');", this.token), str);
    }

    public WVCallBackContext(IWVWebView iWVWebView, String str, String str2, String str3, IJsApiSucceedCallBack iJsApiSucceedCallBack, IJsApiFailedCallBack iJsApiFailedCallBack) {
        this.webview = iWVWebView;
        this.token = str;
        this.objectname = str2;
        this.methodname = str3;
        this.failedCallBack = iJsApiFailedCallBack;
        this.succeedCallBack = iJsApiSucceedCallBack;
    }
}
