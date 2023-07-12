package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.alipay.sdk.m.u.C4300c;
import com.youku.playerservice.axp.utils.Utils;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class kc {
    private static int b;
    private static String[] c;
    private static String[] d = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    private static String e = "android.permission.ACCESS_BACKGROUND_LOCATION";
    static WifiManager a = null;
    private static boolean f = false;

    public static double a(double d2) {
        return c(d2);
    }

    public static float a(float f2) {
        return (float) (((long) (f2 * 100.0d)) / 100.0d);
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(int i) {
        return (i * 2) - 113;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static Object a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            jy.a(th, Utils.TAG, "getServ");
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? b(context, "android.provider.Settings$System") : b(context, "android.provider.Settings$Global");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || C4300c.b.equals(str) || str.contains(" :")) ? false : true;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return gn.a(jSONObject, str);
    }

    public static byte[] a(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            bArr = new byte[2];
        }
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        return bArr;
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> (i * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        return gn.b(bArr);
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int i;
        String[] strArr;
        String networkOperator = telephonyManager != null ? telephonyManager.getNetworkOperator() : null;
        String[] strArr2 = {"0", "0"};
        if (!TextUtils.isEmpty(networkOperator) && TextUtils.isDigitsOnly(networkOperator) && networkOperator.length() > 4) {
            strArr2[0] = networkOperator.substring(0, 3);
            char[] charArray = networkOperator.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr2[1] = networkOperator.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr2[0]);
        } catch (Throwable th) {
            jy.a(th, Utils.TAG, "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr2[0] = "0";
        }
        if ("0".equals(strArr2[0]) || "0".equals(strArr2[1])) {
            return ("0".equals(strArr2[0]) && "0".equals(strArr2[1]) && (strArr = c) != null) ? strArr : strArr2;
        }
        c = strArr2;
        return strArr2;
    }

    public static double b(double d2) {
        return ((long) (d2 * 100.0d)) / 100.0d;
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(int i) {
        switch (i) {
            case 0:
                return "success";
            case 1:
                return "重要参数为空";
            case 2:
                return "WIFI信息不足";
            case 3:
                return "请求参数获取出现异常";
            case 4:
                return "网络连接异常";
            case 5:
                return "解析数据异常";
            case 6:
                return "定位结果错误";
            case 7:
                return "KEY错误";
            case 8:
            case 16:
            case 17:
            default:
                return "其他错误";
            case 9:
                return "初始化异常";
            case 10:
                return "定位服务启动失败";
            case 11:
                return "错误的基站信息，请检查是否插入SIM卡";
            case 12:
                return "缺少定位权限";
            case 13:
                return "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
            case 14:
                return "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
            case 15:
                return "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
            case 18:
                return "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
            case 19:
                return "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        }
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(jy.h)) {
            if (context == null) {
                return null;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(C4554gc.c(context), 64);
            } catch (Throwable th) {
                jy.a(th, Utils.TAG, "getAppName part");
                packageInfo = null;
            }
            try {
                if (TextUtils.isEmpty(jy.i)) {
                    jy.i = null;
                }
            } catch (Throwable th2) {
                jy.a(th2, Utils.TAG, "getAppName");
            }
            StringBuilder sb = new StringBuilder();
            if (packageInfo != null) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                CharSequence loadLabel = applicationInfo != null ? applicationInfo.loadLabel(context.getPackageManager()) : null;
                if (loadLabel != null) {
                    sb.append(loadLabel.toString());
                }
                if (!TextUtils.isEmpty(packageInfo.versionName)) {
                    sb.append(packageInfo.versionName);
                }
            }
            String c2 = C4554gc.c(context);
            if (!TextUtils.isEmpty(c2)) {
                sb.append(",");
                sb.append(c2);
            }
            if (!TextUtils.isEmpty(jy.i)) {
                sb.append(",");
                sb.append(jy.i);
            }
            String sb2 = sb.toString();
            jy.h = sb2;
            return sb2;
        }
        return jy.h;
    }

    public static String b(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            try {
                i = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(telephonyManager);
            } catch (Throwable unused) {
            }
        }
        switch (i) {
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "IDEN";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "UNKWN";
        }
    }

    private static boolean b(Context context, String str) throws Throwable {
        return ((Integer) ka.a(str, "getInt", new Object[]{context.getContentResolver(), ((String) ka.a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] b(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            bArr = new byte[4];
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] b(String str) {
        return a(d(str), (byte[]) null);
    }

    private static double c(double d2) {
        return ((long) (d2 * 1000000.0d)) / 1000000.0d;
    }

    public static int c() {
        int i = b;
        if (i > 0) {
            return i;
        }
        try {
            try {
                return ka.b("android.os.Build$VERSION", "SDK_INT");
            } catch (Throwable unused) {
                return Integer.parseInt(ka.a("android.os.Build$VERSION", "SDK").toString());
            }
        } catch (Throwable unused2) {
            return 0;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean c(Context context) {
        boolean z;
        if (context == null) {
            return true;
        }
        if (a == null) {
            a = (WifiManager) a(context, "wifi");
        }
        try {
            z = a.isWifiEnabled();
        } catch (Throwable unused) {
            z = false;
        }
        if (z || c() <= 17) {
            return z;
        }
        try {
            return "true".equals(String.valueOf(ka.a(a, "isScanAlwaysAvailable", new Object[0])));
        } catch (Throwable unused2) {
            return z;
        }
    }

    public static byte[] c(String str) {
        return b(d(str), (byte[]) null);
    }

    public static int d() {
        return new Random().nextInt(65536) - 32768;
    }

    public static int d(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static String d(Context context) {
        String n = gg.n(context);
        boolean isEmpty = TextUtils.isEmpty(n);
        String str = C4300c.b;
        if (isEmpty || n.equals(C4300c.b)) {
            n = kb.a(context);
        }
        if (!TextUtils.isEmpty(n)) {
            str = n;
        }
        if (!f) {
            kb.a(context, str);
            f = true;
        }
        return str;
    }

    public static byte e(String str) throws NumberFormatException {
        return Byte.parseByte(str);
    }

    public static boolean e(Context context) {
        return Build.VERSION.SDK_INT >= 28 && context.getApplicationInfo().targetSdkVersion >= 28;
    }
}
