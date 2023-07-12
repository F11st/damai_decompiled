package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSBoolean extends JSValue {
    private final boolean value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSBoolean(long j, JSContext jSContext, boolean z) {
        super(j, jSContext);
        this.value = z;
    }

    public boolean getBoolean() {
        return this.value;
    }
}
