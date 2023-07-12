package com.taobao.weex.jsEngine;

import com.taobao.weex.base.CalledByNative;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.utils.WXLogUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class JSContext implements Serializable {
    private ConcurrentHashMap<String, JSFunction> funcMap = new ConcurrentHashMap<>();
    private long mNativeContextPtr = 0;
    private JSException mExceptionTransfer = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public JSContext() {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.jsEngine.JSContext.1
            @Override // java.lang.Runnable
            public void run() {
                JSContext jSContext = JSContext.this;
                jSContext.mNativeContextPtr = jSContext.nativeCreateContext();
                JSEngine.mCreatedJSContext.put(Long.valueOf(JSContext.this.mNativeContextPtr), JSContext.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeBindFunc(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native long nativeCreateContext();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDestroyContext(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeExecJS(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUnBindFunc(long j, String str);

    public void Eval(final String str) {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.jsEngine.JSContext.5
            @Override // java.lang.Runnable
            public void run() {
                JSContext jSContext = JSContext.this;
                jSContext.nativeExecJS(jSContext.mNativeContextPtr, str);
            }
        });
    }

    @CalledByNative
    public void Exception(String str) {
        JSException jSException;
        if (str == null || (jSException = this.mExceptionTransfer) == null) {
            return;
        }
        jSException.exception(str);
    }

    @CalledByNative
    public String Invoke(String str, String str2) {
        JSFunction jSFunction = this.funcMap.get(str);
        if (jSFunction != null) {
            WXLogUtils.d("jsEngine invoke " + str + " arg:" + str2);
            return jSFunction.invoke(str2);
        }
        return "";
    }

    public void bindFunction(final String str, final JSFunction jSFunction) {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.jsEngine.JSContext.3
            @Override // java.lang.Runnable
            public void run() {
                JSContext.this.funcMap.put(str, jSFunction);
                JSContext jSContext = JSContext.this;
                jSContext.nativeBindFunc(jSContext.mNativeContextPtr, str);
            }
        });
    }

    public void destroy() {
        JSEngine.mCreatedJSContext.remove(Long.valueOf(this.mNativeContextPtr));
        this.mExceptionTransfer = null;
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.jsEngine.JSContext.2
            @Override // java.lang.Runnable
            public void run() {
                if (JSContext.this.mNativeContextPtr != 0) {
                    long j = JSContext.this.mNativeContextPtr;
                    JSContext.this.mNativeContextPtr = 0L;
                    JSContext.this.nativeDestroyContext(j);
                }
            }
        });
    }

    public void registerException(JSException jSException) {
        this.mExceptionTransfer = jSException;
    }

    public void unBindFunction(final String str) {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.jsEngine.JSContext.4
            @Override // java.lang.Runnable
            public void run() {
                JSContext.this.funcMap.remove(str);
                JSContext jSContext = JSContext.this;
                jSContext.nativeUnBindFunc(jSContext.mNativeContextPtr, str);
            }
        });
    }
}
