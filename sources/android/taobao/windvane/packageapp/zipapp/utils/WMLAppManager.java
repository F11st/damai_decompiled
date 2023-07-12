package android.taobao.windvane.packageapp.zipapp.utils;

import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.monitor.WVPackageMonitorInterface;
import android.taobao.windvane.packageapp.zipapp.data.WMLWrapData;
import android.taobao.windvane.packageapp.zipapp.utils.InstantPerformanceData;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.taobao.zcache.ZCacheInitTask;
import com.taobao.zcache.ZCacheManager;
import com.taobao.zcachecorewrapper.IZCacheCore;
import com.taobao.zcachecorewrapper.model.AppInfo;
import com.taobao.zcachecorewrapper.model.Error;
import java.io.File;
import java.util.Set;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WMLAppManager {
    private static WMLAppManager sInstance;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface LoadAppCallback {
        void onError(String str, String str2);

        void onLoaded(WMLWrapData wMLWrapData);

        void onProgress(int i);
    }

    public static WMLAppManager getInstance() {
        if (sInstance == null) {
            synchronized (WMLAppManager.class) {
                if (sInstance == null) {
                    sInstance = new WMLAppManager();
                }
            }
        }
        return sInstance;
    }

    public void closeApp(String str) {
        ZCacheManager.instance().resumeApp(str);
    }

    public void commitVisit(String str) {
    }

    public void deleteApp(String str) {
        ZCacheManager.instance().removeAZCache(str);
    }

    public boolean isApp(String str) {
        return false;
    }

    public void loadApp(final String str, final LoadAppCallback loadAppCallback) {
        final InstantPerformanceData instantPerformanceData = new InstantPerformanceData();
        instantPerformanceData.t_startTime = System.currentTimeMillis();
        instantPerformanceData.appName = str;
        instantPerformanceData.type = "3";
        ZCacheInitTask.getInstance().init();
        ZCacheManager.instance().getAppPath(str, new IZCacheCore.AppInfoCallback() { // from class: android.taobao.windvane.packageapp.zipapp.utils.WMLAppManager.1
            @Override // com.taobao.zcachecorewrapper.IZCacheCore.AppInfoCallback
            public void onReceive(AppInfo appInfo, Error error) {
                long j;
                instantPerformanceData.t_endTime = System.currentTimeMillis();
                if (appInfo != null) {
                    j = appInfo.downloadDuration;
                    WMLWrapData wMLWrapData = new WMLWrapData();
                    if (TextUtils.isEmpty(appInfo.rootPath)) {
                        InstantPerformanceData instantPerformanceData2 = instantPerformanceData;
                        StringBuilder sb = new StringBuilder();
                        InstantPerformanceData.LoadType loadType = InstantPerformanceData.LoadType.LOAD_FOR_FILE_NOT_FOUND;
                        sb.append(loadType.getCode());
                        sb.append(":");
                        sb.append(loadType.getMsg());
                        instantPerformanceData2.msg = sb.toString();
                        loadAppCallback.onError(loadType.getCode(), loadType.getMsg());
                        if (WVMonitorService.getPackageMonitorInterface() != null) {
                            WVPackageMonitorInterface packageMonitorInterface = WVMonitorService.getPackageMonitorInterface();
                            InstantPerformanceData instantPerformanceData3 = instantPerformanceData;
                            packageMonitorInterface.commitZCacheDownLoadTime("3", instantPerformanceData3.appName, instantPerformanceData3.task_wait, j, instantPerformanceData3.t_endTime - instantPerformanceData3.t_startTime, instantPerformanceData3.msg, false);
                            return;
                        }
                        return;
                    }
                    instantPerformanceData.isSuccess = true;
                    ZCacheManager.instance().pauseApp(str);
                    wMLWrapData.setRootDir(new File(appInfo.rootPath));
                    if (appInfo.isAppInstalled) {
                        InstantPerformanceData instantPerformanceData4 = instantPerformanceData;
                        StringBuilder sb2 = new StringBuilder();
                        InstantPerformanceData.LoadType loadType2 = InstantPerformanceData.LoadType.LOAD_LOCAL;
                        sb2.append(loadType2.getCode());
                        sb2.append(":");
                        sb2.append(loadType2.getMsg());
                        instantPerformanceData4.msg = sb2.toString();
                        wMLWrapData.setStorage(loadType2.getMsg());
                    } else {
                        InstantPerformanceData instantPerformanceData5 = instantPerformanceData;
                        StringBuilder sb3 = new StringBuilder();
                        InstantPerformanceData.LoadType loadType3 = InstantPerformanceData.LoadType.LOAD_NORMAL;
                        sb3.append(loadType3.getCode());
                        sb3.append(":");
                        sb3.append(loadType3.getMsg());
                        instantPerformanceData5.msg = sb3.toString();
                        wMLWrapData.setStorage(loadType3.getMsg());
                    }
                    loadAppCallback.onLoaded(wMLWrapData);
                } else {
                    InstantPerformanceData instantPerformanceData6 = instantPerformanceData;
                    instantPerformanceData6.isSuccess = false;
                    StringBuilder sb4 = new StringBuilder();
                    InstantPerformanceData.LoadType loadType4 = InstantPerformanceData.LoadType.LOAD_OTHER_ERROR;
                    sb4.append(loadType4.getCode());
                    sb4.append(":");
                    sb4.append(loadType4.getMsg());
                    sb4.append(":");
                    sb4.append(error.errMsg);
                    instantPerformanceData6.msg = sb4.toString();
                    loadAppCallback.onError(String.valueOf(error.errCode), error.errMsg);
                    j = 0;
                }
                long j2 = j;
                if (WVMonitorService.getPackageMonitorInterface() != null) {
                    WVPackageMonitorInterface packageMonitorInterface2 = WVMonitorService.getPackageMonitorInterface();
                    InstantPerformanceData instantPerformanceData7 = instantPerformanceData;
                    packageMonitorInterface2.commitZCacheDownLoadTime("3", instantPerformanceData7.appName, instantPerformanceData7.task_wait, j2, instantPerformanceData7.t_endTime - instantPerformanceData7.t_startTime, instantPerformanceData7.msg, instantPerformanceData7.isSuccess);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("miniApp use ZCache 3.0, name=[");
                sb5.append(str);
                sb5.append("], path=[");
                sb5.append(appInfo == null ? null : appInfo.rootPath);
                sb5.append("], code=[");
                sb5.append(error.errCode);
                sb5.append("]; msg=[");
                sb5.append(error.errMsg);
                sb5.append(jn1.ARRAY_END_STR);
                TaoLog.i("ZCache", sb5.toString());
            }
        });
    }

    public void prefetchApps(Set<String> set) {
    }

    public void setDamage(String str, boolean z) {
        ZCacheManager.instance().removeAZCache(str);
    }
}
