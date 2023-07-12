package com.youku.playerservice.axp.p2p;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum PcdnType {
    NONE(0),
    VOD(1),
    DOWNLOAD(2),
    LIVE(3);
    
    private int value;

    PcdnType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
