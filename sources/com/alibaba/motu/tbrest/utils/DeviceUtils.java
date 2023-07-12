package com.alibaba.motu.tbrest.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.ta.utdid2.device.UTDevice;
import java.util.Locale;
import java.util.Random;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DeviceUtils {
    private static final String NETWORK_CLASS_2_G = "2G";
    private static final String NETWORK_CLASS_3_G = "3G";
    private static final String NETWORK_CLASS_4_G = "4G";
    private static final String NETWORK_CLASS_UNKNOWN = "Unknown";
    public static final String NETWORK_CLASS_WIFI = "Wi-Fi";
    private static String carrier;
    private static String cpuName;
    private static String[] arrayOfString = {"Unknown", "Unknown"};
    private static String imsi = null;
    private static String imei = null;

    public static byte[] IntGetBytes(int i) {
        byte[] bArr = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }

    public static String getCarrier(Context context) {
        try {
            String str = carrier;
            if (str != null) {
                return str;
            }
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            carrier = networkOperatorName;
            return networkOperatorName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCountry() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Exception e) {
            LogUtil.e("get country error ", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
        if (r0 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCpuName() {
        /*
            java.lang.String r0 = com.alibaba.motu.tbrest.utils.DeviceUtils.cpuName
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.String r0 = "/proc/cpuinfo"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L51
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L51
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40
        L12:
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L53
            if (r3 == 0) goto L32
            java.lang.String r4 = "Hardware"
            boolean r4 = r3.contains(r4)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L53
            if (r4 == 0) goto L12
            java.lang.String r4 = ":"
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L53
            r4 = 1
            r3 = r3[r4]     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L53
            com.alibaba.motu.tbrest.utils.DeviceUtils.cpuName = r3     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L53
            r2.close()     // Catch: java.lang.Exception -> L31
            r0.close()     // Catch: java.lang.Exception -> L31
        L31:
            return r3
        L32:
            r2.close()     // Catch: java.lang.Exception -> L5b
        L35:
            r0.close()     // Catch: java.lang.Exception -> L5b
            goto L5b
        L39:
            r1 = move-exception
            goto L46
        L3b:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L46
        L40:
            r0 = r1
            goto L53
        L42:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L46:
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.lang.Exception -> L50
        L4b:
            if (r0 == 0) goto L50
            r0.close()     // Catch: java.lang.Exception -> L50
        L50:
            throw r1
        L51:
            r0 = r1
            r2 = r0
        L53:
            if (r2 == 0) goto L58
            r2.close()     // Catch: java.lang.Exception -> L5b
        L58:
            if (r0 == 0) goto L5b
            goto L35
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.utils.DeviceUtils.getCpuName():java.lang.String");
    }

    public static String getImei(Context context) {
        String str = imei;
        if (str != null) {
            return str;
        }
        String uniqueID = getUniqueID();
        imei = uniqueID;
        return uniqueID;
    }

    public static String getImsi(Context context) {
        String str = imsi;
        if (str != null) {
            return str;
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    imsi = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSubscriberId(telephonyManager);
                }
            } catch (Exception unused) {
            }
        }
        if (StringUtils.isEmpty(imsi)) {
            imsi = getUniqueID();
        }
        return imsi;
    }

    public static String getLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            LogUtil.e("get country error ", e);
            return null;
        }
    }

    private static String getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    @SuppressLint({"WrongConstant"})
    public static String[] getNetworkType(Context context) {
        if (context == null) {
            return arrayOfString;
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            return arrayOfString;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return arrayOfString;
        }
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        if (activeNetworkInfo == null) {
            return arrayOfString;
        }
        if (activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                String[] strArr = arrayOfString;
                strArr[0] = "Wi-Fi";
                return strArr;
            } else if (activeNetworkInfo.getType() == 0) {
                arrayOfString[0] = getNetworkClass(activeNetworkInfo.getSubtype());
                arrayOfString[1] = activeNetworkInfo.getSubtypeName();
                return arrayOfString;
            }
        }
        return arrayOfString;
    }

    public static String getResolution() {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            return i + jn1.MUL + i2;
        } catch (Exception e) {
            LogUtil.e("get resolution error", e);
            return null;
        }
    }

    public static final String getUniqueID() {
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nanoTime = (int) System.nanoTime();
            int nextInt = new Random().nextInt();
            int nextInt2 = new Random().nextInt();
            byte[] IntGetBytes = IntGetBytes(currentTimeMillis);
            byte[] IntGetBytes2 = IntGetBytes(nanoTime);
            byte[] IntGetBytes3 = IntGetBytes(nextInt);
            byte[] IntGetBytes4 = IntGetBytes(nextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(IntGetBytes, 0, bArr, 0, 4);
            System.arraycopy(IntGetBytes2, 0, bArr, 4, 4);
            System.arraycopy(IntGetBytes3, 0, bArr, 8, 4);
            System.arraycopy(IntGetBytes4, 0, bArr, 12, 4);
            return Base64.encodeBase64String(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getUtdid(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Exception e) {
            LogUtil.e("get utdid error ", e);
            return null;
        }
    }
}
