package mtopsdk.xstate;

import android.content.Context;
import android.os.RemoteException;
import com.ta.utdid2.device.UTDevice;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.AsyncServiceBinder;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.aidl.IXState;
import mtopsdk.xstate.util.PhoneInfo;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class XState {
    private static final String PARAMETER_DEVICEID = "deviceId";
    private static final String TAG = "mtopsdk.XState";
    private static AsyncServiceBinder<IXState> asyncServiceBinder;
    private static final ConcurrentHashMap<String, String> localMap = new ConcurrentHashMap<>();
    private static AtomicBoolean isInited = new AtomicBoolean(false);
    static volatile AtomicBoolean isSyncToRemote = new AtomicBoolean(false);
    private static Context mContext = null;

    private static boolean checkBindAndRetryAsyncBind() {
        AsyncServiceBinder<IXState> asyncServiceBinder2 = asyncServiceBinder;
        if (asyncServiceBinder2 == null) {
            return false;
        }
        if (asyncServiceBinder2.getService() != null) {
            return true;
        }
        asyncServiceBinder.asyncBind(mContext);
        return false;
    }

    public static String getLat() {
        return getValue("lat");
    }

    public static String getLng() {
        return getValue("lng");
    }

    public static String getNetworkQuality() {
        return getValue(XStateConstants.KEY_NQ);
    }

    public static String getNetworkType() {
        return getValue("netType");
    }

    public static String getTimeOffset() {
        return getValue(XStateConstants.KEY_TIME_OFFSET);
    }

    public static String getValue(String str) {
        return getValue(null, str);
    }

    public static void init(Context context, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            try {
                String str = (String) hashMap.get("deviceId");
                if (str != null) {
                    localMap.put("utdid", str);
                }
            } catch (Throwable unused) {
                TBSdkLog.e(TAG, "[init]init error, params get exception");
                return;
            }
        }
        init(context);
    }

    private static void initPhoneInfo(Context context) {
        String utdid;
        try {
            String phoneBaseInfo = PhoneInfo.getPhoneBaseInfo(context);
            if (phoneBaseInfo != null) {
                localMap.put("ua", phoneBaseInfo);
            }
            ConcurrentHashMap<String, String> concurrentHashMap = localMap;
            if (concurrentHashMap.get("utdid") == null && (utdid = UTDevice.getUtdid(context)) != null) {
                concurrentHashMap.put("utdid", utdid);
            }
            concurrentHashMap.put(XStateConstants.KEY_TIME_OFFSET, "0");
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[initPhoneInfo]initPhoneInfo error", th);
        }
    }

    public static boolean isAppBackground() {
        String value = getValue(XStateConstants.KEY_APP_BACKGROUND);
        if (value != null) {
            try {
                return Boolean.valueOf(value).booleanValue();
            } catch (Exception unused) {
                TBSdkLog.e(TAG, "[isAppBackground] parse KEY_APP_BACKGROUND error");
            }
        }
        return false;
    }

    public static String removeKey(String str) {
        return removeKey(null, str);
    }

    public static void setAppBackground(boolean z) {
        setValue(XStateConstants.KEY_APP_BACKGROUND, String.valueOf(z));
    }

    public static void setValue(String str, String str2) {
        setValue(null, str, str2);
    }

    static void syncToRemote() {
        if (checkBindAndRetryAsyncBind()) {
            IXState service = asyncServiceBinder.getService();
            try {
                service.init();
                for (Map.Entry<String, String> entry : localMap.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    try {
                        service.setValue(key, value);
                        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.i(TAG, "[syncToRemote] sync succeed, key:" + key + ",value:" + value);
                        }
                    } catch (Exception e) {
                        TBSdkLog.e(TAG, "[syncToRemote] sync error, key:" + key + ",value:" + value, e);
                    }
                }
                isSyncToRemote.compareAndSet(false, true);
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "syncToRemote error.", th);
            }
        }
    }

    public static void unInit() {
        if (checkBindAndRetryAsyncBind()) {
            try {
                asyncServiceBinder.getService().unInit();
            } catch (RemoteException e) {
                TBSdkLog.e(TAG, "[unInit] unInit error", e);
            }
        }
        localMap.clear();
        isInited.set(false);
    }

    public static String getValue(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            return null;
        }
        if (StringUtils.isNotBlank(str)) {
            str2 = StringUtils.concatStr(str, str2);
        }
        if (checkBindAndRetryAsyncBind() && isSyncToRemote.get()) {
            try {
                return asyncServiceBinder.getService().getValue(str2);
            } catch (Exception e) {
                TBSdkLog.e(TAG, "[getValue] IXState.getValue(Key) failed,key:" + str2, e);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[getValue]Attention :Use XState Local Mode: key:" + str2);
                }
                return localMap.get(str2);
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[getValue]Attention :Use XState Local Mode: key:" + str2);
        }
        return localMap.get(str2);
    }

    public static String removeKey(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            return null;
        }
        if (StringUtils.isNotBlank(str)) {
            str2 = StringUtils.concatStr(str, str2);
        }
        if (checkBindAndRetryAsyncBind() && isSyncToRemote.get()) {
            try {
                return asyncServiceBinder.getService().removeKey(str2);
            } catch (Exception e) {
                TBSdkLog.e(TAG, "[removeKey] IXState.removeKey(key) failed,key:" + str2, e);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[removeKey]Attention :Use XState Local Mode: key:" + str2);
                }
                localMap.remove(str2);
            }
        } else {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[removeKey]Attention :Use XState Local Mode: key:" + str2);
            }
            localMap.remove(str2);
        }
        return null;
    }

    public static void setValue(String str, String str2, String str3) {
        if (StringUtils.isBlank(str2) || StringUtils.isBlank(str3)) {
            return;
        }
        if (StringUtils.isNotBlank(str)) {
            str2 = StringUtils.concatStr(str, str2);
        }
        if (checkBindAndRetryAsyncBind() && isSyncToRemote.get()) {
            try {
                asyncServiceBinder.getService().setValue(str2, str3);
                return;
            } catch (Exception e) {
                TBSdkLog.e(TAG, "[setValue] IXState.setValue(key,value) failed,key:" + str2 + ",value:" + str3, e);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[setValue]Attention :Use XState Local Mode: key:" + str2 + ",value:" + str3);
                }
                localMap.put(str2, str3);
                return;
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
            TBSdkLog.i(TAG, "[setValue]Attention :Use XState Local Mode: key:" + str2 + ",value:" + str3);
        }
        localMap.put(str2, str3);
    }

    public static void init(Context context) {
        if (context == null) {
            TBSdkLog.e(TAG, "[init]init error,context is null");
        } else if (isInited.compareAndSet(false, true)) {
            mContext = context.getApplicationContext();
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[init]XState init called");
            }
            initPhoneInfo(context);
            if (asyncServiceBinder == null) {
                AsyncServiceBinder<IXState> asyncServiceBinder2 = new AsyncServiceBinder<IXState>(IXState.class, XStateService.class) { // from class: mtopsdk.xstate.XState.1
                    @Override // mtopsdk.common.util.AsyncServiceBinder
                    protected void afterAsyncBind() {
                        XState.isSyncToRemote.compareAndSet(true, false);
                        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.xstate.XState.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                XState.syncToRemote();
                            }
                        });
                    }
                };
                asyncServiceBinder = asyncServiceBinder2;
                asyncServiceBinder2.asyncBind(context);
                return;
            }
            syncToRemote();
        }
    }
}
