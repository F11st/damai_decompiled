package com.taobao.ma.common.log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum LogLevel {
    TRACE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6);
    
    private final int mAndroidLogLevel;

    LogLevel(int i) {
        this.mAndroidLogLevel = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAndroidLogLevel() {
        return this.mAndroidLogLevel;
    }
}
