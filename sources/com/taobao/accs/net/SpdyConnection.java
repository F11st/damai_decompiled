package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.IConnStrategy;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.MessageHandler;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.statistics.MonitorStatistic;
import com.taobao.accs.ut.statistics.ReceiveMsgStat;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.LoadSoFailUtil;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.weex.annotation.JSMethod;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import tb.hu0;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SpdyConnection extends BaseConnection implements SessionCb, Spdycb {
    private static final int ACCS_CONN_TIMEOUT = 120000;
    private static final int CONN_TIMEOUT = 40000;
    private static final int DEFAULT_RETRY_TIME = 5000;
    private static final String HTTP_STATUS = ":status";
    private static final int MAX_RETRY_TIMES = 4;
    protected static final int MAX_TIMEOUT_DATA = 3;
    private static final int REQ_TIMEOUT = 80000;
    private static final String TAG = "SilenceConn_";
    public static String channelAuthRegId = null;
    private static final long nanoToMs = 1000000;
    private long lastPingTime;
    private long lastPingTimeNano;
    private SpdyAgent mAgent;
    private boolean mCanUserProxy;
    private Object mConnLock;
    private long mConnStartTime;
    private long mConnStartTimeNano;
    protected ScheduledFuture<?> mConnTimoutFuture;
    private String mFinalUrl;
    private HttpDnsProvider mHttpDnsProvider;
    protected String mIp;
    private boolean mLastConnectFail;
    private LinkedList<Message> mMessageList;
    private MonitorStatistic mMonitorInfo;
    protected int mPort;
    private String mProxy;
    protected String mProxyIp;
    protected int mProxyPort;
    private boolean mRunning;
    private SpdySession mSession;
    private String mSessionId;
    private SessionMonitor mStatistic;
    private int mStatus;
    private NetworkThread mThread;
    private String mUrl;
    private int sessionConnectInterval;
    private String testUrl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class NetworkThread extends Thread {
        private final String TAG;
        public int failTimes;
        long lastConnectTime;

        public NetworkThread(String str) {
            super(str);
            this.TAG = getName();
            this.failTimes = 0;
        }

        private void tryConnect(boolean z) {
            if (SpdyConnection.this.mStatus == 1) {
                if (SpdyConnection.this.mStatus != 1 || System.currentTimeMillis() - this.lastConnectTime <= DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                    return;
                }
                this.failTimes = 0;
                return;
            }
            ALog.d(SpdyConnection.this.getTag(), "tryConnect", "force", Boolean.valueOf(z));
            if (!UtilityImpl.isNetworkConnected(SpdyConnection.this.mContext)) {
                ALog.e(this.TAG, "Network not available", new Object[0]);
                return;
            }
            if (z) {
                this.failTimes = 0;
            }
            ALog.i(this.TAG, "tryConnect", "force", Boolean.valueOf(z), "failTimes", Integer.valueOf(this.failTimes));
            if (SpdyConnection.this.mStatus == 1 || this.failTimes < 4) {
                if (SpdyConnection.this.mStatus != 1) {
                    if (SpdyConnection.this.mConnectionType == 1 && this.failTimes == 0) {
                        ALog.i(this.TAG, "tryConnect in app, no sleep", new Object[0]);
                    } else {
                        ALog.i(this.TAG, "tryConnect, need sleep", new Object[0]);
                        if (OrangeAdapter.isSpdyConnectSleepEnable() || UtilityImpl.isForeground(SpdyConnection.this.mContext)) {
                            try {
                                Thread.sleep(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    SpdyConnection.this.mProxy = "";
                    if (this.failTimes == 3) {
                        SpdyConnection.this.mHttpDnsProvider.forceUpdateStrategy(SpdyConnection.this.getChannelHost());
                    }
                    SpdyConnection.this.connect(null);
                    SpdyConnection.this.mStatistic.setRetryTimes(this.failTimes);
                    if (SpdyConnection.this.mStatus != 1) {
                        this.failTimes++;
                        ALog.e(this.TAG, "try connect fail, ready for reconnect", new Object[0]);
                        tryConnect(false);
                        return;
                    }
                    this.lastConnectTime = System.currentTimeMillis();
                    return;
                }
                return;
            }
            SpdyConnection.this.mCanUserProxy = true;
            ALog.e(this.TAG, "tryConnect fail", "maxTimes", 4);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Message message;
            boolean z;
            Integer num;
            Integer num2;
            Integer num3;
            ALog.i(this.TAG, "NetworkThread run", new Object[0]);
            this.failTimes = 0;
            Message message2 = null;
            while (SpdyConnection.this.mRunning) {
                ALog.d(this.TAG, "ready to get message", new Object[0]);
                synchronized (SpdyConnection.this.mMessageList) {
                    if (SpdyConnection.this.mMessageList.size() == 0) {
                        try {
                            ALog.d(this.TAG, "no message, wait", new Object[0]);
                            SpdyConnection.this.mMessageList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    ALog.d(this.TAG, "try get message", new Object[0]);
                    if (SpdyConnection.this.mMessageList.size() != 0) {
                        message2 = (Message) SpdyConnection.this.mMessageList.getFirst();
                        if (message2.getNetPermanceMonitor() != null) {
                            message2.getNetPermanceMonitor().onTakeFromQueue();
                        }
                    }
                    message = message2;
                }
                if (!SpdyConnection.this.mRunning) {
                    break;
                }
                if (message != null) {
                    ALog.d(this.TAG, "sendMessage not null", new Object[0]);
                    try {
                        int type = message.getType();
                        ALog.i(this.TAG, "sendMessage", "type", Message.MsgType.name(type), "status", Integer.valueOf(SpdyConnection.this.mStatus));
                        if (type != 2) {
                            if (type == 1) {
                                tryConnect(true);
                                if (SpdyConnection.this.mStatus == 1 && SpdyConnection.this.mSession != null) {
                                    SpdyConnection spdyConnection = SpdyConnection.this;
                                    byte[] build = message.build(spdyConnection.mContext, spdyConnection.mConnectionType);
                                    message.setSendTime(System.currentTimeMillis());
                                    if (build.length > 49152 && message.command.intValue() != 102) {
                                        SpdyConnection.this.mMessageHandler.onResult(message, -4);
                                    } else {
                                        int id = message.isAck ? -message.getMsgId().getId() : message.getMsgId().getId();
                                        SpdyConnection.this.mSession.sendCustomControlFrame(id, 200, 0, build.length, build);
                                        ALog.e(this.TAG, "send data", "length", Integer.valueOf(build.length), Constants.KEY_DATA_ID, message.getDataId(), "utdid", SpdyConnection.this.mUtdid);
                                        SpdyConnection.this.mMessageHandler.onSend(message);
                                        if (message.isAck) {
                                            ALog.e(this.TAG, "sendCFrame end ack", Constants.KEY_DATA_ID, Integer.valueOf(id));
                                            SpdyConnection.this.mAckMessage.put(Integer.valueOf(id), message);
                                        }
                                        if (message.getNetPermanceMonitor() != null) {
                                            message.getNetPermanceMonitor().onSendData();
                                        }
                                        SpdyConnection.this.setTimeOut(message.getDataId(), SpdyConnection.this.mConfig.isQuickReconnect(), message.timeout);
                                        SpdyConnection.this.mMessageHandler.addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, hu0.i(), SpdyConnection.this.getChannelHost(), build.length));
                                    }
                                }
                                z = false;
                            } else {
                                tryConnect(false);
                                ALog.e(this.TAG, "skip msg", "type", Integer.valueOf(type));
                            }
                            z = true;
                        } else if (SpdyConnection.this.mConnectionType != 1) {
                            if (System.currentTimeMillis() - SpdyConnection.this.lastPingTime < (HeartbeatManager.getInstance(SpdyConnection.this.mContext).getInterval() - 1) * 1000 && !message.force) {
                                tryConnect(false);
                                z = true;
                            }
                            ALog.d(this.TAG, "sendMessage", "force", Boolean.valueOf(message.force), "last ping", Long.valueOf(System.currentTimeMillis() - SpdyConnection.this.lastPingTime));
                            tryConnect(true);
                            if (SpdyConnection.this.mSession != null && SpdyConnection.this.mStatus == 1) {
                                if (System.currentTimeMillis() - SpdyConnection.this.lastPingTime >= (HeartbeatManager.getInstance(SpdyConnection.this.mContext).getInterval() - 1) * 1000) {
                                    ALog.i(this.TAG, "sendMessage onSendPing", new Object[0]);
                                    SpdyConnection.this.mMessageHandler.onSendPing();
                                    SpdyConnection.this.mSession.submitPing();
                                    SpdyConnection.this.mStatistic.onSendPing();
                                    SpdyConnection.this.lastPingTime = System.currentTimeMillis();
                                    SpdyConnection.this.lastPingTimeNano = System.nanoTime();
                                    SpdyConnection.this.setPingTimeOut();
                                }
                                z = true;
                            }
                            z = false;
                        } else {
                            ALog.d(this.TAG, "sendMessage INAPP ping, skip", new Object[0]);
                            try {
                                ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                                synchronized (SpdyConnection.this.mMessageList) {
                                    SpdyConnection.this.mMessageList.remove(message);
                                }
                            } catch (Throwable th) {
                                ALog.e(this.TAG, " run finally error", th, new Object[0]);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                    try {
                        SpdyConnection.this.setHeartbeat(true);
                        if (!z) {
                            try {
                                SpdyConnection.this.close();
                                if (SpdyConnection.this.mStatistic != null) {
                                    SpdyConnection.this.mStatistic.setCloseReason("send fail");
                                }
                                synchronized (SpdyConnection.this.mMessageList) {
                                    for (int size = SpdyConnection.this.mMessageList.size() - 1; size >= 0; size--) {
                                        Message message3 = (Message) SpdyConnection.this.mMessageList.get(size);
                                        if (message3 != null && (num3 = message3.command) != null && (num3.intValue() == 100 || message3.command.intValue() == 201)) {
                                            SpdyConnection.this.mMessageHandler.onResult(message3, -1);
                                            SpdyConnection.this.mMessageList.remove(size);
                                        }
                                    }
                                    ALog.e(this.TAG, "network disconnected, wait", new Object[0]);
                                    SpdyConnection.this.mMessageList.wait();
                                }
                            } catch (Throwable th3) {
                                ALog.e(this.TAG, " run finally error", th3, new Object[0]);
                            }
                        } else {
                            ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                            synchronized (SpdyConnection.this.mMessageList) {
                                SpdyConnection.this.mMessageList.remove(message);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, message.serviceId, "1", SpdyConnection.this.mConnectionType + th.toString());
                            th.printStackTrace();
                            ALog.e(this.TAG, "service connection run", th, new Object[0]);
                            if (!z) {
                                try {
                                    SpdyConnection.this.close();
                                    if (SpdyConnection.this.mStatistic != null) {
                                        SpdyConnection.this.mStatistic.setCloseReason("send fail");
                                    }
                                    synchronized (SpdyConnection.this.mMessageList) {
                                        for (int size2 = SpdyConnection.this.mMessageList.size() - 1; size2 >= 0; size2--) {
                                            Message message4 = (Message) SpdyConnection.this.mMessageList.get(size2);
                                            if (message4 != null && (num2 = message4.command) != null && (num2.intValue() == 100 || message4.command.intValue() == 201)) {
                                                SpdyConnection.this.mMessageHandler.onResult(message4, -1);
                                                SpdyConnection.this.mMessageList.remove(size2);
                                            }
                                        }
                                        ALog.e(this.TAG, "network disconnected, wait", new Object[0]);
                                        SpdyConnection.this.mMessageList.wait();
                                    }
                                } catch (Throwable th5) {
                                    ALog.e(this.TAG, " run finally error", th5, new Object[0]);
                                }
                            } else {
                                ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                                synchronized (SpdyConnection.this.mMessageList) {
                                    SpdyConnection.this.mMessageList.remove(message);
                                }
                            }
                            message2 = message;
                        } catch (Throwable th6) {
                            try {
                                if (!z) {
                                    SpdyConnection.this.close();
                                    if (SpdyConnection.this.mStatistic != null) {
                                        SpdyConnection.this.mStatistic.setCloseReason("send fail");
                                    }
                                    synchronized (SpdyConnection.this.mMessageList) {
                                        for (int size3 = SpdyConnection.this.mMessageList.size() - 1; size3 >= 0; size3--) {
                                            Message message5 = (Message) SpdyConnection.this.mMessageList.get(size3);
                                            if (message5 != null && (num = message5.command) != null && (num.intValue() == 100 || message5.command.intValue() == 201)) {
                                                SpdyConnection.this.mMessageHandler.onResult(message5, -1);
                                                SpdyConnection.this.mMessageList.remove(size3);
                                            }
                                        }
                                        ALog.e(this.TAG, "network disconnected, wait", new Object[0]);
                                        SpdyConnection.this.mMessageList.wait();
                                    }
                                } else {
                                    ALog.d(this.TAG, "send succ, remove it", new Object[0]);
                                    synchronized (SpdyConnection.this.mMessageList) {
                                        SpdyConnection.this.mMessageList.remove(message);
                                    }
                                }
                            } catch (Throwable th7) {
                                ALog.e(this.TAG, " run finally error", th7, new Object[0]);
                            }
                            throw th6;
                        }
                    }
                }
                message2 = message;
            }
            SpdyConnection.this.close();
        }
    }

    public SpdyConnection(Context context, int i, String str) {
        super(context, i, str);
        this.mStatus = 3;
        this.mMessageList = new LinkedList<>();
        this.mRunning = true;
        this.mAgent = null;
        this.mSession = null;
        this.mConnLock = new Object();
        this.sessionConnectInterval = -1;
        this.testUrl = null;
        this.mCanUserProxy = false;
        this.mProxy = "";
        this.mLastConnectFail = false;
        this.mHttpDnsProvider = new HttpDnsProvider(getChannelHost());
        initClient();
    }

    private void auth() {
        if (this.mSession == null) {
            notifyStatus(3);
            return;
        }
        try {
            String encode = URLEncoder.encode(UtilityImpl.getDeviceId(this.mContext));
            String appsign = UtilityImpl.getAppsign(this.mContext, getAppkey(), this.mConfig.getAppSecret(), UtilityImpl.getDeviceId(this.mContext), this.mConfigTag, isSecurityOff() ? 0 : 1);
            String buildAuthUrl = buildAuthUrl(this.mUrl);
            channelAuthRegId = OrangeAdapter.getRegId(this.mContext);
            ALog.e(getTag(), "auth", "url", buildAuthUrl);
            this.mFinalUrl = buildAuthUrl;
            if (!checkParam(encode, getAppkey(), appsign)) {
                ALog.e(getTag(), "auth param error!", new Object[0]);
                onAuthFail(-6);
                return;
            }
            new URL(buildAuthUrl);
            SpdyRequest spdyRequest = new SpdyRequest(new URL(buildAuthUrl), "GET", RequestPriority.DEFAULT_PRIORITY, (int) REQ_TIMEOUT, 40000);
            spdyRequest.setDomain(getChannelHost());
            this.mSession.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), getChannelHost(), this);
        } catch (Throwable th) {
            ALog.e(getTag(), "auth exception ", th, new Object[0]);
            onAuthFail(-7);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (android.text.TextUtils.isEmpty(r14) != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkParam(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            android.content.Context r0 = r11.mContext
            int r0 = com.taobao.accs.utl.Utils.getMode(r0)
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Lb
            return r2
        Lb:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r3 = 0
            if (r0 != 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L1e
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 == 0) goto Lb0
        L1e:
            r0 = 3
            r11.notifyStatus(r0)
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L2a
        L28:
            r0 = 1
            goto L38
        L2a:
            boolean r12 = android.text.TextUtils.isEmpty(r13)
            if (r12 == 0) goto L32
            r0 = 2
            goto L38
        L32:
            boolean r12 = android.text.TextUtils.isEmpty(r14)
            if (r12 == 0) goto L28
        L38:
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.mStatistic
            r12.setFailReason(r0)
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.mStatistic
            r12.onConnectStop()
            int r12 = r11.mConnectionType
            if (r12 != 0) goto L49
            java.lang.String r12 = "service"
            goto L4b
        L49:
            java.lang.String r12 = "inapp"
        L4b:
            com.taobao.accs.net.SpdyConnection$NetworkThread r13 = r11.mThread
            if (r13 == 0) goto L52
            int r13 = r13.failTimes
            goto L53
        L52:
            r13 = 0
        L53:
            com.taobao.accs.utl.UTMini r4 = com.taobao.accs.utl.UTMini.getInstance()
            r5 = 66001(0x101d1, float:9.2487E-41)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r6 = "DISCONNECT "
            r14.append(r6)
            r14.append(r12)
            java.lang.String r6 = r14.toString()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r12 = 221(0xdd, float:3.1E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            java.lang.String[] r10 = new java.lang.String[r1]
            java.lang.String r12 = r11.mFinalUrl
            r10[r3] = r12
            java.lang.String r12 = r11.mProxy
            r10[r2] = r12
            r4.commitEvent(r5, r6, r7, r8, r9, r10)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "retrytimes:"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r0)
            java.lang.String r14 = ""
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "accs"
            java.lang.String r1 = "connect"
            com.taobao.accs.utl.AppMonitorAdapter.commitAlarmFail(r0, r1, r12, r13, r14)
            r2 = 0
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.SpdyConnection.checkParam(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRepeatControlCommand(Message message) {
        if (message.command == null || this.mMessageList.size() == 0) {
            return;
        }
        for (int size = this.mMessageList.size() - 1; size >= 0; size--) {
            Message message2 = this.mMessageList.get(size);
            if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                switch (message.command.intValue()) {
                    case 1:
                    case 2:
                        if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                            this.mMessageList.remove(size);
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                            this.mMessageList.remove(size);
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                            this.mMessageList.remove(size);
                            break;
                        }
                        break;
                }
                ALog.d(getTag(), "clearRepeatControlCommand message:" + message2.command + "/" + message2.getPackageName(), new Object[0]);
            }
        }
        MessageHandler messageHandler = this.mMessageHandler;
        if (messageHandler != null) {
            messageHandler.cancelControlMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connect(String str) {
        SessionInfo sessionInfo;
        int i = this.mStatus;
        if (i == 2 || i == 1) {
            return;
        }
        if (this.mHttpDnsProvider == null) {
            this.mHttpDnsProvider = new HttpDnsProvider(getChannelHost());
        }
        List<IConnStrategy> availableStrategy = this.mHttpDnsProvider.getAvailableStrategy(getChannelHost());
        if (availableStrategy != null && availableStrategy.size() > 0) {
            for (IConnStrategy iConnStrategy : availableStrategy) {
                if (iConnStrategy != null) {
                    ALog.e(getTag(), "connect", TbAuthConstants.IP, iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.mLastConnectFail) {
                this.mHttpDnsProvider.updateStrategyPos();
                this.mLastConnectFail = false;
            }
            IConnStrategy strategy = this.mHttpDnsProvider.getStrategy();
            this.mIp = strategy == null ? getChannelHost() : strategy.getIp();
            this.mPort = strategy != null ? strategy.getPort() : 443;
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.e(getTag(), "connect from amdc succ", TbAuthConstants.IP, this.mIp, "port", Integer.valueOf(this.mPort), "originPos", Integer.valueOf(this.mHttpDnsProvider.getStrategyPos()));
        } else {
            if (str != null) {
                this.mIp = str;
            } else {
                this.mIp = getChannelHost();
            }
            this.mPort = System.currentTimeMillis() % 2 == 0 ? 80 : 443;
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.i(getTag(), "connect get ip from amdc fail!!", new Object[0]);
        }
        this.mUrl = "https://" + this.mIp + ":" + this.mPort + "/accs/";
        ALog.e(getTag(), "connect", "URL", this.mUrl);
        this.mSessionId = String.valueOf(System.currentTimeMillis());
        if (this.mStatistic != null) {
            x6.b().commitStat(this.mStatistic);
        }
        SessionMonitor sessionMonitor = new SessionMonitor();
        this.mStatistic = sessionMonitor;
        sessionMonitor.setConnectType(this.mConnectionType == 0 ? "service" : "inapp");
        if (this.mAgent != null) {
            try {
                this.mConnStartTime = System.currentTimeMillis();
                this.mConnStartTimeNano = System.nanoTime();
                this.mProxyIp = UtilityImpl.getProxyHost(this.mContext);
                this.mProxyPort = UtilityImpl.getProxyPort(this.mContext);
                this.lastPingTime = System.currentTimeMillis();
                this.mStatistic.onStartConnect();
                notifyStatus(2);
                synchronized (this.mConnLock) {
                    try {
                        try {
                            if (!TextUtils.isEmpty(this.mProxyIp) && this.mProxyPort >= 0 && this.mCanUserProxy) {
                                ALog.e(getTag(), "connect", "proxy", this.mProxyIp, "port", Integer.valueOf(this.mProxyPort));
                                String str2 = this.mIp;
                                int i2 = this.mPort;
                                sessionInfo = new SessionInfo(str2, i2, getChannelHost() + JSMethod.NOT_SET + this.mAppkey, this.mProxyIp, this.mProxyPort, this.mSessionId, this, 4226);
                                this.mProxy = this.mProxyIp + ":" + this.mProxyPort;
                            } else {
                                ALog.e(getTag(), "connect normal", new Object[0]);
                                String str3 = this.mIp;
                                int i3 = this.mPort;
                                sessionInfo = new SessionInfo(str3, i3, getChannelHost() + JSMethod.NOT_SET + this.mAppkey, null, 0, this.mSessionId, this, 4226);
                                this.mProxy = "";
                            }
                            sessionInfo.setPubKeySeqNum(getPublicKeyType());
                            sessionInfo.setConnectionTimeoutMs(40000);
                            this.mSession = this.mAgent.createSession(sessionInfo);
                            this.mStatistic.connection_stop_date = 0L;
                            this.mConnLock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                            this.mCanUserProxy = false;
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private int getPublicKeyType() {
        boolean isSecurityOff = isSecurityOff();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.mConfig.getChannelPubKey();
        if (channelPubKey <= 0) {
            return isSecurityOff ? 4 : 3;
        }
        ALog.i(getTag(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    private void initClient() {
        try {
            SpdyAgent.enableDebug = true;
            this.mAgent = SpdyAgent.getInstance(this.mContext, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (SpdyAgent.checkLoadSucc()) {
                LoadSoFailUtil.loadSoSuccess();
                if (!isSecurityOff()) {
                    this.mAgent.setAccsSslCallback(new AccsSSLCallback() { // from class: com.taobao.accs.net.SpdyConnection.4
                        @Override // org.android.spdy.AccsSSLCallback
                        public byte[] getSSLPublicKey(int i, byte[] bArr) {
                            SpdyConnection spdyConnection = SpdyConnection.this;
                            return UtilityImpl.staticBinarySafeDecryptNoB64(spdyConnection.mContext, spdyConnection.mConfigTag, spdyConnection.mAppkey, bArr);
                        }
                    });
                }
            } else {
                ALog.e(getTag(), "initClient", new Object[0]);
                this.mAgent = null;
                LoadSoFailUtil.loadSoFail();
            }
        } catch (Throwable th) {
            ALog.e(getTag(), "initClient", th, new Object[0]);
        }
    }

    private synchronized void notifyStatus(int i) {
        ALog.e(getTag(), "notifyStatus start", "status", getStatus(i));
        if (i == this.mStatus) {
            ALog.i(getTag(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.mStatus = i;
        if (i == 1) {
            HeartbeatManager.getInstance(this.mContext).resetLevel();
            setHeartbeat(true);
            ScheduledFuture<?> scheduledFuture = this.mConnTimoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            synchronized (this.mConnLock) {
                try {
                    this.mConnLock.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.mMessageList) {
                try {
                    this.mMessageList.notifyAll();
                } catch (Exception unused2) {
                }
            }
        } else if (i == 2) {
            ScheduledFuture<?> scheduledFuture2 = this.mConnTimoutFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            final String str = this.mSessionId;
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.net.SpdyConnection.3
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    if (str2 != null && str2.equals(SpdyConnection.this.mSessionId) && SpdyConnection.this.mStatus == 2) {
                        SpdyConnection.this.mCanUserProxy = false;
                        SpdyConnection.this.mLastConnectFail = true;
                        SpdyConnection.this.close();
                        SpdyConnection.this.mStatistic.setCloseReason("conn timeout");
                    }
                }
            }, 120000L, TimeUnit.MILLISECONDS);
        } else if (i == 3) {
            setHeartbeat(true);
            HeartbeatManager.getInstance(this.mContext).onNetworkFail();
            synchronized (this.mConnLock) {
                try {
                    this.mConnLock.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.mMessageHandler.onNetworkFail(-10);
            ping(false, true);
        }
        ALog.i(getTag(), "notifyStatus end", "status", getStatus(i));
    }

    private void onAuthFail(int i) {
        this.mConnToken = null;
        close();
        NetworkThread networkThread = this.mThread;
        int i2 = networkThread != null ? networkThread.failTimes : 0;
        SessionMonitor sessionMonitor = this.mStatistic;
        sessionMonitor.setCloseReason("code not 200 is" + i);
        this.mLastConnectFail = true;
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        UTMini uTMini = UTMini.getInstance();
        uTMini.commitEvent(66001, "CONNECTED NO 200 " + str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmFail("accs", "auth", "", i + "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setHeartbeat(boolean z) {
        if (this.mConnectionType == 1) {
            return;
        }
        this.lastPingTime = System.currentTimeMillis();
        this.lastPingTimeNano = System.nanoTime();
        HeartbeatManager.getInstance(this.mContext).set();
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        String tag = getTag();
        ALog.w(tag, "bioPingRecvCallback uniId:" + i, new Object[0]);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean cancel(String str) {
        boolean z;
        String str2;
        synchronized (this.mMessageList) {
            z = true;
            int size = this.mMessageList.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.mMessageList.get(size);
                    if (message != null && message.getType() == 1 && (str2 = message.cunstomDataId) != null && str2.equals(str)) {
                        this.mMessageList.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void close() {
        ALog.e(getTag(), " force close!", new Object[0]);
        try {
            this.mSession.closeSession();
            this.mStatistic.setCloseType(1);
        } catch (Exception unused) {
        }
        notifyStatus(3);
    }

    public String getChannelHost() {
        String channelHost = this.mConfig.getChannelHost();
        ALog.i(getTag(), "getChannelHost", "host", channelHost);
        return channelHost == null ? "" : channelHost;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public int getChannelState() {
        return this.mStatus;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public String getHost(String str) {
        return "https://" + this.mConfig.getChannelHost();
    }

    @Override // com.taobao.accs.net.BaseConnection
    protected int getMaxTimeOutData() {
        return 3;
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        return UtilityImpl.SecurityGuardGetSslTicket2(this.mContext, this.mConfigTag, this.mAppkey, spdySession.getDomain());
    }

    @Override // com.taobao.accs.net.BaseConnection
    public String getTag() {
        return TAG + this.mConfigTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public void initAwcn(Context context) {
        if (this.mAwcnInited) {
            return;
        }
        super.initAwcn(context);
        hu0.k(false);
        this.mAwcnInited = true;
        ALog.i(getTag(), "init awcn success!", new Object[0]);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public boolean isAlive() {
        return this.mRunning;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.accs.net.BaseConnection
    public boolean isKeepAlive() {
        return false;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void notifyNetWorkChange(String str) {
        this.mCanUserProxy = false;
        this.mTimeoutMsgNum = 0;
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void onTimeOut(String str, boolean z, String str2) {
        try {
            notifyStatus(4);
            close();
            this.mStatistic.setCloseReason(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void ping(boolean z, boolean z2) {
        String tag = getTag();
        ALog.d(tag, "try ping, force:" + z, new Object[0]);
        if (this.mConnectionType == 1) {
            ALog.d(getTag(), "INAPP, skip", new Object[0]);
            return;
        }
        Message BuildPing = Message.BuildPing(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d));
        int pingTimeout = this.mConfig.getPingTimeout();
        if (pingTimeout > 0) {
            BuildPing.timeout = pingTimeout;
        }
        send(BuildPing, z);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return UtilityImpl.SecurityGuardPutSslTicket2(this.mContext, this.mConfigTag, this.mAppkey, spdySession.getDomain(), bArr);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void reConnect() {
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void sendMessage(final Message message, final boolean z) {
        if (this.mRunning && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> schedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.net.SpdyConnection.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (SpdyConnection.this.mMessageList) {
                                SpdyConnection.this.clearRepeatControlCommand(message);
                                if (SpdyConnection.this.mMessageList.size() == 0) {
                                    SpdyConnection.this.mMessageList.add(message);
                                } else {
                                    Message message2 = (Message) SpdyConnection.this.mMessageList.getFirst();
                                    if (message.getType() != 1 && message.getType() != 0) {
                                        if (message.getType() != 2 || message2.getType() != 2) {
                                            SpdyConnection.this.mMessageList.addLast(message);
                                        } else if (!message2.force && message.force) {
                                            SpdyConnection.this.mMessageList.removeFirst();
                                            SpdyConnection.this.mMessageList.addFirst(message);
                                        }
                                    }
                                    SpdyConnection.this.mMessageList.addLast(message);
                                    if (message2.getType() == 2) {
                                        SpdyConnection.this.mMessageList.removeFirst();
                                    }
                                }
                                if (z || SpdyConnection.this.mStatus == 3) {
                                    try {
                                        SpdyConnection.this.mMessageList.notifyAll();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }, message.delyTime, TimeUnit.MILLISECONDS);
                    if (message.getType() == 1 && message.cunstomDataId != null) {
                        if (message.isControlFrame()) {
                            cancel(message.cunstomDataId);
                        }
                        this.mMessageHandler.reqTasks.put(message.cunstomDataId, schedule);
                    }
                    if (message.getNetPermanceMonitor() != null) {
                        message.getNetPermanceMonitor().setConnType(this.mConnectionType);
                        message.getNetPermanceMonitor().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                this.mMessageHandler.onResult(message, 70008);
                String tag = getTag();
                ALog.e(tag, "send queue full count:" + ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size(), new Object[0]);
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

    @Override // com.taobao.accs.net.BaseConnection
    public void shutdown() {
        super.shutdown();
        this.mRunning = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.net.SpdyConnection.2
            @Override // java.lang.Runnable
            public void run() {
                SpdyConnection.this.close();
                if (SpdyConnection.this.mStatistic != null) {
                    SpdyConnection.this.mStatistic.setCloseReason("shut down");
                }
                synchronized (SpdyConnection.this.mMessageList) {
                    try {
                        SpdyConnection.this.mMessageList.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            }
        });
        ALog.e(getTag(), "shut down", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        reSendAck(i);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        setHeartbeat(true);
        ALog.e(getTag(), "onFrame", "type", Integer.valueOf(i2), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long currentTimeMillis = System.currentTimeMillis();
            for (byte b : bArr) {
                sb.append(Integer.toHexString(b & 255));
                sb.append(" ");
            }
            ALog.d(getTag(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
        if (i2 == 200) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.mMessageHandler.onMessage(bArr);
                ReceiveMsgStat receiveMsgStat = this.mMessageHandler.getReceiveMsgStat();
                if (receiveMsgStat != null) {
                    receiveMsgStat.receiveDate = String.valueOf(currentTimeMillis2);
                    receiveMsgStat.messageType = this.mConnectionType == 0 ? "service" : "inapp";
                    receiveMsgStat.commitUT();
                }
            } catch (Throwable th) {
                ALog.e(getTag(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.getStackMsg(th));
            }
            ALog.d(getTag(), "try handle msg", new Object[0]);
            cancelPingTimeOut();
        } else {
            ALog.e(getTag(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(getTag(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(getTag(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(getTag(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, Object obj) {
        ALog.d(getTag(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        this.lastPingTime = System.currentTimeMillis();
        this.lastPingTimeNano = System.nanoTime();
        try {
            Map<String, String> header = UtilityImpl.getHeader(map);
            ALog.d(TAG, "spdyOnStreamResponse", "header", map);
            int parseInt = Integer.parseInt(header.get(":status"));
            ALog.e(getTag(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(parseInt));
            if (parseInt == 200) {
                notifyStatus(1);
                String str = header.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.mConnToken = str;
                }
                SessionMonitor sessionMonitor = this.mStatistic;
                sessionMonitor.auth_time = sessionMonitor.connection_stop_date > 0 ? System.currentTimeMillis() - this.mStatistic.connection_stop_date : 0L;
                String str2 = this.mConnectionType == 0 ? "service" : "inapp";
                UTMini uTMini = UTMini.getInstance();
                uTMini.commitEvent(66001, "CONNECTED 200 " + str2, this.mFinalUrl, this.mProxy, Integer.valueOf((int) Constants.SDK_VERSION_CODE), "0");
                AppMonitorAdapter.commitAlarmSuccess("accs", "auth", "");
            } else {
                onAuthFail(parseInt);
            }
        } catch (Exception e) {
            ALog.e(getTag(), e.toString(), new Object[0]);
            close();
            this.mStatistic.setCloseReason("exception");
        }
        ALog.d(getTag(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        String tag = getTag();
        ALog.d(tag, "spdyPingRecvCallback uniId:" + j, new Object[0]);
        if (j < 0) {
            return;
        }
        this.mMessageHandler.onRcvPing();
        HeartbeatManager.getInstance(this.mContext).onHeartbeatSucc();
        HeartbeatManager.getInstance(this.mContext).set();
        this.mStatistic.onPingCBReceive();
        if (this.mStatistic.ping_rec_times % 2 == 0) {
            UtilityImpl.setServiceTime(this.mContext, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(getTag(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.e(getTag(), "spdySessionCloseCallback", "errorCode", Integer.valueOf(i));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                String tag = getTag();
                ALog.e(tag, "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        notifyStatus(3);
        this.mStatistic.onCloseConnect();
        if (this.mStatistic.getConCloseDate() > 0 && this.mStatistic.getConStopDate() > 0) {
            this.mStatistic.getConCloseDate();
            this.mStatistic.getConStopDate();
        }
        this.mStatistic.setCloseReason(this.mStatistic.getCloseReason() + "tnet error:" + i);
        if (superviseConnectInfo != null) {
            this.mStatistic.live_time = superviseConnectInfo.keepalive_period_second;
        }
        x6.b().commitStat(this.mStatistic);
        for (Message message : this.mMessageHandler.getUnhandledMessages()) {
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().setRet(false);
                message.getNetPermanceMonitor().setFailReason("session close");
                x6.b().commitStat(message.getNetPermanceMonitor());
            }
        }
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        String tag2 = getTag();
        ALog.d(tag2, "spdySessionCloseCallback, conKeepTime:" + this.mStatistic.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        uTMini.commitEvent(66001, sb.toString(), Integer.valueOf(i), Long.valueOf(this.mStatistic.live_time), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.sessionConnectInterval = superviseConnectInfo.connectTime;
        int i = superviseConnectInfo.handshakeTime;
        ALog.e(getTag(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.sessionConnectInterval), "sslTime", Integer.valueOf(i), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        auth();
        this.mStatistic.setRet(true);
        this.mStatistic.onConnectStop();
        SessionMonitor sessionMonitor = this.mStatistic;
        sessionMonitor.tcp_time = this.sessionConnectInterval;
        sessionMonitor.ssl_time = i;
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        UTMini uTMini = UTMini.getInstance();
        uTMini.commitEvent(66001, "CONNECTED " + str + " " + superviseConnectInfo.sessionTicketReused, String.valueOf(this.sessionConnectInterval), String.valueOf(i), Integer.valueOf((int) Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmSuccess("accs", "connect", "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e) {
                ALog.e(getTag(), "session cleanUp has exception: " + e, new Object[0]);
            }
        }
        NetworkThread networkThread = this.mThread;
        int i2 = networkThread != null ? networkThread.failTimes : 0;
        ALog.e(getTag(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i2), "errorId", Integer.valueOf(i));
        this.mCanUserProxy = false;
        this.mLastConnectFail = true;
        notifyStatus(3);
        this.mStatistic.setFailReason(i);
        this.mStatistic.onConnectStop();
        String str = this.mConnectionType == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) Constants.SDK_VERSION_CODE), this.mFinalUrl, this.mProxy);
        AppMonitorAdapter.commitAlarmFail("accs", "connect", "retrytimes:" + i2, i + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
        ALog.d(getTag(), "spdyStreamCloseCallback", new Object[0]);
        if (i != 0) {
            ALog.e(getTag(), "spdyStreamCloseCallback", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i));
            onAuthFail(i);
        }
    }

    @Override // com.taobao.accs.net.BaseConnection
    public void start() {
        this.mRunning = true;
        ALog.d(getTag(), "start", new Object[0]);
        initAwcn(this.mContext);
        if (this.mThread == null) {
            ALog.i(getTag(), "start thread", new Object[0]);
            NetworkThread networkThread = new NetworkThread("NetworkThread_" + this.mConfigTag);
            this.mThread = networkThread;
            networkThread.setPriority(2);
            this.mThread.start();
        }
        ping(false, false);
    }

    @Override // com.taobao.accs.net.BaseConnection
    public MonitorStatistic updateMonitorInfo() {
        if (this.mMonitorInfo == null) {
            this.mMonitorInfo = new MonitorStatistic();
        }
        MonitorStatistic monitorStatistic = this.mMonitorInfo;
        monitorStatistic.connType = this.mConnectionType;
        monitorStatistic.messageNum = this.mMessageList.size();
        this.mMonitorInfo.networkAvailable = UtilityImpl.isNetworkConnected(this.mContext);
        MonitorStatistic monitorStatistic2 = this.mMonitorInfo;
        monitorStatistic2.proxy = this.mProxy;
        monitorStatistic2.status = this.mStatus;
        SessionMonitor sessionMonitor = this.mStatistic;
        monitorStatistic2.tcpConnected = sessionMonitor != null && sessionMonitor.getRet();
        this.mMonitorInfo.threadIsalive = isAlive();
        MonitorStatistic monitorStatistic3 = this.mMonitorInfo;
        MessageHandler messageHandler = this.mMessageHandler;
        monitorStatistic3.unHandleMessageNum = messageHandler != null ? messageHandler.getUnhandledCount() : 0;
        MonitorStatistic monitorStatistic4 = this.mMonitorInfo;
        monitorStatistic4.url = this.mFinalUrl;
        return monitorStatistic4;
    }
}
