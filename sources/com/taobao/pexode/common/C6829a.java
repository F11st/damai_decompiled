package com.taobao.pexode.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* renamed from: com.taobao.pexode.common.a */
/* loaded from: classes11.dex */
public class C6829a {
    static Context a;

    public static void a(Context context) {
        a = context;
    }

    public static boolean b(String str, int i) {
        boolean z;
        String c = c(str, i);
        File file = new File(c);
        if (file.exists()) {
            try {
                System.load(c);
                z = true;
            } catch (Throwable unused) {
                file.delete();
            }
            if (!z || NdkCore.a(DeviceUtils.ABI_MIPS) || NdkCore.a(DeviceUtils.ABI_X86)) {
                return z;
            }
            try {
                return d(str, i);
            } catch (IOException e) {
                e.printStackTrace();
                return z;
            }
        }
        z = false;
        return z ? z : z;
    }

    static String c(String str, int i) {
        String path;
        Context context = a;
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            path = "/data/data/" + a.getPackageName() + "/files";
        } else {
            path = filesDir.getPath();
        }
        return path + "/lib" + str + "_bk_" + i + ".so";
    }

    static boolean d(String str, int i) throws IOException {
        FileOutputStream fileOutputStream;
        if (a == null) {
            return false;
        }
        String str2 = "lib/armeabi/lib" + str + ".so";
        String c = c(str, i);
        ApplicationInfo applicationInfo = a.getApplicationInfo();
        ZipFile zipFile = new ZipFile(applicationInfo != null ? applicationInfo.sourceDir : "");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (nextElement.getName().startsWith(str2)) {
                InputStream inputStream = null;
                try {
                    File file = new File(c);
                    if (file.exists()) {
                        file.delete();
                    }
                    InputStream inputStream2 = zipFile.getInputStream(nextElement);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        int i2 = 0;
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                                i2 += read;
                            } else {
                                try {
                                    break;
                                } catch (Exception unused) {
                                }
                            }
                        }
                        inputStream2.close();
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            zipFile.close();
                        } catch (Exception unused3) {
                        }
                        if (i2 > 0) {
                            try {
                                System.load(c);
                                return true;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        try {
                            zipFile.close();
                        } catch (Exception unused6) {
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            }
        }
        return false;
    }
}
