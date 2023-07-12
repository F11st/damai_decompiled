package com.youku.alixplayer.opensdk.ups.data;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public enum Quality {
    UNKNOWN("未知"),
    SOUND("音频"),
    AUTO("智能"),
    HD3GP("省流", 1, 5),
    SD("标清", 2, 2),
    HD("高清", 3, 1),
    HD2("超清", 4, 0),
    HD3("蓝光", 5, 4),
    HD4K("4K", 6, 6),
    SD_HDR("标清HDR", 7),
    HD_HDR("高清HDR", 8),
    HD2_HDR("超清HDR", 9),
    HD2_HDR_HFR("超清HDR50桢", 10),
    HD3_HDR("1080HDR", 11),
    HD3_HDR_HFR("1080HDR50桢", 12),
    HD4K_HDR("4KHDR", 13),
    HD4K_HDR_HFR("4KHDR50桢", 14),
    HD2_PW_HDR("超清PWHDR", 17),
    HD2_PW_HDR_HFR("超清PWHDR50桢", 18),
    HD3_PW_HDR("1080PWHDR", 19),
    HD3_PW_HDR_HFR("1080PWHDR50桢", 20),
    HD4K_PW_HDR("4KPWHDR", 21),
    HD4K_PW_HDR_HFR("HD4KPWHDR50桢", 22),
    HD3_HBR("帧享", 23),
    DOLBY("杜比", 30);
    
    private final int abr;
    private final String description;
    private final int ups;

    Quality(String str) {
        this.description = str;
        this.ups = -1;
        this.abr = -1;
    }

    public static Quality getQualityByAbrCode(int i) {
        Quality[] values;
        for (Quality quality : values()) {
            if (i == quality.abr) {
                return quality;
            }
        }
        return UNKNOWN;
    }

    public static Quality getQualityByCode(int i) {
        Quality[] values;
        for (Quality quality : values()) {
            if (i == quality.ups) {
                return quality;
            }
        }
        return UNKNOWN;
    }

    public static Quality getQualityByUpsCode(int i) {
        Quality[] values;
        for (Quality quality : values()) {
            if (i == quality.ups) {
                return quality;
            }
        }
        return UNKNOWN;
    }

    public int getCode() {
        return this.ups;
    }

    public String getDescription() {
        return this.description;
    }

    @Deprecated
    public int getValueForLive() {
        return -1;
    }

    public int getValueForUps() {
        return this.ups;
    }

    Quality(String str, int i, int i2) {
        this.description = str;
        this.ups = i;
        this.abr = i2;
    }

    Quality(String str, int i) {
        this.description = str;
        this.ups = i;
        this.abr = -1;
    }
}
