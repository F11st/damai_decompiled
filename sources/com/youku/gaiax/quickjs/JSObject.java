package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSObject extends JSValue {
    public static int PROP_FLAG_CONFIGURABLE = 1;
    public static int PROP_FLAG_ENUMERABLE = 4;
    private static final int PROP_FLAG_MASK = 7;
    public static int PROP_FLAG_WRITABLE = 2;
    private final Object javaObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSObject(long j, JSContext jSContext, Object obj) {
        super(j, jSContext);
        this.javaObject = obj;
    }

    public void defineProperty(int i, JSValue jSValue, int i2) {
        if ((i2 & (-8)) == 0) {
            synchronized (this.jsContext.jsRuntime) {
                this.jsContext.checkClosed();
                if (!QuickJS.defineValueProperty(this.jsContext.pointer, this.pointer, i, jSValue.pointer, i2)) {
                    throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flags: " + i2);
    }

    public void dupValue() {
        QuickJS.dupValue(this.jsContext.pointer, this.pointer);
    }

    public void freeValue() {
        QuickJS.freeValue(this.jsContext.pointer, this.pointer);
    }

    public Object getJavaObject() {
        return this.javaObject;
    }

    public JSValue getProperty(int i) {
        JSValue wrapAsJSValue;
        synchronized (this.jsContext.jsRuntime) {
            wrapAsJSValue = this.jsContext.wrapAsJSValue(QuickJS.getValueProperty(this.jsContext.checkClosed(), this.pointer, i));
        }
        return wrapAsJSValue;
    }

    public boolean isValueFunction() {
        return QuickJS.isValueFunction(this.jsContext.pointer, this.pointer);
    }

    public void setProperty(int i, JSValue jSValue) {
        checkSameJSContext(jSValue);
        synchronized (this.jsContext.jsRuntime) {
            this.jsContext.checkClosed();
            if (!QuickJS.setValueProperty(this.jsContext.pointer, this.pointer, i, jSValue.pointer)) {
                throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
            }
        }
    }

    public JSValue getProperty(String str) {
        JSValue wrapAsJSValue;
        synchronized (this.jsContext.jsRuntime) {
            wrapAsJSValue = this.jsContext.wrapAsJSValue(QuickJS.getValueProperty(this.jsContext.checkClosed(), this.pointer, str));
        }
        return wrapAsJSValue;
    }

    public void defineProperty(String str, JSValue jSValue, int i) {
        if ((i & (-8)) == 0) {
            synchronized (this.jsContext.jsRuntime) {
                this.jsContext.checkClosed();
                if (!QuickJS.defineValueProperty(this.jsContext.pointer, this.pointer, str, jSValue.pointer, i)) {
                    throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flags: " + i);
    }

    public void setProperty(String str, JSValue jSValue) {
        checkSameJSContext(jSValue);
        synchronized (this.jsContext.jsRuntime) {
            this.jsContext.checkClosed();
            if (!QuickJS.setValueProperty(this.jsContext.pointer, this.pointer, str, jSValue.pointer)) {
                throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
            }
        }
    }
}
