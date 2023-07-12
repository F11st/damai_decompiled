package com.taobao.accs.connection;

import android.content.Context;
import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class ConnectionWrapper implements IConnection {
    private static final String TAG = "ConnectionWrapper";
    private BaseConnection connection;

    @Keep
    public ConnectionWrapper(AccsClientConfig accsClientConfig, int i) {
        AccsClientConfig.setAccsConfig(accsClientConfig.getConfigEnv(), accsClientConfig);
        this.connection = ElectionServiceImpl.getConnection(GlobalClientInfo.mContext, accsClientConfig.getTag(), true, 0, i);
    }

    @Override // com.taobao.accs.connection.IConnection
    public boolean cancel(String str) {
        return this.connection.cancel(str);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void close() {
        this.connection.close();
    }

    @Override // com.taobao.accs.connection.IConnection
    public String getAppSecret() {
        return this.connection.mConfig.getAppSecret();
    }

    @Override // com.taobao.accs.connection.IConnection
    public String getAppkey() {
        return this.connection.getAppkey();
    }

    @Override // com.taobao.accs.connection.IConnection
    public String getConfigTag() {
        return this.connection.mConfigTag;
    }

    public BaseConnection getConnection() {
        return this.connection;
    }

    @Override // com.taobao.accs.connection.IConnection
    public String getHost(String str) {
        return this.connection.getHost(str);
    }

    @Override // com.taobao.accs.connection.IConnection
    public boolean getSendBackState() {
        return this.connection.getSendBackState();
    }

    @Override // com.taobao.accs.connection.IConnection
    public String getStoreId() {
        return this.connection.mConfig.getStoreId();
    }

    @Override // com.taobao.accs.connection.IConnection
    public String getTag() {
        return this.connection.getTag();
    }

    @Override // com.taobao.accs.connection.IConnection
    public boolean isAppBinded(String str) {
        return this.connection.getClientManager().isAppBinded(str);
    }

    @Override // com.taobao.accs.connection.IConnection
    public boolean isAppUnbinded(String str) {
        return this.connection.getClientManager().isAppUnbinded(str);
    }

    @Override // com.taobao.accs.connection.IConnection
    public boolean isConnected() {
        return this.connection.isConnected();
    }

    @Override // com.taobao.accs.connection.IConnection
    public boolean isUserBinded(String str, String str2) {
        return this.connection.getClientManager().isUserBinded(str, str2);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void onResult(Message message, int i) {
        this.connection.onResult(message, i);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void ping(boolean z, boolean z2) {
        this.connection.ping(z, z2);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        this.connection.registerConnectStateListener(accsConnectStateListener);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void send(Message message, boolean z) {
        this.connection.send(message, z);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void sendMessage(Message message) {
        this.connection.sendMessage(message, true);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void setAppkey(String str) {
        this.connection.mAppkey = str;
    }

    @Override // com.taobao.accs.connection.IConnection
    public void setForeBackState(int i) {
        this.connection.setForeBackState(i);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void setSendBackState(boolean z) {
        this.connection.setSendBackState(z);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void setTTid(String str) {
        this.connection.mTtid = str;
    }

    @Override // com.taobao.accs.connection.IConnection
    public void start() {
        this.connection.start();
    }

    @Override // com.taobao.accs.connection.IConnection
    public void startChannelService() {
        this.connection.startChannelService();
    }

    @Override // com.taobao.accs.connection.IConnection
    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        this.connection.unRegisterConnectStateListener(accsConnectStateListener);
    }

    @Override // com.taobao.accs.connection.IConnection
    public void updateConfig(AccsClientConfig accsClientConfig) {
        BaseConnection baseConnection = this.connection;
        if (baseConnection instanceof InAppConnection) {
            ((InAppConnection) baseConnection).updateConfig(accsClientConfig);
        }
    }

    public ConnectionWrapper(String str) {
        Context context = GlobalClientInfo.mContext;
        if (ConnectionServiceManager.getInstance().isEnabled(context)) {
            if (UtilityImpl.isMainProcess(context)) {
                this.connection = ElectionServiceImpl.getConnection(GlobalClientInfo.mContext, str, true, 0, ForeBackManager.getManager().getState());
                return;
            }
            this.connection = ElectionServiceImpl.getConnection(GlobalClientInfo.mContext, str, true, 0);
            return;
        }
        ALog.e(TAG, "new app connection", new Object[0]);
        this.connection = new InAppConnection(GlobalClientInfo.mContext, 1, str);
    }
}
