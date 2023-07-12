package com.taobao.accs.init;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.asp.PrefsIPCChannel;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.ARanger;
import com.uc.webview.export.extension.UCCore;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_InitAgooLifecycle implements Serializable {
    private static final String TAG = Launcher_InitAgooLifecycle.class.getSimpleName();
    public static Class<?> adaemonClazz;
    public static long coldLaunchTimeInMill;
    public static boolean hasConnected;
    public static boolean mADaemonValid;
    private String mAppKey;
    private int mMode = 0;
    private String mProcess;

    static {
        try {
            adaemonClazz = Class.forName("com.taobao.adaemon.ADaemon");
            mADaemonValid = true;
        } catch (Exception unused) {
            mADaemonValid = false;
        }
        hasConnected = false;
    }

    private void coldLaunch(Context context) {
        boolean isMainProcess = UtilityImpl.isMainProcess(context);
        if ((!isMainProcess || UtilityImpl.isChannelProcessAlive(context)) && (!UtilityImpl.isChannelProcess(context) || UtilityImpl.isMainProcessAlive(context))) {
            return;
        }
        if (ConnectionServiceManager.getInstance().isEnabled(context)) {
            ConnectionServiceManager.getInstance().coldLaunch();
        }
        if (isMainProcess) {
            coldLaunchTimeInMill = SystemClock.elapsedRealtime();
        }
    }

    private void launchInMain(Application application, HashMap<String, Object> hashMap) {
        ALog.e(TAG, "Launcher_InitAgooLifecycle in main", new Object[0]);
        ForeBackManager.getManager().initialize(application);
        GlobalClientInfo.getInstance(application).setRemoteAppReceiver("default", Launcher_InitAccs.mAppReceiver);
        ACCSManager.setAppkey(application, this.mAppKey, this.mMode);
        try {
            ARanger.addComponentAuthority(new ComponentName(application, PrefsIPCChannel.CORE_CONTENT_PROVIDER), UtilityImpl.getChannelProcessName(application));
        } catch (Throwable th) {
            ALog.e(TAG, "addComponentAuthority error", th, new Object[0]);
        }
        if (ConnectionServiceManager.getInstance().isAllWeather()) {
            new Launcher_InitAccs().initImpl(application, hashMap, 15);
        }
        if (mADaemonValid) {
            try {
                adaemonClazz.getMethod("initializeLifecycle", Context.class).invoke(null, application);
            } catch (Exception e) {
                ALog.e(TAG, "adaemon initializeLifecycle error", e, new Object[0]);
            }
        }
        if (ConnectionServiceManager.getInstance().isAllWeather()) {
            return;
        }
        registerConnReceiver(GlobalClientInfo.mContext);
    }

    public static synchronized void monitorConnected() {
        synchronized (Launcher_InitAgooLifecycle.class) {
            if (hasConnected) {
                return;
            }
            hasConnected = true;
            if (coldLaunchTimeInMill > 0) {
                final long elapsedRealtime = SystemClock.elapsedRealtime() - coldLaunchTimeInMill;
                String str = TAG;
                ALog.e(str, "accs connected, spent " + elapsedRealtime, new Object[0]);
                if (elapsedRealtime > 10000) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_COLD_LAUNCH_TIME, "", elapsedRealtime);
                } else {
                    ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitAgooLifecycle.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_COLD_LAUNCH_TIME, "", elapsedRealtime);
                        }
                    }, 10L, TimeUnit.SECONDS);
                }
            }
        }
    }

    private void parseMap(HashMap<String, Object> hashMap) {
        try {
            int intValue = ((Integer) hashMap.get("envIndex")).intValue();
            this.mProcess = (String) hashMap.get("process");
            this.mAppKey = (String) hashMap.get("onlineAppKey");
            boolean z = true;
            if (intValue == 1) {
                this.mAppKey = (String) hashMap.get("preAppKey");
                this.mMode = 1;
            } else {
                boolean z2 = intValue == 2;
                if (intValue != 3) {
                    z = false;
                }
                if (z2 | z) {
                    this.mAppKey = (String) hashMap.get("dailyAppkey");
                    this.mMode = 2;
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "init get param error", th, new Object[0]);
        }
        if (TextUtils.isEmpty(this.mAppKey)) {
            this.mAppKey = "21646297";
            this.mMode = 0;
        }
    }

    private void registerConnReceiver(final Context context) {
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.init.Launcher_InitAgooLifecycle.1
            @Override // java.lang.Runnable
            public void run() {
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.taobao.accs.init.Launcher_InitAgooLifecycle.1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        try {
                            if (((TaoBaseService.ConnectInfo) intent.getExtras().get(Constants.KEY_CONNECT_INFO)).connected) {
                                Launcher_InitAgooLifecycle.monitorConnected();
                                context2.unregisterReceiver(this);
                            }
                        } catch (Throwable th) {
                            ALog.e(Launcher_InitAgooLifecycle.TAG, "registerConnReceiver err", th, new Object[0]);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Constants.ACTION_CONNECT_INFO);
                context.registerReceiver(broadcastReceiver, intentFilter);
            }
        });
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        Context applicationContext = application.getApplicationContext();
        GlobalClientInfo.mContext = applicationContext;
        UtilityImpl.debug(applicationContext);
        String str = TAG;
        ALog.i(str, UCCore.LEGACY_EVENT_INIT, new Object[0]);
        parseMap(hashMap);
        ARanger.init(application);
        coldLaunch(application);
        if (UtilityImpl.isMainProcess(application)) {
            launchInMain(application, hashMap);
            return;
        }
        ALog.e(str, "Launcher_InitAgooLifecycle in " + this.mProcess, new Object[0]);
    }
}
