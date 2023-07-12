package com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class InvalidFrameException extends InvalidDataException {
    private static final long serialVersionUID = -9016496369828887591L;

    public InvalidFrameException() {
        super(1002);
    }

    public InvalidFrameException(String str) {
        super(1002, str);
    }

    public InvalidFrameException(Throwable th) {
        super(1002, th);
    }

    public InvalidFrameException(String str, Throwable th) {
        super(1002, str, th);
    }
}
