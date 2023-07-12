package com.ali.user.mobile.log;

import com.alibaba.mtl.appmonitor.AppMonitor;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AppMonitorAdapter {
    public static void commitFail(String str, String str2, String str3, String str4) {
        AppMonitor.Alarm.commitFail(str, str2, str3, str4);
    }

    public static void commitSuccess(String str, String str2) {
        try {
            AppMonitor.Alarm.commitSuccess(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void commitSuccess(String str, String str2, String str3) {
        try {
            AppMonitor.Alarm.commitSuccess(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
