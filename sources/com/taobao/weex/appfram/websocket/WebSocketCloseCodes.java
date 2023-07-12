package com.taobao.weex.appfram.websocket;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum WebSocketCloseCodes {
    CLOSE_NORMAL(1000),
    CLOSE_GOING_AWAY(1001),
    CLOSE_PROTOCOL_ERROR(1002),
    CLOSE_UNSUPPORTED(1003),
    CLOSE_NO_STATUS(1005),
    CLOSE_ABNORMAL(1006),
    UNSUPPORTED_DATA(1007),
    POLICY_VIOLATION(1008),
    CLOSE_TOO_LARGE(1009),
    MISSING_EXTENSION(1010),
    INTERNAL_ERROR(1011),
    SERVICE_RESTART(1012),
    TRY_AGAIN_LATER(1013),
    TLS_HANDSHAKE(1015);
    
    private int code;

    WebSocketCloseCodes(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
