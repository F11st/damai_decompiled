package com.alipay.android.phone.mobilesdk.socketcraft.platform;

import com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat.AndroidSCLogCatImpl;
import com.alipay.android.phone.mobilesdk.socketcraft.integrated.logcat.MPaaSSCLogCatImpl;
import com.alipay.android.phone.mobilesdk.socketcraft.integrated.monitor.MPaaSMonitorPrinter;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.JavaSCLogCatImpl;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatInterface;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinter;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class PlatformUtil {
    private static final Logger a = Logger.getLogger(PlatformUtil.class.getName());
    private static Class b = null;
    private static Class c = null;

    static {
        Logger.getLogger("com.alipay.android.phone.mobilesdk.socketcraft").setLevel(Level.ALL);
    }

    public static final SCLogCatInterface createAndroidLogImpl() {
        try {
            a.info("enter SCLogCatInterface");
            return (SCLogCatInterface) AndroidSCLogCatImpl.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final SCLogCatInterface createAndroidMPaaSLogImpl() {
        try {
            a.info("enter createAndroidMPaaSLogImpl");
            return (SCLogCatInterface) MPaaSSCLogCatImpl.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final SCLogCatInterface createJavaLogImpl() {
        try {
            a.info("enter createJavaLogImpl");
            return (SCLogCatInterface) JavaSCLogCatImpl.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final MonitorPrinter createMPaaSMonitorPrinter() {
        try {
            a.info("enter createMPaaSMonitorPrinter");
            return (MonitorPrinter) MPaaSMonitorPrinter.class.newInstance();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static final boolean isAndroidMPaaSPlatform() {
        if (isAndroidPlatform()) {
            if (c != null) {
                return true;
            }
            a.info("enter isAndroidMPaaSPlatform");
            try {
                c = Class.forName("com.alipay.mobile.common.transport.utils.LogCatUtil");
                return true;
            } catch (Throwable th) {
                a.log(Level.SEVERE, "isAndroidMPaaSPlatform err", th);
                return false;
            }
        }
        return false;
    }

    public static final boolean isAndroidPlatform() {
        Class<?> cls;
        if (b != null) {
            return true;
        }
        a.info("enter isAndroidPlatform");
        try {
            cls = Class.forName("android.os.Build$VERSION");
        } catch (Throwable th) {
            a.log(Level.INFO, String.format("isAndroidPlatform err: %s", th.getMessage()));
        }
        return ((Integer) cls.getField("SDK_INT").get(cls)).intValue() > 0;
    }
}
