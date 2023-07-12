package io.flutter.util;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class SourceLocation {
    private static final int stackIndex = 3;

    @NonNull
    public static String clazz(@NonNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NonNull
    public static String clazzFullyQualified(@NonNull Object obj) {
        return obj.getClass().getName();
    }

    @NonNull
    public static String file() {
        return Thread.currentThread().getStackTrace()[3].getFileName();
    }

    public static int line() {
        return Thread.currentThread().getStackTrace()[3].getLineNumber();
    }

    @NonNull
    public static String method() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }

    @NonNull
    public static String clazz() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return className.substring(className.lastIndexOf(46) + 1);
    }

    @NonNull
    public static String clazzFullyQualified() {
        return Thread.currentThread().getStackTrace()[3].getClassName();
    }
}
