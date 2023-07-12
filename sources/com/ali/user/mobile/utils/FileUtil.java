package com.ali.user.mobile.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FileUtil {
    public static void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getEaDeviceId() {
        String str;
        if (DataProviderFactory.getDataProvider().getEnvType() == 3) {
            str = "ONLINE";
        } else {
            str = DataProviderFactory.getDataProvider().getEnvType() == 2 ? "PRE" : "TEST";
        }
        return DataProviderFactory.getApplicationContext().getSharedPreferences("onesdk_device", 0).getString(str + "_sdkDeviceId", null);
    }

    public static String getExtensionName(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() + (-1)) ? str : str.substring(lastIndexOf + 1);
    }

    public static int getLaunchTimes() {
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences("aliuser_bootcount", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);
        if (!sharedPreferences.getString("todaytime", "").equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())))) {
            edit.putString("todaytime", simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
        }
        int i = sharedPreferences.getInt("bootcountnum", 0);
        int i2 = 1;
        if (i >= 1) {
            i2 = 1 + i;
            edit.putInt("bootcountnum", i2);
        } else {
            edit.putInt("bootcountnum", 1);
        }
        edit.apply();
        return i2;
    }

    public static String getSdcardFile(String str) {
        String str2 = DataProviderFactory.getApplicationContext().getFilesDir().getPath() + "/device/";
        if (new File(str2).exists()) {
            return readFileData(DataProviderFactory.getApplicationContext(), str2 + str);
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5 == null) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFileData(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r4 = ""
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            int r0 = r5.available()     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L33
            if (r0 <= 0) goto L20
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L33
            r5.read(r0)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L33
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L33
            java.lang.String r2 = "UTF-8"
            r1.<init>(r0, r2)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L33
            r4 = r1
        L20:
            r5.close()     // Catch: java.lang.Exception -> L32
            goto L32
        L24:
            r0 = move-exception
            goto L2c
        L26:
            r4 = move-exception
            goto L35
        L28:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L2c:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto L32
            goto L20
        L32:
            return r4
        L33:
            r4 = move-exception
            r0 = r5
        L35:
            if (r0 == 0) goto L3a
            r0.close()     // Catch: java.lang.Exception -> L3a
        L3a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.utils.FileUtil.readFileData(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void writeFileData(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            r2 = 0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L23
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L2e
            byte[] r2 = r4.getBytes(r2)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L2e
            r3.write(r2)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L2e
        L18:
            r3.close()     // Catch: java.lang.Exception -> L2d
            goto L2d
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r3 = move-exception
            r1 = r3
            r3 = r2
            r2 = r1
            goto L2f
        L23:
            r3 = move-exception
            r1 = r3
            r3 = r2
            r2 = r1
        L27:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L2d
            goto L18
        L2d:
            return
        L2e:
            r2 = move-exception
        L2f:
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.lang.Exception -> L34
        L34:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.utils.FileUtil.writeFileData(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void writeSdcardFile(String str, String str2) {
        Context applicationContext = DataProviderFactory.getApplicationContext();
        String str3 = DataProviderFactory.getApplicationContext().getFilesDir().getPath() + "/device/";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        writeFileData(applicationContext, str3 + str, str2);
    }
}
