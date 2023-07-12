package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.method.oneway;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@ServiceName("com.taobao.accs.connection.ChannelConnectionImpl")
/* loaded from: classes8.dex */
public interface IChannelConnection {
    @oneway
    @Keep
    void start(String str, int i, IChannelConnListener iChannelConnListener) throws IPCException;
}
