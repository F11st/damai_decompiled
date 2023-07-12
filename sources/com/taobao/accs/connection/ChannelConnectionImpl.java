package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class ChannelConnectionImpl implements IChannelConnection {
    private static final String TAG = "ChannelConnectionImpl";

    @Override // com.taobao.accs.connection.IChannelConnection
    public void start(String str, int i, IChannelConnListener iChannelConnListener) throws IPCException {
        if (iChannelConnListener != null) {
            try {
                iChannelConnListener.onStart();
                ElectionServiceImpl.getConnection(GlobalClientInfo.getContext(), str, true, -1, i);
            } catch (Throwable th) {
                ALog.e(TAG, "start err", th, new Object[0]);
            }
        }
    }
}
