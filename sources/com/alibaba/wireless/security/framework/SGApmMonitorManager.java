package com.alibaba.wireless.security.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.framework.utils.C4012a;
import com.alibaba.wireless.security.framework.utils.C4017e;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.taobao.accs.common.Constants;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;
import com.taobao.weex.annotation.JSMethod;
import com.ut.device.UTDevice;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SGApmMonitorManager {
    private static SGApmMonitorManager q = null;
    private static int r = 5000;
    private static ScheduledExecutorService s;
    private static ScheduledExecutorService t;
    private static JSONObject u = new JSONObject();
    private static long v;
    private C3999d e;
    private ConcurrentHashMap<String, Number> a = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Number> b = new ConcurrentHashMap<>();
    private volatile int c = 0;
    private Context d = null;
    private String f = null;
    private volatile boolean g = false;
    private boolean h = false;
    private int i = 0;
    private boolean j = true;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private boolean o = false;
    private String p = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$a */
    /* loaded from: classes8.dex */
    public class C3986a implements Application.ActivityLifecycleCallbacks {
        C3986a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            SGApmMonitorManager.b(SGApmMonitorManager.this);
            if (SGApmMonitorManager.this.i == 1) {
                SGApmMonitorManager.this.j = true;
                if (SGApmMonitorManager.this.n > 0) {
                    SGApmMonitorManager.this.m += System.currentTimeMillis() - SGApmMonitorManager.this.n;
                }
                SGApmMonitorManager.this.l = System.currentTimeMillis();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            SGApmMonitorManager.c(SGApmMonitorManager.this);
            if (SGApmMonitorManager.this.i == 0) {
                SGApmMonitorManager.this.j = false;
                if (SGApmMonitorManager.this.l == 0) {
                    SGApmMonitorManager.this.l = SGApmMonitorManager.v;
                }
                SGApmMonitorManager.this.k += System.currentTimeMillis() - SGApmMonitorManager.this.l;
                SGApmMonitorManager.this.n = System.currentTimeMillis();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$b */
    /* loaded from: classes8.dex */
    class ThreadFactoryC3987b implements ThreadFactory {
        ThreadFactoryC3987b(SGApmMonitorManager sGApmMonitorManager) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGApmMonitor-1");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$c */
    /* loaded from: classes8.dex */
    class ThreadFactoryC3988c implements ThreadFactory {
        ThreadFactoryC3988c(SGApmMonitorManager sGApmMonitorManager) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGApmMonitor-2");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$d */
    /* loaded from: classes8.dex */
    class RunnableC3989d implements Runnable {
        RunnableC3989d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SGApmMonitorManager.this.f();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$e */
    /* loaded from: classes8.dex */
    class RunnableC3990e implements Runnable {
        RunnableC3990e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SGApmMonitorManager.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$f */
    /* loaded from: classes8.dex */
    public class RunnableC3991f implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        RunnableC3991f(boolean z, String str, String str2) {
            this.a = z;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = SGApmMonitorManager.this.f;
            String str2 = SGApmMonitorManager.this.p;
            UserTrackMethodJniBridge.addUtRecord("100171", 0, 1, str, 0L, null, str2, "" + this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$g */
    /* loaded from: classes8.dex */
    class RunnableC3992g implements Runnable {
        private String a;

        public RunnableC3992g(String str, int i) {
            this.a = Base64.encodeToString(SGApmMonitorManager.this.a(str, i).getBytes(), 2);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            if (str == null) {
                return;
            }
            SGApmMonitorManager.this.a(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$h */
    /* loaded from: classes8.dex */
    class RunnableC3993h implements Runnable {
        RunnableC3993h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SGApmMonitorManager.this.h) {
                SGApmMonitorManager.t.submit(new RunnableC3992g("always", 1));
            }
            if (SGApmMonitorManager.this.c == 0 && SGApmMonitorManager.this.isAllPluginLoaded()) {
                SGApmMonitorManager.this.g();
                SGApmMonitorManager.this.g = false;
                JSONObject unused = SGApmMonitorManager.u = null;
                SGApmMonitorManager.s.shutdown();
                SGApmMonitorManager.t.shutdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$i */
    /* loaded from: classes8.dex */
    public class RunnableC3994i implements Runnable {
        private String a;
        private int b;
        private int c;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$i$a */
        /* loaded from: classes8.dex */
        class RunnableC3995a implements Runnable {
            RunnableC3995a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SGApmMonitorManager.this.h();
            }
        }

        public RunnableC3994i(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != null && SGApmMonitorManager.this.g && SGApmMonitorManager.u != null && this.b <= 5) {
                try {
                    if (((Number) SGApmMonitorManager.this.b.get(this.a)) == null) {
                        SGApmMonitorManager.t.submit(new RunnableC3995a());
                        ScheduledExecutorService scheduledExecutorService = SGApmMonitorManager.t;
                        SGApmMonitorManager sGApmMonitorManager = SGApmMonitorManager.this;
                        scheduledExecutorService.submit(new RunnableC3992g(this.a + "_f", this.b));
                        SGApmMonitorManager.i(SGApmMonitorManager.this);
                        SGApmMonitorManager.s.schedule(new RunnableC3994i(this.a, this.b + 1, this.c), (long) this.c, TimeUnit.MILLISECONDS);
                    } else if (this.b > 1) {
                        ScheduledExecutorService scheduledExecutorService2 = SGApmMonitorManager.t;
                        SGApmMonitorManager sGApmMonitorManager2 = SGApmMonitorManager.this;
                        scheduledExecutorService2.submit(new RunnableC3992g(this.a + "_s", this.b));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, int i) {
        String str2 = "";
        String packageName = this.d.getPackageName();
        try {
            str2 = this.d.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("SGApmMonitor", "", e);
        }
        long j = this.k;
        long j2 = this.m;
        if (this.l == 0) {
            this.l = v;
        }
        if (this.j) {
            j += System.currentTimeMillis() - this.l;
        } else if (this.n > 0) {
            j2 += System.currentTimeMillis() - this.n;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("utdid", j());
            jSONObject.put("sysver", Build.VERSION.getRELEASE());
            jSONObject.put("model", Build.getMODEL());
            jSONObject.put("brand", Build.getBRAND());
            jSONObject.put("reason", str);
            jSONObject.put("wsv", this.f);
            jSONObject.put("wsd", k());
            jSONObject.put(ForegroundJointPoint.TYPE, this.j);
            jSONObject.put("foregroundtime", j);
            jSONObject.put("backgroundtime", j2);
            jSONObject.put("fulltrack", this.o);
            jSONObject.put("sample", this.h);
            jSONObject.put("tryround", i);
            jSONObject.put("initts", v);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("appver", str2);
            jSONObject.put("pkgname", packageName);
            jSONObject.put("pid", Process.myPid());
            jSONObject.put("process", a(this.d));
            jSONObject.put("tracklog", u);
            jSONObject.put("costlog", a(this.b));
            jSONObject.put("nt", this.e.getRouter().doCommand(11154, new Object[0]));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    private JSONObject a(ConcurrentHashMap<String, Number> concurrentHashMap) {
        try {
            ArrayList<String> arrayList = new ArrayList(concurrentHashMap.keySet());
            Collections.sort(arrayList);
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                jSONObject.put(str, concurrentHashMap.get(str));
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.net.HttpURLConnection] */
    public void a(String str) {
        Context context;
        String str2;
        if (str == null || (context = this.d) == null) {
            return;
        }
        String packageName = context.getPackageName();
        try {
            str2 = this.d.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        ?? r2 = "https://mum.alibabachengdun.com/repTd.json?e=2040&pn=" + packageName + "&os=0&pv=" + str2 + "&pt=1";
        BufferedReader bufferedReader = null;
        try {
            try {
                r2 = (HttpURLConnection) new URL(r2).openConnection();
                if (r2 != 0) {
                    try {
                        r2.setConnectTimeout(20000);
                        r2.setReadTimeout(20000);
                        r2.setRequestMethod("POST");
                        r2.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                        r2.setRequestProperty("Accept-Charset", "UTF-8");
                        r2.setDoInput(true);
                        r2.connect();
                        OutputStream outputStream = r2.getOutputStream();
                        outputStream.write(str.getBytes());
                        outputStream.flush();
                        if (r2.getResponseCode() != 200) {
                            r2.disconnect();
                            return;
                        }
                        InputStream inputStream = r2.getInputStream();
                        if (inputStream == null) {
                            r2.disconnect();
                            return;
                        }
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        do {
                            try {
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (r2 == 0) {
                                    return;
                                }
                                r2.disconnect();
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (r2 != 0) {
                                    r2.disconnect();
                                }
                                throw th;
                            }
                        } while (bufferedReader2.readLine() != null);
                        bufferedReader = bufferedReader2;
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (r2 == 0) {
                    return;
                }
            } catch (Exception e6) {
                e = e6;
                r2 = 0;
            } catch (Throwable th2) {
                th = th2;
                r2 = 0;
            }
            r2.disconnect();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void a(String str, String str2) {
        try {
            if (TextUtils.equals(str2, "7L2OvtRdxzOJAe7ImU+4I2bAxvq1oDLyTCzRgSPGufNIb7ZY5FsHDFaEzD98Mn7K")) {
                boolean delete = new File(b(this.d), "init.config").delete();
                this.e.a(k());
                t.schedule(new RunnableC3991f(delete, str, str2), 5L, TimeUnit.SECONDS);
            }
        } catch (Exception unused) {
        }
    }

    private boolean a() {
        if (n()) {
            return true;
        }
        double d = 0.001d;
        File b = b(this.d);
        File file = new File(b, "." + i());
        if (file.exists()) {
            String a = C4012a.a(file);
            try {
                if (!TextUtils.isEmpty(a)) {
                    d = Double.parseDouble(a);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return new Random().nextDouble() < d;
    }

    static /* synthetic */ int b(SGApmMonitorManager sGApmMonitorManager) {
        int i = sGApmMonitorManager.i;
        sGApmMonitorManager.i = i + 1;
        return i;
    }

    private File b(Context context) {
        String str;
        File dir;
        String str2;
        File file;
        if (context == null) {
            return null;
        }
        try {
            str2 = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
        }
        if (str2 != null) {
            if (new File(str2).exists()) {
                str = (file.lastModified() / 1000) + "";
                if (str == null && (dir = context.getDir("SGLib", 0)) != null) {
                    return new File(dir, "app_" + str);
                }
                return null;
            }
        }
        str = null;
        if (str == null) {
            return null;
        }
        return new File(dir, "app_" + str);
    }

    static /* synthetic */ int c(SGApmMonitorManager sGApmMonitorManager) {
        int i = sGApmMonitorManager.i;
        sGApmMonitorManager.i = i - 1;
        return i;
    }

    private void c(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        ((Application) context).registerActivityLifecycleCallbacks(new C3986a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f() {
        /*
            r11 = this;
            java.lang.String r0 = "securityguard_orange_namespace"
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.String r2 = "1"
            r3 = 0
            java.lang.Class<com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener> r4 = com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener.class
            int r5 = com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener.a     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "getOrangeConfig"
            r6 = 3
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> L42
            r8 = 0
            r7[r8] = r1     // Catch: java.lang.Throwable -> L42
            r9 = 1
            r7[r9] = r1     // Catch: java.lang.Throwable -> L42
            r10 = 2
            r7[r10] = r1     // Catch: java.lang.Throwable -> L42
            java.lang.reflect.Method r1 = r4.getMethod(r5, r7)     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L40
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L42
            r5[r8] = r0     // Catch: java.lang.Throwable -> L42
            java.lang.String r7 = "128"
            r5[r9] = r7     // Catch: java.lang.Throwable -> L42
            r5[r10] = r2     // Catch: java.lang.Throwable -> L42
            java.lang.Object r5 = r1.invoke(r4, r5)     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L42
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L43
            r6[r8] = r0     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = "129"
            r6[r9] = r0     // Catch: java.lang.Throwable -> L43
            r6[r10] = r2     // Catch: java.lang.Throwable -> L43
            java.lang.Object r0 = r1.invoke(r4, r6)     // Catch: java.lang.Throwable -> L43
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L43
            goto L44
        L40:
            r0 = r3
            goto L45
        L42:
            r5 = r3
        L43:
            r0 = r3
        L44:
            r3 = r5
        L45:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "enable1: "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = ", enable2: "
            r1.append(r4)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "SGApmMonitor"
            android.util.Log.e(r4, r1)
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> Lcd
            android.content.Context r4 = r11.d     // Catch: java.lang.Exception -> Lcd
            java.io.File r4 = r11.b(r4)     // Catch: java.lang.Exception -> Lcd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r5.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r6 = ".pma_"
            r5.append(r6)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r6 = r11.i()     // Catch: java.lang.Exception -> Lcd
            r5.append(r6)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Lcd
            r1.<init>(r4, r5)     // Catch: java.lang.Exception -> Lcd
            boolean r4 = r1.exists()     // Catch: java.lang.Exception -> Lcd
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Exception -> Lcd
            if (r3 == 0) goto L93
            if (r4 != 0) goto L98
            r1.createNewFile()     // Catch: java.lang.Exception -> Lcd
            goto L98
        L93:
            if (r4 == 0) goto L98
            r1.delete()     // Catch: java.lang.Exception -> Lcd
        L98:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> Lcd
            android.content.Context r3 = r11.d     // Catch: java.lang.Exception -> Lcd
            java.io.File r3 = r11.b(r3)     // Catch: java.lang.Exception -> Lcd
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r4.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r5 = ".istbg_"
            r4.append(r5)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r5 = r11.i()     // Catch: java.lang.Exception -> Lcd
            r4.append(r5)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lcd
            r1.<init>(r3, r4)     // Catch: java.lang.Exception -> Lcd
            boolean r3 = r1.exists()     // Catch: java.lang.Exception -> Lcd
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Exception -> Lcd
            if (r0 == 0) goto Lc8
            if (r3 != 0) goto Lcd
            r1.createNewFile()     // Catch: java.lang.Exception -> Lcd
            goto Lcd
        Lc8:
            if (r3 == 0) goto Lcd
            r1.delete()     // Catch: java.lang.Exception -> Lcd
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.SGApmMonitorManager.f():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Context context = this.d;
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("sgloadfailed", 0);
            int i = sharedPreferences.getInt(Constants.KEY_TIMES, 0);
            if (i > 5) {
                File file = new File(this.d.getDir("SGLib", 0), ".nt");
                if (file.exists()) {
                    file.delete();
                }
            } else {
                sharedPreferences.edit().putInt(Constants.KEY_TIMES, i + 1).commit();
            }
        } catch (Exception unused) {
        }
    }

    public static SGApmMonitorManager getInstance() {
        if (q == null) {
            synchronized (SGApmMonitorManager.class) {
                if (q == null) {
                    q = new SGApmMonitorManager();
                }
            }
        }
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Context context = this.d;
        if (context == null) {
            return;
        }
        File file = new File(context.getDir("SGLib", 0), ".nt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            SharedPreferences sharedPreferences = this.d.getSharedPreferences("sgloadfailed", 0);
            if (sharedPreferences.getInt(Constants.KEY_TIMES, 0) != 0) {
                sharedPreferences.edit().putInt(Constants.KEY_TIMES, 0).commit();
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ int i(SGApmMonitorManager sGApmMonitorManager) {
        int i = sGApmMonitorManager.c;
        sGApmMonitorManager.c = i + 1;
        return i;
    }

    private String i() {
        try {
            return this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    private String j() {
        Context context = this.d;
        try {
            String str = (String) UTDevice.class.getMethod("getUtdid", Context.class).invoke(null, context);
            if (str != null) {
                if (!str.isEmpty()) {
                    if (str.contains("?")) {
                    }
                    return str;
                }
            }
            String str2 = (String) com.ta.utdid2.device.UTDevice.class.getMethod("getUtdid", Context.class).invoke(null, context);
            try {
                if (str2.contains("?")) {
                    return "";
                }
            } catch (Exception unused) {
            }
            return str2;
        } catch (Exception unused2) {
            return "";
        }
    }

    private String k() {
        if (this.p == null) {
            try {
                C3997b a = C3997b.a(new File(b(this.d), "init.config"));
                this.p = "" + a.b();
            } catch (Exception unused) {
            }
        }
        return this.p;
    }

    private boolean l() {
        File b = b(this.d);
        StringBuilder sb = new StringBuilder();
        sb.append(".pma_");
        sb.append(i());
        return new File(b, sb.toString()).exists();
    }

    private boolean m() {
        Context context = this.d;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        return "com.taobao.taobao".equals(packageName) || ShareConstant.DD_APP_PACKAGE.equals(packageName) || "com.alibaba.wireless.securityguard".equals(packageName);
    }

    private boolean n() {
        try {
            if (m() && o()) {
                return i().split("\\.").length == 4;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean o() {
        File b = b(this.d);
        StringBuilder sb = new StringBuilder();
        sb.append(".istbg_");
        sb.append(i());
        return new File(b, sb.toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        String str;
        HttpURLConnection httpURLConnection;
        Context context = this.d;
        if (context == null) {
            return;
        }
        String packageName = context.getPackageName();
        try {
            str = this.d.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (Exception unused) {
            str = "";
        }
        String k = k();
        if (k == null) {
            return;
        }
        String str2 = "http://cdn-mum.alibabachengdun.com/sg7sX1/rYxU/pDDw/" + k + "?pn=" + packageName + "&pv=" + str;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    try {
                        char[] cArr = new char[1100];
                        StringBuffer stringBuffer = new StringBuffer();
                        int read = bufferedReader2.read(cArr);
                        if (read < 1024) {
                            stringBuffer.append(cArr, 0, read);
                        }
                        a(str2, stringBuffer.toString());
                        bufferedReader = bufferedReader2;
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
    }

    public synchronized void addTrackInfo(String str) {
        JSONArray jSONArray;
        if (str != null) {
            if (this.g) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(m80.DINAMIC_PREFIX_AT);
                sb.append(this.j ? "1" : "0");
                String sb2 = sb.toString();
                String str2 = "" + Process.myPid() + JSMethod.NOT_SET + Process.myTid();
                try {
                    jSONArray = (JSONArray) u.get(str2);
                } catch (Exception unused) {
                    jSONArray = new JSONArray();
                    try {
                        u.put(str2, jSONArray);
                    } catch (Exception unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", sb2);
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Exception unused3) {
                }
            }
        }
    }

    public void init(Context context) {
        this.d = context;
        v = System.currentTimeMillis();
        Context context2 = this.d;
        if (context2 == null || !C4017e.b(context2)) {
            return;
        }
        s = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC3987b(this));
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC3988c(this));
        t = newSingleThreadScheduledExecutor;
        if (s == null || newSingleThreadScheduledExecutor == null) {
            return;
        }
        newSingleThreadScheduledExecutor.schedule(new RunnableC3989d(), 5L, TimeUnit.SECONDS);
        boolean l = l();
        this.h = a();
        Log.e("SGApmMonitor", "1 : " + l + ", 2 : " + this.h);
        if (l) {
            this.g = true;
            this.o = isEnableFullTrackRecord();
            c(this.d);
            s.schedule(new RunnableC3993h(), r * 5, TimeUnit.MILLISECONDS);
            t.submit(new RunnableC3990e());
        }
    }

    public boolean isAllPluginLoaded() {
        return this.b.containsKey("getInstance") && this.b.containsKey("securitybody") && this.b.containsKey("middletier");
    }

    public boolean isEnableFullTrackRecord() {
        if (this.d == null) {
            return false;
        }
        if (n()) {
            return true;
        }
        return new File(this.d.getDir("SGLib", 0), ".nt").exists();
    }

    public boolean isForeground() {
        return this.j;
    }

    public void monitorEnd(String str) {
        if (str == null || !this.g) {
            return;
        }
        addTrackInfo("j_" + str + "_e");
        Number number = this.a.get(str);
        if (number != null && this.b.get(str) == null) {
            this.b.put(str, Long.valueOf(System.currentTimeMillis() - number.longValue()));
        }
    }

    public void monitorStart(String str) {
        monitorStartWithTimeout(str, r);
    }

    public void monitorStartWithTimeout(String str, int i) {
        if (str == null || !this.g) {
            return;
        }
        addTrackInfo("j_" + str + "_s");
        if (this.a.get(str) != null) {
            return;
        }
        this.a.put(str, Long.valueOf(System.currentTimeMillis()));
        s.schedule(new RunnableC3994i(str, 1, i), i, TimeUnit.MILLISECONDS);
    }

    public void setMainPluginVersion(String str) {
        this.f = str;
    }

    public void setSGPluginManager(C3999d c3999d) {
        this.e = c3999d;
    }
}
