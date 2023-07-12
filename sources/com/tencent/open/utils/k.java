package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k {
    private static ConcurrentHashMap<String, com.tencent.a.a.a> a = new ConcurrentHashMap<>();

    public static String a(int i) {
        if (i == 10103) {
            return "shareToQQ";
        }
        if (i == 10104) {
            return "shareToQzone";
        }
        if (i == 10105) {
            return "addToQQFavorites";
        }
        if (i == 10106) {
            return "sendToMyComputer";
        }
        if (i == 10107) {
            return "shareToTroopBar";
        }
        if (i == 11101) {
            return "action_login";
        }
        if (i == 10100) {
            return "action_request";
        }
        if (i != 10114) {
            return null;
        }
        return "action_common_channel";
    }

    public static void a() {
        a.clear();
    }

    public static String b(Context context, String str) {
        String str2 = "";
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            String a2 = m.a(messageDigest.digest());
            messageDigest.reset();
            SLog.v("openSDK_LOG.SystemUtils", "-->sign: " + a2);
            messageDigest.update(m.j(packageName + JSMethod.NOT_SET + a2 + JSMethod.NOT_SET + str + ""));
            str2 = m.a(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->signEncryped: ");
            sb.append(str2);
            SLog.v("openSDK_LOG.SystemUtils", sb.toString());
            return str2;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static boolean c(Context context, Intent intent) {
        boolean z = false;
        if (context != null && intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? component null");
                return false;
            }
            String packageName = component.getPackageName();
            String a2 = a(context, packageName);
            if (a2 != null && !a2.isEmpty()) {
                z = true;
            }
            SLog.i("openSDK_LOG.SystemUtils", "isAgentActivityExist? packageName = " + packageName + ", appVersionName= " + a2);
        }
        return z;
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    private static PackageInfo e(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        synchronized (k.class) {
            if (a.containsKey(str)) {
                com.tencent.a.a.a aVar = a.get(str);
                if (aVar == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper is null");
                    return null;
                }
                PackageInfo packageInfo = aVar.b;
                if (packageInfo == null) {
                    SLog.e("openSDK_LOG.SystemUtils", "getTargetPackageInfo wrapper packageInfo is null");
                }
                return packageInfo;
            }
            PackageInfo f = f(context, str);
            a.put(str, new com.tencent.a.a.a(str, f));
            return f;
        }
    }

    private static PackageInfo f(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo null. packageName= " + str);
            }
            return packageInfo;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "realGetPackageInfo exception", e);
            return null;
        }
    }

    private static boolean g(Context context, String str) {
        return (h.a(context, c(), str) == null && e(context, str) == null) ? false : true;
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        a.remove(str);
    }

    public static String a(Context context, String str) {
        String a2 = h.a(context, c(), str);
        if (a2 == null || "UNKNOWN".equals(a2)) {
            PackageInfo e = e(context, str);
            if (e == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getAppVersionName return null. package= " + str);
                return null;
            }
            return e.versionName;
        }
        return a2;
    }

    public static boolean d(Context context) {
        return context != null && context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !b();
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null || str2 != null) {
            if (str != null || str2 == null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int i = 0;
                while (i < split.length && i < split2.length) {
                    try {
                        int parseInt = Integer.parseInt(split[i]);
                        int parseInt2 = Integer.parseInt(split2[i]);
                        if (parseInt < parseInt2) {
                            return -1;
                        }
                        if (parseInt > parseInt2) {
                            return 1;
                        }
                        i++;
                    } catch (NumberFormatException unused) {
                        return str.compareTo(str2);
                    }
                }
                if (split.length > i) {
                    return 1;
                }
                return split2.length > i ? -1 : 0;
            }
            return -1;
        }
        return 1;
    }

    public static boolean c(Context context) {
        if (g(context, "com.tencent.mobileqq")) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: qq");
            return true;
        } else if (g(context, Constants.PACKAGE_TIM)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: tim");
            return true;
        } else if (g(context, Constants.PACKAGE_QQ_PAD)) {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: pad");
            return true;
        } else {
            SLog.i("openSDK_LOG.SystemUtils", "isQQBranchInstalled: disable speed");
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        SLog.v("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (m.g(signature.toCharsString()).equals(str2)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private static String c() {
        String b = com.tencent.open.b.b.b();
        if (b == null || b.isEmpty()) {
            SLog.e("openSDK_LOG.SystemUtils", "getAppId error: " + b);
        }
        return b;
    }

    public static boolean b(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add("com.tencent.mobileqq");
        arrayList.add(Constants.PACKAGE_TIM);
        if (context != null && m.c(context)) {
            arrayList.add(Constants.PACKAGE_QQ_PAD);
        }
        return a(context, intent, arrayList);
    }

    public static String a(Activity activity, String str) {
        if (activity == null) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName activity==null !!!!!!");
            return "";
        }
        try {
            byte[] a2 = e.a(str);
            if (a2 == null) {
                SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName shaBytes==null !!!!!!");
                return "";
            }
            byte[] bArr = new byte[8];
            System.arraycopy(a2, 5, bArr, 0, 8);
            byte[] bArr2 = new byte[16];
            System.arraycopy(a2, 8, bArr2, 0, 16);
            return e.a(activity.getPackageName(), e.a(bArr2), bArr);
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SystemUtils", "getEncryptPkgName", e);
            return "";
        }
    }

    public static int b(String str) {
        if ("shareToQQ".equals(str)) {
            return Constants.REQUEST_QQ_SHARE;
        }
        if ("shareToQzone".equals(str)) {
            return Constants.REQUEST_QZONE_SHARE;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return Constants.REQUEST_LOGIN;
        }
        if ("action_request".equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    public static boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            r1 = (queryIntentActivities == null || queryIntentActivities.size() <= 0) ? false : false;
            if (!r1) {
                StringBuilder sb = new StringBuilder();
                sb.append("isActivityExist false. result=");
                sb.append(queryIntentActivities == null ? "null" : Integer.valueOf(queryIntentActivities.size()));
                sb.append(" Intent= ");
                sb.append(intent);
                SLog.e("openSDK_LOG.SystemUtils", sb.toString());
            }
            return r1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isActivityExist params error! [");
        sb2.append(context == null);
        sb2.append(",");
        sb2.append(intent == null);
        sb2.append(jn1.ARRAY_END_STR);
        SLog.e("openSDK_LOG.SystemUtils", sb2.toString());
        return false;
    }

    public static boolean b(Context context) {
        boolean g = g(context, "com.tencent.mobileqq");
        SLog.i("openSDK_LOG.SystemUtils", "isQQInstalled " + g);
        return g;
    }

    private static boolean b() {
        try {
            return ((Boolean) Environment.class.getMethod("isExternalStorageLegacy", new Class[0]).invoke(Environment.class, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent, List<String> list) {
        if (context != null && intent != null) {
            PackageManager packageManager = context.getPackageManager();
            if (!TextUtils.isEmpty(intent.getPackage())) {
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                r0 = (queryIntentActivities == null || queryIntentActivities.size() <= 0) ? false : false;
                if (!r0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("isTargetActivityExist false. result=");
                    sb.append(queryIntentActivities == null ? "null" : Integer.valueOf(queryIntentActivities.size()));
                    SLog.e("openSDK_LOG.SystemUtils", sb.toString());
                }
                return r0;
            } else if (list == null) {
                SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist params error! targetPackageList is null");
                return false;
            } else {
                for (String str : list) {
                    if (str != null) {
                        intent.setPackage(str);
                        List<ResolveInfo> queryIntentActivities2 = packageManager.queryIntentActivities(intent, 0);
                        intent.setPackage(null);
                        if (queryIntentActivities2 != null && queryIntentActivities2.size() > 0) {
                            return true;
                        }
                    }
                }
                SLog.e("openSDK_LOG.SystemUtils", "isTargetActivityExist false");
                return false;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isTargetActivityExist params error! [");
        sb2.append(context == null);
        sb2.append(",");
        sb2.append(intent == null);
        sb2.append(jn1.ARRAY_END_STR);
        SLog.e("openSDK_LOG.SystemUtils", sb2.toString());
        return false;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"SdCardPath"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r10, java.lang.String r11, int r12) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->extractSecureLib, libName: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.SystemUtils"
            com.tencent.open.log.SLog.i(r1, r0)
            android.content.Context r0 = com.tencent.open.utils.g.a()
            r2 = 0
            if (r0 != 0) goto L23
            java.lang.String r10 = "-->extractSecureLib, global context is null. "
            com.tencent.open.log.SLog.i(r1, r10)
            return r2
        L23:
            java.lang.String r3 = "secure_lib"
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r2)
            java.io.File r4 = new java.io.File
            java.io.File r5 = r0.getFilesDir()
            r4.<init>(r5, r11)
            boolean r5 = r4.exists()
            r6 = 1
            java.lang.String r7 = "version"
            if (r5 != 0) goto L50
            java.io.File r5 = r4.getParentFile()
            if (r5 == 0) goto L73
            boolean r5 = r5.mkdirs()
            if (r5 == 0) goto L73
            r4.createNewFile()     // Catch: java.io.IOException -> L4b
            goto L73
        L4b:
            r4 = move-exception
            r4.printStackTrace()
            goto L73
        L50:
            int r4 = r3.getInt(r7, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "-->extractSecureLib, libVersion: "
            r5.append(r8)
            r5.append(r12)
            java.lang.String r8 = " | oldVersion: "
            r5.append(r8)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.tencent.open.log.SLog.i(r1, r5)
            if (r12 != r4) goto L73
            return r6
        L73:
            r4 = 0
            android.content.res.AssetManager r5 = r0.getAssets()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La7
            java.io.InputStream r10 = r5.open(r10)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La7
            java.io.FileOutputStream r4 = r0.openFileOutput(r11, r2)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            a(r10, r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            android.content.SharedPreferences$Editor r11 = r3.edit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            r11.putInt(r7, r12)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            r11.commit()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9f
            if (r10 == 0) goto L94
            r10.close()     // Catch: java.io.IOException -> L93
            goto L94
        L93:
        L94:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L99
        L99:
            return r6
        L9a:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto Lbc
        L9f:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto La9
        La4:
            r11 = move-exception
            r10 = r4
            goto Lbc
        La7:
            r11 = move-exception
            r10 = r4
        La9:
            java.lang.String r12 = "-->extractSecureLib, when copy lib execption."
            com.tencent.open.log.SLog.e(r1, r12, r11)     // Catch: java.lang.Throwable -> Lbb
            if (r4 == 0) goto Lb5
            r4.close()     // Catch: java.io.IOException -> Lb4
            goto Lb5
        Lb4:
        Lb5:
            if (r10 == 0) goto Lba
            r10.close()     // Catch: java.io.IOException -> Lba
        Lba:
            return r2
        Lbb:
            r11 = move-exception
        Lbc:
            if (r4 == 0) goto Lc3
            r4.close()     // Catch: java.io.IOException -> Lc2
            goto Lc3
        Lc2:
        Lc3:
            if (r10 == 0) goto Lc8
            r10.close()     // Catch: java.io.IOException -> Lc8
        Lc8:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.k.a(java.lang.String, java.lang.String, int):boolean");
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                SLog.i("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j);
                return j;
            }
        }
    }

    public static String a(Activity activity) {
        try {
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128);
            SLog.i("openSDK_LOG.SystemUtils", "apkPath=" + applicationInfo.sourceDir);
            return applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            SLog.e("openSDK_LOG.SystemUtils", "NameNotFoundException", e);
            return null;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.SystemUtils", "Exception", e2);
            return null;
        }
    }
}
