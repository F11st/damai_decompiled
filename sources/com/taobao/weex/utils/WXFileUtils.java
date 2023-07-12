package com.taobao.weex.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXFileUtils {
    public static String base64Md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            return base64Md5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void closeIo(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        Exception e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                fileOutputStream = new FileOutputStream(file2);
                while (fileInputStream.read(bArr) != -1) {
                    try {
                        fileOutputStream.write(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        WXLogUtils.e("copyFile " + e.getMessage() + ": " + file.getAbsolutePath() + ": " + file2.getAbsolutePath());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception e5) {
                fileOutputStream = null;
                e = e5;
            }
        } catch (Exception e6) {
            fileOutputStream = null;
            e = e6;
            fileInputStream = null;
        }
    }

    public static void copyFileWithException(File file, File file2) throws Exception {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                fileOutputStream = new FileOutputStream(file2);
                while (fileInputStream2.read(bArr) != -1) {
                    try {
                        fileOutputStream.write(bArr);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            closeIo(fileInputStream);
                            closeIo(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        closeIo(fileInputStream);
                        closeIo(fileOutputStream);
                        throw th;
                    }
                }
                closeIo(fileInputStream2);
                closeIo(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void extractSo(String str, String str2) throws IOException {
        ZipFile zipFile = new ZipFile(str);
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                if (!nextEntry.isDirectory()) {
                    String name = nextEntry.getName();
                    if (name.contains("lib/" + WXSoInstallMgrSdk._cpuType() + "/") && (nextEntry.getName().contains("weex") || nextEntry.getName().equals("libJavaScriptCore.so"))) {
                        String[] split = nextEntry.getName().split("/");
                        String str3 = split[split.length - 1];
                        InputStream inputStream = zipFile.getInputStream(nextEntry);
                        byte[] bArr = new byte[1024];
                        File file = new File(str2 + "/" + str3);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        while (inputStream.read(bArr) != -1) {
                            fileOutputStream.write(bArr);
                        }
                        fileOutputStream.close();
                    }
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
    }

    public static String loadAsset(String str, Context context) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return readStreamToString(context.getAssets().open(str));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String loadFileOrAsset(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                return readStreamToString(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return loadAsset(str, context);
    }

    public static String md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            return md5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static byte[] readBytesFromAssets(String str, Context context) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream open = context.getAssets().open(str);
                byte[] bArr = new byte[4096];
                int read = open.read(bArr);
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, 0, bArr2, 0, read);
                return bArr2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0061: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:38:0x0061 */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readStreamToString(java.io.InputStream r7) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "WXFileUtils loadAsset: "
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            int r4 = r7.available()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            int r4 = r4 + 10
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r2 = 4096(0x1000, float:5.74E-42)
            char[] r2 = new char[r2]     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L60
        L1e:
            int r5 = r4.read(r2)     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L60
            if (r5 <= 0) goto L29
            r6 = 0
            r3.append(r2, r6, r5)     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L60
            goto L1e
        L29:
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L60
            r4.close()     // Catch: java.io.IOException -> L31
            goto L35
        L31:
            r2 = move-exception
            com.taobao.weex.utils.WXLogUtils.e(r1, r2)
        L35:
            r7.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r7 = move-exception
            com.taobao.weex.utils.WXLogUtils.e(r1, r7)
        L3d:
            return r0
        L3e:
            r2 = move-exception
            goto L45
        L40:
            r0 = move-exception
            goto L62
        L42:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L45:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L60
            com.taobao.weex.utils.WXLogUtils.e(r0, r2)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L55
            r4.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r2 = move-exception
            com.taobao.weex.utils.WXLogUtils.e(r1, r2)
        L55:
            if (r7 == 0) goto L5f
            r7.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r7 = move-exception
            com.taobao.weex.utils.WXLogUtils.e(r1, r7)
        L5f:
            return r0
        L60:
            r0 = move-exception
            r2 = r4
        L62:
            if (r2 == 0) goto L6c
            r2.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r2 = move-exception
            com.taobao.weex.utils.WXLogUtils.e(r1, r2)
        L6c:
            if (r7 == 0) goto L76
            r7.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r7 = move-exception
            com.taobao.weex.utils.WXLogUtils.e(r1, r7)
        L76:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.utils.WXFileUtils.readStreamToString(java.io.InputStream):java.lang.String");
    }

    public static boolean saveFile(String str, byte[] bArr, Context context) {
        if (TextUtils.isEmpty(str) || bArr == null || context == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    WXLogUtils.e("WXFileUtils saveFile: " + WXLogUtils.getStackTrace(e));
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String base64Md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
