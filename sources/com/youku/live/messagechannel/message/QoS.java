package com.youku.live.messagechannel.message;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum QoS {
    DISCARD_LOW(0),
    DISCARD_MEDIUM(2),
    DISCARD_HIGH(4);
    
    private int code;

    QoS(int i) {
        this.code = i;
    }

    public boolean isHigh() {
        return this.code == DISCARD_HIGH.code;
    }

    public boolean isLow() {
        return this.code == DISCARD_LOW.code;
    }

    public boolean isMedium() {
        return this.code == DISCARD_MEDIUM.code;
    }

    public static boolean isHigh(String str) {
        return DISCARD_HIGH.name().equals(str);
    }

    public static boolean isLow(String str) {
        return DISCARD_LOW.name().equals(str);
    }

    public static boolean isMedium(String str) {
        return DISCARD_MEDIUM.name().equals(str);
    }
}
