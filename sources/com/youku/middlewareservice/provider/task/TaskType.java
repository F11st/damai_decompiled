package com.youku.middlewareservice.provider.task;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public enum TaskType {
    IO(1),
    NORMAL(2),
    CPU(3),
    RPC(4),
    SCHEDULER(5);
    
    private int value;

    TaskType(int i) {
        this.value = i;
    }

    public static TaskType fromValue(int i) {
        TaskType[] values;
        for (TaskType taskType : values()) {
            if (taskType.getValue() == i) {
                return taskType;
            }
        }
        return NORMAL;
    }

    public int getValue() {
        return this.value;
    }
}
