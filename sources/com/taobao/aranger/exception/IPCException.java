package com.taobao.aranger.exception;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IPCException extends Exception {
    private final int mErrorCode;

    public IPCException(int i, String str) {
        super(str);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public IPCException(int i, Throwable th) {
        super(th.getMessage(), th);
        this.mErrorCode = i;
    }
}
