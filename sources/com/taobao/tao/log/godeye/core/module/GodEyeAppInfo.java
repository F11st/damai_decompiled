package com.taobao.tao.log.godeye.core.module;

import android.os.Build;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GodEyeAppInfo {
    public CpuStat cpuStat = new CpuStat();
    public IOStat iOStat = new IOStat();
    public DeviceInfo deviceInfo = new DeviceInfo();
    public TrafficStatsInfo trafficStatsInfo = new TrafficStatsInfo();
    public BatteryInfo batteryInfo = new BatteryInfo();
    public PerformanceInfo performanceInfo = new PerformanceInfo();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class BatteryInfo implements Serializable {
        public int batteryHealth;
        public int batteryPercent;
        public int batteryStatus;
        public double batteryTemp;
        public int batteryV;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CpuStat implements Serializable {
        public boolean cpuAlarmInBg;
        public int iOWaitTimeAvg;
        public float mPidPerCpuLoadAvg;
        public int myAVGPidCPUPercent;
        public int myMaxPidCPUPercent;
        public int myPidCPUPercent;
        public int pidIoWaitCount;
        public int sysAvgCPUPercent;
        public int sysCPUPercent;
        public int sysMaxCPUPercent;
        public float systemLoadAvg;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DeviceInfo implements Serializable {
        public String cpuBrand;
        public float[] cpuFreqArray;
        public float cpuMaxFreq;
        public float cpuMinFreq;
        public String cpuModel;
        public int cpuProcessCount;
        public float density;
        public long deviceTotalMemory;
        public String gpuBrand;
        public long gpuMaxFreq;
        public String gpuModel;
        public boolean isRooted;
        public int memoryThreshold;
        public int screenHeght;
        public int screenWidth;
        public int storeFreesize;
        public int storeTotalSize;
        public String mobileModel = Build.MODEL;
        public String mobileBrand = Build.BRAND;
        public int apiLevel = Build.VERSION.SDK_INT;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IOStat implements Serializable {
        public int avgIOWaitTime;
        public int currentIOWaitTime;
        public int openedFileCount;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class PerformanceInfo implements Serializable {
        public int anrCount;
        public int appProgressImportance;
        public int cpuPerformance;
        public int deviceScore;
        public int ioPerformance;
        public boolean isLowPerformance;
        public int memPerformance;
        public int runTimeThreadCount;
        public int runningThreadCount;
        public int schedPerformance;
        public int sysRunningProgress;
        public int sysRunningService;
        public int threadCount;
        public int systemRunningScore = 0;
        public int myPidScore = 0;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class TrafficStatsInfo implements Serializable {
        public float activityMobileRxBytes;
        public float activityMobileTxBytes;
        public float activityTotalRxBytes;
        public float activityTotalTxBytes;
        public float totalMobileRxBytes;
        public float totalMobileTxBytes;
        public float totalTotalRxBytes;
        public float totalTotalTxBytes;
    }
}
