package com.ut.mini.exposure;

import com.alibaba.analytics.AnalyticsMgr;
import tb.sj;
import tb.we2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExposureConfigMgr {
    private static final String EXP_CONFIG_TAG = "autoExposure";
    public static double dimThreshold = 0.5d;
    private static String mConfig = null;
    public static int maxTimeThreshold = 3600000;
    public static boolean notClearTagAfterDisAppear = false;
    public static int timeThreshold = 500;
    public static boolean trackerExposureOpen = true;

    public static void init() {
        updateExposureConfig(we2.a(sj.c().b(), EXP_CONFIG_TAG));
        TrackerManager.getInstance().getThreadHandle().postDelayed(new Runnable() { // from class: com.ut.mini.exposure.ExposureConfigMgr.1
            @Override // java.lang.Runnable
            public void run() {
                ExposureConfigMgr.updateExposureConfig();
            }
        }, 15000L);
    }

    public static void updateExposureConfig() {
        try {
            updateExposureConfig(AnalyticsMgr.K(EXP_CONFIG_TAG));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r10.equalsIgnoreCase(com.ut.mini.exposure.ExposureConfigMgr.mConfig) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void updateExposureConfig(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.exposure.ExposureConfigMgr.updateExposureConfig(java.lang.String):void");
    }
}
