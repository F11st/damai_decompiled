package com.youku.live.messagechannel.message;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.heartbeat.MCHeartbeat;
import com.youku.live.messagechannel.report.MCMarkMessage;
import com.youku.live.messagechannel.report.MCMarkMessageManager;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.ServerTimeEstimater;
import io.reactivex.d;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCSystemMessageProcessor {
    private static transient /* synthetic */ IpChange $ipChange;
    private static MCSystemMessageProcessor systemMessageProcessor = new MCSystemMessageProcessor();
    private final String TAG = getClass().getName();
    private final Map<String, IMCSpecialMessageProcessor<MCMessage>> specialMessages;
    private Consumer<MCMessage> systemMessageConsumer;

    public MCSystemMessageProcessor() {
        HashMap hashMap = new HashMap();
        this.specialMessages = hashMap;
        hashMap.put(MCSysMessageName.SYS_PROBE.getName(), new IMCSpecialMessageProcessor<MCMessage>() { // from class: com.youku.live.messagechannel.message.MCSystemMessageProcessor.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.messagechannel.message.IMCSpecialMessageProcessor
            public void process(MCMessage mCMessage) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1808969087")) {
                    ipChange.ipc$dispatch("1808969087", new Object[]{this, mCMessage});
                    return;
                }
                MCSystemMessageProcessor.this.reportUT(mCMessage);
                long estimateServerTimestamp = ServerTimeEstimater.estimateServerTimestamp();
                MCMarkMessageManager.getInstance().storeMarkMessage(new MCMarkMessage(estimateServerTimestamp, estimateServerTimestamp, mCMessage, false));
                MyLog.d(MCSystemMessageProcessor.this.TAG, "Special message 'SYS_PROBE' process, message:", mCMessage);
            }
        });
        this.systemMessageConsumer = new Consumer<MCMessage>() { // from class: com.youku.live.messagechannel.message.MCSystemMessageProcessor.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // io.reactivex.functions.Consumer
            public void accept(MCMessage mCMessage) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1221748485")) {
                    ipChange.ipc$dispatch("1221748485", new Object[]{this, mCMessage});
                } else if (MCSystemMessageProcessor.this.specialMessages.containsKey(mCMessage.msgType)) {
                    ((IMCSpecialMessageProcessor) MCSystemMessageProcessor.this.specialMessages.get(mCMessage.msgType)).process(mCMessage);
                }
            }
        };
    }

    public static MCSystemMessageProcessor getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-77839909") ? (MCSystemMessageProcessor) ipChange.ipc$dispatch("-77839909", new Object[0]) : systemMessageProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUT(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169157090")) {
            ipChange.ipc$dispatch("-1169157090", new Object[]{this, mCMessage});
            return;
        }
        long estimateServerTimestamp = ServerTimeEstimater.estimateServerTimestamp();
        MCMessageReporter.getInstance().reportMessages(new MCMessageDispatch4UTRecord(mCMessage.appId, mCMessage.channelId, mCMessage.connectionSource.name(), mCMessage.msgId, mCMessage.msgType, mCMessage.qos, mCMessage.sendTime, mCMessage.expireTime, mCMessage.statMark, estimateServerTimestamp, estimateServerTimestamp, MCHeartbeat.getDeviceOnlineTimeInChannel(mCMessage.appId, mCMessage.channelId)));
    }

    public Consumer<MCMessage> getSystemMessageConsumer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "101382343") ? (Consumer) ipChange.ipc$dispatch("101382343", new Object[]{this}) : this.systemMessageConsumer;
    }

    public boolean isSystemMessage(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2037074325") ? ((Boolean) ipChange.ipc$dispatch("2037074325", new Object[]{this, mCMessage})).booleanValue() : mCMessage.msgType.startsWith("SYS_") || this.specialMessages.containsKey(mCMessage.msgType);
    }

    public void process(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1009710158")) {
            ipChange.ipc$dispatch("-1009710158", new Object[]{this, mCMessage});
        } else {
            d.just(mCMessage).subscribeOn(a.a()).subscribe(this.systemMessageConsumer);
        }
    }
}
