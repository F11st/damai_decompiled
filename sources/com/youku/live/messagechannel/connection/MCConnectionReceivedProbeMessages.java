package com.youku.live.messagechannel.connection;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.message.MCSysMessageName;
import com.youku.live.messagechannel.message.QoS;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCConnectionReceivedProbeMessages {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CHARACTER_CONNECTOR = "|";
    private static final String TAG = "com.youku.live.messagechannel.connection.MCConnectionReceivedProbeMessages";
    private static Map<String, MCMessage> activeConnectionsProbeMsg = new ConcurrentHashMap();

    public static void clearProbe(long j, String str, MCConnectionFlag mCConnectionFlag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790910638")) {
            ipChange.ipc$dispatch("-790910638", new Object[]{Long.valueOf(j), str, mCConnectionFlag});
        } else {
            activeConnectionsProbeMsg.remove(genProbeKey(j, str, mCConnectionFlag));
        }
    }

    private static String genProbeKey(long j, String str, MCConnectionFlag mCConnectionFlag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1263400030")) {
            return (String) ipChange.ipc$dispatch("1263400030", new Object[]{Long.valueOf(j), str, mCConnectionFlag});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(j);
        stringBuffer.append("|");
        stringBuffer.append(str);
        stringBuffer.append("|");
        stringBuffer.append(mCConnectionFlag.name());
        return stringBuffer.toString();
    }

    public static MCMessage getLastedProbe(long j, String str, MCConnectionFlag mCConnectionFlag) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1559780804") ? (MCMessage) ipChange.ipc$dispatch("-1559780804", new Object[]{Long.valueOf(j), str, mCConnectionFlag}) : activeConnectionsProbeMsg.get(genProbeKey(j, str, mCConnectionFlag));
    }

    public static void initProbe(long j, String str, MCConnectionFlag mCConnectionFlag) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-601174111")) {
            ipChange.ipc$dispatch("-601174111", new Object[]{Long.valueOf(j), str, mCConnectionFlag});
            return;
        }
        MyLog.d(TAG, "Before init probe, active channel's count:", Integer.valueOf(activeConnectionsProbeMsg.size()));
        String genProbeKey = genProbeKey(j, str, mCConnectionFlag);
        if (activeConnectionsProbeMsg.containsKey(genProbeKey)) {
            return;
        }
        MCMessage mCMessage = new MCMessage();
        mCMessage.connectionSource = mCConnectionFlag;
        mCMessage.appId = j;
        mCMessage.channelId = str;
        mCMessage.msgId = "";
        mCMessage.msgType = MCSysMessageName.SYS_PROBE.getName();
        mCMessage.data = new byte[1];
        mCMessage.sendTime = 0L;
        mCMessage.qos = QoS.DISCARD_MEDIUM.name();
        mCMessage.expireTime = -1;
        mCMessage.statMark = false;
        activeConnectionsProbeMsg.put(genProbeKey, mCMessage);
    }

    public static void refreshProbe(MCMessage mCMessage) {
        String genProbeKey;
        MCMessage mCMessage2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31187170")) {
            ipChange.ipc$dispatch("31187170", new Object[]{mCMessage});
        } else if (mCMessage == null || !MCSysMessageName.SYS_PROBE.getName().equals(mCMessage.msgType) || (mCMessage2 = activeConnectionsProbeMsg.get((genProbeKey = genProbeKey(mCMessage.appId, mCMessage.channelId, mCMessage.connectionSource)))) == null || mCMessage2.msgId.equals(mCMessage.msgId) || mCMessage2.sendTime >= mCMessage.sendTime) {
        } else {
            activeConnectionsProbeMsg.put(genProbeKey, mCMessage);
        }
    }
}
