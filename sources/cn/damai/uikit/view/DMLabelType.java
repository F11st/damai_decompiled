package cn.damai.uikit.view;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum DMLabelType {
    LABEL_TYPE_CUSTOM("", "", ""),
    LABEL_TYPE_BUYING("正在热抢", "正在热抢", "301"),
    LABEL_TYPE_HIGHEST_HOT("热度最高", "热度最高", "302"),
    LABEL_TYPE_UPCOMING_PERFORMANCE("即将开演", "即将开演", "303"),
    LABEL_TYPE_DOUBLE_11("双11", "双11", "304"),
    LABEL_TYPE_ZAO_NIAO("早鸟", "早鸟", "305"),
    LABEL_TYPE_NEW_SALE("新上架", "新上架", "306"),
    LABEL_TYPE_UPCOMING_BUY("即将开抢", "即将开抢", "307"),
    LABEL_TYPE_TOUR("巡演", "巡演", "308"),
    LABEL_TYPE_SOLD_OUT("已下架", "已下架", "309"),
    LABEL_TYPE_ALL_SELL_OUT("已售罄", "已售罄", "310"),
    LABEL_TYPE_RANK_TOP_ONE("0", "0", "0"),
    LABEL_TYPE_RANK_TOP_TWO("1", "1", "1"),
    LABEL_TYPE_RANK_TOP_THREE("2", "2", "2"),
    LABEL_TYPE_RANK_TOP_OTHER("请输入具体数字", "-1", "-1");
    
    public String labelName;
    public String tag;
    public String type;

    DMLabelType(String str, String str2, String str3) {
        this.labelName = str;
        this.tag = str2;
        this.type = str3;
    }

    public static DMLabelType convertLabelName2Label(String str) {
        DMLabelType[] values;
        if (str == null) {
            return null;
        }
        for (DMLabelType dMLabelType : values()) {
            if (TextUtils.equals(dMLabelType.labelName, str)) {
                return dMLabelType;
            }
        }
        return null;
    }

    public static DMLabelType convertType2Label(String str) {
        DMLabelType[] values;
        if (str == null) {
            return null;
        }
        for (DMLabelType dMLabelType : values()) {
            if (TextUtils.equals(dMLabelType.type, str)) {
                return dMLabelType;
            }
        }
        return null;
    }
}
