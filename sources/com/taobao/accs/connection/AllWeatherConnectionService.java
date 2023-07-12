package com.taobao.accs.connection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.IPCUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tb.C9708t9;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AllWeatherConnectionService extends ConnectionService {
    private static final String TAG = "AllWeatherConnectionService";
    protected static final ConnectionLock connLock = new ConnectionLock();
    private String mConfigTag;
    private Context mContext = GlobalClientInfo.getContext();
    private Boolean lastAllowed = null;
    private volatile boolean isDownGradle = false;
    private boolean isBackScheduled = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class ConnectionLock {
        static final String LOCK_FILE_NAME = "aw_con.lock";
        private long lastModified = -1;
        private String lastValue;

        ConnectionLock() {
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String getOrSetProcessByLock(int r18, java.lang.String r19) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.connection.AllWeatherConnectionService.ConnectionLock.getOrSetProcessByLock(int, java.lang.String):java.lang.String");
        }

        public void clear() {
            getOrSetProcessByLock(1, null);
        }

        public String getProcessIfEmptyThenSet(String str) {
            return getOrSetProcessByLock(0, str);
        }

        public void setProcess(String str) {
            getOrSetProcessByLock(1, str);
        }
    }

    public AllWeatherConnectionService() {
        schedule();
    }

    private void downGrade() {
        ALog.e(TAG, "downGrade", new Object[0]);
        this.isDownGradle = true;
        connLock.setProcess(this.mContext.getPackageName());
        if (UtilityImpl.isMainProcess(this.mContext)) {
            reset();
            try {
                ConnectionServiceManager.getInstance().getConnectionWrapper().start();
            } catch (IPCException e) {
                ALog.e(TAG, "downGrade err", e, new Object[0]);
            }
        }
        if (UtilityImpl.isChannelProcessAlive(this.mContext)) {
            Intent intent = new Intent(Constants.ACTION_CLOSE_CONNECTION);
            intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
            intent.setClassName(this.mContext.getPackageName(), AdapterUtilityImpl.channelService);
            IntentDispatch.dispatchIntent(this.mContext, intent);
        }
    }

    private void schedule() {
        if (OrangeAdapter.isConnAutoSwitch2Channel() && UtilityImpl.isMainProcess(this.mContext)) {
            ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: com.taobao.accs.connection.AllWeatherConnectionService.1
                @Override // java.lang.Runnable
                public void run() {
                    ALog.e(AllWeatherConnectionService.TAG, "onBackground() by schedule", new Object[0]);
                    if (ConnectionServiceManager.getInstance().isAllWeather()) {
                        AllWeatherConnectionService.this.onBackground();
                    }
                }
            }, 15L, TimeUnit.SECONDS);
        }
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public IConnection getConnection(String str, AccsClientConfig accsClientConfig) {
        if (this.conn == null) {
            this.mConfigTag = str;
            String processIfEmptyThenSet = connLock.getProcessIfEmptyThenSet(IPCUtils.getCurrentProcessName());
            boolean z = TextUtils.isEmpty(processIfEmptyThenSet) || processIfEmptyThenSet.equals(this.mContext.getPackageName());
            if (Utils.isMainProcess(this.mContext) && z) {
                this.conn = new ConnectionWrapper(str);
                this.isProxyConnection = false;
            } else {
                try {
                    if (UtilityImpl.isMainProcess(this.mContext)) {
                        GlobalClientInfo.getInstance(this.mContext).recoverListener("default");
                    }
                    this.conn = (IConnection) ARanger.create(new ComponentName(GlobalClientInfo.mContext, AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, accsClientConfig), new Pair(Integer.class, Integer.valueOf((ForeBackManager.getManager().getState() == 1 && UtilityImpl.isForeground(GlobalClientInfo.mContext)) ? 1 : 0)));
                    this.isProxyConnection = true;
                } catch (IPCException unused) {
                    downGrade();
                }
            }
            ALog.e(TAG, "getConnection-aw", "isUsingARanger", Boolean.valueOf(this.isProxyConnection));
        }
        return this.conn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isCurProcessAllow2Connect() {
        String currentProcessName = IPCUtils.getCurrentProcessName();
        String processIfEmptyThenSet = connLock.getProcessIfEmptyThenSet(currentProcessName);
        boolean z = TextUtils.isEmpty(processIfEmptyThenSet) || processIfEmptyThenSet.equals(currentProcessName);
        Boolean bool = this.lastAllowed;
        if (bool == null || bool.booleanValue() != z) {
            ALog.e(TAG, "isCurProcessAllow2Connect", "process", processIfEmptyThenSet, "allowed", Boolean.valueOf(z));
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.lastAllowed = valueOf;
        return valueOf.booleanValue();
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public boolean isProxyConnection() {
        return this.isProxyConnection;
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public void onBackground() {
        if (this.isDownGradle) {
            ALog.e(TAG, "onBackground() but already downGrade", new Object[0]);
        } else if (this.isBackScheduled) {
        } else {
            this.isBackScheduled = true;
            ALog.e(TAG, "onBackground schedule start", new Object[0]);
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.connection.AllWeatherConnectionService.2
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onBackground scheduling, ctx==null? ");
                    sb.append(AllWeatherConnectionService.this.mContext == null);
                    ALog.e(AllWeatherConnectionService.TAG, sb.toString(), new Object[0]);
                    try {
                        ((IChannelConnection) ARanger.create(new ComponentName(AllWeatherConnectionService.this.mContext, AccsIPCProvider.class), IChannelConnection.class, new Pair[0])).start(AllWeatherConnectionService.this.mConfigTag, ForeBackManager.getManager().getState(), new IChannelConnListener() { // from class: com.taobao.accs.connection.AllWeatherConnectionService.2.1
                            @Override // com.taobao.accs.connection.IChannelConnListener
                            public void onStart() {
                                ALog.e(AllWeatherConnectionService.TAG, "onChannelStart()", new Object[0]);
                                AllWeatherConnectionService.connLock.setProcess(UtilityImpl.getChannelProcessName(AllWeatherConnectionService.this.mContext));
                            }
                        });
                    } catch (IPCException e) {
                        ALog.e(AllWeatherConnectionService.TAG, "IChannelConnection err", e, new Object[0]);
                    }
                }
            }, 5L, TimeUnit.SECONDS);
        }
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public void onChannelConnectionChanged(boolean z) {
        ALog.e(TAG, "onConnectionStateChanged", "connected", Boolean.valueOf(z), "isUsingARanger", Boolean.valueOf(this.isProxyConnection));
        if (!z || this.isProxyConnection) {
            return;
        }
        try {
            BaseConnection connection = ((ConnectionWrapper) this.conn).getConnection();
            if (connection instanceof InAppConnection) {
                reset();
                if (OrangeAdapter.normalChangesEnabled()) {
                    C9708t9.z0(false);
                }
                ((InAppConnection) connection).unRegisterSessionInfo();
            }
            IConnection connectionWrapper = ConnectionServiceManager.getInstance().getConnectionWrapper();
            connectionWrapper.setForeBackState(ForeBackManager.getManager().getState());
            ArrayList<AccsConnectStateListener> accsConnectStateListenerArrayList = connection.getAccsConnectStateListenerArrayList();
            if (accsConnectStateListenerArrayList != null) {
                Iterator<AccsConnectStateListener> it = accsConnectStateListenerArrayList.iterator();
                while (it.hasNext()) {
                    connectionWrapper.registerConnectStateListener(it.next());
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "channelConnListener err", th, new Object[0]);
        }
    }
}
