package com.huawei.secure.android.common.util;

import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ZipUtil {
    private static final String a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 4096;
    private static final String e = "../";
    private static final String f = "..\\";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012c  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.io.File> a(java.io.File r17, java.io.File r18, long r19, boolean r21) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.io.File, java.io.File, long, boolean):java.util.List");
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (a(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException unused) {
                Log.e(a, "createOrExistsFile IOException ");
                return false;
            }
        }
        return false;
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    e(file2);
                }
                c(file);
                return;
            }
            c(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, ZipAppConstants.LIMITED_APP_SPACE, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, ZipAppConstants.LIMITED_APP_SPACE, 100, z);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(a, "delete file error");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
        android.util.Log.e(com.huawei.secure.android.common.util.ZipUtil.a, "unzip  over than top size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d0, code lost:
        r2 = false;
        r3 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014a  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean unZip(java.lang.String r17, java.lang.String r18, long r19, int r21, boolean r22) throws com.huawei.secure.android.common.util.SecurityCommonException {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.unZip(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (a(str, str2, j, i)) {
            String str3 = File.separator;
            if (str2.endsWith(str3) && str2.length() > str3.length()) {
                str2 = str2.substring(0, str2.length() - str3.length());
            }
            return a(c(str), c(str2), j, z);
        }
        return null;
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(a, "mkdirs error , files exists or IOException.");
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains(e) || str.contains(f) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
        }
        Log.e(a, "isContainInvalidStr: name is null");
        return true;
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str) || !e(str)) {
            return;
        }
        Log.e(a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0071 -> B:39:0x0074). Please submit an issue!!! */
    private static boolean a(String str, long j, int i) {
        int i2;
        boolean z = false;
        ZipFile zipFile = null;
        try {
        } catch (IOException unused) {
            LogsUtil.e(a, "close zipFile IOException ");
            zipFile = zipFile;
        }
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    long j2 = 0;
                    int i3 = 0;
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        j2 += nextElement.getSize();
                        int i4 = i3 + 1;
                        if (!e(nextElement.getName()) && i4 < i && j2 <= j) {
                            i3 = i4;
                            if (nextElement.getSize() == -1) {
                                LogsUtil.e(a, "File name is invalid or too many files or too big");
                                i2 = i4;
                                break;
                            }
                        } else {
                            LogsUtil.e(a, "File name is invalid or too many files or too big");
                            i2 = i4;
                            break;
                        }
                    }
                    z = true;
                    i2 = i3;
                    zipFile2.close();
                    zipFile = i2;
                } catch (IOException e2) {
                    e = e2;
                    zipFile = zipFile2;
                    LogsUtil.e(a, "not a valid zip file, IOException : " + e.getMessage());
                    if (zipFile != null) {
                        zipFile.close();
                        zipFile = zipFile;
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            LogsUtil.e(a, "close zipFile IOException ");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !e(str)) {
            if (!TextUtils.isEmpty(str2) && !e(str2)) {
                if (a(str, j, i)) {
                    return true;
                }
                LogsUtil.e(a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            for (File file : list) {
                e(file);
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
