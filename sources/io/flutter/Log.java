package io.flutter;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Log {
    public static int ASSERT = 7;
    public static int DEBUG = 3;
    public static int ERROR = 6;
    public static int INFO = 4;
    public static int VERBOSE = 2;
    public static int WARN = 5;
    private static int logLevel = 3;

    public static void d(@NonNull String str, @NonNull String str2) {
    }

    public static void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        android.util.Log.e(str, str2);
    }

    public static void i(@NonNull String str, @NonNull String str2) {
    }

    public static void i(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public static void println(@NonNull int i, @NonNull String str, @NonNull String str2) {
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void v(@NonNull String str, @NonNull String str2) {
    }

    public static void v(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        android.util.Log.w(str, str2);
    }

    public static void wtf(@NonNull String str, @NonNull String str2) {
        android.util.Log.wtf(str, str2);
    }

    public static void e(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        android.util.Log.e(str, str2, th);
    }

    public static void w(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        android.util.Log.w(str, str2, th);
    }

    public static void wtf(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        android.util.Log.wtf(str, str2, th);
    }
}
