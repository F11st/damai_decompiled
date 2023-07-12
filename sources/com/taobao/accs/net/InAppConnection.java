package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.C0162c;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.C0193a;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.C0227d;
import anet.channel.strategy.ConnProtocol;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.huawei.hms.opendevice.AbstractC5658c;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.data.Message;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.init.Launcher_InitAgooLifecycle;
import com.taobao.accs.ut.monitor.AccsForegroundMonitor;
import com.taobao.accs.ut.monitor.ConnectionMonitor;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.statistics.MonitorStatistic;
import com.taobao.accs.ut.statistics.ReceiveMsgStat;
import com.taobao.accs.utl.ABAdapter;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.C9708t9;
import tb.he;
import tb.sf0;
import tb.x6;
import tb.xa2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class InAppConnection extends BaseConnection implements DataFrameCb {
    private static final int RESEND_CONNECTED_DELAY = 0;
    private static final int RESEND_DELAY = 2000;
    private static final String TAG = "InAppConn_";
    public static long lastPingTimeMill;
    private ScheduledFuture accsHeartBeatFuture;
    private Runnable accsHeartBeatTask;
    private long accsHeartbeatInterval;
    private volatile boolean connected;
    private IHeartbeat heartbeatWrapper;
    private volatile boolean innerConnected;
    private boolean isErrorConnectionCommitted;
    private long lastCheckConnectTimeInMill;
    private boolean mRunning;
    private Set<String> mSessionRegistered;
    private Runnable mTryStartServiceRunable;
    private ISessionListener sessionListener;
    private SmartHeartbeatImpl smartHeartbeat;
    private ScheduledFuture wcTask;
    private static final Map<String, String> retryIdMap = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.net.InAppConnection.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 200;
        }
    };
    private static EventCb sessionEventCb = new EventCb() { // from class: com.taobao.accs.net.InAppConnection.12
        @Override // anet.channel.entity.EventCb
        public void onEvent(Session session, int i, sf0 sf0Var) {
            if (i == 128) {
                ALog.e(InAppConnection.TAG, "ping succ", new Object[0]);
                long unused = InAppConnection.lastReceiveTimeInMill = SystemClock.elapsedRealtime();
                InAppConnection.lastPingTimeMill = 0L;
            } else if (i == 2048) {
                ALog.e(InAppConnection.TAG, "ping timeout", new Object[0]);
            }
        }
    };
    private static long onForeTimeInMill = 0;
    private static long foreOnlineTotalTimesInMill = 0;
    private static long lastOnlineTimeInMill = 0;
    private static long lastReceiveTimeInMill = 0;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Auth implements IAuth {
        private String TAG;
        private String authUrl;
        private BaseConnection connection;
        private String host;

        public Auth(BaseConnection baseConnection, String str) {
            this.TAG = baseConnection.getTag();
            this.connection = baseConnection;
            this.host = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startAuthRequest(final Session session, final IAuth.AuthCallback authCallback) {
            if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
                if (session != null) {
                    session.b();
                }
                ALog.e(this.TAG, "current process is not allowed to startAuthRequest", new Object[0]);
                return;
            }
            this.connection.start();
            final ConnectionMonitor connectionMonitor = new ConnectionMonitor();
            connectionMonitor.startAuth();
            BaseConnection baseConnection = this.connection;
            this.authUrl = baseConnection.buildAuthUrl("https://" + this.host + "/accs/");
            if (OrangeAdapter.isChannelModeEnable()) {
                StringBuilder sb = new StringBuilder();
                String str = this.authUrl;
                sb.append(str.substring(0, str.indexOf("&21=")));
                sb.append("&21=");
                sb.append(BaseConnection.state);
                this.authUrl = sb.toString();
            }
            ALog.e(this.TAG, "auth", "utdid", UtilityImpl.getDeviceId(this.connection.mContext), "hash", Integer.valueOf(hashCode()), "URL", this.authUrl);
            connectionMonitor.authUrlGenerated();
            final int i = BaseConnection.state;
            final C0193a J = new C0193a.C0195b().Z(this.authUrl).J();
            session.w(J, new RequestCb() { // from class: com.taobao.accs.net.InAppConnection.Auth.2
                @Override // anet.channel.RequestCb
                public void onDataReceive(he heVar, boolean z) {
                }

                @Override // anet.channel.RequestCb
                public void onFinish(int i2, String str2, RequestStatistic requestStatistic) {
                    if (i2 < 0) {
                        ALog.e(Auth.this.TAG, "auth onFinish", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2));
                        authCallback.onAuthFail(i2, "onFinish auth fail");
                    }
                }

                @Override // anet.channel.RequestCb
                public void onResponseCode(int i2, Map<String, List<String>> map) {
                    ALog.e(Auth.this.TAG, "auth", "httpStatusCode", Integer.valueOf(i2));
                    if (i2 == 200) {
                        ConnectionMonitor connectionMonitor2 = connectionMonitor;
                        RequestStatistic requestStatistic = J.r;
                        connectionMonitor2.authFinish(requestStatistic == null ? 0L : requestStatistic.serverRT);
                        x6.b().commitStat(connectionMonitor);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FAKE_CONN, "auth", 0.0d);
                        authCallback.onAuthSuccess();
                        if (OrangeAdapter.isChannelModeEnable()) {
                            int i3 = i;
                            int i4 = BaseConnection.state;
                            if ((i3 == i4 && i4 == 0) && (Auth.this.connection instanceof InAppConnection)) {
                                ((InAppConnection) Auth.this.connection).setSendBackState(true);
                            }
                        }
                        if (Auth.this.connection instanceof InAppConnection) {
                            ((InAppConnection) Auth.this.connection).startAccsHeartBeat();
                        }
                        session.v(2176, InAppConnection.sessionEventCb);
                    } else {
                        authCallback.onAuthFail(i2, "auth fail");
                    }
                    Map<String, String> header = UtilityImpl.getHeader(map);
                    ALog.d(Auth.this.TAG, "auth", "header", header);
                    String str2 = header.get("x-at");
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    Auth.this.connection.mConnToken = str2;
                }
            });
        }

        @Override // anet.channel.IAuth
        public void auth(final Session session, final IAuth.AuthCallback authCallback) {
            if (OrangeAdapter.isRegIdSwitchEnable(this.connection.mContext) && OrangeAdapter.isRegIdNotExists(this.connection.mContext)) {
                BaseConnection baseConnection = this.connection;
                session.w(new C0193a.C0195b().Z(baseConnection.buildCreateRegIdUrl("https://" + this.host + "/")).J(), new RequestCb() { // from class: com.taobao.accs.net.InAppConnection.Auth.1
                    @Override // anet.channel.RequestCb
                    public void onDataReceive(he heVar, boolean z) {
                    }

                    @Override // anet.channel.RequestCb
                    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
                    }

                    @Override // anet.channel.RequestCb
                    public void onResponseCode(int i, Map<String, List<String>> map) {
                        ALog.e(Auth.this.TAG, "getRegId resp", "httpStatusCode", Integer.valueOf(i));
                        String str = null;
                        try {
                            if (i == 200) {
                                try {
                                    Map<String, String> header = UtilityImpl.getHeader(map);
                                    if (OrangeAdapter.isRegIdNotExists(Auth.this.connection.mContext)) {
                                        str = header.get(Constants.KEY_X_REGID);
                                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_ONLINE, "get regId by online", 0.0d);
                                    }
                                } catch (Exception e) {
                                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_EXCEPTION, "get regId exception: " + e.getMessage(), 0.0d);
                                    ALog.e(Auth.this.TAG, "get regId error", e, new Object[0]);
                                }
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = UtilityImpl.createRegId();
                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_NATIVE, "get regId by native", 0.0d);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                synchronized (InAppConnection.class) {
                                    if (OrangeAdapter.isRegIdNotExists(Auth.this.connection.mContext)) {
                                        OrangeAdapter.saveRegId(Auth.this.connection.mContext, str);
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(str) && !OrangeAdapter.isChannelModeEnable() && UtilityImpl.isMainProcess(Auth.this.connection.mContext) && UtilityImpl.isChannelProcessAlive(Auth.this.connection.mContext)) {
                                try {
                                    ALog.e(Auth.this.TAG, "start channel service for reset regId", new Object[0]);
                                    Intent intent = new Intent(Constants.ACTION_RESET_REG_ID);
                                    intent.putExtra("regId", str);
                                    intent.setClassName(GlobalClientInfo.getContext().getPackageName(), AdapterUtilityImpl.channelService);
                                    IntentDispatch.dispatchIntent(GlobalClientInfo.getContext(), intent);
                                } catch (Exception e2) {
                                    ALog.e(Auth.this.TAG, "reset channel regId error", e2, new Object[0]);
                                }
                            }
                        } finally {
                            Auth.this.startAuthRequest(session, authCallback);
                        }
                    }
                });
                return;
            }
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_REGID_DISABLE, "regId disable", 0.0d);
            startAuthRequest(session, authCallback);
        }
    }

    public InAppConnection(Context context, int i, String str) {
        super(context, i, str);
        this.mRunning = true;
        this.accsHeartbeatInterval = DateUtils.MILLIS_PER_HOUR;
        this.connected = true;
        this.innerConnected = false;
        this.accsHeartBeatTask = new Runnable() { // from class: com.taobao.accs.net.InAppConnection.2
            @Override // java.lang.Runnable
            public void run() {
                ALog.d(InAppConnection.this.getTag(), "sendAccsHeartbeatMessage", new Object[0]);
                try {
                    ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, new JsonUtility.JsonObjectBuilder().put(MtopJSBridge.MtopJSParam.DATA_TYPE, "pingreq").put("timeInterval", Long.valueOf(InAppConnection.this.accsHeartbeatInterval)).build().toString().getBytes("utf-8"), UUID.randomUUID().toString());
                    accsRequest.setTarget("accs-iot");
                    accsRequest.setTargetServiceName("sal");
                    InAppConnection inAppConnection = InAppConnection.this;
                    InAppConnection.this.sendMessage(Message.buildRequest(inAppConnection.mContext, inAppConnection.getHost(null), InAppConnection.this.getTag(), InAppConnection.this.mConfig.getStoreId(), InAppConnection.this.mContext.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
                } catch (Exception e) {
                    ALog.e(InAppConnection.this.getTag(), "send accs heartbeat message", e, new Object[0]);
                }
            }
        };
        this.sessionListener = new ISessionListener() { // from class: com.taobao.accs.net.InAppConnection.3
            private void innerConnChanged(Context context2, boolean z) {
                if (z) {
                    C9708t9.U(10000);
                    long unused = InAppConnection.lastReceiveTimeInMill = InAppConnection.lastOnlineTimeInMill = SystemClock.elapsedRealtime();
                    Collection<Message> unhandledMessages = InAppConnection.this.mMessageHandler.getUnhandledMessages();
                    List<String> upRetryServiceIds = OrangeAdapter.getUpRetryServiceIds(context2);
                    if (unhandledMessages != null && upRetryServiceIds != null && !upRetryServiceIds.isEmpty()) {
                        for (Message message : unhandledMessages) {
                            if (!message.isAck && !message.isTimeOut()) {
                                String str2 = message.serviceId;
                                if (!TextUtils.isEmpty(str2) && upRetryServiceIds.contains(str2) && !InAppConnection.retryIdMap.containsKey(message.getDataId()) && SystemClock.elapsedRealtime() - message.getSendTime() >= 3000) {
                                    InAppConnection.this.reSend(message, 0);
                                    InAppConnection.retryIdMap.put(message.getDataId(), null);
                                }
                            }
                        }
                    }
                } else {
                    InAppConnection.foreOnlineTotalTimesInMill += InAppConnection.lastReceiveTimeInMill - InAppConnection.lastOnlineTimeInMill;
                    long unused2 = InAppConnection.lastReceiveTimeInMill = InAppConnection.lastOnlineTimeInMill = 0L;
                }
                if (z && UtilityImpl.isMainProcess(context2)) {
                    Launcher_InitAgooLifecycle.monitorConnected();
                }
            }

            private void onConnectionChangedImpl(Context context2, boolean z, Intent intent) {
                boolean z2 = true;
                if (OrangeAdapter.isChannelModeEnable() && UtilityImpl.isMainProcessAlive(InAppConnection.this.mContext) && !C9708t9.L()) {
                    C9708t9.z0(true);
                } else {
                    z2 = false;
                }
                innerConnChanged(context2, z);
                String stringExtra = intent.getStringExtra("host");
                int intExtra = intent.getIntExtra("errorCode", -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                TaoBaseService.ConnectInfo connectInfo = z ? new TaoBaseService.ConnectInfo(stringExtra, booleanExtra, booleanExtra2) : new TaoBaseService.ConnectInfo(stringExtra, booleanExtra, booleanExtra2, intExtra, stringExtra2);
                connectInfo.connected = z;
                InAppConnection.this.notifyConnectionChanged2Main(context2, z);
                if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
                    InAppConnection.this.notifyConnectionChangedListener(connectInfo, z2);
                    return;
                }
                ALog.e(InAppConnection.this.getTag(), "onConnectionChanged not allow to notify", new Object[0]);
                C0162c.m(InAppConnection.this.mConfig.getAppKey()).E(InAppConnection.this.sessionListener);
            }

            @Override // anet.channel.ISessionListener
            public void onConnectionChanged(Intent intent) {
                if (intent == null) {
                    ALog.e(InAppConnection.this.getTag(), "onConnectionChanged", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "null");
                    return;
                }
                Context context2 = GlobalClientInfo.getContext();
                boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                String stringExtra = intent.getStringExtra("host");
                String tag = InAppConnection.this.getTag();
                ALog.e(tag, "onConnectionChanged", "currentHost", "https://" + InAppConnection.this.mConfig.getInappHost(), "changeHost", stringExtra, "state", Boolean.valueOf(booleanExtra), "process", IPCUtils.getCurrentProcessName(), "hash", Integer.valueOf(InAppConnection.this.hashCode()));
                if (("https://" + InAppConnection.this.mConfig.getInappHost()).equals(stringExtra)) {
                    InAppConnection inAppConnection = InAppConnection.this;
                    inAppConnection.innerConnected = inAppConnection.connected = booleanExtra;
                    HeartbeatManager.getInstance(context2).set();
                    InAppConnection.this.monitorFakeConn();
                    InAppConnection.this.monitorWrongConn(booleanExtra);
                    onConnectionChangedImpl(context2, booleanExtra, intent);
                }
            }
        };
        this.isErrorConnectionCommitted = false;
        this.wcTask = null;
        this.mTryStartServiceRunable = new Runnable() { // from class: com.taobao.accs.net.InAppConnection.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InAppConnection inAppConnection = InAppConnection.this;
                    if (inAppConnection.mContext == null || TextUtils.isEmpty(inAppConnection.getAppkey())) {
                        return;
                    }
                    ALog.i(InAppConnection.this.getTag(), "mTryStartServiceRunable bindapp", new Object[0]);
                    InAppConnection.this.startChannelService();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.mSessionRegistered = Collections.synchronizedSet(new HashSet());
        this.heartbeatWrapper = new IHeartbeat() { // from class: com.taobao.accs.net.InAppConnection.11
            @Override // anet.channel.heartbeat.IHeartbeat
            public void reSchedule() {
            }

            @Override // anet.channel.heartbeat.IHeartbeat
            public void start(Session session) {
                if (InAppConnection.this.smartHeartbeat != null) {
                    InAppConnection.this.smartHeartbeat.start(session);
                }
            }

            @Override // anet.channel.heartbeat.IHeartbeat
            public void stop() {
                if (InAppConnection.this.smartHeartbeat != null) {
                    InAppConnection.this.smartHeartbeat.stop();
                }
            }
        };
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.mTryStartServiceRunable, 120000L, TimeUnit.MILLISECONDS);
    }

    private boolean checkCurProcessIsAllowed2SendMessage(Message message, boolean z) {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            if (UtilityImpl.isChannelProcess(this.mContext)) {
                ALog.e(getTag(), "send in main", new Object[0]);
                Intent intent = new Intent(Constants.ACTION_SENDMESSAGE_INMAIN);
                intent.setClassName(this.mContext.getPackageName(), AdapterUtilityImpl.msgService);
                intent.putExtra(WXComponent.PROP_FS_MATCH_PARENT, message);
                intent.putExtra(AbstractC5658c.a, z);
                IntentDispatch.dispatchIntent(this.mContext, intent);
                return false;
            } else if (UtilityImpl.isMainProcess(this.mContext)) {
                ConnectionServiceManager connectionServiceManager = ConnectionServiceManager.getInstance();
                if (!connectionServiceManager.isProxyConnection() && connectionServiceManager.isAllWeather()) {
                    ALog.e(getTag(), "force-proxy conn", new Object[0]);
                    connectionServiceManager.onChannelConnectionChanged(true);
                }
                try {
                    ALog.e(getTag(), "send in channel", new Object[0]);
                    connectionServiceManager.getConnectionWrapper().send(message, z);
                    return false;
                } catch (IPCException unused) {
                    String tag = getTag();
                    ALog.e(tag, "not running or msg null! " + this.mRunning, new Object[0]);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorFakeConn() {
        if (this.connected || BaseConnection.state != 1 || !UtilityImpl.isNetworkConnected(this.mContext) || lastPingTimeMill <= 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - lastPingTimeMill;
        if (elapsedRealtime < 10000 || elapsedRealtime > 11000) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MonitorItemConstants.WS_MONITOR_TITLE_CONN);
        sb.append(ConnectionServiceManager.getInstance().isAllWeather() ? "_aw" : "");
        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FAKE_CONN, sb.toString(), 0.0d);
        ALog.e(getTag(), "fake connection", "isAllWeather", Boolean.valueOf(ConnectionServiceManager.getInstance().isAllWeather()));
    }

    private void monitorForegroundOnline(boolean z) {
        if (z) {
            onForeTimeInMill = SystemClock.elapsedRealtime();
            long j = this.innerConnected ? onForeTimeInMill : 0L;
            lastOnlineTimeInMill = j;
            lastReceiveTimeInMill = j;
        } else if (onForeTimeInMill > 0) {
            foreOnlineTotalTimesInMill += lastReceiveTimeInMill - lastOnlineTimeInMill;
            AccsForegroundMonitor accsForegroundMonitor = new AccsForegroundMonitor();
            accsForegroundMonitor.aliveTime = SystemClock.elapsedRealtime() - onForeTimeInMill;
            accsForegroundMonitor.onlineTime = foreOnlineTotalTimesInMill;
            x6.b().commitStat(accsForegroundMonitor);
            onForeTimeInMill = 0L;
            foreOnlineTotalTimesInMill = 0L;
            lastOnlineTimeInMill = 0L;
            lastReceiveTimeInMill = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorWrongConn(boolean z) {
        if (this.isErrorConnectionCommitted) {
            return;
        }
        if (!z) {
            try {
                if (ForeBackManager.getManager().getState() != 0) {
                    if (UtilityImpl.isNetworkConnected(GlobalClientInfo.getContext())) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (this.lastCheckConnectTimeInMill == 0) {
                            this.lastCheckConnectTimeInMill = elapsedRealtime;
                            this.wcTask = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.net.InAppConnection.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!InAppConnection.this.mRunning || InAppConnection.this.isConnected() || InAppConnection.this.lastCheckConnectTimeInMill <= 0 || SystemClock.elapsedRealtime() - InAppConnection.this.lastCheckConnectTimeInMill <= 12000) {
                                        return;
                                    }
                                    ALog.e(InAppConnection.TAG, "connection error ", new Object[0]);
                                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_FAKE_CONN, BaseMonitor.ARG_NET_FINE_NO_CONNECT, 0.0d);
                                    InAppConnection.this.isErrorConnectionCommitted = true;
                                }
                            }, 10L, TimeUnit.SECONDS);
                        }
                    }
                }
            } catch (Exception e) {
                ALog.e(getTag(), "monitorWrongConn error", e, new Object[0]);
                return;
            }
        }
        this.lastCheckConnectTimeInMill = 0L;
        ScheduledFuture scheduledFuture = this.wcTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.wcTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionChanged2Main(Context context, boolean z) {
        if (UtilityImpl.isChannelProcess(context) && UtilityImpl.isMainProcessAlive(context)) {
            ALog.e(getTag(), "notifyConnectionChanged2Main", new Object[0]);
            Intent intent = new Intent(Constants.ACTION_CHANNEL_CONNECTION_CHANGED);
            intent.setClassName(context.getPackageName(), AdapterUtilityImpl.msgService);
            intent.putExtra(AbstractC5658c.a, z);
            IntentDispatch.dispatchIntent(context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConnectionChangedListener(TaoBaseService.ConnectInfo connectInfo, boolean z) {
        Iterator<AccsConnectStateListener> it = getAccsConnectStateListenerArrayList().iterator();
        while (it.hasNext()) {
            AccsConnectStateListener next = it.next();
            try {
                if (connectInfo.connected) {
                    next.onConnected(connectInfo);
                } else {
                    next.onDisconnected(connectInfo);
                }
            } catch (Exception e) {
                ALog.e(getTag(), "onConnectionChanged callback error", e, new Object[0]);
            }
        }
        if (z) {
            ALog.d(TAG, "handBroadCastMsg ACTION_CONNECT_INFO in sessionListener", connectInfo);
            Intent intent = new Intent(Constants.ACTION_CONNECT_INFO);
            intent.setPackage(this.mContext.getPackageName());
            intent.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
            this.mContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAccsHeartBeat() {
        if (this.mConfig.isAccsHeartbeatEnable()) {
            ALog.e(getTag(), "startAccsHeartBeat", new Object[0]);
            ScheduledFuture scheduledFuture = this.accsHeartBeatFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.accsHeartBeatTask;
            long j = this.accsHeartbeatInterval;
            this.accsHeartBeatFuture = scheduledExecutor.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean cancel(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.mMessageHandler.reqTasks.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            ALog.e(getTag(), "cancel", "customDataId", str);
        }
        return cancel;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void close() {
        ALog.e(getTag(), "close", new Object[0]);
        try {
            if (ConnectionServiceManager.getInstance().isEnabled(this.mContext)) {
                C0162c.m(this.mConfig.getAppKey()).E(this.sessionListener);
            }
        } catch (Exception e) {
            ALog.e(getTag(), "close error", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public int getChannelState() {
        return 1;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public String getTag() {
        return TAG + this.mConfigTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public void initAwcn(Context context) {
        boolean z;
        try {
            if (this.mAwcnInited) {
                return;
            }
            super.initAwcn(context);
            if (OrangeAdapter.isChannelModeEnable() && !UtilityImpl.isMainProcessAlive(context)) {
                C9708t9.z0(false);
            }
            ALog.e(getTag(), "register accs session listener", new Object[0]);
            C0162c.m(this.mConfig.getAppKey()).A(this.sessionListener);
            String inappHost = this.mConfig.getInappHost();
            if (isKeepAlive() && this.mConfig.isKeepalive()) {
                z = true;
            } else {
                ALog.d(getTag(), "initAwcn close keepalive", new Object[0]);
                z = false;
            }
            if ((OrangeAdapter.isChannelModeEnable() && !UtilityImpl.isMainProcess(context)) || ConnectionServiceManager.getInstance().isAllWeather()) {
                ALog.e(getTag(), "AwcnConfig.setAccsSessionCreateForbiddenInBg(false)", new Object[0]);
                C9708t9.V(false);
            }
            registerSessionInfo(C0162c.m(this.mConfig.getAppKey()), inappHost, z);
            this.mAwcnInited = true;
            ALog.e(getTag(), "initAwcn success!", new Object[0]);
        } catch (Throwable th) {
            ALog.e(getTag(), "initAwcn", th, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean isAlive() {
        return this.mRunning;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean isConnected() {
        ALog.e(TAG, "isConnected", "state", Boolean.valueOf(this.connected));
        return this.connected;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void notifyNetWorkChange(String str) {
        this.mTimeoutMsgNum = 0;
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(final TnetSpdySession tnetSpdySession, final byte[] bArr, final int i, final int i2) {
        SmartHeartbeatImpl smartHeartbeatImpl;
        if (ALog.isPrintLog(ALog.Level.E)) {
            ALog.e(getTag(), "onDataReceive", "type", Integer.valueOf(i2), "dataid", Integer.valueOf(i));
        }
        if (ABAdapter.isFeatureOpened(Constants.AB.KEY_ACCS_HEARTBEAT) && (smartHeartbeatImpl = this.smartHeartbeat) != null) {
            smartHeartbeatImpl.reSchedule();
        }
        lastReceiveTimeInMill = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.net.InAppConnection.8
            @Override // java.lang.Runnable
            public void run() {
                if (i2 == 200) {
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ALog.e(InAppConnection.this.getTag(), "onDataScheduled", "dataid", Integer.valueOf(i));
                        InAppConnection.this.mMessageHandler.onMessage(bArr, tnetSpdySession.h(), currentTimeMillis);
                        ReceiveMsgStat receiveMsgStat = InAppConnection.this.mMessageHandler.getReceiveMsgStat();
                        if (receiveMsgStat != null) {
                            receiveMsgStat.receiveDate = String.valueOf(currentTimeMillis2);
                            receiveMsgStat.messageType = InAppConnection.this.mConnectionType == 0 ? "service" : "inapp";
                            receiveMsgStat.commitUT();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        ALog.e(InAppConnection.this.getTag(), "onDataReceive ", th, new Object[0]);
                        UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.getStackMsg(th));
                        return;
                    }
                }
                String tag = InAppConnection.this.getTag();
                ALog.e(tag, "drop frame len:" + bArr.length + " frameType" + i2, new Object[0]);
            }
        });
    }

    @Override // anet.channel.DataFrameCb
    public void onException(final int i, final int i2, final boolean z, String str) {
        String tag = getTag();
        ALog.e(tag, "errorId:" + i2 + "detail:" + str + " dataId:" + i + " needRetry:" + z, new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.net.InAppConnection.9
            @Override // java.lang.Runnable
            public void run() {
                Message removeUnhandledMessage;
                int i3 = i;
                if (i3 > 0) {
                    Message.Id id = new Message.Id(i3, "");
                    Message.Id id2 = null;
                    Iterator<Message.Id> it = InAppConnection.this.mMessageHandler.getUnhandledMessageIds().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Message.Id next = it.next();
                        if (next.equals(id)) {
                            id2 = next;
                            break;
                        }
                    }
                    if (id2 != null && (removeUnhandledMessage = InAppConnection.this.mMessageHandler.removeUnhandledMessage(id2.getDataId())) != null) {
                        if (z) {
                            if (!InAppConnection.this.reSend(removeUnhandledMessage, 2000)) {
                                InAppConnection.this.mMessageHandler.onResult(removeUnhandledMessage, i2);
                            }
                            if (removeUnhandledMessage.getNetPermanceMonitor() != null) {
                                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                            }
                        } else {
                            InAppConnection.this.mMessageHandler.onResult(removeUnhandledMessage, i2);
                        }
                    }
                }
                int i4 = i;
                if (i4 >= 0 || !z) {
                    return;
                }
                InAppConnection.this.reSendAck(i4);
            }
        });
    }

    public void onReceiveAccsHeartbeatResp(JSONObject jSONObject) {
        if (jSONObject == null) {
            ALog.e(getTag(), "onReceiveAccsHeartbeatResp response data is null", new Object[0]);
            return;
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(getTag(), "onReceiveAccsHeartbeatResp", "data", jSONObject);
        }
        try {
            int i = jSONObject.getInt("timeInterval");
            if (i == -1) {
                ScheduledFuture scheduledFuture = this.accsHeartBeatFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    return;
                }
                return;
            }
            long j = i * 1000;
            if (this.accsHeartbeatInterval != j) {
                if (i == 0) {
                    j = DateUtils.MILLIS_PER_HOUR;
                }
                this.accsHeartbeatInterval = j;
                ScheduledFuture scheduledFuture2 = this.accsHeartBeatFuture;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                }
                ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
                Runnable runnable = this.accsHeartBeatTask;
                long j2 = this.accsHeartbeatInterval;
                this.accsHeartBeatFuture = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
            }
        } catch (JSONException e) {
            ALog.e(getTag(), "onReceiveAccsHeartbeatResp", "e", e.getMessage());
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void onTimeOut(String str, boolean z, String str2) {
        Session session;
        try {
            Message removeUnhandledMessage = this.mMessageHandler.removeUnhandledMessage(str);
            if (removeUnhandledMessage != null && removeUnhandledMessage.host != null && (session = AccsSessionCenter.get(C0162c.m(this.mConfig.getAppKey()), removeUnhandledMessage.host.toString(), 0L)) != null) {
                if (z) {
                    ALog.e(getTag(), "close session by time out", new Object[0]);
                    session.c(true);
                } else {
                    session.t(true);
                }
            }
        } catch (Exception e) {
            ALog.e(getTag(), "onTimeOut", e, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void ping(boolean z, boolean z2) {
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.net.InAppConnection.7
            @Override // java.lang.Runnable
            public void run() {
                if (InAppConnection.this.mAwcnInited) {
                    try {
                        String inappHost = ABAdapter.isFeatureOpened(Constants.AB.KEY_INAPP_PING) ? InAppConnection.this.mConfig.getInappHost() : InAppConnection.this.getHost(null);
                        InAppConnection inAppConnection = InAppConnection.this;
                        inAppConnection.registerSessionInfo(C0162c.m(inAppConnection.mConfig.getAppKey()), inappHost, InAppConnection.this.mConfig.isKeepalive());
                        Session session = AccsSessionCenter.get(C0162c.m(InAppConnection.this.mConfig.getAppKey()), InAppConnection.this.getHost(null), ConnType.TypeLevel.SPDY, 0L);
                        if (session != null) {
                            ALog.e(InAppConnection.this.getTag(), "try session ping", new Object[0]);
                            int pingTimeout = InAppConnection.this.mConfig.getPingTimeout();
                            if (pingTimeout > 0) {
                                session.u(true, pingTimeout);
                            } else {
                                session.t(true);
                            }
                        }
                    } catch (Exception e) {
                        ALog.e(InAppConnection.this.getTag(), "ping error", e, new Object[0]);
                    }
                }
            }
        });
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void reConnect() {
        try {
            if (isConnected()) {
                Session session = AccsSessionCenter.get(C0162c.m(this.mConfig.getAppKey()), getHost(null), 0L);
                ALog.e(getTag(), "reConnecting", "appkey", this.mConfig.getAppKey(), "host", this.mConfig.getInappHost(), Preloader.KEY_SESSION, session);
                if (session != null) {
                    C9708t9.U(0);
                    session.c(true);
                }
            }
        } catch (Exception e) {
            ALog.e(getTag(), "reConnect error", e, new Object[0]);
        }
    }

    public void registerSessionInfo(C0162c c0162c, String str, boolean z) {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            ALog.e(getTag(), "current process is not allowed to connect", new Object[0]);
        } else if (this.mSessionRegistered.contains(str)) {
        } else {
            if (OrangeAdapter.isChannelModeEnable()) {
                if (this.smartHeartbeat == null) {
                    this.smartHeartbeat = new SmartHeartbeatImpl(this, BaseConnection.state);
                }
            } else {
                this.smartHeartbeat = null;
            }
            c0162c.C(xa2.a(str, z, true, new Auth(this, str), ABAdapter.isFeatureOpened(Constants.AB.KEY_ACCS_HEARTBEAT) ? this.heartbeatWrapper : this.smartHeartbeat, this));
            c0162c.B(str, this.mConfig.getInappPubKey());
            this.mSessionRegistered.add(str);
            ALog.i(getTag(), "registerSessionInfo", "host", str);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void sendMessage(final Message message, boolean z) {
        if (checkCurProcessIsAllowed2SendMessage(message, z)) {
            if (this.mRunning && message != null) {
                start();
                try {
                    if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                        if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(message.serviceId)) {
                            ALog.e(getTag(), "sendMessage schedule", Constants.KEY_DATA_ID, message.getDataId());
                        }
                        ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.net.InAppConnection.5
                            /* JADX WARN: Removed duplicated region for block: B:64:0x0235  */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public void run() {
                                /*
                                    Method dump skipped, instructions count: 773
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.InAppConnection.AnonymousClass5.run():void");
                            }
                        }, message.delyTime, TimeUnit.MILLISECONDS);
                        if (message.getType() == 1 && message.cunstomDataId != null) {
                            if (message.isControlFrame() && cancel(message.cunstomDataId)) {
                                this.mMessageHandler.cancelControlMessage(message);
                            }
                            this.mMessageHandler.reqTasks.put(message.cunstomDataId, schedule);
                        }
                        NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                        if (netPermanceMonitor != null) {
                            netPermanceMonitor.setConnType(this.mConnectionType);
                            netPermanceMonitor.onEnterQueueData();
                            return;
                        }
                        return;
                    }
                    throw new RejectedExecutionException("accs");
                } catch (RejectedExecutionException unused) {
                    this.mMessageHandler.onResult(message, 70008);
                    String tag = getTag();
                    ALog.e(tag, "send queue full count:" + ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size(), new Object[0]);
                    return;
                } catch (Throwable th) {
                    this.mMessageHandler.onResult(message, -8);
                    ALog.e(getTag(), "send error", th, new Object[0]);
                    return;
                }
            }
            String tag2 = getTag();
            ALog.e(tag2, "not running or msg null! " + this.mRunning, new Object[0]);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void setForeBackState(int i) {
        String tag = getTag();
        Object[] objArr = new Object[4];
        objArr[0] = "state";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = "smartHeartbeat";
        objArr[3] = Boolean.valueOf(this.smartHeartbeat != null);
        ALog.e(tag, "setForeBackStateInApp", objArr);
        super.setForeBackState(i);
        SmartHeartbeatImpl smartHeartbeatImpl = this.smartHeartbeat;
        if (smartHeartbeatImpl != null) {
            smartHeartbeatImpl.setState(i);
        }
        setSendBackState(i == 0);
        monitorForegroundOnline(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public void setTimeOut(final String str, final boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.net.InAppConnection.6
            @Override // java.lang.Runnable
            public void run() {
                Message unhandledMessage = InAppConnection.this.mMessageHandler.getUnhandledMessage(str);
                if (unhandledMessage != null) {
                    InAppConnection.this.mMessageHandler.onResult(unhandledMessage, -9);
                    InAppConnection.this.onTimeOut(str, z, "receive data time out");
                    String tag = InAppConnection.this.getTag();
                    ALog.e(tag, str + "-> receive data time out!", new Object[0]);
                }
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void shutdown() {
        ALog.e(getTag(), "shut down", new Object[0]);
        this.mRunning = false;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public synchronized void start() {
        ALog.e(getTag(), "start", new Object[0]);
        if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            this.mRunning = true;
            initAwcn(this.mContext);
        }
    }

    public void unRegisterSessionInfo() {
        String inappHost = this.mConfig.getInappHost();
        C0162c m = C0162c.m(this.mConfig.getAppKey());
        if (m == null) {
            ALog.w(getTag(), "updateConfig not need update", new Object[0]);
            return;
        }
        m.F(inappHost);
        ALog.w(getTag(), "updateConfig unregisterSessionInfo", "host", inappHost);
        if (this.mSessionRegistered.contains(inappHost)) {
            this.mSessionRegistered.remove(inappHost);
            ALog.w(getTag(), "updateConfig removeSessionRegistered", "oldHost", inappHost);
        }
    }

    public void updateConfig(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(getTag(), "updateConfig null", new Object[0]);
        } else if (accsClientConfig.equals(this.mConfig)) {
            ALog.w(getTag(), "updateConfig not any changed", new Object[0]);
        } else {
            boolean z = true;
            if (!AdapterUtilityImpl.isTaobao(this.mContext)) {
                boolean isRegidEnable = accsClientConfig.isRegidEnable();
                boolean isChannelModeEnable = accsClientConfig.isChannelModeEnable();
                ALog.e(TAG, "updateAppConfig", "regidEnable", Boolean.valueOf(isRegidEnable), "channelModeEnable", Boolean.valueOf(isChannelModeEnable));
                APreferencesManager.getSharedPreferences(this.mContext, Constants.SP_FILE_NAME, 4).edit().putBoolean(Constants.SP_KEY_REG_ID_ENABLE, isRegidEnable).putBoolean(Constants.SP_KEY_GLOBAL_CHANNEL_ENABLE, isChannelModeEnable).apply();
            }
            if (!this.mAwcnInited) {
                if (OrangeAdapter.isChannelModeEnable() || UtilityImpl.isMainProcess(this.mContext)) {
                    this.mConfig = accsClientConfig;
                    initAwcn(this.mContext);
                    return;
                }
                return;
            }
            try {
                ALog.w(getTag(), "updateConfig", "old", this.mConfig, "new", accsClientConfig);
                String inappHost = accsClientConfig.getInappHost();
                C0162c m = C0162c.m(this.mConfig.getAppKey());
                if (m == null) {
                    ALog.w(getTag(), "updateConfig not need update", new Object[0]);
                    return;
                }
                unRegisterSessionInfo();
                this.mConfig = accsClientConfig;
                if (!TextUtils.isEmpty(this.mAppkey) && !this.mAppkey.equals(this.mConfig.getAppKey())) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_APPKEY_CHANGED, "", 0.0d);
                }
                this.mAppkey = this.mConfig.getAppKey();
                this.mConfigTag = this.mConfig.getTag();
                String str = ConnType.PK_ACS;
                str = (this.mConfig.getInappPubKey() == 10 || this.mConfig.getInappPubKey() == 11) ? "open" : "open";
                ALog.i(getTag(), "update config register new conn protocol host:", this.mConfig.getInappHost());
                C0227d.b().c(this.mConfig.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
                if (!isKeepAlive() || !this.mConfig.isKeepalive()) {
                    ALog.i(getTag(), "updateConfig close keepalive", new Object[0]);
                    z = false;
                }
                registerSessionInfo(m, inappHost, z);
            } catch (Throwable th) {
                ALog.e(getTag(), "updateConfig", th, new Object[0]);
            }
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public MonitorStatistic updateMonitorInfo() {
        return null;
    }

    public InAppConnection(Context context, int i, String str, int i2) {
        super(context, i, str);
        this.mRunning = true;
        this.accsHeartbeatInterval = DateUtils.MILLIS_PER_HOUR;
        this.connected = true;
        this.innerConnected = false;
        this.accsHeartBeatTask = new Runnable() { // from class: com.taobao.accs.net.InAppConnection.2
            @Override // java.lang.Runnable
            public void run() {
                ALog.d(InAppConnection.this.getTag(), "sendAccsHeartbeatMessage", new Object[0]);
                try {
                    ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, new JsonUtility.JsonObjectBuilder().put(MtopJSBridge.MtopJSParam.DATA_TYPE, "pingreq").put("timeInterval", Long.valueOf(InAppConnection.this.accsHeartbeatInterval)).build().toString().getBytes("utf-8"), UUID.randomUUID().toString());
                    accsRequest.setTarget("accs-iot");
                    accsRequest.setTargetServiceName("sal");
                    InAppConnection inAppConnection = InAppConnection.this;
                    InAppConnection.this.sendMessage(Message.buildRequest(inAppConnection.mContext, inAppConnection.getHost(null), InAppConnection.this.getTag(), InAppConnection.this.mConfig.getStoreId(), InAppConnection.this.mContext.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
                } catch (Exception e) {
                    ALog.e(InAppConnection.this.getTag(), "send accs heartbeat message", e, new Object[0]);
                }
            }
        };
        this.sessionListener = new ISessionListener() { // from class: com.taobao.accs.net.InAppConnection.3
            private void innerConnChanged(Context context2, boolean z) {
                if (z) {
                    C9708t9.U(10000);
                    long unused = InAppConnection.lastReceiveTimeInMill = InAppConnection.lastOnlineTimeInMill = SystemClock.elapsedRealtime();
                    Collection<Message> unhandledMessages = InAppConnection.this.mMessageHandler.getUnhandledMessages();
                    List<String> upRetryServiceIds = OrangeAdapter.getUpRetryServiceIds(context2);
                    if (unhandledMessages != null && upRetryServiceIds != null && !upRetryServiceIds.isEmpty()) {
                        for (Message message : unhandledMessages) {
                            if (!message.isAck && !message.isTimeOut()) {
                                String str2 = message.serviceId;
                                if (!TextUtils.isEmpty(str2) && upRetryServiceIds.contains(str2) && !InAppConnection.retryIdMap.containsKey(message.getDataId()) && SystemClock.elapsedRealtime() - message.getSendTime() >= 3000) {
                                    InAppConnection.this.reSend(message, 0);
                                    InAppConnection.retryIdMap.put(message.getDataId(), null);
                                }
                            }
                        }
                    }
                } else {
                    InAppConnection.foreOnlineTotalTimesInMill += InAppConnection.lastReceiveTimeInMill - InAppConnection.lastOnlineTimeInMill;
                    long unused2 = InAppConnection.lastReceiveTimeInMill = InAppConnection.lastOnlineTimeInMill = 0L;
                }
                if (z && UtilityImpl.isMainProcess(context2)) {
                    Launcher_InitAgooLifecycle.monitorConnected();
                }
            }

            private void onConnectionChangedImpl(Context context2, boolean z, Intent intent) {
                boolean z2 = true;
                if (OrangeAdapter.isChannelModeEnable() && UtilityImpl.isMainProcessAlive(InAppConnection.this.mContext) && !C9708t9.L()) {
                    C9708t9.z0(true);
                } else {
                    z2 = false;
                }
                innerConnChanged(context2, z);
                String stringExtra = intent.getStringExtra("host");
                int intExtra = intent.getIntExtra("errorCode", -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                TaoBaseService.ConnectInfo connectInfo = z ? new TaoBaseService.ConnectInfo(stringExtra, booleanExtra, booleanExtra2) : new TaoBaseService.ConnectInfo(stringExtra, booleanExtra, booleanExtra2, intExtra, stringExtra2);
                connectInfo.connected = z;
                InAppConnection.this.notifyConnectionChanged2Main(context2, z);
                if (ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
                    InAppConnection.this.notifyConnectionChangedListener(connectInfo, z2);
                    return;
                }
                ALog.e(InAppConnection.this.getTag(), "onConnectionChanged not allow to notify", new Object[0]);
                C0162c.m(InAppConnection.this.mConfig.getAppKey()).E(InAppConnection.this.sessionListener);
            }

            @Override // anet.channel.ISessionListener
            public void onConnectionChanged(Intent intent) {
                if (intent == null) {
                    ALog.e(InAppConnection.this.getTag(), "onConnectionChanged", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "null");
                    return;
                }
                Context context2 = GlobalClientInfo.getContext();
                boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                String stringExtra = intent.getStringExtra("host");
                String tag = InAppConnection.this.getTag();
                ALog.e(tag, "onConnectionChanged", "currentHost", "https://" + InAppConnection.this.mConfig.getInappHost(), "changeHost", stringExtra, "state", Boolean.valueOf(booleanExtra), "process", IPCUtils.getCurrentProcessName(), "hash", Integer.valueOf(InAppConnection.this.hashCode()));
                if (("https://" + InAppConnection.this.mConfig.getInappHost()).equals(stringExtra)) {
                    InAppConnection inAppConnection = InAppConnection.this;
                    inAppConnection.innerConnected = inAppConnection.connected = booleanExtra;
                    HeartbeatManager.getInstance(context2).set();
                    InAppConnection.this.monitorFakeConn();
                    InAppConnection.this.monitorWrongConn(booleanExtra);
                    onConnectionChangedImpl(context2, booleanExtra, intent);
                }
            }
        };
        this.isErrorConnectionCommitted = false;
        this.wcTask = null;
        this.mTryStartServiceRunable = new Runnable() { // from class: com.taobao.accs.net.InAppConnection.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InAppConnection inAppConnection = InAppConnection.this;
                    if (inAppConnection.mContext == null || TextUtils.isEmpty(inAppConnection.getAppkey())) {
                        return;
                    }
                    ALog.i(InAppConnection.this.getTag(), "mTryStartServiceRunable bindapp", new Object[0]);
                    InAppConnection.this.startChannelService();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.mSessionRegistered = Collections.synchronizedSet(new HashSet());
        this.heartbeatWrapper = new IHeartbeat() { // from class: com.taobao.accs.net.InAppConnection.11
            @Override // anet.channel.heartbeat.IHeartbeat
            public void reSchedule() {
            }

            @Override // anet.channel.heartbeat.IHeartbeat
            public void start(Session session) {
                if (InAppConnection.this.smartHeartbeat != null) {
                    InAppConnection.this.smartHeartbeat.start(session);
                }
            }

            @Override // anet.channel.heartbeat.IHeartbeat
            public void stop() {
                if (InAppConnection.this.smartHeartbeat != null) {
                    InAppConnection.this.smartHeartbeat.stop();
                }
            }
        };
        setForeBackState(i2);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.mTryStartServiceRunable, 120000L, TimeUnit.MILLISECONDS);
    }
}
