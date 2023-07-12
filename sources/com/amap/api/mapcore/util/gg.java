package com.amap.api.mapcore.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.alipay.sdk.m.c.C4152b;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import tb.C9796v;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gg {
    static String a = "";
    static String b = "";
    static volatile boolean c = true;
    public static boolean d = false;
    static String e = "";
    static boolean f = false;
    public static InterfaceC4565a g = null;
    static int h = -1;
    static String i = "";
    static String j = "";
    private static String k = null;
    private static boolean l = false;
    private static volatile boolean m = false;
    private static String n = "";
    private static boolean o = false;
    private static String p = "";
    private static String q = "";
    private static String r = "";
    private static String s = "";
    private static String t = "";
    private static String u = "";
    private static boolean v = false;
    private static long w = 0;
    private static int x = 0;
    private static String y = null;
    private static String z = "";

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.gg$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4565a {
        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.gg$b */
    /* loaded from: classes10.dex */
    public static class ServiceConnectionC4566b implements ServiceConnection {
        ServiceConnectionC4566b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(C4152b.a);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String unused = gg.n = obtain2.readString();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String A(Context context) {
        try {
            return F(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String C(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (gn.a(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z2 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z2 = false;
                            } else if (eventType == 4 && z2) {
                                String text = newPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable unused) {
                                }
                                return text;
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i2 = 0; i2 < attributeCount; i2++) {
                                String attributeValue = newPullParser.getAttributeValue(i2);
                                if ("UTDID2".equals(attributeValue) || Constants.UTDID.equals(attributeValue)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused4) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String D(Context context) {
        String c2 = gn.c("IeGlhb21p");
        String manufacturer = Build.getMANUFACTURER();
        int i2 = 0;
        if (c2.equalsIgnoreCase(manufacturer)) {
            try {
                Class<?> cls = Class.forName(gn.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
                Object invoke = cls.getMethod(gn.c("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
                if (invoke != null) {
                    String str = (String) invoke;
                    n = str;
                    return str;
                }
            } catch (Throwable unused) {
                o = true;
            }
        } else if (gn.c("IaHVhd2Vp").equalsIgnoreCase(manufacturer)) {
            try {
                Intent intent = new Intent();
                intent.setAction(gn.c("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(gn.c("UY29tLmh1YXdlaS5od2lk"));
                ServiceConnectionC4566b serviceConnectionC4566b = new ServiceConnectionC4566b();
                if (context.bindService(intent, serviceConnectionC4566b, 1)) {
                    while (i2 < 100 && TextUtils.isEmpty(n)) {
                        i2++;
                        Thread.sleep(15L);
                    }
                    context.unbindService(serviceConnectionC4566b);
                }
                return n;
            } catch (Throwable th) {
                C4573ha.a(th, "oa", "hw");
                o = true;
            }
        } else if ("OPPO".equalsIgnoreCase(manufacturer)) {
            o = true;
        } else {
            o = true;
        }
        return n;
    }

    private static String E(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str = z;
        if (str != null && !"".equals(str)) {
            return z;
        }
        if (!a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return z;
        }
        TelephonyManager L = L(context);
        if (L == null) {
            return "";
        }
        Method a2 = gn.a(L.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
        if (a2 != null) {
            z = (String) a2.invoke(L, new Object[0]);
        }
        if (z == null) {
            z = "";
        }
        return z;
    }

    private static String F(Context context) {
        if (a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            TelephonyManager L = L(context);
            if (L == null) {
                return "";
            }
            String simOperatorName = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName(L);
            return TextUtils.isEmpty(simOperatorName) ? L.getNetworkOperatorName() : simOperatorName;
        }
        return null;
    }

    private static String G(Context context) {
        ConnectivityManager I;
        NetworkInfo activeNetworkInfo;
        return (!a(context, gn.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (I = I(context)) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(I)) == null) ? "" : activeNetworkInfo.getTypeName();
    }

    private static int H(Context context) {
        ConnectivityManager I;
        NetworkInfo activeNetworkInfo;
        if (context == null || !a(context, gn.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (I = I(context)) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(I)) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager I(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String J(Context context) {
        String y2 = y(context);
        return (y2 == null || y2.length() < 5) ? "" : y2.substring(3, 5);
    }

    private static int K(Context context) {
        TelephonyManager L;
        if (a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (L = L(context)) != null) {
            return com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(L);
        }
        return -1;
    }

    private static TelephonyManager L(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String M(Context context) {
        if (c) {
            String str = null;
            try {
                str = N(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                c = false;
                return "";
            }
            try {
                byte[] bytes = gn.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
                return new String(gh.a(gn.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), gh.b(str), bytes), "UTF-8");
            } catch (Throwable unused2) {
                c = false;
                return "";
            }
        }
        return "";
    }

    private static String N(Context context) {
        String str;
        try {
            str = P(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : O(context);
    }

    private static String O(Context context) {
        return context == null ? "" : context.getSharedPreferences(gn.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(gk.b(gn.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String P(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        String b2 = gk.b(gn.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String a2 = a(context, false);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        File file = new File(a2 + File.separator + gn.c("KYmFja3Vwcw"), gn.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            a(byteArrayOutputStream2);
                            a(randomAccessFile);
                            return "";
                        }
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
            }
            if (!TextUtils.isEmpty(str) && str.contains(gn.c("SIw")) && (split = str.split(gn.c("SIw"))) != null && split.length == 2 && TextUtils.equals(b2, split[0])) {
                String str2 = split[1];
                a(byteArrayOutputStream);
                a(randomAccessFile);
                return str2;
            }
            a(byteArrayOutputStream);
            a(randomAccessFile);
        }
        return "";
    }

    public static InterfaceC4565a b() {
        return g;
    }

    public static String c(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            return J(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return K(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int f(Context context) {
        try {
            return H(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String g(Context context) {
        try {
            return E(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String h(final Context context) {
        if (o) {
            return "";
        }
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.gg.2
                @Override // java.lang.Runnable
                public void run() {
                    gg.D(context);
                }
            });
            return n;
        }
        return D(context);
    }

    public static String i(Context context) {
        String str;
        try {
            str = a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return a;
        }
        if (a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        String str2 = a;
        if (str2 != null && !"".equals(str2)) {
            return a;
        }
        try {
            a = C(context);
        } catch (Throwable unused2) {
        }
        String str3 = a;
        return str3 == null ? "" : str3;
    }

    public static String j(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (!TextUtils.isEmpty(q)) {
            return q;
        }
        if (a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            if (i2 >= 26) {
                return (String) gn.a(android.os.Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(android.os.Build.class, new Object[0]);
            }
            if (i2 >= 9) {
                q = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSERIAL();
            }
            String str = q;
            return str == null ? "" : str;
        }
        return "";
    }

    public static String k(Context context) {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), gn.c(new String(gy.a(13))));
            p = string;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return p;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Context context) {
        WifiManager wifiManager;
        if (context != null) {
            try {
                return (a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null && wifiManager.isWifiEnabled()) ? wifiManager.getConnectionInfo().getBSSID() : "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            if (a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return "";
                }
                if (wifiManager.isWifiEnabled()) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() != 0) {
                        List<ScanResult> a2 = a(scanResults);
                        boolean z2 = true;
                        for (int i2 = 0; i2 < a2.size() && i2 < 7; i2++) {
                            ScanResult scanResult = a2.get(i2);
                            if (z2) {
                                z2 = false;
                            } else {
                                sb.append(";");
                            }
                            sb.append(scanResult.BSSID);
                        }
                    }
                    return sb.toString();
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static String n(Context context) {
        String str;
        try {
            str = r;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return r;
        }
        if (!a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
            return r;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        r = WifiInfo.getMacAddress(wifiManager.getConnectionInfo());
        if (gn.c("YMDI6MDA6MDA6MDA6MDA6MDA").equals(r) || gn.c("YMDA6MDA6MDA6MDA6MDA6MDA").equals(r)) {
            r = f();
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] o(Context context) {
        return new String[]{"", ""};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Context context) {
        try {
            TelephonyManager L = L(context);
            if (L == null) {
                return "";
            }
            String networkOperator = L.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int q(Context context) {
        try {
            return K(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int r(Context context) {
        try {
            return H(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo s(Context context) {
        ConnectivityManager I;
        if (a(context, gn.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (I = I(context)) != null) {
            return com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(I);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Context context) {
        try {
            NetworkInfo s2 = s(context);
            if (s2 == null) {
                return null;
            }
            return s2.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String u(Context context) {
        String str;
        StringBuilder sb;
        try {
            str = s;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return s;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
        if (windowManager == null) {
            return "";
        }
        Display.getMetrics(windowManager.getDefaultDisplay(), displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        if (i3 > i2) {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(jn1.MUL);
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(jn1.MUL);
            sb.append(i2);
        }
        s = sb.toString();
        return s;
    }

    public static String v(Context context) {
        try {
            return G(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String w(Context context) {
        int i2;
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i2 >= 29) {
            return "";
        }
        String str = t;
        if (str != null && !"".equals(str)) {
            return t;
        }
        if (!a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return t;
        }
        TelephonyManager L = L(context);
        if (L == null) {
            return "";
        }
        Method a2 = gn.a(L.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
        if (i2 >= 26) {
            a2 = gn.a(L.getClass(), "QZ2V0SW1laQ==", new Class[0]);
        }
        if (a2 != null) {
            t = (String) a2.invoke(L, new Object[0]);
        }
        if (t == null) {
            t = "";
        }
        return t;
    }

    public static String x(Context context) {
        String str;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        try {
            str = u;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return u;
        }
        if (!a(context, gn.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return u;
        }
        TelephonyManager L = L(context);
        if (L == null) {
            return "";
        }
        if (i2 >= 26) {
            Method a2 = gn.a(L.getClass(), "QZ2V0TWVpZA==", new Class[0]);
            if (a2 != null) {
                u = (String) a2.invoke(L, new Object[0]);
            }
            if (u == null) {
                u = "";
            }
        }
        return u;
    }

    public static String y(Context context) {
        try {
            return E(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int z(Context context) {
        BufferedReader bufferedReader;
        int i2 = x;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            i3 = (int) (memoryInfo.totalMem / 1024);
        } else {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(new File("/proc/meminfo")));
                } catch (Throwable unused) {
                }
                try {
                    i3 = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
                    bufferedReader.close();
                } catch (Throwable unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    int i4 = i3 / 1024;
                    x = i4;
                    return i4;
                }
            } catch (IOException unused3) {
            }
        }
        int i42 = i3 / 1024;
        x = i42;
        return i42;
    }

    public static String b(final Context context) {
        if (TextUtils.isEmpty(b)) {
            if (context == null) {
                return "";
            }
            String M = M(context);
            b = M;
            if (!TextUtils.isEmpty(M)) {
                return b;
            }
            if (b() == null || m) {
                return "";
            }
            m = true;
            hd.d().submit(new Runnable() { // from class: com.amap.api.mapcore.util.gg.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, String> b2 = gg.g.b();
                        String a2 = gg.g.a(gg.i(context), "", "", gg.y(context));
                        if (TextUtils.isEmpty(a2)) {
                            return;
                        }
                        String a3 = gg.g.a(context, new String(id.a().a(new ic(a2.getBytes(), b2))));
                        if (TextUtils.isEmpty(a3)) {
                            return;
                        }
                        gg.b = a3;
                    } catch (Throwable unused) {
                    }
                }
            });
            return "";
        }
        return b;
    }

    public static String a() {
        return k;
    }

    public static void c() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
            }
        } catch (Throwable unused) {
        }
    }

    public static String e() {
        if (!TextUtils.isEmpty(y)) {
            return y;
        }
        String property = System.getProperty("os.arch");
        y = property;
        return property;
    }

    private static String f() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = Build.VERSION.SDK_INT >= 9 ? com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(networkInterface) : null;
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                        if (upperCase.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(upperCase);
                        sb.append(":");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(e)) {
                return e;
            }
            InterfaceC4565a interfaceC4565a = g;
            return interfaceC4565a == null ? "" : interfaceC4565a.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long d() {
        long blockCount;
        long blockCount2;
        long j2 = w;
        if (j2 != 0) {
            return j2;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockCount = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                blockCount2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                blockCount = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
                blockCount2 = (statFs2.getBlockCount() * statFs2.getBlockSize()) / 1048576;
            }
            w = blockCount + blockCount2;
        } catch (Throwable unused) {
        }
        return w;
    }

    public static void a(InterfaceC4565a interfaceC4565a) {
        if (g == null) {
            g = interfaceC4565a;
        }
    }

    private static boolean a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String a(Context context, String str, boolean z2) {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 && i3 >= 21) {
            try {
                if (TextUtils.isEmpty(i)) {
                    if (z2 || (i2 = h) < 0 || i2 >= 2) {
                        TelephonyManager L = L(context);
                        if (h == -1) {
                            Method a2 = gn.a(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                            if (a2 != null) {
                                h = ((Integer) a2.invoke(L, new Object[0])).intValue();
                            } else {
                                h = 0;
                            }
                        }
                        if (z2 || h > 1) {
                            Method a3 = gn.a(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
                            if (a3 == null) {
                                h = 0;
                                return "";
                            }
                            StringBuilder sb = new StringBuilder();
                            for (int i4 = 0; i4 < h; i4++) {
                                try {
                                    sb.append((String) a3.invoke(L, Integer.valueOf(i4)));
                                    sb.append(str);
                                } catch (Throwable unused) {
                                }
                            }
                            String sb2 = sb.toString();
                            if (sb2.length() == 0) {
                                h = 0;
                                return "";
                            }
                            String substring = sb2.substring(0, sb2.length() - 1);
                            i = substring;
                            return substring;
                        }
                        return "";
                    }
                    return "";
                }
                return i;
            } catch (Throwable unused2) {
                return "";
            }
        }
        return "";
    }

    private static List<ScanResult> a(List<ScanResult> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            for (int i3 = 1; i3 < size - i2; i3++) {
                int i4 = i3 - 1;
                if (list.get(i4).level > list.get(i3).level) {
                    list.set(i4, list.get(i3));
                    list.set(i3, list.get(i4));
                }
            }
        }
        return list;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context, boolean z2) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(gn.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(gn.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(gn.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(gn.c("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z2 == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
