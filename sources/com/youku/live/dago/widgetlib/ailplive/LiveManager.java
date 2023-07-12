package com.youku.live.dago.widgetlib.ailplive;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.config.Configuration;
import com.youku.live.dago.widgetlib.ailpchat.ChatMessage;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoom;
import com.youku.live.dago.widgetlib.ailpchat.ChatRoomManager;
import com.youku.live.dago.widgetlib.ailpchat.MessageDelegate;
import com.youku.live.dago.widgetlib.ailpchat.MessageListener;
import com.youku.live.dago.widgetlib.ailplive.bean.LiveInfo;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private ChatRoom chatRoom;
    private String default_quanlity;
    private String default_streamFormat;
    private String mBizData;
    private String mExt;
    private MessageDelegate mIMDelegate;
    private String mLiveId;
    private LiveInfo mLiveInfo;
    private LiveChangeListener mLiveListener;
    private String mMicNO;
    private String mSig;
    private String uniqueKey;
    public static final String LIVE_STATE_CHANGE = "live_state_change";
    public static final String LIVE_PLAY_REFRESH = "live_play_refresh";
    public static final String LIVE_MIC_STREAM_STATE_CHANGE = "live_mic_stream_state_change";
    public static final String LIVE_MIC_CHANGE = "live_mic_change";
    public static final String LIVE_DOWN_DRM = "live_down_drm";
    public static final String LIVE_SCENE_PLAYTYPE_CHANGE = "scene_playtype_change";
    public static final String LIVE_CLARITY_DOWNGRADING = "live_clarity_downgrading";
    public static final String LIVE_CLARITY_UPGRADING = "live_clarity_upgrading";
    public static final String LIVE_LIMIT_PLAY = "live_limit_play";
    public static final String[] names = {LIVE_STATE_CHANGE, LIVE_PLAY_REFRESH, LIVE_MIC_STREAM_STATE_CHANGE, LIVE_MIC_CHANGE, LIVE_DOWN_DRM, LIVE_SCENE_PLAYTYPE_CHANGE, LIVE_CLARITY_DOWNGRADING, LIVE_CLARITY_UPGRADING, LIVE_LIMIT_PLAY};

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Builder {
        private LiveManager liveManager = new LiveManager();

        public Builder addListener(LiveChangeListener liveChangeListener) {
            this.liveManager.mLiveListener = liveChangeListener;
            return this;
        }

        public LiveManager build() {
            return this.liveManager;
        }

        public Builder chatRoom(ChatRoom chatRoom) {
            if (chatRoom == null) {
                Log.e(LiveManager.class.getSimpleName(), "the chatRoom is null object,will not receive any notification！");
            } else {
                LiveManager liveManager = this.liveManager;
                if (liveManager != null && liveManager.uniqueKey != null) {
                    if (ChatRoomManager.mChatRoomMessageDelegates.get(this.liveManager.uniqueKey) == null) {
                        ChatRoomManager.mChatRoomMessageDelegates.put(this.liveManager.uniqueKey, new ArrayList());
                    }
                    if (ChatRoomManager.mChatRoomMessageDelegates.get(this.liveManager.uniqueKey) != null) {
                        ChatRoomManager.mChatRoomMessageDelegates.get(this.liveManager.uniqueKey).add(this.liveManager.mIMDelegate);
                    }
                }
                LiveManager liveManager2 = this.liveManager;
                if (liveManager2 != null) {
                    chatRoom.addMessageDelegate(liveManager2.mIMDelegate);
                    this.liveManager.chatRoom = chatRoom;
                }
            }
            return this;
        }

        public Builder defaultFormat(@StreamConfig.Format String str) {
            this.liveManager.default_streamFormat = str;
            return this;
        }

        public Builder defaultQuantity(@StreamConfig.Qulity String str) {
            this.liveManager.default_quanlity = str;
            return this;
        }

        public Builder liveId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.liveManager.mLiveId = str;
                return this;
            }
            throw new IllegalArgumentException("liveId should not be null!");
        }

        public Builder uniqueKey(String str) {
            this.liveManager.uniqueKey = str;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface LiveChangeListener {
        void onIMChange(JSONObject jSONObject, String str, String str2);

        void onLiveInfoChange(LiveInfo liveInfo, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class StreamConfig {
        public static final String FORMAT_FLV = "flv";
        public static final String FORMAT_HLS = "hls";
        public static final String FORMAT_RTMP = "rtmp";
        private static final String MTOP_YOUKU_LIVEPLATFORM_ROOM_PLAY_INFO_GET = "mtop.youku.liveplatform.playInfo.get";
        public static final String QTY_1080P = "1080p";
        public static final String QTY_360P = "360p";
        public static final String QTY_480P = "480p";
        public static final String QTY_720P = "720p";

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public @interface Format {
        }

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public @interface Qulity {
        }
    }

    private void updateLiveInfo(LiveInfo liveInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097159415")) {
            ipChange.ipc$dispatch("-2097159415", new Object[]{this, liveInfo});
        } else if (liveInfo == null) {
        } else {
            if (this.mLiveInfo == null) {
                this.mLiveInfo = liveInfo;
                LiveChangeListener liveChangeListener = this.mLiveListener;
                if (liveChangeListener != null) {
                    try {
                        liveChangeListener.onLiveInfoChange((LiveInfo) liveInfo.clone(), this.mLiveId);
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }
            } else if (this.mLiveId.equals(liveInfo.liveId)) {
                this.mLiveInfo = liveInfo;
                LiveChangeListener liveChangeListener2 = this.mLiveListener;
                if (liveChangeListener2 != null) {
                    try {
                        liveChangeListener2.onLiveInfoChange((LiveInfo) liveInfo.clone(), this.mLiveId);
                    } catch (CloneNotSupportedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void enter(String str, @StreamConfig.Qulity String str2, @StreamConfig.Format String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944037734")) {
            ipChange.ipc$dispatch("944037734", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        this.mBizData = str4;
        this.mSig = str5;
        this.default_quanlity = str2;
        this.default_streamFormat = str3;
        this.mExt = str6;
        this.mMicNO = str;
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(this.mSig)) {
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("fornia", "weex enter micNo:" + str + "quantity:" + str2 + "streamFormat:" + str3 + "bizData:" + str4 + "sign:" + str5 + "liveid:" + this.mLiveId);
        if (!TextUtils.isEmpty(this.mLiveId)) {
            HashMap hashMap = new HashMap(16);
            hashMap.put("roomId", this.mLiveId);
            hashMap.put("micNo", str);
            hashMap.put("streamFormat", str3);
            hashMap.put("quantity", str2);
            hashMap.put("bizData", this.mBizData);
            hashMap.put("sign", this.mSig);
            if (Configuration.getConfig(this.mLiveId) != null) {
                hashMap.put(ALBiometricsKeys.KEY_APP_ID, Configuration.getConfig(this.mLiveId).getAppId());
                hashMap.put("licence", Configuration.getConfig(this.mLiveId).getLicence());
            }
            hashMap.put("ext", this.mExt);
            return;
        }
        throw new IllegalArgumentException("liveId should not be null!");
    }

    public void leave() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "464768235")) {
            ipChange.ipc$dispatch("464768235", new Object[]{this});
            return;
        }
        this.mLiveListener = null;
        if (this.mLiveId == null || ChatRoomManager.mChatRoomMessageDelegates.get(this.uniqueKey) == null) {
            return;
        }
        ChatRoomManager.mChatRoomMessageDelegates.remove(this.uniqueKey);
    }

    public void switchMic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344881977")) {
            ipChange.ipc$dispatch("1344881977", new Object[]{this, str});
        } else {
            enter(str);
        }
    }

    private LiveManager() {
        this.default_quanlity = StreamConfig.QTY_480P;
        this.default_streamFormat = StreamConfig.FORMAT_FLV;
        this.mExt = "";
        this.mIMDelegate = new MessageListener(Arrays.asList(names)) { // from class: com.youku.live.dago.widgetlib.ailplive.LiveManager.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.youku.live.dago.widgetlib.ailpchat.MessageListener, com.youku.live.dago.widgetlib.ailpchat.MessageDelegate
            public void dispatchReceiveMessage(ChatMessage chatMessage) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1078971879")) {
                    ipChange.ipc$dispatch("-1078971879", new Object[]{this, chatMessage});
                    return;
                }
                try {
                    JSONObject jSONObject = chatMessage.dataDictionary;
                    if (jSONObject == null || !LiveManager.this.mLiveId.equals(chatMessage.roomId) || LiveManager.this.mLiveListener == null) {
                        return;
                    }
                    LiveManager.this.mLiveListener.onIMChange(jSONObject, LiveManager.this.mLiveId, chatMessage.msgType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void enter(String str, @StreamConfig.Qulity String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211059394")) {
            ipChange.ipc$dispatch("-211059394", new Object[]{this, str, str2});
        } else {
            enter(str, str2, this.default_streamFormat, this.mBizData, this.mSig, this.mExt);
        }
    }

    public void enter(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43775884")) {
            ipChange.ipc$dispatch("-43775884", new Object[]{this, str});
        } else {
            enter(str, this.default_quanlity, this.default_streamFormat, this.mBizData, this.mSig, this.mExt);
        }
    }

    public void enter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076237610")) {
            ipChange.ipc$dispatch("1076237610", new Object[]{this});
        } else {
            enter("1", this.default_quanlity, this.default_streamFormat, this.mBizData, this.mSig, this.mExt);
        }
    }
}
