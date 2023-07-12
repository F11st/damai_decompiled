package com.youku.live.dago.widgetlib.ailpchat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.entity.ConnType;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.messagechannel.callback.IMCChannelEventCallback;
import com.youku.live.messagechannel.callback.IMCDispatchMsgCallback;
import com.youku.live.messagechannel.callback.MCChannelEvent;
import com.youku.live.messagechannel.channel.MCChannel;
import com.youku.live.messagechannel.channel.MCChannelInfo;
import com.youku.live.messagechannel.engine.MCEngine;
import com.youku.live.messagechannel.message.MCMessage;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.pm;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MCChatConnection implements IChatConnection {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG;
    private ICallback connectCallback;
    private Context context;
    private ICallback disconnectCallback;
    private String mAppId;
    private MCChannel mChannel;
    private String mChannelId;
    private MCEngine mEngine;
    private IChatConnection.ConnectionListner mListener;
    private String mTopicId;
    private List<IChatConnection.WeexMessageListener> mWeexListeners;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    class CallbackCode {
        public static final int CHANNEL_NOT_CREATE = 1002;
        public static final int CONNECT_FAIL = 1001;
        public static final int DISCONNECT_FAIL = 2001;

        CallbackCode() {
        }
    }

    public MCChatConnection(ChatRoomConfig chatRoomConfig) {
        Boolean bool;
        String name = getClass().getName();
        this.TAG = name;
        this.mTopicId = "";
        this.mChannelId = "";
        this.mAppId = "";
        if (chatRoomConfig == null) {
            return;
        }
        this.mAppId = chatRoomConfig.appId;
        Map<String, Object> map = chatRoomConfig.ext;
        if (map != null) {
            this.mTopicId = (String) map.get("topic");
            this.mChannelId = (String) chatRoomConfig.ext.get(RemoteMessageConst.Notification.CHANNEL_ID);
            this.context = (Context) chatRoomConfig.ext.get(WPKFactory.INIT_KEY_CONTEXT);
        }
        if (this.mChannelId == null) {
            this.mChannelId = chatRoomConfig.roomId;
        }
        if (TextUtils.isEmpty(this.mChannelId) || TextUtils.isEmpty(this.mAppId) || this.context == null) {
            return;
        }
        this.mEngine = MCEngine.getInstance(Long.valueOf(this.mAppId).longValue());
        JSONObject jSONObject = (JSONObject) chatRoomConfig.ext.get("connectionMode");
        if (jSONObject != null) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(pm.TAG);
            JSONObject jSONObject3 = jSONObject.getJSONObject(ConnType.PK_CDN);
            JSONObject jSONObject4 = jSONObject.getJSONObject("accsMass");
            if (jSONObject2 != null || jSONObject3 != null || jSONObject4 != null) {
                MCChannelInfo mCChannelInfo = new MCChannelInfo();
                mCChannelInfo.appId = Long.valueOf(this.mAppId).longValue();
                mCChannelInfo.channelId = this.mChannelId;
                Long l = (Long) chatRoomConfig.ext.get(ProjectShowBean.SERVER_TIME);
                if (l != null) {
                    mCChannelInfo.serverTime = l.longValue();
                }
                if (jSONObject2 != null) {
                    Integer integer = jSONObject2.getInteger("bizCode");
                    if (integer != null) {
                        mCChannelInfo.PMInfo.bizCode = integer.intValue();
                    }
                    String string = jSONObject2.getString("topic");
                    if (!TextUtils.isEmpty(string)) {
                        mCChannelInfo.PMInfo.topic = string;
                    }
                    Integer integer2 = jSONObject2.getInteger("msgFetchMode");
                    if (integer2 != null) {
                        mCChannelInfo.PMInfo.msgFetchMode = integer2.intValue();
                    }
                    JSONObject jSONObject5 = jSONObject2.getJSONObject("banSub4Native");
                    if (jSONObject5 != null && (bool = jSONObject5.getBoolean("ban")) != null) {
                        mCChannelInfo.PMInfo.isBanConnect = bool.booleanValue();
                    }
                }
                if (jSONObject3 != null) {
                    String string2 = jSONObject3.getString("url");
                    if (!TextUtils.isEmpty(string2)) {
                        mCChannelInfo.CDNInfo.url = string2;
                    }
                    Integer integer3 = jSONObject3.getInteger(Constants.Name.INTERVAL);
                    if (integer3 != null) {
                        mCChannelInfo.CDNInfo.pullInterval = integer3.intValue();
                    }
                }
                if (jSONObject4 != null) {
                    String string3 = jSONObject4.getString("topic");
                    if (!TextUtils.isEmpty(string3)) {
                        mCChannelInfo.MASSInfo.topic = string3;
                    }
                }
                this.mChannel = this.mEngine.createChannel(this.context, mCChannelInfo);
                ((ILog) Dsl.getService(ILog.class)).d(name, "Create channel by channelInfo:" + mCChannelInfo.toString());
            }
        }
        if (this.mChannel == null) {
            this.mChannel = this.mEngine.createChannel(this.context, this.mChannelId);
            ((ILog) Dsl.getService(ILog.class)).d(name, "Create channel by channelId:" + this.mChannelId);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean connect(ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1937001924")) {
            return ((Boolean) ipChange.ipc$dispatch("-1937001924", new Object[]{this, iCallback})).booleanValue();
        }
        String str = this.TAG;
        ((ILog) Dsl.getService(ILog.class)).d(str, "Connection appId:" + this.mAppId + " channelId:" + this.mChannelId);
        this.connectCallback = iCallback;
        MCChannel mCChannel = this.mChannel;
        if (mCChannel != null) {
            mCChannel.open(new IMCChannelEventCallback() { // from class: com.youku.live.dago.widgetlib.ailpchat.MCChatConnection.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.messagechannel.callback.IMCChannelEventCallback
                public void onEvent(MCChannelEvent mCChannelEvent, String str2, Map<String, Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "642116708")) {
                        ipChange2.ipc$dispatch("642116708", new Object[]{this, mCChannelEvent, str2, map});
                        return;
                    }
                    String str3 = MCChatConnection.this.TAG;
                    ((ILog) Dsl.getService(ILog.class)).d(str3, "Connection event callback, message:" + str2);
                    if (mCChannelEvent == MCChannelEvent.OPEN_SUCCESS) {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "Connection success.");
                        CallbackObject callbackObject = new CallbackObject();
                        callbackObject.topicId = MCChatConnection.this.mTopicId;
                        callbackObject.msg = "Connection success.";
                        if (MCChatConnection.this.connectCallback != null) {
                            MCChatConnection.this.connectCallback.onSuccess(callbackObject);
                        }
                    } else if (mCChannelEvent == MCChannelEvent.OPEN_FAIL) {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "Connection fail.");
                        CallbackObject callbackObject2 = new CallbackObject();
                        callbackObject2.topicId = MCChatConnection.this.mTopicId;
                        callbackObject2.msg = "Connection fail.";
                        if (MCChatConnection.this.connectCallback != null) {
                            MCChatConnection.this.connectCallback.onFailure(1001, callbackObject2);
                        }
                    } else if (mCChannelEvent == MCChannelEvent.CLOSE_SUCCESS) {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "Disconnection success.");
                        CallbackObject callbackObject3 = new CallbackObject();
                        callbackObject3.topicId = MCChatConnection.this.mTopicId;
                        callbackObject3.msg = "Disconnection success.";
                        if (MCChatConnection.this.disconnectCallback != null) {
                            MCChatConnection.this.disconnectCallback.onSuccess(callbackObject3);
                        }
                        MCChatConnection.this.mEngine = null;
                        MCChatConnection.this.mChannel = null;
                    } else if (mCChannelEvent == MCChannelEvent.CLOSE_FAIL) {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "Disconnection fail.");
                        CallbackObject callbackObject4 = new CallbackObject();
                        callbackObject4.topicId = MCChatConnection.this.mTopicId;
                        callbackObject4.msg = "Disconnection fail.";
                        if (MCChatConnection.this.disconnectCallback != null) {
                            MCChatConnection.this.disconnectCallback.onFailure(2001, callbackObject4);
                        }
                        MCChatConnection.this.mEngine = null;
                        MCChatConnection.this.mChannel = null;
                    } else if (mCChannelEvent == MCChannelEvent.DEVICE_ONLINE) {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "Device online.");
                    } else if (mCChannelEvent == MCChannelEvent.DEVICE_OFFLINE) {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "Device offline.");
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, str2);
                    }
                }
            }, new IMCDispatchMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailpchat.MCChatConnection.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.messagechannel.callback.IMCDispatchMsgCallback
                public void onDispatch(MCMessage mCMessage) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-793879812")) {
                        ipChange2.ipc$dispatch("-793879812", new Object[]{this, mCMessage});
                    } else if (mCMessage != null) {
                        ChatMessage chatMessage = new ChatMessage();
                        chatMessage.msgType = mCMessage.msgType;
                        chatMessage.roomId = mCMessage.channelId;
                        chatMessage.msgId = mCMessage.msgId;
                        chatMessage.subType = "";
                        chatMessage.topic = MCChatConnection.this.mTopicId;
                        chatMessage.powerMsgId = "";
                        chatMessage.dataDictionary = JSON.parseObject(new String(mCMessage.data));
                        if (MCChatConnection.this.mListener != null) {
                            MCChatConnection.this.mListener.dispatchReceiveMessage(chatMessage);
                            String str2 = MCChatConnection.this.TAG;
                            ((ILog) Dsl.getService(ILog.class)).v(str2, "Dispatch message:" + chatMessage.toString());
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("topicId", MCChatConnection.this.mTopicId);
                        hashMap.put("roomId", mCMessage.channelId);
                        hashMap.put(RemoteMessageConst.MSGID, mCMessage.msgId);
                        hashMap.put("ts", Long.valueOf(mCMessage.sendTime));
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("msgType", (Object) mCMessage.msgType);
                        jSONObject.put("data", (Object) new String(Base64.encode(mCMessage.data, 0)));
                        jSONArray.add(jSONObject);
                        hashMap.put("datas", jSONArray);
                        if (MCChatConnection.this.mWeexListeners == null || ChatRoomManager.weexListenersUpdatedTopics.containsKey(MCChatConnection.this.mTopicId) || ChatRoomManager.weexListenersUpdatedTopics.containsKey(mCMessage.channelId)) {
                            ((ILog) Dsl.getService(ILog.class)).d(MCChatConnection.this.TAG, "WEEX listener is NULL, get FROM list");
                            if (MCChatConnection.this.mListener != null) {
                                MCChatConnection.this.mListener.refreshWeexListener();
                            }
                        }
                        if (MCChatConnection.this.mWeexListeners != null) {
                            for (IChatConnection.WeexMessageListener weexMessageListener : MCChatConnection.this.mWeexListeners) {
                                if (weexMessageListener != null) {
                                    weexMessageListener.onDispatch(hashMap);
                                    String str3 = MCChatConnection.this.TAG;
                                    ((ILog) Dsl.getService(ILog.class)).v(str3, "Dispatch weex message:" + hashMap.toString());
                                    ((ILog) Dsl.getService(ILog.class)).i("liutaoLog", "mConnection:" + hashCode() + " dispatch to weexListener:" + weexMessageListener.hashCode());
                                }
                            }
                        }
                    }
                }
            });
            return true;
        }
        ((ILog) Dsl.getService(ILog.class)).e(this.TAG, "Channel is not ready!");
        return false;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean disconnect(ICallback iCallback) {
        MCChannel mCChannel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137428982")) {
            return ((Boolean) ipChange.ipc$dispatch("137428982", new Object[]{this, iCallback})).booleanValue();
        }
        String str = this.TAG;
        ((ILog) Dsl.getService(ILog.class)).d(str, "Disconnection appId:" + this.mAppId + " channelId:" + this.mChannelId);
        this.disconnectCallback = iCallback;
        MCEngine mCEngine = this.mEngine;
        if (mCEngine != null && (mCChannel = this.mChannel) != null) {
            mCEngine.destroyChannel(mCChannel);
        }
        CallbackObject callbackObject = new CallbackObject();
        callbackObject.topicId = this.mTopicId;
        callbackObject.msg = "Connection success.";
        ICallback iCallback2 = this.disconnectCallback;
        if (iCallback2 != null) {
            iCallback2.onSuccess(callbackObject);
        }
        return true;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765629047")) {
            ipChange.ipc$dispatch("-1765629047", new Object[]{this});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674391208")) {
            ipChange.ipc$dispatch("-1674391208", new Object[]{this});
            return;
        }
        String str = this.TAG;
        ((ILog) Dsl.getService(ILog.class)).d(str, "Release connection appId:" + this.mAppId + " channelId:" + this.mChannelId);
        List<IChatConnection.WeexMessageListener> list = this.mWeexListeners;
        if (list != null) {
            list.clear();
            this.mWeexListeners = null;
        }
        this.mListener = null;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547106402")) {
            ipChange.ipc$dispatch("-1547106402", new Object[]{this});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean sendMessage(Map<String, Object> map, IChatConnection.SendMessageCallback sendMessageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926480581")) {
            return ((Boolean) ipChange.ipc$dispatch("-1926480581", new Object[]{this, map, sendMessageCallback})).booleanValue();
        }
        return false;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void setConnectionListener(IChatConnection.ConnectionListner connectionListner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2132838242")) {
            ipChange.ipc$dispatch("2132838242", new Object[]{this, connectionListner});
        } else {
            this.mListener = connectionListner;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void setWeexMessageListener(List<IChatConnection.WeexMessageListener> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628421372")) {
            ipChange.ipc$dispatch("-1628421372", new Object[]{this, list});
        } else {
            this.mWeexListeners = list;
        }
    }
}
