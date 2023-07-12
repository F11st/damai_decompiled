package com.youku.live.dago.widgetlib.ailproom;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.config.Configuration;
import com.youku.live.dago.widgetlib.ailpchat.AILPChatRoom;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoom;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoomConfig;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoomManager;
import com.youku.live.dago.widgetlib.ailpchat.MessageDelegate;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.ailproom.callback.ResultCallback;
import com.youku.live.dago.widgetlib.ailproom.config.ChatRoomConfiguration;
import com.youku.live.dago.widgetlib.ailproom.config.ILRoomConfiguration;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ILRoom extends AbsILRoom {
    private static transient /* synthetic */ IpChange $ipChange;
    private LiveManager.LiveChangeListener mLiveListener;

    public ILRoom(String str, String str2) {
        this.roomId = str;
        this.sessionId = str2;
        this.uniqueKey = str + str2;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void addMessageListener(MessageDelegate messageDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437373669")) {
            ipChange.ipc$dispatch("437373669", new Object[]{this, messageDelegate});
        } else {
            this.chatRoom.addMessageDelegate(messageDelegate);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void createRoom(ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629547333")) {
            ipChange.ipc$dispatch("629547333", new Object[]{this, resultCallback});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void joinRoom(ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback) {
        JSONObject parseObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933236580")) {
            ipChange.ipc$dispatch("1933236580", new Object[]{this, iLRoomConfiguration, resultCallback});
        } else if (iLRoomConfiguration == null || iLRoomConfiguration.liveConfiguration == null) {
        } else {
            if (TextUtils.isEmpty(iLRoomConfiguration.mtopAppKey)) {
                Log.e("ILRoom", "join failed, mtopAppKey is null!");
                resultCallback.onFailure();
            }
            this.configuration = iLRoomConfiguration;
            this.roomId = iLRoomConfiguration.roomId;
            ChatRoomConfig chatRoomConfig = new ChatRoomConfig();
            chatRoomConfig.roomId = this.roomId;
            chatRoomConfig.sessionId = this.sessionId;
            ILRoomConfiguration iLRoomConfiguration2 = this.configuration;
            ChatRoomConfiguration chatRoomConfiguration = iLRoomConfiguration2.chatRoomConfiguration;
            chatRoomConfig.protocol = chatRoomConfiguration.protocol;
            Map<String, Object> map = chatRoomConfiguration.ext;
            chatRoomConfig.ext = map;
            chatRoomConfig.mtopKey = iLRoomConfiguration2.mtopAppKey;
            if (map != null) {
                String valueOf = map.get("info") != null ? String.valueOf(chatRoomConfig.ext.get("info")) : null;
                if (!TextUtils.isEmpty(valueOf) && (parseObject = JSON.parseObject(valueOf)) != null) {
                    chatRoomConfig.appId = parseObject.getString(ALBiometricsKeys.KEY_APP_ID);
                }
            }
            Log.i("fornia", "mtop 通道api 请求 roomId" + this.roomId);
            this.chatRoom = new AILPChatRoom(chatRoomConfig);
            this.liveManager = new LiveManager.Builder().addListener(this.mLiveListener).liveId(this.roomId).uniqueKey(this.uniqueKey).chatRoom(this.chatRoom).build();
            Log.i("fornia", "mtop 进入房间 播放信息api 请求 roomId:" + this.roomId);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void linkRoom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966046897")) {
            ipChange.ipc$dispatch("-966046897", new Object[]{this, str});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void quitRoom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319808304")) {
            ipChange.ipc$dispatch("-319808304", new Object[]{this});
            return;
        }
        ChatRoom chatRoom = this.chatRoom;
        if (chatRoom != null && chatRoom.getConnection() != null) {
            this.chatRoom.leave();
        }
        try {
            LiveManager liveManager = this.liveManager;
            if (liveManager != null) {
                liveManager.leave();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Configuration.removeConfig(this.roomId);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void quitRoomNative() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253748985")) {
            ipChange.ipc$dispatch("1253748985", new Object[]{this});
            return;
        }
        try {
            if (ChatRoomManager.hasLiveId(this.uniqueKey)) {
                ChatRoomManager.removeChatRoomByLiveId(this.roomId, this.sessionId);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            LiveManager liveManager = this.liveManager;
            if (liveManager != null) {
                liveManager.leave();
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        Configuration.removeConfig(this.roomId);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void sendMessage(Map<String, Object> map, final ResultCallback resultCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "745467958")) {
            ipChange.ipc$dispatch("745467958", new Object[]{this, map, resultCallback});
        } else {
            this.chatRoom.sendMessage(map, new ChatRoom.SendMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailproom.ILRoom.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpchat.ChatRoom.SendMsgCallback
                public void onSendFail(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-433247935")) {
                        ipChange2.ipc$dispatch("-433247935", new Object[]{this, Integer.valueOf(i)});
                    } else {
                        resultCallback.onFailure();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpchat.ChatRoom.SendMsgCallback
                public void onSendSuccess(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1288642972")) {
                        ipChange2.ipc$dispatch("1288642972", new Object[]{this, Integer.valueOf(i)});
                    } else {
                        resultCallback.onSuccess();
                    }
                }
            });
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void setImListener(LiveManager.LiveChangeListener liveChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1194226262")) {
            ipChange.ipc$dispatch("-1194226262", new Object[]{this, liveChangeListener});
        } else {
            this.mLiveListener = liveChangeListener;
        }
    }

    public void setLiveListener(LiveManager.LiveChangeListener liveChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546047922")) {
            ipChange.ipc$dispatch("1546047922", new Object[]{this, liveChangeListener});
        } else {
            this.mLiveListener = liveChangeListener;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void switchRoom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242561515")) {
            ipChange.ipc$dispatch("-1242561515", new Object[]{this, str});
            return;
        }
        quitRoom();
        ILRoomConfiguration iLRoomConfiguration = new ILRoomConfiguration();
        iLRoomConfiguration.roomId = str;
        joinRoom(iLRoomConfiguration, null);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.AbsILRoom
    public void joinRoom(ILRoomConfiguration iLRoomConfiguration) {
        JSONObject parseObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717397090")) {
            ipChange.ipc$dispatch("717397090", new Object[]{this, iLRoomConfiguration});
        } else if (iLRoomConfiguration == null || iLRoomConfiguration.liveConfiguration == null) {
        } else {
            if (TextUtils.isEmpty(iLRoomConfiguration.mtopAppKey)) {
                Log.e("ILRoom", "join failed, mtopAppKey is null!");
            }
            this.configuration = iLRoomConfiguration;
            this.roomId = iLRoomConfiguration.roomId;
            ChatRoomConfig chatRoomConfig = new ChatRoomConfig();
            chatRoomConfig.roomId = this.roomId;
            chatRoomConfig.sessionId = this.sessionId;
            ILRoomConfiguration iLRoomConfiguration2 = this.configuration;
            ChatRoomConfiguration chatRoomConfiguration = iLRoomConfiguration2.chatRoomConfiguration;
            chatRoomConfig.protocol = chatRoomConfiguration.protocol;
            Map<String, Object> map = chatRoomConfiguration.ext;
            chatRoomConfig.ext = map;
            chatRoomConfig.appId = iLRoomConfiguration2.mtopAppKey;
            if (map != null) {
                String valueOf = map.get("info") != null ? String.valueOf(chatRoomConfig.ext.get("info")) : null;
                if (!TextUtils.isEmpty(valueOf) && (parseObject = JSON.parseObject(valueOf)) != null) {
                    chatRoomConfig.appId = parseObject.getString(ALBiometricsKeys.KEY_APP_ID);
                }
            }
            Log.i("fornia", "mtop 通道api 请求 roomId" + this.roomId);
            if (ChatRoomManager.hasChatRoom(this.uniqueKey, "native")) {
                this.chatRoom = ChatRoomManager.getChatRoomByName(this.roomId, this.sessionId, "native");
            } else {
                this.chatRoom = ChatRoomManager.createChatRoomByName(this.roomId, this.sessionId, "native", chatRoomConfig);
            }
            this.liveManager = new LiveManager.Builder().liveId(this.roomId).addListener(this.mLiveListener).uniqueKey(this.uniqueKey).chatRoom(this.chatRoom).build();
            Log.i("fornia", "mtop 进入房间 播放信息api 请求 roomId:" + this.roomId);
        }
    }
}
