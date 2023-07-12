package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ali.user.mobile.rpc.ApiConstants;
import com.alibaba.gaiax.GXTemplateEngine;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ElectionServiceImpl;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.MsgDistribute;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.net.SpdyConnection;
import com.taobao.accs.ut.statistics.MonitorStatistic;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.LoadSoFailUtil;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.uc.webview.export.extension.UCCore;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.service.IMessageService;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ServiceImpl extends ElectionServiceImpl {
    private static final String TAG = "ServiceImpl";
    private Service mBaseService;
    private Context mContext;
    private String mLastNetWorkType;
    private final IMessageService.Stub messageServiceBinder;
    private long startTime;

    public ServiceImpl(Service service) {
        super(service);
        this.mBaseService = null;
        this.mLastNetWorkType = "unknown";
        this.messageServiceBinder = new IMessageService.Stub() { // from class: com.taobao.accs.internal.ServiceImpl.1
            @Override // org.android.agoo.service.IMessageService
            public boolean ping() throws RemoteException {
                return true;
            }

            @Override // org.android.agoo.service.IMessageService
            public void probe() throws RemoteException {
                ALog.d(ServiceImpl.TAG, "ReceiverImpl probeTaoBao begin......messageServiceBinder [probe]", new Object[0]);
                ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.internal.ServiceImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ServiceImpl.this.mContext != null && UtilityImpl.getServiceEnabled(ServiceImpl.this.mContext)) {
                                Intent intent = new Intent();
                                intent.setAction("org.agoo.android.intent.action.PING_V4");
                                intent.setClassName(ServiceImpl.this.mContext.getPackageName(), AdapterUtilityImpl.channelService);
                                ServiceImpl.this.mContext.startService(intent);
                                UTMini.getInstance().commitEvent(66001, "probeServiceEnabled", UtilityImpl.getDeviceId(ServiceImpl.this.mContext));
                                ALog.d(ServiceImpl.TAG, "ReceiverImpl probeTaoBao........mContext.startService(intent) [probe][successfully]", new Object[0]);
                            } else {
                                Process.killProcess(Process.myPid());
                            }
                            ALog.d(ServiceImpl.TAG, "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
                        } catch (Throwable th) {
                            ALog.d(ServiceImpl.TAG, "ReceiverImpl probeTaoBao error........e=" + th, new Object[0]);
                        }
                    }
                });
            }
        };
        this.mBaseService = service;
        this.mContext = service.getApplicationContext();
    }

    private String getVersion(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "null";
            }
            String str2 = this.mContext.getPackageManager().getPackageInfo(str, 0).versionName;
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "getVersion###版本号为 : " + str2, new Object[0]);
            }
            return str2;
        } catch (Throwable unused) {
            return "null";
        }
    }

    private void handleAction(Intent intent, String str) {
        ALog.d(TAG, "handleAction", "action", str);
        try {
            if (!TextUtils.isEmpty(str) && "org.agoo.android.intent.action.PING_V4".equals(str)) {
                String stringExtra = intent.getStringExtra("source");
                ALog.i(TAG, "org.agoo.android.intent.action.PING_V4,start channel by brothers", "serviceStart", Integer.valueOf(AdapterGlobalClientInfo.mStartServiceTimes.intValue()), "source" + stringExtra);
                AppMonitorAdapter.commitCount("accs", "startChannel", stringExtra, 0.0d);
                if (AdapterGlobalClientInfo.isFirstStartProc()) {
                    AppMonitorAdapter.commitCount("accs", "createChannel", stringExtra, 0.0d);
                }
            }
            if (Constants.ACTION_CLOSE_CONNECTION.equals(str)) {
                BaseConnection connection = ElectionServiceImpl.getConnection(this.mContext, intent.getStringExtra(Constants.KEY_CONFIG_TAG), false, -1);
                if (connection instanceof InAppConnection) {
                    ((InAppConnection) connection).unRegisterSessionInfo();
                }
            } else {
                tryConnect();
            }
            if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                return;
            }
            if (TextUtils.equals(str, ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                String networkTypeExt = UtilityImpl.getNetworkTypeExt(this.mContext);
                boolean isNetworkConnected = UtilityImpl.isNetworkConnected(this.mContext);
                String str2 = "network change:" + this.mLastNetWorkType + " to " + networkTypeExt;
                ALog.i(TAG, str2, new Object[0]);
                if (isNetworkConnected) {
                    this.mLastNetWorkType = networkTypeExt;
                    notifyNetChangeOnAllConns(str2);
                    pingOnAllConns(true, false);
                    UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", networkTypeExt, UtilityImpl.getProxy(), "0");
                }
                if (networkTypeExt.equals("unknown")) {
                    notifyNetChangeOnAllConns(str2);
                    this.mLastNetWorkType = networkTypeExt;
                }
            } else if (TextUtils.equals(str, "android.intent.action.BOOT_COMPLETED")) {
                pingOnAllConns(true, false);
            } else if (TextUtils.equals(str, "android.intent.action.USER_PRESENT")) {
                ALog.d(TAG, "action android.intent.action.USER_PRESENT", new Object[0]);
                pingOnAllConns(true, false);
            } else if (str.equals(Constants.ACTION_COMMAND)) {
                handleCommand(intent);
            } else if (str.equals(Constants.ACTION_START_FROM_AGOO)) {
                ALog.i(TAG, "ACTION_START_FROM_AGOO", new Object[0]);
            } else if (str.equals(Constants.ACTION_RESET_REG_ID)) {
                String stringExtra2 = intent.getStringExtra("regId");
                if (TextUtils.isEmpty(stringExtra2) || stringExtra2.equals(SpdyConnection.channelAuthRegId)) {
                    return;
                }
                ALog.e(TAG, " reset regId", new Object[0]);
                OrangeAdapter.resetRegIdByMain(stringExtra2);
                ElectionServiceImpl.resetAllConnections(this.mContext);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "handleAction", th, new Object[0]);
        }
    }

    private void handleCommand(Intent intent) {
        BaseConnection baseConnection;
        Message.ReqType reqType;
        URL url;
        Message buildRequest;
        URL url2;
        int intExtra = intent.getIntExtra("command", -1);
        ALog.i(TAG, "handleCommand", "command", Integer.valueOf(intExtra));
        String stringExtra = intent.getStringExtra("packageName");
        String stringExtra2 = intent.getStringExtra("serviceId");
        String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
        intent.getStringExtra("appKey");
        String stringExtra4 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
        intent.getStringExtra("ttid");
        intent.getStringExtra("sid");
        intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            sendOnAllConnections(Message.BuildPing(true, 0), true);
            updateMonitorInfoOnAllConns();
        }
        if (intExtra <= 0 || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        BaseConnection connection = ElectionServiceImpl.getConnection(this.mContext, stringExtra4, true, intExtra);
        if (connection == null) {
            ALog.e(TAG, "no connection", Constants.KEY_CONFIG_TAG, stringExtra4, "command", Integer.valueOf(intExtra));
            return;
        }
        connection.start();
        Message message = null;
        if (intExtra == 100) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra6 = intent.getStringExtra("target");
            String stringExtra7 = intent.getStringExtra(Constants.KEY_BUSINESSID);
            String stringExtra8 = intent.getStringExtra(Constants.KEY_EXT_TAG);
            try {
                reqType = (Message.ReqType) intent.getSerializableExtra(Constants.KEY_SEND_TYPE);
            } catch (Exception unused) {
                reqType = null;
            }
            if (byteArrayExtra != null) {
                try {
                    if (!OrangeAdapter.isChannelModeEnable()) {
                        url2 = new URL("https://" + ((SpdyConnection) connection).getChannelHost());
                    } else {
                        url2 = new URL(connection.getHost(null));
                    }
                    url = url2;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    url = null;
                }
                Message.ReqType reqType2 = reqType;
                baseConnection = connection;
                ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra5, stringExtra6, url, stringExtra7);
                accsRequest.setTag(stringExtra8);
                if (reqType2 == null) {
                    buildRequest = Message.buildSendData(baseConnection.getHost(null), stringExtra4, baseConnection.mConfig.getStoreId(), this.mContext, stringExtra, accsRequest, false);
                } else if (reqType2 == Message.ReqType.REQ) {
                    buildRequest = Message.buildRequest(this.mContext, baseConnection.getHost(null), stringExtra4, baseConnection.mConfig.getStoreId(), stringExtra, Constants.TARGET_SERVICE_PRE, accsRequest, false);
                }
                message = buildRequest;
            } else {
                baseConnection = connection;
            }
        } else {
            baseConnection = connection;
            if (intExtra == 106) {
                intent.setAction(Constants.ACTION_RECEIVE);
                intent.putExtra("command", -1);
                MsgDistribute.getInstance().distribute(this.mContext, intent);
                return;
            }
        }
        if (message != null) {
            ALog.d(TAG, "try send message", new Object[0]);
            if (message.getNetPermanceMonitor() != null) {
                message.getNetPermanceMonitor().onSend();
            }
            baseConnection.send(message, true);
            return;
        }
        ALog.e(TAG, "message is null", new Object[0]);
        baseConnection.onResult(Message.buildParameterError(stringExtra, intExtra), -2);
    }

    private void init() {
        ALog.d(TAG, "init start", new Object[0]);
        GlobalClientInfo.getInstance(this.mContext);
        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
        this.startTime = System.currentTimeMillis();
        this.mLastNetWorkType = UtilityImpl.getNetworkTypeExt(this.mContext);
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, UCCore.LEGACY_EVENT_INIT, "sdkVersion", Integer.valueOf((int) Constants.SDK_VERSION_CODE), "procStart", Integer.valueOf(AdapterGlobalClientInfo.mStartServiceTimes.intValue()));
        }
        initUt();
        onPingIpp(this.mContext);
        UTMini.getInstance().commitEvent(66001, GXTemplateEngine.C3338b.STATE_START, UtilityImpl.getProxy(), "PROXY");
        long serviceAliveTime = UtilityImpl.getServiceAliveTime(this.mContext);
        ALog.d(TAG, "getServiceAliveTime", "aliveTime", Long.valueOf(serviceAliveTime));
        if (serviceAliveTime > 20000) {
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", serviceAliveTime / 1000);
        }
        UtilityImpl.setServiceTime(this.mContext, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, ApiConstants.ResultActionType.NOTIFY, UtilityImpl.isNotificationEnabled(this.mContext));
    }

    private void initUt() {
    }

    private void notifyNetChangeOnAllConns(String str) {
        ConcurrentHashMap<String, BaseConnection> concurrentHashMap = ElectionServiceImpl.mConnections;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        for (Map.Entry<String, BaseConnection> entry : ElectionServiceImpl.mConnections.entrySet()) {
            entry.getValue().notifyNetWorkChange(str);
        }
    }

    private final void onPingIpp(Context context) {
    }

    private void pingOnAllConns(boolean z, boolean z2) {
        ConcurrentHashMap<String, BaseConnection> concurrentHashMap = ElectionServiceImpl.mConnections;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        for (Map.Entry<String, BaseConnection> entry : ElectionServiceImpl.mConnections.entrySet()) {
            BaseConnection value = entry.getValue();
            value.ping(z, z2);
            ALog.i(TAG, "ping connection", "appkey", value.getAppkey());
        }
    }

    private void sendOnAllConnections(Message message, boolean z) {
        ConcurrentHashMap<String, BaseConnection> concurrentHashMap = ElectionServiceImpl.mConnections;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        for (Map.Entry<String, BaseConnection> entry : ElectionServiceImpl.mConnections.entrySet()) {
            BaseConnection value = entry.getValue();
            if (value instanceof InAppConnection) {
                value.ping(true, false);
            } else {
                value.send(message, z);
            }
        }
    }

    private void shouldStopSelf(boolean z) {
        ALog.e(TAG, "shouldStopSelf, kill:" + z, new Object[0]);
        Service service = this.mBaseService;
        if (service != null) {
            service.stopSelf();
        }
        if (z) {
            Process.killProcess(Process.myPid());
        }
    }

    private void shutdownAllConns() {
        ConcurrentHashMap<String, BaseConnection> concurrentHashMap = ElectionServiceImpl.mConnections;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        for (Map.Entry<String, BaseConnection> entry : ElectionServiceImpl.mConnections.entrySet()) {
            entry.getValue().shutdown();
        }
    }

    private synchronized void tryConnect() {
        ConcurrentHashMap<String, BaseConnection> concurrentHashMap = ElectionServiceImpl.mConnections;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, BaseConnection> entry : ElectionServiceImpl.mConnections.entrySet()) {
                BaseConnection value = entry.getValue();
                if (value == null) {
                    ALog.e(TAG, "tryConnect connection null", "appkey", value.getAppkey());
                    return;
                }
                ALog.i(TAG, "tryConnect", "appkey", value.getAppkey(), Constants.KEY_CONFIG_TAG, entry.getKey());
                if (value.isSecurityOff() && TextUtils.isEmpty(value.mConfig.getAppSecret())) {
                    ALog.e(TAG, "tryConnect secret is null", new Object[0]);
                } else {
                    value.start();
                }
            }
            return;
        }
        ALog.w(TAG, "tryConnect no connections", new Object[0]);
    }

    private void updateMonitorInfoOnAllConns() {
        ConcurrentHashMap<String, BaseConnection> concurrentHashMap = ElectionServiceImpl.mConnections;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        for (Map.Entry<String, BaseConnection> entry : ElectionServiceImpl.mConnections.entrySet()) {
            MonitorStatistic updateMonitorInfo = entry.getValue().updateMonitorInfo();
            if (updateMonitorInfo != null) {
                updateMonitorInfo.startServiceTime = this.startTime;
                updateMonitorInfo.commitUT();
            }
        }
    }

    @Override // com.taobao.accs.connection.ElectionServiceImpl, com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        ALog.d(TAG, "accs probeTaoBao begin......action=" + action, new Object[0]);
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "org.agoo.android.intent.action.PING_V4")) {
            return null;
        }
        UTMini.getInstance().commitEvent(66001, "probeChannelService", UtilityImpl.getDeviceId(this.mContext), intent.getStringExtra("source"));
        return this.messageServiceBinder;
    }

    @Override // com.taobao.accs.connection.ElectionServiceImpl, com.taobao.accs.base.IBaseService
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override // com.taobao.accs.connection.ElectionServiceImpl, com.taobao.accs.base.IBaseService
    public void onDestroy() {
        super.onDestroy();
        ALog.e(TAG, "Service onDestroy", new Object[0]);
        UtilityImpl.setServiceTime(this.mContext, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.mBaseService = null;
        this.mContext = null;
        shutdownAllConns();
        Process.killProcess(Process.myPid());
    }

    @Override // com.taobao.accs.connection.ElectionServiceImpl
    public int onHostStartCommand(Intent intent, int i, int i2) {
        String action;
        Bundle extras;
        int i3 = 2;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "onHostStartCommand", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        }
        try {
            if (ALog.isPrintLog(ALog.Level.D) && intent != null && (extras = intent.getExtras()) != null) {
                for (String str : extras.keySet()) {
                    ALog.d(TAG, "onHostStartCommand", "key", str, " value", extras.get(str));
                }
            }
            int soFailTimes = LoadSoFailUtil.getSoFailTimes();
            if (soFailTimes > 3) {
                try {
                    ALog.e(TAG, "onHostStartCommand load SO fail 4 times, don't auto restart", new Object[0]);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.int2String(soFailTimes), 0.0d);
                } catch (Throwable th) {
                    th = th;
                    try {
                        ALog.e(TAG, "onHostStartCommand", th, new Object[0]);
                        return i3;
                    } finally {
                        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
                    }
                }
            } else {
                i3 = 1;
            }
            action = intent == null ? null : intent.getAction();
        } catch (Throwable th2) {
            th = th2;
            i3 = 1;
        }
        if (TextUtils.isEmpty(action)) {
            tryConnect();
            pingOnAllConns(false, false);
            return i3;
        }
        handleAction(intent, action);
        return i3;
    }

    @Override // com.taobao.accs.connection.ElectionServiceImpl, com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    @Override // com.taobao.accs.connection.ElectionServiceImpl
    public void onVotedHost() {
        startConnect();
    }

    public void startConnect() {
        ALog.i(TAG, "startConnect", new Object[0]);
        try {
            tryConnect();
            pingOnAllConns(false, false);
        } catch (Throwable th) {
            ALog.e(TAG, "tryConnect is error,e=" + th, new Object[0]);
        }
    }
}
