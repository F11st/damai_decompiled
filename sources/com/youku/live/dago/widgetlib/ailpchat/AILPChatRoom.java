package com.youku.live.dago.widgetlib.ailpchat;

import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.dago.widgetlib.ailpbaselib.config.Configuration;
import com.youku.live.dago.widgetlib.ailpbaselib.net.NetworkProxy;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.AILPMtopListener;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AnalyticsUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;
import tb.jn1;
import tb.pm;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatRoom extends ChatRoom {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String API_ROOMINFO_VERSION = "1.0";
    private static ScheduledThreadPoolExecutor mcConnectExecutor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), new AILPChatThreadFactory("mcConnect"));
    private ScheduledFuture mcConnectFuture;
    private final String TAG = getClass().getName();
    private ChatRoomMtopListener mListener = new ChatRoomMtopListener();
    private final String ORANGE_GROUP_YKLIVE = "YKLive";
    private final String ORANGE_KEY_ISOPENMC = "isOpenMC";
    private final String ORANGE_KEY_ISOPENMC_DEFAULT_VALUE = "0";
    private final String ORANGE_KEY_MCWHITELIST = "mcWhiteList";
    private final String ORANGE_KEY_MCWHITELIST_DEFAULT_VALUE = "";
    private final int RETRY_TIME = 3;
    private int mRetryTime = 0;
    private boolean isBanConnect = false;
    private String mTopicId = "";
    private int mcConnectRetryTimes = 0;
    private final String PM_PROTOCOL = pm.TAG;
    private final String WS_PROTOCOL = "ws";
    private final String API_ROOMINFO = "mtop.youku.live.chatroom.info.get";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class ChatRoomMtopListener extends AILPMtopListener {
        private static transient /* synthetic */ IpChange $ipChange;

        public ChatRoomMtopListener() {
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onError(int i, MtopResponse mtopResponse, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1960287242")) {
                ipChange.ipc$dispatch("1960287242", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                return;
            }
            AnalyticsUtils.callbackFail(AnalyticsConstants.SPM_CHATROOM_INFO, mtopResponse != null ? mtopResponse.getRetMsg() : "");
            AILPChatRoom.this.retryRequest();
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteListener
        public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            JSONObject dataJsonObject;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "672118637")) {
                ipChange.ipc$dispatch("672118637", new Object[]{this, Integer.valueOf(i), mtopResponse, baseOutDo, obj});
                return;
            }
            AnalyticsUtils.callbackSuccess(AnalyticsConstants.SPM_CHATROOM_INFO);
            if (mtopResponse == null || !"mtop.youku.live.chatroom.info.get".equals(mtopResponse.getApi()) || (dataJsonObject = mtopResponse.getDataJsonObject()) == null) {
                return;
            }
            String optString = dataJsonObject.optString("protocol");
            JSONObject optJSONObject = dataJsonObject.optJSONObject("ext");
            HashMap hashMap = new HashMap();
            if (optJSONObject != null) {
                hashMap.put("topic", (String) optJSONObject.opt("topic"));
                hashMap.put("token", optJSONObject.opt("token"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("banSub4Native");
                if (optJSONObject2 != null) {
                    hashMap.put("ban", Boolean.valueOf(optJSONObject2.optBoolean("ban")));
                }
            }
            AILPChatRoom.this.fetchProtocol(optString, hashMap);
        }

        @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
        public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "222426587")) {
                ipChange.ipc$dispatch("222426587", new Object[]{this, Integer.valueOf(i), mtopResponse, obj});
                return;
            }
            AnalyticsUtils.callbackFail(AnalyticsConstants.SPM_CHATROOM_INFO, mtopResponse != null ? mtopResponse.getRetMsg() : "");
            AILPChatRoom.this.retryRequest();
        }
    }

    public AILPChatRoom() {
        setConnectionListener(this);
    }

    static /* synthetic */ int access$204(AILPChatRoom aILPChatRoom) {
        int i = aILPChatRoom.mcConnectRetryTimes + 1;
        aILPChatRoom.mcConnectRetryTimes = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchProtocol(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667822175")) {
            ipChange.ipc$dispatch("-667822175", new Object[]{this, str, map});
            return;
        }
        if (TextUtils.isEmpty(this.mChatRoomConfig.protocol)) {
            ChatRoomConfig chatRoomConfig = this.mChatRoomConfig;
            chatRoomConfig.protocol = str;
            chatRoomConfig.ext = map;
        }
        if (this.mConnection == null) {
            this.mConnection = new PMChatConnection();
        }
        this.mConnection.setConnectionListener(this);
        ((PMChatConnection) this.mConnection).setBizCode(ChatRoomManager.sBizCode);
        if (map != null && map.get("topic") != null) {
            String str2 = (String) map.get("topic");
            this.mTopicId = str2;
            ((PMChatConnection) this.mConnection).setTopicId(str2);
        }
        if (!TextUtils.isEmpty(this.mChatRoomConfig.mtopKey)) {
            ((PMChatConnection) this.mConnection).setMtopKey(this.mChatRoomConfig.mtopKey);
        }
        if (this.isBanConnect) {
            HashMap hashMap = new HashMap();
            hashMap.put("ban", "1");
            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("ailp-chat", 19999, "subscribe", "", "", hashMap);
            return;
        }
        this.sConnectionCount++;
        ((ILog) Dsl.getService(ILog.class)).d("ChatConnection", "fetch protocol sConnectionCount = " + this.sConnectionCount);
        this.mConnection.connect(null);
    }

    private void getConfigFromServer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1859784593")) {
            ipChange.ipc$dispatch("1859784593", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.mChatRoomConfig.appId)) {
                hashMap.put(ALBiometricsKeys.KEY_APP_ID, this.mChatRoomConfig.appId);
            } else {
                hashMap.put(ALBiometricsKeys.KEY_APP_ID, Configuration.getConfig(this.mChatRoomConfig.roomId).getAppId());
            }
            hashMap.put("roomId", str);
            NetworkProxy.request("mtop.youku.live.chatroom.info.get", "1.0", hashMap, true, this.mListener);
        }
    }

    private void parseConfig(final ChatRoomConfig chatRoomConfig) {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "862295731")) {
            ipChange.ipc$dispatch("862295731", new Object[]{this, chatRoomConfig});
        } else if (chatRoomConfig != null) {
            if (TextUtils.isEmpty(chatRoomConfig.sessionId)) {
                chatRoomConfig.sessionId = "";
            }
            this.mUniqueKey = chatRoomConfig.roomId + chatRoomConfig.sessionId;
            this.mChatRoomConfig = chatRoomConfig;
            String config = OrangeConfig.getInstance().getConfig("YKLive", "isOpenMC", "0");
            String config2 = OrangeConfig.getInstance().getConfig("YKLive", "mcWhiteList", "");
            HashSet hashSet = new HashSet(16);
            if (!TextUtils.isEmpty(config2) && (split = config2.split(",")) != null && split.length > 0) {
                for (String str : split) {
                    String trim = str.trim();
                    if (!TextUtils.isEmpty(trim)) {
                        hashSet.add(trim);
                    }
                }
            }
            if ("1".equals(config) && (hashSet.contains(chatRoomConfig.roomId) || jn1.MUL.equals(config2))) {
                Map<String, Object> map = chatRoomConfig.ext;
                if (map != null && map.get("topic") != null) {
                    this.mTopicId = (String) chatRoomConfig.ext.get("topic");
                }
                this.mcConnectFuture = mcConnectExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailpchat.AILPChatRoom.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1439958644")) {
                            ipChange2.ipc$dispatch("1439958644", new Object[]{this});
                            return;
                        }
                        AILPChatRoom.this.mConnection = new MCChatConnection(chatRoomConfig);
                        AILPChatRoom.this.mConnection.setConnectionListener(this);
                        AILPChatRoom.this.mConnection.connect(new ICallback() { // from class: com.youku.live.dago.widgetlib.ailpchat.AILPChatRoom.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // com.youku.live.dago.widgetlib.ailpchat.ICallback
                            public void onFailure(int i, CallbackObject callbackObject) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-1585713633")) {
                                    ipChange3.ipc$dispatch("-1585713633", new Object[]{this, Integer.valueOf(i), callbackObject});
                                    return;
                                }
                                IChatConnection iChatConnection = AILPChatRoom.this.mConnection;
                                if (iChatConnection != null) {
                                    iChatConnection.disconnect(null);
                                    AILPChatRoom.this.mConnection.release();
                                }
                                String str2 = AILPChatRoom.this.TAG;
                                ((ILog) Dsl.getService(ILog.class)).w(str2, "MCConnection connect fail " + AILPChatRoom.access$204(AILPChatRoom.this) + " times.");
                                if (AILPChatRoom.this.mcConnectRetryTimes <= 10 || AILPChatRoom.this.mcConnectFuture == null) {
                                    return;
                                }
                                AILPChatRoom.this.mcConnectFuture.cancel(true);
                                ((ILog) Dsl.getService(ILog.class)).w(AILPChatRoom.this.TAG, "MCConnection reConnect task stop.");
                            }

                            @Override // com.youku.live.dago.widgetlib.ailpchat.ICallback
                            public void onSuccess(CallbackObject callbackObject) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-627095411")) {
                                    ipChange3.ipc$dispatch("-627095411", new Object[]{this, callbackObject});
                                } else if (AILPChatRoom.this.mcConnectFuture != null) {
                                    AILPChatRoom.this.mcConnectFuture.cancel(true);
                                    ((ILog) Dsl.getService(ILog.class)).d(AILPChatRoom.this.TAG, "MCConnection connect success, reConnect task stop.");
                                }
                            }
                        });
                    }
                }, 500L, 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            Map<String, Object> map2 = chatRoomConfig.ext;
            if (map2 != null) {
                String valueOf = map2.get("topic") == null ? null : String.valueOf(chatRoomConfig.ext.get("topic"));
                String valueOf2 = chatRoomConfig.ext.get("ban") != null ? String.valueOf(chatRoomConfig.ext.get("ban")) : null;
                if (!TextUtils.isEmpty(valueOf2)) {
                    this.isBanConnect = Boolean.parseBoolean(valueOf2);
                }
                if (!TextUtils.isEmpty(valueOf)) {
                    fetchProtocol(chatRoomConfig.protocol, chatRoomConfig.ext);
                    return;
                } else {
                    getConfigFromServer(chatRoomConfig.roomId);
                    return;
                }
            }
            getConfigFromServer(chatRoomConfig.roomId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227534615")) {
            ipChange.ipc$dispatch("227534615", new Object[]{this});
            return;
        }
        int i = this.mRetryTime;
        this.mRetryTime = i + 1;
        if (i < 3) {
            getConfigFromServer(this.mChatRoomConfig.roomId);
        }
    }

    public Object getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1216838480") ? ipChange.ipc$dispatch("1216838480", new Object[]{this}) : this;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.ChatRoom
    public boolean leave() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613174713")) {
            return ((Boolean) ipChange.ipc$dispatch("613174713", new Object[]{this})).booleanValue();
        }
        this.mRetryTime = 0;
        return super.leave();
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.ChatRoom
    public void onResume() {
        IChatConnection iChatConnection;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314226514")) {
            ipChange.ipc$dispatch("1314226514", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isBanConnect || (iChatConnection = this.mConnection) == null) {
            return;
        }
        iChatConnection.resume();
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection.ConnectionListner
    public void refreshWeexListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1079719740")) {
            ipChange.ipc$dispatch("1079719740", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (ChatRoomManager.mChatRoomWeexListeners.get(this.mTopicId) != null) {
            arrayList.addAll(ChatRoomManager.mChatRoomWeexListeners.get(this.mTopicId));
            String str = this.TAG;
            ((ILog) Dsl.getService(ILog.class)).d(str, "Add weexListeners by topic: " + this.mTopicId);
        }
        if (ChatRoomManager.mRoomIdWeexListeners.get(this.mChatRoomConfig.roomId) != null) {
            arrayList.addAll(ChatRoomManager.mRoomIdWeexListeners.get(this.mChatRoomConfig.roomId));
            String str2 = this.TAG;
            ((ILog) Dsl.getService(ILog.class)).d(str2, "Add weexListeners by roomId: " + this.mChatRoomConfig.roomId);
        }
        if (arrayList.size() == 0) {
            arrayList = null;
            ((ILog) Dsl.getService(ILog.class)).d(this.TAG, "Add 0 weexListeners.");
        }
        setWeexListener(arrayList);
        ChatRoomManager.weexListenersUpdatedTopics.remove(this.mTopicId);
        ChatRoomManager.weexListenersUpdatedTopics.remove(this.mChatRoomConfig.roomId);
    }

    public void setRoomConfig(ChatRoomConfig chatRoomConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937718813")) {
            ipChange.ipc$dispatch("1937718813", new Object[]{this, chatRoomConfig});
        } else {
            parseConfig(chatRoomConfig);
        }
    }

    public AILPChatRoom(ChatRoomConfig chatRoomConfig) {
        parseConfig(chatRoomConfig);
        setConnectionListener(this);
    }
}
