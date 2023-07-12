package com.ali.user.open.core.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ali.user.open.core.trace.SDKLogger;
import java.lang.reflect.Method;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BridgeWebChromeClient extends WebChromeClient {
    private static final String TAG = BridgeWebChromeClient.class.getSimpleName();
    private static boolean evaluateJavascriptSupported;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class JavaScriptTask implements Runnable {
        public String script;
        public WebView webView;

        public JavaScriptTask(WebView webView, String str) {
            this.webView = webView;
            this.script = str;
            if (webView != null) {
                try {
                    webView.getSettings().setSavePassword(false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // java.lang.Runnable
        @TargetApi(19)
        public void run() {
            try {
                if (BridgeWebChromeClient.evaluateJavascriptSupported) {
                    try {
                        this.webView.evaluateJavascript(this.script, null);
                        return;
                    } catch (Exception e) {
                        SDKLogger.e("ui", "fail to evaluate the script " + e.getMessage(), e);
                    }
                }
                String str = "javascript:" + this.script;
                WebView webView = this.webView;
                if (webView instanceof MemberWebView) {
                    ((MemberWebView) webView).loadUrl(str);
                } else {
                    webView.loadUrl(str);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        evaluateJavascriptSupported = Build.VERSION.SDK_INT >= 19;
    }

    private void handleWindVaneNoHandler(WebView webView, String str) {
        try {
            int indexOf = str.indexOf(58, 9);
            webView.post(new JavaScriptTask(webView, String.format("window.WindVane&&window.WindVane.onFailure(%s,'{\"ret\":\"HY_NO_HANDLER\"');", str.substring(indexOf + 1, str.indexOf(47, indexOf)))));
        } catch (Exception e) {
            SDKLogger.e("ui", "fail to handler windvane request, the error message is " + e.getMessage(), e);
        }
    }

    private HavanaBridgeProtocal parseMessage(String str) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        int port = parse.getPort();
        String lastPathSegment = parse.getLastPathSegment();
        parse.getQuery();
        int indexOf = str.indexOf("?");
        String substring = indexOf == -1 ? null : str.substring(indexOf + 1);
        HavanaBridgeProtocal havanaBridgeProtocal = new HavanaBridgeProtocal();
        havanaBridgeProtocal.methodName = lastPathSegment;
        havanaBridgeProtocal.objName = host;
        havanaBridgeProtocal.param = substring;
        havanaBridgeProtocal.requestId = port;
        return havanaBridgeProtocal;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null) {
            return false;
        }
        String str4 = TAG;
        SDKLogger.d(str4, "onJsPrompt() called with: view = [" + webView + "], url = [" + str + "], message = [" + str2 + "], defaultValue = [" + str3 + "], result = [" + jsPromptResult + jn1.ARRAY_END_STR);
        if (str3.equals("wv_hybrid:")) {
            handleWindVaneNoHandler(webView, str2);
            jsPromptResult.confirm("");
            return true;
        } else if (TextUtils.equals(str3, "hv_hybrid:") && (webView instanceof MemberWebView)) {
            MemberWebView memberWebView = (MemberWebView) webView;
            HavanaBridgeProtocal parseMessage = parseMessage(str2);
            BridgeCallbackContext bridgeCallbackContext = new BridgeCallbackContext();
            bridgeCallbackContext.requestId = parseMessage.requestId;
            bridgeCallbackContext.webView = memberWebView;
            Object bridgeObj = memberWebView.getBridgeObj(parseMessage.objName);
            if (bridgeObj == null) {
                SDKLogger.e(str4, parseMessage.objName + " JS_BRIDGE_MODULE_NOT_FOUND");
                bridgeCallbackContext.onFailure(10000, parseMessage.objName);
                jsPromptResult.confirm("");
                return true;
            }
            try {
                Method method = bridgeObj.getClass().getMethod(parseMessage.methodName, BridgeCallbackContext.class, String.class);
                if (method.isAnnotationPresent(BridgeMethod.class)) {
                    try {
                        Object[] objArr = new Object[2];
                        objArr[0] = bridgeCallbackContext;
                        objArr[1] = TextUtils.isEmpty(parseMessage.param) ? "{}" : parseMessage.param;
                        method.invoke(bridgeObj, objArr);
                    } catch (Exception e) {
                        SDKLogger.e(TAG, e.toString());
                        bridgeCallbackContext.onFailure(10010, e.getMessage());
                    }
                } else {
                    SDKLogger.e(str4, parseMessage.objName + "," + parseMessage.methodName + "  JS_BRIDGE_ANNOTATION_NOT_PRESENT");
                    bridgeCallbackContext.onFailure(952, parseMessage.objName);
                }
                jsPromptResult.confirm("");
                return true;
            } catch (NoSuchMethodException e2) {
                String str5 = TAG;
                SDKLogger.e(str5, parseMessage.objName + "," + parseMessage.methodName + "," + e2.toString());
                bridgeCallbackContext.onFailure(951, parseMessage.objName);
                jsPromptResult.confirm("");
                return true;
            }
        } else {
            return false;
        }
    }
}
