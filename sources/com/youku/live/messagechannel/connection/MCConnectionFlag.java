package com.youku.live.messagechannel.connection;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum MCConnectionFlag {
    PM(0),
    CDN(1),
    ACCS_MASS(2);
    
    private int code;

    MCConnectionFlag(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
