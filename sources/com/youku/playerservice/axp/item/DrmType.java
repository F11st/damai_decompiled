package com.youku.playerservice.axp.item;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum DrmType {
    DEFAULT(1, "default"),
    COPYRIGHT(2, "copyrightDRM"),
    CHINA(4, "chinaDRM"),
    WIDEVINE(8, "widevine"),
    WV_CBCS(16, "cbcs"),
    WV_CENC(32, "cenc"),
    AES128(64, "AES128");
    
    private final String mStringRepresent;
    private final int mValue;

    DrmType(int i, String str) {
        this.mValue = i;
        this.mStringRepresent = str;
    }

    public static DrmType getDrmByStr(String str) {
        DrmType[] values;
        for (DrmType drmType : values()) {
            if (drmType.getStringRepresent().equals(str)) {
                return drmType;
            }
        }
        return DEFAULT;
    }

    public String getStringRepresent() {
        return this.mStringRepresent;
    }

    public int getValue() {
        return this.mValue;
    }
}
