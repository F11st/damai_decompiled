package com.alibaba.security.common.track.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CommonTrackResult implements Serializable {
    public static final int ERROR_CODE = -1;
    public static final int SUCCESS_CODE = 0;
    public int errorCode;
    public String message;

    public CommonTrackResult(int i, String str) {
        this.errorCode = i;
        this.message = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public CommonTrackResult(String str) {
        this.errorCode = 0;
        this.message = str;
    }

    public CommonTrackResult() {
        this.errorCode = 0;
        this.message = "";
    }
}
