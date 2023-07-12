package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.a;
import anet.channel.c;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.d;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.ClientManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.MessageHandler;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.statistics.MonitorStatistic;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.uc.webview.export.cyclone.StatAction;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class BaseConnection {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    protected static final int CONNECTED = 1;
    protected static final int CONNECTING = 2;
    protected static final int DISCONNECTED = 3;
    protected static final int DISCONNECTING = 4;
    protected static final int FRAME_TYPE = 200;
    public static final int INAPP = 1;
    protected static final int MAX_DATA_SIZE = 49152;
    protected static final int MAX_QUEUE_SIZE = 1000;
    protected static final int RESEND_ACK_DELAY = 5000;
    protected static final int RESEND_DELAY = 2000;
    public static final int SERVICE = 0;
    protected static int state;
    public String mAppkey;
    public ClientManager mClientManager;
    public AccsClientConfig mConfig;
    public String mConfigTag;
    protected int mConnectionType;
    protected Context mContext;
    protected MessageHandler mMessageHandler;
    private ScheduledFuture<?> mPingTimeoutFuture;
    private Runnable mPingTimeoutRunnable;
    public String mTtid;
    protected String mUtdid;
    protected int mTimeoutMsgNum = 0;
    private long mExpectSendTime = 0;
    protected volatile boolean mAwcnInited = false;
    protected String mConnToken = null;
    private boolean isSendBackState = false;
    protected LinkedHashMap<Integer, Message> mAckMessage = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };
    private final ArrayList<AccsConnectStateListener> accsConnectStateListenerArrayList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseConnection(Context context, int i, String str) {
        this.mAppkey = "";
        this.mConnectionType = i;
        this.mContext = context.getApplicationContext();
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        this.mConfig = configByTag;
        if (configByTag == null) {
            ALog.e(getTag(), "BaseConnection config null!!", new Object[0]);
            try {
                this.mConfig = new AccsClientConfig.Builder().setAppKey(ACCSManager.getDefaultAppkey(context)).setTag(str).build();
            } catch (AccsException e) {
                ALog.e(getTag(), "BaseConnection build config", e, new Object[0]);
            }
        }
        AccsClientConfig accsClientConfig = this.mConfig;
        if (accsClientConfig != null) {
            this.mConfigTag = accsClientConfig.getTag();
            this.mAppkey = this.mConfig.getAppKey();
        }
        MessageHandler messageHandler = new MessageHandler(context, this);
        this.mMessageHandler = messageHandler;
        messageHandler.mConnectType = this.mConnectionType;
        ALog.e(getTag(), "new connection", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String buildAuthUrl(String str) {
        String str2;
        String str3;
        String deviceId = UtilityImpl.getDeviceId(this.mContext);
        try {
            str2 = URLEncoder.encode(deviceId);
        } catch (Throwable th) {
            ALog.e(getTag(), "buildAuthUrl", th, new Object[0]);
            str2 = deviceId;
        }
        String appsign = UtilityImpl.getAppsign(this.mContext, getAppkey(), this.mConfig.getAppSecret(), deviceId, this.mConfigTag, !isSecurityOff());
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth");
        sb.append(OrangeAdapter.isRegIdSwitchEnableAndValid(this.mContext) ? "?version=2" : "?");
        if (OrangeAdapter.isRegIdSwitchEnableAndValid(this.mContext)) {
            str3 = "&0=" + OrangeAdapter.getRegId(this.mContext);
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append("&1=");
        sb.append(str2);
        sb.append("&2=");
        sb.append(appsign);
        sb.append("&3=");
        sb.append(getAppkey());
        if (this.mConnToken != null) {
            sb.append("&4=");
            sb.append(this.mConnToken);
        }
        sb.append("&5=");
        sb.append(this.mConnectionType);
        sb.append("&6=");
        sb.append(UtilityImpl.getNetworkType(this.mContext));
        sb.append("&7=");
        sb.append("null");
        sb.append("&8=");
        sb.append(this.mConnectionType == 1 ? "1.1.2" : Integer.valueOf((int) Constants.SDK_VERSION_CODE));
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.mContext.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.getAppVersion(this.mContext));
        sb.append("&14=");
        sb.append(this.mTtid);
        sb.append("&15=");
        sb.append(UtilityImpl.urlEncode(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()));
        sb.append("&16=");
        sb.append(UtilityImpl.urlEncode(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND()));
        sb.append("&17=");
        sb.append(OrangeAdapter.getCurrentVersion(this.mContext));
        sb.append("&19=");
        sb.append(!isSecurityOff());
        sb.append("&20=");
        sb.append(this.mConfig.getStoreId());
        if (OrangeAdapter.isChannelModeEnable()) {
            sb.append("&21=");
            sb.append(state);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String buildCreateRegIdUrl(String str) {
        String str2;
        String deviceId = UtilityImpl.getDeviceId(this.mContext);
        try {
            str2 = URLEncoder.encode(deviceId);
        } catch (Throwable th) {
            ALog.e(getTag(), "buildAuthUrl", th, new Object[0]);
            str2 = deviceId;
        }
        String createRegIdAppSign = UtilityImpl.getCreateRegIdAppSign(this.mContext, getAppkey(), this.mConfig.getAppSecret(), deviceId, this.mConfigTag, !isSecurityOff());
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("createRegId?did=");
        sb.append(str2);
        sb.append("&appKey=");
        sb.append(getAppkey());
        sb.append("&sign=");
        sb.append(createRegIdAppSign);
        sb.append("&sec=");
        sb.append(!isSecurityOff());
        sb.append("&version=");
        sb.append(1);
        return sb.toString();
    }

    public abstract boolean cancel(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelPingTimeOut() {
        ScheduledFuture<?> scheduledFuture = this.mPingTimeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public abstract void close();

    public ArrayList<AccsConnectStateListener> getAccsConnectStateListenerArrayList() {
        return this.accsConnectStateListenerArrayList;
    }

    public String getAppkey() {
        return this.mAppkey;
    }

    public abstract int getChannelState();

    public ClientManager getClientManager() {
        if (this.mClientManager == null) {
            ALog.d(getTag(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.mConfigTag);
            this.mClientManager = new ClientManager(this.mContext, this.mConfigTag);
        }
        return this.mClientManager;
    }

    public String getHost(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb.append(str);
        sb.append(this.mConfig.getInappHost());
        return sb.toString();
    }

    protected int getMaxTimeOutData() {
        return 1;
    }

    public boolean getSendBackState() {
        return this.isSendBackState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStatus(int i) {
        return i != 1 ? i != 2 ? (i == 3 || i != 4) ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    public abstract String getTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAwcn(Context context) {
        try {
            ENV env = ENV.ONLINE;
            int i = AccsClientConfig.mEnv;
            if (i == 2) {
                env = ENV.TEST;
                c.D(env);
            } else if (i == 1) {
                env = ENV.PREPARE;
                c.D(env);
            }
            c.z(context, new a.C0009a().c(this.mAppkey).b(this.mConfig.getAppSecret()).d(this.mConfig.getAuthCode()).e(env).f(this.mConfig.getAppKey()).a());
            String str = ConnType.PK_ACS;
            str = (this.mConfig.getInappPubKey() == 10 || this.mConfig.getInappPubKey() == 11) ? "open" : "open";
            ALog.i(getTag(), "init awcn register new conn protocol host:", this.mConfig.getInappHost());
            d.b().c(this.mConfig.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(getTag(), "initAwcn", th, new Object[0]);
        }
    }

    public abstract boolean isAlive();

    public boolean isConnected() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isKeepAlive() {
        return true;
    }

    public boolean isSecurityOff() {
        return 2 == this.mConfig.getSecurity();
    }

    public abstract void notifyNetWorkChange(String str);

    public void onResult(Message message, int i) {
        this.mMessageHandler.onResult(message, i);
    }

    public abstract void onTimeOut(String str, boolean z, String str2);

    public abstract void ping(boolean z, boolean z2);

    public abstract void reConnect();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean reSend(Message message, int i) {
        int i2;
        boolean z = true;
        try {
            i2 = message.retryTimes;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (i2 > 3) {
            return false;
        }
        message.retryTimes = i2 + 1;
        message.delyTime = i;
        ALog.e(getTag(), "reSend", "dataid", message.dataId, "delay", Integer.valueOf(i), " retryTimes", Integer.valueOf(message.retryTimes));
        send(message, true);
        try {
            if (message.getNetPermanceMonitor() != null) {
                NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
                int i3 = message.retryTimes;
                netPermanceMonitor.retry_times = i3;
                if (i3 == 1) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, StatAction.KEY_TOTAL, 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            this.mMessageHandler.onResult(message, -8);
            ALog.e(getTag(), "reSend error", th, new Object[0]);
            return z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reSendAck(int i) {
        if (i < 0) {
            ALog.e(getTag(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i));
            Message message = this.mAckMessage.get(Integer.valueOf(i));
            if (message != null) {
                reSend(message, 5000);
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public void registerConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.accsConnectStateListenerArrayList) {
            this.accsConnectStateListenerArrayList.add(accsConnectStateListener);
        }
    }

    public void send(Message message, boolean z) {
        if (!message.isAck && !UtilityImpl.isNetworkConnected(this.mContext)) {
            ALog.e(getTag(), "sendMessage ready no network", Constants.KEY_DATA_ID, message.dataId);
            this.mMessageHandler.onResult(message, -13);
            return;
        }
        long flowCtrlDelay = message.getType() != 2 ? this.mMessageHandler.mFlowControl.getFlowCtrlDelay(message.serviceId, message.bizId) : 0L;
        if (flowCtrlDelay == -1) {
            ALog.e(getTag(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.dataId);
            this.mMessageHandler.onResult(message, 70021);
        } else if (flowCtrlDelay == -1000) {
            ALog.e(getTag(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.dataId);
            this.mMessageHandler.onResult(message, 70023);
        } else {
            if (flowCtrlDelay > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.mExpectSendTime;
                if (currentTimeMillis > j) {
                    message.delyTime = flowCtrlDelay;
                } else {
                    message.delyTime = (j + flowCtrlDelay) - System.currentTimeMillis();
                }
                this.mExpectSendTime = System.currentTimeMillis() + message.delyTime;
                ALog.e(getTag(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
            } else if (!"accs".equals(message.serviceId) && !Constants.IMPAAS.equals(message.serviceId)) {
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(getTag(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
                }
            } else {
                ALog.e(getTag(), "sendMessage ready", Constants.KEY_DATA_ID, message.dataId, "type", Message.MsgType.name(message.getType()), "delay", Long.valueOf(message.delyTime));
            }
            try {
                if (TextUtils.isEmpty(this.mUtdid)) {
                    this.mUtdid = UtilityImpl.getDeviceId(this.mContext);
                }
                if (!message.isTimeOut()) {
                    sendMessage(message, z);
                } else {
                    this.mMessageHandler.onResult(message, -18);
                }
            } catch (RejectedExecutionException unused) {
                this.mMessageHandler.onResult(message, 70008);
                ALog.e(getTag(), "sendMessage ready queue full", "size", Integer.valueOf(ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size()));
            }
        }
    }

    public abstract void sendMessage(Message message, boolean z);

    public void setForeBackState(int i) {
        state = i != 1 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPingTimeOut() {
        if (this.mPingTimeoutRunnable == null) {
            this.mPingTimeoutRunnable = new Runnable() { // from class: com.taobao.accs.net.BaseConnection.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseConnection.this.mMessageHandler.getUnrcvPing()) {
                        ALog.e(BaseConnection.this.getTag(), "receive ping time out! ", new Object[0]);
                        HeartbeatManager.getInstance(BaseConnection.this.mContext).onNetworkTimeout();
                        BaseConnection.this.onTimeOut("", false, "receive ping timeout");
                        BaseConnection.this.mMessageHandler.onNetworkFail(-12);
                    }
                }
            };
        }
        cancelPingTimeOut();
        this.mPingTimeoutFuture = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.mPingTimeoutRunnable, 40000L, TimeUnit.MILLISECONDS);
    }

    public void setSendBackState(boolean z) {
        this.isSendBackState = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTimeOut(final String str, final boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.net.BaseConnection.2
            @Override // java.lang.Runnable
            public void run() {
                Message unhandledMessage = BaseConnection.this.mMessageHandler.getUnhandledMessage(str);
                if (unhandledMessage != null) {
                    BaseConnection.this.mMessageHandler.onResult(unhandledMessage, -9);
                    BaseConnection.this.onTimeOut(str, z, "receive data time out");
                    String tag = BaseConnection.this.getTag();
                    ALog.e(tag, str + "-> receive data time out!", new Object[0]);
                }
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
    }

    public abstract void start();

    public void startChannelService() {
        try {
            ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: com.taobao.accs.net.BaseConnection.4
                @Override // java.lang.Runnable
                public void run() {
                    ALog.d(BaseConnection.this.getTag(), "startChannelService", new Object[0]);
                    Intent intent = new Intent(Constants.ACTION_START_SERVICE);
                    intent.putExtra("appKey", BaseConnection.this.getAppkey());
                    intent.putExtra("ttid", BaseConnection.this.mTtid);
                    intent.putExtra("packageName", GlobalClientInfo.getContext().getPackageName());
                    intent.putExtra("app_sercet", BaseConnection.this.mConfig.getAppSecret());
                    intent.putExtra("mode", AccsClientConfig.mEnv);
                    intent.putExtra(Config.PROPERTY_APP_KEY, Config.getAgooAppKey(GlobalClientInfo.getContext()));
                    intent.putExtra(Constants.KEY_CONFIG_TAG, BaseConnection.this.mConfigTag);
                    intent.setClassName(GlobalClientInfo.getContext().getPackageName(), AdapterUtilityImpl.channelService);
                    IntentDispatch.dispatchIntent(GlobalClientInfo.getContext(), intent);
                    Intent intent2 = new Intent();
                    intent2.setAction(AgooConstants.INTENT_FROM_AGOO_REPORT);
                    intent2.setPackage(GlobalClientInfo.getContext().getPackageName());
                    intent2.setClassName(GlobalClientInfo.getContext().getPackageName(), AdapterGlobalClientInfo.getAgooCustomServiceName(GlobalClientInfo.getContext().getPackageName()));
                    IntentDispatch.dispatchIntent(GlobalClientInfo.getContext(), intent2);
                }
            }, 10000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(getTag(), "startChannelService", th, new Object[0]);
        }
    }

    public void unRegisterConnectStateListener(AccsConnectStateListener accsConnectStateListener) {
        synchronized (this.accsConnectStateListenerArrayList) {
            this.accsConnectStateListenerArrayList.remove(accsConnectStateListener);
        }
    }

    public abstract MonitorStatistic updateMonitorInfo();
}
