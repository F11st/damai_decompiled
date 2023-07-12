package com.alibaba.gaiax.studio.third.socket.java_websocket.exceptions;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes6.dex */
public class LimitExceededException extends InvalidDataException {
    private static final long serialVersionUID = 6908339749836826785L;
    private final int limit;

    public LimitExceededException() {
        this(Integer.MAX_VALUE);
    }

    public int getLimit() {
        return this.limit;
    }

    public LimitExceededException(int i) {
        super(1009);
        this.limit = i;
    }

    public LimitExceededException(String str, int i) {
        super(1009, str);
        this.limit = i;
    }

    public LimitExceededException(String str) {
        this(str, Integer.MAX_VALUE);
    }
}
