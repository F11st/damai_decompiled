package mtopsdk.mtop.deviceid;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import mtopsdk.common.util.ConfigStoreManager;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.deviceid.domain.MtopSysNewDeviceIdRequest;
import mtopsdk.mtop.deviceid.domain.MtopSysNewDeviceIdResponse;
import mtopsdk.mtop.deviceid.domain.MtopSysNewDeviceIdResponseData;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.PhoneInfo;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DeviceIDManager {
    private static final String CREATED_NO = "0";
    private static final String CREATED_YES = "1";
    private static final String DEVICEID_CREATED_KEY = "deviceId_created";
    private static final String DEVICEID_KEY = "deviceId";
    private static final String MTOPSDK_DEVICEID_STORE_PREFIX = "MTOPSDK_DEVICEID_STORE.";
    private static final String TAG = "mtopsdk.DeviceIDManager";
    private static Map<String, DeviceIdDomain> deviceIdMap = new HashMap();
    private static DeviceIDManager instance;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class DeviceIdDomain {
        public boolean mCreated;
        public String mDeviceId;
        public Future<String> mLastFuture;

        public DeviceIdDomain(Future<String> future) {
            this.mLastFuture = future;
        }
    }

    public static DeviceIDManager getInstance() {
        if (instance == null) {
            synchronized (DeviceIDManager.class) {
                if (instance == null) {
                    instance = new DeviceIDManager();
                }
            }
        }
        return instance;
    }

    private void saveDeviceIdToStore(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        ConfigStoreManager configStoreManager = ConfigStoreManager.getInstance();
        configStoreManager.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, MTOPSDK_DEVICEID_STORE_PREFIX + str, "deviceId", str2);
        ConfigStoreManager configStoreManager2 = ConfigStoreManager.getInstance();
        configStoreManager2.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, MTOPSDK_DEVICEID_STORE_PREFIX + str, DEVICEID_CREATED_KEY, str3);
        DeviceIdDomain deviceIdDomain = deviceIdMap.get(str);
        if (deviceIdDomain == null) {
            deviceIdDomain = new DeviceIdDomain(null);
        }
        deviceIdDomain.mDeviceId = str2;
        deviceIdDomain.mCreated = true;
        deviceIdMap.put(str, deviceIdDomain);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("[saveDeviceIdToStore] appkey=");
            sb.append(str);
            sb.append("; deviceId=");
            sb.append(str2);
            sb.append("; mCreated=");
            sb.append(str3);
            TBSdkLog.i(TAG, sb.toString());
        }
    }

    public void clear(Context context, String str) {
        deviceIdMap.remove(str);
        saveDeviceIdToStore(context, str, "", "0");
    }

    public Future<String> getDeviceID(final Context context, final String str) {
        Future<String> future;
        if (StringUtils.isBlank(str)) {
            TBSdkLog.e(TAG, "appkey is null,get DeviceId error");
            return null;
        }
        DeviceIdDomain deviceIdDomain = deviceIdMap.get(str);
        if (deviceIdDomain != null && (future = deviceIdDomain.mLastFuture) != null && !future.isDone()) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[getDeviceID] appKey=" + str + " return mLastFuture");
            }
            return future;
        }
        final FutureTask futureTask = new FutureTask(new Callable<String>() { // from class: mtopsdk.mtop.deviceid.DeviceIDManager.1
            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                String localDeviceID = DeviceIDManager.this.getLocalDeviceID(context, str);
                String localUtdid = DeviceIDManager.this.getLocalUtdid(context);
                if (StringUtils.isBlank(localDeviceID) || StringUtils.isBlank(localUtdid)) {
                    localDeviceID = DeviceIDManager.this.getRemoteDeviceID(context, str);
                }
                if (StringUtils.isNotBlank(localDeviceID)) {
                    Mtop.instance(Mtop.Id.INNER, (Context) null).registerDeviceId(localDeviceID);
                }
                return localDeviceID;
            }
        });
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.mtop.deviceid.DeviceIDManager.2
            @Override // java.lang.Runnable
            public void run() {
                futureTask.run();
            }
        });
        deviceIdMap.put(str, new DeviceIdDomain(futureTask));
        return futureTask;
    }

    public String getLocalDeviceID(Context context, String str) {
        DeviceIdDomain deviceIdDomain = deviceIdMap.get(str);
        if (deviceIdDomain == null || !StringUtils.isNotBlank(deviceIdDomain.mDeviceId)) {
            if (context == null) {
                return null;
            }
            ConfigStoreManager configStoreManager = ConfigStoreManager.getInstance();
            String configItem = configStoreManager.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, MTOPSDK_DEVICEID_STORE_PREFIX + str, "deviceId");
            ConfigStoreManager configStoreManager2 = ConfigStoreManager.getInstance();
            if ("1".equalsIgnoreCase(configStoreManager2.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, MTOPSDK_DEVICEID_STORE_PREFIX + str, DEVICEID_CREATED_KEY))) {
                DeviceIdDomain deviceIdDomain2 = new DeviceIdDomain(null);
                deviceIdDomain2.mDeviceId = configItem;
                deviceIdDomain2.mCreated = true;
                deviceIdMap.put(str, deviceIdDomain2);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[getLocalDeviceID]get DeviceId from store appkey=" + str + "; deviceId=" + configItem);
            }
            return configItem;
        }
        return deviceIdDomain.mDeviceId;
    }

    public String getLocalUtdid(Context context) {
        String value = XState.getValue("utdid");
        if (StringUtils.isNotBlank(value)) {
            Mtop.instance(Mtop.Id.INNER, (Context) null).registerUtdid(value);
            return value;
        } else if (context == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.w(TAG, "[getLocalUtdid] Context is null,get Utdid failed");
            }
            return null;
        } else {
            String utdid = UTDevice.getUtdid(context);
            Mtop.instance(Mtop.Id.INNER, (Context) null).registerUtdid(utdid);
            return utdid;
        }
    }

    String getRemoteDeviceID(Context context, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[getRemoteDeviceID] called!appkey=" + str);
        }
        String localUtdid = getLocalUtdid(context);
        if (Boolean.parseBoolean(XState.getValue(XStateConstants.KEY_REMOVE_DEVICE_INFO))) {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        } else {
            str2 = PhoneInfo.getOriginalImei(context);
            str3 = PhoneInfo.getOriginalImsi(context);
            str4 = PhoneInfo.getSerialNum();
            str5 = PhoneInfo.getAndroidId(context);
        }
        StringBuilder sb = new StringBuilder(64);
        if (StringUtils.isNotBlank(localUtdid)) {
            sb.append(localUtdid);
        }
        if (StringUtils.isNotBlank(str2)) {
            sb.append(str2);
        }
        if (StringUtils.isNotBlank(str3)) {
            sb.append(str3);
        }
        String str6 = null;
        if (StringUtils.isBlank(sb.toString())) {
            TBSdkLog.e(TAG, "[getRemoteDeviceID]device_global_id is blank");
            return null;
        }
        MtopSysNewDeviceIdRequest mtopSysNewDeviceIdRequest = new MtopSysNewDeviceIdRequest();
        mtopSysNewDeviceIdRequest.device_global_id = sb.toString();
        mtopSysNewDeviceIdRequest.new_device = true;
        mtopSysNewDeviceIdRequest.c0 = Build.getBRAND();
        mtopSysNewDeviceIdRequest.c1 = Build.getMODEL();
        mtopSysNewDeviceIdRequest.c2 = str2;
        mtopSysNewDeviceIdRequest.c3 = str3;
        mtopSysNewDeviceIdRequest.c4 = "";
        mtopSysNewDeviceIdRequest.c5 = str4;
        mtopSysNewDeviceIdRequest.c6 = str5;
        MtopResponse syncRequest = Mtop.instance(Mtop.Id.INNER, (Context) null).build((IMTOPDataObject) mtopSysNewDeviceIdRequest, (String) null).setBizId(4099).syncRequest();
        if (!syncRequest.isApiSuccess()) {
            return null;
        }
        try {
            BaseOutDo baseOutDo = (BaseOutDo) MtopConvert.convertJsonToOutputDO(syncRequest.getBytedata(), MtopSysNewDeviceIdResponse.class);
            if (baseOutDo != null) {
                String str7 = ((MtopSysNewDeviceIdResponseData) baseOutDo.getData()).device_id;
                try {
                    if (StringUtils.isNotBlank(str7)) {
                        saveDeviceIdToStore(context, str, str7, "1");
                    }
                    return str7;
                } catch (Throwable th) {
                    th = th;
                    str6 = str7;
                    TBSdkLog.e(TAG, "[getRemoteDeviceID] error ---" + th.toString());
                    return str6;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
