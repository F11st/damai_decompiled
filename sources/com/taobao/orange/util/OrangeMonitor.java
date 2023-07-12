package com.taobao.orange.util;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class OrangeMonitor {
    public static final String TAG = "OrangeMonitor";
    public static boolean mAppMonitorValid = true;
    public static boolean mPerformanceInfoRecordDone;

    public static void commitBootPerformanceInfo(OrangeMonitorData orangeMonitorData) {
        if (mAppMonitorValid) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("bootType", orangeMonitorData.performance.bootType ? "1" : "0");
            create.setValue("downgradeType", String.valueOf(orangeMonitorData.performance.downgradeType));
            create.setValue("monitorType", String.valueOf(orangeMonitorData.performance.monitorType));
            create.setValue("process", AndroidUtil.currentProcess);
            create.setValue("processIsolated", GlobalOrange.processIsolated ? "1" : "0");
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("requestCount", orangeMonitorData.performance.requestCount);
            create2.setValue("persistCount", orangeMonitorData.performance.persistCount);
            create2.setValue("restoreCount", orangeMonitorData.performance.restoreCount);
            create2.setValue("persistTime", orangeMonitorData.performance.persistTime);
            create2.setValue("restoreTime", orangeMonitorData.performance.restoreTime);
            create2.setValue("ioTime", orangeMonitorData.performance.ioTime);
            commitStat(OConstant.MONITOR_MODULE, OConstant.POINT_BOOT_PERF, create, create2);
            OLog.d(TAG, "commit boot stat", orangeMonitorData.performance.toString());
        }
    }

    public static void commitConfigMonitor(String str, String str2, String str3) {
        commitConfigMonitor(str, str2, str3, null);
    }

    public static void commitCount(String str, String str2, String str3, double d) {
        if (mAppMonitorValid) {
            AppMonitor.Counter.commit(str, str2, str3, d);
        }
    }

    public static void commitFail(String str, String str2, String str3, String str4, String str5) {
        if (mAppMonitorValid) {
            AppMonitor.Alarm.commitFail(str, str2, str3, str4, str5);
        }
    }

    public static void commitFileStatMonitor(String str, boolean z, boolean z2, int i, double d) {
        if (mAppMonitorValid) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(OConstant.DIMEN_CONFIG_NAME, str);
            create.setValue("success", z ? "1" : "0");
            create.setValue(OConstant.DIMEN_FILE_LOCK, z2 ? "1" : "0");
            create.setValue("process", AndroidUtil.currentProcess);
            create.setValue("processIsolated", GlobalOrange.processIsolated ? "1" : "0");
            create.setValue("type", String.valueOf(i));
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("cost", d);
            commitStat(OConstant.MONITOR_MODULE, OConstant.POINT_FILE_STAT, create, create2);
        }
    }

    public static void commitIndexUpdateMonitor(String str, String str2, String str3) {
        if (mAppMonitorValid) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue(OConstant.DIMEN_INDEX_UPDATE_APP_INDEX_VERSION, str);
            create.setValue(OConstant.DIMEN_INDEX_UPDATE_BASE_VERSION, str2);
            create.setValue("indexDiff", String.valueOf(GlobalOrange.indexDiff));
            create.setValue(OConstant.DIMEN_INDEX_UPDATE_RESPONSE_HEADER, str3);
            create.setValue("process", AndroidUtil.currentProcess);
            create.setValue("processIsolated", GlobalOrange.processIsolated ? "1" : "0");
            commitStat(OConstant.MONITOR_MODULE, OConstant.POINT_DIFF_INDEX_UPDATE, create, MeasureValueSet.create());
        }
    }

    public static void commitStat(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        if (mAppMonitorValid) {
            AppMonitor.Stat.commit(str, str2, dimensionValueSet, measureValueSet);
        }
    }

    public static void commitSuccess(String str, String str2, String str3) {
        if (mAppMonitorValid) {
            AppMonitor.Alarm.commitSuccess(str, str2, str3);
        }
    }

    private static Measure createMeasureWithRange(String str, double d) {
        Measure measure = new Measure(str);
        measure.setRange(Double.valueOf(0.0d), Double.valueOf(d));
        return measure;
    }

    public static void init() {
        if (mAppMonitorValid) {
            DimensionSet create = DimensionSet.create();
            create.addDimension("bootType");
            create.addDimension("downgradeType");
            create.addDimension("monitorType");
            create.addDimension("process");
            create.addDimension("processIsolated");
            MeasureSet create2 = MeasureSet.create();
            create2.addMeasure(createMeasureWithRange("requestCount", 10000.0d));
            create2.addMeasure(createMeasureWithRange("persistCount", 10000.0d));
            create2.addMeasure(createMeasureWithRange("restoreCount", 10000.0d));
            create2.addMeasure(createMeasureWithRange("persistTime", 1000000.0d));
            create2.addMeasure(createMeasureWithRange("restoreTime", 1000000.0d));
            create2.addMeasure(createMeasureWithRange("ioTime", 1000000.0d));
            register(OConstant.MONITOR_MODULE, OConstant.POINT_BOOT_PERF, create2, create, false);
            DimensionSet create3 = DimensionSet.create();
            create3.addDimension(OConstant.DIMEN_CONFIG_NAME);
            create3.addDimension("configVersion");
            create3.addDimension(OConstant.DIMEN_CONFIG_CHANGE_VERSION);
            create3.addDimension("enableChangeVersion");
            create3.addDimension("process");
            create3.addDimension("processIsolated");
            create3.addDimension(OConstant.DIMEN_CONFIG_KEY);
            MeasureSet create4 = MeasureSet.create();
            register(OConstant.MONITOR_MODULE, OConstant.POINT_CONFIG_UPDATE, create4, create3, false);
            register(OConstant.MONITOR_MODULE, OConstant.POINT_CONFIG_USE, create4, create3, false);
            register(OConstant.MONITOR_MODULE, OConstant.POINT_CONFIG_USE_DETAIL, create4, create3, false);
            DimensionSet create5 = DimensionSet.create();
            create5.addDimension(OConstant.DIMEN_INDEX_UPDATE_APP_INDEX_VERSION);
            create5.addDimension(OConstant.DIMEN_INDEX_UPDATE_BASE_VERSION);
            create5.addDimension("indexDiff");
            create5.addDimension(OConstant.DIMEN_INDEX_UPDATE_RESPONSE_HEADER);
            create5.addDimension("process");
            create5.addDimension("processIsolated");
            register(OConstant.MONITOR_MODULE, OConstant.POINT_DIFF_INDEX_UPDATE, create4, create5, false);
            DimensionSet create6 = DimensionSet.create();
            create6.addDimension(OConstant.DIMEN_CONFIG_NAME);
            create6.addDimension("success");
            create6.addDimension(OConstant.DIMEN_FILE_LOCK);
            create6.addDimension("process");
            create6.addDimension("processIsolated");
            create6.addDimension("type");
            MeasureSet create7 = MeasureSet.create();
            create7.addMeasure("cost");
            register(OConstant.MONITOR_MODULE, OConstant.POINT_FILE_STAT, create7, create6, false);
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        if (mAppMonitorValid) {
            AppMonitor.register(str, str2, measureSet, dimensionSet, z);
        }
    }

    public static void commitConfigMonitor(String str, String str2, String str3, String str4) {
        commitConfigMonitor(str, str2, str3, str4, null);
    }

    public static void commitConfigMonitor(String str, String str2, String str3, String str4, String str5) {
        if (mAppMonitorValid) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                DimensionValueSet create = DimensionValueSet.create();
                create.setValue(OConstant.DIMEN_CONFIG_NAME, str2);
                create.setValue("configVersion", str3);
                if (!TextUtils.isEmpty(str4)) {
                    create.setValue(OConstant.DIMEN_CONFIG_CHANGE_VERSION, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    create.setValue(OConstant.DIMEN_CONFIG_KEY, str5);
                }
                create.setValue("enableChangeVersion", ((Integer) SPUtil.getFromSharePreference(GlobalOrange.context, "enableChangeVersion", 0)).intValue() > 0 ? "1" : "0");
                create.setValue("process", AndroidUtil.currentProcess);
                create.setValue("processIsolated", GlobalOrange.processIsolated ? "1" : "0");
                commitStat(OConstant.MONITOR_MODULE, str, create, MeasureValueSet.create());
                return;
            }
            OLog.e(TAG, "commit error because data empty!", new Object[0]);
        }
    }
}
