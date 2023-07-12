package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AccsHandler;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.exception.IPCException;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MsgDistribute {
    private static final String KEY_ROUTING_ACK = "routingAck";
    private static final String KEY_ROUTING_MSG = "routingMsg";
    private static final long MIN_SPACE = 5242880;
    private static final String TAG = "MsgDistribute";
    private static volatile MsgDistribute instance;
    private static Set<String> mRoutingDataIds;

    public static void distribMessage(final Context context, final Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_DATA_ID);
            String stringExtra2 = intent.getStringExtra("serviceId");
            if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(stringExtra2)) {
                ALog.e(TAG, "distribMessage", Constants.KEY_DATA_ID, stringExtra);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.data.MsgDistribute.1
                @Override // java.lang.Runnable
                public void run() {
                    MsgDistribute.getInstance().distribute(context, intent);
                }
            });
        } catch (Throwable th) {
            ALog.e(TAG, "distribMessage", th, new Object[0]);
            UTMini uTMini = UTMini.getInstance();
            uTMini.commitEvent(66001, "MsgToBuss8", "distribMessage" + th.toString(), Integer.valueOf((int) Constants.SDK_VERSION_CODE));
        }
    }

    public static MsgDistribute getInstance() {
        if (instance == null) {
            synchronized (MsgDistribute.class) {
                if (instance == null) {
                    instance = new MsgDistribute();
                }
            }
        }
        return instance;
    }

    private boolean handleAgooTrigger(Context context, String str, Intent intent) {
        JSONArray jSONArray;
        if (str.equals("agooControl")) {
            try {
                byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    String str2 = new String(byteArrayExtra, "utf-8");
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.i(TAG, "handle agooControl message", "message", str2);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject(str2);
                        boolean z = jSONObject.getBoolean(Constants.KEY_CONTROL);
                        OrangeAdapter.saveConfigToSP(context, Constants.KEY_CONTROL, z);
                        if (z && (jSONArray = jSONObject.getJSONArray(Constants.KEY_PACKAGES)) != null && jSONArray.length() != 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                NoTraceTriggerHelper.trigger(context, jSONArray.getString(i), 4);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                ALog.e(TAG, "handleBusinessMsg process agooControl message error", e, new Object[0]);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x015b A[Catch: IPCException -> 0x0163, TryCatch #1 {IPCException -> 0x0163, blocks: (B:65:0x0128, B:82:0x0153, B:84:0x015b, B:85:0x015f, B:77:0x014b), top: B:102:0x0128 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleControlMsg(android.content.Context r19, android.content.Intent r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, com.taobao.accs.IAppReceiver r27, int r28) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.MsgDistribute.handleControlMsg(android.content.Context, android.content.Intent, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, com.taobao.accs.IAppReceiver, int):void");
    }

    private boolean handleRoutingMsg(Context context, final Intent intent, final String str, final String str2, String str3) {
        AccsClientConfig configByTag = !TextUtils.isEmpty(str3) ? AccsClientConfig.getConfigByTag(str3) : null;
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        try {
            NoTraceTriggerHelper.trigger(context, intent.getPackage(), 6);
            if (configByTag != null && configByTag.isPullUpEnable()) {
                ALog.e(TAG, "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage(), "serviceId", str2);
                intent.setClassName(intent.getPackage(), AdapterUtilityImpl.msgService);
                intent.putExtra(KEY_ROUTING_MSG, true);
                intent.putExtra("packageName", context.getPackageName());
                IntentDispatch.dispatchIntent(context, intent);
                if (mRoutingDataIds == null) {
                    mRoutingDataIds = new HashSet();
                }
                mRoutingDataIds.add(str);
                ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: com.taobao.accs.data.MsgDistribute.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MsgDistribute.mRoutingDataIds == null || !MsgDistribute.mRoutingDataIds.contains(str)) {
                            return;
                        }
                        ALog.e(MsgDistribute.TAG, "routing msg time out, try election", Constants.KEY_DATA_ID, str, "serviceId", str2);
                        MsgDistribute.mRoutingDataIds.remove(str);
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + intent.getPackage());
                    }
                }, 10L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "exception", th.toString());
            ALog.e(TAG, "routing msg error, try election", th, "serviceId", str2, Constants.KEY_DATA_ID, str);
        }
        return true;
    }

    private boolean handleRoutingMsgAck(Context context, Intent intent, String str, String str2) {
        boolean z;
        boolean booleanExtra = intent.getBooleanExtra(KEY_ROUTING_ACK, false);
        boolean booleanExtra2 = intent.getBooleanExtra(KEY_ROUTING_MSG, false);
        if (booleanExtra) {
            ALog.e(TAG, "recieve routiong ack", Constants.KEY_DATA_ID, str, "serviceId", str2);
            Set<String> set = mRoutingDataIds;
            if (set != null) {
                set.remove(str);
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "");
            z = true;
        } else {
            z = false;
        }
        if (booleanExtra2) {
            try {
                String stringExtra = intent.getStringExtra("packageName");
                ALog.e(TAG, "send routiong ack", Constants.KEY_DATA_ID, str, "to pkg", stringExtra, "serviceId", str2);
                Intent intent2 = new Intent(Constants.ACTION_COMMAND);
                intent2.putExtra("command", 106);
                intent2.setClassName(stringExtra, AdapterUtilityImpl.channelService);
                intent2.putExtra(KEY_ROUTING_ACK, true);
                intent2.putExtra("packageName", stringExtra);
                intent2.putExtra(Constants.KEY_DATA_ID, str);
                IntentDispatch.dispatchIntent(context, intent2);
            } catch (Throwable th) {
                ALog.e(TAG, "send routing ack", th, "serviceId", str2);
            }
        }
        return z;
    }

    protected boolean checkSpace(int i, String str, String str2) {
        if (i != 100 && !GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            long usableSpace = UtilityImpl.getUsableSpace();
            if (usableSpace != -1 && usableSpace <= 5242880) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "space low");
                ALog.e(TAG, "user space low, don't distribute", "size", Long.valueOf(usableSpace), "serviceId", str);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9 A[Catch: all -> 0x0260, TRY_LEAVE, TryCatch #1 {all -> 0x0260, blocks: (B:10:0x0050, B:17:0x0084, B:26:0x00bc, B:29:0x00c9, B:25:0x00ab), top: B:94:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void distribute(android.content.Context r42, android.content.Intent r43) {
        /*
            Method dump skipped, instructions count: 715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.MsgDistribute.distribute(android.content.Context, android.content.Intent):void");
    }

    protected String getChannelService(Context context) {
        return AdapterUtilityImpl.channelService;
    }

    protected String getMsgDistributeService(Context context) {
        return AdapterUtilityImpl.msgService;
    }

    protected void handBroadCastMsg(Context context, Map<String, IAppReceiver> map, Intent intent, int i, int i2) {
        ALog.e(TAG, "handBroadCastMsg", "command", Integer.valueOf(i));
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, IAppReceiver> entry : map.entrySet()) {
                Map<String, String> allService = GlobalClientInfo.getInstance(context).getAllService(entry.getKey());
                if (allService == null) {
                    try {
                        allService = entry.getValue().getAllServices();
                    } catch (IPCException e) {
                        ALog.e(TAG, "handBroadCastMsg getAllServices", e, new Object[0]);
                    }
                }
                if (allService != null) {
                    hashMap.putAll(allService);
                }
            }
        }
        if (i != 103) {
            if (i == 104) {
                for (String str : hashMap.keySet()) {
                    String str2 = (String) hashMap.get(str);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setClassName(context, str2);
                        IntentDispatch.dispatchIntent(context, intent);
                    }
                }
                return;
            }
            ALog.w(TAG, "handBroadCastMsg not handled command", new Object[0]);
            return;
        }
        for (String str3 : hashMap.keySet()) {
            if ("accs".equals(str3) || "windvane".equals(str3) || "motu-remote".equals(str3)) {
                String str4 = (String) hashMap.get(str3);
                if (TextUtils.isEmpty(str4)) {
                    str4 = GlobalClientInfo.getInstance(context).getService(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    intent.setClassName(context, str4);
                    IntentDispatch.dispatchIntent(context, intent);
                }
            }
        }
        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
        String stringExtra = intent.getStringExtra("host");
        String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
        boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
        boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
        TaoBaseService.ConnectInfo connectInfo = null;
        if (!TextUtils.isEmpty(stringExtra)) {
            if (booleanExtra) {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3);
            } else {
                connectInfo = new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, i2, stringExtra2);
            }
            connectInfo.connected = booleanExtra;
        }
        if (connectInfo != null) {
            ALog.d(TAG, "handBroadCastMsg ACTION_CONNECT_INFO", connectInfo);
            Intent intent2 = new Intent(Constants.ACTION_CONNECT_INFO);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(Constants.KEY_CONNECT_INFO, connectInfo);
            context.sendBroadcast(intent2);
            return;
        }
        ALog.e(TAG, "handBroadCastMsg connect info null, host empty", new Object[0]);
    }

    protected void handleBusinessMsg(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i, int i2) {
        if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str)) {
            ALog.e(TAG, "handleBusinessMsg start", Constants.KEY_DATA_ID, str2, "serviceId", str, "command", Integer.valueOf(i));
        }
        if (handleAgooTrigger(context, str, intent)) {
            return;
        }
        String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
        if (TextUtils.isEmpty(service) && iAppReceiver != null) {
            try {
                service = iAppReceiver.getService(str);
            } catch (IPCException e) {
                ALog.e(TAG, "handleBusinessMsg onBindApp", e, new Object[0]);
            }
        }
        if (TextUtils.isEmpty(service)) {
            service = GlobalClientInfo.getInstance(context).getService(str);
        }
        if (!TextUtils.isEmpty(service)) {
            if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str)) {
                ALog.e(TAG, "handleBusinessMsg to start service", PushClientConstants.TAG_CLASS_NAME, service);
            }
            intent.setClassName(context, service);
            IntentDispatch.dispatchIntent(context, intent);
        } else {
            AccsDataListener listener = GlobalClientInfo.getInstance(context).getListener(str);
            if (listener != null) {
                if (ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str)) {
                    ALog.e(TAG, "handleBusinessMsg getListener not null", new Object[0]);
                }
                AccsHandler.onReceiveData(context, intent, listener);
            } else {
                ALog.e(TAG, "handleBusinessMsg getListener also null", new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "service is null");
            }
        }
        UTMini.getInstance().commitEvent(66001, "MsgToBuss", "commandId=" + i, "serviceId=" + str + " errorCode=" + i2 + " dataId=" + str2, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
        StringBuilder sb = new StringBuilder();
        sb.append("2commandId=");
        sb.append(i);
        sb.append("serviceId=");
        sb.append(str);
        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
    }

    protected boolean handleMsgInChannelProcess(Context context, String str, String str2, Intent intent, IAppReceiver iAppReceiver) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String service = GlobalClientInfo.getInstance(context).getService(intent.getStringExtra(Constants.KEY_CONFIG_TAG), str);
            if (TextUtils.isEmpty(service) && iAppReceiver != null) {
                service = iAppReceiver.getService(str);
            }
            if (TextUtils.isEmpty(service)) {
                service = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (!TextUtils.isEmpty(service) || UtilityImpl.isMainProcess(context)) {
                return false;
            }
            if (!"accs".equals(str) && !Constants.IMPAAS.equals(str)) {
                ALog.i(TAG, "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
                intent.setClassName(intent.getPackage(), getMsgDistributeService(context));
                IntentDispatch.dispatchIntent(context, intent);
                return true;
            }
            ALog.e(TAG, "start MsgDistributeService", Constants.KEY_DATA_ID, str2);
            intent.setClassName(intent.getPackage(), getMsgDistributeService(context));
            IntentDispatch.dispatchIntent(context, intent);
            return true;
        } catch (Throwable th) {
            ALog.e(TAG, "handleMsgInChannelProcess", th, new Object[0]);
            return false;
        }
    }
}
