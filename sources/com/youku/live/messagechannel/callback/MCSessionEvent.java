package com.youku.live.messagechannel.callback;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum MCSessionEvent {
    CONNECTION_BROKEN_OFFLINE(0, "Connections are broken, device stop heartbeat."),
    CONNECTION_RECOVERY_ONLINE(1, "Connections are recovery, device start heartbeat."),
    OPEN_SUCCESS(2, "Session open success."),
    OPEN_FAIL(3, "Session open fail."),
    CLOSE_SUCCESS(4, "Session close success."),
    CLOSE_FAIL(5, "Session close fail.");
    
    private int code;
    private String msg;

    MCSessionEvent(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
