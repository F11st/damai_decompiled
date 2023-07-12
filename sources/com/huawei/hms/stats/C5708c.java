package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.stats.c */
/* loaded from: classes10.dex */
public class C5708c {
    public static final Object a = new Object();
    public static boolean b;
    public static boolean c;

    public static boolean a() {
        synchronized (a) {
            if (!b) {
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + c);
            }
        }
        return c;
    }
}
