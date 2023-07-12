package com.taobao.android.launcher.statistics;

import android.content.Context;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.job.core.DAGStage;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.ThreadPoolHelpers;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.common.Constants;
import com.taobao.android.launcher.common.LauncherParam;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.statistics.LazyExecutor;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import com.taobao.weex.adapter.URIAdapter;
import java.util.HashMap;
import tb.c22;
import tb.k60;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGRuntime {
    private static final String CONTENT_TPYE = "application/json";
    private static final String TAG = "DAGRuntime";
    private static final String URL_OFFLINE = "http://tmq-service.taobao.org/task_exec/reportPerformance";

    public static void commitPoints(final Context context) {
        LazyExecutor.Startup.EXECUTOR.submit(new Runnable() { // from class: com.taobao.android.launcher.statistics.DAGRuntime.2
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
                if (r8 != 0) goto L16;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r16 = this;
                    java.util.Map<java.lang.String, java.util.Set<com.taobao.android.launcher.statistics.TaoTrace$Point>> r0 = com.taobao.android.launcher.statistics.TaoTrace.sCustomPoints
                    if (r0 == 0) goto Lae
                    java.util.Set r0 = r0.keySet()
                    java.util.Iterator r0 = r0.iterator()
                Lc:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto La6
                    java.lang.Object r1 = r0.next()
                    java.lang.String r1 = (java.lang.String) r1
                    java.util.Map<java.lang.String, java.util.Set<com.taobao.android.launcher.statistics.TaoTrace$Point>> r2 = com.taobao.android.launcher.statistics.TaoTrace.sCustomPoints
                    java.lang.Object r2 = r2.get(r1)
                    java.util.Set r2 = (java.util.Set) r2
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    int r5 = r2.size()
                    java.util.Iterator r2 = r2.iterator()
                    r8 = 0
                    r10 = 0
                L31:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L92
                    java.lang.Object r4 = r2.next()
                    com.taobao.android.launcher.statistics.TaoTrace$Point r4 = (com.taobao.android.launcher.statistics.TaoTrace.Point) r4
                    boolean r12 = r4.isValid()
                    if (r12 != 0) goto L44
                    goto L31
                L44:
                    java.util.Locale r12 = java.util.Locale.ENGLISH
                    r13 = 4
                    java.lang.Object[] r13 = new java.lang.Object[r13]
                    r14 = 0
                    java.lang.String r15 = r4.name
                    r13[r14] = r15
                    r14 = 1
                    long r6 = r4.startTime
                    java.lang.Long r6 = java.lang.Long.valueOf(r6)
                    r13[r14] = r6
                    r6 = 2
                    long r14 = r4.endTime
                    java.lang.Long r7 = java.lang.Long.valueOf(r14)
                    r13[r6] = r7
                    long r14 = r4.endTime
                    long r6 = r4.startTime
                    long r14 = r14 - r6
                    java.lang.Long r6 = java.lang.Long.valueOf(r14)
                    r7 = 3
                    r13[r7] = r6
                    java.lang.String r6 = "%s#ExecutionSummary{startTime=%d, endTime=%d, duration=%d, total=1, executed=1, isMainThread=0}[]"
                    java.lang.String r6 = java.lang.String.format(r12, r6, r13)
                    r3.append(r6)
                    java.lang.String r6 = "|"
                    r3.append(r6)
                    long r6 = r4.startTime
                    int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                    if (r12 > 0) goto L87
                    r12 = 0
                    int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                    if (r14 != 0) goto L8a
                    goto L89
                L87:
                    r12 = 0
                L89:
                    r8 = r6
                L8a:
                    long r6 = r4.endTime
                    int r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                    if (r4 >= 0) goto L31
                    r10 = r6
                    goto L31
                L92:
                    r4 = r5
                    r6 = r8
                    r8 = r10
                    com.taobao.android.job.core.task.ExecutionSummary r2 = com.taobao.android.job.core.task.ExecutionSummary.create(r4, r5, r6, r8)
                    r4 = r16
                    android.content.Context r5 = r1
                    java.lang.String r3 = r3.toString()
                    com.taobao.android.launcher.statistics.DAGRuntime.access$100(r5, r1, r2, r3)
                    goto Lc
                La6:
                    r4 = r16
                    java.util.Map<java.lang.String, java.util.Set<com.taobao.android.launcher.statistics.TaoTrace$Point>> r0 = com.taobao.android.launcher.statistics.TaoTrace.sCustomPoints
                    r0.clear()
                    goto Lb0
                Lae:
                    r4 = r16
                Lb0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.launcher.statistics.DAGRuntime.AnonymousClass2.run():void");
            }
        });
    }

    public static boolean isCustomPointEnabled() {
        return TaoTrace.isSwitchOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(Context context, String str, ExecutionSummary executionSummary, String str2) {
        HashMap hashMap = new HashMap(4);
        HashMap hashMap2 = new HashMap(28);
        k60 k60Var = new k60(context);
        Request c22Var = new c22(URL_OFFLINE);
        c22Var.setMethod("POST");
        c22Var.setCharset("UTF-8");
        c22Var.setFollowRedirects(true);
        c22Var.setRetryTime(3);
        c22Var.addHeader("Content-Type", CONTENT_TPYE);
        hashMap2.put("stage_name", str);
        hashMap2.put("stage_execution_start", Long.valueOf(executionSummary.startTime));
        hashMap2.put("stage_execution_end", Long.valueOf(executionSummary.endTime));
        hashMap2.put("stage_execution_node_count_total", Integer.valueOf(executionSummary.total));
        hashMap2.put("stage_execution_node_count_executed", Integer.valueOf(executionSummary.executed));
        hashMap2.put("scene", TAG);
        hashMap2.put("stage_summary", str2);
        hashMap2.put("app_process", LauncherRuntime.sProcessName);
        hashMap2.put("app_version", LauncherRuntime.sAppVersion);
        hashMap2.put("app_device_model", Build.getMODEL());
        hashMap2.put("app_device_brand", Build.getBRAND());
        hashMap2.put("app_device_core_size", Integer.valueOf(ThreadPoolHelpers.poolSize(0.0d)));
        IAppPreferences d = b.d();
        hashMap2.put("app_device_score", Integer.valueOf(d.getInt("oldDeviceScore", 60)));
        hashMap2.put("app_status_is_full_new_install", Boolean.valueOf(d.getBoolean("isFullNewInstall", false)));
        hashMap2.put("app_status_is_first_launch", Boolean.valueOf(d.getBoolean("isFirstLaunch", false)));
        hashMap2.put("app_device_manufacturer", Build.getMANUFACTURER());
        hashMap2.put("app_device_os", "android");
        hashMap2.put("app_package_debug", Boolean.valueOf(LauncherRuntime.sDebuggable));
        hashMap2.put("app_package_tag", LauncherRuntime.sPackageTag);
        hashMap.put("data_type", "launch_stage_summary");
        hashMap.put(com.alipay.sdk.m.l.b.h, LauncherParam.getParam(Constants.PARAMETER_CONSTANT_APPKEY, ""));
        hashMap.put("data", hashMap2);
        hashMap.put("exec_id", Long.valueOf(LauncherRuntime.sStartTime));
        int i = LauncherRuntime.sLaunchType;
        hashMap.put("launch_type", i == 1 ? URIAdapter.LINK : i == 2 ? "link-h5" : "normal");
        ByteArrayEntry byteArrayEntry = new ByteArrayEntry(JSON.toJSONBytes(hashMap, new SerializerFeature[0]));
        byteArrayEntry.setContentType(CONTENT_TPYE);
        c22Var.setBodyEntry(byteArrayEntry);
        Log.e(TAG, "[stage:%s][getResponse] exec_id=%d", str, Long.valueOf(LauncherRuntime.sStartTime));
        try {
            Response syncSend = k60Var.syncSend(c22Var, null);
            if (syncSend.getStatusCode() == 200) {
                Log.e(TAG, "[stage:%s][getResponse] id=%d", str, Long.valueOf(((JSONObject) JSON.parse(syncSend.getBytedata(), new Feature[0])).getJSONObject("resultData").getLongValue("id")));
            }
        } catch (Throwable th) {
            Log.e(TAG, "[stage:%s][getResponse] failed:", str, th);
        }
    }

    public static void reportDAGStage(final Context context, final DAGStage<String, Void> dAGStage, final ExecutionSummary executionSummary) {
        LazyExecutor.Startup.EXECUTOR.submit(new Runnable() { // from class: com.taobao.android.launcher.statistics.DAGRuntime.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DAGRuntime.reportDAGStageInternal(context, dAGStage, executionSummary);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportDAGStageInternal(Context context, DAGStage<String, Void> dAGStage, ExecutionSummary executionSummary) {
        StringBuilder sb = new StringBuilder();
        Startups.addStage(dAGStage.getName(), executionSummary, dAGStage.print(sb));
        report(context, dAGStage.getName(), executionSummary, sb.toString());
    }

    public static void reportPoint(String str, String str2, long j, long j2) {
        TaoTrace.duration(str, str2, j, j2);
    }
}
