package com.taobao.alivfssdk.cache;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AVFSException extends IllegalStateException {
    public static final int ERROR = -1;
    public static final int ERROR_INDEXING = -4;
    public static final int ERROR_IO = -2;
    public static final int ERROR_SERIALIZATION = -3;
    private final int mErrorCode;

    public AVFSException(String str, Throwable th, int i) {
        super(str, th);
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
