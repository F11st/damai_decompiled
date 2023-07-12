package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.C7340l;
import java.io.File;
import java.util.Stack;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.j */
/* loaded from: classes11.dex */
public final class C7337j {
    public static long a = 2;
    private static final String b = "j";
    private static long c = 1;
    private static long d = 4;
    private static long e = 8;
    private static long f = 16;
    private static String g = "com.eg.android.AlipayGphone";
    private static long h;
    private static long i;
    private static long j;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.j$a */
    /* loaded from: classes11.dex */
    public static class C7338a {
        public static long a = 1;
        public static long b = 2;
        public static long c = 4;
        public static long d = 8;
        public static long e = 16;
        public static long f = 32;
        public static long g = 64;
        public static long h = 128;
        public static long i = 256;
        public static long j = 512;
        public static long k = 1024;
        public static long l = 2048;
        public static long m = 4096;
        public static long n = 8192;
        public static long o = 16384;
        public static long p = 32768;
        public static long q = 65536;
        public static long r = 131072;
        public long s = 0;

        public final void a(long j2) {
            this.s = j2 | this.s;
        }
    }

    static {
        long j2 = 1 << 1;
        h = j2;
        long j3 = j2 << 1;
        i = j3;
        j = j3 << 1;
    }

    public static void a(String str) {
        if (C7349p.a(str)) {
            return;
        }
        try {
            IGlobalSettings f2 = SDKFactory.f();
            if (f2 != null) {
                f2.setStringValue("LoadShareCoreHost", str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String b(String str) {
        int min;
        if (C7349p.a(str)) {
            return str;
        }
        try {
            String replaceAll = str.replaceAll("Exception", ExifInterface.LONGITUDE_EAST);
            int indexOf = replaceAll.indexOf(":");
            int lastIndexOf = indexOf >= 0 ? replaceAll.lastIndexOf(".", indexOf) : -1;
            return (lastIndexOf < 0 || (min = Math.min(lastIndexOf + 30, replaceAll.length())) <= lastIndexOf) ? replaceAll : replaceAll.substring(lastIndexOf, min);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static File c(String str) {
        return a(new File(a()), str);
    }

    private static long d(String str) {
        long j2 = 0;
        if (C7349p.a(str)) {
            return 0L;
        }
        String[] split = str.split("\\.");
        for (int i2 = 0; i2 < split.length; i2++) {
            j2 += Integer.parseInt(split[i2]);
            if (i2 < split.length - 1) {
                j2 *= 100;
            }
        }
        return j2;
    }

    public static String e(Context context) {
        String[] strArr;
        int i2;
        int i3;
        long j2;
        String str;
        StringBuilder sb;
        long j3 = h;
        try {
            if (!b(context)) {
                str = b;
                Log.d(str, ".getSdcardShareCoreDecFilePath Sdcard配置及权限校验失败");
                j2 = i;
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j2));
                sb = new StringBuilder(".getSdcardShareCoreDecFilePath fStat: ");
            } else {
                String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST);
                if (C7349p.a(param)) {
                    j2 = j;
                    str = b;
                    Log.d(str, ".getSdcardShareCoreDecFilePath CDKeys.CD_KEY_SHARE_CORE_HOST_PKG_NAME_LIST配置为空");
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j2));
                    sb = new StringBuilder(".getSdcardShareCoreDecFilePath fStat: ");
                } else {
                    String[] split = param.split(CDParamKeys.CD_VALUE_STRING_SPLITER);
                    Stack stack = new Stack();
                    int length = split.length;
                    String str2 = null;
                    int i4 = 0;
                    while (i4 < length) {
                        String str3 = split[i4];
                        if (!C7349p.a(str3)) {
                            File c2 = c(str3);
                            if (!c2.exists()) {
                                Log.d(b, ".getSdcardShareCoreDecFilePath " + c2.getAbsolutePath() + " not exists.");
                            } else {
                                File[] listFiles = c2.listFiles();
                                if (listFiles != null && listFiles.length != 0) {
                                    int length2 = listFiles.length;
                                    int i5 = 0;
                                    while (i5 < length2) {
                                        File file = listFiles[i5];
                                        String str4 = b;
                                        String[] strArr2 = split;
                                        int i6 = length;
                                        Log.d(str4, ".getSdcardShareCoreDecFilePath coreFile: " + file.getAbsolutePath());
                                        String a2 = a(context, file, UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_UCM_VERSIONS), null);
                                        if (C7349p.a(a2)) {
                                            Log.d(str4, ".getSdcardShareCoreDecFilePath version is empty.");
                                        } else if (C7358w.a(file.getAbsolutePath(), context)) {
                                            Log.d(str4, ".getSdcardShareCoreDecFilePath " + file.getAbsolutePath() + " once shared.");
                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SKIP_ONCE_VERIFY_CORE_FILE);
                                        } else {
                                            i3 = length2;
                                            Log.d(str4, ".getSdcardShareCoreDecFilePath version : " + a2);
                                            if (a(str2, a2) < 0) {
                                                stack.push(file);
                                                str2 = a2;
                                            }
                                            i5++;
                                            split = strArr2;
                                            length = i6;
                                            length2 = i3;
                                        }
                                        i3 = length2;
                                        i5++;
                                        split = strArr2;
                                        length = i6;
                                        length2 = i3;
                                    }
                                }
                                strArr = split;
                                i2 = length;
                                Log.d(b, ".getSdcardShareCoreDecFilePath " + c2.getAbsolutePath() + " empty.");
                                i4++;
                                split = strArr;
                                length = i2;
                            }
                        }
                        strArr = split;
                        i2 = length;
                        i4++;
                        split = strArr;
                        length = i2;
                    }
                    while (!stack.empty()) {
                        File file2 = (File) stack.pop();
                        if (UCCyclone.detectZipByFileType(file2.getAbsolutePath()) && !a(file2) && !C7340l.a(file2.getAbsolutePath(), context, context, new C7340l.C7342b("sc_cvsv"))) {
                            Log.d(b, ".getSdcardShareCoreDecFilePath verifySignature failure!");
                        }
                        C7358w.a(file2.getAbsolutePath(), context, true);
                        return file2.getAbsolutePath();
                    }
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j3));
                    Log.d(b, ".getSdcardShareCoreDecFilePath fStat: " + j3);
                    return null;
                }
            }
            sb.append(j2);
            Log.d(str, sb.toString());
            return null;
        } catch (Throwable th) {
            try {
                String str5 = b;
                Log.d(str5, ".getSdcardShareCoreDecFilePath", th);
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j3));
                Log.d(str5, ".getSdcardShareCoreDecFilePath fStat: " + j3);
                return null;
            } finally {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j3));
                Log.d(b, ".getSdcardShareCoreDecFilePath fStat: " + j3);
            }
        }
    }

    public static void f(Context context) {
        String d2 = d(context);
        File a2 = C7349p.a(context, "decompresses2");
        File file = new File(d2);
        String str = b;
        Log.d(str, ".deleteShareCoreDecompressDir decRootDir:" + a2);
        Log.d(str, ".deleteShareCoreDecompressDir scDecDir:" + file);
        int i2 = 5;
        File file2 = file;
        while (true) {
            String str2 = b;
            Log.d(str2, ".deleteShareCoreDecompressDir scParentDir:" + file);
            if (file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                Log.d(str2, ".deleteShareCoreDecompressDir delete share core decompress dir.");
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELETE_DEC_DIR);
                UCCyclone.recursiveDelete(file2, false, null);
                return;
            }
            File parentFile = file2.getParentFile();
            i2--;
            if (i2 <= 0) {
                return;
            }
            file2 = file;
            file = parentFile;
        }
    }

    public static boolean c(Context context) {
        return g.equals(context.getPackageName());
    }

    private static boolean a(String str, String str2, C7338a c7338a) {
        String[] split;
        if (C7349p.a(str) || C7349p.a(str2)) {
            if (c7338a != null) {
                c7338a.a(C7338a.c);
            }
            return false;
        }
        for (String str3 : str.split(CDParamKeys.CD_VALUE_STRING_SPLITER)) {
            if (str2.equals(str3) || str2.matches(str3)) {
                return true;
            }
        }
        if (c7338a != null) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_CHECK_FAILURE);
        }
        if (c7338a != null) {
            c7338a.a(C7338a.d);
        }
        return false;
    }

    public static String d(Context context) {
        String str;
        try {
            File[] listFiles = C7349p.a(context, "decompresses2").listFiles();
            if (listFiles.length == 0) {
                return null;
            }
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str = null;
                    break;
                }
                File file = listFiles[i2];
                if (file.isDirectory()) {
                    str = C7349p.a(file, "sdk_shell");
                    if (C7349p.a(str)) {
                        continue;
                    } else {
                        if (!C7349p.a(C7349p.a(file, UCCyclone.DecFileOrign.DecFileOrignFlag + UCCyclone.DecFileOrign.Sdcard_Share_Core))) {
                            break;
                        }
                    }
                }
                i2++;
            }
            if (C7349p.a(str)) {
                return null;
            }
            return new File(str).getParent();
        } catch (Throwable th) {
            Log.d(b, ".getLocationDecDir ", th);
            return null;
        }
    }

    public static boolean b(Context context) {
        return a(context) == a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1 A[Catch: all -> 0x00a7, TRY_ENTER, TryCatch #3 {all -> 0x00cc, blocks: (B:3:0x0003, B:6:0x0012, B:7:0x0017, B:8:0x0029, B:24:0x0095, B:43:0x00c8, B:31:0x00a1, B:35:0x00ab, B:37:0x00b2), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab A[Catch: all -> 0x00a7, TryCatch #3 {all -> 0x00cc, blocks: (B:3:0x0003, B:6:0x0012, B:7:0x0017, B:8:0x0029, B:24:0x0095, B:43:0x00c8, B:31:0x00a1, B:35:0x00ab, B:37:0x00b2), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2 A[Catch: all -> 0x00a7, TRY_LEAVE, TryCatch #3 {all -> 0x00cc, blocks: (B:3:0x0003, B:6:0x0012, B:7:0x0017, B:8:0x0029, B:24:0x0095, B:43:0x00c8, B:31:0x00a1, B:35:0x00ab, B:37:0x00b2), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #3 {all -> 0x00cc, blocks: (B:3:0x0003, B:6:0x0012, B:7:0x0017, B:8:0x0029, B:24:0x0095, B:43:0x00c8, B:31:0x00a1, B:35:0x00ab, B:37:0x00b2), top: B:58:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(android.content.Context r9, java.io.File r10, com.uc.webview.export.internal.utility.C7337j.C7338a r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.C7337j.b(android.content.Context, java.io.File, com.uc.webview.export.internal.utility.j$a):java.lang.String");
    }

    private static int a(String str, String str2) {
        int i2 = (d(str) > d(str2) ? 1 : (d(str) == d(str2) ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }

    public static long a(Context context) {
        long j2 = a;
        try {
            String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH);
            if (C7349p.a(param)) {
                j2 = d;
            } else if (context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) != 0) {
                j2 = e;
            } else {
                File file = new File(param, "uws");
                UCCyclone.expectCreateDirFile(file);
                if (!file.exists()) {
                    j2 = f;
                }
            }
        } catch (Throwable th) {
            Log.d(b, ".sdcardAuthority", th);
        }
        return j2;
    }

    public static String a() {
        return new File(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH), "uws").getAbsolutePath();
    }

    public static File a(File file, String str) {
        return C7349p.b(file, C7349p.e(str));
    }

    public static boolean a(File file) {
        return file.getAbsolutePath().contains("uws") && file.getAbsolutePath().contains(C7349p.e(g));
    }

    public static boolean a(Context context, File file, C7338a c7338a) {
        return C7340l.a(file.getAbsolutePath(), context, context, new C7340l.C7342b("sc_cvsv"), c7338a);
    }

    public static String a(Context context, File file, String str, C7338a c7338a) {
        File file2;
        Log.d(b, ".getLegalVersionsFromCoreCompressFile " + file.getAbsolutePath() + AVFSCacheConstants.COMMA_SEP + str);
        File file3 = null;
        while (true) {
            try {
                file2 = new File(context.getCacheDir(), "temp_dec_core_" + Process.myPid() + JSMethod.NOT_SET + Process.myTid() + JSMethod.NOT_SET + String.valueOf(System.currentTimeMillis()));
                try {
                    if (!file2.exists()) {
                        break;
                    }
                    file3 = file2;
                } catch (Throwable th) {
                    th = th;
                    file3 = file2;
                    try {
                        Log.d(b, ".getLegalVersionsFromCoreCompressFile", th);
                        if (c7338a != null) {
                            c7338a.a(C7338a.a);
                        }
                        if (c7338a != null) {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEC_CORE_FILE_EXCEPTION);
                        }
                        if (c7338a != null) {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEC_CORE_FILE_EXCEPTION_VALUE, b(th.toString()));
                        }
                        return null;
                    } finally {
                        if (file3 != null) {
                            UCCyclone.recursiveDelete(file3, false, null);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        UCCyclone.expectCreateDirFile(file2);
        UCCyclone.decompress(!UCCyclone.detectZipByFileType(file.getAbsolutePath()), context, file.getAbsolutePath(), file2.getAbsolutePath(), "sdk_shell", new C7339k());
        if (c7338a != null) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEC_CORE_FILE_SUCCESS);
        }
        if (c7338a != null) {
            c7338a.a(C7338a.q);
        }
        String b2 = b(context, file2, c7338a);
        if (!C7349p.a(b2)) {
            if (c7338a != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VALUE, b2);
            }
            Log.d(b, ".getLegalVersionsFromCoreDir ucmVersion: " + b2 + " of " + file2.getAbsolutePath());
            if (a(str, b2, c7338a)) {
                String a2 = C7349p.a(file2, "sdk_shell");
                if (!a(context, new File(a2), c7338a)) {
                    if (c7338a != null) {
                        c7338a.a(C7338a.f);
                    }
                    throw new UCKnownException(8005, String.format("[%s] verify failure.", a2));
                }
                UCCyclone.recursiveDelete(file2, false, null);
                return b2;
            }
        } else if (c7338a != null) {
            c7338a.a(C7338a.b);
        }
        b2 = null;
        UCCyclone.recursiveDelete(file2, false, null);
        return b2;
    }
}
