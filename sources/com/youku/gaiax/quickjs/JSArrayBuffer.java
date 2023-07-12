package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSArrayBuffer extends JSObject {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSArrayBuffer(long j, JSContext jSContext) {
        super(j, jSContext, null);
    }

    public int getByteLength() {
        return ((JSNumber) getProperty("byteLength").cast(JSNumber.class)).getInt();
    }

    public boolean[] toBooleanArray() {
        return QuickJS.toBooleanArray(this.jsContext.pointer, this.pointer);
    }

    public byte[] toByteArray() {
        return QuickJS.toByteArray(this.jsContext.pointer, this.pointer);
    }

    public char[] toCharArray() {
        return QuickJS.toCharArray(this.jsContext.pointer, this.pointer);
    }

    public double[] toDoubleArray() {
        return QuickJS.toDoubleArray(this.jsContext.pointer, this.pointer);
    }

    public float[] toFloatArray() {
        return QuickJS.toFloatArray(this.jsContext.pointer, this.pointer);
    }

    public int[] toIntArray() {
        return QuickJS.toIntArray(this.jsContext.pointer, this.pointer);
    }

    public long[] toLongArray() {
        return QuickJS.toLongArray(this.jsContext.pointer, this.pointer);
    }

    public short[] toShortArray() {
        return QuickJS.toShortArray(this.jsContext.pointer, this.pointer);
    }
}
