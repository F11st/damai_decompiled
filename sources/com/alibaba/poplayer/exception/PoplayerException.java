package com.alibaba.poplayer.exception;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PoplayerException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public PoplayerException() {
    }

    public PoplayerException(String str, Throwable th) {
        super(str, th);
    }

    public PoplayerException(String str) {
        super(str);
    }

    public PoplayerException(Throwable th) {
        super(th);
    }
}
