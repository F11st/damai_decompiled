package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public final class JSArray extends JSObject {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSArray(long j, JSContext jSContext) {
        super(j, jSContext, null);
    }

    public int getLength() {
        return ((JSNumber) getProperty("length").cast(JSNumber.class)).getInt();
    }
}
