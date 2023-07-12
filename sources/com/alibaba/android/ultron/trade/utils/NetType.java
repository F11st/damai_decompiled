package com.alibaba.android.ultron.trade.utils;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public enum NetType {
    NET_TYPE_UNKNOW(0, "unknow"),
    NET_TYPE_2G(2, "2g"),
    NET_TYPE_3G(3, "3g"),
    NET_TYPE_WIFI(1, "wifi"),
    NET_TYPE_23G(4, "23g");
    
    private int code;
    private String desc;

    NetType(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.desc;
    }
}
