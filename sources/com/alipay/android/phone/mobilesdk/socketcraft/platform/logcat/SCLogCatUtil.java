package com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class SCLogCatUtil {
    private static SCLogCatInterface a() {
        return SCLogCatFactory.getSCLog();
    }

    public static final void debug(String str, String str2) {
        SCLogCatInterface a = a();
        a.debug("WS_" + str, str2);
    }

    public static final void error(String str, String str2) {
        SCLogCatInterface a = a();
        a.error("WS_" + str, str2);
    }

    public static final void info(String str, String str2) {
        SCLogCatInterface a = a();
        a.info("WS_" + str, str2);
    }

    public static final void printError(String str, Throwable th) {
        SCLogCatInterface a = a();
        a.printError("WS_" + str, th);
    }

    public static final void printInfo(String str, String str2) {
        SCLogCatInterface a = a();
        a.printInfo("WS_" + str, str2);
    }

    public static final void verbose(String str, String str2) {
        SCLogCatInterface a = a();
        a.verbose("WS_" + str, str2);
    }

    public static final void warn(String str, String str2) {
        SCLogCatInterface a = a();
        a.warn("WS_" + str, str2);
    }

    public static final void error(String str, Throwable th) {
        SCLogCatInterface a = a();
        a.error("WS_" + str, th);
    }

    public static final void warn(String str, Throwable th) {
        SCLogCatInterface a = a();
        a.warn("WS_" + str, th);
    }

    public static final void error(String str, String str2, Throwable th) {
        SCLogCatInterface a = a();
        a.error("WS_" + str, str2, th);
    }

    public static final void warn(String str, String str2, Throwable th) {
        SCLogCatInterface a = a();
        a.warn("WS_" + str, str2, th);
    }
}
