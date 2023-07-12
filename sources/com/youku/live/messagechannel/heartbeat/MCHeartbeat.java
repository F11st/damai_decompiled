package com.youku.live.messagechannel.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.orange.OrangeConfig;
import com.youku.live.messagechannel.callback.IMCHeartbeatEventCallback;
import com.youku.live.messagechannel.callback.MCHeartbeatEvent;
import com.youku.live.messagechannel.conf.OrangeConfKey;
import com.youku.live.messagechannel.utils.HttpUtils;
import com.youku.live.messagechannel.utils.MCThreadFactory;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.ServerTimeEstimater;
import com.youku.live.messagechannel.utils.UTEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCHeartbeat {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_HEARBEAT = "FAIL_BIZ_DEVICE_HEARBEAT";
    private static final String HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_HEARBEAT_NOT_ONLINE = "FAIL_BIZ_DEVICE_HEARBEAT_NOT_ONLINE";
    private static final String HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_HEARBEAT_TOKEN_NOT_MATCH = "FAIL_BIZ_DEVICE_HEARBEAT_TOKEN_NOT_MATCH";
    private static final String HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_OFFLINE = "FAIL_BIZ_DEVICE_OFFLINE";
    private static final String HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_ONLINE = "FAIL_BIZ_DEVICE_ONLINE";
    private static final String HEARTBEAT_RESPONSE_SUCCESS = "SUCCESS";
    private static Map<String, Long> onlineTimeMapping = new HashMap(16);
    private final long appId;
    private final String channelId;
    private Context context;
    private String heartBeatInterval;
    private ScheduledThreadPoolExecutor heartbeatExecutor;
    private Future heartbeatFuture;
    private MCHeartbeatInfo heartbeatInfo;
    private IMCHeartbeatEventCallback startHeartbeatEventCallback;
    private IMCHeartbeatEventCallback stopHeartbeatEventCallback;
    private final String TAG = getClass().getName();
    private volatile boolean paused = false;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class HeartbeatWork implements Runnable {
        HeartbeatWork() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z = MCHeartbeat.this.heartbeatInfo == null;
            String str = z ? "" : MCHeartbeat.this.heartbeatInfo.heartbeatToken;
            final long currentTimeMillis = System.currentTimeMillis();
            if (z || !MCHeartbeat.this.paused) {
                HttpUtils.heartbeat(MCHeartbeat.this.context, String.valueOf(MCHeartbeat.this.appId), MCHeartbeat.this.channelId, String.valueOf(z), str, String.valueOf(MCHeartbeat.getDeviceOnlineTimeInChannel(MCHeartbeat.this.appId, MCHeartbeat.this.channelId)), new MtopCallback.MtopFinishListener() { // from class: com.youku.live.messagechannel.heartbeat.MCHeartbeat.HeartbeatWork.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
                    public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                        boolean z2;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-783074585")) {
                            ipChange.ipc$dispatch("-783074585", new Object[]{this, mtopFinishEvent, obj});
                            return;
                        }
                        MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                        if (!mtopResponse.getApi().equals(HttpUtils.HTTP_HEARTBEAT)) {
                            MyLog.e(MCHeartbeat.this.TAG, "Heartbeat mtop api error, api:", mtopResponse.getApi(), ", code:", mtopResponse.getRetCode(), ", msg:", mtopResponse.getRetMsg(), MCHeartbeat.this.appIdAndChannelString());
                        } else if ("SUCCESS".equals(mtopResponse.getRetCode())) {
                            JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
                            if (dataJsonObject != null) {
                                Long valueOf = Long.valueOf(dataJsonObject.optLong(ProjectShowBean.SERVER_TIME));
                                if (valueOf != null) {
                                    ServerTimeEstimater.syncEstimaterByServerTime(currentTimeMillis, valueOf.longValue());
                                }
                                Long valueOf2 = Long.valueOf(dataJsonObject.optLong(ALBiometricsKeys.KEY_APP_ID));
                                String optString = dataJsonObject.optString(RemoteMessageConst.Notification.CHANNEL_ID);
                                String optString2 = dataJsonObject.optString("hbToken");
                                Integer valueOf3 = Integer.valueOf(dataJsonObject.optInt("hbInterval"));
                                if (valueOf2 == null || valueOf2.longValue() != MCHeartbeat.this.appId || TextUtils.isEmpty(optString) || !optString.equals(MCHeartbeat.this.channelId)) {
                                    MyLog.e(MCHeartbeat.this.TAG, "Heartbeat appId or channelId not match, appIdFS:", valueOf2, ", channelIdFS:", optString, MCHeartbeat.this.appIdAndChannelString());
                                } else {
                                    if (!z) {
                                        MyLog.d(MCHeartbeat.this.TAG, "Heartbeat success", MCHeartbeat.this.appIdAndChannelString(), ", heartbeatInfo:", MCHeartbeat.this.heartbeatInfo.toString());
                                        if (valueOf3 != null && MCHeartbeat.this.heartbeatInfo.hbInterval != valueOf3.intValue()) {
                                            MyLog.d(MCHeartbeat.this.TAG, "Heartbeat interval change from:", Integer.valueOf(MCHeartbeat.this.heartbeatInfo.hbInterval), " to:", valueOf3, MCHeartbeat.this.appIdAndChannelString());
                                            MCHeartbeat.this.heartbeatInfo.hbInterval = valueOf3.intValue();
                                            z2 = true;
                                        }
                                        z2 = false;
                                    } else if (TextUtils.isEmpty(optString2) || valueOf3 == null) {
                                        MyLog.e(MCHeartbeat.this.TAG, "First heartbeat fail cause of hbToken or hbInterval invalid", MCHeartbeat.this.appIdAndChannelString());
                                        z2 = false;
                                    } else {
                                        MCHeartbeat.this.heartbeatInfo = new MCHeartbeatInfo();
                                        MCHeartbeat.this.heartbeatInfo.heartbeatToken = optString2;
                                        MCHeartbeat.this.heartbeatInfo.hbInterval = valueOf3.intValue();
                                        MCHeartbeat.setDeviceOnlineTimeInChannel(MCHeartbeat.this.appId, MCHeartbeat.this.channelId, ServerTimeEstimater.estimateServerTimestamp());
                                        MyLog.i(MCHeartbeat.this.TAG, "First heartbeat success", MCHeartbeat.this.appIdAndChannelString(), ", heartbeatInfo:", MCHeartbeat.this.heartbeatInfo.toString());
                                        if (MCHeartbeat.this.startHeartbeatEventCallback != null) {
                                            IMCHeartbeatEventCallback iMCHeartbeatEventCallback = MCHeartbeat.this.startHeartbeatEventCallback;
                                            MCHeartbeatEvent mCHeartbeatEvent = MCHeartbeatEvent.START_SUCCESS;
                                            iMCHeartbeatEventCallback.onEvent(mCHeartbeatEvent, mCHeartbeatEvent.getMsg());
                                        }
                                        z2 = true;
                                    }
                                    if (z2) {
                                        if (MCHeartbeat.this.heartbeatFuture != null) {
                                            MCHeartbeat.this.heartbeatFuture.cancel(true);
                                        }
                                        if (MCHeartbeat.this.heartbeatInfo.hbInterval > 0) {
                                            MCHeartbeat mCHeartbeat = MCHeartbeat.this;
                                            mCHeartbeat.heartbeatFuture = mCHeartbeat.heartbeatExecutor.scheduleWithFixedDelay(new HeartbeatWork(), MCHeartbeat.this.heartbeatInfo.hbInterval, MCHeartbeat.this.heartbeatInfo.hbInterval, TimeUnit.SECONDS);
                                            MyLog.i(MCHeartbeat.this.TAG, "Heartbeat task reset", MCHeartbeat.this.appIdAndChannelString(), ", heartbeatInfo:", MCHeartbeat.this.heartbeatInfo.toString());
                                        } else {
                                            MCHeartbeat mCHeartbeat2 = MCHeartbeat.this;
                                            mCHeartbeat2.heartbeatFuture = mCHeartbeat2.heartbeatExecutor.scheduleWithFixedDelay(new HeartbeatWorkLocal(), Long.valueOf(MCHeartbeat.this.heartBeatInterval).longValue(), Long.valueOf(MCHeartbeat.this.heartBeatInterval).longValue(), TimeUnit.SECONDS);
                                            MyLog.i(MCHeartbeat.this.TAG, "Heartbeat task switch to local", MCHeartbeat.this.appIdAndChannelString(), ", heartbeatInfo:", MCHeartbeat.this.heartbeatInfo.toString());
                                        }
                                    }
                                }
                            }
                        } else if (MCHeartbeat.HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_HEARBEAT_NOT_ONLINE.equals(mtopResponse.getRetCode())) {
                            MyLog.e(MCHeartbeat.this.TAG, "Heartbeat error cause of device not online", MCHeartbeat.this.appIdAndChannelString());
                            MCHeartbeat.this.initHeartbeatInfo();
                        } else if (MCHeartbeat.HEARTBEAT_RESPONSE_FAIL_BIZ_DEVICE_HEARBEAT_TOKEN_NOT_MATCH.equals(mtopResponse.getRetCode())) {
                            MyLog.e(MCHeartbeat.this.TAG, "Heartbeat error cause of token not match", MCHeartbeat.this.appIdAndChannelString());
                            MCHeartbeat.this.initHeartbeatInfo();
                        } else {
                            MyLog.e(MCHeartbeat.this.TAG, "Heartbeat biz error, code:", mtopResponse.getRetCode(), ", msg:", mtopResponse.getRetMsg(), MCHeartbeat.this.appIdAndChannelString());
                            if (MCHeartbeat.this.heartbeatInfo == null && (MCHeartbeat.this.heartbeatFuture instanceof Future)) {
                                MCHeartbeat.this.heartbeatFuture = null;
                            }
                        }
                        MCHeartbeat.this.utRecordHeartbeat(z);
                    }
                });
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class HeartbeatWorkLocal implements Runnable {
        HeartbeatWorkLocal() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MyLog.i(MCHeartbeat.this.TAG, "Local heartbeat", MCHeartbeat.this.appIdAndChannelString(), ", heartbeatInfo:", MCHeartbeat.this.heartbeatInfo.toString());
            MCHeartbeat.this.utRecordHeartbeat(false);
        }
    }

    public MCHeartbeat(Context context, long j, String str) {
        OrangeConfig orangeConfig = OrangeConfig.getInstance();
        OrangeConfKey.KeyInfo keyInfo = OrangeConfKey.heartBeatInterval;
        this.heartBeatInterval = orangeConfig.getConfig(OrangeConfKey.Group.android_youku_messagechannel, keyInfo.name, keyInfo.def);
        this.context = context;
        this.appId = j;
        this.channelId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String appIdAndChannelString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580555365")) {
            return (String) ipChange.ipc$dispatch("-580555365", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(", appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(", channelId:");
        stringBuffer.append(this.channelId);
        return stringBuffer.toString();
    }

    public static void deleteDeviceOnlineTimeInChannel(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732780301")) {
            ipChange.ipc$dispatch("732780301", new Object[]{Long.valueOf(j), str});
        } else if (j <= 0 || TextUtils.isEmpty(str)) {
        } else {
            Map<String, Long> map = onlineTimeMapping;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j);
            stringBuffer.append(str);
            map.remove(stringBuffer.toString());
        }
    }

    public static long getDeviceOnlineTimeInChannel(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-629398296")) {
            return ((Long) ipChange.ipc$dispatch("-629398296", new Object[]{Long.valueOf(j), str})).longValue();
        }
        if (j > 0 && !TextUtils.isEmpty(str)) {
            Map<String, Long> map = onlineTimeMapping;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j);
            stringBuffer.append(str);
            Long l = map.get(stringBuffer.toString());
            if (l != null && l.longValue() > 0) {
                return l.longValue();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHeartbeatInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-957278332")) {
            ipChange.ipc$dispatch("-957278332", new Object[]{this});
        } else {
            this.heartbeatInfo = null;
        }
    }

    public static void setDeviceOnlineTimeInChannel(long j, String str, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618061988")) {
            ipChange.ipc$dispatch("-1618061988", new Object[]{Long.valueOf(j), str, Long.valueOf(j2)});
        } else if (j <= 0 || TextUtils.isEmpty(str) || j2 <= 0) {
        } else {
            Map<String, Long> map = onlineTimeMapping;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j);
            stringBuffer.append(str);
            map.put(stringBuffer.toString(), Long.valueOf(j2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void utRecordHeartbeat(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256012098")) {
            ipChange.ipc$dispatch("1256012098", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(this.appId));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, this.channelId);
        hashMap.put("onlineTime", String.valueOf(getDeviceOnlineTimeInChannel(this.appId, this.channelId)));
        hashMap.put("eventTime", String.valueOf(ServerTimeEstimater.estimateServerTimestamp()));
        if (z) {
            hashMap.put("event", "online");
        } else {
            hashMap.put("event", "heartbeat");
        }
        UTEvent.record("heartbeat", hashMap);
    }

    private void utRecordOffline() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "768588747")) {
            ipChange.ipc$dispatch("768588747", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(this.appId));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, this.channelId);
        hashMap.put("onlineTime", String.valueOf(getDeviceOnlineTimeInChannel(this.appId, this.channelId)));
        hashMap.put("eventTime", String.valueOf(ServerTimeEstimater.estimateServerTimestamp()));
        hashMap.put("event", "offline");
        UTEvent.record("heartbeat", hashMap);
    }

    public boolean isHeartbeating() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-6145152") ? ((Boolean) ipChange.ipc$dispatch("-6145152", new Object[]{this})).booleanValue() : this.heartbeatFuture != null;
    }

    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2094958712") ? ((Boolean) ipChange.ipc$dispatch("2094958712", new Object[]{this})).booleanValue() : this.paused;
    }

    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1699288536")) {
            ipChange.ipc$dispatch("-1699288536", new Object[]{this});
        } else {
            this.paused = true;
        }
    }

    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509449439")) {
            ipChange.ipc$dispatch("509449439", new Object[]{this});
        } else {
            this.paused = false;
        }
    }

    public void start(IMCHeartbeatEventCallback iMCHeartbeatEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625843663")) {
            ipChange.ipc$dispatch("1625843663", new Object[]{this, iMCHeartbeatEventCallback});
            return;
        }
        this.startHeartbeatEventCallback = iMCHeartbeatEventCallback;
        initHeartbeatInfo();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new MCThreadFactory("heartbeat"));
        this.heartbeatExecutor = scheduledThreadPoolExecutor;
        this.heartbeatFuture = scheduledThreadPoolExecutor.submit(new HeartbeatWork());
        MyLog.d(this.TAG, "First heartbeat task start", appIdAndChannelString());
    }

    public void stop(IMCHeartbeatEventCallback iMCHeartbeatEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257568957")) {
            ipChange.ipc$dispatch("1257568957", new Object[]{this, iMCHeartbeatEventCallback});
            return;
        }
        this.stopHeartbeatEventCallback = iMCHeartbeatEventCallback;
        Future future = this.heartbeatFuture;
        if (future != null) {
            future.cancel(true);
            this.heartbeatFuture = null;
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.heartbeatExecutor;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdownNow();
        }
        if (this.heartbeatInfo != null) {
            Context context = this.context;
            String valueOf = String.valueOf(this.appId);
            String str = this.channelId;
            HttpUtils.offline(context, valueOf, str, this.heartbeatInfo.heartbeatToken, String.valueOf(getDeviceOnlineTimeInChannel(this.appId, str)), new MtopCallback.MtopFinishListener() { // from class: com.youku.live.messagechannel.heartbeat.MCHeartbeat.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
                public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1922401264")) {
                        ipChange2.ipc$dispatch("1922401264", new Object[]{this, mtopFinishEvent, obj});
                        return;
                    }
                    MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                    if (mtopResponse.getApi().equals(HttpUtils.HTTP_OFFLINE)) {
                        if ("SUCCESS".equals(mtopResponse.getRetCode())) {
                            MyLog.d(MCHeartbeat.this.TAG, "Offline success", MCHeartbeat.this.appIdAndChannelString());
                        } else {
                            MyLog.e(MCHeartbeat.this.TAG, "Offline error, code:", mtopResponse.getRetCode(), ", msg:", mtopResponse.getRetMsg(), MCHeartbeat.this.appIdAndChannelString());
                        }
                    }
                }
            });
        }
        utRecordOffline();
        initHeartbeatInfo();
        deleteDeviceOnlineTimeInChannel(this.appId, this.channelId);
        IMCHeartbeatEventCallback iMCHeartbeatEventCallback2 = this.stopHeartbeatEventCallback;
        if (iMCHeartbeatEventCallback2 != null) {
            MCHeartbeatEvent mCHeartbeatEvent = MCHeartbeatEvent.STOP_SUCCESS;
            iMCHeartbeatEventCallback2.onEvent(mCHeartbeatEvent, mCHeartbeatEvent.getMsg());
        }
        MyLog.d(this.TAG, "Heartbeat task stop", appIdAndChannelString());
    }
}
