package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IGlobalClientInfoService;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class GlobalClientInfo implements IGlobalClientInfoService {
    public static final String AGOO_SERVICE_ID = "agooSend";
    private static final String TAG = "com.taobao.accs.client.GlobalClientInfo";
    public static IAgooAppReceiver mAgooAppReceiver;
    public static Context mContext;
    public static String mCookieSec;
    private static volatile GlobalClientInfo mInstance;
    public static boolean mSupprotElection;
    private Map<String, AccsDataListener> LISTENERS = new ConcurrentHashMap();
    private ActivityManager mActivityManager;
    private ConcurrentHashMap<String, IAppReceiver> mAppReceiver;
    private ConnectivityManager mConnectivityManager;
    private ConcurrentHashMap<String, ILoginInfo> mILoginInfoImpl;
    private PackageInfo mPackageInfo;
    private static Map<String, String> SERVICES = new ConcurrentHashMap();
    public static Map<String, Map<String, String>> TAG_SERVICES = new ConcurrentHashMap();

    static {
        SERVICES.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        SERVICES.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        SERVICES.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        if (mContext == null) {
            mContext = getContext();
        }
        if (mContext == null && context != null) {
            mContext = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.client.GlobalClientInfo.1
            @Override // java.lang.Runnable
            public void run() {
                GlobalClientInfo.mCookieSec = UtilityImpl.restoreCookie(GlobalClientInfo.mContext);
            }
        });
    }

    public static Context getContext() {
        if (mContext == null) {
            try {
                mContext = ARanger.getContext();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return mContext;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (mInstance == null) {
            synchronized (GlobalClientInfo.class) {
                if (mInstance == null) {
                    mInstance = new GlobalClientInfo(context);
                }
            }
        }
        return mInstance;
    }

    private void registerAllService(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (!OrangeAdapter.isChannelModeEnable() || UtilityImpl.isMainProcess(mContext)) {
            if (TAG_SERVICES.get(str) == null) {
                TAG_SERVICES.put(str, new ConcurrentHashMap());
            }
            TAG_SERVICES.get(str).putAll(map);
            if (OrangeAdapter.isChannelModeEnable() && ARanger.isConnect(new ComponentName(mContext, AccsIPCProvider.class))) {
                try {
                    ((IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext))).registerAllRemoteService(str, map);
                } catch (IPCException e) {
                    ALog.e(TAG, "registerAllService exception", e, new Object[0]);
                }
            }
        }
    }

    public void clearLoginInfoImpl() {
        this.mILoginInfoImpl = null;
    }

    public ActivityManager getActivityManager() {
        if (this.mActivityManager == null) {
            this.mActivityManager = (ActivityManager) mContext.getSystemService("activity");
        }
        return this.mActivityManager;
    }

    public Map<String, String> getAllService(String str) {
        if (TAG_SERVICES.get(str) == null || TAG_SERVICES.get(str).isEmpty()) {
            return null;
        }
        return TAG_SERVICES.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.mAppReceiver;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.mConnectivityManager == null) {
            this.mConnectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        }
        return this.mConnectivityManager;
    }

    public AccsDataListener getListener(String str) {
        return this.LISTENERS.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.mILoginInfoImpl;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.mPackageInfo == null) {
                this.mPackageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.mPackageInfo;
    }

    public String getService(String str) {
        return SERVICES.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.mILoginInfoImpl;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.mILoginInfoImpl;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void recoverListener(String str) {
        try {
            IGlobalClientInfoService iGlobalClientInfoService = (IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext));
            if (!this.LISTENERS.isEmpty()) {
                for (Map.Entry<String, AccsDataListener> entry : this.LISTENERS.entrySet()) {
                    iGlobalClientInfoService.registerRemoteListener(entry.getKey(), entry.getValue());
                }
            }
            if (getAllService(str) != null) {
                iGlobalClientInfoService.registerAllRemoteService(str, getAllService(str));
            }
            if (SERVICES.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry2 : SERVICES.entrySet()) {
                iGlobalClientInfoService.registerRemoteService(entry2.getKey(), entry2.getValue());
            }
        } catch (IPCException e) {
            ALog.e(TAG, "recoverListener error", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (TAG_SERVICES.get(str) == null) {
            TAG_SERVICES.put(str, new ConcurrentHashMap());
        }
        TAG_SERVICES.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.LISTENERS.put(str, accsDataListener);
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    public void registerRemoteService(String str, String str2) {
        SERVICES.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SERVICES.put(str, str2);
        if (OrangeAdapter.isChannelModeEnable() && UtilityImpl.isMainProcess(mContext) && ARanger.isConnect(new ComponentName(mContext, AccsIPCProvider.class))) {
            try {
                ((IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext))).registerRemoteService(str, str2);
            } catch (IPCException e) {
                ALog.e(TAG, "registerService exception", e, new Object[0]);
            }
        }
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if ((!OrangeAdapter.isChannelModeEnable() || UtilityImpl.isMainProcess(mContext)) && iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                mAgooAppReceiver = (IAgooAppReceiver) iAppReceiver;
            } else {
                if (this.mAppReceiver == null) {
                    this.mAppReceiver = new ConcurrentHashMap<>(2);
                }
                this.mAppReceiver.put(str, iAppReceiver);
                try {
                    registerAllService(str, iAppReceiver.getAllServices());
                } catch (IPCException e) {
                    ALog.e(TAG, "setAppReceiver getAllServices", e, new Object[0]);
                }
            }
            if (OrangeAdapter.isChannelModeEnable() && ARanger.isConnect(new ComponentName(mContext, AccsIPCProvider.class))) {
                try {
                    IGlobalClientInfoService iGlobalClientInfoService = (IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext));
                    if (iAppReceiver instanceof IAgooAppReceiver) {
                        iGlobalClientInfoService.setRemoteAgooAppReceiver((IAgooAppReceiver) iAppReceiver);
                    } else {
                        iGlobalClientInfoService.setRemoteAppReceiver(str, iAppReceiver);
                    }
                } catch (IPCException e2) {
                    ALog.e(TAG, "setAppReceiver exception", e2, new Object[0]);
                }
            }
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.mILoginInfoImpl == null) {
            this.mILoginInfoImpl = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.mILoginInfoImpl.put(str, iLoginInfo);
        }
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        mAgooAppReceiver = iAgooAppReceiver;
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.mAppReceiver == null) {
            this.mAppReceiver = new ConcurrentHashMap<>(2);
        }
        this.mAppReceiver.put(str, iAppReceiver);
        try {
            registerAllService(str, iAppReceiver.getAllServices());
        } catch (IPCException e) {
            ALog.e(TAG, "setRemoteAppReceiver registerAllService", e, new Object[0]);
        }
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SERVICES.remove(str);
        if (OrangeAdapter.isChannelModeEnable() && UtilityImpl.isMainProcess(mContext) && ARanger.isConnect(new ComponentName(mContext, AccsIPCProvider.class))) {
            try {
                ((IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext))).unregisterRemoteService(str);
            } catch (IPCException e) {
                ALog.e(TAG, "unRegisterService exception", e, new Object[0]);
            }
        }
    }

    public void unregisterListener(String str) {
        if (!OrangeAdapter.isChannelModeEnable() || UtilityImpl.isMainProcess(mContext)) {
            this.LISTENERS.remove(str);
            if (OrangeAdapter.isChannelModeEnable() && ARanger.isConnect(new ComponentName(mContext, AccsIPCProvider.class))) {
                try {
                    ((IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext))).unregisterRemoteListener(str);
                } catch (IPCException e) {
                    ALog.e(TAG, "unregisterListener exception", e, new Object[0]);
                }
            }
        }
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    public void unregisterRemoteListener(String str) {
        this.LISTENERS.remove(str);
    }

    @Override // com.taobao.accs.IGlobalClientInfoService
    public void unregisterRemoteService(String str) {
        SERVICES.remove(str);
    }

    public String getService(String str, String str2) {
        if (TAG_SERVICES.get(str) != null) {
            return TAG_SERVICES.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if ((OrangeAdapter.isChannelModeEnable() && !UtilityImpl.isMainProcess(mContext)) || TextUtils.isEmpty(str) || accsDataListener == null) {
            return;
        }
        this.LISTENERS.put(str, accsDataListener);
        if (OrangeAdapter.isChannelModeEnable() && ARanger.isConnect(new ComponentName(mContext, AccsIPCProvider.class))) {
            try {
                ((IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(mContext, AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, mContext))).registerRemoteListener(str, accsDataListener);
            } catch (IPCException e) {
                ALog.e(TAG, "registerListener exception", e, new Object[0]);
            }
        }
    }
}
