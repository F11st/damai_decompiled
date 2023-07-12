package com.taobao.android.dinamicx.monitor;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXAppMonitor {
    void alarm_commitFail(String str, String str2, String str3, String str4);

    void alarm_commitFail(String str, String str2, String str3, String str4, String str5);

    void alarm_commitSuccess(String str, String str2);

    void alarm_commitSuccess(String str, String str2, String str3);

    void counter_commit(String str, String str2, double d);

    void counter_commit(String str, String str2, String str3, double d);

    void stat_begin(String str, String str2, String str3);

    void stat_commit(String str, String str2, double d);

    void stat_end(String str, String str2, String str3);
}
