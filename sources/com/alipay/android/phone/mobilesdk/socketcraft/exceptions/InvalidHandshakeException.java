package com.alipay.android.phone.mobilesdk.socketcraft.exceptions;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class InvalidHandshakeException extends InvalidDataException {
    private static final long serialVersionUID = -1426533877490484964L;

    public InvalidHandshakeException() {
        super(1002);
    }

    public InvalidHandshakeException(String str, Throwable th) {
        super(1002, str, th);
    }

    public InvalidHandshakeException(String str) {
        super(1002, str);
    }

    public InvalidHandshakeException(Throwable th) {
        super(1002, th);
    }
}
