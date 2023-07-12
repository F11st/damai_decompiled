package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.taobao.windvane.connect.HttpRequest;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.primitives.SignedBytes;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.MessageStreamBuilder;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.RomInfoCollecter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.weex.annotation.JSMethod;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import tb.cu2;
import tb.kd1;
import tb.xf0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Message implements Serializable {
    public static final String BINDAPP_V1 = "1";
    public static final String BINDAPP_V2 = "2";
    public static int CONTROL_MAX_RETRY_TIMES = 5;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;
    private static final String TAG = "Msg";
    static long baseMessageId = 1;
    public String cunstomDataId;
    byte[] data;
    public String dataId;
    short dataLength;
    Map<Integer, String> extHeader;
    short extHeaderLength;
    short flags;
    public URL host;
    Id msgId;
    transient NetPerformanceMonitor netPerformanceMonitor;
    int node;
    long sendTime;
    String source;
    byte sourceLength;
    public long startSendTime;
    String target;
    byte targetLength;
    short totalLength;
    public boolean isAck = false;
    public boolean force = false;
    public boolean isCancel = false;
    byte compress = 0;
    byte noUse = 0;
    int type = -1;
    String packageName = null;
    public Integer command = null;
    Integer updateDevice = 0;
    String appKey = null;
    public String appSign = null;
    Integer osType = null;
    String osVersion = null;
    String venderOsName = null;
    String venderOsVersion = null;
    String exts = null;
    String appVersion = null;
    Integer sdkVersion = null;
    String ttid = null;
    String macAddress = null;
    public String userinfo = null;
    public String serviceId = null;
    String model = null;
    String brand = null;
    String imei = null;
    String imsi = null;
    String notifyEnable = null;
    public long delyTime = 0;
    public int retryTimes = 0;
    public int timeout = 40000;
    public String bizId = null;
    String tag = null;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Id implements Serializable {
        private String dataId;
        private int id;

        public Id(int i, String str) {
            this.id = i;
            this.dataId = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Id id = (Id) obj;
            return this.id == id.getId() || this.dataId.equals(id.getDataId());
        }

        public String getDataId() {
            return this.dataId;
        }

        public int getId() {
            return this.id;
        }

        public int hashCode() {
            return this.dataId.hashCode();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class MsgResType implements Serializable {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String name(int i) {
            return i != 0 ? i != 1 ? HttpRequest.DEFAULT_HTTPS_ERROR_INVALID : "NEED_ACK" : "NO_ACK";
        }

        public static int valueOf(int i) {
            return i != 0 ? 1 : 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class MsgType implements Serializable {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static String name(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? HttpRequest.DEFAULT_HTTPS_ERROR_INVALID : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }

        public static int valueOf(int i) {
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        return 0;
                    }
                }
            }
            return i2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return DATA;
                        }
                        return RES;
                    }
                    return REQ;
                }
                return ACK;
            }
            return DATA;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message() {
        synchronized (Message.class) {
            this.startSendTime = System.currentTimeMillis();
            String str = this.startSendTime + "." + baseMessageId;
            this.dataId = str;
            long j = baseMessageId;
            baseMessageId = 1 + j;
            this.msgId = new Id((int) j, str);
        }
    }

    public static Message BuildPing(boolean z, int i) {
        Message message = new Message();
        message.type = 2;
        message.command = 201;
        message.force = z;
        message.delyTime = i;
        return message;
    }

    public static Message buildBackground(String str) {
        Message message = new Message();
        message.type(1, ReqType.DATA, 0);
        message.command = 100;
        message.target = Constants.TARGET_BACK;
        setControlHost(str, message);
        ALog.e(TAG, "buildBgId = ", message.dataId);
        return message;
    }

    public static Message buildBindApp(String str, String str2, Context context, Intent intent) {
        Message message = null;
        try {
            message = buildBindApp(context, str2, intent.getStringExtra("appKey"), intent.getStringExtra("app_sercet"), intent.getStringExtra("packageName"), intent.getStringExtra("ttid"), intent.getStringExtra("appVersion"));
            setControlHost(str, message);
            return message;
        } catch (Exception e) {
            ALog.e(TAG, "buildBindApp", e.getMessage());
            return message;
        }
    }

    @Deprecated
    public static Message buildBindService(BaseConnection baseConnection, Context context, Intent intent) {
        return buildBindService(baseConnection.getHost(null), baseConnection.mConfigTag, intent);
    }

    @Deprecated
    public static Message buildBindUser(BaseConnection baseConnection, Context context, Intent intent) {
        return buildBindUser(baseConnection.getHost(null), baseConnection.mConfigTag, intent);
    }

    public static Message buildEventMessage(int i, long j, String str, String str2, Context context) {
        return buildSendData(str, str2, "", context, context.getPackageName(), new ACCSManager.AccsRequest("", Constants.TARGET_SERVICE_EVENT_COLLECT, xf0.a(context, i, j), ""));
    }

    public static Message buildForeground(String str) {
        Message message = new Message();
        message.type(1, ReqType.DATA, 0);
        message.command = 100;
        message.target = Constants.TARGET_FORE;
        setControlHost(str, message);
        ALog.e(TAG, "buildFgId = ", message.dataId);
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.type(3, ReqType.DATA, 1);
        message.packageName = str;
        message.target = Constants.TARGET_CONTROL;
        message.command = 200;
        return message;
    }

    public static Message buildMassMessage(String str, String str2, String str3, String str4, String str5, Context context) {
        return buildSendData(str4, str5, "", context, context.getPackageName(), new ACCSManager.AccsRequest("", Constants.TARGET_SERVICE_MASS, kd1.a(context, str, str3, str2), ""));
    }

    public static Message buildParameterError(String str, int i) {
        Message message = new Message();
        message.type(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i);
        message.packageName = str;
        return message;
    }

    @Deprecated
    public static Message buildPushAck(BaseConnection baseConnection, String str, String str2, String str3, boolean z, short s, String str4, Map<Integer, String> map) {
        return buildPushAck(baseConnection.getHost(null), baseConnection.mConfigTag, str, str2, str3, z, s, str4, map);
    }

    @Deprecated
    public static Message buildRequest(BaseConnection baseConnection, Context context, String str, String str2, String str3, ACCSManager.AccsRequest accsRequest, boolean z) {
        return buildRequest(context, baseConnection.getHost(null), baseConnection.mConfigTag, baseConnection.mConfig.getStoreId(), str, str2, accsRequest, z);
    }

    @Deprecated
    public static Message buildSendData(BaseConnection baseConnection, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(baseConnection.getHost(null), baseConnection.mConfigTag, baseConnection.mConfig.getStoreId(), context, str, accsRequest, true);
    }

    @Deprecated
    public static Message buildUnbindApp(BaseConnection baseConnection, Context context, Intent intent) {
        return buildUnbindApp(baseConnection.getHost(null), intent);
    }

    @Deprecated
    public static Message buildUnbindService(BaseConnection baseConnection, Context context, Intent intent) {
        return buildUnbindService(baseConnection.getHost(null), baseConnection.mConfigTag, intent);
    }

    @Deprecated
    public static Message buildUnbindUser(BaseConnection baseConnection, Context context, Intent intent) {
        return buildUnbindUser(baseConnection.getHost(null), baseConnection.mConfigTag, intent);
    }

    private static void fillExtHeader(Context context, Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.extHeader = new HashMap();
        if (str5 != null && UtilityImpl.getByteLen(str5) <= 1023) {
            message.extHeader.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.getByteLen(str) <= 1023) {
            message.extHeader.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.getByteLen(str2) <= 1023) {
            message.extHeader.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.getByteLen(str6) <= 1023) {
            message.extHeader.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.getByteLen(str4) <= 1023) {
            message.extHeader.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.getByteLen(str3) > 1023) {
            return;
        }
        message.extHeader.put(19, str3);
    }

    private String getTag() {
        return TAG + JSMethod.NOT_SET + this.tag;
    }

    private static void setControlHost(String str, Message message) {
        try {
            message.host = new URL(str);
        } catch (Exception e) {
            ALog.e(TAG, "setControlHost", e, new Object[0]);
        }
    }

    private void setPushAckFlag(short s, boolean z) {
        this.type = 1;
        this.flags = s;
        short s2 = (short) (s & (-16385));
        this.flags = s2;
        short s3 = (short) (s2 | 8192);
        this.flags = s3;
        short s4 = (short) (s3 & (-2049));
        this.flags = s4;
        short s5 = (short) (s4 & (-65));
        this.flags = s5;
        if (z) {
            this.flags = (short) (s5 | 32);
        }
    }

    private static void setUnit(String str, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.host = new URL(str);
                return;
            } catch (MalformedURLException e) {
                ALog.e(TAG, "setUnit", e, new Object[0]);
                e.printStackTrace();
                return;
            }
        }
        message.host = url;
    }

    private void type(int i, ReqType reqType, int i2) {
        this.type = i;
        if (i != 2) {
            this.flags = (short) (((((i & 1) << 4) | (reqType.ordinal() << 2)) | i2) << 11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtility.JsonObjectBuilder buidJsonObject() {
        return new JsonUtility.JsonObjectBuilder().put("command", this.command.intValue() == 100 ? null : this.command).put("appKey", this.appKey).put(Constants.KEY_OS_TYPE, this.osType).put("sign", this.appSign).put("sdkVersion", this.sdkVersion).put("appVersion", this.appVersion).put("ttid", this.ttid).put("model", this.model).put("brand", this.brand).put("imei", this.imei).put("imsi", this.imsi).put(Constants.KYE_MAC_ADDRESS, this.macAddress).put("os", this.osVersion).put(Constants.KEY_EXTS, this.exts);
    }

    public byte[] build(Context context, int i) {
        return build(context, i, null);
    }

    void buildData() throws JSONException, UnsupportedEncodingException {
        Integer num = this.command;
        if (num == null || num.intValue() == 100 || this.command.intValue() == 102) {
            return;
        }
        this.data = buidJsonObject().build().toString().getBytes("utf-8");
    }

    void compressData() {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
            } catch (Throwable th2) {
                gZIPOutputStream = null;
                th = th2;
                byteArrayOutputStream = null;
            }
            if (this.data == null) {
                return;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th3) {
                gZIPOutputStream = null;
                th = th3;
            }
            try {
                gZIPOutputStream.write(this.data);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray != null && byteArray.length < this.data.length) {
                    this.data = byteArray;
                    this.compress = (byte) 1;
                }
                gZIPOutputStream.close();
            } catch (Throwable th4) {
                th = th4;
                try {
                    Log.e(getTag(), th.toString());
                    th.printStackTrace();
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    if (byteArrayOutputStream == null) {
                        return;
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused) {
                            throw th5;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th5;
                }
            }
            byteArrayOutputStream.close();
        } catch (Exception unused2) {
        }
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    short getExtHeaderLen(Map<Integer, String> map) {
        short s = 0;
        if (map != null) {
            try {
                for (Integer num : map.keySet()) {
                    String str = map.get(Integer.valueOf(num.intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        s = (short) (s + ((short) (str.getBytes("utf-8").length & 1023)) + 2);
                    }
                }
            } catch (Exception e) {
                e.toString();
            }
        }
        return s;
    }

    public Id getMsgId() {
        return this.msgId;
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.netPerformanceMonitor;
    }

    public int getNode() {
        return this.node;
    }

    public String getPackageName() {
        String str = this.packageName;
        return str == null ? "" : str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public String getTarget() {
        return this.target;
    }

    public int getType() {
        return this.type;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.target);
    }

    public boolean isForeBgMessage() {
        return Constants.TARGET_FORE.equals(this.target) || Constants.TARGET_BACK.equals(this.target);
    }

    public boolean isTimeOut() {
        boolean z = (System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout);
        if (z) {
            String tag = getTag();
            ALog.e(tag, "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z;
    }

    void printByte(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(getTag(), "len:" + bArr.length, new Object[0]);
            if (bArr.length < 512) {
                for (byte b : bArr) {
                    sb.append(Integer.toHexString(b & 255));
                    sb.append(" ");
                }
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(getTag(), sb.toString(), new Object[0]);
                }
            }
        }
    }

    public void setSendTime(long j) {
        this.sendTime = j;
    }

    public static Message buildBindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindService(intent.getStringExtra("packageName"), intent.getStringExtra("serviceId"));
            message.tag = str2;
            setControlHost(str, message);
            return message;
        } catch (Exception e) {
            ALog.e(TAG, "buildBindService", e, new Object[0]);
            e.printStackTrace();
            return message;
        }
    }

    public static Message buildBindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindUser(intent.getStringExtra("packageName"), intent.getStringExtra(Constants.KEY_USER_ID));
            if (message != null) {
                message.tag = str2;
                setControlHost(str, message);
            }
        } catch (Exception e) {
            ALog.e(TAG, "buildBindUser", e, new Object[0]);
            e.printStackTrace();
        }
        return message;
    }

    public static Message buildPushAck(String str, String str2, String str3, String str4, String str5, boolean z, short s, String str6, Map<Integer, String> map) {
        Message message = new Message();
        message.node = 1;
        message.setPushAckFlag(s, z);
        message.source = str3;
        message.target = str4;
        message.dataId = str5;
        message.isAck = true;
        message.extHeader = map;
        try {
            if (TextUtils.isEmpty(str6)) {
                message.host = new URL(str);
            } else {
                message.host = new URL(str6);
            }
            message.tag = str2;
            if (message.host == null) {
                message.host = new URL(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, String str3, String str4, String str5, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        boolean z2 = true;
        message.node = 1;
        message.type(1, ReqType.REQ, 1);
        message.command = 100;
        message.packageName = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.data = accsRequest.data;
        String str6 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str6);
        sb.append("|");
        String str7 = accsRequest.target;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        message.target = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        message.tag = str2;
        int i = accsRequest.timeout;
        if (i > 0) {
            message.timeout = i;
        }
        if (z) {
            setUnit(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        fillExtHeader(context, message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.mCookieSec, accsRequest.businessId, accsRequest.tag);
        if (OrangeAdapter.normalChangesEnabled()) {
            try {
                z2 = ACCSClient.getAccsClient(str2).isAccsConnected();
            } catch (AccsException unused) {
            }
        }
        if (z2) {
            NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
            message.netPerformanceMonitor = netPerformanceMonitor;
            netPerformanceMonitor.setDataId(accsRequest.dataId);
            message.netPerformanceMonitor.setServiceId(accsRequest.serviceId);
            message.netPerformanceMonitor.setHost(message.host.toString());
        }
        message.tag = str2;
        return message;
    }

    @Deprecated
    public static Message buildSendData(BaseConnection baseConnection, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z) {
        return buildSendData(baseConnection.getHost(null), baseConnection.mConfigTag, baseConnection.mConfig.getStoreId(), context, str, accsRequest, z);
    }

    public static Message buildUnbindApp(String str, Intent intent) {
        ALog.e(TAG, "buildUnbindApp1" + UtilityImpl.getStackMsg(new Exception()), new Object[0]);
        Message message = null;
        try {
            message = buildUnbindApp(str, intent.getStringExtra("packageName"));
            setControlHost(str, message);
            return message;
        } catch (Exception e) {
            ALog.e(TAG, "buildUnbindApp1", e.getMessage());
            return message;
        }
    }

    public static Message buildUnbindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindService(intent.getStringExtra("packageName"), intent.getStringExtra("serviceId"));
            message.tag = str2;
            setControlHost(str, message);
            return message;
        } catch (Exception e) {
            ALog.e(TAG, "buildUnbindService", e, new Object[0]);
            e.printStackTrace();
            return message;
        }
    }

    public static Message buildUnbindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindUser(intent.getStringExtra("packageName"));
            message.tag = str2;
            setControlHost(str, message);
            return message;
        } catch (Exception e) {
            ALog.e(TAG, "buildUnbindUser", e, new Object[0]);
            e.printStackTrace();
            return message;
        }
    }

    public byte[] build(Context context, int i, Boolean bool) {
        byte[] bytes;
        try {
            buildData();
        } catch (UnsupportedEncodingException e) {
            ALog.e(getTag(), "build2", e, new Object[0]);
        } catch (JSONException e2) {
            ALog.e(getTag(), "build1", e2, new Object[0]);
        }
        byte[] bArr = this.data;
        String str = bArr != null ? new String(bArr) : "";
        compressData();
        if (!this.isAck) {
            StringBuilder sb = new StringBuilder();
            sb.append(OrangeAdapter.isRegIdSwitchEnableAndValid(context) ? OrangeAdapter.getRegId(context) : UtilityImpl.getDeviceId(context));
            sb.append("|");
            sb.append(this.packageName);
            sb.append("|");
            String str2 = this.serviceId;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("|");
            String str3 = this.userinfo;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.source = sb.toString();
        }
        try {
            bytes = (this.dataId + "").getBytes("utf-8");
            this.sourceLength = (byte) this.source.getBytes("utf-8").length;
            this.targetLength = (byte) this.target.getBytes("utf-8").length;
        } catch (Exception e3) {
            e3.printStackTrace();
            ALog.e(getTag(), "build3", e3, new Object[0]);
            bytes = (this.dataId + "").getBytes();
            this.sourceLength = (byte) this.source.getBytes().length;
            this.targetLength = (byte) this.target.getBytes().length;
        }
        short extHeaderLen = getExtHeaderLen(this.extHeader);
        boolean z = true;
        int length = this.targetLength + 3 + 1 + this.sourceLength + 1 + bytes.length;
        byte[] bArr2 = this.data;
        short length2 = (short) (length + (bArr2 == null ? 0 : bArr2.length) + extHeaderLen + 2);
        this.dataLength = length2;
        this.totalLength = (short) (length2 + 2);
        MessageStreamBuilder messageStreamBuilder = new MessageStreamBuilder(this.totalLength + 2 + 4);
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(getTag(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            messageStreamBuilder.writeByte((byte) (this.compress | 32));
            if (ALog.isPrintLog(level)) {
                String tag = getTag();
                ALog.d(tag, "\tversion:2 compress:" + ((int) this.compress), new Object[0]);
            }
            if (i == 0) {
                messageStreamBuilder.writeByte(cu2.MAX_POWER_OF_TWO);
                if (ALog.isPrintLog(level)) {
                    ALog.d(getTag(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                if (!OrangeAdapter.isChannelModeEnable() || !OrangeAdapter.isForeBgStateInMessage()) {
                    z = false;
                }
                if (z && bool != null) {
                    if (bool.booleanValue()) {
                        messageStreamBuilder.writeByte((byte) 80);
                    } else {
                        messageStreamBuilder.writeByte((byte) 96);
                    }
                } else {
                    messageStreamBuilder.writeByte(SignedBytes.MAX_POWER_OF_TWO);
                }
                if (ALog.isPrintLog(level)) {
                    ALog.d(getTag(), "\tflag: 0x40", new Object[0]);
                }
            }
            messageStreamBuilder.writeShort(this.totalLength);
            if (ALog.isPrintLog(level)) {
                String tag2 = getTag();
                ALog.d(tag2, "\ttotalLength:" + ((int) this.totalLength), new Object[0]);
            }
            messageStreamBuilder.writeShort(this.dataLength);
            if (ALog.isPrintLog(level)) {
                String tag3 = getTag();
                ALog.d(tag3, "\tdataLength:" + ((int) this.dataLength), new Object[0]);
            }
            messageStreamBuilder.writeShort(this.flags);
            if (ALog.isPrintLog(level)) {
                String tag4 = getTag();
                ALog.d(tag4, "\tflags:" + Integer.toHexString(this.flags), new Object[0]);
            }
            messageStreamBuilder.writeByte(this.targetLength);
            if (ALog.isPrintLog(level)) {
                String tag5 = getTag();
                ALog.d(tag5, "\ttargetLength:" + ((int) this.targetLength), new Object[0]);
            }
            messageStreamBuilder.write(this.target.getBytes("utf-8"));
            if (ALog.isPrintLog(level)) {
                String tag6 = getTag();
                ALog.d(tag6, "\ttarget:" + this.target, new Object[0]);
            }
            messageStreamBuilder.writeByte(this.sourceLength);
            if (ALog.isPrintLog(level)) {
                String tag7 = getTag();
                ALog.d(tag7, "\tsourceLength:" + ((int) this.sourceLength), new Object[0]);
            }
            messageStreamBuilder.write(this.source.getBytes("utf-8"));
            if (ALog.isPrintLog(level)) {
                String tag8 = getTag();
                ALog.d(tag8, "\tsource:" + this.source, new Object[0]);
            }
            messageStreamBuilder.writeByte((byte) bytes.length);
            if (ALog.isPrintLog(level)) {
                String tag9 = getTag();
                ALog.d(tag9, "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            messageStreamBuilder.write(bytes);
            if (ALog.isPrintLog(level)) {
                String tag10 = getTag();
                ALog.d(tag10, "\tdataId:" + new String(bytes), new Object[0]);
            }
            messageStreamBuilder.writeShort(extHeaderLen);
            if (ALog.isPrintLog(level)) {
                String tag11 = getTag();
                ALog.d(tag11, "\textHeader len:" + ((int) extHeaderLen), new Object[0]);
            }
            Map<Integer, String> map = this.extHeader;
            if (map != null) {
                for (Integer num : map.keySet()) {
                    int intValue = num.intValue();
                    String str4 = this.extHeader.get(Integer.valueOf(intValue));
                    if (!TextUtils.isEmpty(str4)) {
                        messageStreamBuilder.writeShort((short) ((((short) intValue) << 10) | ((short) (str4.getBytes("utf-8").length & 1023))));
                        messageStreamBuilder.write(str4.getBytes("utf-8"));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            String tag12 = getTag();
                            ALog.d(tag12, "\textHeader key:" + intValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            byte[] bArr3 = this.data;
            if (bArr3 != null) {
                messageStreamBuilder.write(bArr3);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                String tag13 = getTag();
                ALog.d(tag13, "\toriData:" + str, new Object[0]);
            }
            messageStreamBuilder.flush();
        } catch (IOException e4) {
            ALog.e(getTag(), "build4", e4, new Object[0]);
        }
        byte[] byteArray = messageStreamBuilder.toByteArray();
        try {
            messageStreamBuilder.close();
        } catch (IOException e5) {
            ALog.e(getTag(), "build5", e5, new Object[0]);
        }
        return byteArray;
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(str, str2, str3, context, str4, accsRequest, true);
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        boolean z2 = true;
        message.node = 1;
        message.type(1, ReqType.DATA, 1);
        message.command = 100;
        message.packageName = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.data = accsRequest.data;
        String str5 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str5);
        sb.append("|");
        String str6 = accsRequest.target;
        if (str6 == null) {
            str6 = "";
        }
        sb.append(str6);
        message.target = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        int i = accsRequest.timeout;
        if (i > 0) {
            message.timeout = i;
        }
        if (z) {
            setUnit(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        fillExtHeader(context, message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.mCookieSec, accsRequest.businessId, accsRequest.tag);
        if (OrangeAdapter.normalChangesEnabled()) {
            try {
                z2 = ACCSClient.getAccsClient(str2).isAccsConnected();
            } catch (AccsException unused) {
            }
        }
        if (z2) {
            NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
            message.netPerformanceMonitor = netPerformanceMonitor;
            netPerformanceMonitor.setDataId(accsRequest.dataId);
            message.netPerformanceMonitor.setServiceId(accsRequest.serviceId);
            message.netPerformanceMonitor.setHost(message.host.toString());
        }
        message.tag = str2;
        return message;
    }

    @Deprecated
    public static Message buildUnbindApp(BaseConnection baseConnection, Context context, String str, String str2, String str3, String str4) {
        return buildUnbindApp(baseConnection.getHost(null), str);
    }

    public static Message buildUnbindApp(String str, String str2) {
        Message message;
        Message message2 = null;
        try {
            ALog.d(TAG, "buildUnbindApp", new Object[0]);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (OrangeAdapter.isRegIdSwitchEnable(GlobalClientInfo.getContext())) {
                message = new MessageV2();
            } else {
                message = new Message();
            }
            message2 = message;
            message2.node = 1;
            message2.type(1, ReqType.DATA, 1);
            message2.packageName = str2;
            message2.target = Constants.TARGET_CONTROL;
            message2.command = 2;
            message2.packageName = str2;
            message2.sdkVersion = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
            message2.cunstomDataId = KEY_UNBINDAPP;
            setControlHost(str, message2);
            return message2;
        } catch (Exception e) {
            ALog.e(TAG, "buildUnbindApp", e.getMessage());
            return message2;
        }
    }

    @Deprecated
    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildUnbindUser(str);
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Message message;
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (OrangeAdapter.isRegIdSwitchEnable(context)) {
            message = new MessageV2();
        } else {
            message = new Message();
        }
        message.node = 1;
        message.type(1, ReqType.DATA, 1);
        message.osType = 1;
        message.osVersion = Build.VERSION.SDK_INT + "";
        message.packageName = str4;
        message.target = Constants.TARGET_CONTROL;
        message.command = 1;
        message.appKey = str2;
        message.appSign = UtilityImpl.getAppsign(context, str2, str3, UtilityImpl.getDeviceId(context), str, (configByTag == null || 2 != configByTag.getSecurity()) ? 1 : 0);
        message.sdkVersion = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
        message.appVersion = str6;
        message.packageName = str4;
        message.ttid = str5;
        message.model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        message.brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
        message.cunstomDataId = KEY_BINDAPP;
        message.tag = str;
        message.exts = new JsonUtility.JsonObjectBuilder().put("notifyEnable", UtilityImpl.isNotificationEnabled(context)).put("romInfo", RomInfoCollecter.getCollecter().collect()).build().toString();
        UtilityImpl.saveNotificationState(context, Constants.SP_FILE_NAME, UtilityImpl.isNotificationEnabled(context));
        return message;
    }

    @Deprecated
    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildBindService(str, str3);
    }

    @Deprecated
    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildBindUser(str, str4);
    }

    @Deprecated
    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildUnbindService(str, str3);
    }

    public static Message buildUnbindUser(String str) {
        Message message;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (OrangeAdapter.isRegIdSwitchEnable(GlobalClientInfo.getContext())) {
            message = new MessageV2();
        } else {
            message = new Message();
        }
        message.node = 1;
        message.type(1, ReqType.DATA, 1);
        message.packageName = str;
        message.target = Constants.TARGET_CONTROL;
        message.command = 4;
        message.sdkVersion = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    public static Message buildBindService(String str, String str2) {
        Message message;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (OrangeAdapter.isRegIdSwitchEnable(GlobalClientInfo.getContext())) {
            message = new MessageV2();
        } else {
            message = new Message();
        }
        message.node = 1;
        message.type(1, ReqType.DATA, 1);
        message.packageName = str;
        message.serviceId = str2;
        message.target = Constants.TARGET_CONTROL;
        message.command = 5;
        message.packageName = str;
        message.serviceId = str2;
        message.sdkVersion = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(String str, String str2) {
        Message message;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (OrangeAdapter.isRegIdSwitchEnable(GlobalClientInfo.getContext())) {
            message = new MessageV2();
        } else {
            message = new Message();
        }
        message.node = 1;
        message.type(1, ReqType.DATA, 1);
        message.packageName = str;
        message.userinfo = str2;
        message.target = Constants.TARGET_CONTROL;
        message.command = 3;
        message.packageName = str;
        message.userinfo = str2;
        message.sdkVersion = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildUnbindService(String str, String str2) {
        Message message;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (OrangeAdapter.isRegIdSwitchEnable(GlobalClientInfo.getContext())) {
            message = new MessageV2();
        } else {
            message = new Message();
        }
        message.node = 1;
        message.type(1, ReqType.DATA, 1);
        message.packageName = str;
        message.serviceId = str2;
        message.target = Constants.TARGET_CONTROL;
        message.command = 6;
        message.packageName = str;
        message.serviceId = str2;
        message.sdkVersion = Integer.valueOf((int) Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }
}
