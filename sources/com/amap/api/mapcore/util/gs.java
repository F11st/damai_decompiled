package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gs {
    public static final String a = gn.c("SYmFja3Vwcw");
    public static final String b = gn.c("SLmFkaXU");
    public static final String c = gn.c("JIw");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static synchronized void a(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (gs.class) {
            String a2 = a(context, false);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            String str3 = str + c + str2;
            RandomAccessFile file = new File(a2 + File.separator + a);
            File file2 = new File((File) file, b);
            FileLock fileLock = null;
            try {
                try {
                    if (!file.exists() || file.isDirectory()) {
                        file.mkdirs();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rws");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                    } catch (Throwable unused) {
                        fileChannel = null;
                        file = randomAccessFile;
                    }
                } catch (Throwable unused2) {
                    fileChannel = null;
                    file = null;
                }
            } catch (IOException unused3) {
            }
            try {
                fileLock = fileChannel.tryLock();
                if (fileLock != null) {
                    fileChannel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused4) {
                    }
                }
                fileChannel.close();
                file = randomAccessFile;
            } catch (Throwable unused5) {
                file = randomAccessFile;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused6) {
                    }
                }
                if (fileChannel != null) {
                    fileChannel.close();
                    file = file;
                }
                a(file);
            }
            a(file);
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String a(Context context, boolean z) {
        StorageManager storageManager = Build.VERSION.SDK_INT >= 9 ? (StorageManager) context.getSystemService("storage") : null;
        try {
            Class<?> cls = Class.forName(gn.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(gn.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(gn.c("ZZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(gn.c("AaXNSZW1vdmFibGUK"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
    }
}
