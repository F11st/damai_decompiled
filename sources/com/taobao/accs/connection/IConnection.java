package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.data.Message;
import com.taobao.aranger.annotation.method.AutoRecover;
import com.taobao.aranger.annotation.method.oneway;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.exception.IPCException;

/* compiled from: Taobao */
@ServiceName("com.taobao.accs.connection.ConnectionWrapper")
/* loaded from: classes8.dex */
public interface IConnection {
    @Keep
    boolean cancel(String str) throws IPCException;

    @oneway
    @Keep
    void close() throws IPCException;

    @Keep
    @AutoRecover
    String getAppSecret() throws IPCException;

    @Keep
    @AutoRecover
    String getAppkey() throws IPCException;

    @Keep
    String getConfigTag() throws IPCException;

    @Keep
    @AutoRecover
    String getHost(String str) throws IPCException;

    @Keep
    @AutoRecover
    boolean getSendBackState() throws IPCException;

    @Keep
    @AutoRecover
    String getStoreId() throws IPCException;

    @Keep
    String getTag() throws IPCException;

    @Keep
    @AutoRecover
    boolean isAppBinded(String str) throws IPCException;

    @Keep
    boolean isAppUnbinded(String str) throws IPCException;

    @Keep
    @AutoRecover
    boolean isConnected() throws IPCException;

    @Keep
    boolean isUserBinded(String str, String str2) throws IPCException;

    @oneway
    @Keep
    void onResult(Message message, int i) throws IPCException;

    @oneway
    @Keep
    void ping(boolean z, boolean z2) throws IPCException;

    @Keep
    void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) throws IPCException;

    @Keep
    @AutoRecover
    void send(Message message, boolean z) throws IPCException;

    @Keep
    @AutoRecover
    void sendMessage(Message message) throws IPCException;

    @Keep
    void setAppkey(String str) throws IPCException;

    @Keep
    @AutoRecover
    void setForeBackState(int i) throws IPCException;

    @Keep
    @AutoRecover
    void setSendBackState(boolean z) throws IPCException;

    @Keep
    void setTTid(String str) throws IPCException;

    @oneway
    @Keep
    void start() throws IPCException;

    @oneway
    @Keep
    void startChannelService() throws IPCException;

    @Keep
    void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) throws IPCException;

    @Keep
    void updateConfig(AccsClientConfig accsClientConfig) throws IPCException;
}
