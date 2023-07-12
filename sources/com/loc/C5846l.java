package com.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;
import tb.y33;

/* compiled from: Taobao */
/* renamed from: com.loc.l */
/* loaded from: classes10.dex */
public final class C5846l {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    static String e;
    static boolean f;

    public static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d = str;
        if (context != null) {
            C5866o0.f().d(new ck() { // from class: com.loc.l.1
                @Override // com.loc.ck
                public final void a() {
                    FileOutputStream fileOutputStream;
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        File file = new File(al.i(context, "k.store"));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(v1.p(str));
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            y33.e(th, "AI", "stf");
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    }
                }
            });
        }
    }

    public static void c(String str) {
        b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        if (f) {
            return true;
        }
        if (f(e)) {
            f = true;
            return true;
        } else if (!TextUtils.isEmpty(e)) {
            f = false;
            e = null;
            return false;
        } else if (f(b)) {
            f = true;
            return true;
        } else {
            if (!TextUtils.isEmpty(b)) {
                f = false;
                b = null;
                return false;
            }
            return true;
        }
    }

    public static String e(Context context) {
        try {
        } catch (Throwable th) {
            y33.e(th, "AI", "gAN");
        }
        if ("".equals(a)) {
            PackageManager packageManager = context.getPackageManager();
            a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return a;
        }
        return a;
    }

    private static boolean f(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    an.l(v1.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String g(Context context) {
        String str;
        try {
            str = b;
        } catch (Throwable th) {
            y33.e(th, "AI", "gpck");
        }
        if (str == null || "".equals(str)) {
            String packageName = context.getPackageName();
            b = packageName;
            if (!f(packageName)) {
                b = context.getPackageName();
            }
            return b;
        }
        return b;
    }

    public static String h(Context context) {
        try {
        } catch (Throwable th) {
            y33.e(th, "AI", "gAV");
        }
        if ("".equals(c)) {
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = c;
            return str == null ? "" : str;
        }
        return c;
    }

    public static String i(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(v1.v("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (f(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(b)) {
                str = g(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            y33.e(th, "AI", "gsp");
            return e;
        }
    }

    public static String j(Context context) {
        try {
            C5849m.c(context);
        } catch (Throwable unused) {
        }
        try {
            return l(context);
        } catch (Throwable th) {
            y33.e(th, "AI", "gKy");
            return d;
        }
    }

    private static String k(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(al.i(context, "k.store"));
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String g = v1.g(bArr);
                String str = g.length() == 32 ? g : "";
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return str;
            } catch (Throwable th4) {
                th = th4;
                try {
                    y33.e(th, "AI", "gKe");
                    if (file.exists()) {
                        file.delete();
                    }
                    return "";
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        }
        return "";
    }

    private static String l(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return d;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            d = string;
            if (string == null) {
                d = k(context);
            }
        }
        return d;
    }
}
