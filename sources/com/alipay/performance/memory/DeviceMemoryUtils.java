package com.alipay.performance.memory;

import android.app.ActivityManager;
import android.content.Context;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DeviceMemoryUtils {
    public static final String KEY_MEMORY_STATISTICS = "scan_memory_statistics";
    public static final String TAG = "DeviceMemoryUtils";
    public static boolean needMemoryStatistics;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ScanMemoryInfo {
        public long availableMemory;
        public boolean lowMemory;
        public long thresholdMemory;
        public long totalMemory;

        public boolean needDownGrade() {
            if (this.lowMemory) {
                return true;
            }
            long j = this.availableMemory;
            if (j <= 0) {
                return false;
            }
            return j <= ((long) (((double) this.totalMemory) * 0.1d)) || j <= 400;
        }

        public String toString() {
            return "availableMemory=" + this.availableMemory + "^totalMemory=" + this.totalMemory + "^thresholdMemory=" + this.thresholdMemory;
        }
    }

    private static long a(long j, long j2) {
        MPaasLogger.d(TAG, new Object[]{"formatMemorySize: ", Long.valueOf(j), ", totalMemorySize: ", Long.valueOf(j2)});
        long j3 = 1000;
        if (j2 >= 1000000) {
            j3 = 1000000;
        } else if (j2 < 1000) {
            j3 = 1;
        }
        return j / j3;
    }

    public static ScanMemoryInfo getSystemMemoryInfo(Context context) {
        MPaasLogger.d(TAG, new Object[]{"getSystemMemoryInfo: ", context});
        if (context != null && needMemoryStatistics) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                ScanMemoryInfo scanMemoryInfo = new ScanMemoryInfo();
                long j = memoryInfo.totalMem;
                scanMemoryInfo.totalMemory = a(j, j);
                scanMemoryInfo.availableMemory = a(memoryInfo.availMem, memoryInfo.totalMem);
                scanMemoryInfo.thresholdMemory = a(memoryInfo.threshold, memoryInfo.totalMem);
                scanMemoryInfo.lowMemory = memoryInfo.lowMemory;
                MPaasLogger.d(TAG, new Object[]{"getSystemMemInfo: ", scanMemoryInfo.toString()});
                return scanMemoryInfo;
            } catch (Exception e) {
                MPaasLogger.e(TAG, new Object[]{"getSystemMemoryInfo: "}, e);
                return null;
            }
        }
        return null;
    }
}
