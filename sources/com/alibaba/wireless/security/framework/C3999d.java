package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.framework.utils.C4012a;
import com.alibaba.wireless.security.framework.utils.C4013b;
import com.alibaba.wireless.security.framework.utils.C4017e;
import com.alibaba.wireless.security.framework.utils.FLOG;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.C4026c;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeAdapter;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tb.jn1;
import tb.lu2;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* renamed from: com.alibaba.wireless.security.framework.d */
/* loaded from: classes8.dex */
public class C3999d implements ISGPluginManager {
    private static Boolean u = null;
    private static String[] v = {"armeabi", "armeabi-v7a", DeviceUtils.ABI_X86, "arm64-v8a", "x86_64"};
    private static String w = null;
    private static volatile boolean x = true;
    private List<Runnable> b;
    private Context c;
    private HandlerThread a = null;
    private final ConcurrentHashMap<String, C3998c> d = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class, Object> e = new ConcurrentHashMap<>();
    private IRouterComponent f = null;
    C4013b g = null;
    private boolean h = true;
    private String i = null;
    private String j = null;
    private C3997b k = null;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private File r = null;
    private File s = null;
    private File t = null;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$a */
    /* loaded from: classes8.dex */
    class RunnableC4000a implements Runnable {
        final /* synthetic */ File a;

