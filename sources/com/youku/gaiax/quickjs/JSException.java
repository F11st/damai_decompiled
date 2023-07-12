package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JSException {
    private final String exception;
    private final boolean isError;
    private final String stack;

    private JSException(boolean z, String str, String str2) {
        this.isError = z;
        this.exception = str;
        this.stack = str2;
    }

    public String getException() {
        return this.exception;
    }

    public String getStack() {
        return this.stack;
    }

    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.isError) {
            sb.append("Throw: ");
        }
        sb.append(this.exception);
        sb.append(StringUtils.LF);
        String str = this.stack;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }
}
