package com.youku.alixplayer.opensdk;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum PlayType {
    VOD(0),
    URL(2),
    LIVE(1);
    
    private int value;

    PlayType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
