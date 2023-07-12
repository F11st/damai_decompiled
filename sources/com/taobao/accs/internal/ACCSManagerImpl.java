package com.taobao.accs.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.c;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IGlobalClientInfoService;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.connection.ConnectionWrapper;
import com.taobao.accs.connection.IConnection;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.MsgDistribute;
import com.taobao.accs.net.AccsSessionCenter;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.ProcessStateListener;
import com.taobao.mass.MassClient;
import com.taobao.mass.ServiceKey;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ACCSManagerImpl implements IACCSManager {
    private static String TAG = "ACCSMgrImpl_";
    private IConnection connectionService;
    private String mConfigTag;
    private int baseDataId = 0;
    private Random random = new Random();
    private ProcessStateListener processStateListener = new ProcessStateListener() { // from class: com.taobao.accs.internal.ACCSManagerImpl.1
        @Override // com.taobao.aranger.intf.ProcessStateListener
        public void onProcessStart(String str) {
        }

        @Override // com.taobao.aranger.intf.ProcessStateListener
        public void onProcessStop(String str) {
            String str2 = ACCSManagerImpl.TAG;
            ALog.e(str2, "onProcessStop: " + str, new Object[0]);
            try {
                IGlobalClientInfoService iGlobalClientInfoService = (IGlobalClientInfoService) ARanger.createSingleton(new ComponentName(ARanger.getContext(), AccsIPCProvider.class), IGlobalClientInfoService.class, new Pair(Context.class, ARanger.getContext()));
                IAgooAppReceiver iAgooAppReceiver = GlobalClientInfo.mAgooAppReceiver;
                if (iAgooAppReceiver != null) {
                    iGlobalClientInfoService.setRemoteAgooAppReceiver(iAgooAppReceiver);
                }
                if (GlobalClientInfo.getInstance(ARanger.getContext()).getAppReceiver() != null) {
                    for (Map.Entry<String, IAppReceiver> entry : GlobalClientInfo.getInstance(ARanger.getContext()).getAppReceiver().entrySet()) {
                        iGlobalClientInfoService.setRemoteAppReceiver(entry.getKey(), entry.getValue());
                    }
                }
                GlobalClientInfo.getInstance(ARanger.getContext()).recoverListener(ACCSManagerImpl.this.mConfigTag);
            } catch (Exception e) {
                ALog.e(ACCSManagerImpl.TAG, "on receive action error, Error:", e, new Object[0]);
            }
            try {
                ACCSManagerImpl.this.connectionService = (IConnection) ARanger.create(new ComponentName(ARanger.getContext(), AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, AccsClientConfig.getConfigByTag(ACCSManagerImpl.this.mConfigTag)), new Pair(Integer.class, Integer.valueOf(ForeBackManager.getManager().getState())));
            } catch (IPCException unused) {
                OrangeAdapter.resetChannelModeEnable();
                ACCSManagerImpl aCCSManagerImpl = ACCSManagerImpl.this;
                aCCSManagerImpl.connectionService = new ConnectionWrapper(aCCSManagerImpl.mConfigTag);
            }
            try {
                ACCSManagerImpl.this.connectionService.start();
                ACCSManagerImpl.this.connectionService.setForeBackState(ForeBackManager.getManager().getState());
            } catch (IPCException e2) {
                ALog.e(ACCSManagerImpl.TAG, "start connect error:", e2, new Object[0]);
            }
        }
    };
    private ForeBackManager.ForeBackStateListener forebackStateReceiver = new ForeBackManager.ForeBackStateListener() { // from class: com.taobao.accs.internal.ACCSManagerImpl.2
        private String host;

        @Override // com.taobao.accs.utl.ForeBackManager.ForeBackStateListener
        public void onBackState(Context context) {
            ALog.e(ACCSManagerImpl.TAG, "onBackState", new Object[0]);
            try {
                if (OrangeAdapter.isChannelModeEnable()) {
                    if (!OrangeAdapter.normalChangesEnabled()) {
                        this.host = ACCSManagerImpl.this.getConnection().getHost(null);
                    } else if (TextUtils.isEmpty(this.host) || ACCSManagerImpl.this.inappHostMayUpdate) {
                        this.host = ACCSManagerImpl.this.getConnection().getHost(null);
                        ACCSManagerImpl.this.inappHostMayUpdate = false;
                    }
                    ACCSManagerImpl.this.getConnection().sendMessage(Message.buildBackground(this.host));
                    ACCSManagerImpl.this.getConnection().setForeBackState(0);
                    if (!MassClient.getInstance().getTopicsByService(ServiceKey.POWER_MSG).isEmpty()) {
                        ALog.i(ACCSManagerImpl.TAG, "send mass background state frame", new Object[0]);
                        ACCSManagerImpl.this.getConnection().sendMessage(Message.buildMassMessage(ACCSManagerImpl.this.getConnection().getAppkey(), "back", ServiceKey.POWER_MSG, ACCSManagerImpl.this.getConnection().getHost(null), ACCSManagerImpl.this.mConfigTag, context));
                    }
                }
                ConnectionServiceManager.getInstance().onBackground();
            } catch (Exception e) {
                ALog.e(ACCSManagerImpl.TAG, "onBackState error, Error:", e, new Object[0]);
            }
        }

        @Override // com.taobao.accs.utl.ForeBackManager.ForeBackStateListener
        public void onForeState(Context context) {
            boolean z;
            try {
                ALog.e(ACCSManagerImpl.TAG, "onForeState", new Object[0]);
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(ACCSManagerImpl.this.mConfigTag);
                if (OrangeAdapter.isChannelModeEnable()) {
                    ACCSManagerImpl aCCSManagerImpl = ACCSManagerImpl.this;
                    aCCSManagerImpl.schedulePing(aCCSManagerImpl.getConnection());
                    if (ACCSManagerImpl.this.getConnection().getSendBackState()) {
                        ALog.e(ACCSManagerImpl.TAG, "send foreground state frame", new Object[0]);
                        ACCSManagerImpl.this.getConnection().sendMessage(Message.buildForeground(ACCSManagerImpl.this.getConnection().getHost(null)));
                        if (!MassClient.getInstance().getTopicsByService(ServiceKey.POWER_MSG).isEmpty()) {
                            ALog.e(ACCSManagerImpl.TAG, "send mass foreground state frame", new Object[0]);
                            ACCSManagerImpl.this.getConnection().sendMessage(Message.buildMassMessage(ACCSManagerImpl.this.getConnection().getAppkey(), "front", ServiceKey.POWER_MSG, ACCSManagerImpl.this.getConnection().getHost(null), ACCSManagerImpl.this.mConfigTag, context));
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    ACCSManagerImpl.this.getConnection().setForeBackState(1);
                } else {
                    z = false;
                }
                if (configByTag.isForePingEnable() && !z) {
                    ACCSManagerImpl aCCSManagerImpl2 = ACCSManagerImpl.this;
                    aCCSManagerImpl2.schedulePing(aCCSManagerImpl2.getConnection());
                }
                ConnectionServiceManager.getInstance().onForeground();
            } catch (Exception e) {
                ALog.e(ACCSManagerImpl.TAG, "onForeState error, Error:", e, new Object[0]);
            }
        }
    };
    private volatile boolean inappHostMayUpdate = false;

    public ACCSManagerImpl(Context context, String str) {
        int i = 0;
        GlobalClientInfo.mContext = context.getApplicationContext();
        this.mConfigTag = str;
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            try {
                configByTag = new AccsClientConfig.Builder().setAppKey(ACCSManager.getDefaultAppkey(context)).setTag(str).build();
            } catch (AccsException e) {
                ALog.e(TAG, "ACCSManagerImpl build config", e, new Object[0]);
            }
        }
        if (ConnectionServiceManager.getInstance().isEnabled(GlobalClientInfo.mContext)) {
            ConnectionServiceManager.getInstance().init(str, configByTag);
        } else if (OrangeAdapter.isChannelModeEnable()) {
            try {
                ComponentName componentName = new ComponentName(context, AccsIPCProvider.class);
                Pair[] pairArr = new Pair[2];
                pairArr[0] = new Pair(AccsClientConfig.class, configByTag);
                if (ForeBackManager.getManager().getState() == 1 && UtilityImpl.isForeground(context)) {
                    i = 1;
                }
                pairArr[1] = new Pair(Integer.class, Integer.valueOf(i));
                this.connectionService = (IConnection) ARanger.create(componentName, IConnection.class, pairArr);
                if (Utils.isMainProcess(context)) {
                    ARanger.registerProcessStateListener(this.processStateListener);
                }
            } catch (IPCException unused) {
                OrangeAdapter.resetChannelModeEnable();
                this.connectionService = new ConnectionWrapper(str);
            }
        } else {
            this.connectionService = new ConnectionWrapper(str);
        }
        if (Utils.isMainProcess(context)) {
            ForeBackManager.getManager().registerForeBackStateListener(this.forebackStateReceiver);
        }
        TAG += this.mConfigTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IConnection getConnection() {
        if (ConnectionServiceManager.getInstance().isEnabled(GlobalClientInfo.mContext)) {
            return ConnectionServiceManager.getInstance().getConnectionWrapper();
        }
        return this.connectionService;
    }

    private Intent getIntent(Context context, int i) {
        if (i != 1 && UtilityImpl.getFocusDisableStatus(context)) {
            ALog.e(TAG, "getIntent null command:" + i + " accs enabled:" + UtilityImpl.getFocusDisableStatus(context), new Object[0]);
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_COMMAND);
        intent.setClassName(context.getPackageName(), AdapterUtilityImpl.channelService);
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("command", i);
        try {
            intent.putExtra("appKey", getConnection().getAppkey());
        } catch (IPCException e) {
            ALog.e(TAG, "getIntent getAppkey exception", e, new Object[0]);
        }
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedulePing(final IConnection iConnection) {
        ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: com.taobao.accs.internal.ACCSManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IConnection iConnection2 = iConnection;
                    if (iConnection2 != null) {
                        iConnection2.ping(true, false);
                    }
                } catch (IPCException e) {
                    ALog.e(ACCSManagerImpl.TAG, "schedulePing exception", e, new Object[0]);
                }
            }
        }, this.random.nextInt(6), TimeUnit.SECONDS);
    }

    private void sendAppNotBind(Context context, int i, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i);
        intent.putExtra("serviceId", str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        try {
            intent.putExtra("appKey", getConnection().getAppkey());
        } catch (IPCException e) {
            ALog.e(TAG, "sendAppNotBind getAppkey exception", e, new Object[0]);
        }
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
        intent.putExtra("errorCode", i == 2 ? 200 : 300);
        MsgDistribute.distribMessage(context, intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sendControlMessage(android.content.Context r9, com.taobao.accs.data.Message r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.sendControlMessage(android.content.Context, com.taobao.accs.data.Message, int, boolean):void");
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, str, "accs", str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindService(Context context, String str) {
        String appkey;
        if (UtilityImpl.getFocusDisableStatus(context) || UtilityImpl.getFocusDisableStatus(context)) {
            return;
        }
        Intent intent = getIntent(context, 5);
        if (intent == null) {
            sendAppNotBind(context, 5, str, null);
            return;
        }
        try {
            appkey = getConnection().getAppkey();
        } catch (IPCException e) {
            ALog.e(TAG, "bindService getAppkey exception", e, new Object[0]);
        }
        if (TextUtils.isEmpty(appkey)) {
            return;
        }
        intent.putExtra("appKey", appkey);
        intent.putExtra("serviceId", str);
        if (UtilityImpl.isMainProcess(context)) {
            try {
                Message buildBindService = Message.buildBindService(getConnection().getHost(null), this.mConfigTag, intent);
                if (buildBindService != null && buildBindService.getNetPermanceMonitor() != null) {
                    buildBindService.getNetPermanceMonitor().setDataId(buildBindService.dataId);
                    buildBindService.getNetPermanceMonitor().setHost(buildBindService.host.toString());
                }
                sendControlMessage(context, buildBindService, 5, false);
            } catch (IPCException e2) {
                ALog.e(TAG, "bindService getHost exception", e2, new Object[0]);
            }
        }
        try {
            getConnection().startChannelService();
        } catch (IPCException e3) {
            ALog.e(TAG, "bindService startChannelService exception", e3, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean cancel(Context context, String str) {
        try {
            return getConnection().cancel(str);
        } catch (IPCException e) {
            ALog.e(TAG, "cancel exception", e, new Object[0]);
            return true;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void clearLoginInfo(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceDisableService(Context context) {
        UtilityImpl.focusDisableService(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceEnableService(Context context) {
        UtilityImpl.focusEnableService(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        c.m(getConnection().getAppkey()).g();
        return getChannelState();
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> getChannelState() throws Exception {
        String host = getConnection().getHost(null);
        HashMap hashMap = new HashMap();
        hashMap.put(host, Boolean.FALSE);
        if (AccsSessionCenter.getThrowsException(c.m(getConnection().getAppkey()), host, DateUtils.MILLIS_PER_MINUTE) != null) {
            hashMap.put(host, Boolean.TRUE);
        }
        String str = TAG;
        ALog.d(str, "getChannelState " + hashMap.toString(), new Object[0]);
        return hashMap;
    }

    @Override // com.taobao.accs.IACCSManager
    public String getUserUnit() {
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isAccsConnected() {
        try {
            if (getConnection() != null) {
                if (getConnection().isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            if (e instanceof IPCException) {
                ALog.e(TAG, "isAccsConnected isConnected exception", e, new Object[0]);
                if (((IPCException) e).getErrorCode() == 22) {
                    try {
                        IConnection iConnection = (IConnection) ARanger.create(new ComponentName(ARanger.getContext(), AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, AccsClientConfig.getConfigByTag(this.mConfigTag)), new Pair(Integer.class, Integer.valueOf(ForeBackManager.getManager().getState())));
                        this.connectionService = iConnection;
                        iConnection.start();
                    } catch (IPCException unused) {
                        ALog.e(TAG, "create connectionService exception", e, new Object[0]);
                    }
                }
            }
            return true;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isChannelError(int i) {
        return ErrorCode.isChannelError(i);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isNetworkReachable(Context context) {
        return UtilityImpl.isNetworkConnected(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            try {
                getConnection().registerConnectStateListener(accsConnectStateListener);
            } catch (IPCException e) {
                ALog.e(TAG, "registerConnectStateListener exception", e, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerSerivce(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.IACCSManager
    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        try {
            try {
                getConnection().send(Message.buildPushAck(getConnection().getHost(null), this.mConfigTag, str, str2, str3, true, s, str4, map), true);
            } catch (IPCException e) {
                e = e;
                ALog.e(TAG, "sendBusinessAck exception", e, new Object[0]);
            }
        } catch (IPCException e2) {
            e = e2;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendData(context, str, str2, bArr, str3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9 A[Catch: all -> 0x021e, TRY_ENTER, TryCatch #2 {all -> 0x021e, blocks: (B:18:0x0059, B:21:0x0065, B:26:0x0082, B:29:0x00b9, B:31:0x00e0, B:33:0x00e6, B:34:0x00f2, B:36:0x00f8, B:38:0x0102, B:25:0x006c), top: B:74:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0179 A[Catch: all -> 0x024b, TryCatch #1 {all -> 0x024b, blocks: (B:42:0x0131, B:44:0x0137, B:46:0x013d, B:47:0x0144, B:48:0x014d, B:49:0x0179, B:51:0x0184, B:53:0x01af, B:55:0x01fb, B:56:0x0202, B:58:0x020a, B:59:0x0211, B:61:0x0215, B:62:0x021a, B:67:0x0226), top: B:73:0x0019 }] */
    @Override // com.taobao.accs.IACCSManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String sendPushResponse(android.content.Context r25, com.taobao.accs.ACCSManager.AccsRequest r26, com.taobao.accs.base.TaoBaseService.ExtraInfo r27) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.sendPushResponse(android.content.Context, com.taobao.accs.ACCSManager$AccsRequest, com.taobao.accs.base.TaoBaseService$ExtraInfo):java.lang.String");
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendRequest(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setLoginInfo(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.mConfigTag, iLoginInfo);
    }

    @Override // com.taobao.accs.IACCSManager
    @Deprecated
    public void setMode(Context context, int i) {
        ACCSClient.setEnvironment(context, i);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setProxy(Context context, String str, int i) {
        SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(Constants.KEY_PROXY_HOST, str);
        }
        edit.putInt(Constants.KEY_PROXY_PORT, i);
        edit.apply();
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, str, null, str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        if (accsConnectStateListener != null) {
            try {
                getConnection().unRegisterConnectStateListener(accsConnectStateListener);
            } catch (IPCException e) {
                ALog.e(TAG, "registerConnectStateListener exception", e, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterSerivce(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindApp(Context context) {
        String str = TAG;
        ALog.e(str, "unbindApp" + UtilityImpl.getStackMsg(new Exception()), new Object[0]);
        if (UtilityImpl.getFocusDisableStatus(context)) {
            return;
        }
        Intent intent = getIntent(context, 2);
        if (intent == null) {
            sendAppNotBind(context, 2, null, null);
        } else if (UtilityImpl.isMainProcess(context)) {
            try {
                sendControlMessage(context, Message.buildUnbindApp(getConnection().getHost(null), intent), 2, false);
            } catch (IPCException e) {
                ALog.e(TAG, "unbindApp getHost exception", e, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindService(Context context, String str) {
        String appkey;
        if (UtilityImpl.getFocusDisableStatus(context)) {
            return;
        }
        Intent intent = getIntent(context, 6);
        if (intent == null) {
            sendAppNotBind(context, 6, str, null);
            return;
        }
        try {
            appkey = getConnection().getAppkey();
        } catch (IPCException e) {
            ALog.e(TAG, "unbindService getAppkey exception", e, new Object[0]);
        }
        if (TextUtils.isEmpty(appkey)) {
            return;
        }
        intent.putExtra("appKey", appkey);
        intent.putExtra("serviceId", str);
        if (UtilityImpl.isMainProcess(context)) {
            try {
                sendControlMessage(context, Message.buildUnbindService(getConnection().getHost(null), this.mConfigTag, intent), 6, false);
            } catch (IPCException e2) {
                ALog.e(TAG, "unbindService getHost exception", e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindUser(Context context) {
        String appkey;
        if (UtilityImpl.getFocusDisableStatus(context) || UtilityImpl.getFocusDisableStatus(context)) {
            return;
        }
        Intent intent = getIntent(context, 4);
        if (intent == null) {
            sendAppNotBind(context, 4, null, null);
            return;
        }
        try {
            appkey = getConnection().getAppkey();
        } catch (IPCException e) {
            ALog.e(TAG, "unbindUser getAppkey exception", e, new Object[0]);
        }
        if (TextUtils.isEmpty(appkey)) {
            return;
        }
        intent.putExtra("appKey", appkey);
        if (UtilityImpl.isMainProcess(context)) {
            try {
                sendControlMessage(context, Message.buildUnbindUser(getConnection().getHost(null), this.mConfigTag, intent), 4, false);
            } catch (IPCException e2) {
                ALog.e(TAG, "unbindUser getHost exception", e2, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void updateConfig(AccsClientConfig accsClientConfig) {
        try {
            this.inappHostMayUpdate = true;
            getConnection().updateConfig(accsClientConfig);
        } catch (IPCException e) {
            ALog.e(TAG, "updateConfig exception", e, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009f A[Catch: all -> 0x014b, TryCatch #2 {all -> 0x014b, blocks: (B:25:0x007d, B:27:0x008d, B:29:0x0093, B:35:0x009f, B:36:0x00af, B:38:0x00c4, B:39:0x00cc, B:41:0x00d5, B:43:0x00dc, B:46:0x00fb, B:48:0x0101, B:49:0x0117, B:51:0x0124, B:44:0x00eb, B:50:0x011b, B:52:0x012b, B:54:0x012f), top: B:63:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4 A[Catch: all -> 0x014b, TryCatch #2 {all -> 0x014b, blocks: (B:25:0x007d, B:27:0x008d, B:29:0x0093, B:35:0x009f, B:36:0x00af, B:38:0x00c4, B:39:0x00cc, B:41:0x00d5, B:43:0x00dc, B:46:0x00fb, B:48:0x0101, B:49:0x0117, B:51:0x0124, B:44:0x00eb, B:50:0x011b, B:52:0x012b, B:54:0x012f), top: B:63:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5 A[Catch: all -> 0x014b, TryCatch #2 {all -> 0x014b, blocks: (B:25:0x007d, B:27:0x008d, B:29:0x0093, B:35:0x009f, B:36:0x00af, B:38:0x00c4, B:39:0x00cc, B:41:0x00d5, B:43:0x00dc, B:46:0x00fb, B:48:0x0101, B:49:0x0117, B:51:0x0124, B:44:0x00eb, B:50:0x011b, B:52:0x012b, B:54:0x012f), top: B:63:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011b A[Catch: all -> 0x014b, TryCatch #2 {all -> 0x014b, blocks: (B:25:0x007d, B:27:0x008d, B:29:0x0093, B:35:0x009f, B:36:0x00af, B:38:0x00c4, B:39:0x00cc, B:41:0x00d5, B:43:0x00dc, B:46:0x00fb, B:48:0x0101, B:49:0x0117, B:51:0x0124, B:44:0x00eb, B:50:0x011b, B:52:0x012b, B:54:0x012f), top: B:63:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #2 {all -> 0x014b, blocks: (B:25:0x007d, B:27:0x008d, B:29:0x0093, B:35:0x009f, B:36:0x00af, B:38:0x00c4, B:39:0x00cc, B:41:0x00d5, B:43:0x00dc, B:46:0x00fb, B:48:0x0101, B:49:0x0117, B:51:0x0124, B:44:0x00eb, B:50:0x011b, B:52:0x012b, B:54:0x012f), top: B:63:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.accs.IACCSManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindApp(android.content.Context r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, com.taobao.accs.IAppReceiver r14) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ACCSManagerImpl.bindApp(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.taobao.accs.IAppReceiver):void");
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str, boolean z) {
        try {
            ALog.i(TAG, "bindUser", "userId", str);
            if (UtilityImpl.getFocusDisableStatus(context)) {
                ALog.e(TAG, "accs disabled", new Object[0]);
                return;
            }
            Intent intent = getIntent(context, 3);
            if (intent == null) {
                ALog.e(TAG, "intent null", new Object[0]);
                sendAppNotBind(context, 3, null, null);
                return;
            }
            String appkey = getConnection().getAppkey();
            if (TextUtils.isEmpty(appkey)) {
                ALog.e(TAG, "appKey null", new Object[0]);
                return;
            }
            if (UtilityImpl.appVersionChanged(context) || z) {
                ALog.i(TAG, "force bind User", new Object[0]);
                intent.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            intent.putExtra("appKey", appkey);
            intent.putExtra(Constants.KEY_USER_ID, str);
            if (UtilityImpl.isMainProcess(context)) {
                Message buildBindUser = Message.buildBindUser(getConnection().getHost(null), this.mConfigTag, intent);
                if (buildBindUser != null && buildBindUser.getNetPermanceMonitor() != null) {
                    buildBindUser.getNetPermanceMonitor().setDataId(buildBindUser.dataId);
                    buildBindUser.getNetPermanceMonitor().setHost(buildBindUser.host.toString());
                }
                sendControlMessage(context, buildBindUser, 3, z);
            }
            getConnection().startChannelService();
        } catch (Throwable th) {
            ALog.e(TAG, "bindUser", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendData(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendRequest(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        GlobalClientInfo.getInstance(context).setAppReceiver(this.mConfigTag, iAppReceiver);
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.d(TAG, "inapp only init in main process!", new Object[0]);
            return;
        }
        String str4 = TAG;
        ALog.d(str4, "startInAppConnection APPKEY:" + str, new Object[0]);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.equals(getConnection().getAppkey(), str)) {
                getConnection().setTTid(str3);
                getConnection().setAppkey(str);
                UtilityImpl.saveAppKey(context, str);
            }
            getConnection().start();
        } catch (IPCException e) {
            ALog.e(TAG, "startInAppConnection exception", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendData(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (accsRequest == null) {
            ALog.e(TAG, "sendRequest request null", new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
            return null;
        } else if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(TAG, "sendRequest not in mainprocess", new Object[0]);
            return null;
        } else if (UtilityImpl.getFocusDisableStatus(context)) {
            ALog.e(TAG, "sendRequest disable", new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
            return null;
        } else if (TextUtils.isEmpty(getConnection().getAppkey())) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
            ALog.e(TAG, "sendRequest appkey null", new Object[0]);
            return null;
        } else {
            getConnection().start();
            try {
                Message buildRequest = Message.buildRequest(context, getConnection().getHost(null), this.mConfigTag, "", str == null ? context.getPackageName() : str, Constants.TARGET_SERVICE_PRE, accsRequest, z);
                if (buildRequest != null && buildRequest.getNetPermanceMonitor() != null) {
                    buildRequest.getNetPermanceMonitor().onSend();
                }
                getConnection().send(buildRequest, true);
            } catch (Throwable th2) {
                th = th2;
                if (accsRequest != null) {
                    String str2 = accsRequest.serviceId;
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str2, "1", "request " + th.toString());
                    ALog.e(TAG, "sendRequest", th, Constants.KEY_DATA_ID, accsRequest.dataId);
                }
                return accsRequest.dataId;
            }
            return accsRequest.dataId;
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, ACCSManager.AccsRequest accsRequest) {
        boolean focusDisableStatus;
        try {
            focusDisableStatus = UtilityImpl.getFocusDisableStatus(context);
        } catch (Throwable th) {
            th = th;
        }
        if (!UtilityImpl.isMainProcess(context)) {
            ALog.e(TAG, "sendData not in mainprocess", new Object[0]);
            return null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            String str = accsRequest.serviceId;
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "data " + th.toString());
            ALog.e(TAG, "sendData", th, "dataid", accsRequest.dataId);
            return accsRequest.dataId;
        }
        if (!focusDisableStatus && accsRequest != null) {
            if (TextUtils.isEmpty(getConnection().getAppkey())) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data appkey null");
                ALog.e(TAG, "sendData appkey null", new Object[0]);
                return null;
            }
            getConnection().start();
            Message buildSendData = Message.buildSendData(getConnection().getHost(null), this.mConfigTag, getConnection().getStoreId(), context, context.getPackageName(), accsRequest);
            if (buildSendData != null && buildSendData.getNetPermanceMonitor() != null) {
                buildSendData.getNetPermanceMonitor().onSend();
            }
            if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(buildSendData.serviceId)) {
                ALog.e(TAG, "sendMessage", Constants.KEY_DATA_ID, buildSendData.getDataId());
            }
            getConnection().send(buildSendData, true);
            return accsRequest.dataId;
        }
        if (focusDisableStatus) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "accs disable");
        } else {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "data null");
        }
        String str2 = TAG;
        ALog.e(str2, "sendData dataInfo null or disable:" + focusDisableStatus, new Object[0]);
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest) {
        return sendRequest(context, accsRequest, null, true);
    }
}
