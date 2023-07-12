package com.taobao.tlog.remote;

import android.content.Context;
import android.util.Log;
import com.alibaba.ha.bizerrorreporter.BizErrorBuilder;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.monitor.TLogMonitor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogRemoteMonitor implements TLogMonitor {
    private static String BIZ_ERROR_TYPE = "TLOG_MONITOR";
    private static String MONITOR_POINTER = "TLOG_MONITOR_STAGE";
    private static String PAGE = "TLOG_MONITOR";
    public static String TAG = "tlogRemotge.TLogRemoteMonitor";
    private static String TLOG_MODEL = "TLOG_MONITOR";
    private static String dim_stage = "stage";
    private static String mea_errorCount = "errorStageCount";
    private static String mea_totalCount = "totalStageCount";
    private Context mContext = null;

    private String buildInfo(String str, String str2) {
        return str + " : " + str2;
    }

    private void monitorStageError(String str) {
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue(dim_stage, str);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue(mea_totalCount, 0.0d);
        create2.setValue(mea_errorCount, 1.0d);
        AppMonitor.Stat.commit(PAGE, MONITOR_POINTER, create, create2);
    }

    private void registMonitorStage() {
        try {
            DimensionSet create = DimensionSet.create();
            create.addDimension(dim_stage);
            MeasureSet create2 = MeasureSet.create();
            create2.addMeasure(mea_totalCount);
            create2.addMeasure(mea_errorCount);
            AppMonitor.register(PAGE, MONITOR_POINTER, create2, create, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Context context) {
        this.mContext = context;
        registMonitorStage();
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageError(String str, String str2, String str3) {
        try {
            TLog.logw(TLOG_MODEL, str, buildInfo(str2, str3));
            String str4 = TAG;
            Log.e(str4, str + ":" + str2 + ":" + str3);
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            bizErrorModule.businessType = BIZ_ERROR_TYPE;
            bizErrorModule.exceptionCode = str;
            bizErrorModule.exceptionId = str2;
            bizErrorModule.exceptionDetail = str3;
            bizErrorModule.exceptionVersion = BizErrorBuilder._VERSION;
            if (this.mContext != null) {
                BizErrorReporter.getInstance().send(this.mContext, bizErrorModule);
            } else {
                Log.e(TAG, "you need call TLogRemoteMonitor.init() method ");
            }
            monitorStageError(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        r5 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.create();
        r5.setValue(com.taobao.tlog.remote.TLogRemoteMonitor.dim_stage, r4);
        r4 = com.alibaba.mtl.appmonitor.model.MeasureValueSet.create();
        r4.setValue(com.taobao.tlog.remote.TLogRemoteMonitor.mea_totalCount, 1.0d);
        r4.setValue(com.taobao.tlog.remote.TLogRemoteMonitor.mea_errorCount, 0.0d);
        com.alibaba.mtl.appmonitor.AppMonitor.Stat.commit(com.taobao.tlog.remote.TLogRemoteMonitor.PAGE, com.taobao.tlog.remote.TLogRemoteMonitor.MONITOR_POINTER, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    @Override // com.taobao.tao.log.monitor.TLogMonitor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void stageInfo(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = ":"
            java.lang.String r1 = com.taobao.tlog.remote.TLogRemoteMonitor.TLOG_MODEL     // Catch: java.lang.Exception -> L6a
            java.lang.String r2 = r3.buildInfo(r5, r6)     // Catch: java.lang.Exception -> L6a
            com.taobao.tao.log.TLog.logi(r1, r4, r2)     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = com.taobao.tlog.remote.TLogRemoteMonitor.TAG     // Catch: java.lang.Exception -> L6a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a
            r2.<init>()     // Catch: java.lang.Exception -> L6a
            r2.append(r4)     // Catch: java.lang.Exception -> L6a
            r2.append(r0)     // Catch: java.lang.Exception -> L6a
            r2.append(r5)     // Catch: java.lang.Exception -> L6a
            r2.append(r0)     // Catch: java.lang.Exception -> L6a
            r2.append(r6)     // Catch: java.lang.Exception -> L6a
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> L6a
            android.util.Log.w(r1, r5)     // Catch: java.lang.Exception -> L6a
            r5 = 0
            java.lang.String r6 = com.taobao.tao.log.monitor.TLogStage.MSG_SEND     // Catch: java.lang.Exception -> L6a
            boolean r6 = r4.equals(r6)     // Catch: java.lang.Exception -> L6a
            if (r6 == 0) goto L32
            goto L45
        L32:
            java.lang.String r6 = com.taobao.tao.log.monitor.TLogStage.MSG_LOG_UPLOAD     // Catch: java.lang.Exception -> L6a
            boolean r6 = r4.equals(r6)     // Catch: java.lang.Exception -> L6a
            if (r6 == 0) goto L3b
            goto L45
        L3b:
            java.lang.String r6 = com.taobao.tao.log.monitor.TLogStage.MSG_REVEIVE     // Catch: java.lang.Exception -> L6a
            boolean r6 = r4.equals(r6)     // Catch: java.lang.Exception -> L6a
            if (r6 == 0) goto L44
            goto L45
        L44:
            r4 = r5
        L45:
            if (r4 == 0) goto L6e
            com.alibaba.mtl.appmonitor.model.DimensionValueSet r5 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.create()     // Catch: java.lang.Exception -> L6a
            java.lang.String r6 = com.taobao.tlog.remote.TLogRemoteMonitor.dim_stage     // Catch: java.lang.Exception -> L6a
            r5.setValue(r6, r4)     // Catch: java.lang.Exception -> L6a
            com.alibaba.mtl.appmonitor.model.MeasureValueSet r4 = com.alibaba.mtl.appmonitor.model.MeasureValueSet.create()     // Catch: java.lang.Exception -> L6a
            java.lang.String r6 = com.taobao.tlog.remote.TLogRemoteMonitor.mea_totalCount     // Catch: java.lang.Exception -> L6a
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r4.setValue(r6, r0)     // Catch: java.lang.Exception -> L6a
            java.lang.String r6 = com.taobao.tlog.remote.TLogRemoteMonitor.mea_errorCount     // Catch: java.lang.Exception -> L6a
            r0 = 0
            r4.setValue(r6, r0)     // Catch: java.lang.Exception -> L6a
            java.lang.String r6 = com.taobao.tlog.remote.TLogRemoteMonitor.PAGE     // Catch: java.lang.Exception -> L6a
            java.lang.String r0 = com.taobao.tlog.remote.TLogRemoteMonitor.MONITOR_POINTER     // Catch: java.lang.Exception -> L6a
            com.alibaba.mtl.appmonitor.AppMonitor.Stat.commit(r6, r0, r5, r4)     // Catch: java.lang.Exception -> L6a
            goto L6e
        L6a:
            r4 = move-exception
            r4.printStackTrace()
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tlog.remote.TLogRemoteMonitor.stageInfo(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageError(String str, String str2, Throwable th) {
        try {
            TLog.loge(TLOG_MODEL, str, th);
            String str3 = TAG;
            Log.e(str3, str + ":" + str2, th);
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.STACK;
            bizErrorModule.businessType = BIZ_ERROR_TYPE;
            bizErrorModule.exceptionCode = str;
            bizErrorModule.exceptionId = str2;
            bizErrorModule.exceptionVersion = BizErrorBuilder._VERSION;
            bizErrorModule.throwable = th;
            if (this.mContext != null) {
                BizErrorReporter.getInstance().send(this.mContext, bizErrorModule);
            } else {
                Log.e(TAG, "you need call TLogRemoteMonitor.init() method ");
            }
            monitorStageError(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
