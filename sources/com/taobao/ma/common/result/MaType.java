package com.taobao.ma.common.result;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum MaType {
    PRODUCT(0, 255),
    MEDICINE(2, 255),
    EXPRESS(2, 255),
    QR(1, 512),
    TB_ANTI_FAKE(1, 512),
    TB_4G(1, 2048),
    DM(1, 1024),
    GEN3(1, 32768);
    
    private int discernType;
    private int type;

    MaType(int i, int i2) {
        this.type = i;
        this.discernType = i2;
    }

    public int getDiscernType() {
        return this.discernType;
    }

    public int getType() {
        return this.type;
    }

    public void setDiscernType(int i) {
        this.discernType = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
