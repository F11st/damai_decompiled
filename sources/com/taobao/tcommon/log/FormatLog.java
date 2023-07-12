package com.taobao.tcommon.log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface FormatLog {
    void d(String str, String str2, Object... objArr);

    void e(int i, String str, String str2);

    void e(String str, String str2, Object... objArr);

    void i(String str, String str2, Object... objArr);

    boolean isLoggable(int i);

    void setMinLevel(int i);

    void v(String str, String str2, Object... objArr);

    void w(String str, String str2, Object... objArr);
}
