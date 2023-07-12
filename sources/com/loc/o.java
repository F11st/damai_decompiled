package com.loc;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
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
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.taobao.weex.annotation.JSMethod;
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
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import tb.b43;
import tb.jn1;
import tb.w33;
import tb.x33;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class o {
    private static boolean A = false;
    private static boolean B = false;
    private static long C = 0;
    private static int D = 0;
    private static String E = null;
    private static String F = "";
    private static boolean G = true;
    private static boolean H = false;
    private static String I = "";
    private static boolean J = false;
    private static int K = -1;
    private static boolean L = false;
    private static int M = -1;
    private static boolean N = false;
    private static volatile b O = null;
    static String a = "";
    static String b = "";
    static volatile boolean c = true;
    static String d = "";
    private static String e = null;
    public static a f = null;
    private static volatile boolean g = false;
    private static String h = "";
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static String l = "";
    private static String m = "";
    private static boolean n = false;
    private static boolean o = false;
    private static String p = "";
    private static boolean q = false;
    private static String r = "";
    private static boolean s = false;
    private static String t = "";
    private static String u = "";
    private static String v = "";
    static int w = -1;
    static String x = "";
    private static boolean y = false;
    private static String z = "";

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        bl a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private static BroadcastReceiver a;
        private static ConnectivityManager b;
        private static NetworkRequest c;
        private static ConnectivityManager.NetworkCallback d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class a extends ConnectivityManager.NetworkCallback {
            a(b bVar) {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                o.S();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                o.S();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || a != null) {
                    return;
                }
                a = new BroadcastReceiver(this) { // from class: com.loc.o.b.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        if (v1.v("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                            o.S();
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(v1.v("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(a, intentFilter);
            } else if (o.I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && b == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                b = connectivityManager;
                if (connectivityManager != null) {
                    c = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    a aVar = new a(this);
                    d = aVar;
                    b.registerNetworkCallback(c, aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c implements ServiceConnection {
        private static String c;
        private Context a;
        private int b;

        c(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        private String a() {
            try {
                if (TextUtils.isEmpty(c)) {
                    byte[] digest = MessageDigest.getInstance(v1.v("IU0hBMQ")).digest(this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures[0].toByteArray());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (byte b : digest) {
                        stringBuffer.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    if (!TextUtils.isEmpty(stringBuffer2)) {
                        c = stringBuffer2;
                    }
                    return stringBuffer2;
                }
                return c;
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004e A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:3:0x0008, B:16:0x004e, B:10:0x0017, B:11:0x003a, B:12:0x0040, B:13:0x0044), top: B:26:0x0008 }] */
        @Override // android.content.ServiceConnection
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onServiceConnected(android.content.ComponentName r6, android.os.IBinder r7) {
            /*
                r5 = this;
                android.os.Parcel r6 = android.os.Parcel.obtain()
                android.os.Parcel r0 = android.os.Parcel.obtain()
                int r1 = r5.b     // Catch: java.lang.Throwable -> L62
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == r2) goto L44
                r2 = 4
                if (r1 == r2) goto L3a
                r2 = 5
                if (r1 == r2) goto L17
                r1 = 0
                goto L4c
            L17:
                java.lang.String r1 = "KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"
                java.lang.String r1 = com.loc.v1.v(r1)     // Catch: java.lang.Throwable -> L62
                r6.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L62
                android.content.Context r1 = r5.a     // Catch: java.lang.Throwable -> L62
                java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> L62
                r6.writeString(r1)     // Catch: java.lang.Throwable -> L62
                java.lang.String r1 = r5.a()     // Catch: java.lang.Throwable -> L62
                r6.writeString(r1)     // Catch: java.lang.Throwable -> L62
                java.lang.String r1 = "IT1VJRA"
                java.lang.String r1 = com.loc.v1.v(r1)     // Catch: java.lang.Throwable -> L62
                r6.writeString(r1)     // Catch: java.lang.Throwable -> L62
                goto L4b
            L3a:
                java.lang.String r1 = "UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ"
                java.lang.String r1 = com.loc.v1.v(r1)     // Catch: java.lang.Throwable -> L62
            L40:
                r6.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L62
                goto L4b
            L44:
                java.lang.String r1 = "UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U"
                java.lang.String r1 = com.loc.v1.v(r1)     // Catch: java.lang.Throwable -> L62
                goto L40
            L4b:
                r1 = 1
            L4c:
                if (r1 == 0) goto L5b
                r7.transact(r4, r6, r0, r3)     // Catch: java.lang.Throwable -> L62
                r0.readException()     // Catch: java.lang.Throwable -> L62
                java.lang.String r7 = r0.readString()     // Catch: java.lang.Throwable -> L62
                com.loc.o.E(r7)     // Catch: java.lang.Throwable -> L62
            L5b:
                r0.recycle()
                r6.recycle()
                return
            L62:
                r7 = move-exception
                java.lang.String r1 = "oac"
                int r2 = r5.b     // Catch: java.lang.Throwable -> L75
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L75
                tb.y33.e(r7, r1, r2)     // Catch: java.lang.Throwable -> L75
                r0.recycle()
                r6.recycle()
                return
            L75:
                r7 = move-exception
                r0.recycle()
                r6.recycle()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.o.c.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static void A(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void B(String str) {
        e = str;
    }

    public static String C() {
        try {
            if (TextUtils.isEmpty(d)) {
                a aVar = f;
                return aVar == null ? "" : aVar.a();
            }
            return d;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String D(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static a G() {
        return f;
    }

    public static String H(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String k0 = k0(context);
            if (k0 != null && k0.length() >= 5) {
                return k0.substring(3, 5);
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int J(Context context) {
        try {
            return o(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] K() {
        return new String[]{"", ""};
    }

    public static int L(Context context) {
        try {
            return m(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static void M() {
        try {
            x33.a();
        } catch (Throwable unused) {
        }
    }

    public static long N() {
        long blockCount;
        long blockCount2;
        long j2 = C;
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
            C = blockCount + blockCount2;
        } catch (Throwable unused) {
        }
        return C;
    }

    public static String O(Context context) {
        try {
            return k(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String P() {
        if (TextUtils.isEmpty(E)) {
            String property = System.getProperty("os.arch");
            E = property;
            return property;
        }
        return E;
    }

    public static String Q(final Context context) {
        if (i) {
            return "";
        }
        if (TextUtils.isEmpty(h) && !j) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                o0.f().d(new ck() { // from class: com.loc.o.2
                    @Override // com.loc.ck
                    public final void a() {
                        o.g(context);
                        o.U();
                    }
                });
                return h;
            }
            j = true;
            return g(context);
        }
        return h;
    }

    public static String R(Context context) {
        String str;
        if (k) {
            String str2 = a;
            return str2 == null ? "" : str2;
        }
        try {
            str = a;
        } catch (Throwable unused) {
        }
        if (str == null || "".equals(str)) {
            if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
                a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (!TextUtils.isEmpty(a)) {
                k = true;
                return a;
            }
            try {
                String c2 = c(context);
                a = c2;
                if (!TextUtils.isEmpty(c2)) {
                    k = true;
                    return a;
                }
            } catch (Throwable unused2) {
            }
            try {
                a = d(context);
                k = true;
            } catch (Throwable unused3) {
            }
            String str3 = a;
            return str3 == null ? "" : str3;
        }
        return a;
    }

    public static void S() {
        K = -1;
        L = false;
        M = -1;
        N = false;
        I = "";
        J = false;
        r = "";
        s = false;
    }

    public static String T(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (TextUtils.isEmpty(m) && !n) {
            if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                if (i2 >= 26) {
                    String str = (String) v1.h(Build.class, "MZ2V0U2VyaWFs", new Class[0]).invoke(Build.class, new Object[0]);
                    n = true;
                    return str;
                }
                if (i2 >= 9) {
                    m = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getSERIAL();
                    n = true;
                }
                String str2 = m;
                return str2 == null ? "" : str2;
            }
            return "";
        }
        return m;
    }

    static /* synthetic */ boolean U() {
        j = true;
        return true;
    }

    public static String V(Context context) {
        if (TextUtils.isEmpty(l) && !o) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), v1.v(new String(w33.c(13))));
                l = string;
                o = true;
                return string == null ? "" : string;
            } catch (Throwable unused) {
                return l;
            }
        }
        return l;
    }

    public static String W(Context context) {
        if (Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30) {
            try {
                String str = p;
                if ((str == null || "".equals(str)) && !q && I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF"))) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    p = WifiInfo.getMacAddress(wifiManager.getConnectionInfo());
                    if (v1.v("YMDI6MDA6MDA6MDA6MDA6MDA").equals(p) || v1.v("YMDA6MDA6MDA6MDA6MDA6MDA").equals(p)) {
                        p = h(context);
                    }
                    q = true;
                }
                return p;
            } catch (Throwable unused) {
            }
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String X(Context context) {
        try {
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return "";
            }
            String networkOperator = p2.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Y(Context context) {
        TelephonyManager p2;
        if (s) {
            return r;
        }
        try {
            u(context);
            p2 = p(context);
        } catch (Throwable unused) {
        }
        if (p2 == null) {
            return r;
        }
        String networkOperator = p2.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            r = networkOperator.substring(3);
            s = true;
            return r;
        }
        s = true;
        return r;
    }

    public static int Z(Context context) {
        try {
            return o(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int a0(Context context) {
        try {
            return m(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo b0(Context context) {
        ConnectivityManager n2;
        if (I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (n2 = n(context)) != null) {
            return com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(n2);
        }
        return null;
    }

    private static String c(Context context) {
        try {
            String o2 = b43.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(o2) ? b43.o(context, "Alvin2", Constants.UTDID, "") : o2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c0(Context context) {
        try {
            NetworkInfo b0 = b0(context);
            if (b0 == null) {
                return null;
            }
            return b0.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (v1.m(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d0(Context context) {
        String str;
        StringBuilder sb;
        try {
            str = t;
        } catch (Throwable unused) {
        }
        if (str == null || "".equals(str)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(tb.v.ATTACH_MODE_WINDOW);
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
            t = sb.toString();
            return t;
        }
        return t;
    }

    private static String e(Context context) {
        try {
            Class<?> cls = Class.forName(v1.v("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(v1.v("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                h = str;
                return str;
            }
        } catch (Throwable th) {
            y33.e(th, "oa", "xm");
            i = true;
        }
        return h;
    }

    public static String e0(Context context) {
        try {
            if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                TelephonyManager p2 = p(context);
                return p2 == null ? "" : p2.getNetworkOperatorName();
            }
            return F;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String f(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(v1.v("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= columnCount) {
                            break;
                        } else if (v1.v("IdmFsdWU").equals(query.getColumnName(i2))) {
                            h = query.getString(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            i = true;
            y33.e(th, "oa", "vivo");
        }
        return h;
    }

    public static String f0(Context context) {
        ConnectivityManager n2;
        NetworkInfo activeNetworkInfo;
        try {
            return (!I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (n2 = n(context)) == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(n2)) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(Context context) {
        String v2 = v1.v("IeGlhb21p");
        String manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        if (!v2.equalsIgnoreCase(manufacturer)) {
            String v3 = v1.v("IeGlhb21p");
            String brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND();
            if (!v3.equalsIgnoreCase(brand) && !v1.v("IUkVETUk=").equalsIgnoreCase(manufacturer) && !v1.v("IUkVETUk=").equalsIgnoreCase(brand)) {
                if (v1.v("Idml2bw").equalsIgnoreCase(manufacturer) || v1.v("Idml2bw").equalsIgnoreCase(brand)) {
                    return f(context);
                }
                if (v1.v("IaHVhd2Vp").equalsIgnoreCase(manufacturer) || v1.v("IaHVhd2Vp").equalsIgnoreCase(brand) || v1.v("ISE9OT1I=").equalsIgnoreCase(manufacturer)) {
                    return x(context, 2);
                }
                if (v1.v("Mc2Ftc3VuZw").equalsIgnoreCase(manufacturer) || v1.v("Mc2Ftc3VuZw").equalsIgnoreCase(brand)) {
                    return x(context, 4);
                }
                if (v1.v("IT1BQTw").equalsIgnoreCase(manufacturer) || v1.v("IT1BQTw").equalsIgnoreCase(brand) || v1.v("MT25lUGx1cw").equalsIgnoreCase(manufacturer) || v1.v("MT25lUGx1cw").equalsIgnoreCase(brand) || v1.v("IUkVBTE1F").equalsIgnoreCase(brand)) {
                    return x(context, 5);
                }
                i = true;
                return h;
            }
        }
        return e(context);
    }

    public static String g0(Context context) {
        String str;
        try {
            String h0 = h0(context);
            try {
                if (TextUtils.isEmpty(h0)) {
                    h0 = w(context);
                }
                if (TextUtils.isEmpty(h0)) {
                    h0 = R(context);
                }
                if (TextUtils.isEmpty(h0)) {
                    h0 = Q(context);
                }
                if (TextUtils.isEmpty(h0)) {
                    h0 = V(context);
                }
                return TextUtils.isEmpty(h0) ? i(context) : h0;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static String h(Context context) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] bArr = null;
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 9 && (i2 < 30 || context.getApplicationInfo().targetSdkVersion < 30)) {
                        bArr = com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(networkInterface);
                    }
                    if (bArr == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArr) {
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
        } catch (Exception unused) {
        }
        return "";
    }

    public static String h0(Context context) {
        int i2;
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i2 >= 29) {
            return "";
        }
        String str = u;
        if ((str == null || "".equals(str)) && !A && I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return "";
            }
            Method h2 = v1.h(p2.getClass(), "QZ2V0RGV2aWNlSWQ", new Class[0]);
            if (i2 >= 26) {
                h2 = v1.h(p2.getClass(), "QZ2V0SW1laQ==", new Class[0]);
            }
            if (h2 != null) {
                u = (String) h2.invoke(p2, new Object[0]);
            }
            if (u == null) {
                u = "";
            }
            A = true;
            return u;
        }
        return u;
    }

    private static String i(Context context) {
        if (TextUtils.isEmpty(z)) {
            try {
                String o2 = b43.o(context, "open_common", "a1", "");
                if (TextUtils.isEmpty(o2)) {
                    z = "amap" + UUID.randomUUID().toString().replace(JSMethod.NOT_SET, "").toLowerCase();
                    SharedPreferences.Editor b2 = b43.b(context, "open_common");
                    b43.i(b2, "a1", v1.r(z));
                    b43.e(b2);
                } else {
                    z = v1.v(o2);
                }
            } catch (Throwable unused) {
            }
            return z;
        }
        return z;
    }

    public static String i0(Context context) {
        return h0(context) + com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + w(context) + com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + g0(context);
    }

    private static boolean j(Context context) {
        int simState;
        TelephonyManager p2 = p(context);
        return (p2 == null || (simState = p2.getSimState()) == 0 || simState == 1) ? false : true;
    }

    public static String j0(Context context) {
        String str;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        try {
            str = v;
        } catch (Throwable unused) {
        }
        if ((str == null || "".equals(str)) && I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            TelephonyManager p2 = p(context);
            if (p2 == null) {
                return "";
            }
            if (B) {
                return v;
            }
            if (i2 >= 26) {
                Method h2 = v1.h(p2.getClass(), "QZ2V0TWVpZA==", new Class[0]);
                if (h2 != null) {
                    v = (String) h2.invoke(p2, new Object[0]);
                }
                if (v == null) {
                    v = "";
                }
                B = true;
            }
            return v;
        }
        return v;
    }

    private static String k(Context context) throws InvocationTargetException, IllegalAccessException {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        boolean j2 = j(context);
        if (G != j2) {
            if (j2) {
                F = "";
                H = false;
            }
            G = j2;
        }
        String str = F;
        if ((str == null || "".equals(str)) && !H) {
            if (G) {
                if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                    TelephonyManager p2 = p(context);
                    if (p2 == null) {
                        return "";
                    }
                    Method h2 = v1.h(p2.getClass(), "UZ2V0U3Vic2NyaWJlcklk", new Class[0]);
                    if (h2 != null) {
                        F = (String) h2.invoke(p2, new Object[0]);
                    }
                    if (F == null) {
                        F = "";
                    }
                    H = true;
                    return F;
                }
                return F;
            }
            return "";
        }
        return F;
    }

    public static String k0(Context context) {
        try {
            return k(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String l(Context context) {
        TelephonyManager p2;
        if (J) {
            return I;
        }
        u(context);
        if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (p2 = p(context)) != null) {
            String simOperatorName = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSimOperatorName(p2);
            I = simOperatorName;
            if (TextUtils.isEmpty(simOperatorName)) {
                I = p2.getNetworkOperatorName();
            }
            J = true;
            return I;
        }
        return I;
    }

    public static int l0(Context context) {
        BufferedReader bufferedReader;
        int i2 = D;
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
            } catch (IOException unused2) {
            }
            try {
                i3 = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
                bufferedReader.close();
            } catch (Throwable unused3) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                int i4 = i3 / 1024;
                D = i4;
                return i4;
            }
        }
        int i42 = i3 / 1024;
        D = i42;
        return i42;
    }

    private static int m(Context context) {
        if (L) {
            return K;
        }
        u(context);
        if (context == null || !I(context, v1.v("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return K;
        }
        ConnectivityManager n2 = n(context);
        if (n2 == null) {
            return K;
        }
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(n2);
        if (activeNetworkInfo == null) {
            L = true;
            return K;
        }
        int type = activeNetworkInfo.getType();
        K = type;
        L = true;
        return type;
    }

    private static ConnectivityManager n(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int o(Context context) {
        TelephonyManager p2;
        if (N) {
            return M;
        }
        u(context);
        if (I(context, v1.v("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=")) && (p2 = p(context)) != null) {
            int networkType = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getNetworkType(p2);
            M = networkType;
            N = true;
            return networkType;
        }
        return M;
    }

    private static TelephonyManager p(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String q(Context context) {
        if (c) {
            String str = null;
            try {
                str = r(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                c = false;
                return "";
            }
            try {
                byte[] bytes = v1.v("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
                return new String(p1.e(v1.v("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), p1.g(str), bytes), "UTF-8");
            } catch (Throwable unused2) {
                c = false;
                return "";
            }
        }
        return "";
    }

    private static String r(Context context) {
        String str;
        try {
            str = s(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(v1.v("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(r1.a(v1.v("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String s(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (Build.VERSION.SDK_INT < 19 || I(context, v1.v("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            String a2 = r1.a(v1.v("LYW1hcF9kZXZpY2VfYWRpdQ"));
            String t2 = t(context);
            if (TextUtils.isEmpty(t2)) {
                return "";
            }
            File file = new File(t2 + File.separator + v1.v("KYmFja3Vwcw"), v1.v("MLmFkaXU"));
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
                                A(byteArrayOutputStream2);
                                A(randomAccessFile);
                                return "";
                            }
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    randomAccessFile = null;
                }
                if (!TextUtils.isEmpty(str) && str.contains(v1.v("SIw")) && (split = str.split(v1.v("SIw"))) != null && split.length == 2 && TextUtils.equals(a2, split[0])) {
                    String str2 = split[1];
                    A(byteArrayOutputStream);
                    A(randomAccessFile);
                    return str2;
                }
                A(byteArrayOutputStream);
                A(randomAccessFile);
            }
            return "";
        }
        return "";
    }

    private static String t(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(v1.v("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(v1.v("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(v1.v("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(v1.v("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static synchronized b u(Context context) {
        synchronized (o.class) {
            if (O == null) {
                if (context == null) {
                    return null;
                }
                b bVar = new b();
                O = bVar;
                bVar.a(context.getApplicationContext());
            }
            return O;
        }
    }

    public static String v() {
        return e;
    }

    public static String w(final Context context) {
        if (TextUtils.isEmpty(b)) {
            if (context == null) {
                return "";
            }
            String q2 = q(context);
            b = q2;
            if (TextUtils.isEmpty(q2)) {
                if (G() == null || g) {
                    return "";
                }
                g = true;
                o0.f().d(new ck() { // from class: com.loc.o.1
                    @Override // com.loc.ck
                    public final void a() {
                        try {
                            Map<String, String> b2 = o.f.b();
                            String a2 = o.f.a(o.R(context), "", "", o.k0(context));
                            if (TextUtils.isEmpty(a2)) {
                                return;
                            }
                            bg.b();
                            String a3 = o.f.a(context, new String(bg.c(o.f.a(a2.getBytes(), b2)).a));
                            if (TextUtils.isEmpty(a3)) {
                                return;
                            }
                            o.b = a3;
                        } catch (Throwable unused) {
                        }
                    }
                });
                return "";
            }
            return b;
        }
        return b;
    }

    private static String x(Context context, int i2) {
        try {
            Intent intent = new Intent();
            if (i2 == 2) {
                intent.setAction(v1.v("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));
                intent.setPackage(v1.v("UY29tLmh1YXdlaS5od2lk"));
            } else if (i2 == 4) {
                intent.setClassName(v1.v("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), v1.v("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));
            } else if (i2 != 5) {
                i = true;
                return h;
            } else {
                intent.setClassName(v1.v("YY29tLmhleXRhcC5vcGVuaWQ"), v1.v("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));
                intent.setAction(v1.v("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));
            }
            c cVar = new c(context, i2);
            if (context.bindService(intent, cVar, 1)) {
                int i3 = 0;
                while (i3 < 100 && TextUtils.isEmpty(h)) {
                    i3++;
                    Thread.sleep(15L);
                }
                context.unbindService(cVar);
            }
            return h;
        } catch (Throwable th) {
            y33.e(th, "oa", String.valueOf(i2));
            i = true;
            return h;
        }
    }

    public static String y(Context context, String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 && i2 >= 21) {
            try {
                if (TextUtils.isEmpty(x) && !y) {
                    TelephonyManager p2 = p(context);
                    if (w == -1) {
                        Method h2 = v1.h(TelephonyManager.class, "UZ2V0UGhvbmVDb3VudA=", new Class[0]);
                        if (h2 != null) {
                            try {
                                w = ((Integer) h2.invoke(p2, new Object[0])).intValue();
                            } catch (Throwable unused) {
                            }
                        }
                        w = 0;
                    }
                    Method h3 = v1.h(TelephonyManager.class, "MZ2V0SW1laQ=", Integer.TYPE);
                    if (h3 == null) {
                        w = 0;
                        y = true;
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < w; i3++) {
                        try {
                            sb.append((String) h3.invoke(p2, Integer.valueOf(i3)));
                            sb.append(str);
                        } catch (Throwable unused2) {
                        }
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() == 0) {
                        w = 0;
                        y = true;
                        return "";
                    }
                    String substring = sb2.substring(0, sb2.length() - 1);
                    x = substring;
                    y = true;
                    return substring;
                }
                return x;
            } catch (Throwable unused3) {
                return "";
            }
        }
        return "";
    }

    public static void z(a aVar) {
        if (f == null) {
            f = aVar;
        }
    }
}
