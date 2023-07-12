package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.InvokeObject;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public abstract class JSInterface implements InvokeObject {
    private Object a;
    private Object b;
    private JSRoute c;

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public class JSRoute implements InvokeObject {
        private Object b;

        JSRoute(Object obj) {
            this.b = obj;
        }

        @Override // com.uc.webview.export.internal.interfaces.InvokeObject
        public Object invoke(int i, Object[] objArr) {
            return null;
        }

        public void send(Object[] objArr, ValueCallback<Boolean> valueCallback) {
            try {
                UCCore.sendMessageToJS(this.b, objArr, valueCallback);
            } catch (Exception e) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(Boolean.FALSE);
                }
                Log.e("JSInterface", "send", e);
            }
        }
    }

    public JSInterface() {
        try {
            this.a = UCCore.createJSInterface(this);
        } catch (Exception e) {
            Log.e("JSInterface", "JSInterface", e);
        }
    }

    @Reflection
    public Object getImpl() {
        return this.a;
    }

    public JSRoute getJSRoute() {
        try {
            Object jSRoute = UCCore.getJSRoute(this.a);
            if (jSRoute != this.b) {
                this.b = jSRoute;
                this.c = new JSRoute(jSRoute);
            }
            return this.c;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } catch (Exception e2) {
            Log.e("JSInterface", "getJSRoute", e2);
            return null;
        }
    }

    public String getUrl() {
        try {
            return UCCore.getUrlFromJSInterface(this.a);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } catch (Exception e2) {
            Log.e("JSInterface", "getUrl", e2);
            return null;
        }
    }

    @Override // com.uc.webview.export.internal.interfaces.InvokeObject
    public Object invoke(int i, Object[] objArr) {
        return null;
    }
}
