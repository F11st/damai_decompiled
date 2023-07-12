package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import com.youku.gaiax.quickjs.adapter.TypeAdapter;
import java.io.Closeable;
import java.util.Objects;
import tb.r10;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSContext implements TypeAdapter.Context, Closeable {
    private static final int EVAL_FLAG_MASK = 24;
    public static final int EVAL_FLAG_STRICT = 8;
    public static final int EVAL_FLAG_STRIP = 16;
    public static final int EVAL_TYPE_GLOBAL = 0;
    public static final int EVAL_TYPE_MODULE = 1;
    static final int TYPE_BOOLEAN = 1;
    static final int TYPE_EXCEPTION = 6;
    static final int TYPE_FLOAT64 = 7;
    static final int TYPE_INT = 0;
    static final int TYPE_NULL = 2;
    static final int TYPE_OBJECT = -1;
    static final int TYPE_STRING = -7;
    static final int TYPE_SYMBOL = -8;
    static final int TYPE_UNDEFINED = 3;
    private final NativeCleaner<JSValue> cleaner = new JSValueCleaner();
    final JSRuntime jsRuntime;
    public long pointer;
    final QuickJS quickJS;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private class JSValueCleaner extends NativeCleaner<JSValue> {
        private JSValueCleaner() {
        }

        @Override // com.youku.gaiax.quickjs.NativeCleaner
        public void onRemove(long j) {
            QuickJS.destroyValue(JSContext.this.pointer, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSContext(long j, QuickJS quickJS, JSRuntime jSRuntime) {
        this.pointer = j;
        this.quickJS = quickJS;
        this.jsRuntime = jSRuntime;
    }

    private void checkArrayBounds(int i, int i2, int i3) {
        if (i2 < 0 || i3 <= 0 || i2 + i3 > i) {
            throw new IndexOutOfBoundsException("start = " + i2 + ", length = " + i3 + ", but array.length = " + i);
        }
    }

    private <T> T evaluateInternal(String str, String str2, int i, int i2, TypeAdapter<T> typeAdapter) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid type: " + i);
        } else if ((i2 & (-25)) == 0) {
            synchronized (this.jsRuntime) {
                checkClosed();
                long evaluate = QuickJS.evaluate(this.pointer, str, str2, i | i2);
                if (typeAdapter != null) {
                    return typeAdapter.fromJSValue(this.quickJS, this, wrapAsJSValue(evaluate));
                } else if (QuickJS.getValueTag(evaluate) != 6) {
                    QuickJS.destroyValue(this.pointer, evaluate);
                    return null;
                } else {
                    throw new JSEvaluationException(QuickJS.getException(this.pointer));
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid flags: " + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long checkClosed() {
        if (this.pointer != 0) {
            this.cleaner.clean();
            return this.pointer;
        }
        throw new IllegalStateException("The JSContext is closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.jsRuntime) {
            if (this.pointer != 0) {
                this.cleaner.forceClean();
                long j = this.pointer;
                this.pointer = 0L;
                QuickJS.destroyContext(j);
            }
        }
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSArray createJSArray() {
        JSArray jSArray;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArray = (JSArray) wrapAsJSValue(QuickJS.createValueArray(this.pointer)).cast(JSArray.class);
        }
        return jSArray;
    }

    public JSArrayBuffer createJSArrayBuffer(boolean[] zArr) {
        return createJSArrayBuffer(zArr, 0, zArr.length);
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSBoolean createJSBoolean(boolean z) {
        JSBoolean jSBoolean;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSBoolean = (JSBoolean) wrapAsJSValue(QuickJS.createValueBoolean(this.pointer, z)).cast(JSBoolean.class);
        }
        return jSBoolean;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSFunction createJSFunction(Object obj, Method method) {
        JSFunction jSFunction;
        Objects.requireNonNull(obj, "instance == null");
        Objects.requireNonNull(method, "method == null");
        synchronized (this.jsRuntime) {
            checkClosed();
            jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunction(this.pointer, this, obj, method.name, method.getSignature(), method.returnType, method.parameterTypes, false)).cast(JSFunction.class);
        }
        return jSFunction;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSFunction createJSFunctionS(Class cls, Method method) {
        JSFunction jSFunction;
        Objects.requireNonNull(cls, "clazz == null");
        Objects.requireNonNull(method, "method == null");
        String name = cls.getName();
        StringBuilder sb = new StringBuilder(name.length());
        for (int i = 0; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (charAt == '.') {
                charAt = r10.DIR;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        synchronized (this.jsRuntime) {
            checkClosed();
            jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunctionS(this.pointer, this, sb2, method.name, method.getSignature(), method.returnType, method.parameterTypes)).cast(JSFunction.class);
        }
        return jSFunction;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSObject createJSJsonObject(String str) {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueJson(this.pointer, str)).cast(JSObject.class);
        }
        return jSObject;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSNull createJSNull() {
        JSNull jSNull;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNull = (JSNull) wrapAsJSValue(QuickJS.createValueNull(this.pointer)).cast(JSNull.class);
        }
        return jSNull;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSNumber createJSNumber(int i) {
        JSNumber jSNumber;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueInt(this.pointer, i)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSObject createJSObject() {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueObject(this.pointer)).cast(JSObject.class);
        }
        return jSObject;
    }

    public JSObject createJSPromise(PromiseExecutor promiseExecutor) {
        JSValue wrapAsJSValue;
        JSValue wrapAsJSValue2;
        JSValue wrapAsJSValue3;
        synchronized (this.jsRuntime) {
            checkClosed();
            long[] createValuePromise = QuickJS.createValuePromise(this.pointer);
            if (createValuePromise != null) {
                for (long j : createValuePromise) {
                    if (QuickJS.getValueTag(j) == 6) {
                        for (long j2 : createValuePromise) {
                            QuickJS.destroyValue(this.pointer, j2);
                        }
                        throw new JSEvaluationException(QuickJS.getException(this.pointer));
                    }
                }
                wrapAsJSValue = wrapAsJSValue(createValuePromise[0]);
                wrapAsJSValue2 = wrapAsJSValue(createValuePromise[1]);
                wrapAsJSValue3 = wrapAsJSValue(createValuePromise[2]);
            } else {
                throw new NullPointerException("result == null");
            }
        }
        promiseExecutor.execute((JSFunction) wrapAsJSValue2.cast(JSFunction.class), (JSFunction) wrapAsJSValue3.cast(JSFunction.class));
        return (JSObject) wrapAsJSValue.cast(JSObject.class);
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSString createJSString(String str) {
        JSString jSString;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSString = (JSString) wrapAsJSValue(QuickJS.createValueString(this.pointer, str)).cast(JSString.class);
        }
        return jSString;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSUndefined createJSUndefined() {
        JSUndefined jSUndefined;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSUndefined = (JSUndefined) wrapAsJSValue(QuickJS.createValueUndefined(this.pointer)).cast(JSUndefined.class);
        }
        return jSUndefined;
    }

    public void evaluate(String str, String str2) {
        evaluateInternal(str, str2, 0, 0, null);
    }

    public boolean executePendingJob() {
        boolean z;
        synchronized (this.jsRuntime) {
            checkClosed();
            int executePendingJob = QuickJS.executePendingJob(this.pointer);
            if (executePendingJob < 0) {
                throw new JSEvaluationException(QuickJS.getException(this.pointer));
            }
            z = executePendingJob != 0;
        }
        return z;
    }

    public JSObject getGlobalObject() {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.getGlobalObject(this.pointer)).cast(JSObject.class);
        }
        return jSObject;
    }

    int getNotRemovedJSValueCount() {
        int size;
        synchronized (this.jsRuntime) {
            size = this.cleaner.size();
        }
        return size;
    }

    public void initModuleBridge(String str) {
        synchronized (this.jsRuntime) {
            checkClosed();
            QuickJS.initModuleBridge(this.pointer, str);
        }
    }

    public void initModuleOs() {
        synchronized (this.jsRuntime) {
            checkClosed();
            QuickJS.initModuleOs(this.pointer);
        }
    }

    public void initModuleStd() {
        synchronized (this.jsRuntime) {
            checkClosed();
            QuickJS.initModuleStd(this.pointer);
        }
    }

    public void registerBridgeModuleListener(BridgeModuleListener bridgeModuleListener) {
        synchronized (this.jsRuntime) {
            checkClosed();
            JNIBridgeModuleHelper.setListener(bridgeModuleListener);
        }
    }

    public JSValue wrapAsJSValue(long j) {
        JSValue jSSymbol;
        try {
            if (j != 0) {
                int valueTag = QuickJS.getValueTag(j);
                if (valueTag == -8) {
                    jSSymbol = new JSSymbol(j, this);
                } else if (valueTag == -7) {
                    jSSymbol = new JSString(j, this, QuickJS.getValueString(this.pointer, j));
                } else if (valueTag != -1) {
                    if (valueTag == 0) {
                        jSSymbol = new JSInt(j, this, QuickJS.getValueInt(j));
                    } else if (valueTag == 1) {
                        jSSymbol = new JSBoolean(j, this, QuickJS.getValueBoolean(j));
                    } else if (valueTag == 2) {
                        jSSymbol = new JSNull(j, this);
                    } else if (valueTag == 3) {
                        jSSymbol = new JSUndefined(j, this);
                    } else if (valueTag == 6) {
                        QuickJS.destroyValue(this.pointer, j);
                        throw new JSEvaluationException(QuickJS.getException(this.pointer));
                    } else if (valueTag != 7) {
                        jSSymbol = new JSInternal(j, this);
                    } else {
                        jSSymbol = new JSFloat64(j, this, QuickJS.getValueFloat64(j));
                    }
                } else if (QuickJS.isValueFunction(this.pointer, j)) {
                    jSSymbol = new JSFunction(j, this);
                } else if (QuickJS.isValueArray(this.pointer, j)) {
                    jSSymbol = new JSArray(j, this);
                } else if (QuickJS.isValueArrayBuffer(this.pointer, j)) {
                    jSSymbol = new JSArrayBuffer(j, this);
                } else {
                    jSSymbol = new JSObject(j, this, QuickJS.getValueJavaObject(this.pointer, j));
                }
                this.cleaner.register(jSSymbol, j);
                return jSSymbol;
            }
            throw new IllegalStateException("Can't wrap null pointer as JSValue");
        } catch (Exception e) {
            JNIBridgeModuleHelper.wrapAsJSValueException(e);
            return new JSUndefined(j, this);
        }
    }

    public JSArrayBuffer createJSArrayBuffer(boolean[] zArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(zArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferZ(this.pointer, zArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public void evaluate(String str, String str2, int i, int i2) {
        evaluateInternal(str, str2, i, i2, null);
    }

    public <T> T evaluate(String str, String str2, Class<T> cls) {
        return (T) evaluateInternal(str, str2, 0, 0, this.quickJS.getAdapter(cls));
    }

    public <T> T evaluate(String str, String str2, TypeAdapter<T> typeAdapter) {
        return (T) evaluateInternal(str, str2, 0, 0, typeAdapter);
    }

    public <T> T evaluate(String str, String str2, int i, int i2, Class<T> cls) {
        return (T) evaluateInternal(str, str2, i, i2, this.quickJS.getAdapter(cls));
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSNumber createJSNumber(double d) {
        JSNumber jSNumber;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueFloat64(this.pointer, d)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSObject createJSObject(Object obj) {
        JSObject jSObject;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSObject = (JSObject) wrapAsJSValue(QuickJS.createValueJavaObject(this.pointer, obj)).cast(JSObject.class);
        }
        return jSObject;
    }

    public <T> T evaluate(String str, String str2, int i, int i2, TypeAdapter<T> typeAdapter) {
        return (T) evaluateInternal(str, str2, i, i2, typeAdapter);
    }

    public JSArrayBuffer createJSArrayBuffer(byte[] bArr) {
        return createJSArrayBuffer(bArr, 0, bArr.length);
    }

    public JSFunction createJSFunction(JSFunctionCallback jSFunctionCallback) {
        JSFunction jSFunction;
        Objects.requireNonNull(jSFunctionCallback, "callback == null");
        synchronized (this.jsRuntime) {
            checkClosed();
            jSFunction = (JSFunction) wrapAsJSValue(QuickJS.createValueFunction(this.pointer, this, jSFunctionCallback, "invoke", "(Lcom/youku/gaiax/quickjs/JSContext;[Lcom/youku/gaiax/quickjs/JSValue;)Lcom/youku/gaiax/quickjs/JSValue;", JSValue.class, new Class[]{JSContext.class, JSValue[].class}, true)).cast(JSFunction.class);
        }
        return jSFunction;
    }

    public JSArrayBuffer createJSArrayBuffer(byte[] bArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(bArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferB(this.pointer, bArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    @Override // com.youku.gaiax.quickjs.adapter.TypeAdapter.Context
    public JSNumber createJSNumber(long j) {
        JSNumber jSNumber;
        synchronized (this.jsRuntime) {
            checkClosed();
            jSNumber = (JSNumber) wrapAsJSValue(QuickJS.createValueFloat64(this.pointer, j)).cast(JSNumber.class);
        }
        return jSNumber;
    }

    public JSArrayBuffer createJSArrayBuffer(char[] cArr) {
        return createJSArrayBuffer(cArr, 0, cArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(char[] cArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(cArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferC(this.pointer, cArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(short[] sArr) {
        return createJSArrayBuffer(sArr, 0, sArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(short[] sArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(sArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferS(this.pointer, sArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(int[] iArr) {
        return createJSArrayBuffer(iArr, 0, iArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(int[] iArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(iArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferI(this.pointer, iArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(long[] jArr) {
        return createJSArrayBuffer(jArr, 0, jArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(long[] jArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(jArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferJ(this.pointer, jArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(float[] fArr) {
        return createJSArrayBuffer(fArr, 0, fArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(float[] fArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(fArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferF(this.pointer, fArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }

    public JSArrayBuffer createJSArrayBuffer(double[] dArr) {
        return createJSArrayBuffer(dArr, 0, dArr.length);
    }

    public JSArrayBuffer createJSArrayBuffer(double[] dArr, int i, int i2) {
        JSArrayBuffer jSArrayBuffer;
        checkArrayBounds(dArr.length, i, i2);
        synchronized (this.jsRuntime) {
            checkClosed();
            jSArrayBuffer = (JSArrayBuffer) wrapAsJSValue(QuickJS.createValueArrayBufferD(this.pointer, dArr, i, i2)).cast(JSArrayBuffer.class);
        }
        return jSArrayBuffer;
    }
}
