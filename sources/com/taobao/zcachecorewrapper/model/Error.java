package com.taobao.zcachecorewrapper.model;

import androidx.annotation.Keep;
import java.io.Serializable;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class Error implements Serializable {
    public int errCode;
    public String errMsg;

    public Error(com.taobao.zcache.Error error) {
        if (error == null) {
            this.errCode = 0;
            this.errMsg = null;
            return;
        }
        this.errCode = error.getCode();
        this.errMsg = error.getMessage();
    }
}
