package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import com.alipay.sdk.m.n.C4250a;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public final class JSInt extends JSNumber {
    private final int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSInt(long j, JSContext jSContext, int i) {
        super(j, jSContext);
        this.value = i;
    }

    private int getIntInRange(String str, int i, int i2) {
        int i3 = this.value;
        if (i > i3 || i3 > i2) {
            throw new JSDataException("Can't treat " + i3 + " as " + str);
        }
        return i3;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public byte getByte() {
        return (byte) getIntInRange("byte", C4250a.g, 127);
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public double getDouble() {
        return this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public float getFloat() {
        return this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public int getInt() {
        return this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public long getLong() {
        return this.value;
    }

    @Override // com.youku.gaiax.quickjs.JSNumber
    public short getShort() {
        return (short) getIntInRange("short", -32768, 32767);
    }
}
