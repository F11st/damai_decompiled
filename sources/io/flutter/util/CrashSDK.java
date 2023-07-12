package io.flutter.util;

import android.os.Bundle;
import com.uc.crashsdk.export.CrashApi;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CrashSDK {
    public static final int LOG_TYPE_JAVA = 16;
    public static final int LOG_TYPE_NATIVE = 1;
    public static final int LOG_TYPE_UNEXP = 256;
    private static volatile Method sAddDumpFileMethod;
    private static volatile Method sAddHeaderInfoMethod;
    private static Object sCrashApi;
    private static volatile Method sGenerateCustomLog;
    private static volatile boolean sHasReflected;

    private static void ReflectOnce() {
        if (sHasReflected) {
            return;
        }
        try {
            synchronized (CrashSDK.class) {
                if (sHasReflected) {
                    return;
                }
                int i = CrashApi.e;
                Method declaredMethod = CrashApi.class.getDeclaredMethod("getInstance", new Class[0]);
                declaredMethod.setAccessible(true);
                sCrashApi = declaredMethod.invoke(null, new Object[0]);
                sAddHeaderInfoMethod = CrashApi.class.getDeclaredMethod("addHeaderInfo", String.class, String.class);
                sAddHeaderInfoMethod.setAccessible(true);
                sGenerateCustomLog = CrashApi.class.getDeclaredMethod("generateCustomLog", StringBuffer.class, String.class, Bundle.class);
                sAddDumpFileMethod = CrashApi.class.getDeclaredMethod("addDumpFile", String.class, String.class, Integer.TYPE, Bundle.class);
                sHasReflected = true;
            }
        } catch (Throwable th) {
            sHasReflected = true;
            th.printStackTrace();
        }
    }

    public static void addDumpFile(String str, String str2, int i, Bundle bundle) {
        ReflectOnce();
        if (sAddDumpFileMethod == null) {
            return;
        }
        try {
            sAddDumpFileMethod.invoke(sCrashApi, str, str2, Integer.valueOf(i), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void addHeaderInfo(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        ReflectOnce();
        if (sAddHeaderInfoMethod == null) {
            return;
        }
        try {
            sAddHeaderInfoMethod.invoke(sCrashApi, str, str2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        ReflectOnce();
        if (sGenerateCustomLog == null) {
            return;
        }
        try {
            sGenerateCustomLog.invoke(sCrashApi, stringBuffer, str, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
