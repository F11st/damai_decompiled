package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
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
public final class ca {
    public static final String a = bw.c("SYmFja3Vwcw");
    public static final String b = bw.c("SLmFkaXU");
    public static final String c = bw.c("JIw");

    public static synchronized void a(Context context, String str, String str2) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        synchronized (ca.class) {
            if (Build.VERSION.SDK_INT >= 19 && (context == null || context.checkCallingOrSelfPermission(bw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX0VYVEVSTkFMX1NUT1JBR0U=")) != 0 || context.checkCallingOrSelfPermission(bw.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ==")) != 0)) {
                return;
            }
            String a2 = a(context);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            String str3 = str + c + str2;
            File file = new File(a2 + File.separator + a);
            File file2 = new File(file, b);
            FileLock fileLock = null;
            try {
                if (!file.exists() || file.isDirectory()) {
                    file.mkdirs();
                }
                file2.createNewFile();
                randomAccessFile = new RandomAccessFile(file2, "rws");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        fileLock = fileChannel.tryLock();
                        if (fileLock != null) {
                            fileChannel.write(ByteBuffer.wrap(str3.getBytes("UTF-8")));
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            fileChannel.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable unused4) {
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable unused7) {
                            }
                        }
                    }
                } catch (Throwable unused8) {
                    fileChannel = null;
                }
            } catch (Throwable unused9) {
                fileChannel = null;
                randomAccessFile = null;
            }
        }
    }

    private static String a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && (context.getApplicationInfo().targetSdkVersion < 30 || i < 30)) {
            StorageManager storageManager = i >= 9 ? (StorageManager) context.getSystemService("storage") : null;
            try {
                Class<?> cls = Class.forName(bw.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
                Method method = storageManager.getClass().getMethod(bw.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
                Method method2 = cls.getMethod(bw.c("ZZ2V0UGF0aA"), new Class[0]);
                Method method3 = cls.getMethod(bw.c("AaXNSZW1vdmFibGUK"), new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = Array.get(invoke, i2);
                    String str = (String) method2.invoke(obj, new Object[0]);
                    if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                        return str;
                    }
                }
                return null;
            } catch (Throwable unused) {
                return Environment.getExternalStorageDirectory().getAbsolutePath();
            }
        }
        return context.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
    }
}
