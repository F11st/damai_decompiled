package com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.middletier.IUnifiedSecurityComponent;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeAdapter;
import com.taobao.orange.OConfigListener;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UserTrackUFWrapper {
    private static boolean DEBUG = false;
    private static int DEFAULT_UPDATE_PERIODS = 30;
    private static final String DYNAMIC_KEY = "ut-uf-factors";
    private static int ERROR_GET_UNKNOWN = 2998;
    private static int ERROR_INIT_UNKNOWN = 2998;
    private static int ERROR_INVALID_INIT_ERROR = 2903;
    private static int ERROR_INVALID_PARA = 2901;
    private static int ERROR_INVALID_STORE_MSG = 2902;
    private static final String KEY_API = "api";
    private static final String KEY_APPKEY = "appkey";
    private static final String KEY_AUTH_CODE = "authCode";
    private static final String KEY_BIZ_ID = "bizId";
    private static final String KEY_DATA = "data";
    private static final String KEY_ENV = "env";
    private static final String KEY_FLAG = "flag";
    private static final String KEY_USE_WUA = "useWua";
    private static final String KEY_X_MINI_WUA = "x-mini-wua";
    private static final String KEY_X_SGEXT = "x-sgext";
    private static final String KEY_X_SIGN = "x-sign";
    private static final String KEY_X_UMT = "x-umt";
    private static final String KEY_X_US = "x-us";
    private static int ORANGE_UT_ANDROID = 25;
    private static final int UF_BIZ_UT = 1;
    private static final int UF_FLAG_UT = 3;
    private static final String UT_API_INPUT = "usertrack.uf.wrapper";
    private static volatile IRouterComponent gGlobalRounterComponent;
    private static boolean initedManager;
    private static String mAppkey;
    private static Context mContext;
    private static String mCurProcessName;
    private static IDynamicDataStoreComponent mDynamicDataStoreComp;
    private static Handler mHandler;
    private static Timer mTimer;
    private static TimerTask mTimerTask;
    private static IUnifiedSecurityComponent mUnifiedSecurityComp;
    private static int mUpdatePeriod;

    private static void Logd(String str) {
        if (DEBUG) {
            Log.d("SS", str);
        }
    }

    public static String getCurProcessName(Context context) {
        String str = mCurProcessName;
        if (str != null) {
            return str;
        }
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                String str2 = runningAppProcessInfo.processName;
                mCurProcessName = str2;
                return str2;
            }
        }
        return "";
    }

    private static IRouterComponent getRouterComponent() {
        if (gGlobalRounterComponent == null) {
            synchronized (OConfigListener.class) {
                if (gGlobalRounterComponent == null) {
                    try {
                        gGlobalRounterComponent = SecurityGuardManager.getInstance(OrangeAdapter.gContext).getSGPluginManager().getRouter();
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return gGlobalRounterComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getUFFactorsAndUpdateStore() {
        try {
            HashMap<String, String> uFInMainProcess = getUFInMainProcess();
            if (uFInMainProcess == null) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(uFInMainProcess.get("x-sign"));
            stringBuffer.append("&");
            stringBuffer.append(uFInMainProcess.get("x-mini-wua"));
            stringBuffer.append("&");
            stringBuffer.append(uFInMainProcess.get("x-sgext"));
            stringBuffer.append("&");
            stringBuffer.append(uFInMainProcess.get("x-umt"));
            stringBuffer.append("&");
            stringBuffer.append(uFInMainProcess.get(KEY_X_US));
            String stringBuffer2 = stringBuffer.toString();
            if (!isEmpty(stringBuffer2)) {
                mDynamicDataStoreComp.putStringDDpEx(DYNAMIC_KEY, stringBuffer2, 0);
            }
            updatePeriod();
        } catch (SecException unused) {
        }
    }

    private static HashMap<String, String> getUFInChannelProcess() throws SecException {
        String stringDDpEx = mDynamicDataStoreComp.getStringDDpEx(DYNAMIC_KEY, 0);
        if (!isEmpty(stringDDpEx)) {
            String[] split = stringDDpEx.split("&");
            if (split != null && split.length == 5) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("x-sign", split[0]);
                hashMap.put("x-mini-wua", split[1]);
                hashMap.put("x-sgext", split[2]);
                hashMap.put("x-umt", split[3]);
                hashMap.put(KEY_X_US, split[4]);
                return hashMap;
            }
            throw new SecException(ERROR_INVALID_STORE_MSG);
        }
        throw new SecException(ERROR_INVALID_PARA);
    }

    private static HashMap<String, String> getUFInMainProcess() throws SecException {
        if (mUnifiedSecurityComp != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("data", mAppkey);
            hashMap.put("env", 0);
            hashMap.put("appkey", mAppkey);
            hashMap.put("api", UT_API_INPUT);
            hashMap.put("useWua", Boolean.FALSE);
            hashMap.put("bizId", 1);
            hashMap.put("flag", 3);
            return mUnifiedSecurityComp.getSecurityFactors(hashMap);
        }
        throw new SecException(ERROR_INVALID_INIT_ERROR);
    }

    public static HashMap<String, String> getUFWrapper() throws SecException {
        try {
            if (initedManager) {
                if (isMainProcess(mContext, false)) {
                    return getUFInMainProcess();
                }
                return getUFInChannelProcess();
            }
            return null;
        } catch (SecException e) {
            throw e;
        } catch (Exception unused) {
            throw new SecException(ERROR_GET_UNKNOWN);
        }
    }

    public static void init(Context context, String str) throws SecException {
        try {
            initMethod(context, str);
            if (isMainProcess(mContext, false)) {
                runPeriodTask(DEFAULT_UPDATE_PERIODS);
            }
        } catch (SecException e) {
            throw e;
        } catch (Exception unused) {
            throw new SecException(ERROR_INIT_UNKNOWN);
        }
    }

    private static void initMethod(Context context, String str) throws SecException {
        if (initedManager) {
            return;
        }
        mContext = context;
        mAppkey = str;
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
        if (isMainProcess(mContext, false)) {
            mUnifiedSecurityComp = (IUnifiedSecurityComponent) securityGuardManager.getInterface(IUnifiedSecurityComponent.class);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("authCode", "");
            mUnifiedSecurityComp.init(hashMap);
            mDynamicDataStoreComp = (IDynamicDataStoreComponent) securityGuardManager.getInterface(IDynamicDataStoreComponent.class);
            initedManager = true;
            return;
        }
        mDynamicDataStoreComp = (IDynamicDataStoreComponent) securityGuardManager.getInterface(IDynamicDataStoreComponent.class);
        initedManager = true;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isMainProcess(Context context, boolean z) {
        if (context == null) {
            return z;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
            String curProcessName = getCurProcessName(context);
            return (isEmpty(str) || isEmpty(curProcessName)) ? z : curProcessName.equalsIgnoreCase(str);
        } catch (Throwable unused) {
            return z;
        }
    }

    private static void runPeriodTask(final int i) {
        if (mHandler == null) {
            HandlerThread handlerThread = new HandlerThread("UFW");
            handlerThread.start();
            mHandler = new Handler(handlerThread.getLooper());
        }
        if (mHandler != null) {
            mHandler.postDelayed(new Runnable() { // from class: com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack.UserTrackUFWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    UserTrackUFWrapper.runPeriodTaskImpl(i);
                }
            }, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runPeriodTaskImpl(int i) {
        if (mTimer == null) {
            if (i > 0) {
                mTimer = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack.UserTrackUFWrapper.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        UserTrackUFWrapper.getUFFactorsAndUpdateStore();
                    }
                };
                mTimerTask = timerTask;
                mTimer.schedule(timerTask, 0L, i * 1000);
            }
        } else if (i != mUpdatePeriod) {
            if (i > 0) {
                mTimerTask.cancel();
                TimerTask timerTask2 = new TimerTask() { // from class: com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack.UserTrackUFWrapper.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        UserTrackUFWrapper.getUFFactorsAndUpdateStore();
                    }
                };
                mTimerTask = timerTask2;
                mTimer.schedule(timerTask2, 0L, i * 1000);
            } else {
                mTimerTask.cancel();
            }
        }
        mUpdatePeriod = i;
    }

    private static void updatePeriod() {
        IRouterComponent routerComponent = getRouterComponent();
        if (routerComponent != null) {
            try {
                runPeriodTask(((Integer) routerComponent.doCommand(13001, Integer.valueOf(ORANGE_UT_ANDROID))).intValue());
            } catch (Exception unused) {
            }
        }
    }
}
