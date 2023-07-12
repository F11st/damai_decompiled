package cn.damai.tetris.component.rank.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class RankCityValue implements Serializable {
    public String categoryId;
    public String cityId;
    public String cityName;

    public RankCityValue(String str, String str2) {
        this.cityId = str;
        this.cityName = str2;
    }

    public RankCityValue(String str, String str2, String str3) {
        this.cityId = str;
        this.cityName = str2;
        this.categoryId = str3;
    }
}
