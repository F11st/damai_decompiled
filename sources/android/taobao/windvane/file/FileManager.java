package android.taobao.windvane.file;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FileManager {
    static final int BUFFER = 1024;
    private static final String TAG = "FileManager";
    public static final String UNZIP_SUCCESS = "success";
    private static File cachedDir;

    public static boolean copy(String str, String str2) {
        return copy(new File(str), new File(str2));
    }

    public static boolean copyDir(String str, String str2) {
        String formatUrl = formatUrl(str);
        String formatUrl2 = formatUrl(str2);
        new File(formatUrl2).mkdirs();
        File[] listFiles = new File(formatUrl).listFiles();
        byte[] bArr = new byte[2048];
        if (listFiles == null) {
            return false;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                File file = listFiles[i];
                if (!copy(file, new File(new File(formatUrl2).getAbsolutePath() + File.separator + listFiles[i].getName()), bArr)) {
                    return false;
                }
            }
            if (listFiles[i].isDirectory()) {
                StringBuilder sb = new StringBuilder();
                sb.append(formatUrl);
                String str3 = File.separator;
                sb.append(str3);
                sb.append(listFiles[i].getName());
                String sb2 = sb.toString();
                if (!copyDir(sb2, formatUrl2 + str3 + listFiles[i].getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    public static void copyFile(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                try {
                    file.createNewFile();
                    FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream.read(bArr, 0, 2048);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream4.write(bArr, 0, read);
                        }
                        fileOutputStream4.close();
                        fileOutputStream = bArr;
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream4;
                        TaoLog.e(TAG, "copyFile: dest FileNotFoundException:" + e.getMessage());
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream3 = fileOutputStream4;
                        TaoLog.e(TAG, "copyFile: write IOException:" + e.getMessage());
                        if (fileOutputStream3 != null) {
                            fileOutputStream3.close();
                            fileOutputStream = fileOutputStream3;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream4;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public static String createBaseDir(Application application, String str, String str2, boolean z) {
        File externalCacheDir;
        StringBuilder sb;
        String str3 = null;
        if (z) {
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            if (wVCommonConfigData.targetSdkAdapte && Build.VERSION.SDK_INT >= 29) {
                externalCacheDir = application.getExternalFilesDir("apk");
            } else {
                WVCommonConfig.getInstance();
                if (wVCommonConfigData.storeCachedDir) {
                    if (cachedDir == null) {
                        cachedDir = application.getExternalCacheDir();
                    }
                    externalCacheDir = cachedDir;
                } else {
                    externalCacheDir = application.getExternalCacheDir();
                }
            }
            if (externalCacheDir != null) {
                sb = new StringBuilder();
                sb.append(externalCacheDir.getAbsolutePath());
                sb.append(File.separator);
            } else {
                File externalCacheDir2 = CommonUtils.getExternalCacheDir(application);
                if (externalCacheDir2 != null) {
                    sb = new StringBuilder();
                    sb.append(externalCacheDir2.getAbsolutePath());
                    sb.append(File.separator);
                } else {
                    sb = null;
                }
            }
            if (!TextUtils.isEmpty(str) && sb != null) {
                sb.append(str);
                sb.append(File.separator);
                sb.append(str2);
                str3 = sb.toString();
            }
        }
        if (str3 == null) {
            str3 = createInnerCacheStorage(application, str, str2);
        }
        TaoLog.d(TAG, "createBaseDir path:" + str3);
        return str3;
    }

    public static File createFolder(Context context, String str) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!TextUtils.isEmpty(str)) {
            absolutePath = absolutePath + File.separator + str;
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String createInnerCacheStorage(Application application, String str, String str2) {
        if (application.getFilesDir() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(application.getCacheDir().getAbsolutePath());
            if (!TextUtils.isEmpty(str)) {
                sb.append(File.separator);
                sb.append(str);
            }
            sb.append(File.separator);
            sb.append(str2);
            String sb2 = sb.toString();
            TaoLog.d(TAG, "createInnerCacheStorage path:" + sb2);
            return sb2;
        }
        return "";
    }

    public static String createInnerfileStorage(Application application, String str, String str2) {
        if (application.getFilesDir() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(application.getFilesDir().getAbsolutePath());
            if (!TextUtils.isEmpty(str)) {
                sb.append(File.separator);
                sb.append(str);
            }
            sb.append(File.separator);
            sb.append(str2);
            String sb2 = sb.toString();
            TaoLog.d(TAG, "createInnerfileStorage path:" + sb2);
            return sb2;
        }
        return "";
    }

    private static String formatUrl(String str) {
        String replaceAll = str.replaceAll(WVUtils.URL_SEPARATOR, "/");
        return replaceAll.endsWith("/") ? replaceAll.substring(0, replaceAll.length() - 1) : replaceAll;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x024c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String unZipByFilePath(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.file.FileManager.unZipByFilePath(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean unzip(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return unzip(new FileInputStream(str), str2);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean copy(File file, File file2) {
        return copy(file, file2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r6.length < 10) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copy(java.io.File r4, java.io.File r5, byte[] r6) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r4.exists()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            if (r2 != 0) goto L2a
            boolean r5 = android.taobao.windvane.util.TaoLog.getLogStatus()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            if (r5 == 0) goto L29
            java.lang.String r5 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            r6.<init>()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            java.lang.String r2 = "src file not exist, "
            r6.append(r2)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            java.io.File r4 = r4.getAbsoluteFile()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            r6.append(r4)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            android.taobao.windvane.util.TaoLog.w(r5, r4)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
        L29:
            return r1
        L2a:
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            if (r2 != 0) goto L33
            r5.createNewFile()     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
        L33:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7f
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L78
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L78
            if (r6 == 0) goto L44
            int r5 = r6.length     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6e
            r0 = 10
            if (r5 >= r0) goto L48
        L44:
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r5]     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6e
        L48:
            int r5 = r2.read(r6)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6e
            r0 = -1
            if (r5 == r0) goto L53
            r4.write(r6, r1, r5)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6e
            goto L48
        L53:
            r4.flush()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6e
            r5 = 1
            r2.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r6 = move-exception
            r6.printStackTrace()
        L5f:
            r4.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r4 = move-exception
            r4.printStackTrace()
        L67:
            return r5
        L68:
            r5 = move-exception
            r0 = r2
            r3 = r5
            r5 = r4
            r4 = r3
            goto L9a
        L6e:
            r5 = move-exception
            r0 = r2
            r3 = r5
            r5 = r4
            r4 = r3
            goto L81
        L74:
            r4 = move-exception
            r5 = r0
            r0 = r2
            goto L9a
        L78:
            r4 = move-exception
            r5 = r0
            r0 = r2
            goto L81
        L7c:
            r4 = move-exception
            r5 = r0
            goto L9a
        L7f:
            r4 = move-exception
            r5 = r0
        L81:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L8e
            r0.close()     // Catch: java.io.IOException -> L8a
            goto L8e
        L8a:
            r4 = move-exception
            r4.printStackTrace()
        L8e:
            if (r5 == 0) goto L98
            r5.close()     // Catch: java.io.IOException -> L94
            goto L98
        L94:
            r4 = move-exception
            r4.printStackTrace()
        L98:
            return r1
        L99:
            r4 = move-exception
        L9a:
            if (r0 == 0) goto La4
            r0.close()     // Catch: java.io.IOException -> La0
            goto La4
        La0:
            r6 = move-exception
            r6.printStackTrace()
        La4:
            if (r5 == 0) goto Lae
            r5.close()     // Catch: java.io.IOException -> Laa
            goto Lae
        Laa:
            r5 = move-exception
            r5.printStackTrace()
        Lae:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.file.FileManager.copy(java.io.File, java.io.File, byte[]):boolean");
    }

    public static boolean unzip(byte[] bArr, String str) {
        return unzip(new ByteArrayInputStream(bArr), str);
    }

    public static boolean unzip(InputStream inputStream, String str) {
        ZipInputStream zipInputStream;
        if (inputStream == null || str == null) {
            return false;
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        FileOutputStream fileOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(inputStream);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    StringBuffer stringBuffer = new StringBuffer(200);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        stringBuffer.append(nextEntry.getName());
                        if (!stringBuffer.toString().contains("../")) {
                            File file = new File(str + stringBuffer.toString());
                            stringBuffer.delete(0, stringBuffer.length());
                            if (nextEntry.isDirectory()) {
                                file.mkdirs();
                            } else {
                                if (!file.getParentFile().exists()) {
                                    file.getParentFile().mkdirs();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr, 0, 1024);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, read);
                                    } catch (Exception e) {
                                        e = e;
                                        fileOutputStream = fileOutputStream2;
                                        TaoLog.e(TAG, "unzip: IOException:" + e.getMessage());
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e2) {
                                                TaoLog.e(TAG, "close Stream Exception:" + e2.getMessage());
                                                return false;
                                            }
                                        }
                                        if (zipInputStream != null) {
                                            zipInputStream.close();
                                        }
                                        inputStream.close();
                                        return false;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e3) {
                                                TaoLog.e(TAG, "close Stream Exception:" + e3.getMessage());
                                                throw th;
                                            }
                                        }
                                        if (zipInputStream != null) {
                                            zipInputStream.close();
                                        }
                                        inputStream.close();
                                        throw th;
                                    }
                                }
                                fileOutputStream2.close();
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            TaoLog.e(TAG, "close Stream Exception:" + e4.getMessage());
                        }
                    }
                    zipInputStream.close();
                    inputStream.close();
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            zipInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
        }
    }
}