        RunnableC4000a(File file) {
            this.a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3999d.this.a(100179, 4, this.a.getAbsolutePath(), "", "", "", "");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$b */
    /* loaded from: classes8.dex */
    class RunnableC4001b implements Runnable {
        final /* synthetic */ File a;

        RunnableC4001b(File file) {
            this.a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3999d.this.a(100179, 2, this.a.getAbsolutePath(), "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$c */
    /* loaded from: classes8.dex */
    public class RunnableC4002c implements Runnable {
        final /* synthetic */ File a;
        final /* synthetic */ String b;

        RunnableC4002c(File file, String str) {
            this.a = file;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            File filesDir;
            File[] listFiles;
            File[] listFiles2;
            try {
                File file = this.a;
                if (file != null && file.isDirectory() && (listFiles2 = this.a.listFiles()) != null && listFiles2.length > 0) {
                    for (File file2 : listFiles2) {
                        if (file2.isDirectory() && file2.getName().startsWith("app_") && !file2.getName().equals(this.b)) {
                            C3999d.this.a(file2);
                        } else if (file2.getName().startsWith("libsg")) {
                            file2.delete();
                        }
                    }
                }
                if (C3999d.this.c == null || (filesDir = C3999d.this.c.getFilesDir()) == null || !filesDir.isDirectory() || (listFiles = filesDir.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                for (File file3 : listFiles) {
                    if (file3.getName().startsWith("libsecuritysdk")) {
                        file3.delete();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$d */
    /* loaded from: classes8.dex */
    public class RunnableC4003d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        RunnableC4003d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3999d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency notDelay", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$e */
    /* loaded from: classes8.dex */
    public class RunnableC4004e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        RunnableC4004e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3999d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$f */
    /* loaded from: classes8.dex */
    public class RunnableC4005f implements Runnable {
        RunnableC4005f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3999d.this.i();
            C3999d.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$g */
    /* loaded from: classes8.dex */
    public class RunnableC4006g implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        RunnableC4006g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3999d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency notDelay", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$h */
    /* loaded from: classes8.dex */
    public class RunnableC4007h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        RunnableC4007h(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3999d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$i */
    /* loaded from: classes8.dex */
    public class RunnableC4008i implements Runnable {
        RunnableC4008i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3999d.this.i();
            C3999d.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$j */
    /* loaded from: classes8.dex */
    public class RunnableC4009j implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        RunnableC4009j(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3999d.this.a(100048, 140, "Dynamic update rejected", "Arch=" + this.a, "DeployVersion=" + this.b, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$k */
    /* loaded from: classes8.dex */
    public class RunnableC4010k implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ File b;
        final /* synthetic */ File c;

        RunnableC4010k(String str, File file, File file2) {
            this.a = str;
            this.b = file;
            this.c = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3999d c3999d = C3999d.this;
            c3999d.a(100179, 4, "updInfo=" + this.a, this.b.getAbsolutePath(), this.c.getAbsolutePath(), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.wireless.security.framework.d$l */
    /* loaded from: classes8.dex */
    public static class C4011l {
        File a;
        File b;
        File c;
        boolean d;

        public C4011l(File file, File file2, File file3, boolean z) {
            this.a = file;
            this.b = file2;
            this.c = file3;
            this.d = z;
        }
    }

    private PackageInfo a(String str, C4011l c4011l, String str2) throws SecException {
        PackageInfo packageInfo;
        try {
            packageInfo = this.c.getPackageManager().getPackageArchiveInfo(c4011l.a.getAbsolutePath(), 133);
        } catch (Throwable th) {
            String str3 = "" + th;
            String d = d(c4011l.a.getAbsolutePath() + "");
            File file = c4011l.c;
            a(100043, 133, "getPackageArchiveInfo failed", str3, d, file != null ? d(file.getAbsolutePath()) : "", str2);
            if (c4011l.a.exists() && !e(c4011l.a)) {
                c4011l.a.delete();
            }
            packageInfo = null;
        }
        if (packageInfo == null) {
            String str4 = str + jn1.ARRAY_START_STR + str2 + jn1.ARRAY_END_STR;
            String d2 = d(c4011l.a.getAbsolutePath());
            File file2 = c4011l.c;
            a(100043, 134, "packageInfo == null", str4, d2, file2 != null ? d(file2.getAbsolutePath()) : "", j());
            throw new SecException(134);
        }
        return packageInfo;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:287:0x02c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0198 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b6 A[Catch: all -> 0x0182, TryCatch #14 {all -> 0x0182, blocks: (B:50:0x0170, B:52:0x017a, B:59:0x019a, B:61:0x01a4, B:65:0x01b3, B:67:0x01b6, B:70:0x01c4, B:72:0x01ca, B:90:0x0263, B:94:0x027d, B:96:0x0281, B:97:0x0293, B:99:0x02aa, B:100:0x02bf, B:98:0x0297, B:93:0x026a), top: B:289:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023d A[Catch: all -> 0x0786, TRY_ENTER, TryCatch #16 {all -> 0x0786, blocks: (B:48:0x016b, B:56:0x0186, B:76:0x01d4, B:80:0x01fb, B:86:0x0250, B:101:0x02c0, B:103:0x02c5, B:85:0x023d), top: B:291:0x016b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x025c  */
    /* JADX WARN: Type inference failed for: r13v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.C3998c a(java.lang.String r45, com.alibaba.wireless.security.framework.C3999d.C4011l r46, android.content.Context r47, java.lang.String r48) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 1947
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.a(java.lang.String, com.alibaba.wireless.security.framework.d$l, android.content.Context, java.lang.String):com.alibaba.wireless.security.framework.c");
    }

    private File a(Context context) throws SecException {
        File file;
        if (context == null) {
            a(100038, 116, "", "", "", "", "");
            throw new SecException(116);
        }
        String str = null;
        try {
            String str2 = context.getApplicationInfo().sourceDir;
            if (str2 != null) {
                if (new File(str2).exists()) {
                    str = (file.lastModified() / 1000) + "";
                }
            }
            if (str != null) {
                File dir = context.getDir("SGLib", 0);
                this.s = dir;
                if (dir == null || !dir.exists()) {
                    a(100038, 109, "", "" + this.s, "", "", "");
                    throw new SecException(109);
                }
                File file2 = new File(this.s.getAbsolutePath(), "app_" + str);
                if (!file2.exists()) {
                    file2.mkdirs();
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                }
                if (x && file2.exists()) {
                    x = false;
                    a(this.s, "app_" + str);
                }
                if (file2.exists()) {
                    return file2;
                }
                a(100038, 114, "", "", "", "", "");
                throw new SecException(114);
            }
            throw new SecException(115);
        } catch (Throwable th) {
            a(100038, 115, "", "" + th, "", "", "");
            throw new SecException(th, 115);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (a(r6, r7.b()) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(android.content.Context r6, com.alibaba.wireless.security.framework.C3997b r7) {
        /*
            r5 = this;
            boolean r6 = com.alibaba.wireless.security.framework.utils.C4017e.c(r6)
            r0 = 0
            if (r6 != 0) goto Lbd
            if (r7 == 0) goto Lbd
            int r6 = r7.b()
            if (r6 == 0) goto Lbd
            java.lang.String r6 = r7.c()
            if (r6 == 0) goto Lbd
            java.lang.String r6 = r7.c()
            int r6 = r6.length()
            if (r6 <= 0) goto Lbd
            boolean r6 = r5.h()
            java.lang.String r1 = "libs"
            if (r6 == 0) goto L6c
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r5.s
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            java.lang.String r4 = "upds"
            r2.append(r4)
            r2.append(r3)
            r2.append(r1)
            r2.append(r3)
            int r4 = r7.b()
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = r7.c()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.<init>(r2)
            int r2 = r7.b()
            boolean r2 = r5.a(r6, r2)
            if (r2 != 0) goto L6d
        L6c:
            r6 = r0
        L6d:
            if (r6 == 0) goto L75
            boolean r2 = r6.isDirectory()
            if (r2 != 0) goto Lb3
        L75:
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r5.r
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r1)
            r2.append(r3)
            int r1 = r7.b()
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r7.c()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r6.<init>(r1)
            int r7 = r7.b()
            boolean r7 = r5.a(r6, r7)
            if (r7 != 0) goto Lb3
            r6 = r0
        Lb3:
            if (r6 == 0) goto Lbc
            boolean r7 = r6.exists()
            if (r7 != 0) goto Lbc
            goto Lbd
        Lbc:
            r0 = r6
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.a(android.content.Context, com.alibaba.wireless.security.framework.b):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(java.lang.String r13, java.io.File r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = r12.c     // Catch: java.lang.Throwable -> La
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()     // Catch: java.lang.Throwable -> La
            java.lang.String r1 = r1.sourceDir     // Catch: java.lang.Throwable -> La
            goto Lb
        La:
            r1 = r0
        Lb:
            if (r1 != 0) goto Le
            return r0
        Le:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "libsg"
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = ".so"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
            com.alibaba.wireless.security.framework.utils.FLOG.i(r3)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L6a
            java.lang.String[] r4 = com.alibaba.wireless.security.framework.C3999d.v     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            int r5 = r4.length     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r6 = 0
        L32:
            if (r6 >= r5) goto L62
            r7 = r4[r6]     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.<init>()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.String r9 = "lib"
            r8.append(r9)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.String r9 = java.io.File.separator     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r9)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r7)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r9)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            r8.append(r2)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.lang.String r8 = r8.toString()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.util.zip.ZipEntry r9 = r3.getEntry(r8)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            if (r9 == 0) goto L5f
            com.alibaba.wireless.security.framework.C3999d.w = r7     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            java.io.File r0 = r12.a(r13, r14, r3, r8)     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L8c
            goto L62
        L5f:
            int r6 = r6 + 1
            goto L32
        L62:
            r3.close()     // Catch: java.lang.Throwable -> L65
        L65:
            return r0
        L66:
            r14 = move-exception
            goto L6c
        L68:
            r13 = move-exception
            goto L8e
        L6a:
            r14 = move-exception
            r3 = r0
        L6c:
            java.lang.String r2 = "getPluginFile throws exception"
            com.alibaba.wireless.security.framework.utils.FLOG.w(r2, r14)     // Catch: java.lang.Throwable -> L8c
            r5 = 100047(0x186cf, float:1.40196E-40)
            r6 = 3
            java.lang.String r7 = r14.toString()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r9 = r12.d(r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            r4 = r12
            r8 = r13
            r4.a(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L8c
            if (r3 == 0) goto L8b
            r3.close()     // Catch: java.lang.Throwable -> L8b
        L8b:
            return r0
        L8c:
            r13 = move-exception
            r0 = r3
        L8e:
            if (r0 == 0) goto L93
            r0.close()     // Catch: java.lang.Throwable -> L93
        L93:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.a(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r1 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(java.lang.String r11, java.io.File r12, java.lang.String r13, java.lang.String r14) {
        /*
            r10 = this;
            r0 = 0
            if (r13 == 0) goto L44
            if (r14 != 0) goto L6
            goto L44
        L6:
            java.lang.String r1 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed"
            com.alibaba.wireless.security.framework.utils.FLOG.i(r1)     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            r1.<init>(r13)     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            java.io.File r0 = r10.a(r11, r12, r1, r14)     // Catch: java.io.IOException -> L18 java.lang.Throwable -> L3c
        L14:
            r1.close()     // Catch: java.lang.Throwable -> L3b
            goto L3b
        L18:
            r12 = move-exception
            goto L1e
        L1a:
            r11 = move-exception
            goto L3e
        L1c:
            r12 = move-exception
            r1 = r0
        L1e:
            java.lang.String r14 = "getPluginFile throws exception"
            com.alibaba.wireless.security.framework.utils.FLOG.w(r14, r12)     // Catch: java.lang.Throwable -> L3c
            r3 = 100047(0x186cf, float:1.40196E-40)
            r4 = 3
            java.lang.String r5 = r12.toString()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = r10.d(r13)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            r2 = r10
            r6 = r11
            r2.a(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L3b
            goto L14
        L3b:
            return r0
        L3c:
            r11 = move-exception
            r0 = r1
        L3e:
            if (r0 == 0) goto L43
            r0.close()     // Catch: java.lang.Throwable -> L43
        L43:
            throw r11
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.a(java.lang.String, java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    private File a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        ZipEntry entry;
        if (zipFile != null && str2 != null && (entry = zipFile.getEntry(str2)) != null && C4012a.a(entry.getName())) {
            File file2 = new File(file, "libsg" + str + "_inner" + entry.getTime() + ".zip");
            if ((file2.exists() && file2.length() == entry.getSize()) || C4017e.a(zipFile, entry, file2)) {
                FLOG.i("Extract success");
                return file2;
            }
            FLOG.i("Extract failed!!");
        }
        return null;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            a(100042, 132, "Class.forName failed", "" + th, str, classLoader.toString(), "");
            cls = null;
        }
        FLOG.i("    loadClassFromClassLoader( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return cls;
    }

    private ClassLoader a(String str, String str2, boolean z) {
        if (!z) {
            try {
                this.g.a();
            } finally {
                if (!z) {
                    this.g.b();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.c.getApplicationInfo().nativeLibraryDir);
        String str3 = File.pathSeparator;
        sb.append(str3);
        sb.append(str2);
        String sb2 = sb.toString();
        if (this.i != null) {
            sb2 = sb2 + str3 + this.i;
            FLOG.i("add path to native classloader " + sb2);
        }
        if (w != null) {
            sb2 = sb2 + str3 + this.c.getApplicationInfo().sourceDir + "!/lib/" + w;
        }
        return (Build.VERSION.SDK_INT < 21 || "6.0.1".equalsIgnoreCase(Build.VERSION.getRELEASE())) ? new DexClassLoader(str, str2, sb2, C3999d.class.getClassLoader()) : new PathClassLoader(str, sb2, C3999d.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2, String str3, String str4, String str5) {
        UserTrackMethodJniBridge.addUtRecord("" + i, i2, 0, C4026c.a(), 0L, str, str2, str3, str4, str5);
    }

    private void a(C4011l c4011l, String str, String str2) {
        if (c(c4011l.c)) {
            int b = this.k.b();
            String str3 = "PluginName=" + str;
            String str4 = "PluginVersion=" + str2;
            String str5 = "LibDeployVersion=" + b;
            a(100048, 135, "Write dyInit.config", str3, str4, str5, "write success=" + C4012a.a(new File(this.r, "dyInit.config"), Integer.toString(b)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                a(new File(file, str));
            }
        }
        file.delete();
    }

    private void a(File file, String str) {
        new Thread(new RunnableC4002c(file, str), "SGCleanFile").start();
    }

    private boolean a(File file, int i) {
        return new File(file, ".finish").isFile();
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r20, java.io.File r21) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.a(java.io.File, java.io.File):boolean");
    }

    private boolean a(String str, String str2) throws SecException {
        for (Map.Entry<String, C3998c> entry : this.d.entrySet()) {
            String key = entry.getKey();
            C3998c value = entry.getValue();
            String a = value.a("reversedependencies");
            if (a != null) {
                String[] split = a.split(";");
                for (int i = 0; i < split.length; i++) {
                    String trim = split[i].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(":");
                        if (split2.length != 2) {
                            a(100041, 131, "nameVersionPair.length != 2", str + jn1.BRACKET_START_STR + str2 + jn1.BRACKET_END_STR, key + jn1.BRACKET_START_STR + value.getVersion() + jn1.BRACKET_END_STR, d(value.getPluginPath()), a);
                            throw new SecException(131);
                        } else if (split2[0].equalsIgnoreCase(str) && b(str2, split2[1]) < 0) {
                            String str3 = "plugin " + str + jn1.BRACKET_START_STR + str2 + ") is not meet the reverse dependency of " + key + jn1.BRACKET_START_STR + value.getVersion() + "): " + split2[0] + jn1.BRACKET_START_STR + split2[1] + jn1.BRACKET_END_STR;
                            a(100041, 117, str3, C3999d.class.getClassLoader().toString(), d(value.getPluginPath()), a, "" + i);
                            throw new SecException(str3, 117);
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0133, code lost:
        if (r21 == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0171, code lost:
        if (r21 != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0173, code lost:
        r16.g.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0179, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(java.lang.String r17, java.lang.String r18, java.io.File r19, java.lang.String r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.a(java.lang.String, java.lang.String, java.io.File, java.lang.String, boolean):boolean");
    }

    private int b(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:19:0x0056, B:25:0x0067, B:27:0x006d, B:29:0x0073, B:31:0x0081, B:33:0x00ab, B:34:0x00b2, B:36:0x00b7, B:39:0x00bf, B:46:0x00cf, B:48:0x00d9, B:49:0x00e1, B:51:0x00e7, B:52:0x00ee, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:59:0x0129, B:61:0x0132, B:62:0x0138, B:64:0x0161, B:68:0x0173, B:66:0x016d), top: B:77:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:19:0x0056, B:25:0x0067, B:27:0x006d, B:29:0x0073, B:31:0x0081, B:33:0x00ab, B:34:0x00b2, B:36:0x00b7, B:39:0x00bf, B:46:0x00cf, B:48:0x00d9, B:49:0x00e1, B:51:0x00e7, B:52:0x00ee, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:59:0x0129, B:61:0x0132, B:62:0x0138, B:64:0x0161, B:68:0x0173, B:66:0x016d), top: B:77:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:19:0x0056, B:25:0x0067, B:27:0x006d, B:29:0x0073, B:31:0x0081, B:33:0x00ab, B:34:0x00b2, B:36:0x00b7, B:39:0x00bf, B:46:0x00cf, B:48:0x00d9, B:49:0x00e1, B:51:0x00e7, B:52:0x00ee, B:54:0x0117, B:56:0x011d, B:58:0x0123, B:59:0x0129, B:61:0x0132, B:62:0x0138, B:64:0x0161, B:68:0x0173, B:66:0x016d), top: B:77:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b5 A[EDGE_INSN: B:79:0x00b5->B:35:0x00b5 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.C3999d.C4011l b(java.lang.String r17, java.lang.String r18, boolean r19) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.b(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.d$l");
    }

    private File b(File file) {
        if (file.exists() && file.isDirectory() && this.l) {
            File file2 = new File(file, lu2.MAIN);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return file2.exists() ? file2 : file;
        }
        return file;
    }

    private File b(String str) {
        if (this.i != null) {
            return null;
        }
        String a = C4017e.a(C3999d.class.getClassLoader(), "sg" + str);
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new File(a);
    }

    private boolean b(File file, File file2) {
        Method method;
        try {
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 21) {
                method = Class.forName("android.system.Os").getDeclaredMethod("symlink", String.class, String.class);
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                method = obj.getClass().getMethod("symlink", String.class, String.class);
            }
            method.invoke(obj, file.getAbsolutePath(), file2.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            FLOG.w("create symbolic link( " + file2.getAbsolutePath() + " -> " + file.getAbsolutePath() + " ) failed", th);
            String th2 = th.toString();
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            a(100047, 1, th2, absolutePath, absolutePath2, "" + Build.VERSION.SDK_INT, "");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01d4, code lost:
        r11 = "plugin " + r9 + " not existed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ee, code lost:
        if (r10.length() == 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f0, code lost:
        r11 = r11 + ", depended by " + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0204, code lost:
        a(100044, 110, "", r9, r10, "", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x021c, code lost:
        throw new com.alibaba.wireless.security.open.SecException(r11, 110);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized com.alibaba.wireless.security.framework.ISGPluginInfo c(java.lang.String r9, java.lang.String r10, boolean r11) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.c(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.ISGPluginInfo");
    }

    private File c(String str) {
        String str2 = this.i;
        if (str2 == null) {
            try {
                str2 = this.c.getApplicationInfo().nativeLibraryDir;
            } catch (Throwable unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            File file = new File(str2 + File.separator + "libsg" + str + ".so");
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private String c(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        if (interfacePluginInfo == null) {
            return null;
        }
        return interfacePluginInfo.pluginName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0056 -> B:22:0x0073). Please submit an issue!!! */
    public void c() {
        try {
            int i = OrangeListener.a;
            Method method = OrangeListener.class.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                String str = (String) method.invoke(OrangeListener.class, OrangeAdapter.SECURITYGUARD_ORANGE_NAMESPACE, "130", "0");
                try {
                    File file = new File(a(this.c), ".giw");
                    boolean exists = file.exists();
                    if (str == null) {
                        if (exists) {
                            file.delete();
                        }
                    } else if (!TextUtils.equals(C4012a.a(file), str)) {
                        C4012a.a(file, str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            FLOG.e("checkGetInterfaceLockSwitch : " + th.getMessage());
        }
    }

    private boolean c(File file) {
        String str;
        if (file == null || file.getParentFile() == null || this.t == null) {
            return false;
        }
        String str2 = null;
        try {
            str = file.getParentFile().getCanonicalPath();
            try {
                str2 = this.t.getCanonicalPath();
            } catch (IOException e) {
                e = e;
                FLOG.w("", e);
                return str == null ? false : false;
            }
        } catch (IOException e2) {
            e = e2;
            str = null;
        }
        if (str == null && TextUtils.equals(str, str2)) {
            return true;
        }
    }

    private boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Throwable th) {
            FLOG.w("", th);
            a(100046, 0, th.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d2, code lost:
        r15 = "plugin " + r13 + " not existed";
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ec, code lost:
        if (r14.length() == 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ee, code lost:
        r15 = r15 + ", depended by " + r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0202, code lost:
        a(100044, 110, "", r13, r14, "", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x021a, code lost:
        throw new com.alibaba.wireless.security.open.SecException(r15, 110);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.wireless.security.framework.ISGPluginInfo d(java.lang.String r13, java.lang.String r14, boolean r15) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.C3999d.d(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.ISGPluginInfo");
    }

    private String d(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (e(file)) {
            sb.append("->");
            try {
                sb.append(file.getCanonicalPath());
            } catch (Throwable unused) {
            }
        }
        sb.append(jn1.ARRAY_START);
        sb.append("exists:" + file.exists() + ",");
        sb.append("size:" + file.length() + ",");
        sb.append("canRead:" + file.canRead() + ",");
        sb.append("canWrite:" + file.canWrite() + ",");
        sb.append("totalSpace:" + file.getTotalSpace() + ",");
        sb.append("freeSpace:" + file.getFreeSpace() + ",");
        sb.append(jn1.ARRAY_END);
        return sb.toString();
    }

    private boolean d() {
        C3997b a;
        File file = new File(b(), "upds");
        File file2 = new File(file, "update.config");
        File file3 = new File(a(), "update.config");
        if (!file2.isFile() || (a = C3997b.a(file2)) == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String str = File.separator;
        sb.append(str);
        sb.append("libs");
        sb.append(str);
        sb.append(a.b());
        File file4 = new File(sb.toString(), "FBD");
        HashMap<String, String> d = a.d();
        HashMap<String, String> f = f();
        if (!file4.exists() && d != null && d.equals(f)) {
            try {
                this.g.a();
                file3.delete();
                String a2 = C4012a.a(file2);
                if (a2 != null && C4012a.a(file3, a2)) {
                    this.g.b();
                    return true;
                }
                this.b.add(new RunnableC4010k(a2, file3, file2));
            } finally {
                this.g.b();
            }
        }
        return false;
    }

    private boolean d(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null && absolutePath.length() > 0) {
                    if (!C4017e.c(this.c)) {
                        if (absolutePath.startsWith("/system/")) {
                        }
                    }
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private C3997b e() {
        C3997b a;
        C3997b c3997b;
        String a2;
        File file = new File(this.r, "update.config");
        File file2 = new File(this.r, "init.config");
        if (this.l) {
            if (!file2.isFile() && h()) {
                d();
            }
            a = C3997b.a(file);
            if (a == null) {
                c3997b = C3997b.a(file2);
                if (c3997b == null && (a2 = C4012a.a(new File(this.r, "dyInit.config"))) != null && a2.equals(Integer.toString(c3997b.b()))) {
                    this.b.add(new RunnableC4009j(c3997b.c(), c3997b.b()));
                    return null;
                }
                return c3997b;
            }
            try {
                this.g.a();
                file2.delete();
                file.renameTo(file2);
            } finally {
            }
        } else {
            try {
                this.g.a();
                a = C3997b.a(file2);
            } finally {
            }
        }
        this.g.b();
        c3997b = a;
        return c3997b == null ? c3997b : c3997b;
    }

    private boolean e(File file) {
        try {
            File canonicalFile = file.getCanonicalFile();
            if (canonicalFile != null) {
                File parentFile = file.getParentFile();
                File parentFile2 = canonicalFile.getParentFile();
                if (parentFile == null || parentFile2 == null || parentFile.getCanonicalPath().equals(parentFile2.getCanonicalPath())) {
                    if (!file.getName().equals(canonicalFile.getName())) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            FLOG.w("", th);
            a(100047, 0, th.toString(), file.getAbsolutePath(), "", "", "");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, String str2, boolean z) throws SecException {
        if (str != null && str.trim().length() != 0) {
            String[] split = str.split(";");
            char c = 0;
            for (int i = 0; i < split.length; i++) {
                String trim = split[i].trim();
                if (trim.length() != 0) {
                    String[] split2 = trim.split(":");
                    if (split2.length != 2) {
                        a(100040, 128, "nameVersionPair.length != 2", trim, str2, "" + z, "" + i);
                        throw new SecException(128);
                    }
                    int indexOf = str2.indexOf(split2[c]);
                    if (indexOf >= 0) {
                        int indexOf2 = str2.indexOf(jn1.BRACKET_START_STR, indexOf);
                        int indexOf3 = str2.indexOf(jn1.BRACKET_END_STR, indexOf);
                        if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                            a(100040, SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", "" + indexOf2, "" + indexOf3, "", "" + i);
                            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
                        }
                        String substring = str2.substring(indexOf2 + 1, indexOf3);
                        if (b(substring, split2[1]) < 0) {
                            String str3 = "version " + substring + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str3 = str3 + ", depended by: " + str2;
                            }
                            String str4 = str3;
                            if (!z) {
                                a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, split2[0], split2[1], "" + i);
                            }
                            throw new SecException(str4, 113);
                        }
                    } else {
                        C3998c c3998c = this.d.get(split2[0]);
                        if (c3998c == null) {
                            try {
                                c3998c = this.q ? d(split2[0], str2, !z) : c(split2[0], str2, !z);
                                th = null;
                            } catch (Throwable th) {
                                th = th;
                            }
                            if (c3998c == null) {
                                if (!z) {
                                    if (th instanceof SecException) {
                                        throw th;
                                    }
                                    a(100040, 130, "throwable in loadPluginInner", "" + th, str, str2, "" + i);
                                    throw new SecException(str2, 130);
                                }
                            }
                        }
                        if (b(c3998c.getVersion(), split2[1]) < 0) {
                            String str5 = "version " + c3998c.getVersion() + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                            if (str2.length() != 0) {
                                str5 = str5 + ", depended by: " + str2;
                            }
                            if (!z) {
                                a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", c3998c.getVersion(), split2[0], split2[1], "" + i);
                            }
                            throw new SecException(str5, 113);
                        }
                    }
                    c = 0;
                }
            }
        }
        return true;
    }

    private HashMap<String, String> f() {
        String str;
        if (this.c.getApplicationInfo() == null || (str = this.c.getApplicationInfo().nativeLibraryDir) == null) {
            return null;
        }
        String[] strArr = {"libsgmain", "libsgsecuritybody", "libsgmiddletier"};
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            File file = new File(str, str2 + "so.version.so");
            if (file.isFile()) {
                hashMap.put(str2, C4012a.a(file));
            }
        }
        return hashMap;
    }

    private void g() throws SecException {
        File a = a(this.c);
        this.r = a;
        if (a != null) {
            Context context = this.c;
            this.g = new C4013b(context, this.r + File.separator + "lock.lock");
            C3997b e = e();
            this.k = e;
            this.t = a(this.c, e);
        }
    }

    private boolean h() {
        if (u == null) {
            u = Boolean.valueOf(new File(b(), ".sgdynkp").isFile());
        }
        return u.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        List<Runnable> list = this.b;
        if (list != null) {
            try {
                for (Runnable runnable : list) {
                    runnable.run();
                }
            } catch (Exception unused) {
            }
            this.b.clear();
        }
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        File file = this.r;
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                sb.append(jn1.ARRAY_START_STR);
                File[] listFiles = file.listFiles();
                for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                    File file2 = listFiles[i];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        sb.append(file2.getName());
                        sb.append(jn1.BRACKET_START_STR);
                        sb.append(e(file2) + " , ");
                        sb.append(file2.length());
                        sb.append(") , ");
                    }
                }
                sb.append(jn1.ARRAY_END_STR);
            } catch (Throwable unused) {
            }
        } else {
            sb.append("not exists!");
        }
        return sb.toString();
    }

    public File a() {
        return this.r;
    }

    public <T> T a(Class<T> cls) throws SecException {
        String str;
        Object obj = this.e.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        C3997b c3997b = this.k;
        if (c3997b != null) {
            str = c3997b.e();
            if (str == null || str.length() == 0) {
                str = this.k.a(cls.getName());
            }
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            str = c((Class<?>) cls);
        }
        if (str == null || str.length() == 0) {
            throw new SecException(150);
        }
        ISGPluginInfo pluginInfo = getPluginInfo(str);
        if (pluginInfo == null) {
            if (this.m && getMainPluginName().equals(str)) {
                throw new SecException(110);
            }
            return null;
        }
        Object obj2 = pluginInfo.getSGPluginEntry().getInterface(cls);
        if (obj2 != null) {
            this.e.put(cls, obj2);
            return cls.cast(obj2);
        }
        a(100045, 112, "", cls.getName(), str + jn1.BRACKET_START_STR + pluginInfo.getVersion() + jn1.BRACKET_END_STR, d(pluginInfo.getPluginPath()), "");
        throw new SecException(112);
    }

    public void a(Context context, String str, String str2, boolean z, Object... objArr) {
        String str3 = "0";
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.c = context;
        this.j = str;
        this.l = C4017e.b(context);
        this.h = z;
        this.b = new ArrayList();
        UserTrackMethodJniBridge.init(this.c);
        if (str2 != null && !str2.isEmpty()) {
            this.i = str2;
        }
        boolean z2 = false;
        try {
            g();
            this.q = new Random().nextDouble() < Double.parseDouble(C4012a.a(new File(a(this.c), ".giw")));
        } catch (SecException | Exception unused) {
        }
        try {
            int i = OrangeListener.a;
            Method method = OrangeListener.class.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                str3 = (String) method.invoke(OrangeListener.class, OrangeAdapter.SECURITYGUARD_ORANGE_NAMESPACE, "113", "0");
            }
        } catch (Throwable th) {
            FLOG.e("getKeepAliveOrangeSwitch : " + th.getMessage());
        }
        this.o |= "1".equals(str3);
        try {
            Class<?> cls = Class.forName("com.taobao.adaemon.ADaemon");
            Method method2 = cls.getMethod("isChannelMemOptimizeEnable", Context.class);
            if (method2 != null) {
                z2 = ((Boolean) method2.invoke(cls, this.c)).booleanValue();
            }
        } catch (Throwable th2) {
            FLOG.e("ADaemon.isChannelMemOptimizeEnable: " + th2.getMessage());
        }
        boolean z3 = this.o | z2;
        this.o = z3;
        this.p = z3;
    }

    public void a(String str) {
        if (h()) {
            File b = b();
            File file = new File(b, "upds/libs/" + str);
            if (!file.isDirectory()) {
                this.b.add(new RunnableC4001b(file));
                return;
            }
            File file2 = new File(file, "FBD");
            if (C4012a.a(file2, "1")) {
                return;
            }
            this.b.add(new RunnableC4000a(file2));
        }
    }

    public void a(boolean z) {
        boolean z2;
        if (z) {
            z2 = true;
            this.o = true;
        } else {
            this.o = this.p;
            z2 = this.n;
        }
        this.m = z2;
    }

    public File b() {
        return this.s;
    }

    public synchronized <T> T b(Class<T> cls) throws SecException {
        return (T) a(cls);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public <T> T getInterface(Class<T> cls) throws SecException {
        return this.q ? (T) a(cls) : (T) b(cls);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public String getMainPluginName() {
        return lu2.MAIN;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public ISGPluginInfo getPluginInfo(String str) throws SecException {
        FLOG.i("MockTaobaoChannel - getPluginInfo: " + str);
        return this.q ? d(str, "", true) : c(str, "", true);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public IRouterComponent getRouter() {
        return this.f;
    }
}
