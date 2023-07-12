package com.youku.usercenter.passport.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.cert.CertificateFactory;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SysUtil {
    private static String sPkgKeyDigest;
    private static String sProcessName;
    private static Toast sToast;

    public static String getApkPublicKeyDigest(Context context) {
        if (context != null && TextUtils.isEmpty(sPkgKeyDigest)) {
            sPkgKeyDigest = getApkPublicKeyDigest(context, context.getPackageName());
        }
        return sPkgKeyDigest;
    }

    public static String getAppName(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(str, 0).applicationInfo.loadLabel(packageManager).toString().trim();
        } catch (Throwable th) {
            Logger.printStackTrace(th);
            return null;
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getBSSID(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getDeviceBrand() {
        return Build.getMANUFACTURER();
    }

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        return UTDevice.getUtdid(context);
    }

    public static String getDeviceIp() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    String hostAddress = inetAddress.getHostAddress();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return hostAddress;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getDeviceMac() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return EncryptUtil.toHexString(com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(networkInterface), ":", false);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getDeviceModel() {
        return Build.getMODEL();
    }

    public static Drawable getDialogBgRes(Context context) {
        Resources resources = context.getResources();
        if (resources != null) {
            try {
                int identifier = resources.getIdentifier("dialog_gradient_bg", "drawable", context.getPackageName());
                if (identifier > 0) {
                    return resources.getDrawable(identifier);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String getImei(Context context) {
        try {
            return TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static double[] getLocation(Context context) {
        Location lastKnownLocation;
        if (context == null) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.getLastKnownLocation(locationManager, bestProvider)) == null) {
                return null;
            }
            return new double[]{com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(lastKnownLocation), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(lastKnownLocation)};
        } catch (SecurityException e) {
            Logger.printStackTrace(e);
        } catch (Exception e2) {
            Logger.printStackTrace(e2);
        }
        return null;
    }

    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null) {
                return "";
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "WIFI";
            }
            if (type == 0) {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
                return String.valueOf(getNetworkType30(context));
            }
            return "OTHER";
        } catch (Exception unused) {
            Logger.e("Get network type failed");
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    private static int getNetworkType30(Context context) {
        int dataNetworkType;
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT < 30) {
                dataNetworkType = TelephonyManager.getNetworkType(telephonyManager);
            } else {
                dataNetworkType = TelephonyManager.getDataNetworkType(telephonyManager);
            }
            return dataNetworkType;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.getRELEASE();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getProcessName(android.content.Context r7) {
        /*
            java.lang.String r0 = com.youku.usercenter.passport.util.SysUtil.sProcessName
            if (r0 == 0) goto L5
            return r0
        L5:
            java.lang.Class<com.youku.usercenter.passport.util.SysUtil> r0 = com.youku.usercenter.passport.util.SysUtil.class
            monitor-enter(r0)
            java.lang.String r1 = com.youku.usercenter.passport.util.SysUtil.sProcessName     // Catch: java.lang.Throwable -> L9b
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r1
        Le:
            int r1 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L9b
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r5.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r6 = "/proc/"
            r5.append(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r5.append(r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r6 = "/cmdline"
            r5.append(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            r4.<init>()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
        L38:
            int r5 = r3.read()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            if (r5 <= 0) goto L43
            char r5 = (char) r5     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            r4.append(r5)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            goto L38
        L43:
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            com.youku.usercenter.passport.util.SysUtil.sProcessName = r4     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L8e
            r3.close()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L9b
            goto L51
        L4d:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9b
        L51:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r4
        L53:
            r4 = move-exception
            goto L59
        L55:
            r7 = move-exception
            goto L90
        L57:
            r4 = move-exception
            r3 = r2
        L59:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L9b
            goto L66
        L62:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L9b
        L66:
            java.lang.String r3 = "activity"
            java.lang.Object r7 = r7.getSystemService(r3)     // Catch: java.lang.Throwable -> L9b
            android.app.ActivityManager r7 = (android.app.ActivityManager) r7     // Catch: java.lang.Throwable -> L9b
            java.util.List r7 = r7.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L9b
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L9b
        L76:
            boolean r3 = r7.hasNext()     // Catch: java.lang.Throwable -> L9b
            if (r3 == 0) goto L8c
            java.lang.Object r3 = r7.next()     // Catch: java.lang.Throwable -> L9b
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Throwable -> L9b
            int r4 = r3.pid     // Catch: java.lang.Throwable -> L9b
            if (r4 != r1) goto L76
            java.lang.String r7 = r3.processName     // Catch: java.lang.Throwable -> L9b
            com.youku.usercenter.passport.util.SysUtil.sProcessName = r7     // Catch: java.lang.Throwable -> L9b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r7
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            return r2
        L8e:
            r7 = move-exception
            r2 = r3
        L90:
            if (r2 == 0) goto L9a
            r2.close()     // Catch: java.lang.Exception -> L96 java.lang.Throwable -> L9b
            goto L9a
        L96:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L9b
        L9a:
            throw r7     // Catch: java.lang.Throwable -> L9b
        L9b:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9b
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.usercenter.passport.util.SysUtil.getProcessName(android.content.Context):java.lang.String");
    }

    public static String getRunningInfo() {
        try {
            return String.format(Locale.CHINESE, "[%s, %d][SDK]", getProcessName(null), Long.valueOf(Thread.currentThread().getId()));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getSSID(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
            return null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return null;
        }
    }

    public static String getScreenSize(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) + Constants.Name.X + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static Drawable getTlIcon(Context context, String str) {
        Resources resources = context.getResources();
        if (resources != null) {
            try {
                int identifier = resources.getIdentifier("passport_icon_tl_" + str, "drawable", context.getPackageName());
                if (identifier > 0) {
                    return resources.getDrawable(identifier);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String getTlName(Context context, String str) {
        Resources resources = context.getResources();
        if (resources != null) {
            try {
                int identifier = resources.getIdentifier("passport_tl_" + str, "string", context.getPackageName());
                return identifier > 0 ? resources.getString(identifier) : "";
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static boolean hasActiveNetwork(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity")) != null;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        } catch (Exception e) {
            Logger.printStackTrace(e);
        }
    }

    public static boolean isSupportYoukuAuth(Context context) {
        return false;
    }

    public static boolean popAllFragments(Activity activity) {
        try {
            return activity.getFragmentManager().popBackStackImmediate((String) null, 1);
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    public static String readThreadStack() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showQuickToast(Context context, String str) {
    }

    public static boolean supportDial(Context context) {
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() != 1) {
                return telephonyManager.getSimState() != 0;
            }
            return false;
        } catch (Exception e) {
            Logger.printStackTrace(e);
            return false;
        }
    }

    public static String getApkPublicKeyDigest(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable th) {
            th = th;
            byteArrayInputStream = null;
        }
        try {
            String encryptMD5 = EncryptUtil.encryptMD5(CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey().toString(), true);
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return encryptMD5;
        } catch (Throwable th2) {
            th = th2;
            try {
                Logger.printStackTrace(th);
                return null;
            } finally {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
