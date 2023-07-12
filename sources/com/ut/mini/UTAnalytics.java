package com.ut.mini;

import android.app.Application;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.ut.mini.anti_cheat.AntiCheatTracker;
import com.ut.mini.behavior.UTBehavior;
import com.ut.mini.behavior.UTScrollTracker;
import com.ut.mini.behavior.edgecomputing.adapter.WalleDataCollectorAdapter;
import com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import com.ut.mini.crashhandler.UTMiniCrashHandler;
import com.ut.mini.exposure.TrackerManager;
import com.ut.mini.extend.TLogExtend;
import com.ut.mini.extend.UTExtendSwitch;
import com.ut.mini.extend.WindvaneExtend;
import com.ut.mini.internal.RealtimeDebugSwitch;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.module.UTOperationStack;
import com.ut.mini.module.appstatus.UTAppBackgroundTimeoutDetector;
import com.ut.mini.module.appstatus.UTAppStatusRegHelper;
import com.ut.mini.module.plugin.UTPlugin;
import com.ut.mini.module.plugin.UTPluginMgr;
import com.ut.mini.module.process.AbsMultiProcessAdapter;
import com.ut.mini.module.process.MultiProcessManager;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import com.ut.mini.mtop.UTMtopConfigExtend;
import com.ut.mini.scene.UTSceneMgr;
import com.ut.mini.scene.UTSceneTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.et2;
import tb.os2;
import tb.sj;
import tb.u6;
import tb.ut2;
import tb.we2;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTAnalytics {
    private static final String TAG = "UTAnalytics";
    public static final /* synthetic */ int a = 0;
    private UTTracker mDefaultTracker;
    private UTSceneTracker mUTSceneTracker;
    private static UTAnalytics s_instance = new UTAnalytics();
    private static volatile boolean mInit = false;
    private static volatile boolean mInit4app = false;
    private static boolean mIsMainProcess = true;
    private Map<String, UTTracker> mTrackerMap = new HashMap();
    private HashMap<String, UTTracker> mAppkeyTrackMap = new HashMap<>();

    private UTAnalytics() {
    }

    private boolean checkInit() {
        if (!AnalyticsMgr.g) {
            Logger.v("Please call setAppApplicationInstance() before call other method", new Object[0]);
        }
        return AnalyticsMgr.g;
    }

    private Runnable createTransferLogTask(final Map<String, String> map) {
        return new Runnable() { // from class: com.ut.mini.UTAnalytics.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AnalyticsMgr.b.transferLog(map);
                } catch (Throwable unused) {
                }
            }
        };
    }

    public static UTAnalytics getInstance() {
        return s_instance;
    }

    private void initialize(Application application, IUTApplication iUTApplication, boolean z) {
        Log.i(TAG, "initialize start...");
        setAppVersion(iUTApplication.getUTAppVersion());
        setChannel(iUTApplication.getUTChannel());
        if (iUTApplication.isAliyunOsSystem()) {
            getInstance().setToAliyunOsPlatform();
        }
        if (iUTApplication.isUTCrashHandlerDisable()) {
            UTMiniCrashHandler.getInstance().turnOff();
        } else {
            UTMiniCrashHandler.getInstance().turnOn(application.getApplicationContext());
            if (iUTApplication.getUTCrashCraughtListener() != null) {
                UTMiniCrashHandler.getInstance().setCrashCaughtListener(iUTApplication.getUTCrashCraughtListener());
            }
        }
        if (iUTApplication.isUTLogEnable()) {
            turnOnDebug();
        }
        if (!mInit || z) {
            setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
        }
        mIsMainProcess = u6.h(application.getApplicationContext());
        if (mInit) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14 && mIsMainProcess) {
            AbsMultiProcessAdapter multiProcessAdapter = MultiProcessManager.getMultiProcessAdapter();
            if (multiProcessAdapter != null) {
                try {
                    multiProcessAdapter.registerActivityLifecycleCallbacks();
                } catch (Exception e) {
                    UTAppStatusRegHelper.registeActivityLifecycleCallbacks(application);
                    e.printStackTrace();
                }
            } else {
                UTAppStatusRegHelper.registeActivityLifecycleCallbacks(application);
            }
            UTAppStatusRegHelper.registerAppStatusCallbacks(UTAppBackgroundTimeoutDetector.getInstance());
            UTAppStatusRegHelper.registerAppStatusCallbacks(UTMI1010_2001Event.getInstance());
            UTAppStatusRegHelper.registerAppStatusCallbacks(new RealtimeDebugSwitch());
            UTAppStatusRegHelper.registerAppStatusCallbacks(UTAppLaunch.getInstance());
            AntiCheatTracker.getInstance().init(application);
            TrackerManager.getInstance().init(application);
        }
        if (mIsMainProcess) {
            UTMtopConfigExtend.init();
            RepeatExposurePageMgr.getInstance().init();
            UTSceneMgr.init();
            UTBehavior.init();
            if (UTExtendSwitch.bUTDataCollector) {
                try {
                    UTDataCollector.init(application, WalleDataCollectorAdapter.getInstance());
                } catch (Exception unused) {
                }
            }
            UTPageSequenceMgr.init();
        }
        if (u6.i(application.getApplicationContext(), false)) {
            AnalyticsMgr.Z();
        }
    }

    private void setAppVersion(String str) {
        AnalyticsMgr.T(str);
    }

    private void setChannel(final String str) {
        AnalyticsMgr.U(str);
        try {
            AnalyticsMgr.d.a(new Runnable() { // from class: com.ut.mini.UTAnalytics.2
                @Override // java.lang.Runnable
                public void run() {
                    we2.b(sj.c().b(), "channel", str);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void setDelaySecond(int i) {
        AnalyticsMgr.V(i);
    }

    public static void setDisableWindvane(boolean z) {
        UTExtendSwitch.bWindvaneExtend = !z;
    }

    private void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        String appkey;
        boolean isEncode;
        String str;
        boolean z = false;
        Logger.m(TAG, "[setRequestAuthentication] start...", os2.a().getFullSDKVersion(), Boolean.valueOf(AnalyticsMgr.g));
        Objects.requireNonNull(iUTRequestAuthentication, "签名不能为空!");
        if (iUTRequestAuthentication instanceof UTSecurityThridRequestAuthentication) {
            UTSecurityThridRequestAuthentication uTSecurityThridRequestAuthentication = (UTSecurityThridRequestAuthentication) iUTRequestAuthentication;
            appkey = uTSecurityThridRequestAuthentication.getAppkey();
            str = uTSecurityThridRequestAuthentication.getAuthcode();
            isEncode = false;
            z = true;
        } else if (iUTRequestAuthentication instanceof UTBaseRequestAuthentication) {
            UTBaseRequestAuthentication uTBaseRequestAuthentication = (UTBaseRequestAuthentication) iUTRequestAuthentication;
            appkey = uTBaseRequestAuthentication.getAppkey();
            String appSecret = uTBaseRequestAuthentication.getAppSecret();
            isEncode = uTBaseRequestAuthentication.isEncode();
            str = appSecret;
        } else {
            throw new IllegalArgumentException("此签名方式暂不支持!请使用 UTSecuritySDKRequestAuthentication 或 UTBaseRequestAuthentication 设置签名!");
        }
        sj.c().k(appkey);
        AnalyticsMgr.X(z, isEncode, appkey, str);
    }

    private void turnOffCrashHandler() {
        UTMiniCrashHandler.getInstance().turnOff();
    }

    private void turnOnDebug() {
        AnalyticsMgr.b0();
    }

    public void dispatchLocalHits() {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() { // from class: com.ut.mini.UTAnalytics.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.b.dispatchLocalHits();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public synchronized UTTracker getDefaultTracker() {
        Class cls;
        UTTracker uTTracker;
        Class<? extends UTTracker> cls2;
        cls = UTTracker.class;
        synchronized (this) {
            if (yh2.f(sj.c().a())) {
                Log.e(TAG, "getDefaultTracker error,must call setRequestAuthentication method first");
                try {
                    throw new RuntimeException("getDefaultTracker error,must call setRequestAuthentication method first");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.mDefaultTracker == null) {
                AbsMultiProcessAdapter multiProcessAdapter = MultiProcessManager.getMultiProcessAdapter();
                UTTracker uTTracker2 = null;
                if (multiProcessAdapter != null) {
                    cls2 = multiProcessAdapter.isUiSubProcess() ? multiProcessAdapter.getSubProcessUTTrackerClass() : cls;
                } else {
                    cls2 = null;
                }
                try {
                    uTTracker2 = (cls2 != null ? cls2 : UTTracker.class).newInstance();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (uTTracker2 == null) {
                    this.mDefaultTracker = new UTTracker();
                } else {
                    this.mDefaultTracker = uTTracker2;
                }
            }
            uTTracker = this.mDefaultTracker;
        }
        return uTTracker;
    }

    public String getOperationHistory(int i, String str) {
        return UTOperationStack.getInstance().getOperationHistory(i, str);
    }

    public synchronized UTTracker getTracker(String str) {
        if (!yh2.f(str)) {
            if (this.mTrackerMap.containsKey(str)) {
                return this.mTrackerMap.get(str);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.setTrackId(str);
            this.mTrackerMap.put(str, uTTracker);
            return uTTracker;
        }
        throw new IllegalArgumentException("TrackId is null");
    }

    public synchronized UTTracker getTrackerByAppkey(String str) {
        if (!yh2.f(str)) {
            if (this.mAppkeyTrackMap.containsKey(str)) {
                return this.mAppkeyTrackMap.get(str);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.setAppKey(str);
            this.mAppkeyTrackMap.put(str, uTTracker);
            return uTTracker;
        }
        throw new IllegalArgumentException("appkey is null");
    }

    public synchronized UTSceneTracker getUTSceneTracker() {
        if (this.mUTSceneTracker == null) {
            AbsMultiProcessAdapter multiProcessAdapter = MultiProcessManager.getMultiProcessAdapter();
            if (multiProcessAdapter != null && multiProcessAdapter.isUiSubProcess()) {
                this.mUTSceneTracker = multiProcessAdapter.getSubProcessUTSceneTracker();
            }
            if (this.mUTSceneTracker == null) {
                this.mUTSceneTracker = new UTSceneTracker();
            }
        }
        return this.mUTSceneTracker;
    }

    public synchronized UTScrollTracker getUTScrollTracker() {
        return UTScrollTracker.getInstance();
    }

    public boolean isInit() {
        return mInit;
    }

    public void registerPlugin(UTPlugin uTPlugin) {
        UTPluginMgr.getInstance().registerPlugin(uTPlugin);
    }

    public void registerWindvane() {
        WindvaneExtend.registerWindvane(mInit);
    }

    @Deprecated
    public void saveCacheDataToLocal() {
        if (checkInit()) {
            AnalyticsMgr.d.a(new Runnable() { // from class: com.ut.mini.UTAnalytics.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.b.saveCacheDataToLocal();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public String selfCheck(String str) {
        if (checkInit()) {
            IAnalytics iAnalytics = AnalyticsMgr.b;
            if (iAnalytics == null) {
                return "not bind remote service，waitting 10 second";
            }
            try {
                return iAnalytics.selfCheck(str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return "local not init";
    }

    public void sessionTimeout() {
        UTTrackerListenerMgr.getInstance().sessionTimeout();
        et2.e().g();
        AnalyticsMgr.Y(new HashMap());
        AnalyticsMgr.S();
    }

    public synchronized void setAppApplicationInstance(final Application application, IUTApplication iUTApplication) {
        try {
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
        if (mInit4app) {
            return;
        }
        if (application != null && iUTApplication != null && application.getBaseContext() != null) {
            sj.c().l(application.getBaseContext());
            UTAppLaunch.checkFirstLaunch(application);
            UTClientConfigMgr.d().e();
            TLogExtend.registerTLog();
            AnalyticsMgr.M(application);
            initialize(application, iUTApplication, true);
            new Thread("InitSecurity") { // from class: com.ut.mini.UTAnalytics.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Logger.f(UTAnalytics.TAG, "initSecurity");
                        ut2.b().d(application.getBaseContext());
                    } catch (Throwable th2) {
                        Logger.h(null, th2, new Object[0]);
                    }
                }
            }.start();
            registerWindvane();
            mInit = true;
            mInit4app = true;
            Log.i(TAG, "setAppApplicationInstance success!!!");
            UTSystemLaunch.sendBootTime(application);
            return;
        }
        throw new IllegalArgumentException("application and callback must not be null");
    }

    public synchronized void setAppApplicationInstance4sdk(Application application, IUTApplication iUTApplication) {
        try {
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
        if (mInit) {
            return;
        }
        if (application != null && iUTApplication != null && application.getBaseContext() != null) {
            sj.c().l(application.getBaseContext());
            UTAppLaunch.checkFirstLaunch(application);
            UTClientConfigMgr.d().e();
            TLogExtend.registerTLog();
            AnalyticsMgr.M(application);
            initialize(application, iUTApplication, false);
            registerWindvane();
            mInit = true;
            UTSystemLaunch.sendBootTime(application);
            return;
        }
        throw new IllegalArgumentException("application and callback must not be null");
    }

    public void setToAliyunOsPlatform() {
        sj.c().o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transferLog(Map<String, String> map) {
        if (checkInit()) {
            AnalyticsMgr.d.a(createTransferLogTask(map));
        }
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }

    public void turnOffRealTimeDebug() {
        AnalyticsMgr.a0();
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        AnalyticsMgr.c0(map);
    }

    public void unregisterPlugin(UTPlugin uTPlugin) {
        UTPluginMgr.getInstance().unregisterPlugin(uTPlugin);
    }

    public void updateSessionProperties(Map<String, String> map) {
        AnalyticsMgr.d0(map);
    }

    @Deprecated
    public void updateUserAccount(String str, String str2) {
        updateUserAccount(str, str2, null);
    }

    public void userRegister(String str) {
        if (!yh2.f(str)) {
            getDefaultTracker().send(new UTOriginalCustomHitBuilder(BizTime.UT, 1006, str, null, null, null).build());
            return;
        }
        throw new IllegalArgumentException("Usernick can not be null or empty!");
    }

    public void registerPlugin(UTPlugin uTPlugin, boolean z, List<String> list, List<String> list2) {
        UTPluginMgr.getInstance().registerPlugin(uTPlugin, z, list, list2);
    }

    public void updateUserAccount(String str, String str2, String str3) {
        AnalyticsMgr.e0(str, str2, str3);
        if (yh2.f(str)) {
            return;
        }
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(BizTime.UT, 1007, str, str2, null, null);
        uTOriginalCustomHitBuilder.setProperty(RestConstants.LogContentKeys.PRIORITY, "5");
        getInstance().getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
    }

    public void updateUserAccount(String str, String str2, String str3, String str4) {
        AnalyticsMgr.f0(str, str2, str3, str4);
        if (yh2.f(str)) {
            return;
        }
        UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(BizTime.UT, 1007, str, str2, null, null);
        uTOriginalCustomHitBuilder.setProperty(RestConstants.LogContentKeys.PRIORITY, "5");
        getInstance().getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
    }
}
