package android.taobao.windvane.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVJsBridge implements Handler.Callback {
    public static final int CALL_ALIAS = 7;
    public static final int CALL_DESTROY = 8;
    public static final int CALL_EXECUTE = 0;
    public static final int CALL_METHOD = 1;
    public static final int CLOSED = 4;
    public static final int ERROR_EXECUTE = 6;
    public static final int NO_CLASS = 5;
    public static final int NO_METHOD = 2;
    public static final int NO_PERMISSION = 3;
    private static final String TAG = "WVJsBridge";
    public static boolean enableGetParamByJs = true;
    private static Handler mHandler;
    private static WVJsBridge mJsBridge;
    private static ExecutorService sExecutors;
    private boolean mSkipPreprocess;
    private boolean enabled = true;
    private boolean isInit = false;
    public ArrayList<WVCallMethodContext> mTailBridges = null;

    private WVJsBridge() {
        mHandler = new Handler(Looper.getMainLooper(), this);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        sExecutors = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void aftercallMethod(WVCallMethodContext wVCallMethodContext, String str) {
        Map<String, String> originalPlugin = WVPluginManager.getOriginalPlugin(wVCallMethodContext.objectName, wVCallMethodContext.methodName);
        if (originalPlugin != null) {
            if (TaoLog.getLogStatus()) {
                TaoLog.i(TAG, "call method through alias name. newObject: " + originalPlugin.get("name") + " newMethod: " + originalPlugin.get("method"));
            }
            wVCallMethodContext.objectName = originalPlugin.get("name");
            wVCallMethodContext.methodName = originalPlugin.get("method");
            startCall(7, wVCallMethodContext);
        }
        Object jsObject = wVCallMethodContext.webview.getJsObject(wVCallMethodContext.objectName);
        if (jsObject != null) {
            if (jsObject instanceof WVApiPlugin) {
                wVCallMethodContext.classinstance = jsObject;
                startCall(0, wVCallMethodContext);
                return;
            } else if (jsObject instanceof String) {
                TaoLog.e(TAG, "cannot call method for context is null");
                startCall(8, wVCallMethodContext);
                return;
            } else {
                try {
                    if (wVCallMethodContext.methodName != null) {
                        Method method = jsObject.getClass().getMethod(wVCallMethodContext.methodName, Object.class, String.class);
                        if (method.isAnnotationPresent(WindVaneInterface.class)) {
                            wVCallMethodContext.classinstance = jsObject;
                            wVCallMethodContext.method = method;
                            startCall(1, wVCallMethodContext);
                            return;
                        }
                        TaoLog.w(TAG, "callMethod: Method " + wVCallMethodContext.methodName + " didn't has @WindVaneInterface annotation, obj=" + wVCallMethodContext.objectName);
                        return;
                    }
                    return;
                } catch (NoSuchMethodException unused) {
                    TaoLog.e(TAG, "callMethod: Method " + wVCallMethodContext.methodName + " didn't found. It must has two parameter, Object.class and String.class, obj=" + wVCallMethodContext.objectName);
                    return;
                }
            }
        }
        TaoLog.w(TAG, "callMethod: Plugin " + wVCallMethodContext.objectName + " didn't found, you should call WVPluginManager.registerPlugin first.");
        startCall(5, wVCallMethodContext);
    }

    public static synchronized WVJsBridge getInstance() {
        WVJsBridge wVJsBridge;
        synchronized (WVJsBridge.class) {
            if (mJsBridge == null) {
                mJsBridge = new WVJsBridge();
            }
            wVJsBridge = mJsBridge;
        }
        return wVJsBridge;
    }

    private WVCallMethodContext getRequest(String str) {
        if (str != null && str.startsWith("hybrid://")) {
            try {
                WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
                int indexOf = str.indexOf(58, 9);
                wVCallMethodContext.objectName = str.substring(9, indexOf);
                int indexOf2 = str.indexOf(47, indexOf);
                wVCallMethodContext.token = str.substring(indexOf + 1, indexOf2);
                int indexOf3 = str.indexOf(63, indexOf2);
                if (indexOf3 > 0) {
                    wVCallMethodContext.methodName = str.substring(indexOf2 + 1, indexOf3);
                    wVCallMethodContext.params = str.substring(indexOf3 + 1);
                } else {
                    wVCallMethodContext.methodName = str.substring(indexOf2 + 1);
                }
                if (wVCallMethodContext.objectName.length() > 0 && wVCallMethodContext.token.length() > 0) {
                    if (wVCallMethodContext.methodName.length() > 0) {
                        return wVCallMethodContext;
                    }
                }
            } catch (StringIndexOutOfBoundsException unused) {
            }
        }
        return null;
    }

    public static void startCall(int i, WVCallMethodContext wVCallMethodContext) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = wVCallMethodContext;
        mHandler.sendMessage(obtain);
    }

    public void callMethod(IWVWebView iWVWebView, String str) {
        callMethod(iWVWebView, str, null, null);
    }

    public void destroy() {
        this.isInit = false;
    }

    public void exCallMethod(WVPluginEntryManager wVPluginEntryManager, WVCallMethodContext wVCallMethodContext, IJsApiFailedCallBack iJsApiFailedCallBack, IJsApiSucceedCallBack iJsApiSucceedCallBack) {
        if (wVCallMethodContext != null) {
            wVCallMethodContext.failedCallBack = iJsApiFailedCallBack;
            wVCallMethodContext.succeedCallBack = iJsApiSucceedCallBack;
            if (TextUtils.isEmpty(wVCallMethodContext.params)) {
                wVCallMethodContext.params = "{}";
            }
            TaoLog.i(TAG, "before call object=[" + wVCallMethodContext.objectName + "].");
            String str = wVCallMethodContext.objectName;
            if (str != null) {
                Object entry = wVPluginEntryManager.getEntry(str);
                wVCallMethodContext.classinstance = entry;
                if (entry instanceof WVApiPlugin) {
                    startCall(0, wVCallMethodContext);
                } else {
                    startCall(2, wVCallMethodContext);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        WVCallMethodContext wVCallMethodContext = (WVCallMethodContext) message.obj;
        if (wVCallMethodContext == null) {
            TaoLog.e(TAG, "CallMethodContext is null, and do nothing.");
            return false;
        }
        WVCallBackContext wVCallBackContext = new WVCallBackContext(wVCallMethodContext.webview, wVCallMethodContext.token, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.succeedCallBack, wVCallMethodContext.failedCallBack);
        Object obj = wVCallMethodContext.classinstance;
        if (obj != null) {
            wVCallBackContext.setInstancename(obj.getClass().getName());
        }
        str = "{}";
        switch (message.what) {
            case 0:
                Object obj2 = wVCallMethodContext.classinstance;
                StringBuilder sb = new StringBuilder();
                sb.append("call method=[");
                sb.append(wVCallMethodContext.objectName);
                sb.append(".");
                sb.append(wVCallMethodContext.methodName);
                sb.append("], object=[");
                sb.append(obj2 == null ? null : obj2.getClass().getSimpleName());
                sb.append("].");
                TaoLog.i(TAG, sb.toString());
                if (!((WVApiPlugin) obj2).executeSafe(wVCallMethodContext.methodName, TextUtils.isEmpty(wVCallMethodContext.params) ? "{}" : wVCallMethodContext.params, wVCallBackContext)) {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.w(TAG, "WVApiPlugin execute failed.object:" + wVCallMethodContext.objectName + ", method: " + wVCallMethodContext.methodName);
                    }
                    startCall(6, wVCallMethodContext);
                } else {
                    try {
                        ConcurrentHashMap<String, Integer> concurrentHashMap = IWVWebView.JsbridgeHis;
                        int i = 1;
                        String str2 = wVCallMethodContext.objectName + "." + wVCallMethodContext.methodName;
                        if (concurrentHashMap.containsKey(str2)) {
                            i = Integer.valueOf(concurrentHashMap.get(str2).intValue() + 1);
                        }
                        concurrentHashMap.put(str2, i);
                    } catch (Exception unused) {
                    }
                }
                return true;
            case 1:
                Object obj3 = wVCallMethodContext.classinstance;
                try {
                    Method method = wVCallMethodContext.method;
                    Object[] objArr = new Object[2];
                    objArr[0] = wVCallBackContext;
                    if (!TextUtils.isEmpty(wVCallMethodContext.params)) {
                        str = wVCallMethodContext.params;
                    }
                    objArr[1] = str;
                    method.invoke(obj3, objArr);
                } catch (Exception e) {
                    TaoLog.e(TAG, "call method " + wVCallMethodContext.method + " exception. " + e.getMessage());
                }
                return true;
            case 2:
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.NO_METHOD);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No Method Error: method=[");
                sb2.append(wVCallMethodContext.objectName);
                sb2.append(".");
                sb2.append(wVCallMethodContext.methodName);
                sb2.append("],url=[");
                sb2.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb2.append(jn1.ARRAY_END_STR);
                wVResult.addData("msg", sb2.toString());
                wVCallBackContext.error(wVResult);
                return true;
            case 3:
                WVResult wVResult2 = new WVResult();
                wVResult2.setResult(WVResult.NO_PERMISSION);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("method=[");
                sb3.append(wVCallMethodContext.objectName);
                sb3.append(".");
                sb3.append(wVCallMethodContext.methodName);
                sb3.append("],url=[");
                sb3.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb3.append(jn1.ARRAY_END_STR);
                wVResult2.addData("msg", sb3.toString());
                wVCallBackContext.error(wVResult2);
                return true;
            case 4:
                WVResult wVResult3 = new WVResult();
                wVResult3.setResult(WVResult.CLOSED);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("method=[");
                sb4.append(wVCallMethodContext.objectName);
                sb4.append(".");
                sb4.append(wVCallMethodContext.methodName);
                sb4.append("],url=[");
                sb4.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb4.append(jn1.ARRAY_END_STR);
                wVResult3.addData("msg", sb4.toString());
                wVCallBackContext.error(wVResult3);
                return true;
            case 5:
                WVResult wVResult4 = new WVResult();
                wVResult4.setResult(WVResult.NO_METHOD);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("No Class Error: method=[");
                sb5.append(wVCallMethodContext.objectName);
                sb5.append(".");
                sb5.append(wVCallMethodContext.methodName);
                sb5.append("],url=[");
                sb5.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb5.append(jn1.ARRAY_END_STR);
                wVResult4.addData("msg", sb5.toString());
                wVCallBackContext.error(wVResult4);
                return true;
            case 6:
                WVResult wVResult5 = new WVResult();
                wVResult5.setResult(WVResult.NO_METHOD);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Execute error:method=[");
                sb6.append(wVCallMethodContext.objectName);
                sb6.append(".");
                sb6.append(wVCallMethodContext.methodName);
                sb6.append("],url=[");
                sb6.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                sb6.append(jn1.ARRAY_END_STR);
                wVResult5.addData("msg", sb6.toString());
                wVCallBackContext.error(wVResult5);
                return true;
            case 7:
                WVResult wVResult6 = new WVResult();
                wVResult6.setResult("CALL_ALIAS");
                wVResult6.addData("msg", wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                wVResult6.setSuccess();
                wVCallBackContext.commitJsBridgeReturn(wVResult6);
                return true;
            case 8:
                WVResult wVResult7 = new WVResult();
                wVResult7.setResult("HY_FAILED");
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Null Context Error:");
                sb7.append(wVCallBackContext.getWebview() != null ? wVCallBackContext.getWebview().getUrl() : "");
                wVResult7.addData("msg", sb7.toString());
                wVCallBackContext.error(wVResult7);
                return true;
            default:
                return false;
        }
    }

    public synchronized void init() {
        this.isInit = true;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void skipPreprocess() {
        this.mSkipPreprocess = true;
    }

    public synchronized void tryToRunTailBridges() {
        ArrayList<WVCallMethodContext> arrayList = this.mTailBridges;
        if (arrayList != null) {
            Iterator<WVCallMethodContext> it = arrayList.iterator();
            while (it.hasNext()) {
                WVCallMethodContext next = it.next();
                aftercallMethod(next, "");
                TaoLog.i(TAG, "excute TailJSBridge : " + next.objectName + " : " + next.methodName);
            }
            this.mTailBridges.clear();
            this.mTailBridges = null;
        }
    }

    private void callMethod(IWVWebView iWVWebView, String str, IJsApiSucceedCallBack iJsApiSucceedCallBack, IJsApiFailedCallBack iJsApiFailedCallBack) {
        boolean z;
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "callMethod: url=" + str);
        }
        if (!this.isInit) {
            TaoLog.w(TAG, "jsbridge is not init.");
            return;
        }
        final WVCallMethodContext request = getRequest(str);
        if (request == null) {
            TaoLog.w(TAG, "url format error and call canceled. url=" + str);
            return;
        }
        request.webview = iWVWebView;
        if (iJsApiSucceedCallBack != null) {
            request.succeedCallBack = iJsApiSucceedCallBack;
        }
        if (iJsApiFailedCallBack != null) {
            request.failedCallBack = iJsApiFailedCallBack;
        }
        final String url = iWVWebView.getUrl();
        if (enableGetParamByJs) {
            try {
                JSON.parse(request.params);
                z = false;
            } catch (Throwable th) {
                if (WVMonitorService.getJsBridgeMonitor() != null) {
                    WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
                    String message = th.getMessage();
                    String str2 = request.params;
                    jsBridgeMonitor.commitParamParseError(url, message, str2, request.objectName + "." + request.methodName);
                }
                z = true;
            }
            if (z) {
                iWVWebView.evaluateJavascript(String.format("javascript:window.WindVane&&window.WindVane.getParam(%s);", request.token), new ValueCallback<String>() { // from class: android.taobao.windvane.jsbridge.WVJsBridge.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str3) {
                        if (str3.startsWith("\"")) {
                            str3 = JSON.parse(str3).toString();
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            request.params = str3;
                        }
                        WVJsBridge.sExecutors.submit(new Runnable() { // from class: android.taobao.windvane.jsbridge.WVJsBridge.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                WVJsBridge.this.callMethod(request, url);
                            }
                        });
                    }
                });
                return;
            }
        }
        sExecutors.submit(new Runnable() { // from class: android.taobao.windvane.jsbridge.WVJsBridge.2
            @Override // java.lang.Runnable
            public void run() {
                WVJsBridge.this.callMethod(request, url);
            }
        });
    }

    public void callMethod(WVCallMethodContext wVCallMethodContext, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d(TAG, "callMethod-obj:" + wVCallMethodContext.objectName + " method:" + wVCallMethodContext.methodName + " param:" + wVCallMethodContext.params + " sid:" + wVCallMethodContext.token);
        }
        if (this.enabled && wVCallMethodContext.webview != null) {
            if (!this.mSkipPreprocess) {
                if (WVJsbridgeService.getPagePreprocessors() != null && !WVJsbridgeService.getPagePreprocessors().isEmpty()) {
                    for (WVJSAPIPageAuth wVJSAPIPageAuth : WVJsbridgeService.getPagePreprocessors()) {
                        if (wVJSAPIPageAuth.needAuth(wVCallMethodContext.webview)) {
                            if (wVJSAPIPageAuth.apiAuthCheck(str, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.params)) {
                                aftercallMethod(wVCallMethodContext, str);
                                return;
                            } else {
                                startCall(3, wVCallMethodContext);
                                return;
                            }
                        }
                    }
                }
                if (WVJsbridgeService.getJSBridgePreprocessors() != null && !WVJsbridgeService.getJSBridgePreprocessors().isEmpty()) {
                    for (WVJSAPIAuthCheck wVJSAPIAuthCheck : WVJsbridgeService.getJSBridgePreprocessors()) {
                        if (!wVJSAPIAuthCheck.apiAuthCheck(str, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.params)) {
                            TaoLog.w(TAG, "preprocessor call fail, callMethod cancel.");
                            startCall(3, wVCallMethodContext);
                            return;
                        }
                    }
                }
                if (WVJsbridgeService.getJSBridgeayncPreprocessors() != null && !WVJsbridgeService.getJSBridgeayncPreprocessors().isEmpty()) {
                    for (WVAsyncAuthCheck wVAsyncAuthCheck : WVJsbridgeService.getJSBridgeayncPreprocessors()) {
                        if (wVAsyncAuthCheck.AsyncapiAuthCheck(str, wVCallMethodContext, new WVAsyncAuthCheckCallBackforJsBridge())) {
                            TaoLog.w(TAG, "enter  WVAsyncAuthCheck preprocessor  ");
                            return;
                        }
                    }
                }
            }
            aftercallMethod(wVCallMethodContext, str);
            return;
        }
        TaoLog.w(TAG, "jsbridge is closed.");
        startCall(4, wVCallMethodContext);
    }
}
