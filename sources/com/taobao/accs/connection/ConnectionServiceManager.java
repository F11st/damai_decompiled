package com.taobao.accs.connection;

import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IGlobalClientInfoService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ABAdapter;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.accs.utl.syncps.SyncChannelSwitch;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.intf.ProcessStateListener;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.jn1;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class ConnectionServiceManager {
    private static final String TAG = "ConnectionServiceManager";
    public static final String TYPE_ALL_WEATHER = "2";
    public static final String TYPE_CHANNEL = "1";
    public static final String TYPE_NONE = "0";
    private static final Map<String, ConnectionService> maps = new HashMap();
    private AccsClientConfig clientConfig;
    private String configTag;
    private final ConnectionService connService;
    private Boolean enabled;
    private boolean isChannelConnected;
    private AtomicBoolean isInit;
    private final ProcessStateListener processStateListener;
    private String serviceType;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class SingletonHolder {
        private static final ConnectionServiceManager instance = new ConnectionServiceManager();

        private SingletonHolder() {
        }
    }

    @Keep
    public static ConnectionServiceManager getInstance() {
        return SingletonHolder.instance;
    }

    private void setServiceType() {
        String connectionServiceType = OrangeAdapter.getConnectionServiceType(GlobalClientInfo.getContext());
        ALog.e(TAG, "getServiceType by orange " + connectionServiceType, new Object[0]);
        if (ABAdapter.isFeatureOpened(Constants.AB.KEY_CONN_SERVICE_TYPE_CB)) {
            ALog.e(TAG, "getServiceType by AB TYPE_CHANNEL", new Object[0]);
            connectionServiceType = "1";
        } else if (ABAdapter.isFeatureOpened(Constants.AB.KEY_CONN_SERVICE_TYPE_AW)) {
            ALog.e(TAG, "getServiceType by AB TYPE_ALL_WEATHER", new Object[0]);
            connectionServiceType = "2";
        }
        String orSetValueInProcessLock = SyncChannelSwitch.getOrSetValueInProcessLock(GlobalClientInfo.getContext(), SyncChannelSwitch.FILE_CONN_SERVICES, connectionServiceType);
        if (TextUtils.isEmpty(orSetValueInProcessLock)) {
            orSetValueInProcessLock = "0";
        }
        this.serviceType = orSetValueInProcessLock;
    }

    public void coldLaunch() {
        try {
            ALog.e(TAG, "coldLaunch", "connService", this.connService.getClass().getName());
            if (isAllWeather()) {
                AllWeatherConnectionService.connLock.clear();
                ALog.preTag = jn1.ARRAY_START_STR + (SystemClock.elapsedRealtime() / 10000) + "] " + ALog.oriTag;
            }
            GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_FILE_NAME, 0).edit().putString(Constants.KEY_LOG_TAG, ALog.preTag).apply();
        } catch (Exception e) {
            ALog.e(TAG, "coldLaunch err", e, new Object[0]);
        }
    }

    public IConnection getConnectionWrapper() {
        try {
            return this.connService.getConnection(this.configTag, this.clientConfig);
        } catch (Throwable th) {
            ALog.e(TAG, "getService err", th, new Object[0]);
            return null;
        }
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public void init(String str, AccsClientConfig accsClientConfig) {
        if (this.isInit.getAndSet(true)) {
            ALog.e(TAG, "already init", new Object[0]);
            return;
        }
        this.configTag = str;
        this.clientConfig = accsClientConfig;
        ALog.e(TAG, UCCore.LEGACY_EVENT_INIT, new Object[0]);
        if (Utils.isMainProcess(GlobalClientInfo.getContext())) {
            ARanger.registerProcessStateListener(this.processStateListener);
        }
    }

    @Keep
    public boolean isAllWeather() {
        return this.connService instanceof AllWeatherConnectionService;
    }

    public boolean isChannelConnected() {
        return this.isChannelConnected && UtilityImpl.isChannelProcessAlive(GlobalClientInfo.getContext());
    }

    public boolean isCurProcessAllow2Connect() {
        try {
            if (isAllWeather()) {
                return ((AllWeatherConnectionService) this.connService).isCurProcessAllow2Connect();
            }
            return true;
        } catch (Exception e) {
            ALog.e(TAG, "isCurProcessAllow2Connect err", e, new Object[0]);
            return true;
        }
    }

    public synchronized boolean isEnabled(Context context) {
        if (this.enabled == null) {
            this.enabled = Boolean.valueOf((TextUtils.isEmpty(this.serviceType) || this.serviceType.equals("0")) ? false : true);
        }
        return this.enabled.booleanValue();
    }

    public boolean isProxyConnection() {
        return this.connService.isProxyConnection();
    }

    public void onBackground() {
        this.connService.onBackground();
    }

    public void onChannelConnectionChanged(boolean z) {
        ConnectionService connectionService = this.connService;
        this.isChannelConnected = z;
        connectionService.onChannelConnectionChanged(z);
    }

    public void onForeground() {
        this.connService.onForeground();
    }

    private ConnectionServiceManager() {
        this.enabled = null;
        this.isChannelConnected = false;
        this.isInit = new AtomicBoolean();
        this.processStateListener = new ProcessStateListener() { // from class: com.taobao.accs.connection.ConnectionServiceManager.1
            @Override // com.taobao.aranger.intf.ProcessStateListener
            public void onProcessStart(String str) {
            }

            @Override // com.taobao.aranger.intf.ProcessStateListener
            public void onProcessStop(String str) {
                ALog.e(ConnectionServiceManager.TAG, "onProcessStop: " + str, new Object[0]);
                if (!ConnectionServiceManager.this.connService.isProxyConnection()) {
                    ALog.e(ConnectionServiceManager.TAG, "not aranger proxy", new Object[0]);
                    return;
                }
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
                    GlobalClientInfo.getInstance(ARanger.getContext()).recoverListener(ConnectionServiceManager.this.configTag);
                } catch (Throwable th) {
                    ALog.e(ConnectionServiceManager.TAG, "on processStateListener global error", th, new Object[0]);
                }
                try {
                    ConnectionServiceManager.this.connService.reset();
                    IConnection connection = ConnectionServiceManager.this.connService.getConnection(ConnectionServiceManager.this.configTag, ConnectionServiceManager.this.clientConfig);
                    connection.start();
                    connection.setForeBackState(ForeBackManager.getManager().getState());
                } catch (Throwable th2) {
                    ALog.e(ConnectionServiceManager.TAG, "on processStateListener connection_service error", th2, new Object[0]);
                }
            }
        };
        try {
            Map<String, ConnectionService> map = maps;
            map.put("1", new ChannelConnectionService());
            map.put("2", new AllWeatherConnectionService());
            setServiceType();
        } catch (Throwable th) {
            ALog.e(TAG, "ConnectionServiceManager init err", th, new Object[0]);
        }
        Map<String, ConnectionService> map2 = maps;
        if (map2.containsKey(this.serviceType)) {
            this.connService = map2.get(this.serviceType);
        } else {
            this.connService = new ChannelConnectionService();
        }
    }
}
