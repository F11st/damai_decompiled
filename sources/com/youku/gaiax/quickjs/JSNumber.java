package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public abstract class JSNumber extends JSValue {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSNumber(long j, JSContext jSContext) {
        super(j, jSContext);
    }

    public abstract byte getByte();

    public abstract double getDouble();

    public abstract float getFloat();

    public abstract int getInt();

    public abstract long getLong();

    public abstract short getShort();
}
