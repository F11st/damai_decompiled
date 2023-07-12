package com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat;

import androidx.exifinterface.media.ExifInterface;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class JavaSCLogCatImpl implements SCLogCatInterface {
    private String b(String str, String str2) {
        return new Date().toLocaleString() + " " + Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + str2 + " " + str + " ";
    }

    private void c(String str, Throwable th) {
        if (th != null) {
            str = str + " " + a(th);
        }
        d(str);
    }

    private void d(String str) {
        try {
            Class<?> cls = Class.forName("java.lang.System");
            Object obj = cls.getField("out").get(cls);
            obj.getClass().getMethod("println", String.class).invoke(obj, str);
        } catch (Throwable unused) {
        }
    }

    protected String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.getClass().getMethod(String.format("%s%s%s", "print", "Stack", "Trace"), PrintWriter.class).invoke(th, printWriter);
            printWriter.flush();
        } catch (Throwable unused) {
        }
        return stringWriter.toString();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void debug(String str, String str2) {
        d(b(str, "D") + ":" + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2) {
        c(b(str, ExifInterface.LONGITUDE_EAST) + ":" + str2, null);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void info(String str, String str2) {
        d(b(str, "I") + ":" + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printError(String str, Throwable th) {
        error(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void printInfo(String str, String str2) {
        info(str, str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void verbose(String str, String str2) {
        d(b(str, "V") + ":" + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2) {
        d(b(str, ExifInterface.LONGITUDE_WEST) + ":" + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, Throwable th) {
        c(b(str, ExifInterface.LONGITUDE_EAST), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, Throwable th) {
        c(b(str, ExifInterface.LONGITUDE_WEST), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void error(String str, String str2, Throwable th) {
        c(b(str, ExifInterface.LONGITUDE_EAST) + ":" + str2, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface
    public void warn(String str, String str2, Throwable th) {
        c(b(str, ExifInterface.LONGITUDE_WEST) + ":" + str2, th);
    }
}
