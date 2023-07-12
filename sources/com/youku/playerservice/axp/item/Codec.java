package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum Codec {
    H264(0),
    H265(1),
    AV1(2);
    
    private final int mValue;

    Codec(int i) {
        this.mValue = i;
    }

    public static Codec getCodecByValue(int i) {
        Codec[] values;
        for (Codec codec : values()) {
            if (codec.getValue() == i) {
                return codec;
            }
        }
        return H264;
    }

    public int getValue() {
        return this.mValue;
    }
}
