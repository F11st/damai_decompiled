package com.ut.mini.behavior.data;

import android.text.TextUtils;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum LogicalType {
    AND(m80.AND_PREFIX),
    OR(m80.OR_PREFIX);
    
    private final String value;

    LogicalType(String str) {
        this.value = str;
    }

    public static LogicalType getLogicalType(String str) {
        LogicalType[] values;
        if (TextUtils.isEmpty(str)) {
            return AND;
        }
        for (LogicalType logicalType : values()) {
            if (logicalType.getValue().equals(str)) {
                return logicalType;
            }
        }
        return AND;
    }

    public static boolean isLogicalType(String str) {
        return AND.getValue().equals(str) || OR.getValue().equals(str);
    }

    public String getValue() {
        return this.value;
    }
}
