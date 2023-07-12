package com.youku.playerservice.axp.item;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum Quality {
    UNKNOWN("未知"),
    SOUND("音频"),
    AUTO("智能", 99, 3, 0),
    HD3GP("省流", 1, 5, 1),
    SD("标清", 2, 2, 2),
    HD("高清", 3, 1, 3),
    HD2("超清", 4, 0, 4),
    HD3("蓝光", 5, 4, 5),
    HD4K("4K", 6, 6, 6),
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
    private final int live;
    private int liveCode;
    private String liveDescription;
    private Map<String, String> mStringMap;
    private final int ups;

    Quality(String str) {
        this(str, -1, -1, -1);
    }

    Quality(String str, int i) {
        this(str, i, -1, -1);
    }

    Quality(String str, int i, int i2) {
        this(str, i, i2, -1);
    }

    Quality(String str, int i, int i2, int i3) {
        this.mStringMap = new ConcurrentHashMap();
        this.description = str;
        this.ups = i;
        this.abr = i2;
        this.live = i3;
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
            if (i == quality.abr) {
                return quality;
            }
        }
        return UNKNOWN;
    }

    public static Quality getQualityByLiveCode(int i) {
        Quality[] values;
        for (Quality quality : values()) {
            if (i == quality.live) {
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

    public int getAbr() {
        return this.abr;
    }

    public int getCode() {
        return this.ups;
    }

    public int getDefaultLiveCode() {
        return this.live;
    }

    public String getDescription() {
        return this.description;
    }

    @Deprecated
    public String getDescriptionForLive() {
        return this.liveDescription;
    }

    public String getDescriptionForUps() {
        return this.description;
    }

    public int getLiveCode() {
        return this.liveCode;
    }

    public String getLiveDescription() {
        return this.liveDescription;
    }

    public String getString(String str, String str2) {
        String str3 = this.mStringMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public int getUpsCode() {
        return this.ups;
    }

    public void putString(String str, String str2) {
        if (str2 != null) {
            this.mStringMap.put(str, str2);
        } else {
            this.mStringMap.remove(str);
        }
    }

    public void setLiveCode(int i) {
        this.liveCode = i;
    }

    public void setLiveDescription(String str) {
        this.liveDescription = str;
    }
}
