package com.youku.upsplayer.util;

import android.util.Log;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SystemUtils {
    private static final String TAG = "SystemUtils";
    private static Class<?> mClassType;
    private static Method mGetIntMethod;
    private static Method mGetMethod;
    private static Method mSetMethod;
    private static final String[] WIN_RUNTIME = {"cmd.exe", "/C"};
    private static final String[] OS_LINUX_RUNTIME = {"/bin/bash", "-l", "-c"};
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static long startTime = 0;
    private static long lastTime = 0;

    private static <T> T[] concat(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static String get(String str) {
        init();
        try {
            return (String) mGetMethod.invoke(mClassType, str);
        } catch (Exception unused) {
            Log.d(TAG, "get key " + str + " failed ");
            return null;
        }
    }

    public static int getInt(String str, int i) {
        init();
        try {
            return ((Integer) mGetIntMethod.invoke(mClassType, str, Integer.valueOf(i))).intValue();
        } catch (Exception unused) {
            Log.d(TAG, "get key " + str + " failed ");
            return i;
        }
    }

    private static void init() {
        try {
            if (mClassType == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                mClassType = cls;
                mGetMethod = cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
                mSetMethod = mClassType.getDeclaredMethod("set", String.class, String.class);
                mGetIntMethod = mClassType.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isUTExposure() {
        int i = getInt("debug.yingshi.config.utexposure", 1);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static boolean isUTSend() {
        int i = getInt("debug.yingshi.config.utsend", 1);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static boolean isUtDebugTurnOn() {
        int i = getInt("debug.yingshi.config.ut", 0);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static boolean isUtRealTimeTurnOn() {
        int i = getInt("debug.yingshi.config.utrealtime", 0);
        Log.d(TAG, "isUTSend: debug switch =" + i);
        return i > 0;
    }

    public static void printTime() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        long currentTimeMillis = System.currentTimeMillis();
        if (startTime == 0) {
            Log.d(TAG, "albertCurrentTime " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "行 start time:" + df.format(new Date(currentTimeMillis)));
            startTime = currentTimeMillis;
        } else {
            Log.d(TAG, "albertCurrentTime " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "行 time:" + (currentTimeMillis - lastTime) + " total:" + (currentTimeMillis - startTime));
        }
        lastTime = currentTimeMillis;
    }

    public static void printTimeClear() {
        startTime = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> runProcess(boolean r5, java.lang.String... r6) {
        /*
            java.lang.String r0 = "SystemUtils"
            java.lang.String r1 = "command to run: "
            android.util.Log.d(r0, r1)
            int r1 = r6.length
            r2 = 0
        L9:
            if (r2 >= r1) goto L13
            r3 = r6[r2]
            android.util.Log.d(r0, r3)
            int r2 = r2 + 1
            goto L9
        L13:
            java.lang.String r1 = "\n"
            android.util.Log.d(r0, r1)
            r1 = 0
            if (r5 == 0) goto L24
            java.lang.String[] r5 = com.youku.upsplayer.util.SystemUtils.WIN_RUNTIME     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.Object[] r5 = concat(r5, r6)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
        L21:
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            goto L2b
        L24:
            java.lang.String[] r5 = com.youku.upsplayer.util.SystemUtils.OS_LINUX_RUNTIME     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.Object[] r5 = concat(r5, r6)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            goto L21
        L2b:
            java.lang.ProcessBuilder r6 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r5 = 1
            r6.redirectErrorStream(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.lang.Process r5 = r6.start()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r5.waitFor()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8d
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r5.<init>()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
        L4e:
            java.lang.String r2 = r6.readLine()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            if (r2 == 0) goto L6c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r3.<init>()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            java.lang.String r4 = "temp line: "
            r3.append(r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r3.append(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            android.util.Log.d(r0, r3)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r5.add(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            goto L4e
        L6c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r2.<init>()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            java.lang.String r3 = "result after command: "
            r2.append(r3)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r2.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            android.util.Log.d(r0, r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> L9d
            r6.close()     // Catch: java.io.IOException -> L84
            goto L88
        L84:
            r6 = move-exception
            r6.printStackTrace()
        L88:
            return r5
        L89:
            r5 = move-exception
            goto L8f
        L8b:
            r5 = move-exception
            goto L9f
        L8d:
            r5 = move-exception
            r6 = r1
        L8f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L9d
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.io.IOException -> L98
            goto L9c
        L98:
            r5 = move-exception
            r5.printStackTrace()
        L9c:
            return r1
        L9d:
            r5 = move-exception
            r1 = r6
        L9f:
            if (r1 == 0) goto La9
            r1.close()     // Catch: java.io.IOException -> La5
            goto La9
        La5:
            r6 = move-exception
            r6.printStackTrace()
        La9:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.upsplayer.util.SystemUtils.runProcess(boolean, java.lang.String[]):java.util.List");
    }

    public static void set(String str, String str2) {
        init();
        try {
            mSetMethod.invoke(mClassType, str, str2);
        } catch (Exception unused) {
            Log.d(TAG, "set key " + str + " failed ");
        }
    }
}
