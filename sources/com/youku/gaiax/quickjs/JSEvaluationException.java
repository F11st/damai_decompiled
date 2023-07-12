package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSEvaluationException extends RuntimeException {
    private JSException jsException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSEvaluationException(JSException jSException) {
        super(jSException.toString());
    }

    public JSException getJSException() {
        return this.jsException;
    }
}
