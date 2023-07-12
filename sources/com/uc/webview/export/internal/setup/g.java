package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.UCMPackageInfo;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class g {
    private static final int a = -1;
    private static Boolean b;
    private static final Object c = new Object();

    public static final void a(bt btVar, ConcurrentHashMap<String, Object> concurrentHashMap, boolean z, boolean z2, boolean z3) {
        if (z) {
            Boolean bool = null;
            if (!z3) {
                z3 = !z2;
                bool = Boolean.valueOf(com.uc.webview.export.internal.utility.p.a((Boolean) concurrentHashMap.get(UCCore.OPTION_SKIP_OLD_KERNEL)));
                if (bool != null) {
                    z3 = bool.booleanValue();
                }
            }
            if (z3) {
                UCLogger.print(a, "checkParamSkipOldKernel:true", new Throwable[0]);
                throw new UCSetupException((int) GlobalErrorCode.ERROR_CTID_NOT_BINDING, String.format("UCM [%s] is excluded by param skip_old_extra_kernel value [%s].", btVar.dataDir, bool));
            }
        }
    }

    public static final void b(bt btVar, Context context, ClassLoader classLoader, int i) {
        com.uc.webview.export.internal.uc.startup.b.a(31);
        String[][] e = com.uc.webview.export.internal.utility.h.e(classLoader);
        if (e != null) {
            if (e.length == 0) {
                Log.d("EnvUtils", "getPkgAssets empty");
                return;
            }
            String str = btVar.resDirPath;
            if (str == null) {
                return;
            }
            String absolutePath = new File(str, "").getAbsolutePath();
            File file = new File(absolutePath, bt.RES_PAKS_DIR_NAME);
            if (file.exists()) {
                absolutePath = file.getAbsolutePath();
            }
            boolean z = (i & 64) != 0;
            for (String[] strArr : e) {
                String str2 = strArr[0];
                long d = com.uc.webview.export.internal.utility.p.d(strArr[1]);
                File file2 = new File(absolutePath, str2);
                if (file2.length() == d) {
                    UCLogger.print(a, String.format(Locale.CHINA, "Check file size ok [%s].", file2), new Throwable[0]);
                } else {
                    Log.d("EnvUtils", "组件校验 Pak Size Failed [" + file2.getAbsolutePath() + jn1.ARRAY_END_STR);
                    throw new UCSetupException(1014, String.format(Locale.CHINA, "So file [%s] with length [%d] mismatch to predefined [%d].", file2, Long.valueOf(file2.length()), Long.valueOf(d)));
                }
            }
            if (z) {
                h.b(context, absolutePath, e, Integer.valueOf(i));
            }
            com.uc.webview.export.internal.uc.startup.b.a(215);
            return;
        }
        throw new UCSetupException(3029, "getPkgAssets failed");
    }

    public static final void a(ClassLoader classLoader, String str, String str2) {
        a(str, com.uc.webview.export.internal.utility.h.a(classLoader));
        a(str2, com.uc.webview.export.internal.utility.h.b(classLoader));
    }

    private static final void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String[] split = str.split(",");
                if (split.length == 0) {
                    return;
                }
                for (String str3 : split) {
                    String trim = str3.trim();
                    if (trim.length() != 0 && (str2.startsWith(trim) || str2.matches(trim))) {
                        throw new UCSetupException(4013, String.format("UCM version [%s] is excluded by rules [%s].", str2, str));
                    }
                }
            }
        } catch (Exception e) {
            throw new UCSetupException(4012, e);
        }
    }

    public static final void a(bt btVar, Context context, ClassLoader classLoader, ConcurrentHashMap<String, Object> concurrentHashMap) {
        com.uc.webview.export.internal.uc.startup.b.a(30);
        com.uc.webview.export.internal.utility.h.a((UCMPackageInfo) btVar, context, classLoader, concurrentHashMap);
        com.uc.webview.export.internal.uc.startup.b.a(214);
    }

    public static final void a(bt btVar, Context context, ClassLoader classLoader, int i) {
        com.uc.webview.export.internal.uc.startup.b.a(35);
        String[][] d = com.uc.webview.export.internal.utility.h.d(classLoader);
        if (d != null) {
            if (d.length == 0) {
                Log.d("EnvUtils", "getNativeLibraries empty");
                return;
            }
            String str = btVar.soDirPath;
            if (str == null) {
                str = context.getApplicationInfo().nativeLibraryDir;
            }
            boolean z = (i & 16) != 0;
            for (String[] strArr : d) {
                String str2 = strArr[0];
                long d2 = com.uc.webview.export.internal.utility.p.d(strArr[1]);
                File file = new File(str, str2);
                if (file.length() == d2) {
                    UCLogger.print(a, String.format(Locale.CHINA, "Check file size ok [%s].", file), new Throwable[0]);
                } else {
                    Log.d("EnvUtils", "组件校验 So Size Failed [" + file.getAbsolutePath() + jn1.ARRAY_END_STR);
                    throw new UCSetupException(1008, String.format(Locale.CHINA, "So file [%s] with length [%d] mismatch to predefined [%d].", file, Long.valueOf(file.length()), Long.valueOf(d2)));
                }
            }
            if (z) {
                h.a(context, btVar.soDirPath, d, Integer.valueOf(i));
            }
            com.uc.webview.export.internal.uc.startup.b.a(219);
            return;
        }
        throw new UCSetupException(3019, "getNativeLibraries failed");
    }

    public static boolean a(Context context, bt btVar, ConcurrentHashMap<String, Object> concurrentHashMap) {
        boolean booleanValue;
        boolean z;
        synchronized (c) {
            if (b == null) {
                if (!com.uc.webview.export.internal.utility.p.a(btVar.dataDir)) {
                    String str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_ZIP_FILE);
                    if (!com.uc.webview.export.internal.utility.p.a(str)) {
                        z = com.uc.webview.export.internal.utility.p.c(context, btVar.dataDir, str);
                    } else {
                        String str2 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL);
                        if (!com.uc.webview.export.internal.utility.p.a(str2)) {
                            File b2 = com.uc.webview.export.internal.update.b.b(context);
                            if (btVar.dataDir.startsWith(b2.getAbsolutePath())) {
                                if (!btVar.dataDir.startsWith(new File(b2, UCCyclone.getSourceHash(str2)).getAbsolutePath())) {
                                    z = true;
                                }
                            }
                        }
                    }
                    b = Boolean.valueOf(z);
                }
                z = false;
                b = Boolean.valueOf(z);
            }
            booleanValue = b.booleanValue();
        }
        return booleanValue;
    }
}
