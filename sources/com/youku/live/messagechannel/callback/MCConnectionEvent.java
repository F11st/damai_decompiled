package com.youku.live.messagechannel.callback;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum MCConnectionEvent {
    LAUNCH_SUCCESS(1, "Connection open success."),
    LAUNCH_FAIL(2, "Connection open fail."),
    SHUTDOWN_SUCCESS(3, "Connection close success."),
    SHUTDOWN_FAIL(4, "Connection close fail.");
    
    private int code;
    private String msg;

    MCConnectionEvent(int i, String str) {
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
