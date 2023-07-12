package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7340l;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.C7358w;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.h */
/* loaded from: classes11.dex */
public final class C7277h {
    private static final int a = -1;

    public static UCElapseTime a(Context context, Integer num, String str) {
        UCElapseTime uCElapseTime = new UCElapseTime();
        if ((num.intValue() & 1073741824) == 0 || !C7358w.a(str, context)) {
            if (C7340l.a(str, context, context, new C7340l.C7342b("cd_cvsv"), null)) {
                Log.d("FileVerifier", "组件校验 Dex Success [" + str + jn1.ARRAY_END_STR);
                C7358w.a(str, context, true);
            } else {
                Log.d("FileVerifier", "组件校验 Dex Failed [" + str + jn1.ARRAY_END_STR);
                C7358w.a(str, context, false);
                throw new UCSetupException(3005, String.format("[%s] verify failed", str));
            }
        }
        return uCElapseTime;
    }

    private static String a(int i) {
        return i != 2 ? i != 3 ? i != 4 ? "SHA1(default)" : "SHA256" : "SHA1" : MessageDigestAlgorithms.MD5;
    }

    public static void b(Context context, String str, String[][] strArr, Integer num) throws UCSetupException {
        if (context == null || C7349p.a(str) || strArr == null || strArr.length <= 0 || num == null) {
            return;
        }
        a(context, str, strArr, num, ((num.intValue() & 1073741824) != 0) || ((num.intValue() & 536870912) != 0), false);
    }

    public static void a(Context context, String str, String[][] strArr, Integer num) {
        if (context == null || C7349p.a(str) || strArr == null || strArr.length <= 0 || num == null) {
            return;
        }
        C7302b.a(37);
        boolean z = ((num.intValue() & 1073741824) != 0) || ((num.intValue() & 268435456) != 0);
        boolean z2 = z && !SDKFactory.a(context).exists();
        int i = a;
        UCLogger.print(i, "ignoreQuickFlagFile : " + z2, new Throwable[0]);
        a(context, str, strArr, num, z, z2);
        C7302b.a(Constants.SDK_VERSION_CODE);
    }

    private static void a(Context context, String str, String[][] strArr, Integer num, boolean z, boolean z2) throws UCSetupException {
        String hashFileContents;
        int i;
        int i2 = 2;
        int i3 = strArr[0].length > 3 ? 3 : 2;
        int i4 = 4;
        if ((num.intValue() & 1048576) != 0) {
            i3 = 2;
        } else if ((num.intValue() & 4194304) != 0 && strArr[0].length > 4) {
            i3 = 4;
        }
        int length = strArr.length;
        int i5 = 0;
        while (i5 < length) {
            String[] strArr2 = strArr[i5];
            String str2 = strArr2[0];
            String str3 = strArr2[i3];
            File file = new File(str, str2);
            if (z && !z2 && C7358w.a(file.getAbsolutePath(), context)) {
                i = i5;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (i3 == i2) {
                    hashFileContents = UCCyclone.hashFileContents(file, UCCyclone.MessageDigestType.MD5);
                } else if (i3 == i4) {
                    hashFileContents = UCCyclone.hashFileContents(file, UCCyclone.MessageDigestType.SHA256);
                } else {
                    hashFileContents = UCCyclone.hashFileContents(file, UCCyclone.MessageDigestType.SHA1);
                }
                try {
                    if (!C7349p.a(str3) && !str3.equals(hashFileContents)) {
                        Object[] objArr = new Object[i4];
                        objArr[0] = file;
                        objArr[1] = i3 == i2 ? "md5" : "sha";
                        objArr[i2] = hashFileContents;
                        objArr[3] = str3;
                        throw new UCSetupException(1011, String.format("file [%s] with [%s] [%s] mismatch to predefined [%s].", objArr));
                    }
                    if (z) {
                        C7358w.a(file.getAbsolutePath(), context, true);
                    }
                    i = i5;
                    Log.d("FileVerifier", "组件校验(" + a(i3) + ") Pass:true [" + file.getAbsolutePath() + "] time[" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
                } catch (Throwable th) {
                    if (z) {
                        C7358w.a(file.getAbsolutePath(), context, false);
                    }
                    Log.d("FileVerifier", "组件校验(" + a(i3) + ") Pass:false [" + file.getAbsolutePath() + "] time[" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
                    throw th;
                }
            }
            UCLogger.print(a, String.format(Locale.CHINA, "Check file hash ok [%s].", file), new Throwable[0]);
            i5 = i + 1;
            i2 = 2;
            i4 = 4;
        }
    }

    public static boolean a(Context context) {
        return SDKFactory.a(context).exists();
    }
}
