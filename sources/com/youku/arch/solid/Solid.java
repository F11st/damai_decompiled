package com.youku.arch.solid;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DownloadItem;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.download.IDownloadListener;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.DefaultMonitorImpl;
import com.youku.arch.solid.monitor.IMonitor;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.TimeUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Solid {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile boolean hasStarted;
    private static volatile boolean isAllSoDownloaded;
    private static volatile boolean isAutoDownloading;
    private ActivityManager activityManager;
    private Application application;
    private SolidConfig mConfig;
    private IMonitor mMonitor = new DefaultMonitorImpl();
    private final SoInfoManager mSoInfoManager = new SoInfoManager();
    private final ComponentCallbacks2 mComponentCallbacks2 = new ComponentCallbacks2() { // from class: com.youku.arch.solid.Solid.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-867583063")) {
                ipChange.ipc$dispatch("-867583063", new Object[]{this, configuration});
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1276304592")) {
                ipChange.ipc$dispatch("1276304592", new Object[]{this});
            }
        }

        @Override // android.content.ComponentCallbacks2
        @TargetApi(14)
        public void onTrimMemory(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1624417439")) {
                ipChange.ipc$dispatch("-1624417439", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 20) {
                Solid solid = Solid.this;
                if (solid.getAm(solid.application) == null) {
                    return;
                }
                Solid solid2 = Solid.this;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = solid2.getAm(solid2.application).getRunningAppProcesses();
                if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
                    if (runningAppProcessInfo.uid == Solid.this.application.getApplicationInfo().uid && runningAppProcessInfo.importance == 100) {
                        return;
                    }
                }
                Solid.this.autoDownload();
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnInitFinishCallback {
        void onFinish(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    static class SingletonHolder {
        static Solid mInstance = new Solid();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoDownload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257001568")) {
            ipChange.ipc$dispatch("-257001568", new Object[]{this});
            return;
        }
        SLog.e("autoDownload", "Ready to auto download.");
        if (isAllSoDownloaded) {
            SLog.e("autoDownload", "All so auto downloaded, return out.");
        } else if (isAutoDownloading) {
            SLog.e("autoDownload", "Still auto downloading, return out.");
        } else {
            isAutoDownloading = true;
            if (download(true, (SoGroupWrapper[]) this.mSoInfoManager.soGroupMap.values().toArray(new SoGroupWrapper[this.mSoInfoManager.soGroupMap.values().size()]))) {
                return;
            }
            isAutoDownloading = false;
            isAllSoDownloaded = true;
            SLog.e("autoDownload", "All so auto downloaded, return out.");
        }
    }

    private DownloadItem buildZipDownloadItem(boolean z, ZipDownloadItem zipDownloadItem) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-589351931") ? (DownloadItem) ipChange.ipc$dispatch("-589351931", new Object[]{this, Boolean.valueOf(z), zipDownloadItem}) : new DownloadItem.Builder().setUrl(zipDownloadItem.getZipUrl()).setMd5(zipDownloadItem.getZipMd5()).setPath(this.mConfig.getZipPath()).setName(zipDownloadItem.getZipName()).setPriority(zipDownloadItem.getZipPriority(z)).setZipDownloadItem(zipDownloadItem).build();
    }

    private boolean download(boolean z, SoGroupWrapper... soGroupWrapperArr) {
        DownloadItem build;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980438020")) {
            return ((Boolean) ipChange.ipc$dispatch("-1980438020", new Object[]{this, Boolean.valueOf(z), soGroupWrapperArr})).booleanValue();
        }
        if (isLocal()) {
            return false;
        }
        String str = z ? "autoDownload" : "driveDownload";
        DownloadTask downloadTask = new DownloadTask();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList<SoInfoWrapper> arrayList = new ArrayList();
        for (SoGroupWrapper soGroupWrapper : soGroupWrapperArr) {
            if (soGroupWrapper != null) {
                if (this.mConfig.useCompress() && soGroupWrapper.needDownloadZip()) {
                    downloadTask.addDownloadItem(buildZipDownloadItem(z, soGroupWrapper));
                    sb.append(soGroupWrapper.getZipName());
                    sb.append(";");
                } else {
                    arrayList.addAll(soGroupWrapper.getSoInfoList());
                }
            }
        }
        for (SoInfoWrapper soInfoWrapper : arrayList) {
            if (soInfoWrapper.needDownload()) {
                if (this.mConfig.useCompress() && soInfoWrapper.needDownloadZip()) {
                    build = buildZipDownloadItem(z, soInfoWrapper);
                } else {
                    build = new DownloadItem.Builder().setUrl(soInfoWrapper.url()).setMd5(soInfoWrapper.md5()).setPath(this.mConfig.getLibInstallPath()).setName(soInfoWrapper.soFileName()).setPriority(soInfoWrapper.priority(z)).build();
                }
                soInfoWrapper.updateStatus(Status.DOWNLOADING);
                downloadTask.addDownloadItem(build);
                sb.append(soInfoWrapper.soFileName());
                sb.append(";");
                SoGroupWrapper belongGroup = soInfoWrapper.getBelongGroup();
                if (belongGroup != null && sb2.indexOf(belongGroup.name()) < 0) {
                    sb2.append(belongGroup.name());
                    sb2.append(";");
                }
            }
        }
        if (downloadTask.getDownloadCount() > 0) {
            doDownload(str, z, downloadTask);
            HashMap hashMap = new HashMap();
            hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_COUNT, downloadTask.getDownloadCount() + "");
            hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_SO_LIST, sb.toString());
            hashMap.put(SolidMonitor.Params.NEED_DOWNLOAD_GROUP_LIST, sb2.toString());
            this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_REQUEST, hashMap);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActivityManager getAm(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605176625")) {
            return (ActivityManager) ipChange.ipc$dispatch("-605176625", new Object[]{this, application});
        }
        try {
            if (this.activityManager == null) {
                this.activityManager = (ActivityManager) application.getSystemService("activity");
            }
        } catch (Throwable unused) {
        }
        return this.activityManager;
    }

    public static Solid getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "863140251") ? (Solid) ipChange.ipc$dispatch("863140251", new Object[0]) : SingletonHolder.mInstance;
    }

    private void registerSystem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704072731")) {
            ipChange.ipc$dispatch("-1704072731", new Object[]{this});
            return;
        }
        this.application.registerComponentCallbacks(this.mComponentCallbacks2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.application.registerReceiver(new BroadcastReceiver() { // from class: com.youku.arch.solid.Solid.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "120553254")) {
                    ipChange2.ipc$dispatch("120553254", new Object[]{this, context, intent});
                } else {
                    Solid.this.autoDownload();
                }
            }
        }, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDownload(final String str, final boolean z, DownloadTask downloadTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109944234")) {
            ipChange.ipc$dispatch("2109944234", new Object[]{this, str, Boolean.valueOf(z), downloadTask});
            return;
        }
        SLog.e(str, str + ": Ready to download.");
        final long curTimeStamp = TimeUtil.getCurTimeStamp();
        this.mConfig.getDownloader().download(downloadTask, new IDownloadListener() { // from class: com.youku.arch.solid.Solid.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onError() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1115121307")) {
                    ipChange2.ipc$dispatch("1115121307", new Object[]{this});
                    return;
                }
                if (z) {
                    boolean unused = Solid.isAutoDownloading = false;
                }
                SLog.e(str, "download finish, status: fail");
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onLibError(DownloadItem downloadItem, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1036182724")) {
                    ipChange2.ipc$dispatch("1036182724", new Object[]{this, downloadItem, str2});
                    return;
                }
                String name = downloadItem.getName();
                String str3 = str;
                SLog.d(str3, "download single file fail -> " + name + ", errmsg -> " + str2);
                StringBuilder sb = new StringBuilder();
                sb.append(downloadItem.getPath());
                sb.append(File.separator);
                sb.append(name);
                File file = new File(sb.toString());
                if (file.exists()) {
                    file.delete();
                }
                SoInfoWrapper soInfoWithSoName = Solid.this.mSoInfoManager.getSoInfoWithSoName(name);
                if (soInfoWithSoName != null) {
                    soInfoWithSoName.updateStatus(Status.DOWNLOAD_FAIL);
                }
                if (downloadItem.getZipDownloadItem() != null) {
                    downloadItem.getZipDownloadItem().downloadFail();
                }
                HashMap hashMap = new HashMap();
                SolidMonitor.Params params = SolidMonitor.Params.ELAPSE_SINCE_LAUNCH;
                hashMap.put(params, Solid.this.getElapseSinceLaunch() + "");
                SolidMonitor.Params params2 = SolidMonitor.Params.ERROR_MSG;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "unKnow";
                }
                hashMap.put(params2, str2);
                hashMap.put(SolidMonitor.Params.LIB_NAME, name);
                SolidMonitor.Params params3 = SolidMonitor.Params.COST_TIME;
                hashMap.put(params3, (TimeUtil.getCurTimeStamp() - curTimeStamp) + "");
                hashMap.put(SolidMonitor.Params.SUCCESS, "0");
                Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_LIB_DOWNLOAD, hashMap);
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onLibStart(DownloadItem downloadItem) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "680991712")) {
                    ipChange2.ipc$dispatch("680991712", new Object[]{this, downloadItem});
                    return;
                }
                String name = downloadItem.getName();
                String str2 = str;
                SLog.d(str2, "download single file start -> " + name);
                HashMap hashMap = new HashMap();
                hashMap.put(SolidMonitor.Params.LIB_NAME, name);
                Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_LIB_START_DOWNLOAD, hashMap);
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onLibSuccess(DownloadItem downloadItem, String str2, long j) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "894973819")) {
                    ipChange2.ipc$dispatch("894973819", new Object[]{this, downloadItem, str2, Long.valueOf(j)});
                    return;
                }
                File file = new File(str2);
                String name = downloadItem.getName();
                String str3 = str;
                SLog.d(str3, "download single file success -> " + name);
                HashMap hashMap = new HashMap();
                SolidMonitor.Params params = SolidMonitor.Params.ELAPSE_SINCE_LAUNCH;
                hashMap.put(params, Solid.this.getElapseSinceLaunch() + "");
                SolidMonitor.Params params2 = SolidMonitor.Params.LIB_NAME;
                hashMap.put(params2, name);
                SolidMonitor.Params params3 = SolidMonitor.Params.COST_TIME;
                hashMap.put(params3, j + "");
                SolidMonitor.Params params4 = SolidMonitor.Params.SUCCESS;
                hashMap.put(params4, "1");
                SolidMonitor.Params params5 = SolidMonitor.Params.FILE_SIZE;
                hashMap.put(params5, file.length() + "");
                Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_LIB_DOWNLOAD, hashMap);
                if (downloadItem.getZipDownloadItem() == null) {
                    SoInfoWrapper soInfoWithSoName = Solid.this.mSoInfoManager.getSoInfoWithSoName(name);
                    if (soInfoWithSoName == null) {
                        return;
                    }
                    soInfoWithSoName.setLocalFile(file);
                    Status status = Status.DOWNLOADED;
                    soInfoWithSoName.updateStatus(status);
                    SoGroupWrapper belongGroup = soInfoWithSoName.getBelongGroup();
                    if (belongGroup == null || belongGroup.status() != status) {
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(params, Solid.this.getElapseSinceLaunch() + "");
                    hashMap2.put(params2, belongGroup.name());
                    hashMap2.put(params3, (TimeUtil.getCurTimeStamp() - curTimeStamp) + "");
                    hashMap2.put(params4, "1");
                    Solid.this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_GROUP_DOWNLOAD, hashMap2);
                    return;
                }
                ZipProcessor.unzip(downloadItem.getZipDownloadItem(), file);
            }

            @Override // com.youku.arch.solid.download.IDownloadListener
            public void onSuccess(long j) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "199507844")) {
                    ipChange2.ipc$dispatch("199507844", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                if (z) {
                    boolean unused = Solid.isAutoDownloading = false;
                }
                SLog.e(str, "download finish, status: success");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void driveDownload(SoGroupWrapper soGroupWrapper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309975161")) {
            ipChange.ipc$dispatch("-1309975161", new Object[]{this, soGroupWrapper});
            return;
        }
        for (SoInfoWrapper soInfoWrapper : soGroupWrapper.getSoInfoList()) {
            soInfoWrapper.setDrive();
        }
        if (hasStarted()) {
            download(false, soGroupWrapper);
            return;
        }
        SLog.e("driveDownload", "driveDownload: " + soGroupWrapper.name() + " download failed, solid has not started");
    }

    public void executeTask(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262763383")) {
            ipChange.ipc$dispatch("262763383", new Object[]{this, runnable});
        } else {
            this.mConfig.getExecutor().execute(runnable);
        }
    }

    public Application getApplication() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1137862732") ? (Application) ipChange.ipc$dispatch("1137862732", new Object[]{this}) : this.application;
    }

    public SolidConfig getConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1358249818") ? (SolidConfig) ipChange.ipc$dispatch("-1358249818", new Object[]{this}) : this.mConfig;
    }

    public long getElapseSinceLaunch() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1896872988") ? ((Long) ipChange.ipc$dispatch("1896872988", new Object[]{this})).longValue() : TimeUtil.getCurTimeStamp() - this.mConfig.getLaunchTimeMillions();
    }

    public IMonitor getMonitor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1230442549") ? (IMonitor) ipChange.ipc$dispatch("1230442549", new Object[]{this}) : this.mConfig.getMonitor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoGroupWrapper getSoGroupWithName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-548456645") ? (SoGroupWrapper) ipChange.ipc$dispatch("-548456645", new Object[]{this, str}) : this.mSoInfoManager.getSoGroupWithName(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoInfoWrapper getSoInfoWithSoName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1455842667") ? (SoInfoWrapper) ipChange.ipc$dispatch("-1455842667", new Object[]{this, str}) : this.mSoInfoManager.getSoInfoWithSoName(str);
    }

    public boolean hasStarted() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-891428620") ? ((Boolean) ipChange.ipc$dispatch("-891428620", new Object[]{this})).booleanValue() : hasStarted;
    }

    public void init(SolidConfig solidConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108494254")) {
            ipChange.ipc$dispatch("-108494254", new Object[]{this, solidConfig});
        } else {
            init(solidConfig, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLocal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-253638826") ? ((Boolean) ipChange.ipc$dispatch("-253638826", new Object[]{this})).booleanValue() : this.mSoInfoManager.isLocal();
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203594033")) {
            ipChange.ipc$dispatch("1203594033", new Object[]{this});
            return;
        }
        long curTimeStamp = TimeUtil.getCurTimeStamp();
        this.mConfig.getDownloader().init();
        autoDownload();
        registerSystem();
        HashMap hashMap = new HashMap();
        SolidMonitor.Params params = SolidMonitor.Params.ELAPSE_SINCE_LAUNCH;
        hashMap.put(params, getElapseSinceLaunch() + "");
        SolidMonitor.Params params2 = SolidMonitor.Params.COST_TIME;
        hashMap.put(params2, (TimeUtil.getCurTimeStamp() - curTimeStamp) + "");
        this.mMonitor.reportStageResult(SolidMonitor.Stage.SOLID_START, hashMap);
        hasStarted = true;
    }

    public void init(SolidConfig solidConfig, final OnInitFinishCallback onInitFinishCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1412731930")) {
            ipChange.ipc$dispatch("-1412731930", new Object[]{this, solidConfig, onInitFinishCallback});
            return;
        }
        this.mConfig = solidConfig;
        this.mMonitor = solidConfig.getMonitor();
        this.application = solidConfig.getApplication();
        SoLoader.appendLibSearchPath(this.mConfig.getLibInstallPath());
        executeTask(new Runnable() { // from class: com.youku.arch.solid.Solid.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2094687898")) {
                    ipChange2.ipc$dispatch("2094687898", new Object[]{this});
                    return;
                }
                boolean prepare = Solid.this.mSoInfoManager.prepare();
                SLog.e("Prepare", "prepare so info finish: " + prepare);
                OnInitFinishCallback onInitFinishCallback2 = onInitFinishCallback;
                if (onInitFinishCallback2 != null) {
                    onInitFinishCallback2.onFinish(prepare);
                }
            }
        });
    }
}
