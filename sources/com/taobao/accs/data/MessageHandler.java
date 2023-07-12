package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.ut.statistics.BindAppStatistic;
import com.taobao.accs.ut.statistics.BindUserStatistic;
import com.taobao.accs.ut.statistics.ReceiveMsgStat;
import com.taobao.accs.ut.statistics.SendAckStatistic;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.MessageStreamReader;
import com.taobao.accs.utl.NoTraceTriggerHelper;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.youku.live.livesdk.preloader.Preloader;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.android.agoo.common.Config;
import org.apache.commons.net.SocketClient;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.hu0;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MessageHandler {
    private static final int MESSAGE_ID_CACHE_SIZE = 50;
    private String TAG;
    public AntiBrush mAntiBrush;
    public int mConnectType;
    private BaseConnection mConnection;
    private Context mContext;
    public FlowControl mFlowControl;
    private Message mLastSendMessage;
    private ReceiveMsgStat mReceiveMsgStat;
    protected TrafficsMonitor mTrafficMonitor;
    private ConcurrentMap<Message.Id, Message> unHandleMessage = new ConcurrentHashMap();
    public ConcurrentMap<String, ScheduledFuture<?>> reqTasks = new ConcurrentHashMap();
    private boolean unRevPing = false;
    public String mAccsDeviceToken = "";
    public String mDeviceToken = "";
    private LinkedHashMap<String, String> handledMessageId = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            return size() > 50;
        }
    };
    private Map<String, AssembleMessage> assembleMessageMap = new HashMap();
    private Runnable mRestoreTrafficsRunnable = new Runnable() { // from class: com.taobao.accs.data.MessageHandler.3
        @Override // java.lang.Runnable
        public void run() {
            TrafficsMonitor trafficsMonitor = MessageHandler.this.mTrafficMonitor;
            if (trafficsMonitor != null) {
                trafficsMonitor.restoreTraffics();
            }
        }
    };

    public MessageHandler(Context context, BaseConnection baseConnection) {
        String str;
        this.TAG = "MsgRecv_";
        this.mContext = context;
        this.mConnection = baseConnection;
        this.mTrafficMonitor = new TrafficsMonitor(context);
        this.mFlowControl = new FlowControl(this.mContext);
        this.mAntiBrush = new AntiBrush(this.mContext);
        if (baseConnection == null) {
            str = this.TAG;
        } else {
            str = this.TAG + baseConnection.mConfigTag;
        }
        this.TAG = str;
        restoreMessageId();
        restoreTraffics();
    }

    private Intent buildBaseReceiveIntent(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.packageName);
        intent.putExtra("command", message.command);
        intent.putExtra("serviceId", message.serviceId);
        intent.putExtra(Constants.KEY_USER_ID, message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        return intent;
    }

    private byte[] gzipInputStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Throwable th) {
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e) {
            String str = this.TAG;
            ALog.e(str, "uncompress data error " + e.toString(), new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.mConnectType + " uncompress data error " + e.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            return null;
        }
    }

    private void handleControlMessage(Message message, byte[] bArr, byte[] bArr2, String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONObject jSONObject2;
        int i = -8;
        try {
            try {
                JSONObject jSONObject3 = new JSONObject(new String(bArr));
                int i2 = 2;
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.TAG, "handleControlMessage parse", Preloader.KEY_JSON, jSONObject3.toString());
                }
                i = message.command.intValue() == 100 ? 200 : jSONObject3.getInt("code");
                if (i == 200) {
                    int intValue = message.command.intValue();
                    if (intValue == 1) {
                        UtilityImpl.saveUtdid(Constants.SP_FILE_NAME, this.mContext);
                        this.mConnection.getClientManager().onAppBind(this.mContext.getPackageName());
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                        this.mAccsDeviceToken = JsonUtility.getString(jSONObject4, Constants.KEY_ACCS_TOKEN, null);
                        this.mDeviceToken = JsonUtility.getString(jSONObject4, "deviceToken", null);
                        String string = JsonUtility.getString(jSONObject4, "regId", null);
                        if (!TextUtils.isEmpty(this.mDeviceToken)) {
                            Config.setDeviceToken(this.mContext, this.mDeviceToken);
                        }
                        if (!TextUtils.isEmpty(string) && !string.equals(OrangeAdapter.getRegId(this.mContext))) {
                            this.mConnection.getClientManager().clearClients();
                            OrangeAdapter.clearRegId(this.mContext);
                        }
                        if (jSONObject4 != null) {
                            JSONArray jSONArray2 = jSONObject4.getJSONArray(Constants.KEY_PACKAGE_NAMES);
                            if (jSONArray2 != null) {
                                int i3 = 0;
                                while (i3 < jSONArray2.length()) {
                                    String string2 = jSONArray2.getString(i3);
                                    if (UtilityImpl.packageExist(this.mContext, string2)) {
                                        this.mConnection.getClientManager().onAppBind(message.packageName);
                                    } else {
                                        String str2 = this.TAG;
                                        Object[] objArr = new Object[i2];
                                        objArr[0] = "pkg";
                                        objArr[1] = string2;
                                        ALog.d(str2, "unbind app", objArr);
                                        BaseConnection baseConnection = this.mConnection;
                                        baseConnection.send(Message.buildUnbindApp(baseConnection.getHost(null), string2), true);
                                    }
                                    i3++;
                                    i2 = 2;
                                }
                            }
                            if (jSONObject4.has(Constants.KEY_EVENT_COLLECT_CONTROL) && (jSONObject2 = jSONObject4.getJSONObject(Constants.KEY_EVENT_COLLECT_CONTROL)) != null) {
                                OrangeAdapter.saveConfigToSP(this.mContext, "switch", jSONObject2.getBoolean("switch"));
                                OrangeAdapter.saveEventCollectStrategy(this.mContext, jSONObject2.toString());
                            }
                            if (jSONObject4.has("agooControl") && (jSONObject = jSONObject4.getJSONObject("agooControl")) != null) {
                                boolean z = jSONObject.getBoolean(Constants.KEY_CONTROL);
                                OrangeAdapter.saveConfigToSP(this.mContext, Constants.KEY_CONTROL, z);
                                if (z && (jSONArray = jSONObject.getJSONArray("strategy")) != null && jSONArray.length() != 0) {
                                    NoTraceTriggerHelper.trigger(jSONArray.toString(), this.mContext, null, 7, -1);
                                }
                            }
                        }
                    } else if (intValue == 2) {
                        this.mConnection.getClientManager().onAppUnbind(message.packageName);
                    } else if (intValue == 3) {
                        this.mConnection.getClientManager().onUserBind(message.packageName, message.userinfo);
                    } else if (intValue != 4) {
                        if (intValue == 100 && (this.mConnection instanceof InAppConnection) && "4|sal|accs-iot".equals(message.target)) {
                            ((InAppConnection) this.mConnection).onReceiveAccsHeartbeatResp(jSONObject3);
                        }
                    } else {
                        this.mConnection.getClientManager().onUserUnBind(message.packageName, message.userinfo);
                    }
                } else if (message.command.intValue() == 3 && i == 300) {
                    this.mConnection.getClientManager().onAppUnbind(message.packageName);
                }
            } catch (Throwable th) {
                th = th;
                ALog.e(this.TAG, "handleControlMessage", th, new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.mConnectType + th.toString());
                onResult(message, i, null, bArr, null);
                addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, hu0.i(), str, bArr2.length));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        onResult(message, i, null, bArr, null);
        addTrafficsInfo(new TrafficsMonitor.TrafficInfo(message.serviceId, hu0.i(), str, bArr2.length));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05ab A[Catch: Exception -> 0x0751, TryCatch #9 {Exception -> 0x0751, blocks: (B:168:0x04bb, B:170:0x04c3, B:172:0x04df, B:174:0x04e7, B:178:0x04f7, B:180:0x0506, B:182:0x052c, B:184:0x0532, B:186:0x0549, B:189:0x0550, B:191:0x0558, B:193:0x0593, B:195:0x05ab, B:196:0x05b1, B:198:0x05b5, B:200:0x05c0, B:202:0x0601, B:204:0x0617, B:208:0x067b, B:207:0x067a, B:192:0x0576), top: B:264:0x04bb }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05b5 A[Catch: Exception -> 0x0751, TryCatch #9 {Exception -> 0x0751, blocks: (B:168:0x04bb, B:170:0x04c3, B:172:0x04df, B:174:0x04e7, B:178:0x04f7, B:180:0x0506, B:182:0x052c, B:184:0x0532, B:186:0x0549, B:189:0x0550, B:191:0x0558, B:193:0x0593, B:195:0x05ab, B:196:0x05b1, B:198:0x05b5, B:200:0x05c0, B:202:0x0601, B:204:0x0617, B:208:0x067b, B:207:0x067a, B:192:0x0576), top: B:264:0x04bb }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0601 A[Catch: Exception -> 0x0751, TryCatch #9 {Exception -> 0x0751, blocks: (B:168:0x04bb, B:170:0x04c3, B:172:0x04df, B:174:0x04e7, B:178:0x04f7, B:180:0x0506, B:182:0x052c, B:184:0x0532, B:186:0x0549, B:189:0x0550, B:191:0x0558, B:193:0x0593, B:195:0x05ab, B:196:0x05b1, B:198:0x05b5, B:200:0x05c0, B:202:0x0601, B:204:0x0617, B:208:0x067b, B:207:0x067a, B:192:0x0576), top: B:264:0x04bb }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x067a A[Catch: Exception -> 0x0751, TryCatch #9 {Exception -> 0x0751, blocks: (B:168:0x04bb, B:170:0x04c3, B:172:0x04df, B:174:0x04e7, B:178:0x04f7, B:180:0x0506, B:182:0x052c, B:184:0x0532, B:186:0x0549, B:189:0x0550, B:191:0x0558, B:193:0x0593, B:195:0x05ab, B:196:0x05b1, B:198:0x05b5, B:200:0x05c0, B:202:0x0601, B:204:0x0617, B:208:0x067b, B:207:0x067a, B:192:0x0576), top: B:264:0x04bb }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x072c A[Catch: Exception -> 0x078a, TryCatch #2 {Exception -> 0x078a, blocks: (B:223:0x0721, B:225:0x072c, B:226:0x0739, B:228:0x0740, B:233:0x075b), top: B:252:0x0448 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0740 A[Catch: Exception -> 0x078a, TryCatch #2 {Exception -> 0x078a, blocks: (B:223:0x0721, B:225:0x072c, B:226:0x0739, B:228:0x0740, B:233:0x075b), top: B:252:0x0448 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.taobao.accs.utl.ALog$Level] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleMessage(int r50, byte[] r51, java.lang.String r52, int r53, int r54, long r55) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.MessageHandler.handleMessage(int, byte[], java.lang.String, int, int, long):void");
    }

    private boolean isDuplicateMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.handledMessageId.containsKey(str);
    }

    private boolean isNetWorkError(int i) {
        return i == -1 || i == -9 || i == -18 || i == -10 || i == -11;
    }

    private void monitorPerf(Message message, int i, boolean z) {
        boolean z2;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor == null) {
                return;
            }
            URL url = message.host;
            String url2 = url == null ? null : url.toString();
            if (i == 200) {
                z2 = true;
                if (message.retryTimes > 0) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                } else {
                    AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQUEST, url2);
                }
            } else {
                if (message.retryTimes > 0) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i, 0.0d);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                } else if (i != -13) {
                    String int2String = UtilityImpl.int2String(i);
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQUEST, url2, int2String, this.mConnectType + message.serviceId + message.timeout);
                }
                netPermanceMonitor.setFailReason(i);
                z2 = false;
            }
            netPermanceMonitor.setRet(z2);
            if (z) {
                if (message.isCancel) {
                    netPermanceMonitor.setRet(false);
                    netPermanceMonitor.setFailReason("msg cancel");
                }
                x6.b().commitStat(netPermanceMonitor);
            }
        } catch (Throwable th) {
            ALog.e(this.TAG, "monitorPerf", th, new Object[0]);
        }
    }

    private Map<Integer, String> parseExtHeader(MessageStreamReader messageStreamReader) {
        HashMap hashMap = null;
        if (messageStreamReader == null) {
            return null;
        }
        try {
            int readShort = messageStreamReader.readShort();
            if (ALog.isPrintLog(ALog.Level.D)) {
                String str = this.TAG;
                ALog.d(str, "extHeaderLen:" + readShort, new Object[0]);
            }
            int i = 0;
            while (i < readShort) {
                int readShort2 = messageStreamReader.readShort();
                int i2 = (64512 & readShort2) >> 10;
                int i3 = readShort2 & 1023;
                String readString = messageStreamReader.readString(i3);
                i = i + 2 + i3;
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(Integer.valueOf(i2), readString);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.TAG, "", "extHeaderType", Integer.valueOf(i2), "value", readString);
                }
            }
        } catch (Exception e) {
            ALog.e(this.TAG, "parseExtHeader", e, new Object[0]);
        }
        return hashMap;
    }

    private byte[] putBurstMessage(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int parseInt = Integer.parseInt(map.get(17));
                    int parseInt2 = Integer.parseInt(map.get(16));
                    if (parseInt2 > 1) {
                        if (parseInt >= 0 && parseInt < parseInt2) {
                            String str2 = map.get(18);
                            String str3 = map.get(15);
                            long parseLong = TextUtils.isEmpty(str3) ? 0L : Long.parseLong(str3);
                            AssembleMessage assembleMessage = this.assembleMessageMap.get(str);
                            if (assembleMessage == null) {
                                if (ALog.isPrintLog(ALog.Level.I)) {
                                    ALog.i(this.TAG, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                                }
                                assembleMessage = new AssembleMessage(str, parseInt2, str2);
                                assembleMessage.setTimeOut(parseLong);
                                this.assembleMessageMap.put(str, assembleMessage);
                            }
                            return assembleMessage.putBurst(parseInt, parseInt2, bArr);
                        }
                        throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(parseInt2), Integer.valueOf(parseInt)));
                    }
                    throw new RuntimeException("burstNums <= 1");
                }
            } catch (Throwable th) {
                ALog.w(this.TAG, "putBurstMessage", th, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void putBusinessAckInfoToIntent(Intent intent, String str, String str2, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("target", str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    private void putExtHeaderToIntent(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    private void recordMessageId(String str) {
        if (TextUtils.isEmpty(str) || this.handledMessageId.containsKey(str)) {
            return;
        }
        this.handledMessageId.put(str, str);
        saveMessageId();
    }

    private void restoreMessageId() {
        try {
            File dir = this.mContext.getDir("accs", 0);
            File file = new File(dir, "message" + this.mConnection.getAppkey());
            if (!file.exists()) {
                ALog.d(this.TAG, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    this.handledMessageId.put(readLine, readLine);
                } else {
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMessageId() {
        try {
            File dir = this.mContext.getDir("accs", 0);
            FileWriter fileWriter = new FileWriter(new File(dir, "message" + this.mConnection.getAppkey()));
            fileWriter.write("");
            for (String str : this.handledMessageId.keySet()) {
                fileWriter.append((CharSequence) str).append((CharSequence) SocketClient.NETASCII_EOL);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void utStat(Message message, int i) {
        if (message == null) {
            return;
        }
        String deviceId = UtilityImpl.getDeviceId(this.mContext);
        String str = System.currentTimeMillis() + "";
        boolean z = i == 200;
        int intValue = message.command.intValue();
        if (intValue == 1) {
            BindAppStatistic bindAppStatistic = new BindAppStatistic();
            bindAppStatistic.deviceId = deviceId;
            bindAppStatistic.time = str;
            bindAppStatistic.ret = z;
            bindAppStatistic.setFailReason(i);
            bindAppStatistic.commitUT();
        } else if (intValue != 3) {
        } else {
            BindUserStatistic bindUserStatistic = new BindUserStatistic();
            bindUserStatistic.deviceId = deviceId;
            bindUserStatistic.time = str;
            bindUserStatistic.ret = z;
            bindUserStatistic.userId = message.userinfo;
            bindUserStatistic.setFailReason(i);
            bindUserStatistic.commitUT();
        }
    }

    private void utStatSendAck(String str, String str2) {
        SendAckStatistic sendAckStatistic = new SendAckStatistic();
        sendAckStatistic.deviceId = UtilityImpl.getDeviceId(this.mContext);
        sendAckStatistic.dataId = str;
        sendAckStatistic.sendTime = "" + System.currentTimeMillis();
        sendAckStatistic.failReason = "";
        sendAckStatistic.serviceId = str2;
        sendAckStatistic.sessionId = "";
        sendAckStatistic.commitUT();
    }

    public void addTrafficsInfo(final TrafficsMonitor.TrafficInfo trafficInfo) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.data.MessageHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    TrafficsMonitor trafficsMonitor = MessageHandler.this.mTrafficMonitor;
                    if (trafficsMonitor != null) {
                        trafficsMonitor.addTrafficInfo(trafficInfo);
                    }
                }
            });
        } catch (Throwable th) {
            ALog.e(this.TAG, "addTrafficsInfo", th, new Object[0]);
        }
    }

    public void cancelControlMessage(Message message) {
        if (this.unHandleMessage.keySet().size() > 0) {
            for (Message.Id id : this.unHandleMessage.keySet()) {
                Message message2 = this.unHandleMessage.get(id);
                if (message2 != null && message2.command != null && message2.getPackageName().equals(message.getPackageName())) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                                break;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.e(this.TAG, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public ReceiveMsgStat getReceiveMsgStat() {
        return this.mReceiveMsgStat;
    }

    public int getUnhandledCount() {
        return this.unHandleMessage.size();
    }

    public Message getUnhandledMessage(String str) {
        return this.unHandleMessage.get(new Message.Id(0, str));
    }

    public Set<Message.Id> getUnhandledMessageIds() {
        return this.unHandleMessage.keySet();
    }

    public Collection<Message> getUnhandledMessages() {
        return this.unHandleMessage.values();
    }

    public boolean getUnrcvPing() {
        return this.unRevPing;
    }

    public void onMessage(byte[] bArr) throws IOException {
        onMessage(bArr, null);
    }

    public void onNetworkFail(int i) {
        this.unRevPing = false;
        Message.Id[] idArr = (Message.Id[]) this.unHandleMessage.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.TAG, "onNetworkFail", new Object[0]);
            for (Message.Id id : idArr) {
                Message remove = this.unHandleMessage.remove(id);
                if (remove != null) {
                    onResult(remove, i);
                }
            }
        }
    }

    public void onRcvPing() {
        ALog.d(this.TAG, "onRcvPing", new Object[0]);
        synchronized (MessageHandler.class) {
            this.unRevPing = false;
        }
    }

    public void onResult(Message message, int i) {
        onResult(message, i, null, null, null);
    }

    public void onSend(Message message) {
        String str;
        Message message2 = this.mLastSendMessage;
        if (message2 != null && (str = message.cunstomDataId) != null && message.serviceId != null && message2.cunstomDataId.equals(str) && this.mLastSendMessage.serviceId.equals(message.serviceId)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() == -1 || message.getType() == 2 || message.isAck) {
            return;
        }
        this.unHandleMessage.put(message.getMsgId(), message);
    }

    public void onSendPing() {
        ALog.d(this.TAG, "onSendPing", new Object[0]);
        synchronized (MessageHandler.class) {
            this.unRevPing = true;
        }
    }

    public Message removeUnhandledMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.unHandleMessage.remove(new Message.Id(0, str));
    }

    public void restoreTraffics() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.mRestoreTrafficsRunnable);
        } catch (Throwable th) {
            ALog.e(this.TAG, "restoreTraffics", th, new Object[0]);
        }
    }

    public void setReceiveMsgStat(ReceiveMsgStat receiveMsgStat) {
        this.mReceiveMsgStat = receiveMsgStat;
    }

    public void onMessage(byte[] bArr, String str) throws IOException {
        onMessage(bArr, str, 0L);
    }

    public void onResult(Message message, int i, Map<Integer, String> map) {
        onResult(message, i, null, null, map);
    }

    public void onMessage(byte[] bArr, String str, long j) throws IOException {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.TAG, "onMessage", "host", str);
        }
        MessageStreamReader messageStreamReader = new MessageStreamReader(bArr);
        try {
            int readByte = messageStreamReader.readByte();
            int i = (readByte & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4;
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                String str2 = this.TAG;
                ALog.d(str2, "version:" + i, new Object[0]);
            }
            int i2 = readByte & 15;
            if (ALog.isPrintLog(level)) {
                String str3 = this.TAG;
                ALog.d(str3, "compress:" + i2, new Object[0]);
            }
            int readByte2 = messageStreamReader.readByte();
            int readShort = messageStreamReader.readShort();
            if (ALog.isPrintLog(level)) {
                String str4 = this.TAG;
                ALog.d(str4, "totalLen:" + readShort, new Object[0]);
            }
            int i3 = 0;
            while (i3 < readShort) {
                int readShort2 = messageStreamReader.readShort();
                int i4 = i3 + 2;
                if (readShort2 > 0) {
                    byte[] bArr2 = new byte[readShort2];
                    messageStreamReader.read(bArr2);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        String str5 = this.TAG;
                        ALog.d(str5, "buf len:" + readShort2, new Object[0]);
                    }
                    handleMessage(i2, bArr2, str, i, readByte2, j);
                    i3 = i4 + readShort2;
                } else {
                    throw new IOException("data format error");
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void onResult(Message message, int i, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command != null && message.getType() >= 0 && message.getType() != 2) {
            String str = message.cunstomDataId;
            if (str != null) {
                this.reqTasks.remove(str);
            }
            Message.ReqType reqType2 = null;
            if (this.mAntiBrush.checkAntiBrush(message.host, map)) {
                i = 70022;
                reqType = null;
                bArr = null;
                map = null;
            }
            int updateFlowCtrlInfo = this.mFlowControl.updateFlowCtrlInfo(map, message.serviceId);
            if (updateFlowCtrlInfo != 0) {
                i = updateFlowCtrlInfo == 2 ? 70021 : updateFlowCtrlInfo == 3 ? 70023 : 70020;
                bArr = null;
                map = null;
            } else {
                reqType2 = reqType;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.TAG, "onResult", "command", message.command, "erorcode", Integer.valueOf(i));
            }
            if (message.command.intValue() == 102) {
                return;
            }
            if (!message.isCancel) {
                if (isNetWorkError(i) && message.command.intValue() != 100 && message.retryTimes <= Message.CONTROL_MAX_RETRY_TIMES) {
                    message.startSendTime = System.currentTimeMillis();
                    int i2 = message.retryTimes + 1;
                    message.retryTimes = i2;
                    ALog.d(this.TAG, "onResult", "retryTimes", Integer.valueOf(i2));
                    this.mConnection.send(message, true);
                    monitorPerf(message, i, true);
                } else {
                    monitorPerf(message, i, true);
                    Intent buildBaseReceiveIntent = buildBaseReceiveIntent(message);
                    buildBaseReceiveIntent.putExtra("errorCode", i);
                    Message.ReqType valueOf = Message.ReqType.valueOf((message.flags >> 13) & 3);
                    if (reqType2 == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                        buildBaseReceiveIntent.putExtra(Constants.KEY_SEND_TYPE, "res");
                    }
                    if (i == 200) {
                        buildBaseReceiveIntent.putExtra("data", bArr);
                    }
                    buildBaseReceiveIntent.putExtra("appKey", this.mConnection.mAppkey);
                    buildBaseReceiveIntent.putExtra(Constants.KEY_CONFIG_TAG, this.mConnection.mConfigTag);
                    putExtHeaderToIntent(map, buildBaseReceiveIntent);
                    MsgDistribute.getInstance().distribute(this.mContext, buildBaseReceiveIntent);
                    if (!TextUtils.isEmpty(message.serviceId)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + i + " dataId=" + message.dataId, Integer.valueOf((int) Constants.SDK_VERSION_CODE));
                        StringBuilder sb = new StringBuilder();
                        sb.append("1commandId=");
                        sb.append(message.command);
                        sb.append("serviceId=");
                        sb.append(message.serviceId);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                    }
                }
            } else {
                ALog.e(this.TAG, "onResult message is cancel", "command", message.command);
                monitorPerf(message, i, true);
            }
            utStat(message, i);
            return;
        }
        ALog.d(this.TAG, "onError, skip ping/ack", new Object[0]);
    }
}
