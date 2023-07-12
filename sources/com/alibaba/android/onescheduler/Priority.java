package com.alibaba.android.onescheduler;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public enum Priority {
    LOW(1),
    NORMAL(2),
    HIGH(3),
    IMMEDIATE(4);
    
    private int value;

    Priority(int i) {
        this.value = i;
    }

    public static Priority fromValue(int i) {
        Priority[] values;
        for (Priority priority : values()) {
            if (priority.getValue() == i) {
                return priority;
            }
        }
        return NORMAL;
    }

    public int getValue() {
        return this.value;
    }
}
