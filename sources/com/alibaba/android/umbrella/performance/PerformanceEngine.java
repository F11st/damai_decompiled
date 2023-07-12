package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.mtl.appmonitor.AppMonitor;
import tb.kt2;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class PerformanceEngine {
    static void commitPerformancePage(PerformanceEntity performanceEntity) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void commitPerformancePage(ProcessEntity processEntity) {
        if (processEntity == null || TextUtils.isEmpty(processEntity.bizName) || kt2.z()) {
            return;
        }
        AppMonitor.Alarm.commitSuccess("Page_Umbrella_Performance_Govern", "Monitor_Page_Load_Service", processEntity.toJsonString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void commitPerformancePoint(PerformanceEntity performanceEntity) {
        if (kt2.A()) {
            return;
        }
        AppMonitor.Alarm.commitSuccess("Page_Umbrella_Performance_Govern", UmbrellaTracker.PURCHASE_POINT_PRE + performanceEntity.bizName + UmbrellaTracker.PURCHASE_POINT_POST, performanceEntity.toJsonString());
    }
}
