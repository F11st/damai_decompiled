package com.alipay.ma;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum EngineType {
    ALL(0),
    BAR(1),
    QRCODE(2),
    DEFAULT(3),
    LOTTERY(4);
    
    public int type;

    EngineType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public static EngineType getType(int i) {
        EngineType[] values;
        for (EngineType engineType : values()) {
            if (engineType.type == i) {
                return engineType;
            }
        }
        return DEFAULT;
    }
}
