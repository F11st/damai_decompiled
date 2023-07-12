package com.taobao.android.launcher.statistics;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.SystemClock;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Request;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.android.job.core.base.Log;
import com.taobao.android.job.core.helper.ThreadPoolHelpers;
import com.taobao.android.job.core.task.ExecutionSummary;
import com.taobao.android.launcher.Constants;
import com.taobao.android.launcher.common.LauncherRuntime;
import com.taobao.android.launcher.statistics.common.monitor.image.Phenix;
import com.taobao.android.launcher.statistics.common.monitor.network.Network;
import com.taobao.android.launcher.statistics.common.processes.AndroidAppProcess;
import com.taobao.android.launcher.statistics.common.processes.AndroidProcesses;
import com.taobao.android.launcher.statistics.common.processes.Stat;
import com.taobao.android.launcher.statistics.common.processes.Thread;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.b;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.model.ConfigDO;
import com.taobao.orange.model.NameSpaceDO;
import com.taobao.orange.util.OrangeUtils;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.c22;
import tb.k60;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class StartupDefaultImpl extends Startup {
    private static final String CONTENT_TYPE = "application/json";
    private static final String URL_STARTUP_OFFLINE = "http://tmq-service.taobao.org/api/whiteboxlaunchdata/uploadStartupInfo";
    private static final Map<String, Object> contentBody = new HashMap(16);
    private static final List<Map<String, Object>> stages = new ArrayList(16);
    private static final List<Map<String, Object>> janks = new ArrayList(16);
    private final Phenix phenix = new Phenix();
    private final Network network = new Network();

    private void addExtra() {
        Map<String, Object> map = contentBody;
        map.put("jank", janks);
        map.put(TLogEventConst.PARAM_UPLOAD_STAGE, stages);
        addZCache();
    }

    private static void addGeneralInfo() {
        HashMap hashMap = new HashMap(20);
        hashMap.put("device_brand", Build.getBRAND());
        hashMap.put("device_core_size", Integer.valueOf(ThreadPoolHelpers.poolSize(0.0d)));
        hashMap.put("device_manufacturer", Build.getMANUFACTURER());
        hashMap.put(IRequestConst.DEVICE_MODEL, Build.getMODEL());
        hashMap.put("os", "android");
        hashMap.put("os_version", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("package_debug", Boolean.valueOf(LauncherRuntime.sDebuggable));
        hashMap.put("package_tag", LauncherRuntime.sPackageTag);
        hashMap.put("packageName", LauncherRuntime.sPackageName);
        hashMap.put("app_version", LauncherRuntime.sAppVersion);
        IAppPreferences d = b.d();
        hashMap.put("device_score", Integer.valueOf(d.getInt("oldDeviceScore", 60)));
        hashMap.put("app_status_is_full_new_install", Boolean.valueOf(d.getBoolean("isFullNewInstall", false)));
        hashMap.put("app_status_is_first_launch", Boolean.valueOf(d.getBoolean("isFirstLaunch", false)));
        hashMap.put("start_time", Long.valueOf(LauncherRuntime.sStartTime));
        contentBody.putAll(hashMap);
    }

    private void addImages() {
        this.phenix.stop();
        HashMap hashMap = new HashMap(4);
        ArrayList arrayList = new ArrayList(this.phenix.requestedImages.size());
        for (Phenix.ImageInfo imageInfo : this.phenix.requestedImages) {
            arrayList.add(imageInfo.toMap());
        }
        hashMap.put("requested", arrayList);
        ArrayList arrayList2 = new ArrayList(this.phenix.finishedImages.size());
        for (Phenix.ImageInfo imageInfo2 : this.phenix.finishedImages) {
            arrayList2.add(imageInfo2.toMap());
        }
        hashMap.put("finished", arrayList2);
        ArrayList arrayList3 = new ArrayList(this.phenix.canceledImages.size());
        for (Phenix.ImageInfo imageInfo3 : this.phenix.canceledImages) {
            arrayList3.add(imageInfo3.toMap());
        }
        hashMap.put("canceled", arrayList3);
        ArrayList arrayList4 = new ArrayList(this.phenix.failedImages.size());
        for (Phenix.ImageInfo imageInfo4 : this.phenix.failedImages) {
            arrayList4.add(imageInfo4.toMap());
        }
        hashMap.put("failed", arrayList4);
        contentBody.put("image", hashMap);
    }

    private void addNetworks() {
        this.network.stop();
        ArrayList arrayList = new ArrayList(this.network.otherRequests.size());
        for (Network.RequestInfo requestInfo : this.network.otherRequests) {
            arrayList.add(requestInfo.toMap());
        }
        contentBody.put("network", arrayList);
    }

    private void addOrange() {
        Map sortMapByKey = OrangeUtils.sortMapByKey(ConfigCenter.getInstance().getConfigCache().getConfigMap(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("total_count", Integer.valueOf(sortMapByKey.size()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = sortMapByKey.entrySet().iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            ConfigDO configDO = (ConfigDO) ((Map.Entry) it.next()).getValue();
            Iterator it2 = it;
            HashMap hashMap2 = hashMap;
            if (NameSpaceDO.LEVEL_HIGH.equals(configDO.loadLevel)) {
                i++;
                Map<String, String> map = configDO.content;
                if (map != null) {
                    i5 += map.size();
                }
                arrayList.add(createFromConfig(configDO));
            } else if ("HIGH_INIT".equals(configDO.loadLevel)) {
                i2++;
                Map<String, String> map2 = configDO.content;
                if (map2 != null) {
                    i6 += map2.size();
                }
                arrayList2.add(createFromConfig(configDO));
            } else if ("HIGH_LAZY".equals(configDO.loadLevel)) {
                i3++;
                Map<String, String> map3 = configDO.content;
                if (map3 != null) {
                    i7 += map3.size();
                }
                arrayList3.add(createFromConfig(configDO));
            } else if ("DEFAULT".equals(configDO.loadLevel)) {
                i4++;
                Map<String, String> map4 = configDO.content;
                if (map4 != null) {
                    i8 += map4.size();
                }
                arrayList4.add(createFromConfig(configDO));
            }
            it = it2;
            hashMap = hashMap2;
        }
        HashMap hashMap3 = hashMap;
        hashMap3.put("high_count", Integer.valueOf(i));
        hashMap3.put("high_detail", arrayList);
        hashMap3.put("high_init_count", Integer.valueOf(i2));
        hashMap3.put("high_init_detail", arrayList2);
        hashMap3.put("high_lazy_count", Integer.valueOf(i3));
        hashMap3.put("high_lazy_detail", arrayList3);
        hashMap3.put("default_count", Integer.valueOf(i4));
        hashMap3.put("default_detail", arrayList4);
        hashMap3.put("high_size", Integer.valueOf(i5));
        hashMap3.put("high_init_size", Integer.valueOf(i6));
        hashMap3.put("high_lazy_size", Integer.valueOf(i7));
        hashMap3.put("default_size", Integer.valueOf(i8));
        hashMap3.put("total_size", Integer.valueOf(i5 + i6 + i7 + i8));
        contentBody.put("orange", hashMap3);
    }

    private void addProcessesAndThreads(Context context) {
        List<AndroidAppProcess> runningAppProcesses = AndroidProcesses.getRunningAppProcesses();
        ArrayList arrayList = new ArrayList(runningAppProcesses.size());
        for (AndroidAppProcess androidAppProcess : runningAppProcesses) {
            HashMap hashMap = new HashMap(6);
            hashMap.put("name", androidAppProcess.name);
            hashMap.put("is_foreground", Boolean.valueOf(androidAppProcess.foreground));
            try {
                Stat stat = androidAppProcess.stat();
                long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                long starttime = stat.starttime();
                Long.signum(starttime);
                hashMap.put("start_time", Long.valueOf(currentTimeMillis + (starttime * 10)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<Thread> threads = androidAppProcess.getThreads();
            ArrayList arrayList2 = new ArrayList(threads.size());
            for (Thread thread : threads) {
                arrayList2.add(thread.name);
            }
            hashMap.put("thread", arrayList2);
            Debug.MemoryInfo memoryInfo = androidAppProcess.getMemoryInfo(context);
            if (memoryInfo != null) {
                hashMap.put("memory", getUnionMemInfo(memoryInfo));
            }
            arrayList.add(hashMap);
        }
        contentBody.put("process", arrayList);
    }

    private void addZCache() {
    }

    private void commit(Context context) {
        k60 k60Var = new k60(context);
        Request c22Var = new c22(URL_STARTUP_OFFLINE);
        c22Var.setMethod("POST");
        c22Var.setCharset("UTF-8");
        c22Var.setFollowRedirects(true);
        c22Var.setRetryTime(3);
        c22Var.addHeader("Content-Type", CONTENT_TYPE);
        ByteArrayEntry byteArrayEntry = new ByteArrayEntry(JSON.toJSONBytes(contentBody, new SerializerFeature[0]));
        byteArrayEntry.setContentType(CONTENT_TYPE);
        c22Var.setBodyEntry(byteArrayEntry);
        try {
            if (k60Var.syncSend(c22Var, null).getStatusCode() == 200) {
                Log.e(Startups.TAG, "[Startup][commit] success", new Object[0]);
            }
        } catch (Throwable th) {
            Log.e(Startups.TAG, "[Startup][commit] failed:", th);
        }
    }

    private Map<String, Object> createFromConfig(ConfigDO configDO) {
        HashMap hashMap = new HashMap(8);
        hashMap.put("name", configDO.name);
        hashMap.put("type", configDO.type);
        hashMap.put("create_time", configDO.createTime);
        hashMap.put("resource_id", configDO.resourceId);
        hashMap.put("version", configDO.version);
        hashMap.put("id", configDO.id);
        hashMap.put("load_level", configDO.loadLevel);
        Map<String, String> map = configDO.content;
        if (map != null) {
            hashMap.put("content_size", Integer.valueOf(map.size()));
        } else {
            hashMap.put("content_size", 0);
        }
        return hashMap;
    }

    private static Map<String, String> getUnionMemInfo(Debug.MemoryInfo memoryInfo) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return memoryInfo.getMemoryStats();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("summary.java-heap", Integer.toString(memoryInfo.dalvikPss));
        hashMap.put("summary.native-heap", Integer.toString(memoryInfo.nativePss));
        hashMap.put("summary.other", Integer.toString(memoryInfo.otherPss));
        hashMap.put("summary.total-pss", Integer.toString(memoryInfo.getTotalPss()));
        if (i >= 19) {
            hashMap.put("summary.total-swap", Integer.toString(memoryInfo.getTotalSwappablePss()));
        }
        return hashMap;
    }

    @Override // com.taobao.android.launcher.statistics.Startup
    public void addJank(int i, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(AdUtConstants.XAD_UT_ARG_COUNT, Integer.valueOf(i));
        hashMap.put("time", Long.valueOf(j));
        janks.add(hashMap);
    }

    @Override // com.taobao.android.launcher.statistics.Startup
    public void addStage(String str, ExecutionSummary executionSummary, Map<String, ExecutionSummary> map) {
        HashMap hashMap = new HashMap(8);
        if (Constants.STAGE_MAIN_BOOT_FINISH.equals(str)) {
            contentBody.put("startup_duration", Long.valueOf(executionSummary.startTime - LauncherRuntime.sStartTime));
        }
        hashMap.put("stage_name", str);
        hashMap.put("stage_execution_start", Long.valueOf(executionSummary.startTime));
        hashMap.put("stage_execution_end", Long.valueOf(executionSummary.endTime));
        hashMap.put("stage_execution_duration", Long.valueOf(executionSummary.endTime - executionSummary.startTime));
        hashMap.put("stage_execution_node_count_total", Integer.valueOf(executionSummary.total));
        hashMap.put("stage_execution_node_count_executed", Integer.valueOf(executionSummary.executed));
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, ExecutionSummary> entry : map.entrySet()) {
            HashMap hashMap2 = new HashMap(5);
            hashMap2.put("name", entry.getKey());
            ExecutionSummary value = entry.getValue();
            hashMap2.put("start_time", Long.valueOf(value.startTime));
            hashMap2.put("end_time", Long.valueOf(value.endTime));
            hashMap2.put("duration", Long.valueOf(value.endTime - value.startTime));
            hashMap2.put("is_main_thread", Boolean.valueOf(value.isMainThread));
            arrayList.add(hashMap2);
        }
        hashMap.put("launchers", arrayList);
        stages.add(hashMap);
    }

    @Override // com.taobao.android.launcher.statistics.Startup
    public void dump(Context context) {
        try {
            addProcessesAndThreads(context);
            addOrange();
            addImages();
            addNetworks();
        } catch (Throwable th) {
            Log.e(Startups.TAG, "dump error:", th);
        }
    }

    @Override // com.taobao.android.launcher.statistics.Startup
    public void start() {
        this.phenix.start();
    }

    @Override // com.taobao.android.launcher.statistics.Startup
    public void submit(Context context) {
        Log.e(Startups.TAG, "[Startup][commit] start", new Object[0]);
        addGeneralInfo();
        addExtra();
        commit(context);
    }

    @Override // com.taobao.android.launcher.statistics.Startup
    public void teardown() {
        contentBody.clear();
        stages.clear();
        janks.clear();
        this.phenix.clear();
        this.network.clear();
    }
}
