package com.youku.live.messagechannel.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.callback.IMCConnectionEventCallback;
import com.youku.live.messagechannel.callback.MCConnectionEvent;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.connection.Connector.AccsH5Connector;
import com.youku.live.messagechannel.connection.Connector.ConnectorListener;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.message.MCSysMessageName;
import com.youku.live.messagechannel.utils.AppFrontBackHelper;
import com.youku.live.messagechannel.utils.HttpUtils;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AccsMassMCConnection extends AbstractMCConnection {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CHARACTER_CONNECTOR = "@";
    private static volatile boolean accsDataListenerRegistered = false;
    private static volatile Map<String, AccsMassMCConnection> activeConnections = new HashMap();
    public static final String serviceId = "YK_MessageChannel";
    private final String TAG;
    private String accsYoukuConnectHost;
    private String closeSupplySubscribe;
    private final boolean connectByMyself;
    private ConnectReceiver connectReceiver;
    private long lastSupplySubscribeTime;
    private IMCConnectionEventCallback launchCallback;
    private IMCConnectionEventCallback shutdownCallback;
    private String subscribeRequestId;
    private final String topic;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class ConnectReceiver extends BroadcastReceiver {
        ConnectReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TaoBaseService.ConnectInfo connectInfo = (TaoBaseService.ConnectInfo) intent.getExtras().get(Constants.KEY_CONNECT_INFO);
            if (connectInfo == null || TextUtils.isEmpty(connectInfo.host) || connectInfo.host.indexOf(AccsMassMCConnection.this.accsYoukuConnectHost) <= -1) {
                return;
            }
            for (AccsMassMCConnection accsMassMCConnection : AccsMassMCConnection.activeConnections.values()) {
                if (accsMassMCConnection != null && !accsMassMCConnection.connectByMyself) {
                    if (connectInfo.connected) {
                        if (accsMassMCConnection.getConnectionState() == MCConnectionState.BROKEN) {
                            accsMassMCConnection.supplySubscribeMsgFromServer();
                            MyLog.i(AccsMassMCConnection.this.TAG, "ACCS connection intent onConnected and connection is BROKEN, begin supply subscribe", accsMassMCConnection.appIdAndChannelString(), ", host:", connectInfo.host, ", mcConnectionState:", accsMassMCConnection.getConnectionState());
                        }
                    } else {
                        accsMassMCConnection.setConnectionState(MCConnectionState.BROKEN);
                        MyLog.i(AccsMassMCConnection.this.TAG, "ACCS connection intent onDisconnected, change state to BROKEN", accsMassMCConnection.appIdAndChannelString(), ", host:", connectInfo.host, ", errorCode:", Integer.valueOf(connectInfo.errorCode), ", errorDetail:", connectInfo.errordetail);
                    }
                }
            }
        }
    }

    public AccsMassMCConnection(Context context, long j, String str, String str2, boolean z) {
        super(context, j, str);
        this.TAG = getClass().getName();
        this.subscribeRequestId = "1234";
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.closeAccsMassCloseSupplySubscribe;
        this.closeSupplySubscribe = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig orangeConfig2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.accsYoukuConnectHost;
        this.accsYoukuConnectHost = orangeConfig2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        this.lastSupplySubscribeTime = 0L;
        this.topic = str2;
        this.connectByMyself = z;
    }

    private static String activeConnectionKey(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1054999587")) {
            return (String) ipChange.ipc$dispatch("-1054999587", new Object[]{Long.valueOf(j), str});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j);
        stringBuffer.append("@");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private void asyncSubscribeNotify(MassSubscribeResult massSubscribeResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226052342")) {
            ipChange.ipc$dispatch("1226052342", new Object[]{this, massSubscribeResult});
        } else if (getConnectionState() == MCConnectionState.OPENING && massSubscribeResult != null && massSubscribeResult.subscribeRequestId.equals(this.subscribeRequestId) && massSubscribeResult.appId == this.appId && massSubscribeResult.channelId.equals(this.channelId) && massSubscribeResult.topic.equals(this.topic)) {
            if (massSubscribeResult.success) {
                setConnectionState(MCConnectionState.OPEN);
                MyLog.d(this.TAG, "MASS async subscribe success. topic:", this.topic, appIdAndChannelString(), ", mcConnectionState:", getConnectionState());
                IMCConnectionEventCallback iMCConnectionEventCallback = this.launchCallback;
                if (iMCConnectionEventCallback != null) {
                    MCConnectionEvent mCConnectionEvent = MCConnectionEvent.LAUNCH_SUCCESS;
                    iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
                    return;
                }
                return;
            }
            MyLog.e(this.TAG, "MASS async subscribe fail. topic:", this.topic, appIdAndChannelString(), ", mcConnectionState:", getConnectionState());
            IMCConnectionEventCallback iMCConnectionEventCallback2 = this.launchCallback;
            if (iMCConnectionEventCallback2 != null) {
                MCConnectionEvent mCConnectionEvent2 = MCConnectionEvent.LAUNCH_FAIL;
                iMCConnectionEventCallback2.onEvent(mCConnectionEvent2, mCConnectionEvent2.getMsg(), null);
            }
        }
    }

    private boolean isOtherConnectionUsedMyselfConnector() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315263060")) {
            return ((Boolean) ipChange.ipc$dispatch("315263060", new Object[]{this})).booleanValue();
        }
        for (AccsMassMCConnection accsMassMCConnection : activeConnections.values()) {
            if (accsMassMCConnection.connectByMyself) {
                return true;
            }
        }
        return false;
    }

    private void startDataListen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127212749")) {
            ipChange.ipc$dispatch("-1127212749", new Object[]{this});
        } else {
            GlobalClientInfo.getInstance(this.context).registerListener(serviceId, new AccsAbstractDataListener() { // from class: com.youku.live.messagechannel.connection.AccsMassMCConnection.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.accs.base.AccsDataListener
                public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1001468881")) {
                        ipChange2.ipc$dispatch("1001468881", new Object[]{this, str, Integer.valueOf(i), extraInfo});
                    }
                }

                @Override // com.taobao.accs.base.AccsDataListener
                public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-544952960")) {
                        ipChange2.ipc$dispatch("-544952960", new Object[]{this, str, str2, str3, bArr, extraInfo});
                    } else if (!AccsMassMCConnection.serviceId.equals(str)) {
                        MyLog.e(AccsMassMCConnection.this.TAG, "Received serviceId: ", str, " is not match ", AccsMassMCConnection.serviceId);
                    } else if (bArr == null || bArr.length == 0) {
                        MyLog.e(AccsMassMCConnection.this.TAG, "ACCS message data is empty!");
                    } else {
                        try {
                            JSONObject parseObject = JSON.parseObject(new String(bArr));
                            if (parseObject != null) {
                                AccsMassMCConnection.this.deliverMessages(MCMessage.parseMsgJsonToMCMessages(MCConnectionFlag.ACCS_MASS, parseObject));
                            }
                        } catch (Exception e) {
                            MyLog.e(AccsMassMCConnection.this.TAG, "ACCS message data parse error!", e);
                        }
                    }
                }

                @Override // com.taobao.accs.base.AccsDataListener
                public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-637589328")) {
                        ipChange2.ipc$dispatch("-637589328", new Object[]{this, str, str2, Integer.valueOf(i), bArr, extraInfo});
                    }
                }

                @Override // com.taobao.accs.base.AccsDataListener
                public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1537291174")) {
                        ipChange2.ipc$dispatch("1537291174", new Object[]{this, str, str2, Integer.valueOf(i), extraInfo});
                    }
                }

                @Override // com.taobao.accs.base.AccsDataListener
                public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2078444264")) {
                        ipChange2.ipc$dispatch("-2078444264", new Object[]{this, str, Integer.valueOf(i), extraInfo});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeMsgFromServer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439995296")) {
            ipChange.ipc$dispatch("-439995296", new Object[]{this});
            return;
        }
        this.subscribeRequestId = UUID.randomUUID().toString();
        HttpUtils.massSubscribe(this.context, String.valueOf(this.appId), this.channelId, this.topic, this.subscribeRequestId, new MtopCallback.MtopFinishListener() { // from class: com.youku.live.messagechannel.connection.AccsMassMCConnection.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
            public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "936369751")) {
                    ipChange2.ipc$dispatch("936369751", new Object[]{this, mtopFinishEvent, obj});
                    return;
                }
                MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                if (!mtopResponse.getApi().equals(HttpUtils.HTTP_MASS_SUBSCRIBE) || !mtopResponse.isApiSuccess()) {
                    MyLog.e(AccsMassMCConnection.this.TAG, "MASS subscribe request fail. topic:", AccsMassMCConnection.this.topic, " code:", mtopResponse.getRetCode(), " msg:", mtopResponse.getRetMsg(), AccsMassMCConnection.this.appIdAndChannelString(), ", mcConnectionState:", AccsMassMCConnection.this.getConnectionState());
                } else {
                    MyLog.d(AccsMassMCConnection.this.TAG, "MASS subscribe request success. topic:", AccsMassMCConnection.this.topic, AccsMassMCConnection.this.appIdAndChannelString(), ", mcConnectionState:", AccsMassMCConnection.this.getConnectionState());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void supplySubscribeMsgFromServer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230988047")) {
            ipChange.ipc$dispatch("-230988047", new Object[]{this});
        } else if ("0".equals(this.closeSupplySubscribe)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastSupplySubscribeTime > 3000) {
                this.lastSupplySubscribeTime = currentTimeMillis;
                HttpUtils.massSupplySubscribe(this.context, String.valueOf(this.appId), this.channelId, this.topic, new MtopCallback.MtopFinishListener() { // from class: com.youku.live.messagechannel.connection.AccsMassMCConnection.3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
                    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1172663498")) {
                            ipChange2.ipc$dispatch("-1172663498", new Object[]{this, mtopFinishEvent, obj});
                            return;
                        }
                        MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                        if (!mtopResponse.getApi().equals(HttpUtils.HTTP_MASS_SUPPLY_SUBSCRIBE) || !mtopResponse.isApiSuccess()) {
                            MyLog.e(AccsMassMCConnection.this.TAG, "MASS supply subscribe fail. topic:", AccsMassMCConnection.this.topic, " code:", mtopResponse.getRetCode(), " msg:", mtopResponse.getRetMsg(), AccsMassMCConnection.this.appIdAndChannelString(), ", mcConnectionState:", AccsMassMCConnection.this.getConnectionState());
                        } else {
                            MyLog.d(AccsMassMCConnection.this.TAG, "MASS supply subscribe success. topic:", AccsMassMCConnection.this.topic, AccsMassMCConnection.this.appIdAndChannelString(), ", mcConnectionState:", AccsMassMCConnection.this.getConnectionState());
                        }
                    }
                });
            }
        }
    }

    private void unsubscribeMsgFromServer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-152157145")) {
            ipChange.ipc$dispatch("-152157145", new Object[]{this});
        } else {
            HttpUtils.massUnsubscribe(this.context, String.valueOf(this.appId), this.channelId, this.topic, new MtopCallback.MtopFinishListener() { // from class: com.youku.live.messagechannel.connection.AccsMassMCConnection.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
                public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1013270549")) {
                        ipChange2.ipc$dispatch("1013270549", new Object[]{this, mtopFinishEvent, obj});
                        return;
                    }
                    MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                    if (!mtopResponse.getApi().equals(HttpUtils.HTTP_MASS_UNSUBSCRIBE) || !mtopResponse.isApiSuccess()) {
                        MyLog.e(AccsMassMCConnection.this.TAG, "MASS unSubscribe fail. topic:", AccsMassMCConnection.this.topic, " code:", mtopResponse.getRetCode(), " msg:", mtopResponse.getRetMsg(), AccsMassMCConnection.this.appIdAndChannelString(), ", mcConnectionState:", AccsMassMCConnection.this.getConnectionState());
                        if (AccsMassMCConnection.this.shutdownCallback != null) {
                            AccsMassMCConnection.this.shutdownCallback.onEvent(MCConnectionEvent.SHUTDOWN_FAIL, mtopResponse.getRetMsg(), null);
                            return;
                        }
                        return;
                    }
                    MyLog.d(AccsMassMCConnection.this.TAG, "MASS unSubscribe success. topic:", AccsMassMCConnection.this.topic, AccsMassMCConnection.this.appIdAndChannelString(), ", mcConnectionState:", AccsMassMCConnection.this.getConnectionState());
                    if (AccsMassMCConnection.this.shutdownCallback != null) {
                        IMCConnectionEventCallback iMCConnectionEventCallback = AccsMassMCConnection.this.shutdownCallback;
                        MCConnectionEvent mCConnectionEvent = MCConnectionEvent.SHUTDOWN_SUCCESS;
                        iMCConnectionEventCallback.onEvent(mCConnectionEvent, mCConnectionEvent.getMsg(), null);
                    }
                }
            });
        }
    }

    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    protected boolean customDispatchFilterPass(MCMessage mCMessage) {
        MassSubscribeResult massSubscribeResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160994672")) {
            return ((Boolean) ipChange.ipc$dispatch("-1160994672", new Object[]{this, mCMessage})).booleanValue();
        }
        AccsMassMCConnection accsMassMCConnection = activeConnections.get(activeConnectionKey(mCMessage.appId, mCMessage.channelId));
        if (accsMassMCConnection == null) {
            return false;
        }
        if (MCSysMessageName.SYS_MASS_SUBSCRIBE.getName().equals(mCMessage.msgType)) {
            byte[] bArr = mCMessage.data;
            if (bArr != null && (massSubscribeResult = (MassSubscribeResult) JSON.parseObject(new String(bArr), MassSubscribeResult.class)) != null) {
                accsMassMCConnection.asyncSubscribeNotify(massSubscribeResult);
            }
            return false;
        }
        return true;
    }

    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    protected void customLaunch(IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-152922951")) {
            ipChange.ipc$dispatch("-152922951", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        this.launchCallback = iMCConnectionEventCallback;
        MyLog.d(this.TAG, "Before activate AccsMassMCConnection, active channel's count:", Integer.valueOf(activeConnections.size()));
        activeConnections.put(activeConnectionKey(this.appId, this.channelId), this);
        if (this.connectByMyself) {
            if (AccsH5Connector.getInstance().isSubscribe(serviceId)) {
                return;
            }
            AccsH5Connector.getInstance().subscribe(serviceId, new ConnectorListener() { // from class: com.youku.live.messagechannel.connection.AccsMassMCConnection.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.messagechannel.connection.Connector.ConnectorListener
                public void onClosed() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1553098982")) {
                        ipChange2.ipc$dispatch("1553098982", new Object[]{this});
                        return;
                    }
                    for (AccsMassMCConnection accsMassMCConnection : AccsMassMCConnection.activeConnections.values()) {
                        if (accsMassMCConnection != null && accsMassMCConnection.connectByMyself) {
                            accsMassMCConnection.setConnectionState(MCConnectionState.BROKEN);
                            MyLog.i(AccsMassMCConnection.this.TAG, "ACCS H5 connector onClosed, change state to BROKEN", accsMassMCConnection.appIdAndChannelString());
                        }
                    }
                }

                @Override // com.youku.live.messagechannel.connection.Connector.ConnectorListener
                public void onError(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1240966202")) {
                        ipChange2.ipc$dispatch("1240966202", new Object[]{this, str});
                    } else {
                        MyLog.e(AccsMassMCConnection.this.TAG, "ACCS H5 connector error, ", str);
                    }
                }

                @Override // com.youku.live.messagechannel.connection.Connector.ConnectorListener
                public void onMessage(String str, String str2, byte[] bArr) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1199501460")) {
                        ipChange2.ipc$dispatch("-1199501460", new Object[]{this, str, str2, bArr});
                    } else if (!AccsMassMCConnection.serviceId.equals(str)) {
                        MyLog.e(AccsMassMCConnection.this.TAG, "ACCS H5 connector received serviceId: ", str, " is not match ", AccsMassMCConnection.serviceId);
                    } else if (bArr == null || bArr.length == 0) {
                        MyLog.e(AccsMassMCConnection.this.TAG, "ACCS H5 connector message data is empty!");
                    } else {
                        try {
                            JSONObject parseObject = JSON.parseObject(new String(bArr));
                            if (parseObject != null) {
                                AccsMassMCConnection.this.deliverMessages(MCMessage.parseMsgJsonToMCMessages(MCConnectionFlag.ACCS_MASS, parseObject));
                            }
                        } catch (Exception e) {
                            MyLog.e(AccsMassMCConnection.this.TAG, "ACCS H5 connector message data parse error!", e);
                        }
                    }
                }

                @Override // com.youku.live.messagechannel.connection.Connector.ConnectorListener
                public void onOpen() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1310293368")) {
                        ipChange2.ipc$dispatch("-1310293368", new Object[]{this});
                        return;
                    }
                    for (AccsMassMCConnection accsMassMCConnection : AccsMassMCConnection.activeConnections.values()) {
                        if (accsMassMCConnection != null && accsMassMCConnection.connectByMyself) {
                            if (accsMassMCConnection.getConnectionState() == MCConnectionState.OPENING) {
                                accsMassMCConnection.subscribeMsgFromServer();
                                MyLog.i(AccsMassMCConnection.this.TAG, "ACCS H5 connector onOpen and connection is OPENING, begin subscribe", accsMassMCConnection.appIdAndChannelString(), ", mcConnectionState:", accsMassMCConnection.getConnectionState());
                            }
                            if (accsMassMCConnection.getConnectionState() == MCConnectionState.BROKEN) {
                                accsMassMCConnection.supplySubscribeMsgFromServer();
                                MyLog.i(AccsMassMCConnection.this.TAG, "ACCS H5 connector onOpen and connection is BROKEN, begin supply subscribe", accsMassMCConnection.appIdAndChannelString(), ", mcConnectionState:", accsMassMCConnection.getConnectionState());
                            }
                        }
                    }
                }
            });
            return;
        }
        if (!accsDataListenerRegistered) {
            startDataListen();
            this.connectReceiver = new ConnectReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constants.ACTION_CONNECT_INFO);
            this.context.registerReceiver(this.connectReceiver, intentFilter);
            accsDataListenerRegistered = true;
        }
        subscribeMsgFromServer();
    }

    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    protected void customShutdown(IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710930588")) {
            ipChange.ipc$dispatch("710930588", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        this.shutdownCallback = iMCConnectionEventCallback;
        unsubscribeMsgFromServer();
        activeConnections.remove(activeConnectionKey(this.appId, this.channelId));
        if (this.connectByMyself && !isOtherConnectionUsedMyselfConnector() && AccsH5Connector.getInstance().isSubscribe(serviceId)) {
            AccsH5Connector.getInstance().unsubscribe(serviceId);
        }
    }

    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    protected void doSomethingForReopen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-837514675")) {
            ipChange.ipc$dispatch("-837514675", new Object[]{this});
        } else if (AppFrontBackHelper.getInstance().isOnBackground()) {
        } else {
            supplySubscribeMsgFromServer();
        }
    }

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public MCConnectionFlag getConnectionFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "513835114") ? (MCConnectionFlag) ipChange.ipc$dispatch("513835114", new Object[]{this}) : MCConnectionFlag.ACCS_MASS;
    }

    @Override // com.youku.live.messagechannel.connection.AbstractMCConnection
    protected void stateChangeNotify(MCConnectionState mCConnectionState, MCConnectionState mCConnectionState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173249830")) {
            ipChange.ipc$dispatch("-173249830", new Object[]{this, mCConnectionState, mCConnectionState2});
        }
    }
}
