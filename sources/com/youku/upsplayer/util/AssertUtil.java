package com.youku.upsplayer.util;

import android.content.Context;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AssertUtil {
    private static final String EMPTY_ASSERT_MESSAGE = "[empty]";
    private static boolean mAllowCrash = false;
    private static boolean mDebugMode = false;
    public static boolean mInited = false;
    private static int upsInterfaceVersion = 1;

    public static void assertTrue(boolean z) {
        if (z) {
            return;
        }
        logic_fail(EMPTY_ASSERT_MESSAGE);
    }

    public static void assertTrue(boolean z, String str) {
        if (z) {
            return;
        }
        logic_fail(str);
    }

    public static void assertUpsV1() {
        assertTrue(upsInterfaceVersion == 1);
    }

    public static String getCaller(int i) {
        while (true) {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[i + 2];
            if (!stackTraceElement.getMethodName().contains("$")) {
                return jn1.ARRAY_START_STR + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ":" + stackTraceElement.getMethodName() + jn1.ARRAY_END_STR;
            }
            i++;
        }
    }

    public static boolean isAllowCrash() {
        return mAllowCrash;
    }

    public static boolean isApkDebuggable(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebugMode() {
        return mDebugMode;
    }

    private static void logic_fail(String str) {
        String str2 = "failed in " + getCaller(1) + ", msg: " + str;
        if (!mAllowCrash) {
            str2 = str2 + "(will NOT crash)";
        }
        Logger.e("", str2, new Exception(str2));
        if (mAllowCrash) {
            throw new RuntimeException(str2);
        }
    }

    public static void setAllowCrash(boolean z) {
        mInited = true;
        mAllowCrash = z;
        mDebugMode = z;
    }

    public static void setUpsInterfaceVersion(int i) {
        upsInterfaceVersion = i;
    }
}
