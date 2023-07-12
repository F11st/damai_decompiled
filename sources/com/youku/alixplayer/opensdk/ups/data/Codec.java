package com.youku.alixplayer.opensdk.ups.data;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public enum Codec {
    H264(0),
    H265(1),
    AV1(2);
    
    private final int mValue;

    Codec(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
