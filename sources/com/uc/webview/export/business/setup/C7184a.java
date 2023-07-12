package com.uc.webview.export.business.setup;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.Build;
import com.uc.webview.export.business.BusinessWrapper;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.setup.C7277h;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.bt;
import com.uc.webview.export.internal.utility.C7333g;
import com.uc.webview.export.internal.utility.C7334h;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.SetupTask;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.a */
/* loaded from: classes11.dex */
public class C7184a extends SetupTask {
    private static final String a = C7184a.class.getSimpleName();
    private C7185a h;
    private C7179a c = new C7179a();
    private C7179a d = new C7179a();
    private C7179a e = new C7179a();
    private C7179a f = new C7179a();
    private C7179a g = new C7179a();
    private ValueCallback<BaseSetupTask> i = new C7193i(this);
    private ValueCallback<BaseSetupTask> j = new C7194j(this);
    private ValueCallback<BaseSetupTask> k = new C7195k(this);
    private ValueCallback<BaseSetupTask> l = new C7196l(this);
    private ValueCallback<BaseSetupTask> m = new C7197m(this);
    private Map<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> n = new C7198n(this);
    private Map<String, String> o = new C7199o(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b() {
    }

    private void g() {
        a(new C7187c(this));
    }

    private void i() {
        a(new C7190f(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x011b A[Catch: UCSetupException -> 0x023c, all -> 0x033a, TRY_LEAVE, TryCatch #0 {UCSetupException -> 0x023c, blocks: (B:5:0x0021, B:8:0x0038, B:29:0x00cd, B:31:0x00d3, B:33:0x00ef, B:42:0x011b, B:45:0x0172, B:50:0x0192, B:53:0x01e4, B:48:0x018b, B:36:0x0106, B:39:0x0113, B:56:0x0236, B:57:0x023b, B:9:0x0042, B:11:0x0050, B:12:0x005a, B:14:0x0068, B:15:0x0072, B:17:0x0080, B:18:0x008a, B:20:0x0098, B:22:0x00a4, B:23:0x00ae, B:25:0x00bc, B:27:0x00c2), top: B:93:0x0021, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0172 A[Catch: UCSetupException -> 0x023c, all -> 0x033a, TRY_ENTER, TryCatch #0 {UCSetupException -> 0x023c, blocks: (B:5:0x0021, B:8:0x0038, B:29:0x00cd, B:31:0x00d3, B:33:0x00ef, B:42:0x011b, B:45:0x0172, B:50:0x0192, B:53:0x01e4, B:48:0x018b, B:36:0x0106, B:39:0x0113, B:56:0x0236, B:57:0x023b, B:9:0x0042, B:11:0x0050, B:12:0x005a, B:14:0x0068, B:15:0x0072, B:17:0x0080, B:18:0x008a, B:20:0x0098, B:22:0x00a4, B:23:0x00ae, B:25:0x00bc, B:27:0x00c2), top: B:93:0x0021, outer: #1 }] */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.business.setup.C7184a.run():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.business.setup.a$a */
    /* loaded from: classes11.dex */
    public class C7185a {
        UCElapseTime a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;

        private C7185a() {
            this.a = new UCElapseTime();
        }

        /* synthetic */ C7185a(C7184a c7184a, byte b) {
            this();
        }
    }

    private SetupTask e() {
        if (C7349p.a((Boolean) getOption(UCCore.OPTION_UCMOBILE_INIT))) {
            try {
                return (SetupTask) UCCyclone.invoke(null, Class.forName("com.uc.webview.browser.BrowserCore"), UCCore.LEGACY_EVENT_SETUP, new Class[]{String.class, Object.class}, new Object[]{"CONTEXT", this.mOptions.get("CONTEXT")});
            } catch (Exception e) {
                throw new UCSetupException(e);
            }
        }
        return UCCore.setup("CONTEXT", this.mOptions.get("CONTEXT"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        File file = new File(UCCore.getExtractDirPath((String) this.mOptions.get(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH), (String) this.mOptions.get(UCCore.OPTION_NEW_UCM_ZIP_FILE)));
        if (!file.exists()) {
            file = new File(UCCore.getExtractDirPath(C7349p.a(getContext(), "decompresses2").getAbsolutePath(), (String) this.mOptions.get(UCCore.OPTION_NEW_UCM_ZIP_FILE)));
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(C7184a c7184a) {
        c7184a.d.a(c7184a.c.a);
        C7186b c7186b = new C7186b(c7184a);
        for (Map.Entry<String, String> entry : c7186b.entrySet()) {
            IWaStat.WaStat.stat(entry.getKey(), entry.getValue());
        }
        String str = a;
        Log.d(str, "processStatMaps: " + c7186b);
    }

    private void h() {
        a(new C7189e(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(C7184a c7184a) {
        long j;
        Object option = c7184a.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_TASK_WAIT_MILIS);
        if (option != null) {
            if (option instanceof Long) {
                j = ((Long) option).longValue();
            } else if (option instanceof Integer) {
                j = ((Integer) option).longValue();
            }
            ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) BusinessWrapper.decompressAndODex("CONTEXT", c7184a.getContext()).setup("o_flag_odex_done", (Object) Boolean.TRUE)).setup(UCCore.OPTION_UCM_ZIP_FILE, c7184a.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE))).setup(UCCore.OPTION_ZIP_FILE_TYPE, c7184a.getOption(UCCore.OPTION_NEW_UCM_ZIP_TYPE))).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, c7184a.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))).setup(UCCore.OPTION_DELETE_AFTER_EXTRACT, (Object) Boolean.FALSE)).setup(UCCore.OPTION_PROVIDED_KEYS, c7184a.getOption(UCCore.OPTION_PROVIDED_KEYS))).setup(UCCore.OPTION_DECOMPRESS_CALLBACK, c7184a.getOption(UCCore.OPTION_DECOMPRESS_CALLBACK))).setup(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK, c7184a.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK))).setup(UCCore.OPTION_VERIFY_POLICY, c7184a.getOption(UCCore.OPTION_VERIFY_POLICY))).start(Long.valueOf(j).longValue());
        }
        j = 3000;
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) BusinessWrapper.decompressAndODex("CONTEXT", c7184a.getContext()).setup("o_flag_odex_done", (Object) Boolean.TRUE)).setup(UCCore.OPTION_UCM_ZIP_FILE, c7184a.getOption(UCCore.OPTION_NEW_UCM_ZIP_FILE))).setup(UCCore.OPTION_ZIP_FILE_TYPE, c7184a.getOption(UCCore.OPTION_NEW_UCM_ZIP_TYPE))).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, c7184a.getOption(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))).setup(UCCore.OPTION_DELETE_AFTER_EXTRACT, (Object) Boolean.FALSE)).setup(UCCore.OPTION_PROVIDED_KEYS, c7184a.getOption(UCCore.OPTION_PROVIDED_KEYS))).setup(UCCore.OPTION_DECOMPRESS_CALLBACK, c7184a.getOption(UCCore.OPTION_DECOMPRESS_CALLBACK))).setup(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK, c7184a.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK))).setup(UCCore.OPTION_VERIFY_POLICY, c7184a.getOption(UCCore.OPTION_VERIFY_POLICY))).start(Long.valueOf(j).longValue());
    }

    private void j() {
        a(new C7191g(this));
    }

    private void a(BaseSetupTask baseSetupTask) {
        for (Map.Entry<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> entry : this.n.entrySet()) {
            String key = entry.getKey();
            Iterator<Map.Entry<String, String>> it = this.o.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next.getKey().equals(key)) {
                        key = next.getValue();
                        break;
                    }
                }
            }
            baseSetupTask.onEvent(key, (ValueCallback) entry.getValue().second);
        }
    }

    private DexClassLoader b(String str) {
        Context context = (Context) getOption("CONTEXT");
        File file = new File(str);
        try {
            String absolutePath = new File(file, "sdk_shell.jar").getAbsolutePath();
            Integer num = (Integer) this.mOptions.get(UCCore.OPTION_VERIFY_POLICY);
            if (num != null && (num.intValue() & 1) != 0) {
                C7277h.a(context, num, absolutePath);
            }
            return new DexClassLoader(absolutePath, UCCore.getODexDirPath(context, file.getAbsolutePath()), "", C7184a.class.getClassLoader());
        } catch (Throwable unused) {
            Log.d(a, "create sdk_shell dexLoader failure!");
            return null;
        }
    }

    private void c() {
        for (Map.Entry<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> entry : this.n.entrySet()) {
            Object callback = getCallback(entry.getKey());
            if (callback != null) {
                entry.setValue(new Pair<>(callback, entry.getValue().second));
            }
        }
    }

    private long d(String str) {
        String str2 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                String str3 = "check new core files, " + str + " not exists!";
                long j = C7179a.C7180a.e;
                if (!C7349p.a(str3)) {
                    Log.d(a, str3);
                }
                return j;
            }
            DexClassLoader b = b(str);
            if (b == null) {
                long j2 = C7179a.C7180a.f;
                if (!C7349p.a("check new core files, create sdk_shell dexLoader failure!")) {
                    Log.d(a, "check new core files, create sdk_shell dexLoader failure!");
                }
                return j2;
            }
            long a2 = a(file, b);
            if (0 != a2) {
                if (!C7349p.a("check new core files, file exists and permission failure!")) {
                    Log.d(a, "check new core files, file exists and permission failure!");
                }
                return a2;
            }
            return 0L;
        } catch (Throwable th) {
            try {
                str2 = "check new core files exception!" + th.getMessage();
                long j3 = C7179a.C7180a.j;
                if (!C7349p.a(str2)) {
                    Log.d(a, str2);
                }
                return j3;
            } finally {
                if (!C7349p.a(str2)) {
                    Log.d(a, str2);
                }
            }
        }
    }

    private long c(String str) {
        String str2 = a;
        Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions " + str);
        String str3 = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                String str4 = "check new core files, " + str + " not exists!";
                long j = C7179a.C7180a.e;
                if (!C7349p.a(str4)) {
                    Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions " + str4);
                }
                return j;
            }
            DexClassLoader b = b(str);
            if (b == null) {
                long j2 = C7179a.C7180a.f;
                if (!C7349p.a("check old core files, create sdk_shell dexLoader failure!")) {
                    Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions check old core files, create sdk_shell dexLoader failure!");
                }
                return j2;
            }
            String b2 = C7334h.b(b);
            if (C7349p.a(b2)) {
                long j3 = C7179a.C7180a.g;
                if (!C7349p.a("check old core files, get core version failure!")) {
                    Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions check old core files, get core version failure!");
                }
                return j3;
            }
            UCCore.Callable callable = (UCCore.Callable) getOption(UCCore.OPTION_PROMISE_SPECIAL_VERSION_CORE_INIT);
            if (callable != null && ((Boolean) callable.call(b2)).booleanValue()) {
                if (!a(Build.Version.NAME, Build.Version.SUPPORT_U4_MIN, b2, C7334h.c(b))) {
                    long j4 = C7179a.C7180a.i;
                    if (!C7349p.a("check old core files, version compatible failure!")) {
                        Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions check old core files, version compatible failure!");
                    }
                    return j4;
                }
                if (C7349p.b((Boolean) getOption(UCCore.OPTION_SKIP_PRECONDITIONS_IO_CHECK))) {
                    long a2 = a(file, b);
                    if (0 != a2) {
                        if (!C7349p.a("check old core files, file exists and permission failure!")) {
                            Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions check old core files, file exists and permission failure!");
                        }
                        return a2;
                    }
                }
                if (!C7349p.a((String) null)) {
                    Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions " + ((String) null));
                }
                return 0L;
            }
            long j5 = C7179a.C7180a.h;
            if (!C7349p.a("check callable permission failure!")) {
                Log.d(str2, ".checkCoreCompatibleAndFileExistsPermissions check callable permission failure!");
            }
            return j5;
        } catch (Throwable th) {
            try {
                str3 = "check old core files exception!" + th.getMessage();
                return C7179a.C7180a.j;
            } finally {
                if (!C7349p.a(str3)) {
                    Log.d(a, ".checkCoreCompatibleAndFileExistsPermissions " + str3);
                }
            }
        }
    }

    private static final int[] a(String str) {
        if (str != null) {
            String[] split = str.split("\\.");
            if (split.length > 3) {
                return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])};
            }
            return null;
        }
        return null;
    }

    private static final boolean a(String str, String str2, String str3, String str4) {
        try {
            String str5 = a;
            Log.d(str5, "sdk版本:" + str);
            Log.d(str5, "sdk支持的最小内核版本:" + str2);
            Log.d(str5, "内核版本:" + str3);
            Log.d(str5, "内核支持的最小sdk版本:" + str4);
            int[] a2 = a(str3);
            int[] a3 = a(str2);
            if (a2 != null && a3 != null) {
                if (a2[0] >= a3[0] && (a2[0] != a3[0] || (a2[1] >= a3[1] && (a2[1] != a3[1] || (a2[2] >= a3[2] && (a2[2] != a3[2] || a2[3] >= a3[3])))))) {
                    int[] a4 = a(str);
                    int[] a5 = a(str4);
                    if (a4 != null && a5 != null) {
                        if (a4[0] >= a5[0] && (a4[0] != a5[0] || (a4[1] >= a5[1] && (a4[1] != a5[1] || (a4[2] >= a5[2] && (a4[2] != a5[2] || a4[3] >= a5[3])))))) {
                            return true;
                        }
                        Log.d(str5, "最小SDK版本不通过");
                    }
                    return false;
                }
                Log.d(str5, "最小内核版本不通过");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static long a(File file, String[] strArr) {
        int i;
        int i2;
        String str = null;
        try {
            if (strArr.length <= 0) {
                long j = C7179a.C7180a.k;
                if (!C7349p.a("so file array is empty.")) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because so file array is empty.");
                }
                return j;
            } else if (!C7349p.b(file, file)) {
                long j2 = C7179a.C7180a.l;
                if (!C7349p.a("root dir modifyFilePermissionsDirFromTo failure.")) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because root dir modifyFilePermissionsDirFromTo failure.");
                }
                return j2;
            } else {
                String[] strArr2 = {"core.jar", "sdk_shell.jar"};
                while (i < 2) {
                    File file2 = new File(file, strArr2[i]);
                    i = (file2.exists() && C7333g.a(file2)) ? i + 1 : 0;
                    String str2 = file2.getName() + " not exists or setReadable failure.";
                    long j3 = C7179a.C7180a.m;
                    if (!C7349p.a(str2)) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str2);
                    }
                    return j3;
                }
                File file3 = new File(file, "assets");
                if (!C7349p.b(file3, file)) {
                    long j4 = C7179a.C7180a.n;
                    if (!C7349p.a("resource dir modifyFilePermissionsDirFromTo failure.")) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because resource dir modifyFilePermissionsDirFromTo failure.");
                    }
                    return j4;
                }
                File[] listFiles = C7349p.b(file3, bt.RES_PAKS_DIR_NAME).listFiles();
                int length = listFiles.length;
                while (i2 < length) {
                    File file4 = listFiles[i2];
                    i2 = (file4.exists() && C7333g.a(file4)) ? i2 + 1 : 0;
                    String str3 = file4.getName() + " not exists or setReadable failure.";
                    long j5 = C7179a.C7180a.o;
                    if (!C7349p.a(str3)) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str3);
                    }
                    return j5;
                }
                File parentFile = new File(C7349p.a(file, strArr[0])).getParentFile();
                if (!C7349p.b(parentFile, file)) {
                    long j6 = C7179a.C7180a.p;
                    if (!C7349p.a("so dir modifyFilePermissionsDirFromTo failure.")) {
                        Log.d(a, ".checkFilesExistsAndPermissions failure, because so dir modifyFilePermissionsDirFromTo failure.");
                    }
                    return j6;
                }
                if (parentFile.exists() && C7333g.a(parentFile)) {
                    for (String str4 : strArr) {
                        File file5 = new File(parentFile, str4);
                        if (!file5.exists()) {
                            String str5 = file5.getName() + " not exists.";
                            long j7 = C7179a.C7180a.r;
                            if (!C7349p.a(str5)) {
                                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str5);
                            }
                            return j7;
                        } else if (!C7333g.b(file5)) {
                            String str6 = file5.getName() + " setExecutable failure.";
                            long j8 = C7179a.C7180a.s;
                            if (!C7349p.a(str6)) {
                                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str6);
                            }
                            return j8;
                        } else if (!C7333g.a(file5)) {
                            String str7 = file5.getName() + " setReadable failure.";
                            long j9 = C7179a.C7180a.t;
                            if (!C7349p.a(str7)) {
                                Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str7);
                            }
                            return j9;
                        }
                    }
                }
                String str8 = parentFile.getName() + " not exists or setReadable failure.";
                long j10 = C7179a.C7180a.q;
                if (!C7349p.a(str8)) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str8);
                }
                return j10;
            }
        } catch (Throwable th) {
            try {
                str = "exception " + th.getMessage();
                long j11 = C7179a.C7180a.u;
                if (!C7349p.a(str)) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str);
                }
                return j11;
            } finally {
                if (!C7349p.a(str)) {
                    Log.d(a, ".checkFilesExistsAndPermissions failure, because " + str);
                }
            }
        }
    }

    private static long a(File file, DexClassLoader dexClassLoader) {
        return a(file, C7334h.f(dexClassLoader));
    }

    private void a(Map<String, Object> map) {
        String key;
        String obj;
        try {
            ValueCallback valueCallback = (ValueCallback) getOption(UCCore.OPTION_START_INIT_UC_CORE);
            if (valueCallback != null) {
                Bundle bundle = new Bundle();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() instanceof String) {
                        key = entry.getKey();
                        obj = (String) entry.getValue();
                    } else {
                        key = entry.getKey();
                        obj = entry.getValue() == null ? "null" : entry.getValue().toString();
                    }
                    bundle.putString(key, obj);
                }
                valueCallback.onReceiveValue(bundle);
            }
        } catch (Throwable th) {
            Log.d(a, "init core callback", th);
        }
        String str = a;
        Log.d(str, "initCore options: " + map);
        c();
        SetupTask e = e();
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) e.setOptions(this.mOptions)).setParent(this)).setCallbacks(this.mCallbacks)).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, this.mOptions.get(UCCore.OPTION_BUSINESS_DECOMPRESS_ROOT_PATH))).setAsDefault();
        a((BaseSetupTask) e);
        for (Map.Entry<String, Object> entry2 : map.entrySet()) {
            e.setup(entry2.getKey(), entry2.getValue());
        }
        e.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(C7184a c7184a, String str, BaseSetupTask baseSetupTask) {
        ValueCallback valueCallback;
        for (Map.Entry<String, Pair<ValueCallback<BaseSetupTask>, ValueCallback<BaseSetupTask>>> entry : c7184a.n.entrySet()) {
            if (str.equals(entry.getKey()) && (valueCallback = (ValueCallback) entry.getValue().first) != null) {
                try {
                    valueCallback.onReceiveValue(baseSetupTask != 0 ? baseSetupTask : c7184a);
                } catch (Throwable th) {
                    String str2 = a;
                    Log.d(str2, str + " callback", th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(C7184a c7184a, String str) {
        C7192h c7192h = new C7192h(c7184a, str);
        IWaStat.WaStat.statAKV(new Pair(IWaStat.BUSINESS_ELAPSE_KEY, c7192h));
        String str2 = a;
        Log.d(str2, "elapseStatMaps: " + c7192h);
    }
}
