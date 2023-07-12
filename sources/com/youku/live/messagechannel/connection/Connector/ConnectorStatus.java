package com.youku.live.messagechannel.connection.Connector;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum ConnectorStatus {
    INIT(0),
    OPENING(1),
    OPEN(2),
    CLOSED(3);
    
    private int code;

    ConnectorStatus(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
