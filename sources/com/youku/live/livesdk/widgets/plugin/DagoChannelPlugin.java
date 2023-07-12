package com.youku.live.livesdk.widgets.plugin;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.live.arch.Arch;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.dsl.plugins.IDagoChannelInterruptInterface;
import com.youku.live.livesdk.constants.DagoDataCenterConstants;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.monitor.AbsYoukuLiveAlarm;
import com.youku.live.livesdk.monitor.MessageChannelAlarm;
import com.youku.live.livesdk.widgets.model.LaifengRoomInfoData;
import com.youku.live.livesdk.widgets.plugin.channel.ChannelListenersMananger;
import com.youku.live.messagechannel.callback.IMCChannelEventCallback;
import com.youku.live.messagechannel.callback.IMCDispatchMsgCallback;
import com.youku.live.messagechannel.callback.MCChannelEvent;
import com.youku.live.messagechannel.channel.MCChannel;
import com.youku.live.messagechannel.connection.MCConnectionFlag;
import com.youku.live.messagechannel.engine.MCEngine;
import com.youku.live.messagechannel.message.MCMessage;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.widgets.impl.BasePlugin;
import com.youku.live.widgets.protocol.ICall;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPluginData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoChannelPlugin extends BasePlugin implements ICall, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LF_ROOM_INFO_V2_API = "mtop.youku.laifeng.ilm.getLfRoomInfoV2";
    private static final String METHOD_ADD_LISTENER = "addListener";
    private static final String METHOD_REMOVE_LISTENER = "removeListener";
    private static final String MSG_TYPE_ALL = "*";
    public static final String NAME_SCREEN_STAT_INFO = "ScreenStatInfo";
    private static final String PARAM_MSG_TYPE = "msgType";
    private static final String PARAM_RECEIVER = "receiver";
    public static final String PATRONSAINT = "PatronSaint";
    public static final String PK_INIT = "battle";
    private static final String TAG = "DagoChannelPlugin";
    private AbsYoukuLiveAlarm alarm;
    private String mAppId;
    private ChannelListenersMananger mChannelListenersMananger;
    private LaifengRoomInfoData mCurrentLaifengRoomInfoData;
    private LiveFullInfoData mCurrentLiveFullInfoData;
    private String mEndPointType;
    private LaifengRoomInfoData mLaifengRoomInfoData;
    private List<Receiver> mListeners;
    private LiveFullInfoData mLiveFullInfoData;
    private String mLiveId;
    private MCChannel mMCChannel;
    private String mPageInstanceId;
    private String mRoomId;
    private String mToken;
    private AtomicInteger sidCounter;
    private boolean mHashToken = false;
    private boolean mStateActive = false;
    private boolean mMcOpened = false;
    private boolean mHasAppeared = false;
    private boolean mIsLaifeng = false;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Receiver {
        void onMessage(Message message);
    }

    public DagoChannelPlugin() {
        AdapterForTLog.loge(TAG, "mcConstructor:" + this + "," + this.mAppId + AVFSCacheConstants.COMMA_SEP + this.mRoomId + AVFSCacheConstants.COMMA_SEP + this.mToken + ";");
    }

    private void checkIsLaifeng() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1087357560")) {
            ipChange.ipc$dispatch("-1087357560", new Object[]{this});
        } else {
            this.mIsLaifeng = getEngineInstance().findPluginByName("LaifengRoomInfo") != null;
        }
    }

    private void dispatchChannelStatus(final String str) {
        final IEngineInstance engineInstance;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070592279")) {
            ipChange.ipc$dispatch("2070592279", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str) || (engineInstance = getEngineInstance()) == null) {
        } else {
            engineInstance.runOnMainThread(new Runnable() { // from class: com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1840873522")) {
                        ipChange2.ipc$dispatch("-1840873522", new Object[]{this});
                    } else {
                        engineInstance.putData("dagoChannelStatusChanged", str);
                    }
                }
            });
        }
    }

    private AbsYoukuLiveAlarm getAlarm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685416053")) {
            return (AbsYoukuLiveAlarm) ipChange.ipc$dispatch("1685416053", new Object[]{this});
        }
        if (this.alarm == null) {
            synchronized (this) {
                if (this.alarm == null) {
                    this.alarm = new MessageChannelAlarm();
                }
            }
        }
        return this.alarm;
    }

    private ChannelListenersMananger getChannelListenersMananger() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186676635")) {
            return (ChannelListenersMananger) ipChange.ipc$dispatch("186676635", new Object[]{this});
        }
        if (this.mChannelListenersMananger == null) {
            synchronized (this) {
                if (this.mChannelListenersMananger == null) {
                    this.mChannelListenersMananger = new ChannelListenersMananger();
                }
            }
        }
        return this.mChannelListenersMananger;
    }

    private List<Receiver> getListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579691858")) {
            return (List) ipChange.ipc$dispatch("-1579691858", new Object[]{this});
        }
        if (this.mListeners == null) {
            synchronized (this) {
                if (this.mListeners == null) {
                    this.mListeners = new ArrayList();
                }
            }
        }
        return this.mListeners;
    }

    private int getSid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634397629")) {
            return ((Integer) ipChange.ipc$dispatch("1634397629", new Object[]{this})).intValue();
        }
        if (this.sidCounter == null) {
            synchronized (this) {
                if (this.sidCounter == null) {
                    this.sidCounter = new AtomicInteger();
                }
            }
        }
        return this.sidCounter.incrementAndGet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
        if (r6.liveId != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initWithLiveFullInfo(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData r6, com.youku.live.livesdk.widgets.model.LaifengRoomInfoData r7, boolean r8) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.$ipChange
            java.lang.String r1 = "-2074714473"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L21
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r5
            r2[r4] = r6
            r6 = 2
            r2[r6] = r7
            r6 = 3
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)
            r2[r6] = r7
            r0.ipc$dispatch(r1, r2)
            return
        L21:
            r0 = 0
            if (r7 == 0) goto L36
            com.youku.live.livesdk.widgets.model.LaifengRoomInfoData$IMData r1 = r7.im
            if (r1 == 0) goto L36
            java.lang.String r0 = r1.token
            java.util.Map<java.lang.String, java.lang.String> r1 = r7._extra
            java.lang.String r2 = "ENDPOINT_TYPE"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r5.mEndPointType = r1
        L36:
            if (r8 == 0) goto L93
            if (r6 == 0) goto L9a
            if (r7 == 0) goto L9a
            java.lang.Long r8 = r6.liveId
            if (r8 == 0) goto L9a
            com.youku.live.livesdk.widgets.model.LaifengRoomInfoData$RoomData r1 = r7.room
            if (r1 == 0) goto L9a
            java.lang.Long r1 = r1.id
            if (r1 == 0) goto L9a
            boolean r8 = r8.equals(r1)
            java.lang.String r1 = "DagoChannelPlugin"
            if (r8 == 0) goto L70
            com.youku.live.livesdk.model.mtop.data.livefullinfo.ExtDTO r7 = r6.ext
            if (r7 == 0) goto L59
            java.lang.Long r7 = r7.connectionAppId
            if (r7 == 0) goto L59
            goto L99
        L59:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "数据无效: liveFullInfoData.ext:"
            r7.append(r8)
            com.youku.live.livesdk.model.mtop.data.livefullinfo.ExtDTO r8 = r6.ext
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r1, r7)
            goto L9a
        L70:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "直播间ID不一致: liveFullInfoData.liveId:"
            r8.append(r2)
            java.lang.Long r2 = r6.liveId
            r8.append(r2)
            java.lang.String r2 = "; laifengRoomInfoData.room.id:"
            r8.append(r2)
            com.youku.live.livesdk.widgets.model.LaifengRoomInfoData$RoomData r7 = r7.room
            java.lang.Long r7 = r7.id
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.e(r1, r7)
            goto L9a
        L93:
            if (r6 == 0) goto L9a
            java.lang.Long r7 = r6.liveId
            if (r7 == 0) goto L9a
        L99:
            r3 = 1
        L9a:
            boolean r7 = r5.mStateActive
            if (r7 == 0) goto Lbe
            if (r3 == 0) goto Lbe
            com.youku.live.livesdk.model.mtop.data.livefullinfo.ExtDTO r7 = r6.ext
            java.lang.Long r7 = r7.connectionAppId
            long r7 = r7.longValue()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            java.lang.Long r6 = r6.liveId
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r5.mcOpen(r7, r6, r0)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.initWithLiveFullInfo(com.youku.live.livesdk.model.mtop.data.LiveFullInfoData, com.youku.live.livesdk.widgets.model.LaifengRoomInfoData, boolean):void");
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023089361")) {
            ipChange.ipc$dispatch("1023089361", new Object[]{this});
        } else {
            getEngineInstance().addDataHandlers(new String[]{"mtop.youku.live.com.livefullinfo", LF_ROOM_INFO_V2_API}, this);
        }
    }

    private boolean isAppear() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-363304089") ? ((Boolean) ipChange.ipc$dispatch("-363304089", new Object[]{this})).booleanValue() : this.mHasAppeared;
    }

    private boolean isLaifeng() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1806697366") ? ((Boolean) ipChange.ipc$dispatch("-1806697366", new Object[]{this})).booleanValue() : this.mIsLaifeng;
    }

    private void mcClose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330582298")) {
            ipChange.ipc$dispatch("-1330582298", new Object[]{this});
            return;
        }
        AdapterForTLog.loge(TAG, "mcClose:" + this + "," + this.mAppId + AVFSCacheConstants.COMMA_SEP + this.mRoomId + AVFSCacheConstants.COMMA_SEP + this.mToken + ";");
        String str = this.mPageInstanceId;
        if (str != null) {
            try {
                ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelClosing(str, this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.mMcOpened = false;
        perfMonitorPoint("DagoChannelPlugin.mcClose", "DagoChannelPlugin.mcClose:" + this.mAppId + AVFSCacheConstants.COMMA_SEP + this.mRoomId + AVFSCacheConstants.COMMA_SEP + this.mToken + ";");
        MCChannel mCChannel = this.mMCChannel;
        if (mCChannel != null) {
            mCChannel.close();
            this.mMCChannel = null;
        }
    }

    private void mcOpen(long j, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1742363062")) {
            ipChange.ipc$dispatch("1742363062", new Object[]{this, Long.valueOf(j), str, str2});
            return;
        }
        AdapterForTLog.loge(TAG, "mcOpen: " + this + "; appId: " + j + "; liveId: " + str);
        String string = getEngineInstance().getOptions().getString(SDKConstants.SDK_PAGE_INSTANCE_ID, "");
        this.mPageInstanceId = string;
        if (string != null) {
            try {
                ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelOpening(string, this, j, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.mMcOpened) {
            return;
        }
        this.mMcOpened = true;
        dispatchChannelStatus("open");
        perfMonitorPoint("DagoChannelPlugin.mcOpen", "DagoChannelPlugin.mcOpen:" + this + "," + j + ", {" + this.mRoomId + AVFSCacheConstants.COMMA_SEP + str + "}, " + str2 + ";");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(j);
        this.mAppId = sb.toString();
        this.mRoomId = str;
        this.mToken = str2;
        MCChannel createChannel = MCEngine.getInstance(j).createChannel(Arch.getApp().getApplicationContext(), str);
        this.mMCChannel = createChannel;
        createChannel.open(new IMCChannelEventCallback() { // from class: com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.messagechannel.callback.IMCChannelEventCallback
            public void onEvent(MCChannelEvent mCChannelEvent, String str3, Map<String, Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "452209293")) {
                    ipChange2.ipc$dispatch("452209293", new Object[]{this, mCChannelEvent, str3, map});
                } else {
                    DagoChannelPlugin.this.onEvent(mCChannelEvent, str3, map);
                }
            }
        }, new IMCDispatchMsgCallback() { // from class: com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.messagechannel.callback.IMCDispatchMsgCallback
            public void onDispatch(MCMessage mCMessage) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1544092069")) {
                    ipChange2.ipc$dispatch("1544092069", new Object[]{this, mCMessage});
                } else {
                    DagoChannelPlugin.this.onDispatch(mCMessage);
                }
            }
        });
    }

    private void mcOpenWithUpdateLiveFullInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-495622454")) {
            ipChange.ipc$dispatch("-495622454", new Object[]{this});
        } else if (this.mStateActive) {
            checkIsLaifeng();
            initWithLiveFullInfo(this.mLiveFullInfoData, this.mLaifengRoomInfoData, isLaifeng());
        }
    }

    private void onConnected() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105274494")) {
            ipChange.ipc$dispatch("2105274494", new Object[]{this});
        } else if (isLaifeng()) {
            sendUpPkInit();
            sendUpActiveStageGet();
            sendUpScreenStatInfo(this.mRoomId);
            sendUpPatronSaint();
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1641806146")) {
            ipChange.ipc$dispatch("1641806146", new Object[]{this});
            return;
        }
        getEngineInstance().removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        getEngineInstance().removeDataHandler(LF_ROOM_INFO_V2_API, this);
        mcClose();
        perfMonitorPoint("DagoChannelPlugin.addListener", "DagoChannelPlugin.clearListeners");
        getListeners().clear();
    }

    private void sendUpActiveStageGet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839884735")) {
            ipChange.ipc$dispatch("-839884735", new Object[]{this});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String sid = getSid("ActiveStageGet");
            MyLog.i(TAG, "sendUpActiveStageGet[]>>>>sid: " + sid);
            jSONObject.put("_sid", sid);
            sendUp(sid, "ActiveStageGet", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void sendUpPatronSaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220626056")) {
            ipChange.ipc$dispatch("-220626056", new Object[]{this});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String sid = getSid(PATRONSAINT);
            jSONObject.put(ReportManager.e, this.mRoomId);
            sendUp(sid, PATRONSAINT, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void sendUpPkInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "80087572")) {
            ipChange.ipc$dispatch("80087572", new Object[]{this});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String sid = getSid(PK_INIT);
            jSONObject.put("_sid", sid);
            jSONObject.put("t", 24);
            sendUp(sid, PK_INIT, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void sendUpScreenStatInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134338235")) {
            ipChange.ipc$dispatch("1134338235", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                String sid = getSid(NAME_SCREEN_STAT_INFO);
                jSONObject.put("_sid", sid);
                jSONObject.put("roomId", str);
                sendUp(sid, NAME_SCREEN_STAT_INFO, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLiveId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1315691164")) {
            ipChange.ipc$dispatch("1315691164", new Object[]{this, str});
            return;
        }
        Log.e(TAG, "更新直播间，关闭长连接:" + str);
    }

    public void addListener(Receiver receiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64541076")) {
            ipChange.ipc$dispatch("64541076", new Object[]{this, receiver});
            return;
        }
        perfMonitorPoint("DagoChannelPlugin.addListener.begin", "DagoChannelPlugin.addListener::" + receiver);
        getListeners().add(receiver);
        perfMonitorPoint("DagoChannelPlugin.addListener.end", "DagoChannelPlugin.addListener::" + receiver);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    @Override // com.youku.live.widgets.protocol.ICall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call(com.youku.live.widgets.protocol.IEngineInstance r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.Object> r7, com.youku.live.widgets.protocol.IResult r8, com.youku.live.widgets.protocol.IResult r9) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.$ipChange
            java.lang.String r1 = "-59645130"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L23
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r5 = 2
            r2[r5] = r6
            r5 = 3
            r2[r5] = r7
            r5 = 4
            r2[r5] = r8
            r5 = 5
            r2[r5] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L23:
            if (r7 == 0) goto L93
            if (r6 == 0) goto L93
            java.lang.String r5 = "msgType"
            boolean r0 = r7.containsKey(r5)
            r1 = 0
            if (r0 == 0) goto L3b
            java.lang.Object r5 = r7.get(r5)
            boolean r0 = r5 instanceof java.lang.String
            if (r0 == 0) goto L3b
            java.lang.String r5 = (java.lang.String) r5
            goto L3c
        L3b:
            r5 = r1
        L3c:
            java.lang.String r0 = "receiver"
            boolean r2 = r7.containsKey(r0)
            if (r2 == 0) goto L4f
            java.lang.Object r7 = r7.get(r0)
            boolean r0 = r7 instanceof com.youku.live.widgets.protocol.IResult
            if (r0 == 0) goto L4f
            com.youku.live.widgets.protocol.IResult r7 = (com.youku.live.widgets.protocol.IResult) r7
            goto L50
        L4f:
            r7 = r1
        L50:
            java.lang.String r0 = "addListener"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L72
            if (r5 == 0) goto L6c
            if (r7 == 0) goto L6c
            com.youku.live.livesdk.widgets.plugin.channel.ChannelListenersMananger r6 = r4.getChannelListenersMananger()
            boolean r5 = r6.putResultListenersByMsgType(r5, r7)
            if (r5 == 0) goto L6c
            if (r8 == 0) goto L6c
            r8.onResult(r1)
            return
        L6c:
            if (r9 == 0) goto L93
            r9.onResult(r1)
            return
        L72:
            java.lang.String r0 = "removeListener"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L93
            if (r5 == 0) goto L8e
            if (r7 == 0) goto L8e
            com.youku.live.livesdk.widgets.plugin.channel.ChannelListenersMananger r6 = r4.getChannelListenersMananger()
            boolean r5 = r6.removeResultListenersByMsgType(r5, r7)
            if (r5 == 0) goto L8e
            if (r8 == 0) goto L8e
            r8.onResult(r1)
            return
        L8e:
            if (r9 == 0) goto L93
            r9.onResult(r1)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.call(com.youku.live.widgets.protocol.IEngineInstance, java.lang.String, java.util.Map, com.youku.live.widgets.protocol.IResult, com.youku.live.widgets.protocol.IResult):void");
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761499118")) {
            ipChange.ipc$dispatch("1761499118", new Object[]{this});
            return;
        }
        getChannelListenersMananger().destroy();
        super.destroy();
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593858110")) {
            ipChange.ipc$dispatch("1593858110", new Object[]{this});
        } else {
            onActiveStateChanged(false);
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545812129")) {
            ipChange.ipc$dispatch("1545812129", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol.IPlugin
    public void initWithData(IEngineInstance iEngineInstance, IPluginData iPluginData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035044164")) {
            ipChange.ipc$dispatch("-1035044164", new Object[]{this, iEngineInstance, iPluginData});
            return;
        }
        super.initWithData(iEngineInstance, iPluginData);
        this.mStateActive = false;
        this.mRoomId = iPluginData.getOptions().getString("liveid", "");
        this.mLiveFullInfoData = null;
        this.mLaifengRoomInfoData = null;
        getAlarm().addArg("liveId", this.mRoomId);
        perfMonitorPoint("DagoChannelPlugin.initWithData", "pluginData.getOptions:" + iPluginData.getOptions().toMap());
    }

    public void onActiveStateChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732038330")) {
            ipChange.ipc$dispatch("1732038330", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mStateActive = z;
        if (z) {
            mcOpenWithUpdateLiveFullInfo();
        } else {
            mcClose();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756509313")) {
            ipChange.ipc$dispatch("-756509313", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                LiveFullInfoData liveFullInfoData = (LiveFullInfoData) obj;
                this.mLiveFullInfoData = liveFullInfoData;
                perfMonitorPoint("DagoChannelPlugin.onDataChanged", "'" + this.mRoomId + "' 'mtop.youku.live.com.livefullinfo' " + JSON.toJSONString(liveFullInfoData));
                mcOpenWithUpdateLiveFullInfo();
            }
        } else if (LF_ROOM_INFO_V2_API.equals(str) && (obj instanceof LaifengRoomInfoData)) {
            this.mHashToken = true;
            this.mLaifengRoomInfoData = (LaifengRoomInfoData) obj;
            perfMonitorPoint("DagoChannelPlugin.onDataChanged", "'" + this.mRoomId + "' '" + LF_ROOM_INFO_V2_API + "' " + JSON.toJSONString(obj));
            mcOpenWithUpdateLiveFullInfo();
        }
    }

    public void onDispatch(MCMessage mCMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15475251")) {
            ipChange.ipc$dispatch("15475251", new Object[]{this, mCMessage});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onDispatch: ");
        String str = "null";
        sb.append(mCMessage == null ? "null" : mCMessage.msgType);
        AdapterForTLog.logi(TAG, sb.toString());
        try {
            Message message = new Message(mCMessage);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDispatch: ");
            if (mCMessage != null) {
                str = mCMessage.msgType;
            }
            sb2.append(str);
            sb2.append("; ");
            sb2.append(message.data);
            Log.e(TAG, sb2.toString());
            MCChannel mCChannel = this.mMCChannel;
            if (mCChannel != null) {
                if (mCChannel.getAppId() == message.appId && mCChannel.getChannelId().equals(message.channelId)) {
                    List<Receiver> listeners = getListeners();
                    if (listeners != null) {
                        for (int i = 0; i < listeners.size(); i++) {
                            listeners.get(i).onMessage(message);
                        }
                    }
                    HashMap hashMap = new HashMap(3);
                    hashMap.put(RemoteMessageConst.MSGID, message.msgId);
                    hashMap.put(PARAM_MSG_TYPE, message.msgType);
                    hashMap.put("data", message.data);
                    getChannelListenersMananger().processMessage(message.msgType, hashMap);
                }
            } else {
                perfMonitorPoint("DagoChannelPlugin.onDispatch", "DagoChannelPlugin.onDispatch.mMCChannel is null");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            String str2 = this.mPageInstanceId;
            if (str2 != null) {
                ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelDispatch(str2, this, mCMessage);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void onEvent(MCChannelEvent mCChannelEvent, String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853067962")) {
            ipChange.ipc$dispatch("853067962", new Object[]{this, mCChannelEvent, str, map});
            return;
        }
        MCChannel mCChannel = this.mMCChannel;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection event callback, message: ");
        sb.append(str);
        sb.append(", getAppId:");
        sb.append(mCChannel != null ? Long.valueOf(mCChannel.getAppId()) : "null");
        sb.append(", getChannelId:");
        sb.append(mCChannel != null ? mCChannel.getChannelId() : "null");
        AdapterForTLog.loge(TAG, sb.toString());
        String str2 = this.mPageInstanceId;
        if (mCChannelEvent == MCChannelEvent.OPEN_SUCCESS) {
            getAlarm().commitSuccess();
            perfMonitorPoint("DagoChannelPlugin.onEvent", "DagoChannelPlugin.onEvent OPEN_SUCCESS");
            try {
                dispatchChannelStatus("openSuccess");
                onConnected();
                getEngineInstance().asyncPutData(DagoDataCenterConstants.DAGO_CONTAINER_CHANNEL_CONNECTED_EVENT, Boolean.TRUE);
                if (str2 != null) {
                    ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelOpenSuccess(str2, this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            AdapterForTLog.loge(TAG, "Connection success.");
        } else if (mCChannelEvent == MCChannelEvent.OPEN_FAIL) {
            getAlarm().setErrorCode("1000").setErrorMessage("open fail").commitFailure();
            perfMonitorPoint("DagoChannelPlugin.onEvent", "DagoChannelPlugin.onEvent OPEN_FAIL");
            try {
                dispatchChannelStatus("openFailure");
                getEngineInstance().asyncPutData(DagoDataCenterConstants.DAGO_CONTAINER_CHANNEL_CONNECTED_EVENT, Boolean.FALSE);
                if (str2 != null) {
                    ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelOpenFail(str2, this);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            AdapterForTLog.loge(TAG, "Connection fail.");
        } else if (mCChannelEvent == MCChannelEvent.CLOSE_SUCCESS) {
            perfMonitorPoint("DagoChannelPlugin.onEvent", "DagoChannelPlugin.onEvent CLOSE_SUCCESS");
            try {
                getEngineInstance().asyncPutData(DagoDataCenterConstants.DAGO_CONTAINER_CHANNEL_CONNECTED_EVENT, Boolean.FALSE);
                if (str2 != null) {
                    ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelCloseSuccess(str2, this);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            AdapterForTLog.loge(TAG, "Disconnection success.");
        } else if (mCChannelEvent == MCChannelEvent.CLOSE_FAIL) {
            perfMonitorPoint("DagoChannelPlugin.onEvent", "DagoChannelPlugin.onEvent CLOSE_FAIL");
            try {
                getEngineInstance().asyncPutData(DagoDataCenterConstants.DAGO_CONTAINER_CHANNEL_CONNECTED_EVENT, Boolean.FALSE);
                if (str2 != null) {
                    ((IDagoChannelInterruptInterface) Dsl.getService(IDagoChannelInterruptInterface.class)).onDagoChannelCloseFail(str2, this);
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            AdapterForTLog.loge(TAG, "Disconnection fail.");
        } else if (mCChannelEvent == MCChannelEvent.DEVICE_ONLINE) {
            getAlarm().addArg("device", "online");
            perfMonitorPoint("DagoChannelPlugin.onEvent", "DagoChannelPlugin.onEvent DEVICE_ONLINE");
            AdapterForTLog.loge(TAG, "Device online.");
        } else if (mCChannelEvent == MCChannelEvent.DEVICE_OFFLINE) {
            getAlarm().addArg("device", "offline");
            perfMonitorPoint("DagoChannelPlugin.onEvent", "DagoChannelPlugin.onEvent DEVICE_OFFLINE");
            AdapterForTLog.loge(TAG, "Device offline.");
        }
    }

    public void removeListener(Receiver receiver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549402315")) {
            ipChange.ipc$dispatch("1549402315", new Object[]{this, receiver});
            return;
        }
        perfMonitorPoint("DagoChannelPlugin.removeListener.begin", "DagoChannelPlugin.removeListener::" + receiver);
        getListeners().remove(receiver);
        perfMonitorPoint("DagoChannelPlugin.removeListener.end", "DagoChannelPlugin.removeListener::" + receiver);
    }

    public void sendUp(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000042578")) {
            ipChange.ipc$dispatch("2000042578", new Object[]{this, str, str2, map});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            sendUp(str, str2, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367522181")) {
            ipChange.ipc$dispatch("-367522181", new Object[]{this});
        } else {
            onActiveStateChanged(true);
        }
    }

    @Override // com.youku.live.widgets.impl.BasePlugin, com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308519263")) {
            ipChange.ipc$dispatch("-1308519263", new Object[]{this});
        } else {
            initWithNothing();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Message implements Serializable {
        public long appId;
        public byte[] bytes;
        public String channelId;
        public MCConnectionFlag connectionSource;
        public String data;
        public int expireTime;
        public String msgId;
        public String msgType;
        public String qos;
        public long sendTime;
        public boolean statMark;

        public Message() {
            this.statMark = false;
        }

        public Message(MCMessage mCMessage) {
            this.statMark = false;
            this.connectionSource = mCMessage.connectionSource;
            this.appId = mCMessage.appId;
            this.channelId = mCMessage.channelId;
            this.msgId = mCMessage.msgId;
            this.msgType = mCMessage.msgType;
            this.qos = mCMessage.qos;
            byte[] bArr = mCMessage.data;
            this.bytes = bArr;
            try {
                this.data = new String(bArr);
            } catch (Exception unused) {
                this.data = "";
            }
            if (this.data.startsWith("5:::")) {
                this.data = this.data.substring(4);
            }
            this.sendTime = mCMessage.sendTime;
            this.expireTime = mCMessage.expireTime;
            this.statMark = mCMessage.statMark;
        }
    }

    public void sendUp(String str, String str2, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251573045")) {
            ipChange.ipc$dispatch("-1251573045", new Object[]{this, str, str2, jSONObject});
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(JSON.parseObject(jSONObject.toString()));
        jSONObject2.put("name", (Object) str2);
        jSONObject2.put("args", (Object) jSONArray);
        HashMap hashMap = new HashMap(16);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, this.mAppId);
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, this.mRoomId);
        hashMap.put(RemoteMessageConst.MSGID, str);
        hashMap.put("data", "5:::" + jSONObject2.toJSONString());
        hashMap.put("chatRoomToken", this.mToken);
        hashMap.put("endpointType", this.mEndPointType);
        INetClient iNetClient = (INetClient) Dsl.getService(INetClient.class);
        Log.e(TAG, "mtop.youku.live.chatroom.lf.userSendData:" + hashMap);
        INetRequest createRequestWithMTop = iNetClient.createRequestWithMTop("mtop.youku.live.chatroom.lf.userSendData", "1.0", hashMap, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-71875126")) {
                        ipChange2.ipc$dispatch("-71875126", new Object[]{this, iNetResponse});
                        return;
                    }
                    Log.e(DagoChannelPlugin.TAG, "mtop.youku.live.chatroom.lf.userSendData:" + iNetResponse.getSource());
                    iNetResponse.isSuccess();
                }
            });
        }
    }

    private String getSid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "416335372")) {
            return (String) ipChange.ipc$dispatch("416335372", new Object[]{this, str});
        }
        return str + getSid();
    }

    public void onDispatch(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188229648")) {
            ipChange.ipc$dispatch("-188229648", new Object[]{this, message});
            return;
        }
        try {
            List<Receiver> listeners = getListeners();
            if (listeners != null) {
                for (int i = 0; i < listeners.size(); i++) {
                    listeners.get(i).onMessage(message);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
