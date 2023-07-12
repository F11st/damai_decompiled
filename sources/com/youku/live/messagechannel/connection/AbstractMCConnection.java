package com.youku.live.messagechannel.connection;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.callback.IMCConnectionEventCallback;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.message.MCMessageProcessor;
import com.youku.live.messagechannel.message.MCSysMessageName;
import com.youku.live.messagechannel.utils.MCThreadFactory;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.ServerTimeEstimater;
import io.reactivex.AbstractC8149d;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class AbstractMCConnection implements IMCConnection {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final long appId;
    private String appMonitorHeartBeatInterval;
    protected final String channelId;
    protected final Context context;
    private String maxDeliverCount;
    private volatile MCConnectionState mcConnectionState;
    private ScheduledThreadPoolExecutor stateCheckExecutor;
    private ScheduledFuture stateCheckFuture;
    protected final String TAG = getClass().getName();
    private volatile long lastedStateChangeTime = 0;

    public AbstractMCConnection(Context context, long j, String str) {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.maxPullmsgDistributeCnt;
        this.maxDeliverCount = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        OrangeConfig orangeConfig2 = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo2 = OrangeConfKey.appMonitorHeartBeatInterval;
        this.appMonitorHeartBeatInterval = orangeConfig2.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo2.name, keyInfo2.def);
        this.context = context;
        this.appId = j;
        this.channelId = str;
        setConnectionState(MCConnectionState.INIT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String appIdAndChannelString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589285617")) {
            return (String) ipChange.ipc$dispatch("-1589285617", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(", appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(", channelId:");
        stringBuffer.append(this.channelId);
        return stringBuffer.toString();
    }

    protected abstract boolean customDispatchFilterPass(MCMessage mCMessage);

    protected abstract void customLaunch(IMCConnectionEventCallback iMCConnectionEventCallback);

    protected abstract void customShutdown(IMCConnectionEventCallback iMCConnectionEventCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public void deliverMessages(List<MCMessage> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116373354")) {
            ipChange.ipc$dispatch("2116373354", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            MyLog.v(this.TAG, "Deliver receive ", Integer.valueOf(list.size()), " messages.");
            AbstractC8149d.fromIterable(list).filter(new Predicate<MCMessage>() { // from class: com.youku.live.messagechannel.connection.AbstractMCConnection.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // io.reactivex.functions.Predicate
                public boolean test(MCMessage mCMessage) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1607079614")) {
                        return ((Boolean) ipChange2.ipc$dispatch("-1607079614", new Object[]{this, mCMessage})).booleanValue();
                    }
                    if (mCMessage == null) {
                        return false;
                    }
                    if (MCSysMessageName.SYS_PROBE.getName().equals(mCMessage.msgType)) {
                        MCConnectionReceivedProbeMessages.refreshProbe(mCMessage);
                    }
                    return AbstractMCConnection.this.customDispatchFilterPass(mCMessage);
                }
            }).sorted(new Comparator<MCMessage>() { // from class: com.youku.live.messagechannel.connection.AbstractMCConnection.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.util.Comparator
                public int compare(MCMessage mCMessage, MCMessage mCMessage2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1749998295")) {
                        return ((Integer) ipChange2.ipc$dispatch("-1749998295", new Object[]{this, mCMessage, mCMessage2})).intValue();
                    }
                    long j = mCMessage.sendTime;
                    long j2 = mCMessage2.sendTime;
                    if (j > j2) {
                        return 1;
                    }
                    return j < j2 ? -1 : 0;
                }
            }).take(Integer.valueOf(this.maxDeliverCount).intValue()).toList().subscribe(new Consumer<List<MCMessage>>() { // from class: com.youku.live.messagechannel.connection.AbstractMCConnection.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // io.reactivex.functions.Consumer
                public void accept(List<MCMessage> list2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1673196457")) {
                        ipChange2.ipc$dispatch("-1673196457", new Object[]{this, list2});
                    } else if (list2 == null || list2.size() <= 0) {
                    } else {
                        if (AbstractMCConnection.this.getConnectionFlag() != MCConnectionFlag.PM && AbstractMCConnection.this.getConnectionFlag() != MCConnectionFlag.ACCS_MASS && AbstractMCConnection.this.mcConnectionState == MCConnectionState.CLOSED) {
                            MyLog.w(AbstractMCConnection.this.TAG, "Because of connection closed, deliver terminal push ", Integer.valueOf(list2.size()), " messages to MCMessageProcessor. MCConnectionState:", AbstractMCConnection.this.mcConnectionState, " ", JSON.toJSONString(list2));
                            return;
                        }
                        MyLog.v(AbstractMCConnection.this.TAG, "Deliver push ", Integer.valueOf(list2.size()), " messages to MCMessageProcessor. ", JSON.toJSONString(list2));
                        MCMessageProcessor.getInstance().process(list2);
                    }
                }
            });
        } else {
            MyLog.d(this.TAG, "Deliver messages is empty, connectionFlag: ", getConnectionFlag(), appIdAndChannelString());
        }
    }

    protected abstract void doSomethingForReopen();

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public MCConnectionState getConnectionState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-451787118") ? (MCConnectionState) ipChange.ipc$dispatch("-451787118", new Object[]{this}) : this.mcConnectionState;
    }

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public boolean isHealth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1496634626") ? ((Boolean) ipChange.ipc$dispatch("-1496634626", new Object[]{this})).booleanValue() : MCConnectionState.OPEN == this.mcConnectionState;
    }

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public void launch(IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776094700")) {
            ipChange.ipc$dispatch("776094700", new Object[]{this, iMCConnectionEventCallback});
        } else if (this.mcConnectionState == MCConnectionState.INIT) {
            setConnectionState(MCConnectionState.OPENING);
            MCConnectionReceivedProbeMessages.initProbe(this.appId, this.channelId, getConnectionFlag());
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new MCThreadFactory("stateCheck"));
            this.stateCheckExecutor = scheduledThreadPoolExecutor;
            this.stateCheckFuture = scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.youku.live.messagechannel.connection.AbstractMCConnection.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1399826578")) {
                        ipChange2.ipc$dispatch("1399826578", new Object[]{this});
                        return;
                    }
                    AbstractMCConnection abstractMCConnection = AbstractMCConnection.this;
                    MyLog.d(abstractMCConnection.TAG, "State selfCheck start", abstractMCConnection.appIdAndChannelString());
                    if (AbstractMCConnection.this.mcConnectionState.getCode() <= MCConnectionState.INIT.getCode() || System.currentTimeMillis() - AbstractMCConnection.this.lastedStateChangeTime <= Integer.valueOf(AbstractMCConnection.this.appMonitorHeartBeatInterval).intValue() * 1000) {
                        return;
                    }
                    AbstractMCConnection abstractMCConnection2 = AbstractMCConnection.this;
                    MCMessage lastedProbe = MCConnectionReceivedProbeMessages.getLastedProbe(abstractMCConnection2.appId, abstractMCConnection2.channelId, abstractMCConnection2.getConnectionFlag());
                    if (lastedProbe == null || ServerTimeEstimater.estimateServerTimestamp() - lastedProbe.sendTime > Integer.valueOf(AbstractMCConnection.this.appMonitorHeartBeatInterval).intValue() * 1000) {
                        if (AbstractMCConnection.this.mcConnectionState == MCConnectionState.OPEN) {
                            AbstractMCConnection.this.setConnectionState(MCConnectionState.BROKEN);
                            AbstractMCConnection abstractMCConnection3 = AbstractMCConnection.this;
                            MyLog.d(abstractMCConnection3.TAG, "Probe is miss, connection change state to:", abstractMCConnection3.mcConnectionState, AbstractMCConnection.this.appIdAndChannelString(), ", mcConnectionFlag:", AbstractMCConnection.this.getConnectionFlag());
                        }
                        AbstractMCConnection.this.doSomethingForReopen();
                        return;
                    }
                    MCConnectionState mCConnectionState = AbstractMCConnection.this.mcConnectionState;
                    MCConnectionState mCConnectionState2 = MCConnectionState.OPEN;
                    if (mCConnectionState != mCConnectionState2) {
                        AbstractMCConnection.this.setConnectionState(mCConnectionState2);
                        AbstractMCConnection abstractMCConnection4 = AbstractMCConnection.this;
                        MyLog.d(abstractMCConnection4.TAG, "Probe received, connection change state to:", abstractMCConnection4.mcConnectionState, AbstractMCConnection.this.appIdAndChannelString(), ", mcConnectionFlag:", AbstractMCConnection.this.getConnectionFlag());
                    }
                }
            }, Integer.valueOf(this.appMonitorHeartBeatInterval).intValue(), Integer.valueOf(this.appMonitorHeartBeatInterval).intValue(), TimeUnit.SECONDS);
            customLaunch(iMCConnectionEventCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setConnectionState(MCConnectionState mCConnectionState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087098734")) {
            ipChange.ipc$dispatch("2087098734", new Object[]{this, mCConnectionState});
            return;
        }
        this.lastedStateChangeTime = System.currentTimeMillis();
        if (this.mcConnectionState != mCConnectionState) {
            MCConnectionState mCConnectionState2 = this.mcConnectionState;
            this.mcConnectionState = mCConnectionState;
            MyLog.i(this.TAG, "Connection state change to:", this.mcConnectionState, appIdAndChannelString(), ", mcConnectionFlag:", getConnectionFlag());
            stateChangeNotify(mCConnectionState2, mCConnectionState);
        }
    }

    @Override // com.youku.live.messagechannel.connection.IMCConnection
    public void shutdown(IMCConnectionEventCallback iMCConnectionEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "143695631")) {
            ipChange.ipc$dispatch("143695631", new Object[]{this, iMCConnectionEventCallback});
            return;
        }
        setConnectionState(MCConnectionState.CLOSED);
        ScheduledFuture scheduledFuture = this.stateCheckFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.stateCheckFuture = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.stateCheckExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        MCConnectionReceivedProbeMessages.clearProbe(this.appId, this.channelId, getConnectionFlag());
        customShutdown(iMCConnectionEventCallback);
    }

    protected abstract void stateChangeNotify(MCConnectionState mCConnectionState, MCConnectionState mCConnectionState2);
}
