package com.youku.live.messagechannel.connection;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum MCConnectionState {
    CLOSED(-1),
    INIT(0),
    OPENING(1),
    BROKEN(2),
    OPEN(3);
    
    private int code;

    MCConnectionState(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
