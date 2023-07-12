package com.alimm.xadsdk.info;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.core.AdThreadPoolExecutor;
import com.alimm.xadsdk.base.utils.LogUtils;
import com.alimm.xadsdk.base.utils.Utils;
import com.alimm.xadsdk.info.AdvertisingIdClient;
import com.taobao.weex.annotation.JSMethod;
import java.net.NetworkInterface;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DeviceInfo {
    private static final String DEFAULT_MAC_ADDR = "00:00:00:00:00:00";
    private static final int DELAY_GET_OAID_TIME = 10000;
    private static final String DEVICE_PAD = "pad";
    private static final String DEVICE_PHONE = "phone";
    private static final String DEVICE_TV = "tv";
    private static final String OS_ALI_YUN = "YunOS";
    private static final String OS_ANDROID = "Android";
    private static final String OTT_HARDWARE_TYPE_ALI_FUN = "3";
    private static final String OTT_HARDWARE_TYPE_ALLIANCE = "2";
    private static final String OTT_HARDWARE_TYPE_MAGIC_BOX = "1";
    private static final String OTT_HARDWARE_TYPE_MAGIC_PROJECTOR = "4";
    private static final String OTT_HARDWARE_TYPE_UNKNOWN = "0";
    private static final String PREF_AD_DEVICE_ID = "mm_adsdk_device_ids";
    private static final String PREF_KEY_AAID = "device_aaid";
    private static final String PREF_KEY_OAID = "device_oaid";
    private static final String TAG = "DeviceInfo";
    private String mAdvertisingId;
    private String mAndroidId;
    private Context mAppContext;
    private String mImei;
    private boolean mIsTablet;
    private String mMacAddress;
    private String mNetworkOperatorName;
    private String mOaid;
    private String mOttSystemType;
    private int mScreenHeight;
    private int mScreenWidth;
    private String mUtdid;
    private String mUuid;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class DeviceInfoHelper {
        DeviceInfoHelper() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getAndroidId(@NonNull Context context) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
                LogUtils.d(DeviceInfo.TAG, "getAndroidId exception", e);
                return "";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getImei(@NonNull Context context) {
            try {
                return TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService(DeviceInfo.DEVICE_PHONE));
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getNetworkOperatorName(@NonNull Context context) {
            try {
                StringBuilder sb = new StringBuilder();
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(DeviceInfo.DEVICE_PHONE);
                String simOperatorName = TelephonyManager.getSimOperatorName(telephonyManager);
                if (TextUtils.isEmpty(simOperatorName)) {
                    simOperatorName = telephonyManager.getNetworkOperatorName();
                    if (TextUtils.isEmpty(simOperatorName)) {
                        return "";
                    }
                }
                sb.append(simOperatorName);
                sb.append(JSMethod.NOT_SET);
                String simOperator = TelephonyManager.getSimOperator(telephonyManager);
                if (!TextUtils.isEmpty(simOperator)) {
                    sb.append(simOperator);
                }
                if (sb.length() > 1) {
                    return sb.toString();
                }
            } catch (Exception e) {
                LogUtils.e(DeviceInfo.TAG, "getNetworkOperatorName failed", e);
            }
            return "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getWifiAddress(@NonNull Context context) {
            return Build.VERSION.SDK_INT >= 23 ? getWifiMacID23() : getWifiMacID22(context);
        }

        private static String getWifiMacID22(@NonNull Context context) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
                    return !TextUtils.isEmpty(macAddress) ? macAddress : "00:00:00:00:00:00";
                }
                return "00:00:00:00:00:00";
            } catch (Throwable th) {
                LogUtils.d(DeviceInfo.TAG, "getWifiMacID22: exception.", th);
                return "00:00:00:00:00:00";
            }
        }

        @TargetApi(23)
        private static String getWifiMacID23() {
            try {
                NetworkInterface byName = NetworkInterface.getByName("wlan0");
                if (byName != null) {
                    byte[] hardwareAddress = com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(byName);
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    while (i < hardwareAddress.length) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Byte.valueOf(hardwareAddress[i]);
                        objArr[1] = i < hardwareAddress.length - 1 ? ":" : "";
                        sb.append(String.format("%02X%s", objArr));
                        i++;
                    }
                    return sb.toString();
                }
                return "00:00:00:00:00:00";
            } catch (Throwable th) {
                LogUtils.d(DeviceInfo.TAG, "getWifiMacID23: exception.", th);
                return "00:00:00:00:00:00";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTablet(@NonNull Context context) {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        }
    }

    public DeviceInfo(@NonNull Context context) {
        this.mAppContext = context;
        getAdvertisingIdsInBackground();
    }

    private void getAdvertisingIdsInBackground() {
        AdThreadPoolExecutor.postDelayed(new Runnable() { // from class: com.alimm.xadsdk.info.DeviceInfo.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DeviceInfo deviceInfo = DeviceInfo.this;
                    deviceInfo.mOaid = Utils.getOaid(deviceInfo.mAppContext);
                    DeviceInfo deviceInfo2 = DeviceInfo.this;
                    deviceInfo2.writeToPref(deviceInfo2.mAppContext, DeviceInfo.PREF_KEY_OAID, DeviceInfo.this.mOaid);
                    AdvertisingIdClient.AdInfo advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(DeviceInfo.this.mAppContext);
                    if (advertisingIdInfo != null) {
                        DeviceInfo.this.mAdvertisingId = advertisingIdInfo.isLimitAdTrackingEnabled() ? "" : advertisingIdInfo.getId();
                    } else {
                        DeviceInfo.this.mAdvertisingId = "";
                    }
                    DeviceInfo deviceInfo3 = DeviceInfo.this;
                    deviceInfo3.writeToPref(deviceInfo3.mAppContext, DeviceInfo.PREF_KEY_AAID, DeviceInfo.this.mAdvertisingId);
                } catch (Throwable unused) {
                    LogUtils.d(DeviceInfo.TAG, "getAdvertisingIdInBackground: exception.");
                }
                if (LogUtils.DEBUG) {
                    LogUtils.d(DeviceInfo.TAG, "getAdvertisingIdInBackground: mAdvertisingId = " + DeviceInfo.this.mAdvertisingId);
                }
            }
        }, 10000);
    }

    private void getScreenParams() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            this.mIsTablet = DeviceInfoHelper.isTablet(this.mAppContext);
            Display defaultDisplay = ((WindowManager) this.mAppContext.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            if (Build.VERSION.SDK_INT >= 17) {
                Point point = new Point();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point);
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                i = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                i2 = xVar;
            }
            if (AdSdkManager.getInstance().getConfig().getDeviceType() == 0) {
                if (this.mIsTablet) {
                    this.mScreenHeight = i;
                } else if (i > i2) {
                    this.mScreenHeight = i;
                } else {
                    this.mScreenHeight = i2;
                    this.mScreenWidth = i;
                }
                this.mScreenWidth = i2;
            } else if (i > i2) {
                this.mScreenHeight = i2;
                this.mScreenWidth = i;
            } else {
                this.mScreenHeight = i;
                this.mScreenWidth = i2;
            }
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getScreenParams: mIsTablet = " + this.mIsTablet + ", mScreenHeight = " + this.mScreenHeight + ", mScreenWidth = " + this.mScreenWidth);
            }
        } catch (Exception e) {
            LogUtils.d(TAG, "getScreenParams: fail.", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isAliYunOs() {
        /*
            r5 = this;
            java.lang.String r0 = "persist.sys.yunosflag"
            java.lang.String r1 = "0"
            java.lang.String r0 = com.alimm.xadsdk.base.utils.Utils.getSystemProperty(r0, r1)
            java.lang.String r1 = "1"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
        L12:
            r0 = 1
            goto L3b
        L14:
            java.lang.String r0 = "ro.yunos.product.model"
            java.lang.String r3 = "null"
            java.lang.String r0 = com.alimm.xadsdk.base.utils.Utils.getSystemProperty(r0, r3)
            boolean r4 = android.text.TextUtils.equals(r0, r3)
            if (r4 == 0) goto L28
            java.lang.String r0 = "ro.yunos.product.chip"
            java.lang.String r0 = com.alimm.xadsdk.base.utils.Utils.getSystemProperty(r0, r3)
        L28:
            boolean r4 = android.text.TextUtils.equals(r0, r3)
            if (r4 == 0) goto L34
            java.lang.String r0 = "ro.yunos.version.release"
            java.lang.String r0 = com.alimm.xadsdk.base.utils.Utils.getSystemProperty(r0, r3)
        L34:
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 == 0) goto L12
            r0 = 0
        L3b:
            if (r0 != r2) goto L3e
            r1 = 1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.xadsdk.info.DeviceInfo.isAliYunOs():boolean");
    }

    private String readFromPref(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String string = context.getSharedPreferences(PREF_AD_DEVICE_ID, 0).getString(str, "");
        LogUtils.d(TAG, "readFromPref: key = " + str + ", value = " + string);
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToPref(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREF_AD_DEVICE_ID, 0).edit();
        edit.putString(str, str2);
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "writeToPref: key = " + str + ", value = " + str2);
        }
        edit.apply();
    }

    public String getAdvertisingId() {
        String str = this.mAdvertisingId;
        return str == null ? readFromPref(this.mAppContext, PREF_KEY_AAID) : str;
    }

    public String getAndroidId() {
        if (TextUtils.isEmpty(this.mAndroidId)) {
            this.mAndroidId = DeviceInfoHelper.getAndroidId(this.mAppContext);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getAndroidId: mAndroidId = " + this.mAndroidId);
            }
        }
        return this.mAndroidId;
    }

    public String getDeviceType() {
        return AdSdkManager.getInstance().getConfig().getDeviceType() == 1 ? DEVICE_TV : isTablet() ? DEVICE_PAD : DEVICE_PHONE;
    }

    public String getImei() {
        if (this.mImei == null) {
            this.mImei = DeviceInfoHelper.getImei(this.mAppContext);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getImei: mImei = " + this.mImei);
            }
        }
        String str = this.mImei;
        return str != null ? str : "";
    }

    public String getMacAddress() {
        if (TextUtils.isEmpty(this.mMacAddress)) {
            this.mMacAddress = DeviceInfoHelper.getWifiAddress(this.mAppContext);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getMacAddress: mMacAddress = " + this.mMacAddress);
            }
        }
        return this.mMacAddress;
    }

    public String getNetworkOperatorName() {
        if (this.mNetworkOperatorName == null) {
            this.mNetworkOperatorName = DeviceInfoHelper.getNetworkOperatorName(this.mAppContext);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getNetworkOperatorName: mNetworkOperatorName = " + this.mNetworkOperatorName);
            }
        }
        return this.mNetworkOperatorName;
    }

    public String getOaid() {
        String str = this.mOaid;
        return str == null ? readFromPref(this.mAppContext, PREF_KEY_OAID) : str;
    }

    public String getOsType() {
        return (AdSdkManager.getInstance().getConfig().getDeviceType() != 0 && isAliYunOs()) ? OS_ALI_YUN : "Android";
    }

    public String getOttSystemType() {
        String str;
        if (TextUtils.isEmpty(this.mOttSystemType)) {
            String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
            if (model != null) {
                if (model.startsWith("MagicBox")) {
                    str = "1";
                } else if (model.startsWith("MagicProjector")) {
                    str = "4";
                } else if (model.toLowerCase().startsWith("alifun")) {
                    this.mOttSystemType = "3";
                }
                this.mOttSystemType = str;
            }
            if ("alliance".equals(Utils.getSystemProperty("ro.yunos.product.model", "null"))) {
                this.mOttSystemType = "2";
            }
            return isAliYunOs() ? "3" : "0";
        }
        return this.mOttSystemType;
    }

    public int getScreenHeight() {
        if (this.mScreenHeight == 0) {
            getScreenParams();
        }
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        if (this.mScreenWidth == 0) {
            getScreenParams();
        }
        return this.mScreenWidth;
    }

    public String getUtdid() {
        if (TextUtils.isEmpty(this.mUtdid)) {
            this.mUtdid = Utils.getUtdid(this.mAppContext);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getUtdid: mUtdid = " + this.mUtdid);
            }
        }
        String str = this.mUtdid;
        return str != null ? str : "";
    }

    public String getUuid() {
        if (TextUtils.isEmpty(this.mUuid)) {
            this.mUuid = Utils.getUuid();
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "getUuid: mUuid = " + this.mUuid);
            }
        }
        String str = this.mUuid;
        return str != null ? str : "";
    }

    public boolean isTablet() {
        if (this.mScreenWidth == 0) {
            getScreenParams();
        }
        return this.mIsTablet;
    }
}
