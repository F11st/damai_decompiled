package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.C0162c;
import anet.channel.entity.ENV;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.Utils;
import com.taobao.aranger.ARanger;
import com.uc.webview.export.extension.UCCore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ACCSClient {
    private static String TAG = "ACCSClient";
    public static Map<String, ACCSClient> mACCSClients = new ConcurrentHashMap(2);
    private static Context mContext;
    private String OTAG = TAG;
    protected IACCSManager mAccsManager;
    private AccsClientConfig mConfig;

    public ACCSClient(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        this.OTAG += accsClientConfig.getTag();
        if (mContext == null) {
            Context context = GlobalClientInfo.mContext;
            mContext = context;
            if (context == null) {
                try {
                    mContext = ARanger.getContext();
                } catch (Exception e) {
                    ALog.e(TAG, "[getContext]", e, new Object[0]);
                }
            }
        }
        this.mAccsManager = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
    }

    public static ACCSClient getAccsClient() throws AccsException {
        return getAccsClient(null);
    }

    public static String getRegId(Context context) {
        return OrangeAdapter.getRegId(context);
    }

    public static synchronized String init(Context context, String str) throws AccsException {
        String init;
        synchronized (ACCSClient.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                    if (!AccsClientConfig.loadedStaticConfig) {
                        configByTag = new AccsClientConfig.Builder().setAppKey(str).build();
                        ALog.i(TAG, UCCore.LEGACY_EVENT_INIT, "create config, appkey as tag");
                    }
                    init = init(context, configByTag);
                }
            }
            throw new AccsException("params error");
        }
        return init;
    }

    public static synchronized void setEnvironment(Context context, @AccsClientConfig.ENV int i) {
        synchronized (ACCSClient.class) {
            if (context != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    ALog.isUseTlog = false;
                    anet.channel.util.ALog.i(false);
                }
            }
            if (i < 0 || i > 2) {
                ALog.e(TAG, "env error", "env", Integer.valueOf(i));
                i = 0;
            }
            int i2 = AccsClientConfig.mEnv;
            AccsClientConfig.mEnv = i;
            if (i2 != i && Utils.isMainProcess(context)) {
                ALog.i(TAG, "setEnvironment", "preEnv", Integer.valueOf(i2), "toEnv", Integer.valueOf(i));
                Utils.clearAllSharePreferences(context);
                Utils.clearAgooBindCache(context);
                Utils.killService(context);
                if (i == 2) {
                    C0162c.D(ENV.TEST);
                } else if (i == 1) {
                    C0162c.D(ENV.PREPARE);
                }
                for (Map.Entry<String, ACCSClient> entry : mACCSClients.entrySet()) {
                    try {
                        getAccsClient(entry.getKey());
                    } catch (AccsException e) {
                        ALog.e(TAG, "setEnvironment update client", e, new Object[0]);
                    }
                }
            }
            Utils.setMode(context, i);
        }
    }

    private void updateConfig(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        IACCSManager accsInstance = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
        this.mAccsManager = accsInstance;
        if (accsInstance != null) {
            accsInstance.updateConfig(accsClientConfig);
        }
    }

    public void bindApp(String str, IAppReceiver iAppReceiver) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "bindApp mAccsManager null", new Object[0]);
        } else {
            iACCSManager.bindApp(mContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void bindService(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "bindService mAccsManager null", new Object[0]);
        } else {
            iACCSManager.bindService(mContext, str);
        }
    }

    public void bindUser(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            iACCSManager.bindUser(mContext, str);
        }
    }

    public boolean cancel(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "cancel mAccsManager null", new Object[0]);
            return false;
        }
        return iACCSManager.cancel(mContext, str);
    }

    public void clearLoginInfo() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "clearLoginInfo mAccsManager null", new Object[0]);
        } else {
            iACCSManager.clearLoginInfo(mContext);
        }
    }

    public void forceDisableService() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "forceDisableService mAccsManager null", new Object[0]);
        } else {
            iACCSManager.forceDisableService(mContext);
        }
    }

    public void forceEnableService() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "forceEnableService mAccsManager null", new Object[0]);
        } else {
            iACCSManager.forceEnableService(mContext);
        }
    }

    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "forceReConnectChannel mAccsManager null", new Object[0]);
            return null;
        }
        return iACCSManager.forceReConnectChannel();
    }

    public Map<String, Boolean> getChannelState() throws Exception {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "getChannelState mAccsManager null", new Object[0]);
            return null;
        }
        return iACCSManager.getChannelState();
    }

    @Deprecated
    public String getUserUnit() {
        return null;
    }

    public boolean isAccsConnected() {
        IACCSManager iACCSManager = this.mAccsManager;
        return iACCSManager != null && iACCSManager.isAccsConnected();
    }

    public boolean isChannelError(int i) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "isChannelError mAccsManager null", new Object[0]);
            return true;
        }
        return iACCSManager.isChannelError(i);
    }

    public boolean isNetworkReachable() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "isNetworkReachable mAccsManager null", new Object[0]);
            return false;
        }
        return iACCSManager.isNetworkReachable(mContext);
    }

    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "registerConnectStateListener mAccsManager null", new Object[0]);
        } else {
            iACCSManager.registerConnectStateListener(accsConnectStateListener);
        }
    }

    public void registerDataListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "registerDataListener mAccsManager null", new Object[0]);
        } else {
            iACCSManager.registerDataListener(mContext, str, accsAbstractDataListener);
        }
    }

    public void registerSerivce(String str, String str2) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "registerSerivce mAccsManager null", new Object[0]);
        } else {
            iACCSManager.registerSerivce(mContext, str, str2);
        }
    }

    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "sendBusinessAck mAccsManager null", new Object[0]);
        } else {
            iACCSManager.sendBusinessAck(str, str2, str3, s, str4, map);
        }
    }

    public String sendData(ACCSManager.AccsRequest accsRequest) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "sendData mAccsManager null", new Object[0]);
            return null;
        }
        return iACCSManager.sendData(mContext, accsRequest);
    }

    public String sendPushResponse(ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "sendPushResponse mAccsManager null", new Object[0]);
            return null;
        }
        return iACCSManager.sendPushResponse(mContext, accsRequest, extraInfo);
    }

    public String sendRequest(ACCSManager.AccsRequest accsRequest) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "sendRequest mAccsManager null", new Object[0]);
            return null;
        }
        return iACCSManager.sendRequest(mContext, accsRequest);
    }

    public void setLoginInfo(ILoginInfo iLoginInfo) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "setLoginInfo mAccsManager null", new Object[0]);
        } else {
            iACCSManager.setLoginInfo(mContext, iLoginInfo);
        }
    }

    public void startInAppConnection(String str, IAppReceiver iAppReceiver) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "startInAppConnection mAccsManager null", new Object[0]);
        } else {
            iACCSManager.startInAppConnection(mContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "unRegisterConnectStateListener mAccsManager null", new Object[0]);
        } else {
            iACCSManager.unRegisterConnectStateListener(accsConnectStateListener);
        }
    }

    public void unRegisterDataListener(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "unRegisterDataListener mAccsManager null", new Object[0]);
        } else {
            iACCSManager.unRegisterDataListener(mContext, str);
        }
    }

    public void unRegisterSerivce(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "unRegisterSerivce mAccsManager null", new Object[0]);
        } else {
            iACCSManager.unRegisterSerivce(mContext, str);
        }
    }

    public void unbindService(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "unbindService mAccsManager null", new Object[0]);
        } else {
            iACCSManager.unbindService(mContext, str);
        }
    }

    public void unbindUser() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "unbindUser mAccsManager null", new Object[0]);
        } else {
            iACCSManager.unbindUser(mContext);
        }
    }

    public static synchronized ACCSClient getAccsClient(String str) throws AccsException {
        synchronized (ACCSClient.class) {
            if (TextUtils.isEmpty(str)) {
                str = "default";
                ALog.w(TAG, "getAccsClient", "configTag is null, use default!");
            }
            ALog.i(TAG, "getAccsClient", Constants.KEY_CONFIG_TAG, str);
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
            if (configByTag != null) {
                ACCSClient aCCSClient = mACCSClients.get(str);
                if (aCCSClient == null) {
                    ALog.d(TAG, "getAccsClient create client", new Object[0]);
                    ACCSClient aCCSClient2 = new ACCSClient(configByTag);
                    mACCSClients.put(str, aCCSClient2);
                    aCCSClient2.updateConfig(configByTag);
                    return aCCSClient2;
                }
                if (configByTag.equals(aCCSClient.mConfig)) {
                    ALog.i(TAG, "getAccsClient exists", new Object[0]);
                } else {
                    ALog.i(TAG, "getAccsClient update config", "old config", aCCSClient.mConfig.getTag(), "new config", configByTag.getTag());
                    aCCSClient.updateConfig(configByTag);
                }
                return aCCSClient;
            }
            ALog.e(TAG, "getAccsClient", "configTag not exist, please init first!!");
            throw new AccsException("configTag not exist");
        }
    }

    public void bindUser(String str, boolean z) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            ALog.e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            iACCSManager.bindUser(mContext, str, z);
        }
    }

    public static synchronized String init(Context context, AccsClientConfig accsClientConfig) throws AccsException {
        String tag;
        synchronized (ACCSClient.class) {
            if (context != null && accsClientConfig != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    ALog.isUseTlog = false;
                    anet.channel.util.ALog.i(false);
                }
                mContext = context.getApplicationContext();
                GlobalClientInfo.mContext = context.getApplicationContext();
                ALog.d(TAG, UCCore.LEGACY_EVENT_INIT, com.youku.arch.v3.core.Constants.CONFIG, accsClientConfig);
                tag = accsClientConfig.getTag();
            } else {
                throw new AccsException("init AccsClient params error");
            }
        }
        return tag;
    }
}
