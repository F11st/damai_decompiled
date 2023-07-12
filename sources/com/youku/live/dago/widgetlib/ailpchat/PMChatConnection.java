package com.youku.live.dago.widgetlib.ailpchat;

import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.powermsg.common.IPowerMsgCallback;
import com.taobao.tao.powermsg.common.IPowerMsgDispatcher;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AnalyticsUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.ailpchat.IChatConnection;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.wt1;
import tb.xt1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PMChatConnection implements IChatConnection {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG;
    private boolean isForceDisConnect;
    private String mAppId;
    private int mBizCode;
    private String mFrom;
    private boolean mIsConnected;
    private IChatConnection.ConnectionListner mListener;
    private String mMTopKey;
    private IPowerMsgDispatcher mPowerMsgDispatcher;
    private String mTopicId;
    private List<IChatConnection.WeexMessageListener> mWeexListeners;

    public PMChatConnection() {
        this.TAG = "PMChatConnection";
        this.mBizCode = 13;
        this.mTopicId = "";
        this.mAppId = "";
        this.mMTopKey = "";
        this.mFrom = "youku-android";
        this.mIsConnected = false;
        this.isForceDisConnect = false;
        this.mPowerMsgDispatcher = new IPowerMsgDispatcher() { // from class: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
            /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
            @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onDispatch(tb.wt1 r24) {
                /*
                    Method dump skipped, instructions count: 459
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass1.onDispatch(tb.wt1):void");
            }

            @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
            public void onError(int i, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-146671587")) {
                    ipChange.ipc$dispatch("-146671587", new Object[]{this, Integer.valueOf(i), obj});
                }
            }
        };
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean connect(ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1676441291")) {
            return ((Boolean) ipChange.ipc$dispatch("-1676441291", new Object[]{this, iCallback})).booleanValue();
        }
        PMTopicIdManager.getInstance().notifySubscribe(this.mTopicId);
        int topicSubscribeCount = PMTopicIdManager.getInstance().getTopicSubscribeCount(this.mTopicId);
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "SUB topic , current topic Count = " + topicSubscribeCount);
        if (TextUtils.isEmpty(this.mTopicId)) {
            return false;
        }
        xt1.b(this.mBizCode, this.mPowerMsgDispatcher);
        xt1.e(this.mBizCode, this.mTopicId, 3);
        xt1.f(this.mBizCode, this.mTopicId, this.mFrom, new IPowerMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1021848918")) {
                    ipChange2.ipc$dispatch("-1021848918", new Object[]{this, Integer.valueOf(i), map, objArr});
                    return;
                }
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.put("code", Integer.valueOf(i));
                if (i == 1000) {
                    hashMap2.put("success", "1");
                    AnalyticsUtils.callbackSuccess(AnalyticsConstants.SPM_CHATROOM_SUBSCRIPTION);
                    PMChatConnection.this.mIsConnected = true;
                    ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "connection  success = " + PMChatConnection.this.mTopicId);
                    if (PMChatConnection.this.mListener != null) {
                        PMChatConnection.this.mListener.connectionStateChange(ConnectState.CONNECTED);
                    }
                } else {
                    hashMap2.put("success", "0");
                    AnalyticsUtils.callbackFail(AnalyticsConstants.SPM_CHATROOM_SUBSCRIPTION, String.valueOf(i));
                    ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "connection  failure code = " + i);
                    if (PMChatConnection.this.mListener != null) {
                        PMChatConnection.this.mListener.connectionStateChange(ConnectState.DISCONNECTED);
                    }
                }
                hashMap2.put("ban", "0");
                ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("ailp-chat", 19999, "subscribe", "", "", hashMap2);
            }
        }, new Object[0]);
        return false;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean disconnect(final ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493342813")) {
            return ((Boolean) ipChange.ipc$dispatch("1493342813", new Object[]{this, iCallback})).booleanValue();
        }
        PMTopicIdManager.getInstance().notifyUnsubscribe(this.mTopicId);
        int topicSubscribeCount = PMTopicIdManager.getInstance().getTopicSubscribeCount(this.mTopicId);
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "UNSUB topic , current topic Count = " + topicSubscribeCount);
        if (topicSubscribeCount > 0) {
            return false;
        }
        if (TextUtils.isEmpty(this.mTopicId)) {
            Log.d("PMChatConnection", "topic id is " + this.mTopicId + ", or mIsConected = " + this.mIsConnected);
            return false;
        }
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "connetction  disconnect TOPIC = " + this.mTopicId);
        xt1.h(this.mBizCode, this.mTopicId, this.mFrom, new IPowerMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map, Object... objArr) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1262389047")) {
                    ipChange2.ipc$dispatch("-1262389047", new Object[]{this, Integer.valueOf(i), map, objArr});
                    return;
                }
                CallbackObject callbackObject = new CallbackObject();
                callbackObject.topicId = PMChatConnection.this.mTopicId;
                HashMap hashMap = new HashMap();
                if (PMChatConnection.this.isForceDisConnect) {
                    hashMap.put("force", "1");
                } else {
                    hashMap.put("force", "0");
                }
                if (i == 1000) {
                    ICallback iCallback2 = iCallback;
                    if (iCallback2 != null) {
                        iCallback2.onSuccess(callbackObject);
                    }
                    Log.d("PMChatConnection", "disconnect success = " + PMChatConnection.this.mTopicId);
                    hashMap.put("success", "1");
                    PMChatConnection.this.mIsConnected = false;
                } else {
                    callbackObject.msg = "disconnect failure";
                    ICallback iCallback3 = iCallback;
                    if (iCallback3 != null) {
                        iCallback3.onFailure(i, callbackObject);
                    }
                    Log.d("PMChatConnection", "disconnect failure");
                    hashMap.put("success", "0");
                }
                ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("ailp-chat", 19999, "unsubscribe", "", "", hashMap);
            }
        }, new Object[0]);
        return true;
    }

    public boolean isConnected() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1760493341") ? ((Boolean) ipChange.ipc$dispatch("1760493341", new Object[]{this})).booleanValue() : this.mIsConnected;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429411074")) {
            ipChange.ipc$dispatch("1429411074", new Object[]{this});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2142451567")) {
            ipChange.ipc$dispatch("-2142451567", new Object[]{this});
            return;
        }
        Log.d("PMChatConnection", "release PM connection");
        this.mTopicId = "";
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
        if (AndroidInstantRuntime.support(ipChange, "-1285110459")) {
            ipChange.ipc$dispatch("-1285110459", new Object[]{this});
            return;
        }
        xt1.b(this.mBizCode, this.mPowerMsgDispatcher);
        xt1.e(this.mBizCode, this.mTopicId, 3);
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public boolean sendMessage(Map<String, Object> map, final IChatConnection.SendMessageCallback sendMessageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491723038")) {
            return ((Boolean) ipChange.ipc$dispatch("-491723038", new Object[]{this, map, sendMessageCallback})).booleanValue();
        }
        wt1 wt1Var = new wt1();
        wt1Var.d = "";
        String str = (String) map.get("data");
        if (!TextUtils.isEmpty(str)) {
            wt1Var.f = str.getBytes();
        }
        String str2 = (String) map.get("userId");
        wt1Var.a = ParseUtils.parse2Int((String) map.get("msgType"));
        wt1Var.c = 13;
        xt1.d(13, wt1Var, new IPowerMsgCallback() { // from class: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgCallback
            public void onResult(int i, Map<String, Object> map2, Object... objArr) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-781308789")) {
                    ipChange2.ipc$dispatch("-781308789", new Object[]{this, Integer.valueOf(i), map2, objArr});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("code", Integer.valueOf(i));
                if (i == 1000) {
                    ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "send msg success");
                    hashMap.put("msg", "success");
                    sendMessageCallback.onSuccess(hashMap);
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "send msg fail");
                hashMap.put("msg", "ailed, and check the error code");
                sendMessageCallback.onFail(hashMap);
            }
        }, new Object[0]);
        return false;
    }

    public void setAppId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108519678")) {
            ipChange.ipc$dispatch("-2108519678", new Object[]{this, str});
        } else {
            this.mAppId = str;
        }
    }

    public void setBizCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048328975")) {
            ipChange.ipc$dispatch("1048328975", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mBizCode = i;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void setConnectionListener(IChatConnection.ConnectionListner connectionListner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34102171")) {
            ipChange.ipc$dispatch("34102171", new Object[]{this, connectionListner});
        } else {
            this.mListener = connectionListner;
        }
    }

    public void setFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1731562006")) {
            ipChange.ipc$dispatch("1731562006", new Object[]{this, str});
        } else {
            this.mFrom = str;
        }
    }

    public void setMtopKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758321607")) {
            ipChange.ipc$dispatch("758321607", new Object[]{this, str});
        } else {
            this.mMTopKey = str;
        }
    }

    public void setTopicId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2103673740")) {
            ipChange.ipc$dispatch("-2103673740", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("PMChatConnection", "set topic , TOPIC = " + str);
        this.mTopicId = str;
    }

    @Override // com.youku.live.dago.widgetlib.ailpchat.IChatConnection
    public void setWeexMessageListener(List<IChatConnection.WeexMessageListener> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477813419")) {
            ipChange.ipc$dispatch("1477813419", new Object[]{this, list});
        } else {
            this.mWeexListeners = list;
        }
    }

    public PMChatConnection(String str, String str2, int i, IChatConnection.ConnectionListner connectionListner) {
        this.TAG = "PMChatConnection";
        this.mBizCode = 13;
        this.mTopicId = "";
        this.mAppId = "";
        this.mMTopKey = "";
        this.mFrom = "youku-android";
        this.mIsConnected = false;
        this.isForceDisConnect = false;
        this.mPowerMsgDispatcher = new IPowerMsgDispatcher() { // from class: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onDispatch(tb.wt1 r24) {
                /*
                    Method dump skipped, instructions count: 459
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass1.onDispatch(tb.wt1):void");
            }

            @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
            public void onError(int i2, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-146671587")) {
                    ipChange.ipc$dispatch("-146671587", new Object[]{this, Integer.valueOf(i2), obj});
                }
            }
        };
        this.mTopicId = str;
        this.mFrom = str2;
        this.mBizCode = i;
        this.mListener = connectionListner;
    }

    public PMChatConnection(String str, IChatConnection.ConnectionListner connectionListner) {
        this.TAG = "PMChatConnection";
        this.mBizCode = 13;
        this.mTopicId = "";
        this.mAppId = "";
        this.mMTopKey = "";
        this.mFrom = "youku-android";
        this.mIsConnected = false;
        this.isForceDisConnect = false;
        this.mPowerMsgDispatcher = new IPowerMsgDispatcher() { // from class: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onDispatch(tb.wt1 r24) {
                /*
                    Method dump skipped, instructions count: 459
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailpchat.PMChatConnection.AnonymousClass1.onDispatch(tb.wt1):void");
            }

            @Override // com.taobao.tao.powermsg.common.IPowerMsgDispatcher
            public void onError(int i2, Object obj) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-146671587")) {
                    ipChange.ipc$dispatch("-146671587", new Object[]{this, Integer.valueOf(i2), obj});
                }
            }
        };
        this.mTopicId = str;
        this.mListener = connectionListner;
    }
}
