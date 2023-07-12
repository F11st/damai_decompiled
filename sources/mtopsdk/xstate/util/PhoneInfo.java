package mtopsdk.xstate.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Random;
import mtopsdk.common.util.ConfigStoreManager;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.IDeviceInfo;
import tb.gn1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PhoneInfo {
    private static final String IMEI = "mtopsdk_imei";
    private static final String IMSI = "mtopsdk_imsi";
    private static final String MACADDRESS = "mtopsdk_mac_address";
    private static final String TAG = "mtopsdk.PhoneInfo";
    private static volatile IDeviceInfo sDeviceInfo;
    private static ConfigStoreManager storeManager = ConfigStoreManager.getInstance();

    private static String generateImei() {
        StringBuilder sb = new StringBuilder();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String valueOf = String.valueOf(currentTimeMillis);
            sb.append(valueOf.substring(valueOf.length() - 5));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.getMODEL().replaceAll(" ", ""));
            while (sb2.length() < 6) {
                sb2.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(sb2.substring(0, 6));
            Random random = new Random(currentTimeMillis);
            long j = 0;
            while (j < 4096) {
                j = random.nextLong();
            }
            sb.append(Long.toHexString(j).substring(0, 4));
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[generateImei] error --->" + th.toString());
        }
        return sb.toString();
    }

    @TargetApi(3)
    public static String getAndroidId(Context context) {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo == null || TextUtils.isEmpty(iDeviceInfo.getAndroidId())) {
            if (context == null) {
                return null;
            }
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "[getAndroidId]error ---" + th.toString());
                return null;
            }
        }
        return iDeviceInfo.getAndroidId();
    }

    @TargetApi(8)
    public static String getImei(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder sb2 = new StringBuilder(storeManager.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMEI));
            try {
                if (StringUtils.isNotBlank(sb2.toString())) {
                    return new String(Base64.decode(sb2.toString(), 0));
                }
                StringBuilder sb3 = new StringBuilder(TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone")));
                try {
                    sb = StringUtils.isBlank(sb3.toString()) ? new StringBuilder(generateImei()) : sb3;
                    StringBuilder sb4 = new StringBuilder(sb.toString().replaceAll(" ", "").trim());
                    while (sb4.length() < 15) {
                        sb4.insert(0, "0");
                    }
                    storeManager.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMEI, Base64.encodeToString(sb4.toString().getBytes(), 0));
                    return sb4.toString().trim();
                } catch (Throwable th) {
                    th = th;
                    sb = sb3;
                    TBSdkLog.e(TAG, "[getImei] error ---" + th.toString());
                    return sb.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                sb = sb2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @TargetApi(8)
    public static String getImsi(Context context) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        try {
            sb2 = new StringBuilder(storeManager.getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMSI));
            try {
            } catch (Throwable th) {
                th = th;
                sb3 = sb2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (StringUtils.isNotBlank(sb2.toString())) {
            return new String(Base64.decode(sb2.toString(), 0));
        }
        StringBuilder sb4 = new StringBuilder(TelephonyManager.getSubscriberId((android.telephony.TelephonyManager) context.getSystemService("phone")));
        try {
            sb3 = StringUtils.isBlank(sb4.toString()) ? new StringBuilder(generateImei()) : sb4;
            sb = new StringBuilder(sb3.toString().replaceAll(" ", "").trim());
            while (sb.length() < 15) {
                sb.insert(0, "0");
            }
            storeManager.saveConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, ConfigStoreManager.PHONE_INFO_STORE_PREFIX, IMSI, Base64.encodeToString(sb.toString().getBytes(), 0));
        } catch (Throwable th3) {
            th = th3;
            sb3 = sb4;
            TBSdkLog.e(TAG, "[getImsi]error ---" + th.toString());
            sb = sb3;
            return sb.toString();
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {all -> 0x009c, blocks: (B:5:0x0005, B:28:0x007e, B:30:0x0084), top: B:38:0x0005 }] */
    @android.annotation.TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getLocalMacAddress(android.content.Context r10) {
        /*
            java.lang.String r0 = ""
            if (r10 != 0) goto L5
            return r0
        L5:
            mtopsdk.common.util.ConfigStoreManager r1 = mtopsdk.xstate.util.PhoneInfo.storeManager     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = "MtopConfigStore"
            java.lang.String r3 = "PHONE_INFO_STORE."
            java.lang.String r4 = "mtopsdk_mac_address"
            java.lang.String r1 = r1.getConfigItem(r10, r2, r3, r4)     // Catch: java.lang.Throwable -> L9c
            boolean r2 = mtopsdk.common.util.StringUtils.isNotBlank(r1)     // Catch: java.lang.Throwable -> L99
            r3 = 0
            if (r2 == 0) goto L22
            java.lang.String r10 = new java.lang.String     // Catch: java.lang.Throwable -> L99
            byte[] r0 = android.util.Base64.decode(r1, r3)     // Catch: java.lang.Throwable -> L99
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L99
            return r10
        L22:
            java.lang.String r2 = "android.permission.ACCESS_WIFI_STATE"
            int r2 = r10.checkCallingOrSelfPermission(r2)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L7d
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L99
            r4 = 23
            if (r2 < r4) goto L6a
            java.lang.String r2 = "wlan0"
            java.net.NetworkInterface r2 = java.net.NetworkInterface.getByName(r2)     // Catch: java.lang.Throwable -> L99
            byte[] r2 = com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r4.<init>()     // Catch: java.lang.Throwable -> L99
            r5 = 0
        L40:
            int r6 = r2.length     // Catch: java.lang.Throwable -> L99
            if (r5 >= r6) goto L65
            java.lang.String r6 = "%02X%s"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L99
            r8 = r2[r5]     // Catch: java.lang.Throwable -> L99
            java.lang.Byte r8 = java.lang.Byte.valueOf(r8)     // Catch: java.lang.Throwable -> L99
            r7[r3] = r8     // Catch: java.lang.Throwable -> L99
            int r8 = r2.length     // Catch: java.lang.Throwable -> L99
            r9 = 1
            int r8 = r8 - r9
            if (r5 >= r8) goto L58
            java.lang.String r8 = ":"
            goto L59
        L58:
            r8 = r0
        L59:
            r7[r9] = r8     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch: java.lang.Throwable -> L99
            r4.append(r6)     // Catch: java.lang.Throwable -> L99
            int r5 = r5 + 1
            goto L40
        L65:
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L99
            goto L7e
        L6a:
            java.lang.String r0 = "wifi"
            java.lang.Object r0 = r10.getSystemService(r0)     // Catch: java.lang.Throwable -> L99
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0     // Catch: java.lang.Throwable -> L99
            android.net.wifi.WifiInfo r0 = r0.getConnectionInfo()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L7d
            java.lang.String r0 = com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(r0)     // Catch: java.lang.Throwable -> L99
            goto L7e
        L7d:
            r0 = r1
        L7e:
            boolean r1 = mtopsdk.common.util.StringUtils.isNotBlank(r0)     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto Lb7
            mtopsdk.common.util.ConfigStoreManager r4 = mtopsdk.xstate.util.PhoneInfo.storeManager     // Catch: java.lang.Throwable -> L9c
            java.lang.String r6 = "MtopConfigStore"
            java.lang.String r7 = "PHONE_INFO_STORE."
            java.lang.String r8 = "mtopsdk_mac_address"
            byte[] r1 = r0.getBytes()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r9 = android.util.Base64.encodeToString(r1, r3)     // Catch: java.lang.Throwable -> L9c
            r5 = r10
            r4.saveConfigItem(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9c
            goto Lb7
        L99:
            r10 = move-exception
            r0 = r1
            goto L9d
        L9c:
            r10 = move-exception
        L9d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[getLocalMacAddress]error ---"
            r1.append(r2)
            java.lang.String r10 = r10.toString()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            java.lang.String r1 = "mtopsdk.PhoneInfo"
            mtopsdk.common.util.TBSdkLog.e(r1, r10)
        Lb7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.xstate.util.PhoneInfo.getLocalMacAddress(android.content.Context):java.lang.String");
    }

    public static String getOriginalImei(Context context) {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo == null || TextUtils.isEmpty(iDeviceInfo.getImei())) {
            if (context == null) {
                return null;
            }
            try {
                String deviceId = TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
                return deviceId != null ? deviceId.trim() : deviceId;
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "[getOriginalImei]error ---" + th.toString());
                return null;
            }
        }
        return iDeviceInfo.getImei();
    }

    public static String getOriginalImsi(Context context) {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo == null || TextUtils.isEmpty(iDeviceInfo.getSubscriberId())) {
            if (context == null) {
                return null;
            }
            try {
                String subscriberId = TelephonyManager.getSubscriberId((android.telephony.TelephonyManager) context.getSystemService("phone"));
                return subscriberId != null ? subscriberId.trim() : subscriberId;
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "[getOriginalImsi]error ---" + th.toString());
                return null;
            }
        }
        return iDeviceInfo.getSubscriberId();
    }

    public static String getPhoneBaseInfo(Context context) {
        try {
            String release = Build.VERSION.getRELEASE();
            String manufacturer = Build.getMANUFACTURER();
            String model = Build.getMODEL();
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK/");
            sb.append(HttpHeaderConstant.M_SDKVER_VALUE);
            sb.append(" (");
            sb.append("Android");
            sb.append(";");
            sb.append(release);
            sb.append(";");
            sb.append(manufacturer);
            sb.append(";");
            sb.append(model);
            sb.append(jn1.BRACKET_END_STR);
            return sb.toString();
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getPhoneBaseInfo] error ---" + th.toString());
            return "";
        }
    }

    public static String getSerialNum() {
        IDeviceInfo iDeviceInfo = sDeviceInfo;
        if (iDeviceInfo != null && !TextUtils.isEmpty(iDeviceInfo.getSerialNum())) {
            return iDeviceInfo.getSerialNum();
        }
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[getSerialNum]error ---" + th.toString());
            return null;
        }
    }

    public static void setDeviceInfo(IDeviceInfo iDeviceInfo) {
        if (iDeviceInfo != null) {
            sDeviceInfo = iDeviceInfo;
        }
        if (sDeviceInfo == null) {
            TBSdkLog.e(TAG, "[getLocalMacAddress]setDeviceInfo --- null");
        }
    }
}
