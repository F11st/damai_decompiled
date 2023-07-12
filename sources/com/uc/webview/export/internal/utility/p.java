package com.uc.webview.export.internal.utility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.bt;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.playerservice.axp.utils.Utils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import tb.gn1;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p {
    public static final String[] a = {"armeabi-v7a", "arm64-v8a", "armeabi", DeviceUtils.ABI_X86};
    public static String b;
    private static a c;
    private static a d;
    private static final Map<String, String> e;
    private static volatile Method f;
    private static final String[] g;
    private static boolean h;
    private static boolean i;
    private static String j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum a {
        NOT_INITED,
        ENABLE,
        DISABLE
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b {
        private static String a;

        public static String a(Context context) {
            if (!p.a(a)) {
                return a;
            }
            if (SDKFactory.c != null && context != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str = (String) ReflectionUtil.invoke((Class<?>) UTDevice.class, "getUtdid", new Class[]{Context.class}, new Object[]{context});
                    Log.d(Utils.TAG, "getUtdidBySdk time: " + (System.currentTimeMillis() - currentTimeMillis) + " milliseconds");
                    StringBuilder sb = new StringBuilder("getUtdidBySdk utdid: ");
                    sb.append(str);
                    Log.d(Utils.TAG, sb.toString());
                    if (!p.a(str)) {
                        a = str;
                    }
                    return str;
                } catch (Throwable th) {
                    Log.d(Utils.TAG, "getUtdidBySdk cd exception : " + th.getMessage());
                }
            }
            return null;
        }
    }

    static {
        a aVar = a.NOT_INITED;
        c = aVar;
        d = aVar;
        e = new q();
        f = null;
        b = "3032";
        g = new String[]{"3032"};
        h = false;
        i = false;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(String str) {
        return !a(str) && "true".equalsIgnoreCase(str);
    }

    public static int c() {
        Integer num = (Integer) i.a().a(UCCore.OPTION_CONNECTION_CONNECT_TIMEOUT);
        if (num != null) {
            return num.intValue();
        }
        return 5000;
    }

    public static int d() {
        Integer num = (Integer) i.a().a(UCCore.OPTION_CONNECTION_READ_TIMEOUT);
        if (num != null) {
            return num.intValue();
        }
        return 5000;
    }

    public static String e() {
        for (Map.Entry<String, String> entry : e.entrySet()) {
            String i2 = i(entry.getKey());
            if (i2 != null && i2.length() > 0) {
                return entry.getValue();
            }
        }
        return "UNKNOWN";
    }

    public static boolean f() {
        a aVar = c;
        a aVar2 = a.NOT_INITED;
        if (aVar == aVar2) {
            synchronized (c) {
                if (c == aVar2) {
                    try {
                        Class.forName("com.uc.webkit.sdk.CoreFactoryImpl");
                        c = a.ENABLE;
                    } catch (ClassNotFoundException unused) {
                        c = a.DISABLE;
                    }
                }
            }
        }
        return c == a.ENABLE;
    }

    public static String g() {
        return "/unexists/" + System.currentTimeMillis();
    }

    private static String h(String str) {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    String sb2 = sb.toString();
                    UCCyclone.close(fileReader);
                    UCCyclone.close(bufferedReader);
                    return sb2;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                th.printStackTrace();
                return "";
            } finally {
                if (fileReader != null) {
                    UCCyclone.close(fileReader);
                }
                if (bufferedReader != null) {
                    UCCyclone.close(bufferedReader);
                }
            }
        }
    }

    private static String i(String str) {
        try {
            if (f == null) {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
                f = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f.invoke(null, str);
            if (invoke == null) {
                return null;
            }
            return invoke.toString();
        } catch (Throwable th) {
            Log.i(Utils.TAG, "getSystemProperty " + th.getMessage());
            return null;
        }
    }

    private static File j(String str) throws UCSetupException {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        throw new UCSetupException(1002, String.format("Directory [%s] not exists.", file.getAbsolutePath()));
    }

    public static boolean a(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static boolean b(Boolean bool) {
        return bool == null || !bool.booleanValue();
    }

    public static File g(String str) throws UCSetupException {
        File[] listFiles;
        int i2 = Build.PACK_TYPE;
        if ((i2 == 34 || i2 == 43) && (listFiles = j(str).listFiles(new s())) != null && listFiles.length > 0) {
            return listFiles[0];
        }
        return null;
    }

    public static String a() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new r());
            Log.d(Utils.TAG, "CPU Count: " + listFiles.length);
            return String.valueOf(listFiles.length);
        } catch (Throwable th) {
            Log.d(Utils.TAG, "CPU Count: Failed.");
            th.printStackTrace();
            return "1";
        }
    }

    public static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return 1 == ((Integer) obj).intValue();
        } else if (obj instanceof String) {
            String lowerCase = ((String) obj).trim().toLowerCase(Locale.getDefault());
            return "1".equals(lowerCase) || BQCCameraParam.VALUE_YES.equals(lowerCase) || "true".equals(lowerCase);
        } else {
            return false;
        }
    }

    public static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long d(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean c(Context context, String str, String str2) {
        File a2 = a(context, "decompresses2");
        if (str.startsWith(a2.getAbsolutePath())) {
            File file = new File(str2);
            return !str.startsWith(new File(new File(a2, UCCyclone.getSourceHash(file.getAbsolutePath())), UCCyclone.getSourceHash(file.length(), file.lastModified())).getAbsolutePath());
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
        r14 = r8.getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.uc.webview.export.internal.setup.bt d(android.content.Context r13, java.lang.String r14, java.lang.String r15) throws com.uc.webview.export.internal.setup.UCSetupException {
        /*
        L0:
            java.io.File r14 = j(r14)
            java.lang.String r0 = "libcore_jar_kj_uc.so"
            java.io.File r0 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r14, r0)     // Catch: com.uc.webview.export.cyclone.UCKnownException -> L40
            java.lang.String r9 = r0.getAbsolutePath()     // Catch: com.uc.webview.export.cyclone.UCKnownException -> L40
            r0 = 0
            java.lang.String r1 = "libsdk_shell_jar_kj_uc.so"
            java.io.File r1 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r14, r1)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L1b
            r7 = r1
            goto L1c
        L1b:
            r7 = r0
        L1c:
            java.lang.String r1 = "libbrowser_if_jar_kj_uc.so"
            java.io.File r1 = com.uc.webview.export.cyclone.UCCyclone.expectFile(r14, r1)     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L26
        L26:
            r8 = r0
            com.uc.webview.export.internal.utility.UCMPackageInfo r0 = new com.uc.webview.export.internal.utility.UCMPackageInfo
            java.lang.String r4 = r14.getAbsolutePath()
            java.lang.String r5 = r14.getAbsolutePath()
            java.lang.String r6 = r14.getAbsolutePath()
            r11 = 1
            r12 = 0
            java.lang.String r3 = "specified"
            r1 = r0
            r2 = r13
            r10 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L40:
            r0 = move-exception
            java.io.File[] r14 = r14.listFiles()
            if (r14 == 0) goto L71
            java.lang.String[] r1 = com.uc.webview.export.internal.utility.p.a
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L4c:
            if (r4 >= r2) goto L71
            r5 = r1[r4]
            int r6 = r14.length
            r7 = 0
        L52:
            if (r7 >= r6) goto L6e
            r8 = r14[r7]
            java.lang.String r9 = r8.getName()
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L6b
            boolean r9 = r8.isDirectory()
            if (r9 == 0) goto L6b
            java.lang.String r14 = r8.getAbsolutePath()
            goto L0
        L6b:
            int r7 = r7 + 1
            goto L52
        L6e:
            int r4 = r4 + 1
            goto L4c
        L71:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.p.d(android.content.Context, java.lang.String, java.lang.String):com.uc.webview.export.internal.setup.bt");
    }

    public static String e(String str) {
        return String.valueOf(str.hashCode()).replace('-', '_');
    }

    public static void a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel channel;
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
        } catch (Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(file2).getChannel();
            if (fileChannel2.transferFrom(channel, 0L, channel.size()) == file.length()) {
                try {
                    channel.close();
                } catch (Throwable unused) {
                }
                try {
                    fileChannel2.close();
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            file2.delete();
            throw new RuntimeException("Size mismatch.");
        } catch (Throwable th2) {
            th = th2;
            fileChannel = fileChannel2;
            fileChannel2 = channel;
            if (fileChannel2 != null) {
                try {
                    fileChannel2.close();
                } catch (Throwable unused3) {
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    public static String f(String str) {
        if (a(str)) {
            return str;
        }
        File file = new File(str);
        return file.exists() ? file.getAbsolutePath() : str;
    }

    public static boolean b(File file, File file2) {
        try {
            if (file.getCanonicalPath().startsWith(file2.getCanonicalPath())) {
                while (file.getCanonicalPath().contains(file2.getCanonicalPath()) && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    if (!g.b(file)) {
                        return false;
                    }
                    file = file.getParentFile();
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c(Context context) {
        String str = j;
        if (str != null) {
            return str;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            j = (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Exception unused) {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    j = next.processName;
                    break;
                }
            }
        }
        return TextUtils.isEmpty(j) ? "" : j;
    }

    public static synchronized List<bt> b(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        synchronized (p.class) {
            List<bt> arrayList = new ArrayList<>();
            com.uc.webview.export.internal.uc.startup.b.a(285);
            String str = (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH);
            Log.i(Utils.TAG, " listFromOptions dexPath:" + str);
            if (!a(str)) {
                arrayList = a(context, new File(str), arrayList);
            }
            String str2 = (String) concurrentHashMap.get(UCCore.OPTION_SET_ODEX_ROOT_PATH);
            if (str2 == null) {
                str2 = a(context, "odexs").getAbsolutePath();
            }
            if (arrayList.size() == 0) {
                bt a2 = a(context, (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH), str2);
                if (a2 != null) {
                    arrayList.add(a2);
                }
                if (f()) {
                    com.uc.webview.export.internal.uc.startup.b.a(286);
                    return arrayList;
                }
            }
            String str3 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR);
            if (!a(str3)) {
                arrayList = a(context, new File(str3), arrayList);
            }
            String str4 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR);
            if (!a(str4)) {
                arrayList.add(d(context, str4, str2));
            }
            if (arrayList != null && arrayList.size() > 1) {
                Collections.sort(arrayList, new u());
            }
            com.uc.webview.export.internal.uc.startup.b.a(286);
            return arrayList;
        }
    }

    public static boolean h() {
        Object globalOption = UCCore.getGlobalOption(UCCore.GLOBAL_OPTION_IS_BROWSER_RUNTIME);
        if (globalOption != null) {
            return ((Boolean) globalOption).booleanValue();
        }
        a aVar = d;
        a aVar2 = a.NOT_INITED;
        if (aVar == aVar2) {
            synchronized (d) {
                if (d == aVar2) {
                    try {
                        Class.forName("com.uc.webview.browser.BrowserCore");
                        d = a.ENABLE;
                    } catch (ClassNotFoundException unused) {
                        d = a.DISABLE;
                    }
                }
            }
        }
        return d == a.ENABLE;
    }

    public static boolean d(Context context) {
        return !c(context).contains(":");
    }

    public static File a(File file, File file2, File file3) {
        if (file2.exists()) {
            return file2;
        }
        if (file3.exists() && file.length() == file3.length() && file.lastModified() == file3.lastModified()) {
            return file3;
        }
        String parent = file3.getParent();
        File file4 = new File(parent, "bak_" + file3.getName());
        if (file4.exists()) {
            if (file.length() == file4.length()) {
                file4.setLastModified(file.lastModified());
                if (file4.lastModified() != file.lastModified()) {
                    return file4;
                }
            }
            file4.delete();
        }
        try {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Os.symlink(file.getAbsolutePath(), file2.getAbsolutePath());
                        return file2;
                    } catch (Exception unused) {
                    }
                }
                Process exec = Runtime.getRuntime().exec("ln -s " + file.getAbsolutePath() + " " + file2.getAbsolutePath());
                UCElapseTime uCElapseTime = new UCElapseTime();
                while (uCElapseTime.getMilis() < 500) {
                    try {
                        if (exec.exitValue() != 0) {
                            throw new Throwable();
                            break;
                        }
                        break;
                    } catch (IllegalThreadStateException unused2) {
                    }
                }
                if (file.getName().equals("libar_pak_kr_uc.so")) {
                    android.util.Log.i("ThinEnvTask", "linkOrCopyFile Time:" + uCElapseTime.getMilis());
                }
                return file2;
            } catch (Throwable th) {
                throw new UCSetupException(1007, th);
            }
        } catch (Throwable unused3) {
            file3.delete();
            File file5 = new File(file3.getAbsolutePath() + ".tmp");
            file5.createNewFile();
            a(file, file5);
            if (file5.renameTo(file3)) {
                file3.setLastModified(file.lastModified());
                if (file3.lastModified() != file.lastModified()) {
                    file3.renameTo(file4);
                    return file4;
                }
                return file3;
            }
            file5.delete();
            throw new UCSetupException(1005, String.format("Rename [%s] to [%s] failed.", file5, file3));
        }
    }

    public static int c(Context context, String str) {
        File a2 = a(context, Constants.KEY_FLAGS);
        String a3 = w.a(str);
        Log.d(Utils.TAG, "checkQuickVerifiedResult filePath:" + str + ", prefix:" + a3);
        if (new File(a2, a3 + "_n").exists()) {
            return 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a3);
        sb.append("_y");
        return new File(a2, sb.toString()).exists() ? 1 : 0;
    }

    public static String b(Context context, String str) {
        return (context == null || a(str) || str.indexOf(context.getPackageName()) <= 0) ? str : str.substring(str.indexOf(context.getPackageName()), str.length());
    }

    public static File b(File file, String str) throws UCSetupException {
        return UCCyclone.expectCreateDirFile(new File(file, str));
    }

    public static void b(Context context) {
        File[] listFiles = context.getCacheDir().listFiles(new v());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            UCCyclone.recursiveDelete(file, false, null);
        }
    }

    private static File[] a(File[] fileArr, File[] fileArr2, File[] fileArr3) {
        boolean z;
        File[] fileArr4 = new File[fileArr.length];
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                for (int i2 = 0; i2 < fileArr.length; i2++) {
                    if (fileArr2[i2].exists()) {
                        fileArr4[i2] = fileArr2[i2];
                    } else {
                        Os.symlink(fileArr[i2].getAbsolutePath(), fileArr2[i2].getAbsolutePath());
                        fileArr4[i2] = fileArr2[i2];
                    }
                }
                return fileArr4;
            }
            UCElapseTime uCElapseTime = new UCElapseTime();
            Process process = null;
            try {
                process = Runtime.getRuntime().exec("sh");
                DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
                new BufferedReader(new InputStreamReader(process.getInputStream()));
                for (int i3 = 0; i3 < fileArr.length; i3++) {
                    if (fileArr2[i3].exists()) {
                        fileArr4[i3] = fileArr2[i3];
                    } else {
                        dataOutputStream.writeBytes(String.format("ln -s %s %s", fileArr[i3].getAbsolutePath(), fileArr2[i3].getAbsolutePath()));
                        dataOutputStream.writeBytes(StringUtils.LF);
                        dataOutputStream.flush();
                        fileArr4[i3] = fileArr2[i3];
                    }
                }
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                process.waitFor();
                dataOutputStream.close();
                process.destroy();
                z = true;
            } catch (Exception e2) {
                Log.e(Utils.TAG, "symlink exception.", e2);
                if (process != null) {
                    process.destroy();
                }
                z = false;
            }
            if (z) {
                Log.e(Utils.TAG, "link success! Time:" + uCElapseTime.getMilis());
                return fileArr4;
            }
            throw new Throwable();
        } catch (Throwable unused) {
            for (int i4 = 0; i4 < fileArr.length; i4++) {
                try {
                    File file = fileArr3[i4];
                    File file2 = fileArr[i4];
                    file.delete();
                    File file3 = new File(file.getAbsolutePath() + ".tmp");
                    file3.createNewFile();
                    a(file2, file3);
                    if (file3.renameTo(file)) {
                        file.setLastModified(file2.lastModified());
                        fileArr4[i4] = file;
                    } else {
                        file3.delete();
                        throw new UCSetupException(1005, String.format("Rename [%s] to [%s] failed.", file3, file));
                    }
                } catch (Throwable th) {
                    throw new UCSetupException(1007, th);
                }
            }
            return fileArr4;
        }
    }

    public static String b(Context context, String str, String str2) {
        if (a(str2)) {
            return null;
        }
        File file = new File(str2);
        String name = file.getName();
        if (name.startsWith(SolidMonitor.CHECK_TYPE_LIB) && name.endsWith("_jar_kj_uc.so")) {
            String str3 = name.substring(3, name.length() - 13) + ".jar";
            String e2 = e(str);
            return a(file, new File(b(a(context, "kjlinks"), e2), str3), new File(b(a(context, "kjcopies"), e2), str3)).getAbsolutePath();
        }
        return str2;
    }

    private static String b(File file) {
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public static String b() {
        return String.valueOf(c(h("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").trim()));
    }

    public static Boolean a(ConcurrentHashMap<String, Object> concurrentHashMap, String str) {
        Object obj = concurrentHashMap.get(str);
        if (obj != null) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
            throw new UCSetupException(3012, String.format("\"true\" or \"false\" or boolean expected with key:[%s], now is [%s]", str, obj));
        }
        return null;
    }

    public static void a(Map<String, String> map) {
        try {
            Log.d(Utils.TAG, "addHeaderInfoToCrashSdk headerInfos: " + map);
            Object invoke = ReflectionUtil.invoke("com.uc.crashsdk.export.CrashApi", "getInstance");
            if (invoke == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ReflectionUtil.invoke(invoke, "addHeaderInfo", new Class[]{String.class, String.class}, new Object[]{entry.getKey(), entry.getValue()});
            }
        } catch (Throwable th) {
            Log.i(Utils.TAG, "addHeaderInfoToCrashSdk " + th.getMessage());
        }
    }

    public static int a(boolean z) {
        if (f()) {
            return 1;
        }
        return z ? 4 : 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            File file = new File(a(context, Constants.KEY_FLAGS), "fpathhash");
            String sourceHash = UCCyclone.getSourceHash(file.getAbsolutePath());
            if (file.exists() && file.length() > 0) {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream3 = fileInputStream;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    th.printStackTrace();
                }
                try {
                    byte[] bArr = new byte[32];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(byteArrayOutputStream.toByteArray());
                    Log.d(Utils.TAG, "curHash:" + sourceHash + ", preHash:" + str);
                    if (!sourceHash.equals(str)) {
                        IWaStat.WaStat.stat(IWaStat.KEY_MULTI_PROCESS_FILE_PATH_COMPATIBILITY);
                    }
                    byteArrayOutputStream2 = null;
                    byteArrayOutputStream3 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = null;
                    byteArrayOutputStream3 = fileInputStream;
                    th.printStackTrace();
                }
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(sourceHash.getBytes());
                    byteArrayOutputStream = null;
                    byteArrayOutputStream2 = fileOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    byteArrayOutputStream2 = fileOutputStream;
                    try {
                        th.printStackTrace();
                    } finally {
                        UCCyclone.close(byteArrayOutputStream3);
                        UCCyclone.close(byteArrayOutputStream2);
                        UCCyclone.close(byteArrayOutputStream);
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = byteArrayOutputStream3;
        }
    }

    public static boolean a(UCMRunningInfo uCMRunningInfo) {
        if (uCMRunningInfo != null) {
            return uCMRunningInfo.coreType == 2 && i.a().b(UCCore.OPTION_MULTI_CORE_TYPE);
        }
        return true;
    }

    public static String a(File file, String str) {
        return a(file, str, true);
    }

    public static String a(File file, String str, boolean z) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        String a2 = a(file2, str, true);
                        if (!a(a2)) {
                            return a2;
                        }
                    } else {
                        continue;
                    }
                }
                if (file2.getName().contains(str)) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return null;
    }

    public static synchronized List<bt> a(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        List<bt> arrayList;
        bt a2;
        synchronized (p.class) {
            arrayList = new ArrayList<>();
            com.uc.webview.export.internal.uc.startup.b.a(283);
            if (!a((String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH)) && (a2 = a(context, null, (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH), null)) != null) {
                arrayList.add(a2);
            }
            String str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR);
            if (!a(str)) {
                arrayList = a(context, new File(str), arrayList);
            }
            com.uc.webview.export.internal.uc.startup.b.a(284);
        }
        return arrayList;
    }

    public static File a(Context context, String str) throws UCSetupException {
        File dir = context.getDir("ucmsdk", 0);
        return str == null ? dir : UCCyclone.expectCreateDirFile(new File(dir, str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r2 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r5, java.io.File r6, java.io.File r7) throws com.uc.webview.export.internal.setup.UCSetupException {
        /*
            boolean r0 = r6.isFile()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto La
            goto L41
        La:
            boolean r0 = r6.isDirectory()
            if (r0 == 0) goto L40
            java.lang.String r0 = "flags"
            java.io.File r5 = a(r5, r0)
            java.io.File r0 = new java.io.File
            java.lang.String r4 = "setup_delete"
            r0.<init>(r5, r4)
            java.io.File r5 = com.uc.webview.export.cyclone.UCCyclone.expectCreateDirFile(r0)
            java.lang.String r0 = r6.getAbsolutePath()
            java.lang.String r0 = com.uc.webview.export.cyclone.UCCyclone.getSourceHash(r0)
            java.io.File r4 = new java.io.File
            r4.<init>(r5, r0)
            java.io.File r5 = com.uc.webview.export.cyclone.UCCyclone.expectCreateDirFile(r4)
            java.lang.String[] r0 = r5.list()
            int r0 = r0.length
            r4 = 12
            if (r0 < r4) goto L3c
            goto L3d
        L3c:
            r2 = r5
        L3d:
            if (r2 == 0) goto L40
            goto L41
        L40:
            r1 = 0
        L41:
            if (r1 == 0) goto L73
            com.uc.webview.export.cyclone.UCCyclone.recursiveDelete(r6, r3, r7)
            boolean r5 = r6.exists()
            if (r5 != 0) goto L73
            if (r2 == 0) goto L73
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L6a
            r6.<init>(r2, r5)     // Catch: java.lang.Throwable -> L6a
            boolean r5 = r6.createNewFile()     // Catch: java.lang.Throwable -> L6a
            if (r5 == 0) goto L62
            return
        L62:
            java.lang.Exception r5 = new java.lang.Exception     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = "createNewFile return false"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L6a
            throw r5     // Catch: java.lang.Throwable -> L6a
        L6a:
            r5 = move-exception
            com.uc.webview.export.cyclone.UCKnownException r6 = new com.uc.webview.export.cyclone.UCKnownException
            r7 = 1006(0x3ee, float:1.41E-42)
            r6.<init>(r7, r5)
            throw r6
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.p.a(android.content.Context, java.io.File, java.io.File):void");
    }

    public static boolean a(ConcurrentHashMap<String, Object> concurrentHashMap) {
        Boolean bool;
        a aVar;
        if (c == a.NOT_INITED && concurrentHashMap != null && (bool = (Boolean) concurrentHashMap.get(UCCore.OPTION_THICK_INTEGRATION)) != null) {
            boolean a2 = a(bool);
            synchronized (c) {
                aVar = a2 ? a.ENABLE : a.DISABLE;
                c = aVar;
            }
            return aVar == a.ENABLE;
        }
        return f();
    }

    public static String a(Context context, String str, String str2) {
        File j2;
        String[] list;
        if (a(str2) || (list = (j2 = j(str2)).list(new t())) == null || list.length == 0) {
            return null;
        }
        String e2 = e(str);
        File b2 = b(a(context, "krlinks"), e2);
        File b3 = b(a(context, "krcopies"), e2);
        File b4 = b(b2, bt.RES_PAKS_DIR_NAME);
        File b5 = b(b3, bt.RES_PAKS_DIR_NAME);
        File[] fileArr = new File[list.length];
        File[] fileArr2 = new File[list.length];
        File[] fileArr3 = new File[list.length];
        UCElapseTime uCElapseTime = new UCElapseTime();
        int i2 = 0;
        while (i2 < list.length) {
            String str3 = list[i2];
            boolean endsWith = str3.endsWith("_pak_kr_uc.so");
            String substring = str3.substring(3, str3.length() - 9);
            int lastIndexOf = substring.lastIndexOf(95);
            File file = b5;
            StringBuilder sb = new StringBuilder();
            File file2 = b4;
            sb.append(substring.substring(0, lastIndexOf));
            sb.append('.');
            sb.append(substring.substring(lastIndexOf + 1));
            String sb2 = sb.toString();
            File file3 = new File(j2, str3);
            File file4 = new File(endsWith ? file2 : b2, sb2);
            File file5 = new File(endsWith ? file : b3, sb2);
            fileArr[i2] = file3;
            fileArr2[i2] = file4;
            fileArr3[i2] = file5;
            i2++;
            b5 = file;
            b4 = file2;
        }
        File[] a2 = a(fileArr, fileArr2, fileArr3);
        android.util.Log.i(Utils.TAG, "getLnkOrCpyResDirFromSO: file count:" + list.length + " time:" + uCElapseTime.getMilis());
        if (!(a2[0] == fileArr2[0])) {
            return b3.getAbsolutePath();
        }
        return b2.getAbsolutePath();
    }

    private static bt a(Context context, String str, String str2, String str3, String str4) throws UCSetupException {
        String str5;
        String str6;
        String str7;
        String str8;
        boolean a2 = a(str);
        boolean a3 = a(str2);
        boolean a4 = a(str3);
        String str9 = null;
        if (a2 && !f()) {
            if (a3 && a4) {
                return null;
            }
            throw new UCSetupException(3002, "No ucm dex file specified.");
        }
        if (a2) {
            str5 = null;
            str6 = null;
            str7 = null;
        } else {
            File j2 = j(str);
            String absolutePath = UCCyclone.expectFile(j2, "core.jar").getAbsolutePath();
            try {
                str8 = UCCyclone.expectFile(j2, "sdk_shell.jar").getAbsolutePath();
            } catch (Throwable unused) {
                str8 = null;
            }
            try {
                str9 = UCCyclone.expectFile(j2, "browser_if.jar").getAbsolutePath();
            } catch (Throwable unused2) {
            }
            str7 = absolutePath;
            str5 = str8;
            str6 = str9;
        }
        return new UCMPackageInfo(context, SocialConstants.PARAM_SPECIFIED, str2, str3, str, str5, str6, str7, str4, false, false);
    }

    private static List<bt> a(Context context, File file, List<bt> list) throws UCSetupException {
        boolean z;
        List<bt> arrayList = list != null ? list : new ArrayList<>();
        Log.i(Utils.TAG, " listUninstalls ucmDirFile :" + file.getAbsolutePath());
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file, "sdk_shell.jar");
            File file3 = new File(file, "browser_if.jar");
            File file4 = new File(file, "core.jar");
            File file5 = new File(file, SolidMonitor.CHECK_TYPE_LIB);
            i.a().b(UCCore.OPTION_USE_SDK_SETUP);
            if (f()) {
                z = file5.isDirectory();
            } else {
                z = file4.exists() && (!i.a().b(UCCore.OPTION_USE_SDK_SETUP) || file2.exists()) && file5.isDirectory();
            }
            if (z) {
                String[] strArr = a;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file6 = new File(file5, strArr[i2]);
                    if (file6.isDirectory()) {
                        file5 = file6;
                        break;
                    }
                    i2++;
                }
                File file7 = new File(file, "assets");
                Log.i(Utils.TAG, " listUninstalls resDirFile :" + file7.getAbsolutePath());
                if (z) {
                    arrayList.add(new UCMPackageInfo(context, SocialConstants.PARAM_SPECIFIED, b(file5), b(file7), b(file), b(file2), b(file3), b(file4), null, false, false));
                }
            }
            Log.i(Utils.TAG, " listUninstalls retUCMpis size :" + arrayList.size());
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file8 : listFiles) {
                    if (file8.isDirectory()) {
                        a(context, file8, arrayList);
                    }
                }
            }
        }
        return arrayList;
    }

    public static final String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            int min = Math.min(8, stackTrace.length);
            int i2 = 0;
            while (i2 < min) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                String className = i2 < 2 ? stackTraceElement.getClassName() : "";
                int lineNumber = stackTraceElement.getLineNumber();
                sb.append(" ");
                sb.append(className);
                sb.append(":");
                sb.append(lineNumber);
                i2++;
            }
        }
        return sb.toString();
    }

    public static File a(File file) {
        for (String str : a) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                return file2;
            }
        }
        return file;
    }
}
