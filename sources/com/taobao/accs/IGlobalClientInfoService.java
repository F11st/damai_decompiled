package com.taobao.accs;

import androidx.annotation.Keep;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.exception.IPCException;
import java.util.Map;

/* compiled from: Taobao */
@ServiceName("com.taobao.accs.client.GlobalClientInfo")
/* loaded from: classes8.dex */
public interface IGlobalClientInfoService {
    @Keep
    void registerAllRemoteService(String str, Map<String, String> map) throws IPCException;

    @Keep
    void registerRemoteListener(String str, AccsDataListener accsDataListener) throws IPCException;

    @Keep
    void registerRemoteService(String str, String str2) throws IPCException;

    @Keep
    void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) throws IPCException;

    @Keep
    void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) throws IPCException;

    @Keep
    void unregisterRemoteListener(String str) throws IPCException;

    @Keep
    void unregisterRemoteService(String str) throws IPCException;
}
