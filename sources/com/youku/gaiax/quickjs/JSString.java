package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public final class JSString extends JSValue {
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSString(long j, JSContext jSContext, String str) {
        super(j, jSContext);
        this.value = str;
    }

    public String getString() {
        return this.value;
    }
}
