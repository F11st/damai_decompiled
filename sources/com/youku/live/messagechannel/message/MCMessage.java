package com.youku.live.messagechannel.message;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.youku.live.messagechannel.connection.MCConnectionFlag;
import io.reactivex.AbstractC8149d;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = ALBiometricsKeys.KEY_APP_ID)
    public long appId;
    @JSONField(name = RemoteMessageConst.Notification.CHANNEL_ID)
    public String channelId;
    @JSONField(name = "connectionSource")
    public MCConnectionFlag connectionSource;
    @JSONField(name = "data")
    public byte[] data;
    @JSONField(name = "expireTime")
    public int expireTime;
    @JSONField(name = RemoteMessageConst.MSGID)
    public String msgId;
    @JSONField(name = "msgType")
    public String msgType;
    @JSONField(name = "qos")
    public String qos;
    @JSONField(name = RemoteMessageConst.SEND_TIME)
    public long sendTime;
    @JSONField(name = "statMark")
    public boolean statMark = false;

    public static List<MCMessage> parseMsgJsonToMCMessages(final MCConnectionFlag mCConnectionFlag, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150222076")) {
            return (List) ipChange.ipc$dispatch("150222076", new Object[]{mCConnectionFlag, jSONObject});
        }
        if (jSONObject != null && jSONObject.size() > 0) {
            final Long l = jSONObject.getLong(ALBiometricsKeys.KEY_APP_ID);
            final String string = jSONObject.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            JSONArray jSONArray = jSONObject.getJSONArray("datas");
            if (l != null && !TextUtils.isEmpty(string) && !jSONArray.isEmpty()) {
                return (List) AbstractC8149d.fromIterable(jSONArray).map(new Function<Object, MCMessage>() { // from class: com.youku.live.messagechannel.message.MCMessage.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // io.reactivex.functions.Function
                    public MCMessage apply(Object obj) throws Exception {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "353249716")) {
                            return (MCMessage) ipChange2.ipc$dispatch("353249716", new Object[]{this, obj});
                        }
                        if (obj == null || !(obj instanceof JSONObject)) {
                            return null;
                        }
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string2 = jSONObject2.getString(RemoteMessageConst.MSGID);
                        String string3 = jSONObject2.getString("msgType");
                        byte[] bytes = jSONObject2.getBytes("data");
                        Long l2 = jSONObject2.getLong(RemoteMessageConst.SEND_TIME);
                        String string4 = jSONObject2.getString("qos");
                        Integer integer = jSONObject2.getInteger("expireTime");
                        Boolean bool = jSONObject2.getBoolean("statMark");
                        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || bytes == null || l2 == null) {
                            return null;
                        }
                        MCMessage mCMessage = new MCMessage();
                        mCMessage.connectionSource = MCConnectionFlag.this;
                        mCMessage.appId = l.longValue();
                        mCMessage.channelId = string;
                        mCMessage.msgId = string2;
                        mCMessage.msgType = string3;
                        mCMessage.data = bytes;
                        mCMessage.sendTime = l2.longValue();
                        if (TextUtils.isEmpty(string4)) {
                            string4 = QoS.DISCARD_HIGH.name();
                        }
                        mCMessage.qos = string4;
                        mCMessage.expireTime = integer != null ? integer.intValue() : -1;
                        if (bool != null) {
                            mCMessage.statMark = bool.booleanValue();
                        }
                        return mCMessage;
                    }
                }).filter(new Predicate<MCMessage>() { // from class: com.youku.live.messagechannel.message.MCMessage.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // io.reactivex.functions.Predicate
                    public boolean test(MCMessage mCMessage) throws Exception {
                        IpChange ipChange2 = $ipChange;
                        return AndroidInstantRuntime.support(ipChange2, "-1840901693") ? ((Boolean) ipChange2.ipc$dispatch("-1840901693", new Object[]{this, mCMessage})).booleanValue() : mCMessage != null;
                    }
                }).toList().blockingGet();
            }
        }
        return new ArrayList();
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640845494")) {
            return (String) ipChange.ipc$dispatch("-1640845494", new Object[]{this});
        }
        return "MCMessage{connectionSource=" + this.connectionSource + ", appId=" + this.appId + ", channelId='" + this.channelId + "', msgId='" + this.msgId + "', msgType='" + this.msgType + "', qos='" + this.qos + "', data=" + Arrays.toString(this.data) + ", sendTime=" + this.sendTime + ", expireTime=" + this.expireTime + ", statMark=" + this.statMark + '}';
    }
}
