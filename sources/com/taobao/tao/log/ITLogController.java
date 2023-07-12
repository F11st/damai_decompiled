package com.taobao.tao.log;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ITLogController {
    boolean checkLogLength(String str);

    String compress(String str);

    void destroyLog(boolean z);

    byte[] ecrypted(byte[] bArr);

    byte[] ecrypted(byte[] bArr, int i, int i2);

    LogLevel getLogLevel(String str);

    boolean isFilter(LogLevel logLevel, String str);

    boolean isOpenLog();

    void openLog(boolean z);

    void setEndTime(long j);

    void setLogLevel(String str);

    void setModuleFilter(Map<String, LogLevel> map);
}
