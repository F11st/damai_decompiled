package com.taobao.zcache;

import androidx.annotation.Keep;
import java.io.Serializable;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class Error implements Serializable {
    private final int code;
    private final String message;

    public Error(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
