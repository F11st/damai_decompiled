package com.ali.ha.fulltrace;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.ali.ha.fulltrace.a */
/* loaded from: classes17.dex */
public class C2940a {
    public static void a(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static String b(Context context, String str) {
        return d(context, str, true);
    }

    public static String c(Context context, String str) {
        File dir = context.getDir("fulltrace", 0);
        if (dir == null) {
            return "";
        }
        File file = new File(dir.getAbsolutePath(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static String d(Context context, String str, boolean z) {
        if (str == null) {
            str = "";
        }
        File file = null;
        try {
            File externalCacheDir = z ? context.getExternalCacheDir() : context.getExternalFilesDir(null);
            if (externalCacheDir != null) {
                file = new File(externalCacheDir, "fulltrace/" + str);
            }
        } catch (Throwable unused) {
        }
        if (file == null) {
            File cacheDir = z ? context.getCacheDir() : context.getFilesDir();
            file = new File(cacheDir, "fulltrace/" + str);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static byte[] e(File file) throws IOException {
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
