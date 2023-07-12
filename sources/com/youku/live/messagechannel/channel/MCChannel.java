package com.youku.live.messagechannel.channel;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import anet.channel.entity.ConnType;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import com.youku.live.messagechannel.callback.IMCChannelEventCallback;
import com.youku.live.messagechannel.callback.IMCDispatchMsgCallback;
import com.youku.live.messagechannel.callback.IMCSessionEventCallback;
import com.youku.live.messagechannel.callback.MCChannelEvent;
import com.youku.live.messagechannel.callback.MCSessionEvent;
import com.youku.live.messagechannel.connection.AccsMassMCConnection;
import com.youku.live.messagechannel.connection.CDNMCConnection;
import com.youku.live.messagechannel.connection.IMCConnection;
import com.youku.live.messagechannel.connection.PMMCConnection;
import com.youku.live.messagechannel.message.MCMessageDispatcher;
import com.youku.live.messagechannel.message.MCMessageProcessor;
import com.youku.live.messagechannel.message.MCMessageReporter;
import com.youku.live.messagechannel.report.MCConnectionReportWrap;
import com.youku.live.messagechannel.report.MCMarkMessageManager;
import com.youku.live.messagechannel.session.MCSession;
import com.youku.live.messagechannel.utils.HttpUtils;
import com.youku.live.messagechannel.utils.MyLog;
import com.youku.live.messagechannel.utils.ServerTimeEstimater;
import com.youku.live.messagechannel.utils.UTEvent;
import java.util.ArrayList;
import java.util.HashMap;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;
import tb.C9556pm;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCChannel {
    private static transient /* synthetic */ IpChange $ipChange;
    private final long appId;
    private final String channelId;
    private Context context;
    private IMCChannelEventCallback eventCallback;
    private MCChannelInfo mcChannelInfo;
    private MCSession mcSession;
    private final String TAG = getClass().getName();
    private MCChannelState mcChannelState = MCChannelState.INIT;
    private long openStartTime = 0;
    private long localOpenStartTime = 0;
    private long closeStartTime = 0;
    private long localCloseStartTime = 0;

    public MCChannel(@NonNull Context context, @NonNull long j, @NonNull String str) {
        this.context = context;
        this.appId = j;
        this.channelId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String appIdAndChannelString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "501216681")) {
            return (String) ipChange.ipc$dispatch("501216681", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(", appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(", channelId:");
        stringBuffer.append(this.channelId);
        return stringBuffer.toString();
    }

    private String appMonitorArg(boolean z, boolean z2, String str) {
        long j;
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744206557")) {
            return (String) ipChange.ipc$dispatch("-744206557", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str});
        }
        if (z) {
            j = this.openStartTime;
            j2 = this.localOpenStartTime;
        } else {
            j = this.closeStartTime;
            j2 = this.localCloseStartTime;
        }
        MCConnectionReportWrap mCConnectionReportWrap = new MCConnectionReportWrap();
        mCConnectionReportWrap.appId = this.appId;
        mCConnectionReportWrap.channelId = this.channelId;
        mCConnectionReportWrap.startTime = j;
        mCConnectionReportWrap.localStartTime = j2;
        mCConnectionReportWrap.endTime = ServerTimeEstimater.estimateServerTimestamp();
        mCConnectionReportWrap.takeTime = System.currentTimeMillis() - j2;
        mCConnectionReportWrap.success = z2 ? 1 : 0;
        if (!TextUtils.isEmpty(str)) {
            mCConnectionReportWrap.errorMsg = str;
        }
        return JSON.toJSONString(mCConnectionReportWrap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String appMonitorCloseArg(boolean z, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "803095621") ? (String) ipChange.ipc$dispatch("803095621", new Object[]{this, Boolean.valueOf(z), str}) : appMonitorArg(false, z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String appMonitorOpenArg(boolean z, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "642595199") ? (String) ipChange.ipc$dispatch("642595199", new Object[]{this, Boolean.valueOf(z), str}) : appMonitorArg(true, z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097456810")) {
            ipChange.ipc$dispatch("1097456810", new Object[]{this});
            return;
        }
        MyLog.d(this.TAG, "initSession", appIdAndChannelString());
        if (this.mcChannelInfo == null) {
            MyLog.e(this.TAG, "ChannelInfo is null!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        PMInfo pMInfo = this.mcChannelInfo.PMInfo;
        if (pMInfo != null && pMInfo.bizCode > 0 && !TextUtils.isEmpty(pMInfo.topic)) {
            PMInfo pMInfo2 = this.mcChannelInfo.PMInfo;
            if (!pMInfo2.isBanConnect) {
                Context context = this.context;
                long j = this.appId;
                String str = this.channelId;
                PMInfo pMInfo3 = this.mcChannelInfo.PMInfo;
                arrayList.add(new PMMCConnection(context, j, str, pMInfo3.bizCode, pMInfo3.topic, pMInfo3.msgFetchMode));
                MyLog.d(this.TAG, "InitSession added pmConnection, PMInfo:", this.mcChannelInfo.PMInfo, appIdAndChannelString());
            } else {
                MyLog.w(this.TAG, "InitSession pmConnection is ban, PMInfo:", pMInfo2, appIdAndChannelString());
            }
        }
        CDNInfo cDNInfo = this.mcChannelInfo.CDNInfo;
        if (cDNInfo != null && !TextUtils.isEmpty(cDNInfo.url)) {
            Context context2 = this.context;
            long j2 = this.appId;
            String str2 = this.channelId;
            CDNInfo cDNInfo2 = this.mcChannelInfo.CDNInfo;
            arrayList.add(new CDNMCConnection(context2, j2, str2, cDNInfo2.pullInterval, cDNInfo2.url));
            MyLog.d(this.TAG, "InitSession added cdnConnection, CDNInfo:", this.mcChannelInfo.CDNInfo, appIdAndChannelString());
        }
        MASSInfo mASSInfo = this.mcChannelInfo.MASSInfo;
        if (mASSInfo != null && !TextUtils.isEmpty(mASSInfo.topic)) {
            Context context3 = this.context;
            long j3 = this.appId;
            String str3 = this.channelId;
            MASSInfo mASSInfo2 = this.mcChannelInfo.MASSInfo;
            arrayList.add(new AccsMassMCConnection(context3, j3, str3, mASSInfo2.topic, mASSInfo2.connectByMyself));
            MyLog.d(this.TAG, "InitSession added massConnection, MASSInfo:", this.mcChannelInfo.MASSInfo, appIdAndChannelString());
        }
        if (!arrayList.isEmpty()) {
            final ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((IMCConnection) arrayList.get(i)).getConnectionFlag().name());
            }
            MCSession mCSession = new MCSession(this.context, this.appId, this.channelId, arrayList, new IMCSessionEventCallback() { // from class: com.youku.live.messagechannel.channel.MCChannel.1
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v19 */
                /* JADX WARN: Type inference failed for: r2v7 */
                /* JADX WARN: Type inference failed for: r2v8, types: [com.youku.live.messagechannel.callback.IMCChannelEventCallback, java.util.Map] */
                /* JADX WARN: Type inference failed for: r3v10, types: [com.youku.live.messagechannel.callback.IMCChannelEventCallback, java.util.Map] */
                /* JADX WARN: Type inference failed for: r3v21 */
                /* JADX WARN: Type inference failed for: r3v9 */
                @Override // com.youku.live.messagechannel.callback.IMCSessionEventCallback
                public void onEvent(MCSessionEvent mCSessionEvent, String str4) {
                    ?? r3;
                    ?? r2;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1191962531")) {
                        ipChange2.ipc$dispatch("1191962531", new Object[]{this, mCSessionEvent, str4});
                    } else if (mCSessionEvent == MCSessionEvent.OPEN_SUCCESS) {
                        MyLog.d(MCChannel.this.TAG, "Channel open success cause of session open success", MCChannel.this.appIdAndChannelString());
                        MCChannel.this.mcChannelState = MCChannelState.OPENED;
                        if (MCChannel.this.eventCallback != null) {
                            MCChannel.this.eventCallback.onEvent(MCChannelEvent.OPEN_SUCCESS, "Channel open success.", null);
                        }
                        HashMap hashMap = new HashMap(8);
                        hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(MCChannel.this.appId));
                        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, MCChannel.this.channelId);
                        hashMap.put("connections", TextUtils.join(AVFSCacheConstants.COMMA_SEP, arrayList2));
                        if (MCChannel.this.mcChannelInfo.MASSInfo != null) {
                            hashMap.put("connectByMyself", String.valueOf(MCChannel.this.mcChannelInfo.MASSInfo.connectByMyself));
                        }
                        hashMap.put("isSuccess", "true");
                        UTEvent.record("openChannel", hashMap);
                        AppMonitor.Alarm.commitSuccess(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "openChannelX", MCChannel.this.appMonitorOpenArg(true, ""));
                    } else if (mCSessionEvent == MCSessionEvent.OPEN_FAIL) {
                        MyLog.e(MCChannel.this.TAG, "Channel open fail cause of session open fail, ", str4, MCChannel.this.appIdAndChannelString());
                        MCChannel.this.mcChannelState = MCChannelState.INIT;
                        if (MCChannel.this.eventCallback != null) {
                            MCChannel.this.eventCallback.onEvent(MCChannelEvent.OPEN_FAIL, str4, null);
                        }
                        HashMap hashMap2 = new HashMap(8);
                        hashMap2.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(MCChannel.this.appId));
                        hashMap2.put(RemoteMessageConst.Notification.CHANNEL_ID, MCChannel.this.channelId);
                        hashMap2.put("connections", TextUtils.join(AVFSCacheConstants.COMMA_SEP, arrayList2));
                        if (MCChannel.this.mcChannelInfo.MASSInfo != null) {
                            hashMap2.put("connectByMyself", String.valueOf(MCChannel.this.mcChannelInfo.MASSInfo.connectByMyself));
                        }
                        hashMap2.put("isSuccess", "false");
                        hashMap2.put("msg", str4);
                        UTEvent.record("openChannel", hashMap2);
                        AppMonitor.Alarm.commitFail(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "openChannelX", MCChannel.this.appMonitorOpenArg(false, str4), "1", str4);
                    } else if (mCSessionEvent == MCSessionEvent.CLOSE_SUCCESS) {
                        MyLog.d(MCChannel.this.TAG, "Channel close success cause of session close success", MCChannel.this.appIdAndChannelString());
                        if (MCChannel.this.mcSession != null) {
                            r2 = 0;
                            MCChannel.this.mcSession = null;
                        } else {
                            r2 = 0;
                        }
                        if (MCChannel.this.eventCallback != null) {
                            MCChannel.this.eventCallback.onEvent(MCChannelEvent.CLOSE_SUCCESS, "Channel close success.", r2);
                            MCChannel.this.eventCallback = r2;
                        }
                        HashMap hashMap3 = new HashMap(8);
                        hashMap3.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(MCChannel.this.appId));
                        hashMap3.put(RemoteMessageConst.Notification.CHANNEL_ID, MCChannel.this.channelId);
                        hashMap3.put("connections", TextUtils.join(AVFSCacheConstants.COMMA_SEP, arrayList2));
                        hashMap3.put("isSuccess", "true");
                        UTEvent.record("closeChannel", hashMap3);
                        AppMonitor.Alarm.commitSuccess(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "closeChannelX", MCChannel.this.appMonitorCloseArg(true, ""));
                    } else if (mCSessionEvent == MCSessionEvent.CLOSE_FAIL) {
                        MyLog.e(MCChannel.this.TAG, "Channel close fail cause of session close fail, ", str4, MCChannel.this.appIdAndChannelString());
                        if (MCChannel.this.mcSession != null) {
                            r3 = 0;
                            MCChannel.this.mcSession = null;
                        } else {
                            r3 = 0;
                        }
                        if (MCChannel.this.eventCallback != null) {
                            MCChannel.this.eventCallback.onEvent(MCChannelEvent.CLOSE_SUCCESS, str4, r3);
                            MCChannel.this.eventCallback = r3;
                        }
                        HashMap hashMap4 = new HashMap(8);
                        hashMap4.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(MCChannel.this.appId));
                        hashMap4.put(RemoteMessageConst.Notification.CHANNEL_ID, MCChannel.this.channelId);
                        hashMap4.put("connections", TextUtils.join(AVFSCacheConstants.COMMA_SEP, arrayList2));
                        hashMap4.put("isSuccess", "false");
                        hashMap4.put("msg", str4);
                        UTEvent.record("closeChannel", hashMap4);
                        AppMonitor.Alarm.commitFail(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "closeChannelX", MCChannel.this.appMonitorCloseArg(false, str4), "1", str4);
                    } else if (mCSessionEvent == MCSessionEvent.CONNECTION_RECOVERY_ONLINE) {
                        if (MCChannel.this.eventCallback != null) {
                            MCChannel.this.eventCallback.onEvent(MCChannelEvent.DEVICE_ONLINE, "Device online.", null);
                        }
                    } else if (mCSessionEvent != MCSessionEvent.CONNECTION_BROKEN_OFFLINE || MCChannel.this.eventCallback == null) {
                    } else {
                        MCChannel.this.eventCallback.onEvent(MCChannelEvent.DEVICE_OFFLINE, "Device offline.", null);
                    }
                }
            });
            this.mcSession = mCSession;
            mCSession.openSession();
            return;
        }
        MyLog.e(this.TAG, "Channel open fail cause of no usable MCConnections", appIdAndChannelString());
        this.mcChannelState = MCChannelState.INIT;
        if (this.mcSession != null) {
            this.mcSession = null;
        }
        IMCChannelEventCallback iMCChannelEventCallback = this.eventCallback;
        if (iMCChannelEventCallback != null) {
            iMCChannelEventCallback.onEvent(MCChannelEvent.OPEN_FAIL, "Channel open fail cause of no usable MCConnections", null);
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(this.appId));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, this.channelId);
        hashMap.put("isSuccess", "false");
        hashMap.put("msg", "Channel open fail cause of no usable MCConnections");
        UTEvent.record("openChannel", hashMap);
        AppMonitor.Alarm.commitFail(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "openChannelX", appMonitorOpenArg(false, "Channel open fail cause of no usable MCConnections"), "1", "Channel open fail cause of no usable MCConnections");
    }

    private void initSessionAfterGetChannelInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66779337")) {
            ipChange.ipc$dispatch("66779337", new Object[]{this});
            return;
        }
        MyLog.d(this.TAG, "InitSessionAfterGetChannelInfo", appIdAndChannelString());
        final long currentTimeMillis = System.currentTimeMillis();
        HttpUtils.getChannelInfo(this.context, String.valueOf(this.appId), this.channelId, new MtopCallback.MtopFinishListener() { // from class: com.youku.live.messagechannel.channel.MCChannel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
            public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1128534913")) {
                    ipChange2.ipc$dispatch("1128534913", new Object[]{this, mtopFinishEvent, obj});
                    return;
                }
                HashMap hashMap = new HashMap(8);
                hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(MCChannel.this.appId));
                hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, MCChannel.this.channelId);
                MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                if (mtopResponse.getApi().equals(HttpUtils.HTTP_GET_CHANNEL_INFO) && mtopResponse.isApiSuccess()) {
                    MyLog.d(MCChannel.this.TAG, "GetChannelInfo success", MCChannel.this.appIdAndChannelString());
                    JSONObject dataJsonObject = mtopResponse.getDataJsonObject();
                    if (dataJsonObject != null) {
                        Long valueOf = Long.valueOf(dataJsonObject.optLong(ALBiometricsKeys.KEY_APP_ID));
                        String optString = dataJsonObject.optString(RemoteMessageConst.Notification.CHANNEL_ID);
                        Long valueOf2 = Long.valueOf(dataJsonObject.optLong(ProjectShowBean.SERVER_TIME));
                        JSONObject optJSONObject = dataJsonObject.optJSONObject("connectionMode");
                        if (valueOf.longValue() == MCChannel.this.appId && MCChannel.this.channelId.equals(optString) && valueOf2 != null && optJSONObject != null) {
                            MCChannel.this.mcChannelInfo = new MCChannelInfo();
                            MCChannel.this.mcChannelInfo.appId = valueOf.longValue();
                            MCChannel.this.mcChannelInfo.channelId = optString;
                            MCChannel.this.mcChannelInfo.serverTime = valueOf2.longValue();
                            ServerTimeEstimater.syncEstimaterByServerTime(currentTimeMillis, MCChannel.this.mcChannelInfo.serverTime);
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(C9556pm.TAG);
                            if (optJSONObject2 != null) {
                                MCChannel.this.mcChannelInfo.PMInfo.bizCode = optJSONObject2.optInt("bizCode");
                                MCChannel.this.mcChannelInfo.PMInfo.topic = optJSONObject2.optString("topic");
                                MCChannel.this.mcChannelInfo.PMInfo.msgFetchMode = optJSONObject2.optInt("msgFetchMode");
                                MCChannel.this.mcChannelInfo.PMInfo.isBanConnect = optJSONObject2.optJSONObject("banSub4Native").optBoolean("ban");
                            }
                            JSONObject optJSONObject3 = optJSONObject.optJSONObject(ConnType.PK_CDN);
                            if (optJSONObject3 != null) {
                                MCChannel.this.mcChannelInfo.CDNInfo.url = optJSONObject3.optString("url");
                                MCChannel.this.mcChannelInfo.CDNInfo.pullInterval = optJSONObject3.optInt(Constants.Name.INTERVAL);
                            }
                            JSONObject optJSONObject4 = optJSONObject.optJSONObject("accsMass");
                            if (optJSONObject4 != null) {
                                MCChannel.this.mcChannelInfo.MASSInfo.topic = optJSONObject4.optString("topic");
                                MCChannel.this.mcChannelInfo.MASSInfo.connectByMyself = optJSONObject4.isNull("connectByMyself") ? false : optJSONObject4.optBoolean("connectByMyself");
                            }
                            hashMap.put("isSuccess", "true");
                            UTEvent.record("getChannelInfo", hashMap);
                            MCChannel.this.initSession();
                            return;
                        }
                    }
                }
                MyLog.e(MCChannel.this.TAG, "InitSessionAfterGetChannelInfo fail! appId:", Long.valueOf(MCChannel.this.appId), " channelId:", MCChannel.this.channelId, " mtopResponse:", mtopResponse.toString());
                if (MCChannel.this.eventCallback != null) {
                    MCChannel.this.eventCallback.onEvent(MCChannelEvent.OPEN_FAIL, "Channel open fail.", null);
                }
                hashMap.put("isSuccess", "false");
                hashMap.put("errorCode", mtopResponse.getRetCode());
                hashMap.put("errorMsg", mtopResponse.getRetMsg());
                UTEvent.record("getChannelInfo", hashMap);
                UTEvent.record("openChannel", hashMap);
                AppMonitor.Alarm.commitFail(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "openChannelX", MCChannel.this.appMonitorOpenArg(false, mtopResponse.getRetMsg()), "1", mtopResponse.getRetMsg());
            }
        });
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2089918744")) {
            ipChange.ipc$dispatch("2089918744", new Object[]{this});
            return;
        }
        MCChannelState mCChannelState = this.mcChannelState;
        MCChannelState mCChannelState2 = MCChannelState.CLOSED;
        if (mCChannelState == mCChannelState2) {
            MyLog.e(this.TAG, "Channel is closed, don't repeat close.", appIdAndChannelString());
            IMCChannelEventCallback iMCChannelEventCallback = this.eventCallback;
            if (iMCChannelEventCallback != null) {
                iMCChannelEventCallback.onEvent(MCChannelEvent.CLOSE_FAIL, "Channel is closed, don't repeat close.", null);
            }
            HashMap hashMap = new HashMap(8);
            hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(this.appId));
            hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, this.channelId);
            hashMap.put("isSuccess", "false");
            hashMap.put("msg", "Channel is closed, don't repeat close.");
            UTEvent.record("closeChannel", hashMap);
            AppMonitor.Alarm.commitFail(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "closeChannelX", appMonitorCloseArg(false, "Channel is closed, don't repeat close."), "1", "Channel is closed, don't repeat close.");
            return;
        }
        MyLog.d(this.TAG, "Channel begin to close", appIdAndChannelString());
        this.closeStartTime = ServerTimeEstimater.estimateServerTimestamp();
        this.localCloseStartTime = System.currentTimeMillis();
        this.mcChannelState = mCChannelState2;
        MCSession mCSession = this.mcSession;
        if (mCSession != null) {
            mCSession.closeSession();
        }
        MCMessageDispatcher.unregisterDispatcher(this.appId, this.channelId);
    }

    public long getAppId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "981541832") ? ((Long) ipChange.ipc$dispatch("981541832", new Object[]{this})).longValue() : this.appId;
    }

    public String getChannelId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608284626") ? (String) ipChange.ipc$dispatch("-1608284626", new Object[]{this}) : this.channelId;
    }

    public void open(IMCChannelEventCallback iMCChannelEventCallback, IMCDispatchMsgCallback iMCDispatchMsgCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539748260")) {
            ipChange.ipc$dispatch("539748260", new Object[]{this, iMCChannelEventCallback, iMCDispatchMsgCallback});
            return;
        }
        MCChannelState mCChannelState = this.mcChannelState;
        MCChannelState mCChannelState2 = MCChannelState.OPENING;
        if (mCChannelState != mCChannelState2 && mCChannelState != MCChannelState.OPENED) {
            MyLog.d(this.TAG, "Channel begin to open", appIdAndChannelString());
            this.openStartTime = ServerTimeEstimater.estimateServerTimestamp();
            this.localOpenStartTime = System.currentTimeMillis();
            this.mcChannelState = mCChannelState2;
            this.eventCallback = iMCChannelEventCallback;
            MCMessageDispatcher.registerDispatcher(this.appId, this.channelId, iMCDispatchMsgCallback);
            if (this.mcChannelInfo != null) {
                initSession();
            } else {
                initSessionAfterGetChannelInfo();
            }
            MCMessageProcessor.getInstance();
            MCMessageReporter.getInstance();
            return;
        }
        MyLog.e(this.TAG, "Channel is opening or opened, don't repeat open.", appIdAndChannelString());
        if (iMCChannelEventCallback != null) {
            iMCChannelEventCallback.onEvent(MCChannelEvent.OPEN_FAIL, "Channel is opening or opened, don't repeat open.", null);
        }
        HashMap hashMap = new HashMap(8);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, String.valueOf(this.appId));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, this.channelId);
        hashMap.put("isSuccess", "false");
        hashMap.put("msg", "Channel is opening or opened, don't repeat open.");
        UTEvent.record("openChannel", hashMap);
        AppMonitor.Alarm.commitFail(MCMarkMessageManager.APP_MONITOR_MODULE_NAME, "openChannelX", appMonitorOpenArg(false, "Channel is opening or opened, don't repeat open."), "1", "Channel is opening or opened, don't repeat open.");
    }

    public void sendMsg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793721303")) {
            ipChange.ipc$dispatch("793721303", new Object[]{this});
        }
    }

    public MCChannel(@NonNull Context context, @NonNull MCChannelInfo mCChannelInfo) {
        this.context = context;
        this.appId = mCChannelInfo.appId;
        this.channelId = mCChannelInfo.channelId;
        this.mcChannelInfo = mCChannelInfo;
    }
}
