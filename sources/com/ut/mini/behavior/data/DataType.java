package com.ut.mini.behavior.data;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum DataType {
    Begin("b"),
    Event("e");
    
    private final String value;

    DataType(String str) {
        this.value = str;
    }

    public static DataType getDataType(String str) {
        DataType[] values;
        if (TextUtils.isEmpty(str)) {
            return Event;
        }
        for (DataType dataType : values()) {
            if (dataType.getValue().equals(str)) {
                return dataType;
            }
        }
        return Event;
    }

    public String getValue() {
        return this.value;
    }
}
