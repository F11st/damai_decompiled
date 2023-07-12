package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public abstract class JSValue {
    public final JSContext jsContext;
    public final long pointer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue(long j, JSContext jSContext) {
        this.pointer = j;
        this.jsContext = jSContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends JSValue> T cast(Class<T> cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        throw new JSDataException("expected: " + cls.getSimpleName() + ", actual: " + getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkSameJSContext(JSValue jSValue) {
        if (jSValue.jsContext != this.jsContext) {
            throw new IllegalStateException("Two JSValues are not from the same JSContext");
        }
    }
}
