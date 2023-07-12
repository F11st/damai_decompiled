package com.youku.kubus;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class EventBusException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public EventBusException(String str) {
        super(str);
    }

    public EventBusException(Throwable th) {
        super(th);
    }

    public EventBusException(String str, Throwable th) {
        super(str, th);
    }
}
