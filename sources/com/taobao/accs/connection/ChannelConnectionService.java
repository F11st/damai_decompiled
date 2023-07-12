package com.taobao.accs.connection;

import android.content.ComponentName;
import android.util.Pair;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ChannelConnectionService extends ConnectionService {
    @Override // com.taobao.accs.connection.ConnectionService
    public IConnection getConnection(String str, AccsClientConfig accsClientConfig) {
        if (this.conn == null) {
            try {
                this.conn = (IConnection) ARanger.create(new ComponentName(GlobalClientInfo.mContext, AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, accsClientConfig), new Pair(Integer.class, Integer.valueOf((ForeBackManager.getManager().getState() == 1 && UtilityImpl.isForeground(GlobalClientInfo.mContext)) ? 1 : 0)));
                this.isProxyConnection = true;
            } catch (IPCException unused) {
                OrangeAdapter.resetChannelModeEnable();
                this.conn = new ConnectionWrapper(str);
                this.isProxyConnection = false;
            }
        }
        return this.conn;
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public boolean isProxyConnection() {
        return this.isProxyConnection;
    }
}
