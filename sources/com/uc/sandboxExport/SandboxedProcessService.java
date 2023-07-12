package com.uc.sandboxExport;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import com.uc.crashsdk.export.CrashApi;
import com.uc.sandboxExport.IChildProcessSetup;
import com.uc.sandboxExport.helper.C7168b;
import com.uc.sandboxExport.helper.C7169c;
import com.youku.arch.solid.monitor.SolidMonitor;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class SandboxedProcessService extends Service {
    static final /* synthetic */ boolean a = true;
    private boolean d;
    private Constructor<?> f;
    private Method g;
    private Method h;
    private Method i;
    private IBinder j;
    private Object k;
    private Intent l;
    private String n;
    private int o;
    private final String b = "SandboxedProcessService";
    private String c = "SandboxedProcessService";
    private boolean e = false;
    private final IChildProcessSetup.Stub m = new BinderC7174i(this);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v49, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v31 */
    public void init(ParcelFileDescriptor parcelFileDescriptor, Parcelable[] parcelableArr, ParcelFileDescriptor parcelFileDescriptor2) {
        Method declaredMethod;
        DexFileClassLoader dexFileClassLoader;
        ?? r2;
        Method method;
        Method method2;
        ?? cls;
        DexFile dexFile;
        DexFileClassLoader dexFileClassLoader2;
        if (this.d) {
            return;
        }
        this.e = C7168b.a();
        C7169c.a(this.c, "doInit 1/4 - initCrashSdkIfNeeded, crashFD: %s", parcelFileDescriptor2);
        if (!a && parcelFileDescriptor2 == null) {
            throw new AssertionError();
        }
        if (parcelFileDescriptor2 != null) {
            try {
                int i = CrashApi.e;
                Object invoke = CrashApi.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    try {
                        declaredMethod = CrashApi.class.getDeclaredMethod("setHostFd", ParcelFileDescriptor.class);
                    } catch (Exception unused) {
                        declaredMethod = CrashApi.class.getDeclaredMethod("setIsolatedHostFd", ParcelFileDescriptor.class);
                    }
                    declaredMethod.invoke(invoke, parcelFileDescriptor2);
                }
            } catch (Throwable th) {
                C7169c.a(this.c, "initCrashSdkIfNeeded: init crashsdk failed.", th);
            }
        }
        C7169c.a(this.c, "doInit 2/4 - initServiceClassIfNeeded, dexFd: %s, libFdInfos: %s", parcelFileDescriptor, String.valueOf(parcelableArr));
        String stringExtra = this.l.getStringExtra("dex.path");
        String stringExtra2 = this.l.getStringExtra("odex.path");
        String stringExtra3 = this.l.getStringExtra("lib.path");
        String stringExtra4 = this.l.getStringExtra("source.dir");
        String stringExtra5 = this.l.getStringExtra("source.dir.prior");
        a(Switches.ENABLE_RENDERER_DEBUG_LOG, false);
        if (stringExtra == null || stringExtra.length() == 0) {
            dexFileClassLoader = null;
        } else {
            try {
                dexFile = (this.e && stringExtra5 != null && new File(stringExtra5).exists()) ? new DexFile(stringExtra5) : null;
            } catch (Throwable unused2) {
                dexFile = null;
            }
            try {
                dexFileClassLoader2 = new DexFileClassLoader(stringExtra, stringExtra2, stringExtra3, getClass().getClassLoader(), parcelFileDescriptor, dexFile == null ? stringExtra4 : stringExtra5, dexFile);
            } catch (Throwable th2) {
                a("new DexFileClassLoader failed.", th2);
                dexFileClassLoader2 = null;
            }
            if (parcelFileDescriptor != null && this.e) {
                this.l.putExtra("isolated", true);
            }
            dexFileClassLoader = dexFileClassLoader2;
        }
        String stringExtra6 = this.l.getStringExtra("info.core.version");
        String stringExtra7 = this.l.getStringExtra("info.sdk.version");
        String a2 = a(dexFileClassLoader, "webviewSdkVersion");
        String a3 = a(dexFileClassLoader, "coreVersion");
        C7169c.a(this.c, "main process version: %s, %s", stringExtra7, stringExtra6);
        C7169c.a(this.c, "this process version: %s, %s", a2, a3);
        try {
            if (dexFileClassLoader != null) {
                cls = Class.forName("org.chromium.content.app.SandboxedProcessService0", false, dexFileClassLoader);
            } else {
                cls = Class.forName("org.chromium.content.app.SandboxedProcessService0");
            }
            dexFileClassLoader = cls;
            r2 = dexFileClassLoader;
        } catch (Throwable th3) {
            if (dexFileClassLoader == null) {
                a("Class.forName(org.chromium.content.app.SandboxedProcessService0) failed.", th3);
            } else {
                a("Class.forName(org.chromium.content.app.SandboxedProcessService0, " + dexFileClassLoader + ") failed.", th3);
            }
            r2 = 0;
        }
        try {
            Constructor<?> declaredConstructor = r2.getDeclaredConstructor(new Class[0]);
            this.f = declaredConstructor;
            declaredConstructor.setAccessible(true);
        } catch (Throwable th4) {
            a("initServiceClassIfNeeded: getDeclaredConstructor failed.", th4);
        }
        try {
            Method method3 = r2.getMethod("onDestroy", new Class[0]);
            this.g = method3;
            method3.setAccessible(true);
        } catch (Throwable th5) {
            a("initServiceClassIfNeeded: getMethod onDestroy failed.", th5);
        }
        try {
            Method declaredMethod2 = r2.getDeclaredMethod("initializeEngine", Class.forName("[Landroid.os.ParcelFileDescriptor;"));
            this.i = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Throwable th6) {
            a("initServiceClassIfNeeded: getDeclaredMethod mInitializeMethod failed.", th6);
        }
        try {
            Method declaredMethod3 = r2.getDeclaredMethod("onBind", Class.forName("android.content.Intent"));
            this.h = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (Throwable th7) {
            a("initServiceClassIfNeeded: getDeclaredMethod onBind failed.", th7);
        }
        Constructor<?> constructor = this.f;
        if (constructor != null) {
            try {
                this.k = constructor.newInstance(new Object[0]);
            } catch (Exception e) {
                a("initServiceClassIfNeeded: new SandboxedProcessService failed.", e);
            }
        }
        C7169c.a(4, this.c, "doInit 3/4 - attachSandboxedProcessService", null);
        try {
            Class<?> cls2 = Class.forName("android.app.Service");
            Field declaredField = cls2.getDeclaredField("mThread");
            declaredField.setAccessible(true);
            Field declaredField2 = cls2.getDeclaredField("mClassName");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls2.getDeclaredField("mToken");
            declaredField3.setAccessible(true);
            Field declaredField4 = cls2.getDeclaredField("mApplication");
            declaredField4.setAccessible(true);
            Field declaredField5 = cls2.getDeclaredField("mActivityManager");
            declaredField5.setAccessible(true);
            Field declaredField6 = Class.forName("android.content.ContextWrapper").getDeclaredField("mBase");
            declaredField6.setAccessible(true);
            cls2.getDeclaredMethod("attach", Context.class, Class.forName("android.app.ActivityThread"), String.class, IBinder.class, Application.class, Object.class).invoke(this.k, declaredField6.get(this), declaredField.get(this), declaredField2.get(this), declaredField3.get(this), declaredField4.get(this), declaredField5.get(this));
        } catch (Exception e2) {
            a("attachSandboxedProcessService: attach service failed.", e2);
        }
        C7169c.a(this.c, "doInit 4/4 - doInitService, libFdInfos: %s", String.valueOf(parcelableArr));
        Object obj = this.k;
        if (obj != null && (method2 = this.h) != null) {
            try {
                this.j = (IBinder) method2.invoke(obj, this.l);
            } catch (Exception e3) {
                a("doInitService: invoke onBind failed.", e3);
            }
        }
        Object obj2 = this.k;
        if (obj2 != null && (method = this.i) != null) {
            try {
                method.invoke(obj2, parcelableArr);
            } catch (Exception e4) {
                a("doInitService: invoke initialize failed.", e4);
            }
        }
        C7169c.a(4, this.c, "doInit done.", null);
        this.d = true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C7169c.a(4, this.c, "onBind", null);
        this.l = intent;
        stopSelf();
        a();
        return this.m;
    }

    @Override // android.app.Service
    public void onCreate() {
        C7169c.a(4, this.c, "onCreate", null);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        C7169c.a(4, this.c, "onDestroy", null);
        super.onDestroy();
        if (this.j != null) {
            Method method = this.g;
            if (method != null) {
                try {
                    method.invoke(this.k, new Object[0]);
                } catch (Throwable th) {
                    C7169c.a(this.c, "onDestroy: onDestroy failed.", th);
                }
            }
            this.k = null;
            this.j = null;
        }
        System.exit(0);
    }

    private void a(String str, Throwable th) {
        a(true, true);
        C7169c.a(this.c, str, th);
        throw new Error(str, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ed, code lost:
        if (r12.c.contains("." + r4 + tb.jn1.ARRAY_END_STR) == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.sandboxExport.SandboxedProcessService.a():void");
    }

    private String a(ClassLoader classLoader, String str) {
        Class<?> cls;
        try {
            if (classLoader == null) {
                cls = Class.forName("org.chromium.base.utils.MiscUtil");
            } else {
                cls = Class.forName("org.chromium.base.utils.MiscUtil", false, classLoader);
            }
            Method method = cls.getMethod(str, new Class[0]);
            method.setAccessible(true);
            return (String) method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            C7169c.a(this.c, "getVersion exception", th);
            return "";
        }
    }

    private void a(boolean z, boolean z2) {
        String[] stringArrayExtra;
        String stringExtra = this.l.getStringExtra("dex.path");
        String stringExtra2 = this.l.getStringExtra("odex.path");
        String stringExtra3 = this.l.getStringExtra("lib.path");
        String stringExtra4 = this.l.getStringExtra("source.dir");
        String stringExtra5 = this.l.getStringExtra("source.dir.prior");
        C7169c.a(this.c, "core info:\n        dexPath: %s\n       odexPath: %s\n        libPath: %s\n      sourceDir: %s\n sourceDirPrior: %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
        if (z) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(stringExtra);
            arrayList.add(stringExtra2);
            arrayList.add(stringExtra4);
            arrayList.add(stringExtra5);
            arrayList.add(stringExtra3);
            if (!TextUtils.isEmpty(stringExtra3) && !stringExtra3.equals(getApplicationInfo().nativeLibraryDir) && (stringArrayExtra = this.l.getStringArrayExtra("info.core.libs")) != null) {
                for (String str : stringArrayExtra) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.endsWith(".so")) {
                            arrayList.add(new File(stringExtra3, str).getPath());
                        } else {
                            arrayList.add(new File(stringExtra3, SolidMonitor.CHECK_TYPE_LIB + str + ".so").getPath());
                        }
                    }
                }
            }
            a(arrayList, z2);
        }
    }

    private void a(ArrayList<String> arrayList, boolean z) {
        C7169c.a(4, this.c, "file info:", null);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                C7169c.a(this.c, " %s", next);
                try {
                    File file = new File(next);
                    if (!file.exists()) {
                        C7169c.a(4, this.c, " | not exists", null);
                    } else if (file.isDirectory()) {
                        C7169c.a(4, this.c, " | is directory", null);
                    } else if (!file.isFile()) {
                        C7169c.a(4, this.c, " | is not file", null);
                    } else {
                        C7169c.a(this.c, " | size: %d, last modify time: %s", Long.valueOf(file.length()), a(file.lastModified()));
                        if (z) {
                            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                messageDigest.update(bArr, 0, read);
                            }
                            byte[] digest = messageDigest.digest();
                            String str = this.c;
                            C7169c.a(4, str, " |  md5: " + a(digest), null);
                            fileInputStream.close();
                        }
                    }
                } catch (Throwable th) {
                    C7169c.a(this.c, " | get info exception", th);
                }
            }
        }
    }

    private static String a(long j) {
        try {
            return new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }
}
